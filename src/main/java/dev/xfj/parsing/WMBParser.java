package dev.xfj.parsing;

import dev.xfj.format.wmb.WMBBone;
import dev.xfj.format.wmb.WMBFile;
import dev.xfj.format.wmb.WMBHeader;
import dev.xfj.format.wmb.WMBMaterial;

import java.io.IOException;
import java.nio.file.Path;
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
        wmbFile.setWmbMaterials(IntStream.range(0, wmbFile.getWmbHeader().getMaterialCount()).mapToObj(i -> parseMaterial(i, wmbFile)).collect(Collectors.toList()));

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

    public WMBMaterial parseMaterial(int index, WMBFile wmbFile) {
        setOffset(wmbFile.getWmbHeader().getMaterialArrayOffset() + index * 0x30);

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

        for (int i = 0; i < wmbMaterial.getTextureNum(); i++) {
            setOffset(wmbMaterial.getTextureOffset() + i * 8);
            int offset = getInt32();
            System.out.println(offset);
            String identifier = String.format("%08x", getInt32());
            System.out.println(identifier);
            setOffset(offset);
            String textureTypeName = getFixedString(256);
            System.out.println(textureTypeName);

        }

        System.out.println(wmbMaterial);

        return wmbMaterial;
    }
}
