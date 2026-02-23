package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPublicKey;
import java.util.LinkedHashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class oq {
    private final Object a;

    public oq() {
        this.a = new op();
    }

    public static oq i(String str, byte[] bArr, int i) {
        bif j = bht.j();
        j.n(str);
        j.o(bpb.t(bArr));
        int i2 = i - 1;
        j.m(i2 != 0 ? i2 != 1 ? bid.RAW : bid.LEGACY : bid.TINK);
        return new oq((bht) j.aY());
    }

    public final byte[] a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return (byte[]) ((LinkedHashMap) this.a).get(uri);
    }

    public final byte[] b(Uri uri) {
        return (byte[]) ((LinkedHashMap) this.a).remove(uri);
    }

    public final void c(Uri uri, byte[] bArr) {
        Object obj = this.a;
        af.s(uri);
    }

    public final cy d() {
        return ((df) this.a).a();
    }

    public final String e() {
        return ((bht) this.a).e();
    }

    public final byte[] f() {
        return ((bht) this.a).d().B();
    }

    public final int g() {
        bid c = ((bht) this.a).c();
        bid bidVar = bid.UNKNOWN_PREFIX;
        int ordinal = c.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (ordinal != 3) {
                    if (ordinal == 4) {
                        return 4;
                    }
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
            }
        }
        return i;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.security.interfaces.ECKey] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.security.interfaces.ECPublicKey] */
    public final bel h(String str, byte[] bArr, byte[] bArr2, int i, int i2) throws GeneralSecurityException {
        KeyPair k = bjh.k(this.a.getParams());
        ECPublicKey eCPublicKey = k.getPublic();
        byte[] o = bjh.o(k.getPrivate(), this.a);
        byte[] v = bjh.v(eCPublicKey.getParams().getCurve(), i2, eCPublicKey.getW());
        byte[] y = bjh.y(v, o);
        Mac mac = (Mac) biv.b.a(str);
        if (i > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr == null || bArr.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
        } else {
            mac.init(new SecretKeySpec(bArr, str));
        }
        byte[] doFinal = mac.doFinal(y);
        byte[] bArr3 = new byte[i];
        mac.init(new SecretKeySpec(doFinal, str));
        byte[] bArr4 = new byte[0];
        int i3 = 1;
        int i4 = 0;
        while (true) {
            mac.update(bArr4);
            mac.update(bArr2);
            mac.update((byte) i3);
            bArr4 = mac.doFinal();
            int length = bArr4.length;
            int i5 = i4 + length;
            if (i5 >= i) {
                System.arraycopy(bArr4, 0, bArr3, i4, i - i4);
                return new bel(v, bArr3);
            }
            System.arraycopy(bArr4, 0, bArr3, i4, length);
            i3++;
            i4 = i5;
        }
    }

    private oq(bht bhtVar) {
        this.a = bhtVar;
    }

    public oq(cx cxVar) {
        this.a = cxVar;
    }

    public oq(ECPublicKey eCPublicKey) {
        this.a = eCPublicKey;
    }
}
