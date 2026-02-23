package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class arv {
    private String a;
    private boolean b;
    private boolean c;
    private byte d;

    public arv() {
    }

    public final arw a() {
        String str;
        if (this.d == 3 && (str = this.a) != null) {
            return new arw(str, this.b, this.c);
        }
        StringBuilder sb = new StringBuilder();
        if (this.a == null) {
            sb.append(" clientVersion");
        }
        if ((this.d & 1) == 0) {
            sb.append(" shouldGetAdvertisingId");
        }
        if ((this.d & 2) == 0) {
            sb.append(" isGooglePlayServicesAvailable");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final void b(String str) {
        if (str == null) {
            throw new NullPointerException("Null clientVersion");
        }
        this.a = str;
    }

    public final void c() {
        this.c = true;
        this.d = (byte) (this.d | 2);
    }

    public final void d(boolean z) {
        this.b = z;
        this.d = (byte) (this.d | 1);
    }

    public arv(byte[] bArr) {
        this();
    }
}
