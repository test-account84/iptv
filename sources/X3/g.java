package x3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.M;
import d4.Z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g extends b {
    public static final Parcelable.Creator CREATOR = new a();
    public final long a;
    public final long c;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong(), null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i) {
            return new g[i];
        }
    }

    public g(long j, long j2) {
        this.a = j;
        this.c = j2;
    }

    public static g a(M m, long j, Z z) {
        long c = c(m, j);
        return new g(c, z.b(c));
    }

    public static long c(M m, long j) {
        long H = m.H();
        if ((128 & H) != 0) {
            return 8589934591L & ((((H & 1) << 32) | m.J()) + j);
        }
        return -9223372036854775807L;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.c);
    }

    public /* synthetic */ g(long j, long j2, a aVar) {
        this(j, j2);
    }
}
