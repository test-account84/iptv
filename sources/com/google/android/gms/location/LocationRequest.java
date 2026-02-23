package com.google.android.gms.location;

import J4.E;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import y4.a;
import y4.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class LocationRequest extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new E();
    public int f;
    public long g;
    public long h;
    public boolean i;
    public long j;
    public int k;
    public float l;
    public long m;
    public boolean n;

    @Deprecated
    public LocationRequest() {
        this.f = 102;
        this.g = 3600000L;
        this.h = 600000L;
        this.i = false;
        this.j = Long.MAX_VALUE;
        this.k = Integer.MAX_VALUE;
        this.l = 0.0f;
        this.m = 0L;
        this.n = false;
    }

    public static LocationRequest H() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.O(true);
        return locationRequest;
    }

    public static void P(long j) {
        if (j >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("invalid interval: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public long I() {
        return this.g;
    }

    public long J() {
        long j = this.m;
        long j2 = this.g;
        return j < j2 ? j2 : j;
    }

    public LocationRequest K(long j) {
        P(j);
        this.i = true;
        this.h = j;
        return this;
    }

    public LocationRequest L(long j) {
        P(j);
        this.g = j;
        if (!this.i) {
            this.h = (long) (j / 6.0d);
        }
        return this;
    }

    public LocationRequest M(long j) {
        P(j);
        this.m = j;
        return this;
    }

    public LocationRequest N(int i) {
        if (i == 100 || i == 102 || i == 104 || i == 105) {
            this.f = i;
            return this;
        }
        StringBuilder sb = new StringBuilder(28);
        sb.append("invalid quality: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public LocationRequest O(boolean z) {
        this.n = z;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.f == locationRequest.f && this.g == locationRequest.g && this.h == locationRequest.h && this.i == locationRequest.i && this.j == locationRequest.j && this.k == locationRequest.k && this.l == locationRequest.l && J() == locationRequest.J() && this.n == locationRequest.n) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return q.c(Integer.valueOf(this.f), Long.valueOf(this.g), Float.valueOf(this.l), Long.valueOf(this.m));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        int i = this.f;
        sb.append(i != 100 ? i != 102 ? i != 104 ? i != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f != 105) {
            sb.append(" requested=");
            sb.append(this.g);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.h);
        sb.append("ms");
        if (this.m > this.g) {
            sb.append(" maxWait=");
            sb.append(this.m);
            sb.append("ms");
        }
        if (this.l > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.l);
            sb.append("m");
        }
        long j = this.j;
        if (j != Long.MAX_VALUE) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j - elapsedRealtime);
            sb.append("ms");
        }
        if (this.k != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.k);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = c.a(parcel);
        c.l(parcel, 1, this.f);
        c.o(parcel, 2, this.g);
        c.o(parcel, 3, this.h);
        c.c(parcel, 4, this.i);
        c.o(parcel, 5, this.j);
        c.l(parcel, 6, this.k);
        c.i(parcel, 7, this.l);
        c.o(parcel, 8, this.m);
        c.c(parcel, 9, this.n);
        c.b(parcel, a);
    }

    public LocationRequest(int i, long j, long j2, boolean z, long j3, int i2, float f, long j4, boolean z2) {
        this.f = i;
        this.g = j;
        this.h = j2;
        this.i = z;
        this.j = j3;
        this.k = i2;
        this.l = f;
        this.m = j4;
        this.n = z2;
    }
}
