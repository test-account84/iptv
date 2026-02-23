package e7;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f extends b implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public long j;
    public String k;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            f fVar = new f();
            fVar.J(parcel.readLong());
            fVar.K(parcel.readString());
            fVar.L(parcel.readString());
            fVar.N(parcel.readLong());
            fVar.G(parcel.readString());
            fVar.H(parcel.readString());
            fVar.I(parcel.readLong());
            fVar.M(parcel.readByte() != 0);
            fVar.Q(parcel.readLong());
            fVar.R(parcel.readString());
            return fVar;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i) {
            return new f[i];
        }
    }

    public long O() {
        return this.j;
    }

    public String P() {
        return this.k;
    }

    public void Q(long j) {
        this.j = j;
    }

    public void R(String str) {
        this.k = str;
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
        parcel.writeLong(O());
        parcel.writeString(P());
    }
}
