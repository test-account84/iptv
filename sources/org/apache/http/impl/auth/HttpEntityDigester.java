package org.apache.http.impl.auth;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class HttpEntityDigester extends OutputStream {
    private boolean closed;
    private byte[] digest;
    private final MessageDigest digester;

    public HttpEntityDigester(MessageDigest messageDigest) {
        this.digester = messageDigest;
        messageDigest.reset();
    }

    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.digest = this.digester.digest();
        super.close();
    }

    public byte[] getDigest() {
        return this.digest;
    }

    public void write(int i) throws IOException {
        if (this.closed) {
            throw new IOException("Stream has been already closed");
        }
        this.digester.update((byte) i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new IOException("Stream has been already closed");
        }
        this.digester.update(bArr, i, i2);
    }
}
