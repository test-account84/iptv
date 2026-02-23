package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class du extends ct {
    private final Resources a;
    private final String b;
    private Uri c;
    private AssetFileDescriptor d;
    private InputStream e;
    private long f;
    private boolean g;

    public du(Context context) {
        super(false);
        this.a = context.getResources();
        this.b = context.getPackageName();
    }

    public final int a(byte[] bArr, int i, int i2) throws dt {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new dt(null, e, 2000);
            }
        }
        InputStream inputStream = this.e;
        int i3 = cq.a;
        int read = inputStream.read(bArr, i, i2);
        if (read == -1) {
            if (this.f == -1) {
                return -1;
            }
            throw new dt("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j2 = this.f;
        if (j2 != -1) {
            this.f = j2 - read;
        }
        g(read);
        return read;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long b(com.google.ads.interactivemedia.v3.internal.dc r18) throws com.google.ads.interactivemedia.v3.internal.dt {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.du.b(com.google.ads.interactivemedia.v3.internal.dc):long");
    }

    public final Uri c() {
        return this.c;
    }

    public final void d() throws dt {
        this.c = null;
        try {
            try {
                InputStream inputStream = this.e;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new dt(null, e, 2000);
                    }
                } finally {
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        h();
                    }
                }
            } catch (IOException e2) {
                throw new dt(null, e2, 2000);
            }
        } catch (Throwable th) {
            this.e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.d;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        h();
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new dt(null, e3, 2000);
                }
            } catch (Throwable th2) {
                this.d = null;
                if (this.g) {
                    this.g = false;
                    h();
                }
                throw th2;
            }
        }
    }
}
