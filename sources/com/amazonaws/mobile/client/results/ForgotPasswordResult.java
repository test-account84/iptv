package com.amazonaws.mobile.client.results;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ForgotPasswordResult {
    private UserCodeDeliveryDetails parameters;
    private final ForgotPasswordState state;

    public ForgotPasswordResult(ForgotPasswordState forgotPasswordState) {
        this.state = forgotPasswordState;
    }

    public UserCodeDeliveryDetails getParameters() {
        return this.parameters;
    }

    public ForgotPasswordState getState() {
        return this.state;
    }

    public void setParameters(UserCodeDeliveryDetails userCodeDeliveryDetails) {
        this.parameters = userCodeDeliveryDetails;
    }
}
