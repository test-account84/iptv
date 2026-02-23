package V2;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import d4.k0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class m implements Comparator, Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    public final b[] a;
    public int c;
    public final String d;
    public final int e;

    public class a implements Parcelable.Creator {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i) {
            return new m[i];
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public int a;
        public final UUID c;
        public final String d;
        public final String e;
        public final byte[] f;

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

        public b(Parcel parcel) {
            this.c = new UUID(parcel.readLong(), parcel.readLong());
            this.d = parcel.readString();
            this.e = (String) k0.j(parcel.readString());
            this.f = parcel.createByteArray();
        }

        public boolean a(b bVar) {
            return d() && !bVar.d() && e(bVar.c);
        }

        public b c(byte[] bArr) {
            return new b(this.c, this.d, this.e, bArr);
        }

        public boolean d() {
            return this.f != null;
        }

        public int describeContents() {
            return 0;
        }

        public boolean e(UUID uuid) {
            return O2.o.a.equals(this.c) || uuid.equals(this.c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return k0.c(this.d, bVar.d) && k0.c(this.e, bVar.e) && k0.c(this.c, bVar.c) && Arrays.equals(this.f, bVar.f);
        }

        public int hashCode() {
            if (this.a == 0) {
                int hashCode = this.c.hashCode() * 31;
                String str = this.d;
                this.a = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.e.hashCode()) * 31) + Arrays.hashCode(this.f);
            }
            return this.a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.c.getMostSignificantBits());
            parcel.writeLong(this.c.getLeastSignificantBits());
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeByteArray(this.f);
        }

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this.c = (UUID) d4.a.e(uuid);
            this.d = str;
            this.e = (String) d4.a.e(str2);
            this.f = bArr;
        }

        public b(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr);
        }
    }

    public m(Parcel parcel) {
        this.d = parcel.readString();
        b[] bVarArr = (b[]) k0.j((b[]) parcel.createTypedArray(b.CREATOR));
        this.a = bVarArr;
        this.e = bVarArr.length;
    }

    public static boolean c(ArrayList arrayList, int i, UUID uuid) {
        for (int i2 = 0; i2 < i; i2++) {
            if (((b) arrayList.get(i2)).c.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static m e(m mVar, m mVar2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (mVar != null) {
            str = mVar.d;
            for (b bVar : mVar.a) {
                if (bVar.d()) {
                    arrayList.add(bVar);
                }
            }
        } else {
            str = null;
        }
        if (mVar2 != null) {
            if (str == null) {
                str = mVar2.d;
            }
            int size = arrayList.size();
            for (b bVar2 : mVar2.a) {
                if (bVar2.d() && !c(arrayList, size, bVar2.c)) {
                    arrayList.add(bVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new m(str, (List) arrayList);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        UUID uuid = O2.o.a;
        return uuid.equals(bVar.c) ? uuid.equals(bVar2.c) ? 0 : 1 : bVar.c.compareTo(bVar2.c);
    }

    public m d(String str) {
        return k0.c(this.d, str) ? this : new m(str, false, this.a);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return k0.c(this.d, mVar.d) && Arrays.equals(this.a, mVar.a);
    }

    public b f(int i) {
        return this.a[i];
    }

    public m g(m mVar) {
        String str;
        String str2 = this.d;
        d4.a.g(str2 == null || (str = mVar.d) == null || TextUtils.equals(str2, str));
        String str3 = this.d;
        if (str3 == null) {
            str3 = mVar.d;
        }
        return new m(str3, (b[]) k0.T0(this.a, mVar.a));
    }

    public int hashCode() {
        if (this.c == 0) {
            String str = this.d;
            this.c = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.a);
        }
        return this.c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.d);
        parcel.writeTypedArray(this.a, 0);
    }

    public m(String str, List list) {
        this(str, false, (b[]) list.toArray(new b[0]));
    }

    public m(String str, boolean z, b... bVarArr) {
        this.d = str;
        bVarArr = z ? (b[]) bVarArr.clone() : bVarArr;
        this.a = bVarArr;
        this.e = bVarArr.length;
        Arrays.sort(bVarArr, this);
    }

    public m(String str, b... bVarArr) {
        this(str, true, bVarArr);
    }

    public m(List list) {
        this(null, false, (b[]) list.toArray(new b[0]));
    }

    public m(b... bVarArr) {
        this((String) null, bVarArr);
    }
}
