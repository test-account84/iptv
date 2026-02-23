package com.amplifyframework.auth.cognito.options;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum AuthFlowType {
    USER_SRP_AUTH("USER_SRP_AUTH"),
    CUSTOM_AUTH("CUSTOM_AUTH"),
    USER_PASSWORD_AUTH("USER_PASSWORD_AUTH");

    private String value;

    AuthFlowType(String str) {
        this.value = str;
    }
}
