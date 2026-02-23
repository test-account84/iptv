package v3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final String c;
    public final int d;
    public final int e;
    public final long f;
    public final long g;
    public final i[] h;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i) {
            return new c[i];
        }
    }

    public c(Parcel parcel) {
        super("CHAP");
        this.c = (String) k0.j(parcel.readString());
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        int readInt = parcel.readInt();
        this.h = new i[readInt];
        for (int i = 0; i < readInt; i++) {
            this.h[i] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.d == cVar.d && this.e == cVar.e && this.f == cVar.f && this.g == cVar.g && k0.c(this.c, cVar.c) && Arrays.equals(this.h, cVar.h);
    }

    public int hashCode() {
        int i = (((((((527 + this.d) * 31) + this.e) * 31) + ((int) this.f)) * 31) + ((int) this.g)) * 31;
        String str = this.c;
        return i + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        parcel.writeInt(this.h.length);
        for (i iVar : this.h) {
            parcel.writeParcelable(iVar, 0);
        }
    }

    public c(String str, int i, int i2, long j, long j2, i[] iVarArr) {
        super("CHAP");
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = j;
        this.g = j2;
        this.h = iVarArr;
    }
}
