package com.google.ads.interactivemedia.v3.internal;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aoi extends apj {
    public aoi(anw anwVar, agl aglVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "9iQ5YMaDdmXd2AE0qa10oJyqmGZHX7XNUzgm4wdKztIQI9jbAXaOTiv6toK0AOKU", "rCh66yJZbGwhYsjh3a4o4nMI5ui67q2Fs4U69kJBF3k=", aglVar, i, 49, null, null, null);
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        this.g.aK(agh.c);
        try {
            this.g.aK(((Boolean) this.d.invoke((Object) null, new Object[]{this.a.b()})).booleanValue() ? agh.b : agh.a);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
