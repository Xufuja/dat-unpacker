package dev.xfj.parsing;

import dev.xfj.format.wmb.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WMBParser extends Parser {
    public WMBParser(Path path) throws IOException {
        super(path);
    }

    public WMBFile parse() {
        WMBFile wmbFile = new WMBFile();
        wmbFile.setWmbHeader(parseHeader());
        setOffset(wmbFile.getWmbHeader().getBoneArrayOffset());
        wmbFile.setWmbBones(IntStream.range(0, wmbFile.getWmbHeader().getBoneCount()).mapToObj(bone -> parseBone()).collect(Collectors.toList()));
        wmbFile.setWmbMeshGroupInformation(IntStream.range(0, wmbFile.getWmbHeader().getMeshGroupInfoArrayCount()).mapToObj(i -> parseMeshGroupInfo(i, wmbFile.getWmbHeader().getMeshGroupInfoArrayHeaderOffset())).collect(Collectors.toList()));
        wmbFile.setWmbMeshGroups(IntStream.range(0, wmbFile.getWmbHeader().getMeshGroupCount()).mapToObj(i -> parseMeshGroup(i, wmbFile.getWmbHeader().getMeshGroupOffset())).collect(Collectors.toList()));
        wmbFile.setWmbMaterials(IntStream.range(0, wmbFile.getWmbHeader().getMaterialCount()).mapToObj(i -> parseMaterial(i, wmbFile.getWmbHeader().getMaterialArrayOffset())).collect(Collectors.toList()));

        return wmbFile;
    }

    public WMBHeader parseHeader() {
        WMBHeader wmbHeader = new WMBHeader();

        wmbHeader.setMagicValue(getFixedString(4));
        wmbHeader.setVersion(String.format("%08x", getInt32()));
        wmbHeader.setUnknown8(getInt32());
        wmbHeader.setFlags(getInt32());
        wmbHeader.setBoundingBox1(getFloat());
        wmbHeader.setBoundingBox2(getFloat());
        wmbHeader.setBoundingBox3(getFloat());
        wmbHeader.setBoundingBox4(getFloat());
        wmbHeader.setBoundingBox5(getFloat());
        wmbHeader.setBoundingBox6(getFloat());
        wmbHeader.setBoneArrayOffset(getInt32());
        wmbHeader.setBoneCount(getInt32());
        wmbHeader.setOffsetBoneIndexTranslationTable(getInt32());
        wmbHeader.setBoneIndexTranslationTableSize(getInt32());
        wmbHeader.setVertexGroupArrayOffset(getInt32());
        wmbHeader.setVertexGroupCount(getInt32());
        wmbHeader.setMeshArrayOffset(getInt32());
        wmbHeader.setMeshCount(getInt32());
        wmbHeader.setMeshGroupInfoArrayHeaderOffset(getInt32());
        wmbHeader.setMeshGroupInfoArrayCount(getInt32());
        wmbHeader.setColTreeNodesOffset(getInt32());
        wmbHeader.setColTreeNodesCount(getInt32());
        wmbHeader.setBoneMapOffset(getInt32());
        wmbHeader.setBoneMapCount(getInt32());
        wmbHeader.setBoneSetOffset(getInt32());
        wmbHeader.setBoneSetCount(getInt32());
        wmbHeader.setMaterialArrayOffset(getInt32());
        wmbHeader.setMaterialCount(getInt32());
        wmbHeader.setMeshGroupOffset(getInt32());
        wmbHeader.setMeshGroupCount(getInt32());
        wmbHeader.setOffsetMeshMaterials(getInt32());
        wmbHeader.setNumMeshMaterials(getInt32());
        wmbHeader.setUnknownWorldDataArrayOffset(getInt32());
        wmbHeader.setUnknownWorldDataArrayCount(getInt32());
        wmbHeader.setUnknown8C(getInt32());

        System.out.println(wmbHeader);

        return wmbHeader;
    }

    public WMBBone parseBone() {
        WMBBone wmbBone = new WMBBone();

        wmbBone.setBoneNumber(getInt16());
        wmbBone.setParentIndex(getInt16());
        wmbBone.setPositionX(getFloat());
        wmbBone.setPositionY(getFloat());
        wmbBone.setPositionZ(getFloat());
        wmbBone.setRotationX(getFloat());
        wmbBone.setRotationY(getFloat());
        wmbBone.setRotationZ(getFloat());
        wmbBone.setScaleX(getFloat());
        wmbBone.setScaleY(getFloat());
        wmbBone.setScaleZ(getFloat());
        wmbBone.setWorldPositionX(getFloat());
        wmbBone.setWorldPositionY(getFloat());
        wmbBone.setWorldPositionZ(getFloat());
        wmbBone.setWorldRotationX(getFloat());
        wmbBone.setWorldRotationY(getFloat());
        wmbBone.setWorldRotationZ(getFloat());
        wmbBone.setWorldScaleX(getFloat());
        wmbBone.setWorldScaleY(getFloat());
        wmbBone.setWorldScaleZ(getFloat());
        wmbBone.setWorldPositionTPoseX(getFloat());
        wmbBone.setWorldPositionTPoseY(getFloat());
        wmbBone.setWorldPositionTPoseZ(getFloat());

        System.out.println(wmbBone);

        return wmbBone;
    }

    public WMBMeshGroupInfo parseMeshGroupInfo(int index, int offset) {
        setOffset(offset + index * 0x14);

        WMBMeshGroupInfo wmbMeshGroupInfo = new WMBMeshGroupInfo();

        wmbMeshGroupInfo.setNameOffset(getInt32());
        wmbMeshGroupInfo.setLodLevel(getInt32());
        wmbMeshGroupInfo.setMeshStart(getInt32());
        wmbMeshGroupInfo.setMeshGroupInfoOffset(getInt32());
        wmbMeshGroupInfo.setMeshCount(getInt32());
        setOffset(wmbMeshGroupInfo.getNameOffset());
        wmbMeshGroupInfo.setMeshGroupInfoName(getFixedString(256));
        setOffset(wmbMeshGroupInfo.getMeshGroupInfoOffset());
        wmbMeshGroupInfo.setWmbGroupedMeshes(IntStream.range(0, wmbMeshGroupInfo.getMeshCount()).mapToObj(group -> parseGroupedMesh()).collect(Collectors.toList()));

        System.out.println(wmbMeshGroupInfo);

        return wmbMeshGroupInfo;
    }

    private WMBGroupedMesh parseGroupedMesh() {
        WMBGroupedMesh wmbGroupedMesh = new WMBGroupedMesh();

        wmbGroupedMesh.setVertexGroupIndex(getInt32());
        wmbGroupedMesh.setMeshGroupIndex(getInt32());
        wmbGroupedMesh.setMaterialIndex(getInt32());
        wmbGroupedMesh.setColTreeNodeIndex(getInt32());
        wmbGroupedMesh.setMeshGroupInfoMaterialPair(getInt32());
        wmbGroupedMesh.setUnknownWorldDataIndex(getInt32());

        return wmbGroupedMesh;
    }

    public WMBMeshGroup parseMeshGroup(int index, int offset) {
        setOffset(offset + index * 0x2c);

        WMBMeshGroup wmbMeshGroup = new WMBMeshGroup();

        wmbMeshGroup.setNameOffset(getInt32());
        wmbMeshGroup.setBoundingBox(IntStream.range(0, 6).mapToObj(group -> getFloat()).collect(Collectors.toList()));
        wmbMeshGroup.setMaterialIndexArrayOffset(getInt32());
        wmbMeshGroup.setMaterialIndexArrayCount(getInt32());
        wmbMeshGroup.setBoneIndexArrayOffset(getInt32());
        wmbMeshGroup.setBoneIndexArrayCount(getInt32());
        setOffset(wmbMeshGroup.getNameOffset());
        wmbMeshGroup.setMeshGroupname(getFixedString(256));
        setOffset(wmbMeshGroup.getMaterialIndexArrayOffset());
        wmbMeshGroup.setMaterialIndexArray(IntStream.range(0, wmbMeshGroup.getMaterialIndexArrayCount()).mapToObj(group -> getInt16()).collect(Collectors.toList()));
        setOffset(wmbMeshGroup.getBoneIndexArrayOffset());
        wmbMeshGroup.setBoneIndexArray(IntStream.range(0, wmbMeshGroup.getBoneIndexArrayCount()).mapToObj(group -> getInt16()).collect(Collectors.toList()));

        System.out.println(wmbMeshGroup);

        return wmbMeshGroup;
    }

    public WMBMaterial parseMaterial(int index, int offset) {
        setOffset(offset + index * 0x30);

        WMBMaterial wmbMaterial = new WMBMaterial();
        wmbMaterial.setUnknown1(getInt16());
        wmbMaterial.setUnknown2(getInt16());
        wmbMaterial.setUnknown3(getInt16());
        wmbMaterial.setUnknown4(getInt16());
        wmbMaterial.setMaterialNameOffset(getInt32());
        wmbMaterial.setEffectNameOffset(getInt32());
        wmbMaterial.setTechniqueNameOffset(getInt32());
        wmbMaterial.setUnknown5(getInt32());
        wmbMaterial.setTextureOffset(getInt32());
        wmbMaterial.setTextureNum(getInt32());
        wmbMaterial.setParameterGroupsOffset(getInt32());
        wmbMaterial.setNumParameterGroups(getInt32());
        wmbMaterial.setVarOffset(getInt32());
        wmbMaterial.setVarNum(getInt32());
        setOffset(wmbMaterial.getMaterialNameOffset());
        wmbMaterial.setMaterialName(getFixedString(256));
        setOffset(wmbMaterial.getEffectNameOffset());
        wmbMaterial.setEffectName(getFixedString(256));
        setOffset(wmbMaterial.getTechniqueNameOffset());
        wmbMaterial.setTechniqueName(getFixedString(256));

        Map<String, String> textureArray = new HashMap<>();
        for (int i = 0; i < wmbMaterial.getTextureNum(); i++) {
            setOffset(wmbMaterial.getTextureOffset() + i * 8);
            int textureOffset = getInt32();
            String identifier = String.format("%08x", getInt32());;
            setOffset(textureOffset);
            String textureTypeName = getFixedString(256);

            textureArray.put(textureTypeName, identifier);
        }

        wmbMaterial.setTextureArray(textureArray);

        System.out.println(wmbMaterial);

        return wmbMaterial;
    }
}
