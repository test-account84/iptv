package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class brf extends brh {
    private static final Class a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private brf() {
    }

    public static List a(Object obj, long j) {
        return (List) btf.h(obj, j);
    }

    private static List g(Object obj, long j, int i) {
        ArrayList brdVar;
        Collection a2 = a(obj, j);
        if (a2.isEmpty()) {
            bqt brdVar2 = a2 instanceof bre ? new brd(i) : ((a2 instanceof brz) && (a2 instanceof bqt)) ? ((bqt) a2).d(i) : new ArrayList(i);
            btf.w(obj, j, brdVar2);
            return brdVar2;
        }
        if (a.isAssignableFrom(a2.getClass())) {
            brdVar = new ArrayList(a2.size() + i);
            brdVar.addAll(a2);
        } else {
            if (!(a2 instanceof bta)) {
                if (!(a2 instanceof brz) || !(a2 instanceof bqt)) {
                    return a2;
                }
                bqt bqtVar = (bqt) a2;
                if (bqtVar.c()) {
                    return a2;
                }
                bqt d = bqtVar.d(a2.size() + i);
                btf.w(obj, j, d);
                return d;
            }
            brdVar = new brd(a2.size() + i);
            brdVar.addAll((bta) a2);
        }
        btf.w(obj, j, brdVar);
        return brdVar;
    }

    public final List b(Object obj, long j) {
        return g(obj, j, 10);
    }

    public final void c(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) btf.h(obj, j);
        if (list instanceof bre) {
            unmodifiableList = ((bre) list).e();
        } else {
            if (a.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof brz) && (list instanceof bqt)) {
                bqt bqtVar = (bqt) list;
                if (bqtVar.c()) {
                    bqtVar.b();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        btf.w(obj, j, unmodifiableList);
    }

    public final void d(Object obj, Object obj2, long j) {
        List a2 = a(obj2, j);
        List g = g(obj, j, a2.size());
        int size = g.size();
        int size2 = a2.size();
        if (size > 0 && size2 > 0) {
            g.addAll(a2);
        }
        if (size > 0) {
            a2 = g;
        }
        btf.w(obj, j, a2);
    }

    public /* synthetic */ brf(byte[] bArr) {
    }
}
