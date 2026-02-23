package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SetUICustomizationResult implements Serializable {
    private UICustomizationType uICustomization;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetUICustomizationResult)) {
            return false;
        }
        SetUICustomizationResult setUICustomizationResult = (SetUICustomizationResult) obj;
        if ((setUICustomizationResult.getUICustomization() == null) ^ (getUICustomization() == null)) {
            return false;
        }
        return setUICustomizationResult.getUICustomization() == null || setUICustomizationResult.getUICustomization().equals(getUICustomization());
    }

    public UICustomizationType getUICustomization() {
        return this.uICustomization;
    }

    public int hashCode() {
        return 31 + (getUICustomization() == null ? 0 : getUICustomization().hashCode());
    }

    public void setUICustomization(UICustomizationType uICustomizationType) {
        this.uICustomization = uICustomizationType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUICustomization() != null) {
            sb.append("UICustomization: " + getUICustomization());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetUICustomizationResult withUICustomization(UICustomizationType uICustomizationType) {
        this.uICustomization = uICustomizationType;
        return this;
    }
}
