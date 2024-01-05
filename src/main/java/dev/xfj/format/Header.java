package dev.xfj.format;

public class Header {
    private byte magicOne;
    private byte magicTwo;
    private byte magicThree;
    private byte magicFour;
    private int fileCount;
    private int fileTableOffset;
    private int extensionTableOffset;
    private int nameTableOffset;
    private int sizeTableOffset;
    private int hashMapOffset;

    public byte getMagicOne() {
        return magicOne;
    }

    public void setMagicOne(byte magicOne) {
        this.magicOne = magicOne;
    }

    public byte getMagicTwo() {
        return magicTwo;
    }

    public void setMagicTwo(byte magicTwo) {
        this.magicTwo = magicTwo;
    }

    public byte getMagicThree() {
        return magicThree;
    }

    public void setMagicThree(byte magicThree) {
        this.magicThree = magicThree;
    }

    public byte getMagicFour() {
        return magicFour;
    }

    public void setMagicFour(byte magicFour) {
        this.magicFour = magicFour;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public int getFileTableOffset() {
        return fileTableOffset;
    }

    public void setFileTableOffset(int fileTableOffset) {
        this.fileTableOffset = fileTableOffset;
    }

    public int getExtensionTableOffset() {
        return extensionTableOffset;
    }

    public void setExtensionTableOffset(int extensionTableOffset) {
        this.extensionTableOffset = extensionTableOffset;
    }

    public int getNameTableOffset() {
        return nameTableOffset;
    }

    public void setNameTableOffset(int nameTableOffset) {
        this.nameTableOffset = nameTableOffset;
    }

    public int getSizeTableOffset() {
        return sizeTableOffset;
    }

    public void setSizeTableOffset(int sizeTableOffset) {
        this.sizeTableOffset = sizeTableOffset;
    }

    public int getHashMapOffset() {
        return hashMapOffset;
    }

    public void setHashMapOffset(int hashMapOffset) {
        this.hashMapOffset = hashMapOffset;
    }

    @Override
    public String toString() {
        return "Header{" +
                "fileCount=" + fileCount +
                ", fileTableOffset=" + fileTableOffset +
                ", extensionTableOffset=" + extensionTableOffset +
                ", nameTableOffset=" + nameTableOffset +
                ", sizeTableOffset=" + sizeTableOffset +
                ", hashMapOffset=" + hashMapOffset +
                '}';
    }
}
