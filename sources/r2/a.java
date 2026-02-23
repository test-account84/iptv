package R2;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import q3.a;
import w5.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final long a;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(long j) {
        this.a = j;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.a == ((a) obj).a;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return q3.b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return q3.b.b(this);
    }

    public int hashCode() {
        return h.b(this.a);
    }

    public /* synthetic */ void populateMediaMetadata(R0.b bVar) {
        q3.b.c(this, bVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Creation time: ");
        long j = this.a;
        sb.append(j == -2082844800000L ? "unset" : Long.valueOf(j));
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
    }

    public a(Parcel parcel) {
        this.a = parcel.readLong();
    }

    public /* synthetic */ a(Parcel parcel, a aVar) {
        this(parcel);
    }
}
