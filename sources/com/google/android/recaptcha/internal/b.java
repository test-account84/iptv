package com.google.android.recaptcha.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class b {
    public static /* bridge */ /* synthetic */ ApplicationInfo a(PackageManager packageManager, String str, PackageManager.ApplicationInfoFlags applicationInfoFlags) {
        return packageManager.getApplicationInfo(str, applicationInfoFlags);
    }
}
