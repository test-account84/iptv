package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aer {
    public final int a;
    public final String b;
    public final List c;
    public final byte[] d;

    public aer(int i, String str, List list, byte[] bArr) {
        this.a = i;
        this.b = str;
        this.c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.d = bArr;
    }
}
