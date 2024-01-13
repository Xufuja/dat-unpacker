package dev.xfj;

import dev.xfj.extracting.DATExtractor;
import dev.xfj.format.dat.DATFile;
import dev.xfj.parsing.DATParser;
import dev.xfj.parsing.WMBParser;
import dev.xfj.parsing.WTAParser;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    public Application() {

    }

    public void run() {
        //parseAndExtractDAT(Path.of("pl010d.dat"));
        //parseAndExtractDAT(Path.of("pl010d.dtt"), false);
        try {
            //WTAParser wtaParser = new WTAParser(Paths.get("pl010d", "[976] pl010d.wta"));
            //wtaParser.parse();

            WMBParser wmbParser = new WMBParser(Paths.get("pl010d", "[976] pl010d.wta"));
            wmbParser.parse();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void parseAndExtractDAT(Path path) {
        parseAndExtractDAT(path, true);
    }

    public void parseAndExtractDAT(Path path, boolean delete) {
        try {
            DATParser datParser = new DATParser(path);
            DATFile datFile = datParser.parse();

            DATExtractor datExtractor = new DATExtractor(datFile, false);
            datExtractor.extract(path, delete);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
