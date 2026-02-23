package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class LengthCheckInputStream extends SdkFilterInputStream {
    public static final boolean EXCLUDE_SKIPPED_BYTES = false;
    public static final boolean INCLUDE_SKIPPED_BYTES = true;
    private long dataLength;
    private final long expectedLength;
    private final boolean includeSkipped;
    private long marked;

    public LengthCheckInputStream(InputStream inputStream, long j, boolean z) {
        super(inputStream);
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        this.expectedLength = j;
        this.includeSkipped = z;
    }

    private void checkLength(boolean z) {
        long j = this.dataLength;
        long j2 = this.expectedLength;
        if (z) {
            if (j == j2) {
                return;
            }
            throw new AmazonClientException("Data read (" + this.dataLength + ") has a different length than the expected (" + this.expectedLength + ")");
        }
        if (j <= j2) {
            return;
        }
        throw new AmazonClientException("More data read (" + this.dataLength + ") than expected (" + this.expectedLength + ")");
    }

    public void mark(int i) {
        super.mark(i);
        this.marked = this.dataLength;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read >= 0) {
            this.dataLength++;
        }
        checkLength(read == -1);
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        if (super.markSupported()) {
            this.dataLength = this.marked;
        }
    }

    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (this.includeSkipped && skip > 0) {
            this.dataLength += skip;
            checkLength(false);
        }
        return skip;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        this.dataLength += read >= 0 ? read : 0L;
        checkLength(read == -1);
        return read;
    }
}
