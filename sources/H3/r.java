package H3;

import O2.R0;
import O2.z0;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import q3.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r implements a.b {
    public static final Parcelable.Creator CREATOR = new a();
    public final String a;
    public final String c;
    public final List d;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r createFromParcel(Parcel parcel) {
            return new r(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public r[] newArray(int i) {
            return new r[i];
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public final int a;
        public final int c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;

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

        public b(int i, int i2, String str, String str2, String str3, String str4) {
            this.a = i;
            this.c = i2;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
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
            return this.a == bVar.a && this.c == bVar.c && TextUtils.equals(this.d, bVar.d) && TextUtils.equals(this.e, bVar.e) && TextUtils.equals(this.f, bVar.f) && TextUtils.equals(this.g, bVar.g);
        }

        public int hashCode() {
            int i = ((this.a * 31) + this.c) * 31;
            String str = this.d;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.e;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.g;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeString(this.g);
        }

        public b(Parcel parcel) {
            this.a = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
            this.g = parcel.readString();
        }
    }

    public r(Parcel parcel) {
        this.a = parcel.readString();
        this.c = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((b) parcel.readParcelable(b.class.getClassLoader()));
        }
        this.d = Collections.unmodifiableList(arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return TextUtils.equals(this.a, rVar.a) && TextUtils.equals(this.c, rVar.c) && this.d.equals(rVar.d);
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return q3.b.a(this);
    }

    public /* synthetic */ z0 getWrappedMetadataFormat() {
        return q3.b.b(this);
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.c;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.d.hashCode();
    }

    public /* synthetic */ void populateMediaMetadata(R0.b bVar) {
        q3.b.c(this, bVar);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("HlsTrackMetadataEntry");
        if (this.a != null) {
            str = " [" + this.a + ", " + this.c + "]";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        int size = this.d.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable((Parcelable) this.d.get(i2), 0);
        }
    }

    public r(String str, String str2, List list) {
        this.a = str;
        this.c = str2;
        this.d = Collections.unmodifiableList(new ArrayList(list));
    }
}
