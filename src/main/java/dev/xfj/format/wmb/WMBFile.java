package dev.xfj.format.wmb;

import java.util.List;

public class WMBFile {
    private WMBHeader wmbHeader;
    private List<WMBBone> wmbBones;
    private List<WMBMaterial> wmbMaterials;

    public WMBHeader getWmbHeader() {
        return wmbHeader;
    }

    public void setWmbHeader(WMBHeader wmbHeader) {
        this.wmbHeader = wmbHeader;
    }

    public List<WMBBone> getWmbBones() {
        return wmbBones;
    }

    public void setWmbBones(List<WMBBone> wmbBones) {
        this.wmbBones = wmbBones;
    }

    public List<WMBMaterial> getWmbMaterials() {
        return wmbMaterials;
    }

    public void setWmbMaterials(List<WMBMaterial> wmbMaterials) {
        this.wmbMaterials = wmbMaterials;
    }
}
