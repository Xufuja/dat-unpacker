package dev.xfj.format.dat;

public class DATHashHeader {
    private int preHashShift;
    private int bucketOffsetsOffset;
    private int hashesOffset;
    private int fileIndicesOffset;

    public int getPreHashShift() {
        return preHashShift;
    }

    public void setPreHashShift(int preHashShift) {
        this.preHashShift = preHashShift;
    }

    public int getBucketOffsetsOffset() {
        return bucketOffsetsOffset;
    }

    public void setBucketOffsetsOffset(int bucketOffsetsOffset) {
        this.bucketOffsetsOffset = bucketOffsetsOffset;
    }

    public int getHashesOffset() {
        return hashesOffset;
    }

    public void setHashesOffset(int hashesOffset) {
        this.hashesOffset = hashesOffset;
    }

    public int getFileIndicesOffset() {
        return fileIndicesOffset;
    }

    public void setFileIndicesOffset(int fileIndicesOffset) {
        this.fileIndicesOffset = fileIndicesOffset;
    }

    @Override
    public String toString() {
        return "DATHashHeader{" +
                "preHashShift=" + preHashShift +
                ", bucketOffsetsOffset=" + bucketOffsetsOffset +
                ", hashesOffset=" + hashesOffset +
                ", fileIndicesOffset=" + fileIndicesOffset +
                '}';
    }
}
