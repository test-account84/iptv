package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bz {
    public final Object a;
    private p b = new p();
    private boolean c;
    private boolean d;

    public bz(Object obj) {
        this.a = obj;
    }

    public final void a(int i, bx bxVar) {
        if (this.d) {
            return;
        }
        if (i != -1) {
            this.b.b(i);
        }
        this.c = true;
        bxVar.a(this.a);
    }

    public final void b(by byVar) {
        if (this.d || !this.c) {
            return;
        }
        q a = this.b.a();
        this.b = new p();
        this.c = false;
        byVar.a(this.a, a);
    }

    public final void c(by byVar) {
        this.d = true;
        if (this.c) {
            byVar.a(this.a, this.b.a());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || bz.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((bz) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
