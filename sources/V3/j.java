package v3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final String c;
    public final String d;
    public final String e;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i) {
            return new j[i];
        }
    }

    public j(Parcel parcel) {
        super("----");
        this.c = (String) k0.j(parcel.readString());
        this.d = (String) k0.j(parcel.readString());
        this.e = (String) k0.j(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return k0.c(this.d, jVar.d) && k0.c(this.c, jVar.c) && k0.c(this.e, jVar.e);
    }

    public int hashCode() {
        String str = this.c;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return this.a + ": domain=" + this.c + ", description=" + this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.e);
    }

    public j(String str, String str2, String str3) {
        super("----");
        this.c = str;
        this.d = str2;
        this.e = str3;
    }
}
