package dev.xfj.parsing;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractParser implements Parser {
    protected final byte[] bytes;
    protected final ByteBuffer byteBuffer;
    protected int offset;

    public AbstractParser(Path path) throws IOException {
        this.bytes = Files.readAllBytes(path);
        this.byteBuffer = ByteBuffer.wrap(bytes);
        this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.offset = 0;
    }

    protected byte getByte() {
        byte result = byteBuffer.get(offset);
        this.offset += Byte.BYTES;
        return result;
    }

    protected int getUByte() {
        int result = Byte.toUnsignedInt(byteBuffer.get(offset));
        this.offset += Byte.BYTES;
        return result;
    }

    protected short getInt16() {
        short result = byteBuffer.getShort(offset);
        this.offset += Short.BYTES;
        return result;
    }

    protected int getUInt16() {
        int result = Short.toUnsignedInt(byteBuffer.getShort(offset));
        this.offset += Short.BYTES;
        return result;
    }

    protected int getInt32() {
        int result = byteBuffer.getInt(offset);
        this.offset += Integer.BYTES;
        return result;
    }

    protected long getUInt32() {
        long result = Integer.toUnsignedLong(byteBuffer.getInt(offset));
        this.offset += Integer.BYTES;
        return result;
    }

    protected float getFloat() {
        float result = byteBuffer.getFloat(offset);
        this.offset += Float.BYTES;
        return result;
    }

    protected String getFixedString(int start, int length, Charset charset) {
        int end = start + length;
        byte[] result = new byte[length];
        for (int i = start; i < end; i++) {
            int resultIndex = i - start;
            result[resultIndex] = bytes[i];
            //System.out.println(result[resultIndex]);
        }
        //System.out.println("End of Byte Range");
        offset += length;
        ByteBuffer buffer = ByteBuffer.wrap(result);
        return charset.decode(buffer).toString().split("\0")[0];
    }

    protected String getFixedString(int length) {
        return getFixedString(offset, length, StandardCharsets.UTF_8);
    }

    protected String getFixedString(int length, Charset charset) {
        return getFixedString(offset, length, charset);
    }

    protected int getOffset() {
        return offset;
    }

    protected void setOffset(int offset) {
        this.offset = offset;
    }

    protected byte[] getSlice(int offset, int length) {
        byteBuffer.position(offset);
        byteBuffer.limit(offset + length);
        byte[] array = new byte[length];
        byteBuffer.get(array);
        byteBuffer.limit(byteBuffer.capacity());
        return array;
    }
}
