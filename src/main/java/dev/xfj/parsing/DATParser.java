package dev.xfj.parsing;

import dev.xfj.format.FileInfo;
import dev.xfj.format.Header;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class DATParser extends Parser {
    private final Path path;
    private Charset characterEncoding;
    private static int nameOffset;

    public DATParser(Path path) throws IOException {
        super(path);
        this.path = path;
        this.characterEncoding = StandardCharsets.UTF_8;
    }

    public void parse() {
        Header header = parseHeader();

        if (header != null) {
            Path directory = Path.of(path.toString().split(".dat")[0]);

            try {
                Files.walk(directory)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            } catch (Exception e) {
                //System.out.println(e.getMessage());
            }

            for (int i = 0; i < header.getFileCount(); i++) {
                FileInfo fileInfo = parseFileInfo(i, header.getFileTableOffset(), header.getExtensionTableOffset(), header.getNameTableOffset(), header.getSizeTableOffset());
                extractFile(directory, String.format("[%1$s] %2$s", fileInfo.getFileOffset(), fileInfo.getFileName()), fileInfo.getFileOffset(), fileInfo.getSize());
            }
        }
    }

    public Header parseHeader() {
        Header header = new Header();
        header.setMagicOne(getByte());
        header.setMagicTwo(getByte());
        header.setMagicThree(getByte());
        header.setMagicFour(getByte());

        if (header.getMagicOne() == 68 && header.getMagicTwo() == 65 && header.getMagicThree() == 84 && header.getMagicFour() == 0) {
            header.setFileCount(getInt32());
            header.setFileTableOffset(getInt32());
            header.setExtensionTableOffset(getInt32());
            header.setNameTableOffset(getInt32());
            header.setSizeTableOffset(getInt32());
            header.setHashMapOffset(getInt32());
        } else {
            System.out.println("Invalid DAT file!");
            return null;
        }

        System.out.println(header);

        return header;
    }

    public FileInfo parseFileInfo(int index, int fileTableOffset, int extensionTableOffset, int nameTableOffset, int sizeTableOffset) {
        FileInfo fileInfo = new FileInfo();

        setOffset(fileTableOffset + index * 4);
        fileInfo.setFileOffset(getInt32());
        setOffset(extensionTableOffset + index * 4);
        fileInfo.setExtension(getFixedString(4));
        setOffset(sizeTableOffset + index * 4);
        fileInfo.setSize(getInt32());
        setOffset(nameTableOffset);

        fileInfo.setFileNameAlignment(getByte());

        for (int x = 0; x < fileInfo.getFileNameAlignment(); x++) {
            byte temp = getByte();
            if (temp != 0) {
                offset = getOffset() - 1;
                break;
            }
        }

        if (index == 0) {
            nameOffset = getOffset();
        }

        setOffset(nameOffset);

        characterEncoding = StandardCharsets.US_ASCII;
        fileInfo.setFileName(getFixedString(nameOffset, fileInfo.getFileNameAlignment()).split("\0")[0]);
        nameOffset = getOffset();
        characterEncoding = StandardCharsets.UTF_8;

        System.out.println(fileInfo);
        return fileInfo;
    }

    public void extractFile(Path directory, String fileName, int fileOffset, int size) {
        byte[] array = getSlice(fileOffset, size);
        try {
            Files.createDirectories(directory);
            Files.write(Paths.get(String.valueOf(directory), fileName), array);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private String getFixedString(int start, int length) {
        int end = start + length;
        byte[] result = new byte[length];
        for (int i = start; i < end; i++) {
            int resultIndex = i - start;
            result[resultIndex] = bytes[i];
            //System.out.println(result[resultIndex]);
        }
        //System.out.println("End of Byte Range");
        offset += length;
        ByteBuffer buffer = ByteBuffer.wrap(result);
        return characterEncoding.decode(buffer).toString();
    }

    private String getFixedString(int length) {
        return getFixedString(offset, length);
    }
}
