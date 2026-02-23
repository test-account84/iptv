package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aol extends apj {
    public aol(anw anwVar, agl aglVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "YC+pJVOZY25wDvtlWBPChLSjLU0iUh44DqTcbsbdAncZlcvrsOhFkSGXkkm3Hf4Z", "a17x9Lt/WQTGhUJAM6t8VqFWsXteADIsbbHvy7b7aMM=", aglVar, i, 5, null, null, null);
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        this.g.V(-1L);
        this.g.U(-1L);
        int[] iArr = (int[]) this.d.invoke((Object) null, new Object[]{this.a.b()});
        synchronized (this.g) {
            try {
                this.g.V(iArr[0]);
                this.g.U(iArr[1]);
                int i = iArr[2];
                if (i != Integer.MIN_VALUE) {
                    this.g.T(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
