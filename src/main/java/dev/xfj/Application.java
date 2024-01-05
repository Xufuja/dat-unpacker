package dev.xfj;

import dev.xfj.parsing.DATParser;

import java.nio.file.Path;

public class Application {
    public Application() {

    }

    public void run() {
        try {
            DATParser datParser = new DATParser(Path.of("pl010d.dat"));
            datParser.parse();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
