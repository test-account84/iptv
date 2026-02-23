package t3;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import q3.a;
import q3.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class a implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final String a;
    public final String c;

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
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.c.equals(aVar.c);
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return b.b(this);
    }

    public int hashCode() {
        return ((527 + this.a.hashCode()) * 31) + this.c.hashCode();
    }

    public void populateMediaMetadata(R0.b bVar) {
        String str = this.a;
        str.hashCode();
        switch (str) {
            case "ALBUM":
                bVar.N(this.c);
                break;
            case "TITLE":
                bVar.m0(this.c);
                break;
            case "DESCRIPTION":
                bVar.U(this.c);
                break;
            case "ALBUMARTIST":
                bVar.M(this.c);
                break;
            case "ARTIST":
                bVar.O(this.c);
                break;
        }
    }

    public String toString() {
        return "VC: " + this.a + "=" + this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
    }

    public a(String str, String str2) {
        this.a = str;
        this.c = str2;
    }
}
