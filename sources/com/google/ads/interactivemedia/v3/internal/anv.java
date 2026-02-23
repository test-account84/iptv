package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class anv implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ anw b;

    public anv(anw anwVar, int i) {
        this.b = anwVar;
        this.a = i;
    }

    public final void run() {
        agc agcVar;
        anw anwVar = this.b;
        if (this.a > 0) {
            try {
                Thread.sleep(r1 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            PackageInfo packageInfo = anwVar.a.getPackageManager().getPackageInfo(anwVar.a.getPackageName(), 0);
            Context context = anwVar.a;
            agcVar = asa.b(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused2) {
            agcVar = null;
        }
        anw.l(this.b, agcVar);
        if (this.a < 4) {
            if (agcVar != null && agcVar.aj() && !agcVar.f().equals("0000000000000000000000000000000000000000000000000000000000000000") && agcVar.ak() && agcVar.d().d() && agcVar.d().a() != -2) {
                return;
            }
            this.b.s(this.a + 1);
        }
    }
}
