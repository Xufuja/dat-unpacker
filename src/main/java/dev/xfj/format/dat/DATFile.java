package dev.xfj.format.dat;

import dev.xfj.format.File;

import java.util.List;

public class DATFile implements File {
    private DATContentHeader header;
    private List<DATContentInfo> fileInfo;
    private List<DATContent> content;
    private DATHashHeader hashHeader;

    public DATContentHeader getHeader() {
        return header;
    }

    public void setHeader(DATContentHeader header) {
        this.header = header;
    }

    public List<DATContentInfo> getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(List<DATContentInfo> fileInfo) {
        this.fileInfo = fileInfo;
    }

    public List<DATContent> getContent() {
        return content;
    }

    public void setContent(List<DATContent> content) {
        this.content = content;
    }

    public DATHashHeader getHashHeader() {
        return hashHeader;
    }

    public void setHashHeader(DATHashHeader hashHeader) {
        this.hashHeader = hashHeader;
    }
}
