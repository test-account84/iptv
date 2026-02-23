package com.amazonaws.mobile.client.results;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class SignUpResult {
    private final UserCodeDeliveryDetails cognitoUserCodeDeliveryDetails;
    private final boolean signUpConfirmationState;
    private final String userSub;

    public SignUpResult(boolean z, UserCodeDeliveryDetails userCodeDeliveryDetails, String str) {
        this.signUpConfirmationState = z;
        this.cognitoUserCodeDeliveryDetails = userCodeDeliveryDetails;
        this.userSub = str;
    }

    public boolean getConfirmationState() {
        return this.signUpConfirmationState;
    }

    public UserCodeDeliveryDetails getUserCodeDeliveryDetails() {
        return this.cognitoUserCodeDeliveryDetails;
    }

    public String getUserSub() {
        return this.userSub;
    }
}
