package com.facebook.ads.internal.bridge.fbsdk;

import android.annotation.SuppressLint;
import androidx.annotation.Keep;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class FBLoginASID {
    @SuppressLint({"CatchGeneralException"})
    public static String getFBLoginASID() {
        try {
            Object invoke = Class.forName("com.facebook.AccessToken").getDeclaredMethod("getCurrentAccessToken", (Class[]) null).invoke((Object) null, (Object[]) null);
            if (invoke != null) {
                return (String) Class.forName("com.facebook.AccessToken").getDeclaredMethod("getUserId", (Class[]) null).invoke(invoke, (Object[]) null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
