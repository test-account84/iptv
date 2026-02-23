package R2;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import q3.a;
import w5.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final float a;
    public final float c;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, (a) null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(float f, float f2) {
        d4.a.b(f >= -90.0f && f <= 90.0f && f2 >= -180.0f && f2 <= 180.0f, "Invalid latitude or longitude");
        this.a = f;
        this.c = f2;
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
        return this.a == bVar.a && this.c == bVar.c;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return q3.b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return q3.b.b(this);
    }

    public int hashCode() {
        return ((527 + d.a(this.a)) * 31) + d.a(this.c);
    }

    public /* synthetic */ void populateMediaMetadata(R0.b bVar) {
        q3.b.c(this, bVar);
    }

    public String toString() {
        return "xyz: latitude=" + this.a + ", longitude=" + this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.c);
    }

    public b(Parcel parcel) {
        this.a = parcel.readFloat();
        this.c = parcel.readFloat();
    }

    public /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }
}
