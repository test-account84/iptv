package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a1 implements Runnable {
    public final Y0 a;
    public final /* synthetic */ b1 c;

    public a1(b1 b1Var, Y0 y0) {
        this.c = b1Var;
        this.a = y0;
    }

    public final void run() {
        if (this.c.a) {
            w4.b b = this.a.b();
            if (b.K()) {
                b1 b1Var = this.c;
                b1Var.mLifecycleFragment.startActivityForResult(GoogleApiActivity.a(b1Var.getActivity(), (PendingIntent) com.google.android.gms.common.internal.r.m(b.J()), this.a.a(), false), 1);
                return;
            }
            b1 b1Var2 = this.c;
            if (b1Var2.e.d(b1Var2.getActivity(), b.H(), null) != null) {
                b1 b1Var3 = this.c;
                b1Var3.e.z(b1Var3.getActivity(), b1Var3.mLifecycleFragment, b.H(), 2, this.c);
                return;
            }
            if (b.H() != 18) {
                b1.f(this.c, b, this.a.a());
                return;
            }
            b1 b1Var4 = this.c;
            Dialog u = b1Var4.e.u(b1Var4.getActivity(), b1Var4);
            b1 b1Var5 = this.c;
            b1Var5.e.v(b1Var5.getActivity().getApplicationContext(), new Z0(this, u));
        }
    }
}
