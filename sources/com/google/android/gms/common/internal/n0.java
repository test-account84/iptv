package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n0 implements Parcelable.Creator {
    public static void a(g gVar, Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, gVar.f);
        y4.c.l(parcel, 2, gVar.g);
        y4.c.l(parcel, 3, gVar.h);
        y4.c.t(parcel, 4, gVar.i, false);
        y4.c.k(parcel, 5, gVar.j, false);
        y4.c.w(parcel, 6, gVar.k, i, false);
        y4.c.e(parcel, 7, gVar.l, false);
        y4.c.r(parcel, 8, gVar.m, i, false);
        y4.c.w(parcel, 10, gVar.n, i, false);
        y4.c.w(parcel, 11, gVar.o, i, false);
        y4.c.c(parcel, 12, gVar.p);
        y4.c.l(parcel, 13, gVar.q);
        y4.c.c(parcel, 14, gVar.r);
        y4.c.t(parcel, 15, gVar.zza(), false);
        y4.c.b(parcel, a);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int B = y4.b.B(parcel);
        Scope[] scopeArr = g.t;
        Bundle bundle = new Bundle();
        w4.d[] dVarArr = g.u;
        w4.d[] dVarArr2 = dVarArr;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < B) {
            int s = y4.b.s(parcel);
            switch (y4.b.l(s)) {
                case 1:
                    i = y4.b.u(parcel, s);
                    break;
                case 2:
                    i2 = y4.b.u(parcel, s);
                    break;
                case 3:
                    i3 = y4.b.u(parcel, s);
                    break;
                case 4:
                    str = y4.b.f(parcel, s);
                    break;
                case 5:
                    iBinder = y4.b.t(parcel, s);
                    break;
                case 6:
                    scopeArr = (Scope[]) y4.b.i(parcel, s, Scope.CREATOR);
                    break;
                case 7:
                    bundle = y4.b.a(parcel, s);
                    break;
                case 8:
                    account = (Account) y4.b.e(parcel, s, Account.CREATOR);
                    break;
                case 9:
                default:
                    y4.b.A(parcel, s);
                    break;
                case 10:
                    dVarArr = (w4.d[]) y4.b.i(parcel, s, w4.d.CREATOR);
                    break;
                case 11:
                    dVarArr2 = (w4.d[]) y4.b.i(parcel, s, w4.d.CREATOR);
                    break;
                case 12:
                    z = y4.b.m(parcel, s);
                    break;
                case 13:
                    i4 = y4.b.u(parcel, s);
                    break;
                case 14:
                    z2 = y4.b.m(parcel, s);
                    break;
                case 15:
                    str2 = y4.b.f(parcel, s);
                    break;
            }
        }
        y4.b.k(parcel, B);
        return new g(i, i2, i3, str, iBinder, scopeArr, bundle, account, dVarArr, dVarArr2, z, i4, z2, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new g[i];
    }
}
