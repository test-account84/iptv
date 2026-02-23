package com.amplifyframework.auth.result.step;

import O.c;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AuthNextUpdateAttributeStep {
    private final Map additionalInfo;
    private final AuthCodeDeliveryDetails codeDeliveryDetails;
    private final AuthUpdateAttributeStep updateAttributeStep;

    public AuthNextUpdateAttributeStep(AuthUpdateAttributeStep authUpdateAttributeStep, Map map, AuthCodeDeliveryDetails authCodeDeliveryDetails) {
        Objects.requireNonNull(authUpdateAttributeStep);
        this.updateAttributeStep = authUpdateAttributeStep;
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
        if (obj == null || AuthNextUpdateAttributeStep.class != obj.getClass()) {
            return false;
        }
        AuthNextUpdateAttributeStep authNextUpdateAttributeStep = (AuthNextUpdateAttributeStep) obj;
        return c.a(getUpdateAttributeStep(), authNextUpdateAttributeStep.getUpdateAttributeStep()) && c.a(getAdditionalInfo(), authNextUpdateAttributeStep.getAdditionalInfo()) && c.a(getCodeDeliveryDetails(), authNextUpdateAttributeStep.getCodeDeliveryDetails());
    }

    public Map getAdditionalInfo() {
        return this.additionalInfo;
    }

    public AuthCodeDeliveryDetails getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public AuthUpdateAttributeStep getUpdateAttributeStep() {
        return this.updateAttributeStep;
    }

    public int hashCode() {
        return c.b(getUpdateAttributeStep(), getAdditionalInfo(), getCodeDeliveryDetails());
    }

    public String toString() {
        return "AuthNextUpdateAttributeStep{updateAttributeStep=" + getUpdateAttributeStep() + ", additionalInfo=" + getAdditionalInfo() + ", codeDeliveryDetails=" + getCodeDeliveryDetails() + '}';
    }
}
