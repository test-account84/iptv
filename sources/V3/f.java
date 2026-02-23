package v3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final String c;
    public final String d;
    public final String e;
    public final byte[] f;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i) {
            return new f[i];
        }
    }

    public f(Parcel parcel) {
        super("GEOB");
        this.c = (String) k0.j(parcel.readString());
        this.d = (String) k0.j(parcel.readString());
        this.e = (String) k0.j(parcel.readString());
        this.f = (byte[]) k0.j(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return k0.c(this.c, fVar.c) && k0.c(this.d, fVar.d) && k0.c(this.e, fVar.e) && Arrays.equals(this.f, fVar.f);
    }

    public int hashCode() {
        String str = this.c;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f);
    }

    public String toString() {
        return this.a + ": mimeType=" + this.c + ", filename=" + this.d + ", description=" + this.e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeByteArray(this.f);
    }

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = bArr;
    }
}
