package dev.xfj.format.wta;

import java.util.List;

public class WTAFile {
    private String magicValue;
    private int unknown4;
    private int textureCount;
    private int textureOffsetArrayOffset;
    private int textureSizeArrayOffset;
    private int unknownArrayOffset1;
    private int textureIdentifierArrayOffset;
    private int unknownArrayOffset2;
    private List<WTATextureData> textureDataList;
    private List<Integer> unknownArray2;

    public String getMagicValue() {
        return magicValue;
    }

    public void setMagicValue(String magicValue) {
        this.magicValue = magicValue;
    }

    public int getUnknown4() {
        return unknown4;
    }

    public void setUnknown4(int unknown4) {
        this.unknown4 = unknown4;
    }

    public int getTextureCount() {
        return textureCount;
    }

    public void setTextureCount(int textureCount) {
        this.textureCount = textureCount;
    }

    public int getTextureOffsetArrayOffset() {
        return textureOffsetArrayOffset;
    }

    public void setTextureOffsetArrayOffset(int textureOffsetArrayOffset) {
        this.textureOffsetArrayOffset = textureOffsetArrayOffset;
    }

    public int getTextureSizeArrayOffset() {
        return textureSizeArrayOffset;
    }

    public void setTextureSizeArrayOffset(int textureSizeArrayOffset) {
        this.textureSizeArrayOffset = textureSizeArrayOffset;
    }

    public int getUnknownArrayOffset1() {
        return unknownArrayOffset1;
    }

    public void setUnknownArrayOffset1(int unknownArrayOffset1) {
        this.unknownArrayOffset1 = unknownArrayOffset1;
    }

    public int getTextureIdentifierArrayOffset() {
        return textureIdentifierArrayOffset;
    }

    public void setTextureIdentifierArrayOffset(int textureIdentifierArrayOffset) {
        this.textureIdentifierArrayOffset = textureIdentifierArrayOffset;
    }

    public int getUnknownArrayOffset2() {
        return unknownArrayOffset2;
    }

    public void setUnknownArrayOffset2(int unknownArrayOffset2) {
        this.unknownArrayOffset2 = unknownArrayOffset2;
    }

    public List<WTATextureData> getTextureDataList() {
        return textureDataList;
    }

    public void setTextureDataList(List<WTATextureData> textureDataList) {
        this.textureDataList = textureDataList;
    }

    public List<Integer> getUnknownArray2() {
        return unknownArray2;
    }

    public void setUnknownArray2(List<Integer> unknownArray2) {
        this.unknownArray2 = unknownArray2;
    }
}
