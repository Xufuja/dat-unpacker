package dev.xfj.format.wmb;

public class WMBHeader {
    private String magicValue;
    private String version;
    private int unknown8;
    private int flags;
    private float boundingBox1;
    private float boundingBox2;
    private float boundingBox3;
    private float boundingBox4;
    private float boundingBox5;
    private float boundingBox6;
    private int boneArrayOffset;
    private int boneCount;
    private int offsetBoneIndexTranslationTable;
    private int boneIndexTranslationTableSize;
    private int vertexGroupArrayOffset;
    private int vertexGroupCount;
    private int meshArrayOffset;
    private int meshCount;
    private int meshGroupInfoArrayHeaderOffset;
    private int meshGroupInfoArrayCount;
    private int colTreeNodesOffset;
    private int colTreeNodesCount;
    private int boneMapOffset;
    private int boneMapCount;
    private int boneSetOffset;
    private int boneSetCount;
    private int materialArrayOffset;
    private int materialCount;
    private int meshGroupOffset;
    private int meshGroupCount;
    private int offsetMeshMaterials;
    private int numMeshMaterials;
    private int unknownWorldDataArrayOffset;
    private int unknownWorldDataArrayCount;
    private int unknown8C;

    public String getMagicValue() {
        return magicValue;
    }

