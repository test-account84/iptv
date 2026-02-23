package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class CognitoIdentityProviderClientConfig {
    private static final long REFRESH_THRESHOLD_DEFAULT = 120000;
    private static final long REFRESH_THRESHOLD_MAX = 1800000;
    private static final long REFRESH_THRESHOLD_MIN = 0;
    private static long refreshThreshold = 120000;

    public static long getRefreshThreshold() {
        return refreshThreshold;
    }

    public static void setRefreshThreshold(long j) {
        if (j > 1800000 || j < 0) {
            throw new CognitoParameterInvalidException(String.format("The value of refreshThreshold must between %d and %d milliseconds", new Object[]{0L, 1800000L}));
        }
        refreshThreshold = j;
    }
}
