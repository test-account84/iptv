package e7;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d extends b implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public int j;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            d dVar = new d();
            dVar.J(parcel.readLong());
            dVar.K(parcel.readString());
            dVar.L(parcel.readString());
            dVar.N(parcel.readLong());
            dVar.G(parcel.readString());
            dVar.H(parcel.readString());
            dVar.I(parcel.readLong());
            dVar.M(parcel.readByte() != 0);
            dVar.O(parcel.readInt());
            return dVar;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    }

    public void O(int i) {
        this.j = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(v());
        parcel.writeString(w());
        parcel.writeString(x());
        parcel.writeLong(A());
        parcel.writeString(m());
        parcel.writeString(r());
        parcel.writeLong(t());
        parcel.writeByte(C() ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.j);
    }
}
