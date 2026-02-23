package w3;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import q3.a;
import w5.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final long a;
    public final long c;
    public final long d;
    public final long e;
    public final long f;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(long j, long j2, long j3, long j4, long j5) {
        this.a = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
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
        return this.a == bVar.a && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return q3.b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return q3.b.b(this);
    }

    public int hashCode() {
        return ((((((((527 + h.b(this.a)) * 31) + h.b(this.c)) * 31) + h.b(this.d)) * 31) + h.b(this.e)) * 31) + h.b(this.f);
    }

    public /* synthetic */ void populateMediaMetadata(R0.b bVar) {
        q3.b.c(this, bVar);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.a + ", photoSize=" + this.c + ", photoPresentationTimestampUs=" + this.d + ", videoStartPosition=" + this.e + ", videoSize=" + this.f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
    }

    public b(Parcel parcel) {
        this.a = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
    }

    public /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }
}
