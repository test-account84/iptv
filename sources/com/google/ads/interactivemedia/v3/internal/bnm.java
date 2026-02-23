package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bnm implements bkm {
    final /* synthetic */ Class a;
    final /* synthetic */ bkl b;
    private final /* synthetic */ int c;

    public bnm(Class cls, bkl bklVar, int i) {
        this.c = i;
        this.a = cls;
        this.b = bklVar;
    }

    public final bkl a(bjt bjtVar, bof bofVar) {
        if (this.c != 0) {
            if (bofVar.c() == this.a) {
                return this.b;
            }
            return null;
        }
        Class c = bofVar.c();
        if (this.a.isAssignableFrom(c)) {
            return new bnl(this, c);
        }
        return null;
    }

    public final String toString() {
        String name;
        String obj;
        StringBuilder sb;
        String str;
        if (this.c != 0) {
            name = this.a.getName();
            obj = this.b.toString();
            sb = new StringBuilder();
            str = "Factory[type=";
        } else {
            name = this.a.getName();
            obj = this.b.toString();
            sb = new StringBuilder();
            str = "Factory[typeHierarchy=";
        }
        sb.append(str);
        sb.append(name);
        sb.append(",adapter=");
        sb.append(obj);
        sb.append("]");
        return sb.toString();
    }
}
