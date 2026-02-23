package com.onesignal;

import android.content.Context;
import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class y {
    public final Context a;
    public final Intent b;
    public final boolean c;

    public y(Context context, Intent intent, boolean z) {
        kotlin.jvm.internal.l.e(context, "context");
        this.a = context;
        this.b = intent;
        this.c = z;
    }

    public final Intent a() {
        Intent launchIntentForPackage;
        if (!this.c || (launchIntentForPackage = this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName())) == null) {
            return null;
        }
        launchIntentForPackage.setPackage((String) null);
        launchIntentForPackage.setFlags(270532608);
        return launchIntentForPackage;
    }

    public final Intent b() {
        Intent intent = this.b;
        return intent != null ? intent : a();
    }
}
