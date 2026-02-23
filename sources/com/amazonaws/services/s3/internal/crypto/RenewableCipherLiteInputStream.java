package com.amazonaws.services.s3.internal.crypto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class RenewableCipherLiteInputStream extends CipherLiteInputStream {
    private boolean hasBeenAccessed;

    public RenewableCipherLiteInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void mark(int i) {
        abortIfNeeded();
        if (this.hasBeenAccessed) {
            throw new UnsupportedOperationException("Marking is only supported before your first call to read or skip.");
        }
        ((FilterInputStream) this).in.mark(i);
    }

    public boolean markSupported() {
        abortIfNeeded();
        return ((FilterInputStream) this).in.markSupported();
    }

    public int read() throws IOException {
        this.hasBeenAccessed = true;
        return super.read();
    }

    public void reset() throws IOException {
        abortIfNeeded();
        ((FilterInputStream) this).in.reset();
        renewCipherLite();
        resetInternal();
        this.hasBeenAccessed = false;
    }

    public long skip(long j) throws IOException {
        this.hasBeenAccessed = true;
        return super.skip(j);
    }

    public RenewableCipherLiteInputStream(InputStream inputStream, CipherLite cipherLite) {
        super(inputStream, cipherLite);
    }

    public int read(byte[] bArr) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr);
    }

    public RenewableCipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int i) {
        super(inputStream, cipherLite, i);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr, i, i2);
    }

    public RenewableCipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int i, boolean z, boolean z2) {
        super(inputStream, cipherLite, i, z, z2);
    }
}
