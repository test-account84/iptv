package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class awy implements Comparator {
    public static awy b(Comparator comparator) {
        return comparator instanceof awy ? (awy) comparator : new auq(comparator);
    }

    public static awy c() {
        return awx.a;
    }

    public awy a() {
        return new axi(this);
    }

    public abstract int compare(Object obj, Object obj2);

    public final awy d(ati atiVar) {
        return new auo(atiVar, this);
    }

    public final List e(Iterable iterable) {
        Object[] A = axo.A(iterable);
        Arrays.sort(A, this);
        List asList = Arrays.asList(A);
        atp.k(asList);
        return asList instanceof Collection ? new ArrayList(asList) : axo.t(asList.iterator());
    }
}
