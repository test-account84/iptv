package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class abe extends aba {
    public static final Parcelable.Creator CREATOR = new aaq(9);
    public final String a;
    public final String b;

    /* JADX WARN: Illegal instructions before constructor call */
    public abe(Parcel parcel) {
        String readString = parcel.readString();
        int i = cq.a;
        super(readString);
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    private static List b(String str) {
        int parseInt;
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                parseInt = Integer.parseInt(str.substring(8, 10));
            } else {
                if (str.length() < 7) {
                    if (str.length() >= 4) {
                        parseInt = Integer.parseInt(str.substring(0, 4));
                    }
                    return arrayList;
                }
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                parseInt = Integer.parseInt(str.substring(5, 7));
            }
            arrayList.add(Integer.valueOf(parseInt));
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.google.ads.interactivemedia.v3.internal.ak r8) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.abe.a(com.google.ads.interactivemedia.v3.internal.ak):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && abe.class == obj.getClass()) {
            abe abeVar = (abe) obj;
            if (cq.V(this.f, abeVar.f) && cq.V(this.a, abeVar.a) && cq.V(this.b, abeVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f.hashCode() + 527) * 31;
        String str = this.a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return this.f + ": description=" + this.a + ": value=" + this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    public abe(String str, String str2, String str3) {
        super(str);
        this.a = str2;
        this.b = str3;
    }
}
