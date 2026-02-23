package com.google.android.gms.internal.firebase_messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzk extends FilterInputStream {
    private long zza;
    private long zzb;

    public zzk(InputStream inputStream, long j) {
        super(inputStream);
        this.zzb = -1L;
        inputStream.getClass();
        this.zza = 1048577L;
    }

    public final int available() throws IOException {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.zza);
    }

    public final synchronized void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        this.zzb = this.zza;
    }

    public final int read() throws IOException {
        if (this.zza == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.zza--;
        }
        return read;
    }

    public final synchronized void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.zzb == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.zza = this.zzb;
    }

    public final long skip(long j) throws IOException {
        long skip = ((FilterInputStream) this).in.skip(Math.min(j, this.zza));
        this.zza -= skip;
        return skip;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.zza;
        if (j == 0) {
            return -1;
        }
        int read = ((FilterInputStream) this).in.read(bArr, i, (int) Math.min(i2, j));
        if (read != -1) {
            this.zza -= read;
        }
        return read;
    }
}
