package v3;

import O2.R0;
import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final String c;
    public final String d;
    public final int e;
    public final byte[] f;

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
        super("APIC");
        this.c = (String) k0.j(parcel.readString());
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = (byte[]) k0.j(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.e == aVar.e && k0.c(this.c, aVar.c) && k0.c(this.d, aVar.d) && Arrays.equals(this.f, aVar.f);
    }

    public int hashCode() {
        int i = (527 + this.e) * 31;
        String str = this.c;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f);
    }

    public void populateMediaMetadata(R0.b bVar) {
        bVar.I(this.f, this.e);
    }

    public String toString() {
        return this.a + ": mimeType=" + this.c + ", description=" + this.d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeByteArray(this.f);
    }

    public a(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = bArr;
    }
}
