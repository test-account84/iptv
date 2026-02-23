package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bpn implements bqr {
    private final /* synthetic */ int d;
    static final bqr c = new bpn(2);
    static final bqr b = new bpn(1);
    static final bqr a = new bpn(0);

    private bpn(int i) {
        this.d = i;
    }

    public final boolean a(int i) {
        int i2 = this.d;
        return i2 != 0 ? i2 != 1 ? bps.b(i) != 0 : bpm.b(i) != 0 : bpo.b(i) != 0;
    }
}
