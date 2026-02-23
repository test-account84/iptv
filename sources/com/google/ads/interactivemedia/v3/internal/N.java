package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n implements Parcelable {
    public static final Parcelable.Creator CREATOR = new m(0);
    public final UUID a;
    public final String b;
    public final String c;
    public final byte[] d;
    private int e;

    public n(Parcel parcel) {
        this.a = new UUID(parcel.readLong(), parcel.readLong());
        this.b = parcel.readString();
        String readString = parcel.readString();
        int i = cq.a;
        this.c = readString;
        this.d = parcel.createByteArray();
    }

    public final n a(byte[] bArr) {
        return new n(this.a, this.b, this.c, bArr);
    }

    public final boolean b() {
        return this.d != null;
    }

    public final boolean c(UUID uuid) {
        return i.a.equals(this.a) || uuid.equals(this.a);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        n nVar = (n) obj;
        return cq.V(this.b, nVar.b) && cq.V(this.c, nVar.c) && cq.V(this.a, nVar.a) && Arrays.equals(this.d, nVar.d);
    }

    public final int hashCode() {
        int i = this.e;
        if (i != 0) {
            return i;
        }
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31) + Arrays.hashCode(this.d);
        this.e = hashCode2;
        return hashCode2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a.getMostSignificantBits());
        parcel.writeLong(this.a.getLeastSignificantBits());
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeByteArray(this.d);
    }

    public n(UUID uuid, String str, String str2, byte[] bArr) {
        af.s(uuid);
        this.a = uuid;
        this.b = str;
        af.s(str2);
        this.c = str2;
        this.d = bArr;
    }

    public n(UUID uuid, String str, byte[] bArr) {
        this(uuid, null, str, bArr);
    }
}
