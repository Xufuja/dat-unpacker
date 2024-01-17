package dev.xfj.extracting;

import dev.xfj.format.dat.DATContent;
import dev.xfj.format.dat.DATContentInfo;
import dev.xfj.format.wmb.WMBFile;
import dev.xfj.format.wmb.WMBMaterial;
import dev.xfj.format.wta.WTAFile;
import dev.xfj.format.wtp.WTPFile;
import dev.xfj.parsing.WTPParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WMBExtractor {
    private final WMBFile wmbFile;
    private final boolean dryRun;

    public WMBExtractor(WMBFile wmbFile, boolean dryRun) {
        this.wmbFile = wmbFile;
        this.dryRun = dryRun;
    }

    public void extract(Path directory, boolean delete) {
        directory = Path.of(directory.toString().split(".wtp")[0]);

        //if (delete) {
        //    try {
        //        Files.walk(directory)
        //                .sorted(Comparator.reverseOrder())
        //                .map(Path::toFile)
        //                .forEach(File::delete);
        //    } catch (Exception e) {
        //        //System.out.println(e.getMessage());
        //    }
        //}

        List<String> textureArray = new ArrayList<>();

        for (int i = 0; i < wmbFile.getWmbHeader().getMaterialCount(); i++) {
            WMBMaterial material = wmbFile.getWmbMaterials().get(i);
            String materialName = material.getMaterialName();

            if (material.getTextureArray().containsKey("g_AlbedoMap")) {
                String identifier = material.getTextureArray().get("g_AlbedoMap");
                String textureFile = Paths.get(directory.toString(), "texture", identifier).toString();
                textureArray.add(textureFile);
            }

            if (material.getTextureArray().containsKey("g_NormalMap")) {
                String identifier = material.getTextureArray().get("g_NormalMap");
                String textureFile = Paths.get(directory.toString(), "texture", identifier).toString();
                textureArray.add(textureFile);
            }
        }


        //for (int i = 0; i < datFile.getHeader().getFileCount(); i++) {
        //    DATContentInfo datContentInfo = datFile.getFileInfo().get(i);
        //    DATContent datContent = datFile.getContent().get(i);
//
        //    if (!dryRun) {
        //        extractFile(directory, datContent, String.format("[%1$s] %2$s", datContentInfo.getFileOffset(), datContentInfo.getFileName()));
        //    }
        //}
    }

    public void extractFile(Path directory, DATContent datContent, String fileName) {
        byte[] array = datContent.getContent();

        try {
            Files.createDirectories(directory);
            Files.write(Paths.get(String.valueOf(directory), fileName), array);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public byte[] getTextureByIndex(WTAFile wtaFile, int textureIndex, Path file) throws IOException {
        WTPParser wtpParser = new WTPParser(file, wtaFile.getTextureDataList().get(textureIndex).getWtaTextureOffset(), wtaFile.getTextureDataList().get(textureIndex).getWtaTextureSize());
        WTPFile wtpFile = wtpParser.parse();
        return wtpFile.getContent();
    }

    public byte[] getTextureByIdentifier(WTAFile wtaFile, String textureIdentifier, Path file) throws IOException {
        for (int i = 0; i < wtaFile.getTextureCount(); i++) {
            if (wtaFile.getTextureDataList().get(i).getWtaTextureIdentifier().equals(textureIdentifier)) {
                return getTextureByIndex(wtaFile, i, file);
            }
        }
        return new byte[0];
    }
}
