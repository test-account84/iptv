package v3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final String c;
    public final byte[] d;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i) {
            return new l[i];
        }
    }

    public l(Parcel parcel) {
        super("PRIV");
        this.c = (String) k0.j(parcel.readString());
        this.d = (byte[]) k0.j(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return k0.c(this.c, lVar.c) && Arrays.equals(this.d, lVar.d);
    }

    public int hashCode() {
        String str = this.c;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.d);
    }

    public String toString() {
        return this.a + ": owner=" + this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeByteArray(this.d);
    }

    public l(String str, byte[] bArr) {
        super("PRIV");
        this.c = str;
        this.d = bArr;
    }
}
