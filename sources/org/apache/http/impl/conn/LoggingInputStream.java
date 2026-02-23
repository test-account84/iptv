package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class LoggingInputStream extends InputStream {
    private final InputStream in;
    private final Wire wire;

    public LoggingInputStream(InputStream inputStream, Wire wire) {
        this.in = inputStream;
        this.wire = wire;
    }

    public int available() throws IOException {
        try {
            return this.in.available();
        } catch (IOException e) {
            this.wire.input("[available] I/O error : " + e.getMessage());
            throw e;
        }
    }

    public void close() throws IOException {
        try {
            this.in.close();
        } catch (IOException e) {
            this.wire.input("[close] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public void mark(int i) {
        super.mark(i);
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        try {
            int read = this.in.read();
            if (read == -1) {
                this.wire.input("end of stream");
            } else {
                this.wire.input(read);
            }
            return read;
        } catch (IOException e) {
            this.wire.input("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public void reset() throws IOException {
        super.reset();
    }

    public long skip(long j) throws IOException {
        try {
            return super.skip(j);
        } catch (IOException e) {
            this.wire.input("[skip] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public int read(byte[] bArr) throws IOException {
        try {
            int read = this.in.read(bArr);
            if (read == -1) {
                this.wire.input("end of stream");
            } else if (read > 0) {
                this.wire.input(bArr, 0, read);
            }
            return read;
        } catch (IOException e) {
            this.wire.input("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.in.read(bArr, i, i2);
            if (read == -1) {
                this.wire.input("end of stream");
            } else if (read > 0) {
                this.wire.input(bArr, i, read);
            }
            return read;
        } catch (IOException e) {
            this.wire.input("[read] I/O error: " + e.getMessage());
            throw e;
        }
    }
}
