package x7;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public static a F;
    public boolean A;
    public boolean B;
    public String C;
    public int D;
    public String E;
    public HashSet a;
    public boolean c;
    public Uri d;
    public String e;
    public boolean f;
    public String g;
    public int h;
    public String i;
    public Uri j;
    public int k;
    public int l;
    public String m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public long s;
    public int t;
    public int u;
    public String v;
    public ArrayList w;
    public List x;
    public String y;
    public boolean z;

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
        this.a = new HashSet();
        this.c = false;
        this.e = "12345";
        this.f = true;
        this.h = 0;
        this.k = 0;
        this.l = -16777216;
        this.m = "ijk";
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = false;
        this.r = 0;
        this.t = 0;
        this.z = false;
        this.A = false;
        this.B = false;
    }

    public static a f() {
        if (F == null) {
            F = new a();
        }
        return F;
    }

    public a A(String str) {
        this.E = str;
        return this;
    }

    public a C(int i) {
        this.D = i;
        return this;
    }

    public a G(int i) {
        this.u = i;
        return this;
    }

    public a H(String str) {
        this.v = str;
        return this;
    }

    public a I(long j) {
        this.s = j;
        return this;
    }

    public String a() {
        return this.y;
    }

    public ArrayList c() {
        return this.w;
    }

    public int d() {
        return this.r;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.C;
    }

    public String g() {
        return this.E;
    }

    public int h() {
        return this.D;
    }

    public int k() {
        return this.u;
    }

    public String m() {
        return this.v;
    }

    public a r(String str) {
        this.y = str;
        return this;
    }

    public a t(ArrayList arrayList) {
        this.w = arrayList;
        return this;
    }

    public a v(List list) {
        this.x = list;
        return this;
    }

    public a w(int i) {
        this.r = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.e);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.g);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeParcelable(this.j, i);
        parcel.writeSerializable(this.a);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.p ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
    }

    public a x(String str) {
        this.C = str;
        return this;
    }

    public a(Parcel parcel) {
        this.a = new HashSet();
        this.c = false;
        this.e = "12345";
        this.f = true;
        this.h = 0;
        this.k = 0;
        this.l = -16777216;
        this.m = "ijk";
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = false;
        this.r = 0;
        this.t = 0;
        this.z = false;
        this.A = false;
        this.B = false;
        this.e = parcel.readString();
        this.d = parcel.readParcelable(Uri.class.getClassLoader());
        this.g = parcel.readString();
        this.f = parcel.readByte() != 0;
        this.h = parcel.readInt();
        this.i = parcel.readString();
        this.j = parcel.readParcelable(Uri.class.getClassLoader());
        this.a = parcel.readSerializable();
        this.c = parcel.readByte() != 0;
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readByte() != 0;
        this.o = parcel.readByte() != 0;
        this.p = parcel.readByte() != 0;
        this.q = parcel.readByte() != 0;
    }
}
