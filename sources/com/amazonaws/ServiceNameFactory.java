package com.amazonaws;

import com.amazonaws.internal.config.HttpClientConfig;
import com.amazonaws.internal.config.InternalConfig;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
enum ServiceNameFactory {
    ;

    public static String getServiceName(String str) {
        HttpClientConfig httpClientConfig = InternalConfig.Factory.getInternalConfig().getHttpClientConfig(str);
        if (httpClientConfig == null) {
            return null;
        }
        return httpClientConfig.getServiceName();
    }
}
