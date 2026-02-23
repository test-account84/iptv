package com.amazonaws.mobile.client.results;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public enum MFAOptions {
    SMS_MFA("SMS_MFA"),
    TOTP_MFA("TOTP_MFA");

    private final String serviceText;

    MFAOptions(String str) {
        this.serviceText = str;
    }

    public boolean equals(String str) {
        return this.serviceText.equals(str);
    }

    public String getServiceText() {
        return this.serviceText;
    }
}
