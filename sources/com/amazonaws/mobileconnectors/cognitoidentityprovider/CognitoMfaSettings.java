package com.amazonaws.mobileconnectors.cognitoidentityprovider;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CognitoMfaSettings {
    public static final String SMS_MFA = "SMS_MFA";
    public static final String TOTP_MFA = "TOTP_MFA";
    private String mfaName;
    private boolean enabled = false;
    private boolean preferred = false;

    private CognitoMfaSettings() {
    }

    public String getMfaName() {
        return this.mfaName;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isPreferred() {
        return this.preferred;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setPreferred(boolean z) {
        this.preferred = z;
    }

    public CognitoMfaSettings(String str) {
        this.mfaName = str;
    }
}
