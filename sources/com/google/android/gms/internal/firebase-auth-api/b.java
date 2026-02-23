package com.google.android.gms.internal.firebase-auth-api;

import android.content.pm.Signature;
import android.content.pm.SigningInfo;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract /* synthetic */ class b {
    public static /* bridge */ /* synthetic */ Signature[] a(SigningInfo signingInfo) {
        return signingInfo.getApkContentsSigners();
    }
}
