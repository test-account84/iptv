package z3;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import d4.k0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final String a;
    public final Uri c;
    public final String d;
    public final List e;
    public final byte[] f;
    public final String g;
    public final byte[] h;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public w createFromParcel(Parcel parcel) {
            return new w(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public w[] newArray(int i) {
            return new w[i];
        }
    }

    public static class b {
        public final String a;
        public final Uri b;
        public String c;
        public List d;
        public byte[] e;
        public String f;
        public byte[] g;

        public b(String str, Uri uri) {
            this.a = str;
            this.b = uri;
        }

        public w a() {
            String str = this.a;
            Uri uri = this.b;
            String str2 = this.c;
            List list = this.d;
            if (list == null) {
                list = s5.y.z();
            }
            return new w(str, uri, str2, list, this.e, this.f, this.g, null);
        }

        public b b(String str) {
            this.f = str;
            return this;
        }

        public b c(byte[] bArr) {
            this.g = bArr;
            return this;
        }

        public b d(byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public b e(String str) {
            this.c = str;
            return this;
        }

        public b f(List list) {
            this.d = list;
            return this;
        }
    }

    public w(Parcel parcel) {
        this.a = (String) k0.j(parcel.readString());
        this.c = Uri.parse((String) k0.j(parcel.readString()));
        this.d = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((H) parcel.readParcelable(H.class.getClassLoader()));
        }
        this.e = Collections.unmodifiableList(arrayList);
        this.f = parcel.createByteArray();
        this.g = parcel.readString();
        this.h = (byte[]) k0.j(parcel.createByteArray());
    }

    public w a(byte[] bArr) {
        return new w(this.a, this.c, this.d, this.e, bArr, this.g, this.h);
    }

    public w c(w wVar) {
        ArrayList emptyList;
        d4.a.a(this.a.equals(wVar.a));
        if (this.e.isEmpty() || wVar.e.isEmpty()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = new ArrayList(this.e);
            for (int i = 0; i < wVar.e.size(); i++) {
                H h = (H) wVar.e.get(i);
                if (!emptyList.contains(h)) {
                    emptyList.add(h);
                }
            }
        }
        return new w(this.a, wVar.c, wVar.d, emptyList, wVar.f, wVar.g, wVar.h);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.a.equals(wVar.a) && this.c.equals(wVar.c) && k0.c(this.d, wVar.d) && this.e.equals(wVar.e) && Arrays.equals(this.f, wVar.f) && k0.c(this.g, wVar.g) && Arrays.equals(this.h, wVar.h);
    }

    public final int hashCode() {
        int hashCode = ((this.a.hashCode() * 961) + this.c.hashCode()) * 31;
        String str = this.d;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + Arrays.hashCode(this.f)) * 31;
        String str2 = this.g;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.h);
    }

    public String toString() {
        return this.d + ":" + this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c.toString());
        parcel.writeString(this.d);
        parcel.writeInt(this.e.size());
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            parcel.writeParcelable((Parcelable) this.e.get(i2), 0);
        }
        parcel.writeByteArray(this.f);
        parcel.writeString(this.g);
        parcel.writeByteArray(this.h);
    }

    public w(String str, Uri uri, String str2, List list, byte[] bArr, String str3, byte[] bArr2) {
        int y0 = k0.y0(uri, str2);
        if (y0 == 0 || y0 == 2 || y0 == 1) {
            d4.a.b(str3 == null, "customCacheKey must be null for type: " + y0);
        }
        this.a = str;
        this.c = uri;
        this.d = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.e = Collections.unmodifiableList(arrayList);
        this.f = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.g = str3;
        this.h = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : k0.f;
    }

    public /* synthetic */ w(String str, Uri uri, String str2, List list, byte[] bArr, String str3, byte[] bArr2, a aVar) {
        this(str, uri, str2, list, bArr, str3, bArr2);
    }
}
