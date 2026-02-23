package u3;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import q3.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final int a;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final int g;

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

    public b(int i, String str, String str2, String str3, boolean z, int i2) {
        d4.a.a(i2 == -1 || i2 > 0);
        this.a = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = z;
        this.g = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static u3.b a(java.util.Map r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.b.a(java.util.Map):u3.b");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && k0.c(this.c, bVar.c) && k0.c(this.d, bVar.d) && k0.c(this.e, bVar.e) && this.f == bVar.f && this.g == bVar.g;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return q3.b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return q3.b.b(this);
    }

    public int hashCode() {
        int i = (527 + this.a) * 31;
        String str = this.c;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.f ? 1 : 0)) * 31) + this.g;
    }

    public void populateMediaMetadata(R0.b bVar) {
        String str = this.d;
        if (str != null) {
            bVar.k0(str);
        }
        String str2 = this.c;
        if (str2 != null) {
            bVar.Z(str2);
        }
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.d + "\", genre=\"" + this.c + "\", bitrate=" + this.a + ", metadataInterval=" + this.g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        k0.y1(parcel, this.f);
        parcel.writeInt(this.g);
    }

    public b(Parcel parcel) {
        this.a = parcel.readInt();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = k0.Z0(parcel);
        this.g = parcel.readInt();
    }
}
