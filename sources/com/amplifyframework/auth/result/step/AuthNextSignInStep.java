package com.amplifyframework.auth.result.step;

import O.c;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthNextSignInStep {
    private final Map additionalInfo;
    private final AuthCodeDeliveryDetails codeDeliveryDetails;
    private final AuthSignInStep signInStep;

    public AuthNextSignInStep(AuthSignInStep authSignInStep, Map map, AuthCodeDeliveryDetails authCodeDeliveryDetails) {
        Objects.requireNonNull(authSignInStep);
        this.signInStep = authSignInStep;
        HashMap hashMap = new HashMap();
        this.additionalInfo = hashMap;
        Objects.requireNonNull(map);
        hashMap.putAll(map);
        this.codeDeliveryDetails = authCodeDeliveryDetails;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthNextSignInStep.class != obj.getClass()) {
            return false;
        }
        AuthNextSignInStep authNextSignInStep = (AuthNextSignInStep) obj;
        return c.a(getSignInStep(), authNextSignInStep.getSignInStep()) && c.a(getAdditionalInfo(), authNextSignInStep.getAdditionalInfo()) && c.a(getCodeDeliveryDetails(), authNextSignInStep.getCodeDeliveryDetails());
    }

    public Map getAdditionalInfo() {
        return this.additionalInfo;
    }

    public AuthCodeDeliveryDetails getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public AuthSignInStep getSignInStep() {
        return this.signInStep;
    }

    public int hashCode() {
        return c.b(getSignInStep(), getAdditionalInfo(), getCodeDeliveryDetails());
    }

    public String toString() {
        return "AuthNextSignInStep{signInStep=" + getSignInStep() + ", additionalInfo=" + getAdditionalInfo() + ", codeDeliveryDetails=" + getCodeDeliveryDetails() + '}';
    }
}
