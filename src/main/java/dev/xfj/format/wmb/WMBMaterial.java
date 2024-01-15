package dev.xfj.format.wmb;

public class WMBMaterial {
    private short unknown1;
    private short unknown2;
    private short unknown3;
    private short unknown4;
    private int materialNameOffset;
    private int effectNameOffset;
    private int techniqueNameOffset;
    private int unknown5;
    private int textureOffset;
    private int textureNum;
    private int parameterGroupsOffset;
    private int numParameterGroups;
    private int varOffset;
    private int varNum;
    private String materialName;
    private String effectName;
    private String techniqueName;

    public short getUnknown1() {
        return unknown1;
    }

    public void setUnknown1(short unknown1) {
        this.unknown1 = unknown1;
    }

    public short getUnknown2() {
        return unknown2;
    }

    public void setUnknown2(short unknown2) {
        this.unknown2 = unknown2;
    }

    public short getUnknown3() {
        return unknown3;
    }

    public void setUnknown3(short unknown3) {
        this.unknown3 = unknown3;
    }

    public short getUnknown4() {
        return unknown4;
    }

    public void setUnknown4(short unknown4) {
        this.unknown4 = unknown4;
    }

    public int getMaterialNameOffset() {
        return materialNameOffset;
    }

    public void setMaterialNameOffset(int materialNameOffset) {
        this.materialNameOffset = materialNameOffset;
    }

    public int getEffectNameOffset() {
        return effectNameOffset;
    }

    public void setEffectNameOffset(int effectNameOffset) {
        this.effectNameOffset = effectNameOffset;
    }

    public int getTechniqueNameOffset() {
        return techniqueNameOffset;
    }

    public void setTechniqueNameOffset(int techniqueNameOffset) {
        this.techniqueNameOffset = techniqueNameOffset;
    }

    public int getUnknown5() {
        return unknown5;
    }

    public void setUnknown5(int unknown5) {
        this.unknown5 = unknown5;
    }

    public int getTextureOffset() {
        return textureOffset;
    }

    public void setTextureOffset(int textureOffset) {
        this.textureOffset = textureOffset;
    }

    public int getTextureNum() {
        return textureNum;
    }

    public void setTextureNum(int textureNum) {
        this.textureNum = textureNum;
    }

    public int getParameterGroupsOffset() {
        return parameterGroupsOffset;
    }

    public void setParameterGroupsOffset(int parameterGroupsOffset) {
        this.parameterGroupsOffset = parameterGroupsOffset;
    }

    public int getNumParameterGroups() {
        return numParameterGroups;
    }

    public void setNumParameterGroups(int numParameterGroups) {
        this.numParameterGroups = numParameterGroups;
    }

    public int getVarOffset() {
        return varOffset;
    }

    public void setVarOffset(int varOffset) {
        this.varOffset = varOffset;
    }

    public int getVarNum() {
        return varNum;
    }

    public void setVarNum(int varNum) {
        this.varNum = varNum;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getEffectName() {
        return effectName;
    }

    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }

    public String getTechniqueName() {
        return techniqueName;
    }

    public void setTechniqueName(String techniqueName) {
        this.techniqueName = techniqueName;
    }

    @Override
    public String toString() {
        return "WMBMaterial{" +
                "unknown1=" + unknown1 +
                ", unknown2=" + unknown2 +
                ", unknown3=" + unknown3 +
                ", unknown4=" + unknown4 +
                ", materialNameOffset=" + materialNameOffset +
                ", effectNameOffset=" + effectNameOffset +
                ", techniqueNameOffset=" + techniqueNameOffset +
                ", unknown5=" + unknown5 +
                ", textureOffset=" + textureOffset +
                ", textureNum=" + textureNum +
                ", parameterGroupsOffset=" + parameterGroupsOffset +
                ", numParameterGroups=" + numParameterGroups +
                ", varOffset=" + varOffset +
                ", varNum=" + varNum +
                ", materialName='" + materialName + '\'' +
                ", effectName='" + effectName + '\'' +
                ", techniqueName='" + techniqueName + '\'' +
                '}';
    }
}
