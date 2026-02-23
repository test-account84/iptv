package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class Scope extends y4.a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new p();
    public final int f;
    public final String g;

    public Scope(int i, String str) {
        r.h(str, "scopeUri must not be null or empty");
        this.f = i;
        this.g = str;
    }

    public String H() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.g.equals(((Scope) obj).g);
        }
        return false;
    }

    public int hashCode() {
        return this.g.hashCode();
    }

    public String toString() {
        return this.g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f;
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, i2);
        y4.c.t(parcel, 2, H(), false);
        y4.c.b(parcel, a);
    }

    public Scope(String str) {
        this(1, str);
    }
}
