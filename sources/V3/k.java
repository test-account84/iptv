package v3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final int c;
    public final int d;
    public final int e;
    public final int[] f;
    public final int[] g;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i) {
            return new k[i];
        }
    }

    public k(int i, int i2, int i3, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = iArr;
        this.g = iArr2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.c == kVar.c && this.d == kVar.d && this.e == kVar.e && Arrays.equals(this.f, kVar.f) && Arrays.equals(this.g, kVar.g);
    }

    public int hashCode() {
        return ((((((((527 + this.c) * 31) + this.d) * 31) + this.e) * 31) + Arrays.hashCode(this.f)) * 31) + Arrays.hashCode(this.g);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeIntArray(this.f);
        parcel.writeIntArray(this.g);
    }

    public k(Parcel parcel) {
        super("MLLT");
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = (int[]) k0.j(parcel.createIntArray());
        this.g = (int[]) k0.j(parcel.createIntArray());
    }
}
