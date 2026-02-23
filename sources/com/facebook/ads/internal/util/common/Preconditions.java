package com.facebook.ads.internal.util.common;

import android.os.Looper;
import androidx.annotation.Keep;
import com.facebook.ads.internal.shield.NoAutoExceptionHandling;

@NoAutoExceptionHandling
@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class Preconditions {
    public static void checkIsOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("Must be called from the UiThread");
        }
    }

    public static void checkIsTrue(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static Object checkNotNull(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException(str);
    }
}
