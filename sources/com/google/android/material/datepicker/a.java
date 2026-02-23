package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final l a;
    public final l c;
    public final c d;
    public l e;
    public final int f;
    public final int g;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a((l) parcel.readParcelable(l.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public static final class b {
        public static final long e = v.a(l.c(1900, 0).g);
        public static final long f = v.a(l.c(2100, 11).g);
        public long a;
        public long b;
        public Long c;
        public c d;

        public b(a aVar) {
            this.a = e;
            this.b = f;
            this.d = g.a(Long.MIN_VALUE);
            this.a = a.a(aVar).g;
            this.b = a.c(aVar).g;
            this.c = Long.valueOf(a.d(aVar).g);
            this.d = a.e(aVar);
        }

        public a a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.d);
            l d = l.d(this.a);
            l d2 = l.d(this.b);
            c cVar = (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l = this.c;
            return new a(d, d2, cVar, l == null ? null : l.d(l.longValue()), null);
        }

        public b b(long j) {
            this.c = Long.valueOf(j);
            return this;
        }
    }

    public interface c extends Parcelable {
        boolean b(long j);
    }

    public a(l lVar, l lVar2, c cVar, l lVar3) {
        this.a = lVar;
        this.c = lVar2;
        this.e = lVar3;
        this.d = cVar;
        if (lVar3 != null && lVar.a(lVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (lVar3 != null && lVar3.a(lVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.g = lVar.C(lVar2) + 1;
        this.f = (lVar2.d - lVar.d) + 1;
    }

    public static /* synthetic */ l a(a aVar) {
        return aVar.a;
    }

    public static /* synthetic */ l c(a aVar) {
        return aVar.c;
    }

    public static /* synthetic */ l d(a aVar) {
        return aVar.e;
    }

    public static /* synthetic */ c e(a aVar) {
        return aVar.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.c.equals(aVar.c) && O.c.a(this.e, aVar.e) && this.d.equals(aVar.d);
    }

    public c f() {
        return this.d;
    }

    public l g() {
        return this.c;
    }

    public int h() {
        return this.g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.c, this.e, this.d});
    }

    public l k() {
        return this.e;
    }

    public l m() {
        return this.a;
    }

    public int r() {
        return this.f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeParcelable(this.e, 0);
        parcel.writeParcelable(this.d, 0);
    }

    public /* synthetic */ a(l lVar, l lVar2, c cVar, l lVar3, a aVar) {
        this(lVar, lVar2, cVar, lVar3);
    }
}
