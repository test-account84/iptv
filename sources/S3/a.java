package s3;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.Arrays;
import q3.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements a.b {
    public final String a;
    public final String c;
    public final long d;
    public final long e;
    public final byte[] f;
    public int g;
    public static final z0 h = new z0.b().g0("application/id3").G();
    public static final z0 i = new z0.b().g0("application/x-scte35").G();
    public static final Parcelable.Creator CREATOR = new a();

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(Parcel parcel) {
        this.a = (String) k0.j(parcel.readString());
        this.c = (String) k0.j(parcel.readString());
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.f = (byte[]) k0.j(parcel.createByteArray());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.d == aVar.d && this.e == aVar.e && k0.c(this.a, aVar.a) && k0.c(this.c, aVar.c) && Arrays.equals(this.f, aVar.f);
    }

    public byte[] getWrappedMetadataBytes() {
        if (getWrappedMetadataFormat() != null) {
            return this.f;
        }
        return null;
    }

    public z0 getWrappedMetadataFormat() {
        String str = this.a;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return i;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return h;
            default:
                return null;
        }
    }

    public int hashCode() {
        if (this.g == 0) {
            String str = this.a;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.c;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j = this.d;
            int i2 = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.e;
            this.g = ((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.f);
        }
        return this.g;
    }

    public /* synthetic */ void populateMediaMetadata(R0.b bVar) {
        q3.b.c(this, bVar);
    }

    public String toString() {
        return "EMSG: scheme=" + this.a + ", id=" + this.e + ", durationMs=" + this.d + ", value=" + this.c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeByteArray(this.f);
    }

    public a(String str, String str2, long j, long j2, byte[] bArr) {
        this.a = str;
        this.c = str2;
        this.d = j;
        this.e = j2;
        this.f = bArr;
    }
}
