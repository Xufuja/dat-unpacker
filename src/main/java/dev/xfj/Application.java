package dev.xfj;

import dev.xfj.extracting.DATExtractor;
import dev.xfj.format.dat.DATFile;
import dev.xfj.parsing.DATParser;

import java.nio.file.Path;

public class Application {
    public Application() {

    }

    public void run() {
        parseAndExtract(Path.of("pl010d.dat"));
        parseAndExtract(Path.of("pl010d.dtt"), false);
    }

    public void parseAndExtract(Path path) {
        parseAndExtract(path, true);
    }

    public void parseAndExtract(Path path, boolean delete) {
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
