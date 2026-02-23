package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class Status extends y4.a implements h, ReflectedParcelable {
    public final int f;
    public final String g;
    public final PendingIntent h;
    public final w4.b i;
    public static final Status j = new Status(-1);
    public static final Status k = new Status(0);
    public static final Status l = new Status(14);
    public static final Status m = new Status(8);
    public static final Status n = new Status(15);
    public static final Status o = new Status(16);
    public static final Status q = new Status(17);
    public static final Status p = new Status(18);
    public static final Parcelable.Creator CREATOR = new q();

    public Status(int i) {
        this(i, (String) null);
    }

    public w4.b H() {
        return this.i;
    }

    public int I() {
        return this.f;
    }

    public String J() {
        return this.g;
    }

    public boolean K() {
        return this.h != null;
    }

    public boolean L() {
        return this.f <= 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f == status.f && com.google.android.gms.common.internal.q.b(this.g, status.g) && com.google.android.gms.common.internal.q.b(this.h, status.h) && com.google.android.gms.common.internal.q.b(this.i, status.i);
    }

    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(Integer.valueOf(this.f), this.g, this.h, this.i);
    }

    public String toString() {
        q.a d = com.google.android.gms.common.internal.q.d(this);
        d.a("statusCode", zza());
        d.a("resolution", this.h);
        return d.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.l(parcel, 1, I());
        y4.c.t(parcel, 2, J(), false);
        y4.c.r(parcel, 3, this.h, i, false);
        y4.c.r(parcel, 4, H(), i, false);
        y4.c.b(parcel, a);
    }

    public final String zza() {
        String str = this.g;
        return str != null ? str : c.a(this.f);
    }

    public Status(int i, String str) {
        this(i, str, (PendingIntent) null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(i, str, pendingIntent, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent, w4.b bVar) {
        this.f = i;
        this.g = str;
        this.h = pendingIntent;
        this.i = bVar;
    }

    public Status(w4.b bVar, String str) {
        this(bVar, str, 17);
    }

    public Status(w4.b bVar, String str, int i) {
        this(i, str, bVar.J(), bVar);
    }
}
