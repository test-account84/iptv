package b4;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import d4.k0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends g {
    public final AssetManager e;
    public Uri f;
    public InputStream g;
    public long h;
    public boolean i;

    public static final class a extends p {
        public a(Throwable th, int i) {
            super(th, i);
        }
    }

    public c(Context context) {
        super(false);
        this.e = context.getAssets();
    }

    public long a(s sVar) {
        try {
            Uri uri = sVar.a;
            this.f = uri;
            String str = (String) d4.a.e(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            v(sVar);
            InputStream open = this.e.open(str, 1);
            this.g = open;
            if (open.skip(sVar.g) < sVar.g) {
                throw new a(null, 2008);
            }
            long j = sVar.h;
            if (j != -1) {
                this.h = j;
            } else {
                long available = this.g.available();
                this.h = available;
                if (available == 2147483647L) {
                    this.h = -1L;
                }
            }
            this.i = true;
            w(sVar);
            return this.h;
        } catch (a e) {
            throw e;
        } catch (IOException e2) {
            throw new a(e2, e2 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    public void close() {
        this.f = null;
        try {
            try {
                InputStream inputStream = this.g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new a(e, 2000);
            }
        } finally {
            this.g = null;
            if (this.i) {
                this.i = false;
                u();
            }
        }
    }

    public Uri getUri() {
        return this.f;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.h;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new a(e, 2000);
            }
        }
        int read = ((InputStream) k0.j(this.g)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.h;
        if (j2 != -1) {
            this.h = j2 - read;
        }
        t(read);
        return read;
    }
}
