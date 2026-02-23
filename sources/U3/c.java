package u3;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import q3.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final byte[] a;
    public final String c;
    public final String d;

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
        this.a = (byte[]) d4.a.e(parcel.createByteArray());
        this.c = parcel.readString();
        this.d = parcel.readString();
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
        return Arrays.equals(this.a, ((c) obj).a);
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return q3.b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return q3.b.b(this);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public void populateMediaMetadata(R0.b bVar) {
        String str = this.c;
        if (str != null) {
            bVar.m0(str);
        }
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", new Object[]{this.c, this.d, Integer.valueOf(this.a.length)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    public c(byte[] bArr, String str, String str2) {
        this.a = bArr;
        this.c = str;
        this.d = str2;
    }
}
