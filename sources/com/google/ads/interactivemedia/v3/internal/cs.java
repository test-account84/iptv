package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class cs extends ct {
    private final AssetManager a;
    private Uri b;
    private InputStream c;
    private long d;
    private boolean e;

    public cs(Context context) {
        super(false);
        this.a = context.getAssets();
    }

    public final int a(byte[] bArr, int i, int i2) throws cr {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new cr(e, 2000);
            }
        }
        InputStream inputStream = this.c;
        int i3 = cq.a;
        int read = inputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.d;
        if (j2 != -1) {
            this.d = j2 - read;
        }
        g(read);
        return read;
    }

    public final long b(dc dcVar) throws cr {
        try {
            Uri uri = dcVar.a;
            this.b = uri;
            String path = uri.getPath();
            af.s(path);
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            i(dcVar);
            InputStream open = this.a.open(path, 1);
            this.c = open;
            if (open.skip(dcVar.e) < dcVar.e) {
                throw new cr(null, 2008);
            }
            long j = dcVar.f;
            if (j != -1) {
                this.d = j;
            } else {
                long available = this.c.available();
                this.d = available;
                if (available == 2147483647L) {
                    this.d = -1L;
                }
            }
            this.e = true;
            j(dcVar);
            return this.d;
        } catch (cr e) {
            throw e;
        } catch (IOException e2) {
            throw new cr(e2, true != (e2 instanceof FileNotFoundException) ? 2000 : 2005);
        }
    }

    public final Uri c() {
        return this.b;
    }

    public final void d() throws cr {
        this.b = null;
        try {
            try {
                InputStream inputStream = this.c;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.c = null;
                if (this.e) {
                    this.e = false;
                    h();
                }
            } catch (IOException e) {
                throw new cr(e, 2000);
            }
        } catch (Throwable th) {
            this.c = null;
            if (this.e) {
                this.e = false;
                h();
            }
            throw th;
        }
    }
}
