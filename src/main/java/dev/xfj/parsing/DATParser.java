package dev.xfj.parsing;

import dev.xfj.format.dat.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DATParser extends Parser {
    private static int nameOffset;

    public DATParser(Path path) throws IOException {
        super(path);
    }

    public DATFile parse() {
        //Used for both DAT and DTT files
        DATFile datFile = new DATFile();

        datFile.setHeader(parseHeader());
        datFile.setFileInfo(IntStream.range(0, datFile.getHeader().getFileCount()).mapToObj(i -> parseFileInfo(i, datFile.getHeader().getFileTableOffset(), datFile.getHeader().getExtensionTableOffset(), datFile.getHeader().getNameTableOffset(), datFile.getHeader().getSizeTableOffset())).collect(Collectors.toList()));
        datFile.setContent(IntStream.range(0, datFile.getHeader().getFileCount()).mapToObj(i -> datFile.getFileInfo().get(i)).map(datContentInfo -> parseContent(datContentInfo.getFileOffset(), datContentInfo.getSize())).toList());
        datFile.setHashHeader(parseHashHeader(datFile.getHeader().getHashMapOffset()));

        return datFile;
    }

    public DATContentHeader parseHeader() {
        DATContentHeader datContentHeader = new DATContentHeader();
        datContentHeader.setMagicOne(getByte());
        datContentHeader.setMagicTwo(getByte());
        datContentHeader.setMagicThree(getByte());
        datContentHeader.setMagicFour(getByte());

        if (datContentHeader.getMagicOne() == 68 && datContentHeader.getMagicTwo() == 65 && datContentHeader.getMagicThree() == 84 && datContentHeader.getMagicFour() == 0) {
            datContentHeader.setFileCount(getInt32());
            datContentHeader.setFileTableOffset(getInt32());
            datContentHeader.setExtensionTableOffset(getInt32());
            datContentHeader.setNameTableOffset(getInt32());
            datContentHeader.setSizeTableOffset(getInt32());
            datContentHeader.setHashMapOffset(getInt32());
        } else {
            System.out.println("Invalid DAT file!");
            return null;
        }

        System.out.println(datContentHeader);

        return datContentHeader;
    }

    public DATContentInfo parseFileInfo(int index, int fileTableOffset, int extensionTableOffset, int nameTableOffset, int sizeTableOffset) {
        DATContentInfo datContentInfo = new DATContentInfo();

        setOffset(fileTableOffset + index * 4);
        datContentInfo.setFileOffset(getInt32());
        setOffset(extensionTableOffset + index * 4);
        datContentInfo.setExtension(getFixedString(4));
        setOffset(sizeTableOffset + index * 4);
        datContentInfo.setSize(getInt32());
        setOffset(nameTableOffset);

        datContentInfo.setFileNameAlignment(getByte());

        for (int x = 0; x < datContentInfo.getFileNameAlignment(); x++) {
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

        datContentInfo.setFileName(getFixedString(nameOffset, datContentInfo.getFileNameAlignment(), StandardCharsets.US_ASCII).split("\0")[0]);
        nameOffset = getOffset();

        System.out.println(datContentInfo);

        return datContentInfo;
    }

    public DATContent parseContent(int fileOffset, int size) {
        DATContent datContent = new DATContent();

        datContent.setContent(getSlice(fileOffset, size));

        return datContent;
    }

    public DATHashHeader parseHashHeader(int hashMapOffset) {
        DATHashHeader header = new DATHashHeader();

        setOffset(hashMapOffset);
        header.setPreHashShift(getInt32());
        header.setBucketOffsetsOffset(getInt32());
        header.setHashesOffset(getInt32());
        header.setFileIndicesOffset(getInt32());

        System.out.println(header);

        return header;
    }
}
