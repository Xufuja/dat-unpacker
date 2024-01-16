package dev.xfj.format.wmb;

import java.util.List;

public class WMBMeshGroupInfo {
    private int nameOffset;
    private int lodLevel;
    private int meshStart;
    private int meshGroupInfoOffset;
    private int meshCount;
    private String meshGroupInfoName;
    private List<WMBGroupedMesh> wmbGroupedMeshes;

    public int getNameOffset() {
        return nameOffset;
    }

    public void setNameOffset(int nameOffset) {
        this.nameOffset = nameOffset;
    }

    public int getLodLevel() {
        return lodLevel;
    }

    public void setLodLevel(int lodLevel) {
        this.lodLevel = lodLevel;

        if (lodLevel == Integer.MAX_VALUE) {
            this.lodLevel = -1;
        }
    }

    public int getMeshStart() {
        return meshStart;
    }

    public void setMeshStart(int meshStart) {
        this.meshStart = meshStart;
    }

    public int getMeshGroupInfoOffset() {
        return meshGroupInfoOffset;
    }

    public void setMeshGroupInfoOffset(int meshGroupInfoOffset) {
        this.meshGroupInfoOffset = meshGroupInfoOffset;
    }

    public int getMeshCount() {
        return meshCount;
    }

    public void setMeshCount(int meshCount) {
        this.meshCount = meshCount;
    }

    public String getMeshGroupInfoName() {
        return meshGroupInfoName;
    }

    public void setMeshGroupInfoName(String meshGroupInfoName) {
        this.meshGroupInfoName = meshGroupInfoName;
    }

    public List<WMBGroupedMesh> getWmbGroupedMeshes() {
        return wmbGroupedMeshes;
    }

    public void setWmbGroupedMeshes(List<WMBGroupedMesh> wmbGroupedMeshes) {
        this.wmbGroupedMeshes = wmbGroupedMeshes;
    }
}
