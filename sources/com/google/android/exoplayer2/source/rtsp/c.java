package com.google.android.exoplayer2.source.rtsp;

import O2.l1;
import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.source.rtsp.h;
import d4.k0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public final int a;
    public final String b;
    public final String c;
    public final String d;

    public c(int i, String str, String str2, String str3) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public String a(h.a aVar, Uri uri, int i) {
        int i2 = this.a;
        if (i2 == 1) {
            return b(aVar);
        }
        if (i2 == 2) {
            return c(aVar, uri, i);
        }
        throw l1.d(null, new UnsupportedOperationException());
    }

    public final String b(h.a aVar) {
        return k0.D("Basic %s", Base64.encodeToString(h.d(aVar.a + ":" + aVar.b), 0));
    }

    public final String c(h.a aVar, Uri uri, int i) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String t = h.t(i);
            String r1 = k0.r1(messageDigest.digest(h.d(aVar.a + ":" + this.b + ":" + aVar.b)));
            StringBuilder sb = new StringBuilder();
            sb.append(t);
            sb.append(":");
            sb.append(uri);
            String r12 = k0.r1(messageDigest.digest(h.d(r1 + ":" + this.c + ":" + k0.r1(messageDigest.digest(h.d(sb.toString()))))));
            return this.d.isEmpty() ? k0.D("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"", aVar.a, this.b, this.c, uri, r12) : k0.D("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"", aVar.a, this.b, this.c, uri, r12, this.d);
        } catch (NoSuchAlgorithmException e) {
            throw l1.d(null, e);
        }
    }
}
