package e7;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e extends b implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public String j;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            e eVar = new e();
            eVar.J(parcel.readLong());
            eVar.K(parcel.readString());
            eVar.L(parcel.readString());
            eVar.N(parcel.readLong());
            eVar.G(parcel.readString());
            eVar.H(parcel.readString());
            eVar.I(parcel.readLong());
            eVar.M(parcel.readByte() != 0);
            eVar.P(parcel.readString());
            return eVar;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public String O() {
        return this.j;
    }

    public void P(String str) {
        this.j = str;
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
        parcel.writeString(O());
    }
}
