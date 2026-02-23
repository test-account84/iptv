package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import n4.E0;
import t4.T;
import t4.U;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class CastDevice extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new E0();
    public final String f;
    public final String g;
    public InetAddress h;
    public final String i;
    public final String j;
    public final String k;
    public final int l;
    public final List m;
    public final int n;
    public final int o;
    public final String p;
    public final String q;
    public final int r;
    public final String s;
    public final byte[] t;
    public final String u;
    public final boolean v;
    public final U w;

    public CastDevice(String str, String str2, String str3, String str4, String str5, int i, List list, int i2, int i3, String str6, String str7, int i4, String str8, byte[] bArr, String str9, boolean z, U u) {
        this.f = S(str);
        String S = S(str2);
        this.g = S;
        if (!TextUtils.isEmpty(S)) {
            try {
                this.h = InetAddress.getByName(S);
            } catch (UnknownHostException e) {
                Log.i("CastDevice", "Unable to convert host address (" + this.g + ") to ipaddress: " + e.getMessage());
            }
        }
        this.i = S(str3);
        this.j = S(str4);
        this.k = S(str5);
        this.l = i;
        this.m = list == null ? new ArrayList() : list;
        this.n = i2;
        this.o = i3;
        this.p = S(str6);
        this.q = str7;
        this.r = i4;
        this.s = str8;
        this.t = bArr;
        this.u = str9;
        this.v = z;
        this.w = u;
    }

    public static CastDevice K(Bundle bundle) {
        ClassLoader classLoader;
        if (bundle == null || (classLoader = CastDevice.class.getClassLoader()) == null) {
            return null;
        }
        bundle.setClassLoader(classLoader);
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public static String S(String str) {
        return str == null ? "" : str;
    }

    public String H() {
        return this.f.startsWith("__cast_nearby__") ? this.f.substring(16) : this.f;
    }

    public String I() {
        return this.k;
    }

    public String J() {
        return this.i;
    }

    public List L() {
        return Collections.unmodifiableList(this.m);
    }

    public String M() {
        return this.j;
    }

    public int N() {
        return this.l;
    }

    public boolean O(int i) {
        return (this.n & i) == i;
    }

    public void P(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }

    public final int Q() {
        return this.n;
    }

    public final U R() {
        if (this.w == null) {
            boolean O = O(32);
            boolean O2 = O(64);
            if (O || O2) {
                return T.a(1);
            }
        }
        return this.w;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        String str = this.f;
        return str == null ? castDevice.f == null : t4.a.k(str, castDevice.f) && t4.a.k(this.h, castDevice.h) && t4.a.k(this.j, castDevice.j) && t4.a.k(this.i, castDevice.i) && t4.a.k(this.k, castDevice.k) && this.l == castDevice.l && t4.a.k(this.m, castDevice.m) && this.n == castDevice.n && this.o == castDevice.o && t4.a.k(this.p, castDevice.p) && t4.a.k(Integer.valueOf(this.r), Integer.valueOf(castDevice.r)) && t4.a.k(this.s, castDevice.s) && t4.a.k(this.q, castDevice.q) && t4.a.k(this.k, castDevice.I()) && this.l == castDevice.N() && (((bArr = this.t) == null && castDevice.t == null) || Arrays.equals(bArr, castDevice.t)) && t4.a.k(this.u, castDevice.u) && this.v == castDevice.v && t4.a.k(R(), castDevice.R());
    }

    public int hashCode() {
        String str = this.f;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        Locale locale = Locale.ROOT;
        String str = this.i;
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            str = length <= 2 ? length == 2 ? "xx" : "x" : String.format(locale, "%c%d%c", new Object[]{Character.valueOf(str.charAt(0)), Integer.valueOf(length - 2), Character.valueOf(str.charAt(length - 1))});
        }
        return String.format(locale, "\"%s\" (%s)", new Object[]{str, this.f});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.t(parcel, 2, this.f, false);
        c.t(parcel, 3, this.g, false);
        c.t(parcel, 4, J(), false);
        c.t(parcel, 5, M(), false);
        c.t(parcel, 6, I(), false);
        c.l(parcel, 7, N());
        c.x(parcel, 8, L(), false);
        c.l(parcel, 9, this.n);
        c.l(parcel, 10, this.o);
        c.t(parcel, 11, this.p, false);
        c.t(parcel, 12, this.q, false);
        c.l(parcel, 13, this.r);
        c.t(parcel, 14, this.s, false);
        c.f(parcel, 15, this.t, false);
        c.t(parcel, 16, this.u, false);
        c.c(parcel, 17, this.v);
        c.r(parcel, 18, R(), i, false);
        c.b(parcel, a);
    }

    public final String zzc() {
        return this.q;
    }
}
