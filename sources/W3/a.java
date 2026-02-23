package w3;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.Arrays;
import q3.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final String a;
    public final byte[] c;
    public final int d;
    public final int e;

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

    public a(Parcel parcel) {
        this.a = (String) k0.j(parcel.readString());
        this.c = (byte[]) k0.j(parcel.createByteArray());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && Arrays.equals(this.c, aVar.c) && this.d == aVar.d && this.e == aVar.e;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return q3.b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return q3.b.b(this);
    }

    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + Arrays.hashCode(this.c)) * 31) + this.d) * 31) + this.e;
    }

    public /* synthetic */ void populateMediaMetadata(R0.b bVar) {
        q3.b.c(this, bVar);
    }

    public String toString() {
        int i = this.e;
        return "mdta: key=" + this.a + ", value=" + (i != 1 ? i != 23 ? i != 67 ? k0.r1(this.c) : String.valueOf(k0.s1(this.c)) : String.valueOf(k0.q1(this.c)) : k0.E(this.c));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }

    public /* synthetic */ a(Parcel parcel, a aVar) {
        this(parcel);
    }

    public a(String str, byte[] bArr, int i, int i2) {
        this.a = str;
        this.c = bArr;
        this.d = i;
        this.e = i2;
    }
}
