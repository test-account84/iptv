package b4;

import O2.l1;
import android.net.Uri;
import android.util.Base64;
import d4.k0;
import java.net.URLDecoder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends g {
    public s e;
    public byte[] f;
    public int g;
    public int h;

    public l() {
        super(false);
    }

    public long a(s sVar) {
        v(sVar);
        this.e = sVar;
        Uri normalizeScheme = sVar.a.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        d4.a.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] i1 = k0.i1(normalizeScheme.getSchemeSpecificPart(), ",");
        if (i1.length != 2) {
            throw l1.b("Unexpected URI format: " + normalizeScheme, null);
        }
        String str = i1[1];
        if (i1[0].contains(";base64")) {
            try {
                this.f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw l1.b("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.f = k0.s0(URLDecoder.decode(str, r5.d.a.name()));
        }
        long j = sVar.g;
        byte[] bArr = this.f;
        if (j > bArr.length) {
            this.f = null;
            throw new p(2008);
        }
        int i = (int) j;
        this.g = i;
        int length = bArr.length - i;
        this.h = length;
        long j2 = sVar.h;
        if (j2 != -1) {
            this.h = (int) Math.min(length, j2);
        }
        w(sVar);
        long j3 = sVar.h;
        return j3 != -1 ? j3 : this.h;
    }

    public void close() {
        if (this.f != null) {
            this.f = null;
            u();
        }
        this.e = null;
    }

    public Uri getUri() {
        s sVar = this.e;
        if (sVar != null) {
            return sVar.a;
        }
        return null;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(k0.j(this.f), this.g, bArr, i, min);
        this.g += min;
        this.h -= min;
        t(min);
        return min;
    }
}
