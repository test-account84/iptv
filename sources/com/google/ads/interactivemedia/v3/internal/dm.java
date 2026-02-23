package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class dm extends ct {
    private RandomAccessFile a;
    private Uri b;
    private long c;
    private boolean d;

    public dm() {
        super(false);
    }

    public final int a(byte[] bArr, int i, int i2) throws dl {
        if (i2 == 0) {
            return 0;
        }
        long j = this.c;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.a;
            int i3 = cq.a;
            int read = randomAccessFile.read(bArr, i, (int) Math.min(j, i2));
            if (read > 0) {
                this.c -= read;
                g(read);
            }
            return read;
        } catch (IOException e) {
            throw new dl(e, 2000);
        }
    }

    public final long b(dc dcVar) throws dl {
        Uri uri = dcVar.a;
        this.b = uri;
        i(dcVar);
        try {
            String path = uri.getPath();
            af.s(path);
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.a = randomAccessFile;
            try {
                randomAccessFile.seek(dcVar.e);
                long j = dcVar.f;
                if (j == -1) {
                    j = this.a.length() - dcVar.e;
                }
                this.c = j;
                if (j < 0) {
                    throw new dl(null, null, 2008);
                }
                this.d = true;
                j(dcVar);
                return this.c;
            } catch (IOException e) {
                throw new dl(e, 2000);
            }
        } catch (FileNotFoundException e2) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new dl(e2, (cq.a < 21 || !dk.a(e2.getCause())) ? 2005 : 2006);
            }
            throw new dl(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e2, 1004);
        } catch (SecurityException e3) {
            throw new dl(e3, 2006);
        } catch (RuntimeException e4) {
            throw new dl(e4, 2000);
        }
    }

    public final Uri c() {
        return this.b;
    }

    public final void d() throws dl {
        this.b = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.a;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.a = null;
                if (this.d) {
                    this.d = false;
                    h();
                }
            } catch (IOException e) {
                throw new dl(e, 2000);
            }
        } catch (Throwable th) {
            this.a = null;
            if (this.d) {
                this.d = false;
                h();
            }
            throw th;
        }
    }
}
