package com.google.android.recaptcha.internal;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class d {
    public static /* bridge */ /* synthetic */ PackageInfo a(PackageManager packageManager, String str, PackageManager.PackageInfoFlags packageInfoFlags) {
        return packageManager.getPackageInfo(str, packageInfoFlags);
    }
}
