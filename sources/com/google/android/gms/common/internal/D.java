package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d extends y4.a {
    public static final Parcelable.Creator CREATOR = new z();
    public final int f;
    public final String g;

    public d(int i, String str) {
        this.f = i;
        this.g = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f == this.f && q.b(dVar.g, this.g);
    }

    public final int hashCode() {
        return this.f;
    }

    public final String toString() {
        return this.f + ":" + this.g;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f;
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, i2);
        y4.c.t(parcel, 2, this.g, false);
        y4.c.b(parcel, a);
    }
}
