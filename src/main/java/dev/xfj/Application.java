package dev.xfj;

import dev.xfj.extracting.DATExtractor;
import dev.xfj.extracting.WMBExtractor;
import dev.xfj.parsing.DATParser;
import dev.xfj.parsing.WMBParser;

import java.nio.file.Path;

public class Application {
    public Application() {

    }

    public void run() {
        parseAndExtractDAT(Path.of("pl000d.dat"));
        parseAndExtractDAT(Path.of("pl000d.dtt"), false);
        parseAndExtractWMB(Path.of("pl000d"), Path.of("[59041210] pl000d.wmb"), Path.of("[676] pl000d.wta"), Path.of("[114] pl000d.wtp"));
        //parseAndExtractWMB(Paths.get("pl010d", "[36452768] pl010d.wmb"));
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
            WMBParser wmbParser = new WMBParser(base.resolve(wmbPath));
            WMBExtractor wmbExtractor = new WMBExtractor(wmbParser.parse(), false);
            wmbExtractor.extract(base, base.resolve(wtaPath), base.resolve(wtpPath));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
