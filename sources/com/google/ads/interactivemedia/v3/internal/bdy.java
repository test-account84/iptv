package com.google.ads.interactivemedia.v3.internal;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bdy {
    private final Object a;
    private final Object b;

    public bdy() {
        this.b = new ArrayList();
        this.a = new ArrayList();
        new ArrayList();
    }

    public static bdy a(bdx bdxVar, Class cls, Class cls2) {
        return new bdy(cls, cls2);
    }

    public static bdy n() {
        com.google.ads.interactivemedia.v3.impl.data.i.d("Google1", "Name is null or empty");
        com.google.ads.interactivemedia.v3.impl.data.i.d("3.29.0", "Version is null or empty");
        return new bdy((byte[]) null, (byte[]) null);
    }

    private static void o(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public final Class b() {
        return (Class) this.a;
    }

    public final Class c() {
        return (Class) this.b;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.ads.interactivemedia.v3.internal.azo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.ads.interactivemedia.v3.internal.azr, java.lang.Object] */
    public final byte[] d(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ?? r0 = this.a;
        return r0 != 0 ? r0.a(bArr, bArr2) : this.b.a(bArr, bArr2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Collection] */
    public final void e(aqj aqjVar) {
        this.a.add(aqjVar);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.util.Collection] */
    public final void f(aqj aqjVar) {
        this.b.add(aqjVar);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.ads.interactivemedia.v3.internal.ahg, java.lang.Object] */
    public final ahg g() {
        return this.a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.ads.interactivemedia.v3.internal.ahg, java.lang.Object] */
    public final ahg h() {
        return this.b;
    }

    public final String i() {
        return (String) this.a;
    }

    public final String j() {
        return (String) this.b;
    }

    public final void k(long j, cj cjVar) {
        fz.l(j, cjVar, (aae[]) this.b);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.List] */
    public final void l(zk zkVar, aet aetVar) {
        for (int i = 0; i < ((aae[]) this.b).length; i++) {
            aetVar.c();
            aae i2 = zkVar.i(aetVar.a(), 3);
            s sVar = (s) this.a.get(i);
            String str = sVar.l;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            af.v(z, "Invalid closed caption mime type provided: ".concat(String.valueOf(str)));
            String str2 = sVar.a;
            if (str2 == null) {
                str2 = aetVar.b();
            }
            r rVar = new r();
            rVar.S(str2);
            rVar.ae(str);
            rVar.ag(sVar.d);
            rVar.V(sVar.c);
            rVar.F(sVar.D);
            rVar.T(sVar.n);
            i2.b(rVar.v());
            ((aae[]) this.b)[i] = i2;
        }
    }

    public final byte[] m(aal aalVar) {
        ((ByteArrayOutputStream) this.a).reset();
        try {
            o((DataOutputStream) this.b, aalVar.a);
            String str = aalVar.b;
            if (str == null) {
                str = "";
            }
            o((DataOutputStream) this.b, str);
            ((DataOutputStream) this.b).writeLong(aalVar.c);
            ((DataOutputStream) this.b).writeLong(aalVar.d);
            ((DataOutputStream) this.b).write(aalVar.e);
            ((DataOutputStream) this.b).flush();
            return ((ByteArrayOutputStream) this.a).toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public bdy(azo azoVar) {
        this.a = azoVar;
        this.b = null;
    }

    public bdy(azr azrVar) {
        this.a = null;
        this.b = azrVar;
    }

    public bdy(Class cls, Class cls2) {
        this(cls, cls2, null);
    }

    public /* synthetic */ bdy(Class cls, Class cls2, byte[] bArr) {
        this.a = cls;
        this.b = cls2;
    }

    public bdy(List list) {
        this.a = list;
        this.b = new aae[list.size()];
    }

    public bdy(byte[] bArr) {
        ahh ahhVar = new ahh(0);
        this.b = ahhVar;
        this.a = new ahh(ahhVar, 1);
    }

    private bdy(byte[] bArr, byte[] bArr2) {
        this.a = "Google1";
        this.b = "3.29.0";
    }

    public bdy(char[] cArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.a = byteArrayOutputStream;
        this.b = new DataOutputStream(byteArrayOutputStream);
    }
}
