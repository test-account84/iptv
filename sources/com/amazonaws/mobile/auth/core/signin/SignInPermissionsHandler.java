package com.amazonaws.mobile.auth.core.signin;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface SignInPermissionsHandler {
    int getPermissionRequestCode();

    void handleRequestPermissionsResult(int i, String[] strArr, int[] iArr);
}
