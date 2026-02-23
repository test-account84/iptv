package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class vt extends bh {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final SparseArray g;
    private final SparseBooleanArray h;

    @Deprecated
    public vt() {
        this.g = new SparseArray();
        this.h = new SparseBooleanArray();
        C();
    }

    public static /* bridge */ /* synthetic */ boolean A(vt vtVar) {
        return vtVar.e;
    }

    public static /* bridge */ /* synthetic */ boolean B(vt vtVar) {
        return vtVar.a;
    }

    private final void C() {
        this.a = true;
        this.b = true;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = true;
    }

    public static /* bridge */ /* synthetic */ SparseArray t(vt vtVar) {
        return vtVar.g;
    }

    public static /* bridge */ /* synthetic */ SparseBooleanArray u(vt vtVar) {
        return vtVar.h;
    }

    public static /* bridge */ /* synthetic */ boolean w(vt vtVar) {
        return vtVar.f;
    }

    public static /* bridge */ /* synthetic */ boolean x(vt vtVar) {
        return vtVar.b;
    }

    public static /* bridge */ /* synthetic */ boolean y(vt vtVar) {
        return vtVar.d;
    }

    public static /* bridge */ /* synthetic */ boolean z(vt vtVar) {
        return vtVar.c;
    }

    public final /* synthetic */ void q(Context context) {
        super.q(context);
    }

    public final /* bridge */ /* synthetic */ bh r(int i, int i2) {
        super.r(i, i2);
        return this;
    }

    public final /* bridge */ /* synthetic */ void s(Context context) {
        super.s(context);
    }

    public final vu v() {
        return new vu(this);
    }

    public vt(Context context) {
        q(context);
        s(context);
        this.g = new SparseArray();
        this.h = new SparseBooleanArray();
        C();
    }
}
