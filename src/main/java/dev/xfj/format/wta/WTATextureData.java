package dev.xfj.format.wta;

public class WTATextureData {
    private int wtaTextureOffset;
    private int wtaTextureSize;
    private int wtaTextureIdentifier;
    private int unknownArray1;

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

    public int getWtaTextureIdentifier() {
        return wtaTextureIdentifier;
    }

    public void setWtaTextureIdentifier(int wtaTextureIdentifier) {
        this.wtaTextureIdentifier = wtaTextureIdentifier;
    }

    public int getUnknownArray1() {
        return unknownArray1;
    }

    public void setUnknownArray1(int unknownArray1) {
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
