package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l implements Comparable, Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final Calendar a;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final long g;
    public String h;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return l.c(parcel.readInt(), parcel.readInt());
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i) {
            return new l[i];
        }
    }

    public l(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d = v.d(calendar);
        this.a = d;
        this.c = d.get(2);
        this.d = d.get(1);
        this.e = d.getMaximum(7);
        this.f = d.getActualMaximum(5);
        this.g = d.getTimeInMillis();
    }

    public static l c(int i, int i2) {
        Calendar k = v.k();
        k.set(1, i);
        k.set(2, i2);
        return new l(k);
    }

    public static l d(long j) {
        Calendar k = v.k();
        k.setTimeInMillis(j);
        return new l(k);
    }

    public static l h() {
        return new l(v.i());
    }

    public l A(int i) {
        Calendar d = v.d(this.a);
        d.add(2, i);
        return new l(d);
    }

    public int C(l lVar) {
        if (this.a instanceof GregorianCalendar) {
            return ((lVar.d - this.d) * 12) + (lVar.c - this.c);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(l lVar) {
        return this.a.compareTo(lVar.a);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.c == lVar.c && this.d == lVar.d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }

    public int r() {
        int firstDayOfWeek = this.a.get(7) - this.a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.e : firstDayOfWeek;
    }

    public long t(int i) {
        Calendar d = v.d(this.a);
        d.set(5, i);
        return d.getTimeInMillis();
    }

    public int v(long j) {
        Calendar d = v.d(this.a);
        d.setTimeInMillis(j);
        return d.get(5);
    }

    public String w() {
        if (this.h == null) {
            this.h = f.c(this.a.getTimeInMillis());
        }
        return this.h;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.d);
        parcel.writeInt(this.c);
    }

    public long x() {
        return this.a.getTimeInMillis();
    }
}
