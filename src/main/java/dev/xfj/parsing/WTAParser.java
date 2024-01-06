package dev.xfj.parsing;

import dev.xfj.format.wta.WTAFile;
import dev.xfj.format.wta.WTATextureData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WTAParser extends Parser {
    public WTAParser(Path path) throws IOException {
        super(path);
    }

    public WTAFile parse() {
        WTAFile wtaFile = new WTAFile();

        wtaFile.setMagicValue(getFixedString(4, StandardCharsets.UTF_8));
        wtaFile.setUnknown4(getInt32());
        wtaFile.setTextureCount(getInt32());
        wtaFile.setTextureOffsetArrayOffset(getInt32());
        wtaFile.setTextureSizeArrayOffset(getInt32());
        wtaFile.setUnknownArrayOffset1(getInt32());
        wtaFile.setTextureIdentifierArrayOffset(getInt32());
        wtaFile.setUnknownArrayOffset2(getInt32());
        wtaFile.setTextureDataList(parseTextureData(wtaFile));
        wtaFile.setUnknownArray2(parseUnknownArray(wtaFile));

        return wtaFile;
    }

    public List<WTATextureData> parseTextureData(WTAFile wtaFile) {
        List<WTATextureData> data = new ArrayList<>();

        for (int i = 0; i < wtaFile.getTextureCount(); i++) {
            WTATextureData textureData = new WTATextureData();

            setOffset(wtaFile.getTextureOffsetArrayOffset() + i * 4);
            textureData.setWtaTextureOffset(getInt32());
            setOffset(wtaFile.getTextureSizeArrayOffset() + i * 4);
            textureData.setWtaTextureSize(getInt32());
            setOffset(wtaFile.getTextureIdentifierArrayOffset() + i * 4);
            textureData.setWtaTextureIdentifier(getInt32());
            setOffset(wtaFile.getUnknownArrayOffset1() + i * 4);
            textureData.setUnknownArray1(getInt32()); //TODO: convert to Hex

            data.add(textureData);
        }

        return data;
    }

    public List<Integer> parseUnknownArray(WTAFile wtaFile) {
        setOffset(wtaFile.getUnknownArrayOffset2());

        List<Integer> unknownValues = new ArrayList<>();

        boolean unknownNull = false;

        while (!unknownNull) {
            int temp = getInt32();

            if (temp != 0) {
                unknownValues.add(temp);
            } else {
                unknownNull = true;
            }
        }

        return unknownValues;
    }
}
