package com.google.ads.interactivemedia.v3.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bkt implements blk {
    private final /* synthetic */ int a;

    public bkt(int i) {
        this.a = i;
    }

    public final Object a() {
        switch (this.a) {
            case 0:
                return new LinkedHashSet();
            case 1:
                return new TreeSet();
            case 2:
                return new ArrayDeque();
            case 3:
                return new ArrayList();
            case 4:
                return new ConcurrentSkipListMap();
            case 5:
                return new ConcurrentHashMap();
            case 6:
                return new TreeMap();
            case 7:
                return new LinkedHashMap();
            default:
                return new blj();
        }
    }
}
