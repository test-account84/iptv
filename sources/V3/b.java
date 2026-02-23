package v3;

import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends i {
    public static final Parcelable.Creator CREATOR = new a();
    public final byte[] c;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(Parcel parcel) {
        super((String) k0.j(parcel.readString()));
        this.c = (byte[]) k0.j(parcel.createByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && Arrays.equals(this.c, bVar.c);
    }

    public int hashCode() {
        return ((527 + this.a.hashCode()) * 31) + Arrays.hashCode(this.c);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.c);
    }

    public b(String str, byte[] bArr) {
        super(str);
        this.c = bArr;
    }
}
