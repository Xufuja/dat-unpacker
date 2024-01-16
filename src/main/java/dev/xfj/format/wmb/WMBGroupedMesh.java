package dev.xfj.format.wmb;

public class WMBGroupedMesh {
    private int vertexGroupIndex;
    private int meshGroupIndex;
    private int materialIndex;
    private int colTreeNodeIndex;
    private int meshGroupInfoMaterialPair;
    private int unknownWorldDataIndex;

    public int getVertexGroupIndex() {
        return vertexGroupIndex;
    }

    public void setVertexGroupIndex(int vertexGroupIndex) {
        this.vertexGroupIndex = vertexGroupIndex;
    }

    public int getMeshGroupIndex() {
        return meshGroupIndex;
    }

    public void setMeshGroupIndex(int meshGroupIndex) {
        this.meshGroupIndex = meshGroupIndex;
    }

    public int getMaterialIndex() {
        return materialIndex;
    }

    public void setMaterialIndex(int materialIndex) {
        this.materialIndex = materialIndex;
    }

    public int getColTreeNodeIndex() {
        return colTreeNodeIndex;
    }

    public void setColTreeNodeIndex(int colTreeNodeIndex) {
        this.colTreeNodeIndex = colTreeNodeIndex;

        if (colTreeNodeIndex == Integer.MAX_VALUE) {
            this.colTreeNodeIndex = -1;
        }
    }

    public int getMeshGroupInfoMaterialPair() {
        return meshGroupInfoMaterialPair;
    }

    public void setMeshGroupInfoMaterialPair(int meshGroupInfoMaterialPair) {
        this.meshGroupInfoMaterialPair = meshGroupInfoMaterialPair;
    }

    public int getUnknownWorldDataIndex() {
        return unknownWorldDataIndex;
    }

    public void setUnknownWorldDataIndex(int unknownWorldDataIndex) {
        this.unknownWorldDataIndex = unknownWorldDataIndex;

        if (unknownWorldDataIndex == Integer.MAX_VALUE) {
            this.unknownWorldDataIndex = -1;
        }
    }

    @Override
    public String toString() {
        return "WMBGroupedMesh{" +
                "vertexGroupIndex=" + vertexGroupIndex +
                ", meshGroupIndex=" + meshGroupIndex +
                ", materialIndex=" + materialIndex +
                ", colTreeNodeIndex=" + colTreeNodeIndex +
                ", meshGroupInfoMaterialPair=" + meshGroupInfoMaterialPair +
                ", unknownWorldDataIndex=" + unknownWorldDataIndex +
                '}';
    }
}
