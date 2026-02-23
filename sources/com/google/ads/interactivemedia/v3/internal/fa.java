package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Looper;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class fa {
    final Context a;
    final bn b;
    final atq c;
    final atq d;
    final atq e;
    final atq f;
    final atq g;
    final ati h;
    final Looper i;
    final f j;
    final int k;
    final boolean l;
    final hl m;
    final long n;
    final long o;
    final long p;
    final long q;
    final boolean r;
    boolean s;
    final er t;

    public fa(Context context, hk hkVar) {
        ex exVar = new ex(hkVar, 1);
        ex exVar2 = new ex(context, 0);
        ex exVar3 = new ex(context, 2);
        ey eyVar = ey.a;
        ex exVar4 = new ex(context, 3);
        ez ezVar = ez.a;
        af.s(context);
        this.a = context;
        this.c = exVar;
        this.d = exVar2;
        this.e = exVar3;
        this.f = eyVar;
        this.g = exVar4;
        this.h = ezVar;
        this.i = cq.D();
        this.j = f.a;
        this.k = 1;
        this.l = true;
        this.m = hl.b;
        this.n = 5000L;
        this.o = 15000L;
        this.t = fz.a(0.97f, 1.03f, 1000L, 1.0E-7f, cq.t(20L), cq.t(500L), 0.999f);
        this.b = bn.a;
        this.p = 500L;
        this.q = 2000L;
        this.r = true;
    }
}
