package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class bw implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    private final /* synthetic */ int d;

    public /* synthetic */ bw(nn nnVar, no noVar, int i, int i2) {
        this.d = i2;
        this.c = nnVar;
        this.b = noVar;
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.ads.interactivemedia.v3.internal.bx, java.lang.Object] */
    public final void run() {
        if (this.d != 0) {
            Object obj = this.c;
            ?? r1 = this.b;
            int i = this.a;
            r1.ap();
            nn nnVar = (nn) obj;
            r1.am(nnVar.a, nnVar.b, i);
            return;
        }
        Object obj2 = this.b;
        int i2 = this.a;
        ?? r2 = this.c;
        Iterator it = ((CopyOnWriteArraySet) obj2).iterator();
        while (it.hasNext()) {
            ((bz) it.next()).a(i2, r2);
        }
    }

    public /* synthetic */ bw(CopyOnWriteArraySet copyOnWriteArraySet, int i, bx bxVar, int i2) {
        this.d = i2;
        this.b = copyOnWriteArraySet;
        this.a = i;
        this.c = bxVar;
    }
}
