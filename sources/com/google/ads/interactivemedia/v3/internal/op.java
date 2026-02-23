package com.google.ads.interactivemedia.v3.internal;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class op extends LinkedHashMap {
    public op() {
        super(5, 1.0f, false);
    }

    public final boolean removeEldestEntry(Map.Entry entry) {
        return size() > 4;
    }
}
