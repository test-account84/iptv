package x3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.M;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends b {
    public static final Parcelable.Creator CREATOR = new a();
    public final long a;
    public final long c;
    public final byte[] d;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(long j, byte[] bArr, long j2) {
        this.a = j2;
        this.c = j;
        this.d = bArr;
    }

    public static a a(M m, int i, long j) {
        long J = m.J();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        m.l(bArr, 0, i2);
        return new a(J, bArr, j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.c);
        parcel.writeByteArray(this.d);
    }

    public a(Parcel parcel) {
        this.a = parcel.readLong();
        this.c = parcel.readLong();
        this.d = (byte[]) k0.j(parcel.createByteArray());
    }

    public /* synthetic */ a(Parcel parcel, a aVar) {
        this(parcel);
    }
}
