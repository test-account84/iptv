package v3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final String c;
    public final boolean d;
    public final boolean e;
    public final String[] f;
    public final i[] g;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i) {
            return new d[i];
        }
    }

    public d(Parcel parcel) {
        super("CTOC");
        this.c = (String) k0.j(parcel.readString());
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = (String[]) k0.j(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.g = new i[readInt];
        for (int i = 0; i < readInt; i++) {
            this.g[i] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.d == dVar.d && this.e == dVar.e && k0.c(this.c, dVar.c) && Arrays.equals(this.f, dVar.f) && Arrays.equals(this.g, dVar.g);
    }

    public int hashCode() {
        int i = (((527 + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31;
        String str = this.c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f);
        parcel.writeInt(this.g.length);
        for (i iVar : this.g) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    public d(String str, boolean z, boolean z2, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.c = str;
        this.d = z;
        this.e = z2;
        this.f = strArr;
        this.g = iVarArr;
    }
}
