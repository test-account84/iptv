package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.util.Base64;
import java.io.IOException;
import java.net.URLDecoder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class cw extends ct {
    private dc a;
    private byte[] b;
    private int c;
    private int d;

    public cw() {
        super(false);
    }

    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.d;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(cq.G(this.b), this.c, bArr, i, min);
        this.c += min;
        this.d -= min;
        g(min);
        return min;
    }

    public final long b(dc dcVar) throws IOException {
        i(dcVar);
        this.a = dcVar;
        Uri uri = dcVar.a;
        String scheme = uri.getScheme();
        af.v("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String[] ak = cq.ak(uri.getSchemeSpecificPart(), ",");
        if (ak.length != 2) {
            throw as.b("Unexpected URI format: ".concat(String.valueOf(uri)), null);
        }
        String str = ak[1];
        if (ak[0].contains(";base64")) {
            try {
                this.b = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw as.b("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e);
            }
        } else {
            this.b = cq.ad(URLDecoder.decode(str, ath.a.name()));
        }
        long j = dcVar.e;
        int length = this.b.length;
        if (j > length) {
            this.b = null;
            throw new cz(2008);
        }
        int i = (int) j;
        this.c = i;
        int i2 = length - i;
        this.d = i2;
        long j2 = dcVar.f;
        if (j2 != -1) {
            this.d = (int) Math.min(i2, j2);
        }
        j(dcVar);
        long j3 = dcVar.f;
        return j3 != -1 ? j3 : this.d;
    }

    public final Uri c() {
        dc dcVar = this.a;
        if (dcVar != null) {
            return dcVar.a;
        }
        return null;
    }

    public final void d() {
        if (this.b != null) {
            this.b = null;
            h();
        }
        this.a = null;
    }
}
