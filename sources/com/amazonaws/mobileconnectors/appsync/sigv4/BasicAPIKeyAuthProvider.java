package com.amazonaws.mobileconnectors.appsync.sigv4;

import android.util.Log;
import com.amazonaws.mobile.config.AWSConfiguration;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class BasicAPIKeyAuthProvider implements APIKeyAuthProvider {
    private static final String TAG = "BasicAPIKeyAuthProvider";
    private final String apiKey;

    public BasicAPIKeyAuthProvider(AWSConfiguration aWSConfiguration) {
        try {
            this.apiKey = aWSConfiguration.optJsonObject("AppSync").getString("ApiKey");
        } catch (Exception e) {
            Log.e(TAG, "Please check the ApiKey passed from awsconfiguration.json.");
            throw new RuntimeException("Please check the ApiKey passed from awsconfiguration.json.", e);
        }
    }

    public String getAPIKey() {
        return this.apiKey;
    }

    public BasicAPIKeyAuthProvider(String str) {
        this.apiKey = str;
    }
}
