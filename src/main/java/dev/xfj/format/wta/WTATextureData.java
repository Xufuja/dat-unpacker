package dev.xfj.format.wta;

public class WTATextureData {
    private int wtaTextureOffset;
    private int wtaTextureSize;
    private String wtaTextureIdentifier;
    private String unknownArray1;

    public int getWtaTextureOffset() {
        return wtaTextureOffset;
    }

    public void setWtaTextureOffset(int wtaTextureOffset) {
        this.wtaTextureOffset = wtaTextureOffset;
    }

    public int getWtaTextureSize() {
        return wtaTextureSize;
    }

    public void setWtaTextureSize(int wtaTextureSize) {
        this.wtaTextureSize = wtaTextureSize;
    }

    public String getWtaTextureIdentifier() {
        return wtaTextureIdentifier;
    }

    public void setWtaTextureIdentifier(String wtaTextureIdentifier) {
        this.wtaTextureIdentifier = wtaTextureIdentifier;
    }

    public String getUnknownArray1() {
        return unknownArray1;
    }

    public void setUnknownArray1(String unknownArray1) {
        this.unknownArray1 = unknownArray1;
    }

    @Override
    public String toString() {
        return "WTATextureData{" +
                "wtaTextureOffset=" + wtaTextureOffset +
                ", wtaTextureSize=" + wtaTextureSize +
                ", wtaTextureIdentifier=" + wtaTextureIdentifier +
                ", unknownArray1=" + unknownArray1 +
                '}';
    }
}
