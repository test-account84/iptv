package w3;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import q3.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final float a;
    public final int c;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel, (a) null);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public e(float f, int i) {
        this.a = f;
        this.c = i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.c == eVar.c;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return q3.b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return q3.b.b(this);
    }

    public int hashCode() {
        return ((527 + w5.d.a(this.a)) * 31) + this.c;
    }

    public /* synthetic */ void populateMediaMetadata(R0.b bVar) {
        q3.b.c(this, bVar);
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.a + ", svcTemporalLayerCount=" + this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeInt(this.c);
    }

    public e(Parcel parcel) {
        this.a = parcel.readFloat();
        this.c = parcel.readInt();
    }

    public /* synthetic */ e(Parcel parcel, a aVar) {
        this(parcel);
    }
}
