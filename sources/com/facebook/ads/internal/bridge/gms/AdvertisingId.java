package com.facebook.ads.internal.bridge.gms;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import h4.a;

@Keep
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdvertisingId {
    private final String mId;
    private final boolean mLimitAdTracking;

    public AdvertisingId(String str, boolean z) {
        this.mId = str;
        this.mLimitAdTracking = z;
    }

    @SuppressLint({"CatchGeneralException"})
    public static AdvertisingId getAdvertisingIdInfoDirectly(Context context) {
        try {
            a.a a = a.a(context);
            if (a != null) {
                return new AdvertisingId(a.a(), a.b());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getId() {
        return this.mId;
    }

    public boolean isLimitAdTracking() {
        return this.mLimitAdTracking;
    }
}
