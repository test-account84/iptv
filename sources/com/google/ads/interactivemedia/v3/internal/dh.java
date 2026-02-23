package com.google.ads.interactivemedia.v3.internal;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class dh implements atm {
    private final /* synthetic */ int c;
    public static final /* synthetic */ dh b = new dh(1);
    public static final /* synthetic */ dh a = new dh(0);

    private /* synthetic */ dh(int i) {
        this.c = i;
    }

    public final boolean a(Object obj) {
        return this.c != 0 ? ((Map.Entry) obj).getKey() != null : ((String) obj) != null;
    }
}
