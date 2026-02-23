package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class xg implements Comparator {
    private final /* synthetic */ int c;
    public static final /* synthetic */ xg b = new xg(1);
    public static final /* synthetic */ xg a = new xg(0);

    private /* synthetic */ xg(int i) {
        this.c = i;
    }

    public final int compare(Object obj, Object obj2) {
        xh xhVar = (xh) obj;
        xh xhVar2 = (xh) obj2;
        return this.c != 0 ? xhVar.a - xhVar2.a : Float.compare(xhVar.c, xhVar2.c);
    }
}
