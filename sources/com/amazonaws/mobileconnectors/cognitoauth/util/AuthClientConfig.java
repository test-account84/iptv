package com.amazonaws.mobileconnectors.cognitoauth.util;

import java.security.InvalidParameterException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthClientConfig {
    private static long REFRESH_THRESHOLD_MAX = 1800000;
    private static long REFRESH_THRESHOLD_MIN = 0;
    private static long refreshThreshold = 300000;

    public static long getRefreshThreshold() {
        return refreshThreshold;
    }

    public static void setRefreshThreshold(long j) throws InvalidParameterException {
        if (j > REFRESH_THRESHOLD_MAX || j < REFRESH_THRESHOLD_MIN) {
            throw new InvalidParameterException(String.format("The value of refreshThreshold must between %d and %d seconds", new Object[]{Long.valueOf(REFRESH_THRESHOLD_MIN), Long.valueOf(REFRESH_THRESHOLD_MAX)}));
        }
        refreshThreshold = j;
    }
}
