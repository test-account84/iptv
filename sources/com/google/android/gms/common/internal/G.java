package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g extends y4.a {
    public static final Parcelable.Creator CREATOR = new n0();
    public static final Scope[] t = new Scope[0];
    public static final w4.d[] u = new w4.d[0];
    public final int f;
    public final int g;
    public final int h;
    public String i;
    public IBinder j;
    public Scope[] k;
    public Bundle l;
    public Account m;
    public w4.d[] n;
    public w4.d[] o;
    public final boolean p;
    public final int q;
    public boolean r;
    public final String s;

    public g(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, w4.d[] dVarArr, w4.d[] dVarArr2, boolean z, int i4, boolean z2, String str2) {
        scopeArr = scopeArr == null ? t : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        dVarArr = dVarArr == null ? u : dVarArr;
        dVarArr2 = dVarArr2 == null ? u : dVarArr2;
        this.f = i;
        this.g = i2;
        this.h = i3;
        if ("com.google.android.gms".equals(str)) {
            this.i = "com.google.android.gms";
        } else {
            this.i = str;
        }
        if (i < 2) {
            this.m = iBinder != null ? a.E(k.a.A(iBinder)) : null;
        } else {
            this.j = iBinder;
            this.m = account;
        }
        this.k = scopeArr;
        this.l = bundle;
        this.n = dVarArr;
        this.o = dVarArr2;
        this.p = z;
        this.q = i4;
        this.r = z2;
        this.s = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        n0.a(this, parcel, i);
    }

    public final String zza() {
        return this.s;
    }
}
