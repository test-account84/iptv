package org.apache.commons.codec.binary;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary.BaseNCodec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BaseNCodecOutputStream extends FilterOutputStream {
    private final BaseNCodec baseNCodec;
    private final BaseNCodec.Context context;
    private final boolean doEncode;
    private final byte[] singleByte;

    public BaseNCodecOutputStream(OutputStream outputStream, BaseNCodec baseNCodec, boolean z) {
        super(outputStream);
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.baseNCodec = baseNCodec;
        this.doEncode = z;
    }

    public void close() throws IOException {
        if (this.doEncode) {
            this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
        } else {
            this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
        }
        flush();
        ((FilterOutputStream) this).out.close();
    }

    public void flush() throws IOException {
        flush(true);
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    private void flush(boolean z) throws IOException {
        byte[] bArr;
        int readResults;
        int available = this.baseNCodec.available(this.context);
        if (available > 0 && (readResults = this.baseNCodec.readResults((bArr = new byte[available]), 0, available, this.context)) > 0) {
            ((FilterOutputStream) this).out.write(bArr, 0, readResults);
        }
        if (z) {
            ((FilterOutputStream) this).out.flush();
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 > 0) {
            if (this.doEncode) {
                this.baseNCodec.encode(bArr, i, i2, this.context);
            } else {
                this.baseNCodec.decode(bArr, i, i2, this.context);
            }
            flush(false);
        }
    }
}
