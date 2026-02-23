package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bf {
    public final int a;
    public final String b;
    public final int c;
    private final s[] d;
    private int e;

    public bf(String str, s... sVarArr) {
        int length = sVarArr.length;
        int i = 1;
        af.u(length > 0);
        this.b = str;
        this.d = sVarArr;
        this.a = length;
        int b = ar.b(sVarArr[0].l);
        this.c = b == -1 ? ar.b(sVarArr[0].k) : b;
        String d = d(sVarArr[0].c);
        int c = c(sVarArr[0].e);
        while (true) {
            s[] sVarArr2 = this.d;
            if (i >= sVarArr2.length) {
                return;
            }
            if (!d.equals(d(sVarArr2[i].c))) {
                s[] sVarArr3 = this.d;
                e("languages", sVarArr3[0].c, sVarArr3[i].c, i);
                return;
            } else {
                s[] sVarArr4 = this.d;
                if (c != c(sVarArr4[i].e)) {
                    e("role flags", Integer.toBinaryString(sVarArr4[0].e), Integer.toBinaryString(this.d[i].e), i);
                    return;
                }
                i++;
            }
        }
    }

    private static int c(int i) {
        return i | 16384;
    }

    private static String d(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static void e(String str, String str2, String str3, int i) {
        cd.c("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public final int a(s sVar) {
        int i = 0;
        while (true) {
            s[] sVarArr = this.d;
            if (i >= sVarArr.length) {
                return -1;
            }
            if (sVar == sVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final s b(int i) {
        return this.d[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && bf.class == obj.getClass()) {
            bf bfVar = (bf) obj;
            if (this.b.equals(bfVar.b) && Arrays.equals(this.d, bfVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.e;
        if (i != 0) {
            return i;
        }
        int hashCode = ((this.b.hashCode() + 527) * 31) + Arrays.hashCode(this.d);
        this.e = hashCode;
        return hashCode;
    }
}
