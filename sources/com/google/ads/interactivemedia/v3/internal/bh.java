package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class bh {
    private int a = Integer.MAX_VALUE;
    private int b = Integer.MAX_VALUE;
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = Integer.MAX_VALUE;
    private int f = Integer.MAX_VALUE;
    private boolean g = true;
    private avo h = avo.o();
    private avo i = avo.o();
    private int j = Integer.MAX_VALUE;
    private int k = Integer.MAX_VALUE;
    private avo l = avo.o();
    private avo m = avo.o();
    private int n = 0;
    private HashMap o = new HashMap();
    private HashSet p = new HashSet();

    @Deprecated
    public bh() {
    }

    public static /* bridge */ /* synthetic */ int a(bh bhVar) {
        return bhVar.k;
    }

    public static /* bridge */ /* synthetic */ int b(bh bhVar) {
        return bhVar.j;
    }

    public static /* bridge */ /* synthetic */ int c(bh bhVar) {
        return bhVar.d;
    }

    public static /* bridge */ /* synthetic */ int d(bh bhVar) {
        return bhVar.c;
    }

    public static /* bridge */ /* synthetic */ int e(bh bhVar) {
        return bhVar.b;
    }

    public static /* bridge */ /* synthetic */ int f(bh bhVar) {
        return bhVar.a;
    }

    public static /* bridge */ /* synthetic */ int g(bh bhVar) {
        return bhVar.n;
    }

    public static /* bridge */ /* synthetic */ int h(bh bhVar) {
        return bhVar.f;
    }

    public static /* bridge */ /* synthetic */ int i(bh bhVar) {
        return bhVar.e;
    }

    public static /* bridge */ /* synthetic */ avo j(bh bhVar) {
        return bhVar.i;
    }

    public static /* bridge */ /* synthetic */ avo k(bh bhVar) {
        return bhVar.l;
    }

    public static /* bridge */ /* synthetic */ avo l(bh bhVar) {
        return bhVar.m;
    }

    public static /* bridge */ /* synthetic */ avo m(bh bhVar) {
        return bhVar.h;
    }

    public static /* bridge */ /* synthetic */ HashMap n(bh bhVar) {
        return bhVar.o;
    }

    public static /* bridge */ /* synthetic */ HashSet o(bh bhVar) {
        return bhVar.p;
    }

    public static /* bridge */ /* synthetic */ boolean p(bh bhVar) {
        return bhVar.g;
    }

    public void q(Context context) {
        CaptioningManager captioningManager;
        int i = cq.a;
        if (i >= 19) {
            if ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.n = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.m = avo.p(cq.O(locale));
                }
            }
        }
    }

    public bh r(int i, int i2) {
        this.e = i;
        this.f = i2;
        this.g = true;
        return this;
    }

    public void s(Context context) {
        Point y = cq.y(context);
        r(y.x, y.y);
    }
}
