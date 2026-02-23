package com.google.ads.interactivemedia.v3.internal;

import android.app.AppOpsManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aoe implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ aof a;

    public aoe(aof aofVar) {
        this.a = aofVar;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        aof aofVar;
        boolean z2;
        if (z) {
            aof.g(this.a, System.currentTimeMillis());
            aofVar = this.a;
            z2 = true;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            aof aofVar2 = this.a;
            if (aof.a(aofVar2) > 0 && currentTimeMillis >= aof.a(aofVar2)) {
                aof.e(aofVar2, currentTimeMillis - aof.a(aofVar2));
            }
            aofVar = this.a;
            z2 = false;
        }
        aof.f(aofVar, z2);
    }
}
