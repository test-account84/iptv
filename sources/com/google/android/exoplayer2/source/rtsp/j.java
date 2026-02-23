package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import b4.s;
import com.google.android.exoplayer2.source.rtsp.g;
import d4.k0;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j extends b4.g implements a, g.b {
    public final LinkedBlockingQueue e;
    public final long f;
    public byte[] g;
    public int h;

    public j(long j) {
        super(true);
        this.f = j;
        this.e = new LinkedBlockingQueue();
        this.g = new byte[0];
        this.h = -1;
    }

    public long a(s sVar) {
        this.h = sVar.a.getPort();
        return -1L;
    }

    public String c() {
        d4.a.g(this.h != -1);
        return k0.D("RTP/AVP/TCP;unicast;interleaved=%d-%d", Integer.valueOf(this.h), Integer.valueOf(this.h + 1));
    }

    public void close() {
    }

    public int getLocalPort() {
        return this.h;
    }

    public Uri getUri() {
        return null;
    }

    public boolean i() {
        return false;
    }

    public void j(byte[] bArr) {
        this.e.add(bArr);
    }

    public g.b l() {
        return this;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int min = Math.min(i2, this.g.length);
        System.arraycopy(this.g, 0, bArr, i, min);
        byte[] bArr2 = this.g;
        this.g = Arrays.copyOfRange(bArr2, min, bArr2.length);
        if (min == i2) {
            return min;
        }
        try {
            byte[] bArr3 = (byte[]) this.e.poll(this.f, TimeUnit.MILLISECONDS);
            if (bArr3 == null) {
                return -1;
            }
            int min2 = Math.min(i2 - min, bArr3.length);
            System.arraycopy(bArr3, 0, bArr, i + min, min2);
            if (min2 < bArr3.length) {
                this.g = Arrays.copyOfRange(bArr3, min2, bArr3.length);
            }
            return min + min2;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return -1;
        }
    }
}
