package v3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final String c;
    public final String d;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public n[] newArray(int i) {
            return new n[i];
        }
    }

    public n(Parcel parcel) {
        super((String) k0.j(parcel.readString()));
        this.c = parcel.readString();
        this.d = (String) k0.j(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.a.equals(nVar.a) && k0.c(this.c, nVar.c) && k0.c(this.d, nVar.d);
    }

    public int hashCode() {
        int hashCode = (527 + this.a.hashCode()) * 31;
        String str = this.c;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.a + ": url=" + this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public n(String str, String str2, String str3) {
        super(str);
        this.c = str2;
        this.d = str3;
    }
}
