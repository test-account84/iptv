package com.amplifyframework.auth.result.step;

import O.c;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthNextResetPasswordStep {
    private final Map additionalInfo;
    private final AuthCodeDeliveryDetails codeDeliveryDetails;
    private final AuthResetPasswordStep resetPasswordStep;

    public AuthNextResetPasswordStep(AuthResetPasswordStep authResetPasswordStep, Map map, AuthCodeDeliveryDetails authCodeDeliveryDetails) {
        Objects.requireNonNull(authResetPasswordStep);
        this.resetPasswordStep = authResetPasswordStep;
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
        if (obj == null || AuthNextResetPasswordStep.class != obj.getClass()) {
            return false;
        }
        AuthNextResetPasswordStep authNextResetPasswordStep = (AuthNextResetPasswordStep) obj;
        return c.a(getResetPasswordStep(), authNextResetPasswordStep.getResetPasswordStep()) && c.a(getAdditionalInfo(), authNextResetPasswordStep.getAdditionalInfo()) && c.a(getCodeDeliveryDetails(), authNextResetPasswordStep.getCodeDeliveryDetails());
    }

    public Map getAdditionalInfo() {
        return this.additionalInfo;
    }

    public AuthCodeDeliveryDetails getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public AuthResetPasswordStep getResetPasswordStep() {
        return this.resetPasswordStep;
    }

    public int hashCode() {
        return c.b(getResetPasswordStep(), getAdditionalInfo(), getCodeDeliveryDetails());
    }

    public String toString() {
        return "AuthNextResetPasswordStep{resetPasswordStep=" + getResetPasswordStep() + ", additionalInfo=" + getAdditionalInfo() + ", codeDeliveryDetails=" + getCodeDeliveryDetails() + '}';
    }
}
