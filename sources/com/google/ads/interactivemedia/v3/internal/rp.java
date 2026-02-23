package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class rp implements rv {
    private final /* synthetic */ int c;
    public static final /* synthetic */ rp b = new rp(1);
    public static final /* synthetic */ rp a = new rp(0);

    private /* synthetic */ rp(int i) {
        this.c = i;
    }

    public final int a(Object obj) {
        rh rhVar = (rh) obj;
        if (this.c == 0) {
            int i = rw.a;
            return rhVar.a.startsWith("OMX.google") ? 1 : 0;
        }
        int i2 = rw.a;
        String str = rhVar.a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (cq.a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
