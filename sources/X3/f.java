package x3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.M;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f extends x3.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final List a;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel, null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i) {
            return new f[i];
        }
    }

    public static final class b {
        public final int a;
        public final long b;

        public b(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public static /* synthetic */ b a(Parcel parcel) {
            return c(parcel);
        }

        public static /* synthetic */ void b(b bVar, Parcel parcel) {
            bVar.d(parcel);
        }

        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        public final void d(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
        }

        public /* synthetic */ b(int i, long j, a aVar) {
            this(i, j);
        }
    }

    public static final class c {
        public final long a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final long e;
        public final List f;
        public final boolean g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;

        public c(long j, boolean z, boolean z2, boolean z3, List list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.a = j;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.f = Collections.unmodifiableList(list);
            this.e = j2;
            this.g = z4;
            this.h = j3;
            this.i = i;
            this.j = i2;
            this.k = i3;
        }

        public static /* synthetic */ c a(Parcel parcel) {
            return d(parcel);
        }

        public static /* synthetic */ c b(M m) {
            return e(m);
        }

        public static /* synthetic */ void c(c cVar, Parcel parcel) {
            cVar.f(parcel);
        }

        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        public static c e(M m) {
            ArrayList arrayList;
            boolean z;
            long j;
            boolean z2;
            long j2;
            int i;
            int i2;
            int i3;
            boolean z3;
            boolean z4;
            long j3;
            long J = m.J();
            boolean z5 = (m.H() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z5) {
                arrayList = arrayList2;
                z = false;
                j = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i = 0;
                i2 = 0;
                i3 = 0;
                z3 = false;
            } else {
                int H = m.H();
                boolean z6 = (H & 128) != 0;
                boolean z7 = (H & 64) != 0;
                boolean z8 = (H & 32) != 0;
                long J2 = z7 ? m.J() : -9223372036854775807L;
                if (!z7) {
                    int H2 = m.H();
                    ArrayList arrayList3 = new ArrayList(H2);
                    for (int i4 = 0; i4 < H2; i4++) {
                        arrayList3.add(new b(m.H(), m.J(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long H3 = m.H();
                    boolean z9 = (128 & H3) != 0;
                    j3 = ((((H3 & 1) << 32) | m.J()) * 1000) / 90;
                    z4 = z9;
                } else {
                    z4 = false;
                    j3 = -9223372036854775807L;
                }
                int N = m.N();
                int H4 = m.H();
                z3 = z7;
                i3 = m.H();
                j2 = j3;
                arrayList = arrayList2;
                long j4 = J2;
                i = N;
                i2 = H4;
                j = j4;
                boolean z10 = z6;
                z2 = z4;
                z = z10;
            }
            return new c(J, z5, z, z3, arrayList, j, z2, j2, i, i2, i3);
        }

        public final void f(Parcel parcel) {
            parcel.writeLong(this.a);
            parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
            int size = this.f.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                b.b((b) this.f.get(i), parcel);
            }
            parcel.writeLong(this.e);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.h);
            parcel.writeInt(this.i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }

        public c(Parcel parcel) {
            this.a = parcel.readLong();
            this.b = parcel.readByte() == 1;
            this.c = parcel.readByte() == 1;
            this.d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(b.a(parcel));
            }
            this.f = Collections.unmodifiableList(arrayList);
            this.e = parcel.readLong();
            this.g = parcel.readByte() == 1;
            this.h = parcel.readLong();
            this.i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }
    }

    public f(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(c.a(parcel));
        }
        this.a = Collections.unmodifiableList(arrayList);
    }

    public static f a(M m) {
        int H = m.H();
        ArrayList arrayList = new ArrayList(H);
        for (int i = 0; i < H; i++) {
            arrayList.add(c.b(m));
        }
        return new f((List) arrayList);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = this.a.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            c.c((c) this.a.get(i2), parcel);
        }
    }

    public /* synthetic */ f(Parcel parcel, a aVar) {
        this(parcel);
    }

    public f(List list) {
        this.a = Collections.unmodifiableList(list);
    }
}
