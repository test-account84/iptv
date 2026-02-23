package x3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.M;
import d4.Z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends x3.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final long a;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final long g;
    public final long h;
    public final List i;
    public final boolean j;
    public final long k;
    public final int l;
    public final int m;
    public final int n;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel, null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    }

    public static final class b {
        public final int a;
        public final long b;
        public final long c;

        public b(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.a);
            parcel.writeLong(this.b);
            parcel.writeLong(this.c);
        }

        public /* synthetic */ b(int i, long j, long j2, a aVar) {
            this(i, j, j2);
        }
    }

    public d(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List list, boolean z5, long j4, int i, int i2, int i3) {
        this.a = j;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = j2;
        this.h = j3;
        this.i = Collections.unmodifiableList(list);
        this.j = z5;
        this.k = j4;
        this.l = i;
        this.m = i2;
        this.n = i3;
    }

    public static d a(M m, long j, Z z) {
        List list;
        boolean z2;
        boolean z3;
        long j2;
        boolean z4;
        long j3;
        int i;
        int i2;
        int i3;
        boolean z5;
        boolean z6;
        long j4;
        long J = m.J();
        boolean z7 = (m.H() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (z7) {
            list = emptyList;
            z2 = false;
            z3 = false;
            j2 = -9223372036854775807L;
            z4 = false;
            j3 = -9223372036854775807L;
            i = 0;
            i2 = 0;
            i3 = 0;
            z5 = false;
        } else {
            int H = m.H();
            boolean z8 = (H & 128) != 0;
            boolean z9 = (H & 64) != 0;
            boolean z10 = (H & 32) != 0;
            boolean z11 = (H & 16) != 0;
            long c = (!z9 || z11) ? -9223372036854775807L : g.c(m, j);
            if (!z9) {
                int H2 = m.H();
                List arrayList = new ArrayList(H2);
                for (int i4 = 0; i4 < H2; i4++) {
                    int H3 = m.H();
                    long c2 = !z11 ? g.c(m, j) : -9223372036854775807L;
                    arrayList.add(new b(H3, c2, z.b(c2), null));
                }
                emptyList = arrayList;
            }
            if (z10) {
                long H4 = m.H();
                boolean z12 = (128 & H4) != 0;
                j4 = ((((H4 & 1) << 32) | m.J()) * 1000) / 90;
                z6 = z12;
            } else {
                z6 = false;
                j4 = -9223372036854775807L;
            }
            i = m.N();
            z5 = z9;
            i2 = m.H();
            i3 = m.H();
            list = emptyList;
            long j5 = c;
            z4 = z6;
            j3 = j4;
            z3 = z11;
            z2 = z8;
            j2 = j5;
        }
        return new d(J, z7, z2, z5, z3, j2, z.b(j2), list, z4, j3, i, i2, i3);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.g);
        parcel.writeLong(this.h);
        int size = this.i.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            ((b) this.i.get(i2)).b(parcel);
        }
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
    }

    public d(Parcel parcel) {
        this.a = parcel.readLong();
        this.c = parcel.readByte() == 1;
        this.d = parcel.readByte() == 1;
        this.e = parcel.readByte() == 1;
        this.f = parcel.readByte() == 1;
        this.g = parcel.readLong();
        this.h = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(b.a(parcel));
        }
        this.i = Collections.unmodifiableList(arrayList);
        this.j = parcel.readByte() == 1;
        this.k = parcel.readLong();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
    }

    public /* synthetic */ d(Parcel parcel, a aVar) {
        this(parcel);
    }
}
