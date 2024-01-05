package dev.xfj.format;

public class FileInfo {
    private int fileOffset;
    private String extension;
    private int size;
    private int fileNameAlignment;
    private String fileName;

    public int getFileOffset() {
        return fileOffset;
    }

    public void setFileOffset(int fileOffset) {
        this.fileOffset = fileOffset;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFileNameAlignment() {
        return fileNameAlignment;
    }

    public void setFileNameAlignment(int fileNameAlignment) {
        this.fileNameAlignment = fileNameAlignment;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileOffset=" + fileOffset +
                ", extension='" + extension + '\'' +
                ", size=" + size +
                ", fileNameAlignment=" + fileNameAlignment +
                ", fileName=" + fileName +
                '}';
    }
}
