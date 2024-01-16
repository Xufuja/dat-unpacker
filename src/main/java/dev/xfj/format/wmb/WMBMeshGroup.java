package dev.xfj.format.wmb;

import java.util.List;

public class WMBMeshGroup {
    private int nameOffset;
    private List<Float> boundingBox;
    private int materialIndexArrayOffset;
    private int materialIndexArrayCount;
    private int boneIndexArrayOffset;
    private int boneIndexArrayCount;
    private String meshGroupname;
    private List<Short> materialIndexArray;
    private List<Short> boneIndexArray;

    public int getNameOffset() {
        return nameOffset;
    }

    public void setNameOffset(int nameOffset) {
        this.nameOffset = nameOffset;
    }

    public List<Float> getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(List<Float> boundingBox) {
        this.boundingBox = boundingBox;
    }

    public int getMaterialIndexArrayOffset() {
        return materialIndexArrayOffset;
    }

    public void setMaterialIndexArrayOffset(int materialIndexArrayOffset) {
        this.materialIndexArrayOffset = materialIndexArrayOffset;
    }

    public int getMaterialIndexArrayCount() {
        return materialIndexArrayCount;
    }

    public void setMaterialIndexArrayCount(int materialIndexArrayCount) {
        this.materialIndexArrayCount = materialIndexArrayCount;
    }

    public int getBoneIndexArrayOffset() {
        return boneIndexArrayOffset;
    }

    public void setBoneIndexArrayOffset(int boneIndexArrayOffset) {
        this.boneIndexArrayOffset = boneIndexArrayOffset;
    }

    public int getBoneIndexArrayCount() {
        return boneIndexArrayCount;
    }

    public void setBoneIndexArrayCount(int boneIndexArrayCount) {
        this.boneIndexArrayCount = boneIndexArrayCount;
    }

    public String getMeshGroupname() {
        return meshGroupname;
    }

    public void setMeshGroupname(String meshGroupname) {
        this.meshGroupname = meshGroupname;
    }

    public List<Short> getMaterialIndexArray() {
        return materialIndexArray;
    }

    public void setMaterialIndexArray(List<Short> materialIndexArray) {
        this.materialIndexArray = materialIndexArray;
    }

    public List<Short> getBoneIndexArray() {
        return boneIndexArray;
    }

    public void setBoneIndexArray(List<Short> boneIndexArray) {
        this.boneIndexArray = boneIndexArray;
    }

    @Override
    public String toString() {
        return "WMBMeshGroup{" +
                "nameOffset=" + nameOffset +
                ", boundingBox=" + boundingBox +
                ", materialIndexArrayOffset=" + materialIndexArrayOffset +
                ", materialIndexArrayCount=" + materialIndexArrayCount +
                ", boneIndexArrayOffset=" + boneIndexArrayOffset +
                ", boneIndexArrayCount=" + boneIndexArrayCount +
                ", meshGroupname='" + meshGroupname + '\'' +
                ", materialIndexArray=" + materialIndexArray +
                ", boneIndexArray=" + boneIndexArray +
                '}';
    }
}
