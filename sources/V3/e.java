package v3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final String c;
    public final String d;
    public final String e;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public e(Parcel parcel) {
        super("COMM");
        this.c = (String) k0.j(parcel.readString());
        this.d = (String) k0.j(parcel.readString());
        this.e = (String) k0.j(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return k0.c(this.d, eVar.d) && k0.c(this.c, eVar.c) && k0.c(this.e, eVar.e);
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
        return this.a + ": language=" + this.c + ", description=" + this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.e);
    }

    public e(String str, String str2, String str3) {
        super("COMM");
        this.c = str;
        this.d = str2;
        this.e = str3;
    }
}