    public void setMagicValue(String magicValue) {
        this.magicValue = magicValue;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getUnknown8() {
        return unknown8;
    }

    public void setUnknown8(int unknown8) {
        this.unknown8 = unknown8;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public float getBoundingBox1() {
        return boundingBox1;
    }

    public void setBoundingBox1(float boundingBox1) {
        this.boundingBox1 = boundingBox1;
    }

    public float getBoundingBox2() {
        return boundingBox2;
    }

    public void setBoundingBox2(float boundingBox2) {
        this.boundingBox2 = boundingBox2;
    }

    public float getBoundingBox3() {
        return boundingBox3;
    }

    public void setBoundingBox3(float boundingBox3) {
        this.boundingBox3 = boundingBox3;
    }

    public float getBoundingBox4() {
        return boundingBox4;
    }

    public void setBoundingBox4(float boundingBox4) {
        this.boundingBox4 = boundingBox4;
    }

    public float getBoundingBox5() {
        return boundingBox5;
    }

    public void setBoundingBox5(float boundingBox5) {
        this.boundingBox5 = boundingBox5;
    }

    public float getBoundingBox6() {
        return boundingBox6;
    }

    public void setBoundingBox6(float boundingBox6) {
        this.boundingBox6 = boundingBox6;
    }

    public int getBoneArrayOffset() {
        return boneArrayOffset;
    }

    public void setBoneArrayOffset(int boneArrayOffset) {
        this.boneArrayOffset = boneArrayOffset;
    }

    public int getBoneCount() {
        return boneCount;
    }

    public void setBoneCount(int boneCount) {
        this.boneCount = boneCount;
    }

    public int getOffsetBoneIndexTranslationTable() {
        return offsetBoneIndexTranslationTable;
    }

    public void setOffsetBoneIndexTranslationTable(int offsetBoneIndexTranslationTable) {
        this.offsetBoneIndexTranslationTable = offsetBoneIndexTranslationTable;
    }

    public int getBoneIndexTranslationTableSize() {
        return boneIndexTranslationTableSize;
    }

    public void setBoneIndexTranslationTableSize(int boneIndexTranslationTableSize) {
        this.boneIndexTranslationTableSize = boneIndexTranslationTableSize;
    }

    public int getVertexGroupArrayOffset() {
        return vertexGroupArrayOffset;
    }

    public void setVertexGroupArrayOffset(int vertexGroupArrayOffset) {
        this.vertexGroupArrayOffset = vertexGroupArrayOffset;
    }

    public int getVertexGroupCount() {
        return vertexGroupCount;
    }

    public void setVertexGroupCount(int vertexGroupCount) {
        this.vertexGroupCount = vertexGroupCount;
    }

    public int getMeshArrayOffset() {
        return meshArrayOffset;
    }

    public void setMeshArrayOffset(int meshArrayOffset) {
        this.meshArrayOffset = meshArrayOffset;
    }

    public int getMeshCount() {
        return meshCount;
    }

    public void setMeshCount(int meshCount) {
        this.meshCount = meshCount;
    }

    public int getMeshGroupInfoArrayHeaderOffset() {
        return meshGroupInfoArrayHeaderOffset;
    }

    public void setMeshGroupInfoArrayHeaderOffset(int meshGroupInfoArrayHeaderOffset) {
        this.meshGroupInfoArrayHeaderOffset = meshGroupInfoArrayHeaderOffset;
    }

    public int getMeshGroupInfoArrayCount() {
        return meshGroupInfoArrayCount;
    }

    public void setMeshGroupInfoArrayCount(int meshGroupInfoArrayCount) {
        this.meshGroupInfoArrayCount = meshGroupInfoArrayCount;
    }

    public int getColTreeNodesOffset() {
        return colTreeNodesOffset;
    }

    public void setColTreeNodesOffset(int colTreeNodesOffset) {
        this.colTreeNodesOffset = colTreeNodesOffset;
    }

    public int getColTreeNodesCount() {
        return colTreeNodesCount;
    }

    public void setColTreeNodesCount(int colTreeNodesCount) {
        this.colTreeNodesCount = colTreeNodesCount;
    }

    public int getBoneMapOffset() {
        return boneMapOffset;
    }

    public void setBoneMapOffset(int boneMapOffset) {
        this.boneMapOffset = boneMapOffset;
    }

    public int getBoneMapCount() {
        return boneMapCount;
    }

    public void setBoneMapCount(int boneMapCount) {
        this.boneMapCount = boneMapCount;
    }

    public int getBoneSetOffset() {
        return boneSetOffset;
    }

    public void setBoneSetOffset(int boneSetOffset) {
        this.boneSetOffset = boneSetOffset;
    }

    public int getBoneSetCount() {
        return boneSetCount;
    }

    public void setBoneSetCount(int boneSetCount) {
        this.boneSetCount = boneSetCount;
    }

    public int getMaterialArrayOffset() {
        return materialArrayOffset;
    }

    public void setMaterialArrayOffset(int materialArrayOffset) {
        this.materialArrayOffset = materialArrayOffset;
    }

    public int getMaterialCount() {
        return materialCount;
    }

    public void setMaterialCount(int materialCount) {
        this.materialCount = materialCount;
    }

    public int getMeshGroupOffset() {
        return meshGroupOffset;
    }

    public void setMeshGroupOffset(int meshGroupOffset) {
        this.meshGroupOffset = meshGroupOffset;
    }

    public int getMeshGroupCount() {
        return meshGroupCount;
    }

    public void setMeshGroupCount(int meshGroupCount) {
        this.meshGroupCount = meshGroupCount;
    }

    public int getOffsetMeshMaterials() {
        return offsetMeshMaterials;
    }

    public void setOffsetMeshMaterials(int offsetMeshMaterials) {
        this.offsetMeshMaterials = offsetMeshMaterials;
    }

    public int getNumMeshMaterials() {
        return numMeshMaterials;
    }

    public void setNumMeshMaterials(int numMeshMaterials) {
        this.numMeshMaterials = numMeshMaterials;
    }

    public int getUnknownWorldDataArrayOffset() {
        return unknownWorldDataArrayOffset;
    }

    public void setUnknownWorldDataArrayOffset(int unknownWorldDataArrayOffset) {
        this.unknownWorldDataArrayOffset = unknownWorldDataArrayOffset;
    }

    public int getUnknownWorldDataArrayCount() {
        return unknownWorldDataArrayCount;
    }

    public void setUnknownWorldDataArrayCount(int unknownWorldDataArrayCount) {
        this.unknownWorldDataArrayCount = unknownWorldDataArrayCount;
    }

    public int getUnknown8C() {
        return unknown8C;
    }

    public void setUnknown8C(int unknown8C) {
        this.unknown8C = unknown8C;
    }

    @Override
    public String toString() {
        return "WMBFile{" +
                "magicValue='" + magicValue + '\'' +
                ", version='" + version + '\'' +
                ", unknown8=" + unknown8 +
                ", flags=" + flags +
                ", boundingBox1=" + boundingBox1 +
                ", boundingBox2=" + boundingBox2 +
                ", boundingBox3=" + boundingBox3 +
                ", boundingBox4=" + boundingBox4 +
                ", boundingBox5=" + boundingBox5 +
                ", boundingBox6=" + boundingBox6 +
                ", boneArrayOffset=" + boneArrayOffset +
                ", boneCount=" + boneCount +
                ", offsetBoneIndexTranslationTable=" + offsetBoneIndexTranslationTable +
                ", boneIndexTranslationTableSize=" + boneIndexTranslationTableSize +
                ", vertexGroupArrayOffset=" + vertexGroupArrayOffset +
                ", vertexGroupCount=" + vertexGroupCount +
                ", meshArrayOffset=" + meshArrayOffset +
                ", meshCount=" + meshCount +
                ", meshGroupInfoArrayHeaderOffset=" + meshGroupInfoArrayHeaderOffset +
                ", meshGroupInfoArrayCount=" + meshGroupInfoArrayCount +
                ", colTreeNodesOffset=" + colTreeNodesOffset +
                ", colTreeNodesCount=" + colTreeNodesCount +
                ", boneMapOffset=" + boneMapOffset +
                ", boneMapCount=" + boneMapCount +
                ", boneSetOffset=" + boneSetOffset +
                ", boneSetCount=" + boneSetCount +
                ", materialArrayOffset=" + materialArrayOffset +
                ", materialCount=" + materialCount +
                ", meshGroupOffset=" + meshGroupOffset +
                ", meshGroupCount=" + meshGroupCount +
                ", offsetMeshMaterials=" + offsetMeshMaterials +
                ", numMeshMaterials=" + numMeshMaterials +
                ", unknownWorldDataArrayOffset=" + unknownWorldDataArrayOffset +
                ", unknownWorldDataArrayCount=" + unknownWorldDataArrayCount +
                ", unknown8C=" + unknown8C +
                '}';
    }
}
