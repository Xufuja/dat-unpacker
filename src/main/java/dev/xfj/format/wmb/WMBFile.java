package dev.xfj.format.wmb;

import dev.xfj.format.File;

import java.util.List;

public class WMBFile implements File {
    private WMBHeader wmbHeader;
    private List<WMBBone> wmbBones;
    private List<WMBMeshGroupInfo> wmbMeshGroupInformation;
    private List<WMBMeshGroup> wmbMeshGroups;
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

    public List<WMBMeshGroupInfo> getWmbMeshGroupInformation() {
        return wmbMeshGroupInformation;
    }

    public void setWmbMeshGroupInformation(List<WMBMeshGroupInfo> wmbMeshGroupInformation) {
        this.wmbMeshGroupInformation = wmbMeshGroupInformation;
    }

    public List<WMBMeshGroup> getWmbMeshGroups() {
        return wmbMeshGroups;
    }

    public void setWmbMeshGroups(List<WMBMeshGroup> wmbMeshGroups) {
        this.wmbMeshGroups = wmbMeshGroups;
    }

    public List<WMBMaterial> getWmbMaterials() {
        return wmbMaterials;
    }

    public void setWmbMaterials(List<WMBMaterial> wmbMaterials) {
        this.wmbMaterials = wmbMaterials;
    }
}
