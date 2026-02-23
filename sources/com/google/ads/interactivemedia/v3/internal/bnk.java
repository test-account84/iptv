package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnk implements bkm {
    final /* synthetic */ Class a;
    final /* synthetic */ Class b;
    final /* synthetic */ bkl c;
    private final /* synthetic */ int d;

    public bnk(Class cls, Class cls2, bkl bklVar, int i) {
        this.d = i;
        this.a = cls;
        this.b = cls2;
        this.c = bklVar;
    }

    public final bkl a(bjt bjtVar, bof bofVar) {
        if (this.d != 0) {
            Class c = bofVar.c();
            if (c == this.b || c == this.a) {
                return this.c;
            }
            return null;
        }
        Class c2 = bofVar.c();
        if (c2 == this.a || c2 == this.b) {
            return this.c;
        }
        return null;
    }

    public final String toString() {
        String name;
        String name2;
        String obj;
        StringBuilder sb;
        if (this.d != 0) {
            name = this.a.getName();
            name2 = this.b.getName();
            obj = this.c.toString();
            sb = new StringBuilder();
        } else {
            name = this.a.getName();
            name2 = this.b.getName();
            obj = this.c.toString();
            sb = new StringBuilder();
        }
        sb.append("Factory[type=");
        sb.append(name);
        sb.append("+");
        sb.append(name2);
        sb.append(",adapter=");
        sb.append(obj);
        sb.append("]");
        return sb.toString();
    }

    public bnk(Class cls, Class cls2, bkl bklVar, int i, byte[] bArr) {
        this.d = i;
        this.b = cls;
        this.a = cls2;
        this.c = bklVar;
    }
}
