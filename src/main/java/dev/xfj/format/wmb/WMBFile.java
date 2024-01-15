package dev.xfj.format.wmb;

import java.util.List;

public class WMBFile {
    private WMBHeader wmbHeader;
    private List<WMBMaterial> wmbMaterials;

    public WMBHeader getWmbHeader() {
        return wmbHeader;
    }

    public void setWmbHeader(WMBHeader wmbHeader) {
        this.wmbHeader = wmbHeader;
    }

    public List<WMBMaterial> getWmbMaterials() {
        return wmbMaterials;
    }

    public void setWmbMaterials(List<WMBMaterial> wmbMaterials) {
        this.wmbMaterials = wmbMaterials;
    }
}
