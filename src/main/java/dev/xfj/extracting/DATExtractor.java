package dev.xfj.extracting;

import dev.xfj.format.dat.DATContent;
import dev.xfj.format.dat.DATFile;
import dev.xfj.format.dat.DATContentInfo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class DATExtractor {
    private final DATFile datFile;
    private final boolean dryRun;

    public DATExtractor(DATFile datFile, boolean dryRun) {
        this.datFile = datFile;
        this.dryRun = dryRun;
    }

    public void extract(Path directory, boolean delete) {
        directory = directory.toString().contains(".dat") ? Path.of(directory.toString().split(".dat")[0]) : Path.of(directory.toString().split(".dtt")[0]);

        if (delete) {
            try {
                Files.walk(directory)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            } catch (Exception e) {
                //System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < datFile.getHeader().getFileCount(); i++) {
            DATContentInfo datContentInfo = datFile.getFileInfo().get(i);
            DATContent datContent = datFile.getContent().get(i);

            if (!dryRun) {
                extractFile(directory, datContent, String.format("[%1$s] %2$s", datContentInfo.getFileOffset(), datContentInfo.getFileName()));
            }
        }
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
}
