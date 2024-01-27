package dev.xfj;

import dev.xfj.extracting.DATExtractor;
import dev.xfj.extracting.WMBExtractor;
import dev.xfj.parsing.DATParser;
import dev.xfj.parsing.WMBParser;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class Application {
    public Application() {

    }

    public void run() {
        String target = "pl010d";

        File datLocation = new File(System.getProperty("user.dir"));
        File[] datFiles = datLocation.listFiles((dir, name) -> name.equals(String.format("%s.dat", target)) || name.equals(String.format("%s.dtt", target)));
        Path dat = findFile(datFiles, "dat");
        Path dtt = findFile(datFiles, "dtt");

        parseAndExtractDAT(dat);
        parseAndExtractDAT(dtt, false);

        File directory = new File(target);
        File[] sourceFiles = directory.listFiles((dir, name) -> name.endsWith("wmb") || name.endsWith("wta") || name.endsWith("wtp"));
        Path wmb = findFile(sourceFiles, "wmb");
        Path wta = findFile(sourceFiles, "wta");
        Path wtp = findFile(sourceFiles, "wtp");

        parseAndExtractWMB(Path.of(target), wmb, wta, wtp);
        //parseAndExtractWMB(Paths.get("pl010d", "[36452768] pl010d.wmb"));
    }

    private Path findFile(File[] files, String extension) {
        return Arrays.stream(files)
                .filter(file -> file.toString().endsWith(extension))
                .findFirst()
                .map(File::toPath)
                .orElse(null);
    }

    public void parseAndExtractDAT(Path path) {
        parseAndExtractDAT(path, true);
    }

    public void parseAndExtractDAT(Path path, boolean delete) {
        try {
            DATParser datParser = new DATParser(path);
            DATExtractor datExtractor = new DATExtractor(datParser.parse(), false);
            datExtractor.extract(path, delete);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void parseAndExtractWMB(Path base, Path wmbPath, Path wtaPath, Path wtpPath) {
        try {
            WMBParser wmbParser = new WMBParser(wmbPath);
            WMBExtractor wmbExtractor = new WMBExtractor(wmbParser.parse(), false);
            wmbExtractor.extract(base, wtaPath, wtpPath);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
