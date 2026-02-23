package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class arw {
    private final String a;
    private final boolean b;
    private final boolean c;

    public arw() {
    }

    public static arv a() {
        arv arvVar = new arv(null);
        arvVar.d(false);
        arvVar.c();
        return arvVar;
    }

    public final String b() {
        return this.a;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof arw) {
            arw arwVar = (arw) obj;
            if (this.a.equals(arwVar.b()) && this.b == arwVar.d() && this.c == arwVar.c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231)) * 1000003) ^ (true != this.c ? 1237 : 1231);
    }

    public final String toString() {
        return "AdShield2Options{clientVersion=" + this.a + ", shouldGetAdvertisingId=" + this.b + ", isGooglePlayServicesAvailable=" + this.c + "}";
    }

    public /* synthetic */ arw(String str, boolean z, boolean z2) {
        this();
        this.a = str;
        this.b = z;
        this.c = z2;
    }
}
