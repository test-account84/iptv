package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ResendConfirmationCodeResult implements Serializable {
    private CodeDeliveryDetailsType codeDeliveryDetails;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ResendConfirmationCodeResult)) {
            return false;
        }
        ResendConfirmationCodeResult resendConfirmationCodeResult = (ResendConfirmationCodeResult) obj;
        if ((resendConfirmationCodeResult.getCodeDeliveryDetails() == null) ^ (getCodeDeliveryDetails() == null)) {
            return false;
        }
        return resendConfirmationCodeResult.getCodeDeliveryDetails() == null || resendConfirmationCodeResult.getCodeDeliveryDetails().equals(getCodeDeliveryDetails());
    }

    public CodeDeliveryDetailsType getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public int hashCode() {
        return 31 + (getCodeDeliveryDetails() == null ? 0 : getCodeDeliveryDetails().hashCode());
    }

    public void setCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCodeDeliveryDetails() != null) {
            sb.append("CodeDeliveryDetails: " + getCodeDeliveryDetails());
        }
        sb.append("}");
        return sb.toString();
    }

    public ResendConfirmationCodeResult withCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
        return this;
    }
}
