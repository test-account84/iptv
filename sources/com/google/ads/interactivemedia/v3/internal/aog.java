package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aog extends apj {
    private final Activity h;
    private final View i;

    public aog(anw anwVar, agl aglVar, int i, View view, Activity activity, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "rE+CHn9CLSmLsY/LfivBx+DmSmQMCqSMhAImHDd3dGWtfWUTJAZt/SbpXoR2i5+S", "XOTxexwsk5wzpmsanl+x8sPTZMmLepw+z7JZ/NtNU48=", aglVar, i, 62, null, null, null);
        this.i = view;
        this.h = activity;
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.i == null) {
            return;
        }
        Boolean bool = (Boolean) aqo.m.f();
        boolean booleanValue = bool.booleanValue();
        Object[] objArr = (Object[]) this.d.invoke((Object) null, new Object[]{this.i, this.h, bool});
        synchronized (this.g) {
            try {
                this.g.L(((Long) objArr[0]).longValue());
                this.g.N(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.g.M((String) objArr[2]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
