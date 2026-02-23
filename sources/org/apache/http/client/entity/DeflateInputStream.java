package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DeflateInputStream extends InputStream {
    private final InputStream sourceStream;

    public static class DeflateStream extends InflaterInputStream {
        private boolean closed;

        public DeflateStream(InputStream inputStream, Inflater inflater) {
            super(inputStream, inflater);
            this.closed = false;
        }

        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            ((InflaterInputStream) this).inf.end();
            super.close();
        }
    }

    public DeflateInputStream(InputStream inputStream) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 2);
        int read = pushbackInputStream.read();
        int read2 = pushbackInputStream.read();
        if (read == -1 || read2 == -1) {
            throw new ZipException("Unexpected end of stream");
        }
        pushbackInputStream.unread(read2);
        pushbackInputStream.unread(read);
        int i = read & 255;
        this.sourceStream = new DeflateStream(pushbackInputStream, new Inflater(((read & 15) == 8 && ((i >> 4) & 15) <= 7 && ((i << 8) | (read2 & 255)) % 31 == 0) ? false : true));
    }

    public int available() throws IOException {
        return this.sourceStream.available();
    }

    public void close() throws IOException {
        this.sourceStream.close();
    }

    public void mark(int i) {
        this.sourceStream.mark(i);
    }

    public boolean markSupported() {
        return this.sourceStream.markSupported();
    }

    public int read() throws IOException {
        return this.sourceStream.read();
    }

    public void reset() throws IOException {
        this.sourceStream.reset();
    }

    public long skip(long j) throws IOException {
        return this.sourceStream.skip(j);
    }

    public int read(byte[] bArr) throws IOException {
        return this.sourceStream.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.sourceStream.read(bArr, i, i2);
    }
}
