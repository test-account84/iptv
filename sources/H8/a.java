package h8;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final String a;
    public final String c;
    public final boolean d;

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

    public a(Parcel parcel) {
        this.a = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt() != 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeInt(this.d ? 0 : 1);
    }

    public a(String str, String str2, boolean z, String str3) {
        this.a = str;
        this.c = str2;
        this.d = z;
    }
}
