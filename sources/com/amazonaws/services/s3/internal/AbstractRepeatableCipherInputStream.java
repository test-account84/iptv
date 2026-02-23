package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AbstractRepeatableCipherInputStream extends SdkFilterInputStream {
    private final Object cipherFactory;
    private boolean hasBeenAccessed;
    private final InputStream unencryptedDataStream;

    public AbstractRepeatableCipherInputStream(InputStream inputStream, FilterInputStream filterInputStream, Object obj) {
        super(filterInputStream);
        this.unencryptedDataStream = inputStream;
        this.cipherFactory = obj;
    }

    public abstract FilterInputStream createCipherInputStream(InputStream inputStream, Object obj);

    public void mark(int i) {
        abortIfNeeded();
        if (this.hasBeenAccessed) {
            throw new UnsupportedOperationException("Marking is only supported before your first call to read or skip.");
        }
        this.unencryptedDataStream.mark(i);
    }

    public boolean markSupported() {
        abortIfNeeded();
        return this.unencryptedDataStream.markSupported();
    }

    public int read() throws IOException {
        this.hasBeenAccessed = true;
        return super.read();
    }

    public void reset() throws IOException {
        abortIfNeeded();
        this.unencryptedDataStream.reset();
        ((FilterInputStream) this).in = createCipherInputStream(this.unencryptedDataStream, this.cipherFactory);
        this.hasBeenAccessed = false;
    }

    public long skip(long j) throws IOException {
        this.hasBeenAccessed = true;
        return super.skip(j);
    }

    public int read(byte[] bArr) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr, i, i2);
    }
}
