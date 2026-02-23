package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aal implements an {
    public static final Parcelable.Creator CREATOR;
    private static final s f;
    private static final s g;
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final byte[] e;
    private int h;

    static {
        r rVar = new r();
        rVar.ae("application/id3");
        f = rVar.v();
        r rVar2 = new r();
        rVar2.ae("application/x-scte35");
        g = rVar2.v();
        CREATOR = new aak();
    }

    public aal(Parcel parcel) {
        String readString = parcel.readString();
        int i = cq.a;
        this.a = readString;
        this.b = parcel.readString();
        this.c = parcel.readLong();
        this.d = parcel.readLong();
        this.e = (byte[]) cq.G(parcel.createByteArray());
    }

    public final /* synthetic */ void a(ak akVar) {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.v3.internal.s b() {
        /*
            r5 = this;
            java.lang.String r0 = r5.a
            int r1 = r0.hashCode()
            r2 = -1468477611(0xffffffffa878cf55, float:-1.38117235E-14)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L2c
            r2 = -795945609(0xffffffffd08ed577, float:-1.91708344E10)
            if (r1 == r2) goto L22
            r2 = 1303648457(0x4db418c9, float:3.776904E8)
            if (r1 == r2) goto L18
            goto L36
        L18:
            java.lang.String r1 = "https://developer.apple.com/streaming/emsg-id3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            r0 = 1
            goto L37
        L22:
            java.lang.String r1 = "https://aomedia.org/emsg/ID3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            r0 = 0
            goto L37
        L2c:
            java.lang.String r1 = "urn:scte:scte35:2014:bin"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L36
            r0 = 2
            goto L37
        L36:
            r0 = -1
        L37:
            if (r0 == 0) goto L42
            if (r0 == r4) goto L42
            if (r0 == r3) goto L3f
            r0 = 0
            return r0
        L3f:
            com.google.ads.interactivemedia.v3.internal.s r0 = com.google.ads.interactivemedia.v3.internal.aal.g
            return r0
        L42:
            com.google.ads.interactivemedia.v3.internal.s r0 = com.google.ads.interactivemedia.v3.internal.aal.f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aal.b():com.google.ads.interactivemedia.v3.internal.s");
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && aal.class == obj.getClass()) {
            aal aalVar = (aal) obj;
            if (this.c == aalVar.c && this.d == aalVar.d && cq.V(this.a, aalVar.a) && cq.V(this.b, aalVar.b) && Arrays.equals(this.e, aalVar.e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.h;
        if (i != 0) {
            return i;
        }
        String str = this.a;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.b;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        long j = this.c;
        long j2 = this.d;
        int hashCode3 = ((((((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + Arrays.hashCode(this.e);
        this.h = hashCode3;
        return hashCode3;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.a + ", id=" + this.d + ", durationMs=" + this.c + ", value=" + this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeLong(this.c);
        parcel.writeLong(this.d);
        parcel.writeByteArray(this.e);
    }

    public aal(String str, String str2, long j, long j2, byte[] bArr) {
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = bArr;
    }
}
