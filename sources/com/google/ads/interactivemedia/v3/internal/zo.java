package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zo {
    public final Object a;
    public final Object b;

    public zo(bf bfVar, int... iArr) {
        this(bfVar, iArr, null);
    }

    public final void a(long j) {
        for (ue ueVar : (ue[]) this.b) {
            ueVar.D(j);
        }
    }

    public final int[] b() {
        int[] iArr = new int[((ue[]) this.b).length];
        int i = 0;
        while (true) {
            ue[] ueVarArr = (ue[]) this.b;
            if (i >= ueVarArr.length) {
                return iArr;
            }
            iArr[i] = ueVarArr[i].m();
            i++;
        }
    }

    public final aae c(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = (int[]) this.a;
            if (i2 >= iArr.length) {
                cd.b("BaseMediaChunkOutput", "Unmatched track of type: " + i);
                return new zg();
            }
            if (i == iArr[i2]) {
                return ((ue[]) this.b)[i2];
            }
            i2++;
        }
    }

    public final String d() {
        return (String) this.a;
    }

    public final byte[] e() {
        return (byte[]) this.b;
    }

    public zo(bf bfVar, int[] iArr, byte[] bArr) {
        if (iArr.length == 0) {
            cd.c("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.b = bfVar;
        this.a = iArr;
    }

    public zo(zd zdVar) {
        this.b = zdVar;
        this.a = new AtomicBoolean(false);
    }

    public zo(byte[] bArr, String str) {
        this.b = bArr;
        this.a = str;
    }

    public zo(int[] iArr, ue[] ueVarArr) {
        this.a = iArr;
        this.b = ueVarArr;
    }
}
