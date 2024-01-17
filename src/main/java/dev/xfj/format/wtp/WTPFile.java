package dev.xfj.format.wtp;

import dev.xfj.format.File;

public class WTPFile implements File {
    private byte[] content;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
