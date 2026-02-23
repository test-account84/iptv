package com.amazonaws.mobile.client.results;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SignInResult {
    public static final SignInResult DONE = new SignInResult(SignInState.DONE);
    private final UserCodeDeliveryDetails codeDetails;
    private final Map parameters;
    private final SignInState signInState;

    private SignInResult(SignInState signInState) {
        this.signInState = signInState;
        this.parameters = null;
        this.codeDetails = null;
    }

    public UserCodeDeliveryDetails getCodeDetails() {
        return this.codeDetails;
    }

    public Map getParameters() {
        return this.parameters;
    }

    public SignInState getSignInState() {
        return this.signInState;
    }

    public SignInResult(SignInState signInState, UserCodeDeliveryDetails userCodeDeliveryDetails) {
        this.signInState = signInState;
        this.parameters = null;
        this.codeDetails = userCodeDeliveryDetails;
    }

    public SignInResult(SignInState signInState, Map map) {
        this.signInState = signInState;
        this.parameters = map;
        this.codeDetails = null;
    }
}
