package com.google.ads.interactivemedia.v3.internal;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class apk implements PackageManager.OnChecksumsReadyListener {
    public final /* synthetic */ azi a;

    public /* synthetic */ apk(azi aziVar) {
        this.a = aziVar;
    }

    public final void onChecksumsReady(List list) {
        azi aziVar = this.a;
        if (list == null) {
            aziVar.j(null);
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum a = C.a(list.get(i));
                if (D.a(a) == 8) {
                    aziVar.j(aoa.c(E.a(a)));
                    return;
                }
            }
            aziVar.j(null);
        } catch (Throwable unused) {
            aziVar.j(null);
        }
    }
}
