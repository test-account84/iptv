package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bju {
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final bkj j;
    private final bkj k;
    private final LinkedList l;
    private bky a = bky.a;
    private final int m = bkg.a;
    private final bjm b = bjl.IDENTITY;
    private final Map c = new HashMap();
    private final List d = new ArrayList();
    private final List e = new ArrayList();

    public bju() {
        int i = bjt.e;
        this.f = 2;
        this.g = 2;
        this.h = true;
        this.i = true;
        this.j = bjt.a;
        this.k = bjt.b;
        this.l = new LinkedList();
    }

    public final bjt a() {
        ArrayList arrayList = new ArrayList(this.d.size() + this.e.size() + 3);
        arrayList.addAll(this.d);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.e);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        boolean z = boe.a;
        bky bkyVar = this.a;
        bjm bjmVar = this.b;
        HashMap hashMap = new HashMap(this.c);
        int i = this.m;
        new ArrayList(this.d);
        new ArrayList(this.e);
        return new bjt(bkyVar, bjmVar, hashMap, true, true, i, arrayList, this.j, this.k, new ArrayList(this.l));
    }

    public final void b(Type type, Object obj) {
        boolean z = obj instanceof bke;
        boolean z2 = true;
        if (!z && !(obj instanceof bjx) && !(obj instanceof bjv) && !(obj instanceof bkl)) {
            z2 = false;
        }
        bjh.d(z2);
        if (obj instanceof bjv) {
            this.c.put(type, (bjv) obj);
        }
        if (z || (obj instanceof bjx)) {
            this.d.add(bmo.a(bof.b(type), obj));
        }
        if (obj instanceof bkl) {
            this.d.add(bnw.a(bof.b(type), (bkl) obj));
        }
    }

    public final void c(bkm bkmVar) {
        this.d.add(bkmVar);
    }

    public final void d(com.google.ads.interactivemedia.v3.impl.data.k kVar) {
        this.a = this.a.e(kVar);
    }
}
