package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class LazyDecompressingInputStream extends InputStream {
    private final InputStreamFactory inputStreamFactory;
    private final InputStream wrappedStream;
    private InputStream wrapperStream;

    public LazyDecompressingInputStream(InputStream inputStream, InputStreamFactory inputStreamFactory) {
        this.wrappedStream = inputStream;
        this.inputStreamFactory = inputStreamFactory;
    }

    private void initWrapper() throws IOException {
        if (this.wrapperStream == null) {
            this.wrapperStream = this.inputStreamFactory.create(this.wrappedStream);
        }
    }

    public int available() throws IOException {
        initWrapper();
        return this.wrapperStream.available();
    }

    public void close() throws IOException {
        try {
            InputStream inputStream = this.wrapperStream;
            if (inputStream != null) {
                inputStream.close();
            }
        } finally {
            this.wrappedStream.close();
        }
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        initWrapper();
        return this.wrapperStream.read();
    }

    public long skip(long j) throws IOException {
        initWrapper();
        return this.wrapperStream.skip(j);
    }

    public int read(byte[] bArr) throws IOException {
        initWrapper();
        return this.wrapperStream.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        initWrapper();
        return this.wrapperStream.read(bArr, i, i2);
    }
}
