package t4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e extends y4.a {
    public static final Parcelable.Creator CREATOR = new f();
    public double f;
    public boolean g;
    public int h;
    public n4.d i;
    public int j;
    public n4.A k;
    public double l;

    public e(double d, boolean z, int i, n4.d dVar, int i2, n4.A a, double d2) {
        this.f = d;
        this.g = z;
        this.h = i;
        this.i = dVar;
        this.j = i2;
        this.k = a;
        this.l = d2;
    }

    public final double H() {
        return this.l;
    }

    public final double I() {
        return this.f;
    }

    public final int J() {
        return this.h;
    }

    public final int K() {
        return this.j;
    }

    public final n4.d L() {
        return this.i;
    }

    public final n4.A M() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f == eVar.f && this.g == eVar.g && this.h == eVar.h && a.k(this.i, eVar.i) && this.j == eVar.j) {
            n4.A a = this.k;
            if (a.k(a, a) && this.l == eVar.l) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.c(Double.valueOf(this.f), Boolean.valueOf(this.g), Integer.valueOf(this.h), this.i, Integer.valueOf(this.j), this.k, Double.valueOf(this.l));
    }

    public final String toString() {
        return String.format(Locale.ROOT, "volume=%f", new Object[]{Double.valueOf(this.f)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = y4.c.a(parcel);
        y4.c.g(parcel, 2, this.f);
        y4.c.c(parcel, 3, this.g);
        y4.c.l(parcel, 4, this.h);
        y4.c.r(parcel, 5, this.i, i, false);
        y4.c.l(parcel, 6, this.j);
        y4.c.r(parcel, 7, this.k, i, false);
        y4.c.g(parcel, 8, this.l);
        y4.c.b(parcel, a);
    }

    public final boolean zzg() {
        return this.g;
    }
}
