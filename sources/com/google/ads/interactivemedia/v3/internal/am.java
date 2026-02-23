package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class am {
    public final Object a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;

    public am(am amVar) {
        this.a = amVar.a;
        this.b = amVar.b;
        this.c = amVar.c;
        this.d = amVar.d;
        this.e = amVar.e;
    }

    public final am a(Object obj) {
        return this.a.equals(obj) ? this : new am(obj, this.b, this.c, this.d, this.e);
    }

    public final boolean b() {
        return this.b != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof am)) {
            return false;
        }
        am amVar = (am) obj;
        return this.a.equals(amVar.a) && this.b == amVar.b && this.c == amVar.c && this.d == amVar.d && this.e == amVar.e;
    }

    public final int hashCode() {
        return ((((((((this.a.hashCode() + 527) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d)) * 31) + this.e;
    }

    public am(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    private am(Object obj, int i, int i2, long j, int i3) {
        this.a = obj;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = i3;
    }

    public am(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public am(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
