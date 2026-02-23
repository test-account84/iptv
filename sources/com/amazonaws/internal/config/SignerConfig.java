package com.amazonaws.internal.config;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignerConfig {
    private final String signerType;

    public SignerConfig(SignerConfig signerConfig) {
        this.signerType = signerConfig.getSignerType();
    }

    public String getSignerType() {
        return this.signerType;
    }

    public String toString() {
        return this.signerType;
    }

    public SignerConfig(String str) {
        this.signerType = str;
    }
}
