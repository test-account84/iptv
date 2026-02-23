package U4;

import R4.i;
import R4.j;
import R4.k;
import R4.l;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import d4.d0;
import f5.u;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c {
    public final a a;
    public final a b;
    public final float c;
    public final float d;
    public final float e;

    public static final class a implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public int a;
        public Integer c;
        public Integer d;
        public int e;
        public int f;
        public int g;
        public Locale h;
        public CharSequence i;
        public int j;
        public int k;
        public Integer l;
        public Boolean m;
        public Integer n;
        public Integer o;
        public Integer p;
        public Integer q;
        public Integer r;
        public Integer s;

        public class a implements Parcelable.Creator {
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i) {
                return new a[i];
            }
        }

        public a() {
            this.e = 255;
            this.f = -2;
            this.g = -2;
            this.m = Boolean.TRUE;
        }

        public static /* synthetic */ Integer A(a aVar) {
            return aVar.r;
        }

        public static /* synthetic */ Integer C(a aVar, Integer num) {
            aVar.r = num;
            return num;
        }

        public static /* synthetic */ Integer G(a aVar) {
            return aVar.s;
        }

        public static /* synthetic */ Integer H(a aVar, Integer num) {
            aVar.s = num;
            return num;
        }

        public static /* synthetic */ Locale I(a aVar) {
            return aVar.h;
        }

        public static /* synthetic */ Locale J(a aVar, Locale locale) {
            aVar.h = locale;
            return locale;
        }

        public static /* synthetic */ CharSequence K(a aVar) {
            return aVar.i;
        }

        public static /* synthetic */ CharSequence L(a aVar, CharSequence charSequence) {
            aVar.i = charSequence;
            return charSequence;
        }

        public static /* synthetic */ int M(a aVar) {
            return aVar.j;
        }

        public static /* synthetic */ int N(a aVar, int i) {
            aVar.j = i;
            return i;
        }

        public static /* synthetic */ int O(a aVar) {
            return aVar.k;
        }

        public static /* synthetic */ int P(a aVar, int i) {
            aVar.k = i;
            return i;
        }

        public static /* synthetic */ Boolean Q(a aVar) {
            return aVar.m;
        }

        public static /* synthetic */ Boolean R(a aVar, Boolean bool) {
            aVar.m = bool;
            return bool;
        }

        public static /* synthetic */ int S(a aVar) {
            return aVar.g;
        }

        public static /* synthetic */ int T(a aVar, int i) {
            aVar.g = i;
            return i;
        }

        public static /* synthetic */ int U(a aVar) {
            return aVar.f;
        }

        public static /* synthetic */ int V(a aVar, int i) {
            aVar.f = i;
            return i;
        }

        public static /* synthetic */ Integer W(a aVar) {
            return aVar.c;
        }

        public static /* synthetic */ Integer X(a aVar, Integer num) {
            aVar.c = num;
            return num;
        }

        public static /* synthetic */ Integer Y(a aVar) {
            return aVar.d;
        }

        public static /* synthetic */ Integer Z(a aVar, Integer num) {
            aVar.d = num;
            return num;
        }

        public static /* synthetic */ int a(a aVar) {
            return aVar.a;
        }

        public static /* synthetic */ int c(a aVar, int i) {
            aVar.a = i;
            return i;
        }

        public static /* synthetic */ int d(a aVar) {
            return aVar.e;
        }

        public static /* synthetic */ Integer e(a aVar) {
            return aVar.l;
        }

        public static /* synthetic */ Integer f(a aVar, Integer num) {
            aVar.l = num;
            return num;
        }

        public static /* synthetic */ int g(a aVar, int i) {
            aVar.e = i;
            return i;
        }

        public static /* synthetic */ Integer h(a aVar) {
            return aVar.n;
        }

        public static /* synthetic */ Integer k(a aVar, Integer num) {
            aVar.n = num;
            return num;
        }

        public static /* synthetic */ Integer m(a aVar) {
            return aVar.o;
        }

        public static /* synthetic */ Integer r(a aVar, Integer num) {
            aVar.o = num;
            return num;
        }

        public static /* synthetic */ Integer t(a aVar) {
            return aVar.p;
        }

        public static /* synthetic */ Integer v(a aVar, Integer num) {
            aVar.p = num;
            return num;
        }

        public static /* synthetic */ Integer w(a aVar) {
            return aVar.q;
        }

        public static /* synthetic */ Integer x(a aVar, Integer num) {
            aVar.q = num;
            return num;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeSerializable(this.c);
            parcel.writeSerializable(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            CharSequence charSequence = this.i;
            parcel.writeString(charSequence == null ? null : charSequence.toString());
            parcel.writeInt(this.j);
            parcel.writeSerializable(this.l);
            parcel.writeSerializable(this.n);
            parcel.writeSerializable(this.o);
            parcel.writeSerializable(this.p);
            parcel.writeSerializable(this.q);
            parcel.writeSerializable(this.r);
            parcel.writeSerializable(this.s);
            parcel.writeSerializable(this.m);
            parcel.writeSerializable(this.h);
        }

        public a(Parcel parcel) {
            this.e = 255;
            this.f = -2;
            this.g = -2;
            this.m = Boolean.TRUE;
            this.a = parcel.readInt();
            this.c = parcel.readSerializable();
            this.d = parcel.readSerializable();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.i = parcel.readString();
            this.j = parcel.readInt();
            this.l = parcel.readSerializable();
            this.n = parcel.readSerializable();
            this.o = parcel.readSerializable();
            this.p = parcel.readSerializable();
            this.q = parcel.readSerializable();
            this.r = parcel.readSerializable();
            this.s = parcel.readSerializable();
            this.m = parcel.readSerializable();
            this.h = parcel.readSerializable();
        }
    }

    public c(Context context, int i, int i2, int i3, a aVar) {
        Integer valueOf;
        a aVar2 = new a();
        this.b = aVar2;
        aVar = aVar == null ? new a() : aVar;
        if (i != 0) {
            a.c(aVar, i);
        }
        TypedArray a2 = a(context, a.a(aVar), i2, i3);
        Resources resources = context.getResources();
        this.c = a2.getDimensionPixelSize(l.G, resources.getDimensionPixelSize(R4.d.C));
        this.e = a2.getDimensionPixelSize(l.I, resources.getDimensionPixelSize(R4.d.B));
        this.d = a2.getDimensionPixelSize(l.J, resources.getDimensionPixelSize(R4.d.E));
        a.g(aVar2, a.d(aVar) == -2 ? 255 : a.d(aVar));
        a.L(aVar2, a.K(aVar) == null ? context.getString(j.i) : a.K(aVar));
        a.N(aVar2, a.M(aVar) == 0 ? i.a : a.M(aVar));
        a.P(aVar2, a.O(aVar) == 0 ? j.k : a.O(aVar));
        a.R(aVar2, Boolean.valueOf(a.Q(aVar) == null || a.Q(aVar).booleanValue()));
        a.T(aVar2, a.S(aVar) == -2 ? a2.getInt(l.M, 4) : a.S(aVar));
        a.V(aVar2, a.U(aVar) != -2 ? a.U(aVar) : a2.hasValue(l.N) ? a2.getInt(l.N, 0) : -1);
        a.X(aVar2, Integer.valueOf(a.W(aVar) == null ? t(context, a2, l.E) : a.W(aVar).intValue()));
        if (a.Y(aVar) != null) {
            valueOf = a.Y(aVar);
        } else {
            valueOf = Integer.valueOf(a2.hasValue(l.H) ? t(context, a2, l.H) : new i5.d(context, k.c).i().getDefaultColor());
        }
        a.Z(aVar2, valueOf);
        a.f(aVar2, Integer.valueOf(a.e(aVar) == null ? a2.getInt(l.F, 8388661) : a.e(aVar).intValue()));
        a.k(aVar2, Integer.valueOf(a.h(aVar) == null ? a2.getDimensionPixelOffset(l.K, 0) : a.h(aVar).intValue()));
        a.r(aVar2, Integer.valueOf(a.h(aVar) == null ? a2.getDimensionPixelOffset(l.O, 0) : a.m(aVar).intValue()));
        a.v(aVar2, Integer.valueOf(a.t(aVar) == null ? a2.getDimensionPixelOffset(l.L, a.h(aVar2).intValue()) : a.t(aVar).intValue()));
        a.x(aVar2, Integer.valueOf(a.w(aVar) == null ? a2.getDimensionPixelOffset(l.P, a.m(aVar2).intValue()) : a.w(aVar).intValue()));
        a.C(aVar2, Integer.valueOf(a.A(aVar) == null ? 0 : a.A(aVar).intValue()));
        a.H(aVar2, Integer.valueOf(a.G(aVar) != null ? a.G(aVar).intValue() : 0));
        a2.recycle();
        a.J(aVar2, a.I(aVar) == null ? Build.VERSION.SDK_INT >= 24 ? d0.a(b.a()) : Locale.getDefault() : a.I(aVar));
        this.a = aVar;
    }

    public static int t(Context context, TypedArray typedArray, int i) {
        return i5.c.a(context, typedArray, i).getDefaultColor();
    }

    public final TypedArray a(Context context, int i, int i2, int i3) {
        AttributeSet attributeSet;
        int i4;
        if (i != 0) {
            AttributeSet a2 = b5.a.a(context, i, "badge");
            i4 = a2.getStyleAttribute();
            attributeSet = a2;
        } else {
            attributeSet = null;
            i4 = 0;
        }
        return u.h(context, attributeSet, l.D, i2, i4 == 0 ? i3 : i4, new int[0]);
    }

    public int b() {
        return a.A(this.b).intValue();
    }

    public int c() {
        return a.G(this.b).intValue();
    }

    public int d() {
        return a.d(this.b);
    }

    public int e() {
        return a.W(this.b).intValue();
    }

    public int f() {
        return a.e(this.b).intValue();
    }

    public int g() {
        return a.Y(this.b).intValue();
    }

    public int h() {
        return a.O(this.b);
    }

    public CharSequence i() {
        return a.K(this.b);
    }

    public int j() {
        return a.M(this.b);
    }

    public int k() {
        return a.t(this.b).intValue();
    }

    public int l() {
        return a.h(this.b).intValue();
    }

    public int m() {
        return a.S(this.b);
    }

    public int n() {
        return a.U(this.b);
    }

    public Locale o() {
        return a.I(this.b);
    }

    public int p() {
        return a.w(this.b).intValue();
    }

    public int q() {
        return a.m(this.b).intValue();
    }

    public boolean r() {
        return a.U(this.b) != -1;
    }

    public boolean s() {
        return a.Q(this.b).booleanValue();
    }

    public void u(int i) {
        a.g(this.a, i);
        a.g(this.b, i);
    }
}
