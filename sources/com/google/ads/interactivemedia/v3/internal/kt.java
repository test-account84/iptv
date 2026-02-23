package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class kt implements Comparator {
    public static final /* synthetic */ kt a = new kt();

    private /* synthetic */ kt() {
    }

    public final int compare(Object obj, Object obj2) {
        lt ltVar = (lt) obj;
        lt ltVar2 = (lt) obj2;
        int i = ltVar.c;
        int i2 = ltVar2.c;
        int i3 = i == i2 ? 0 : i < i2 ? -1 : 1;
        return i3 != 0 ? i3 : ltVar.b.compareTo(ltVar2.b);
    }
}
