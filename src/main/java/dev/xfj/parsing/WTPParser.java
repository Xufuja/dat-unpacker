package dev.xfj.parsing;

import dev.xfj.format.wtp.WTPFile;

import java.io.IOException;
import java.nio.file.Path;

public class WTPParser extends AbstractParser {
    private final int offset;
    private final int length;

    public WTPParser(Path path, int offset, int length) throws IOException {
        super(path);
        this.offset = offset;
        this.length = length;
    }


    public WTPFile parse() {
        WTPFile wtpFile = new WTPFile();

        wtpFile.setContent(getSlice(offset, length));

        return wtpFile;
    }
}
