package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SoftwareTokenMfaConfigType implements Serializable {
    private Boolean enabled;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SoftwareTokenMfaConfigType)) {
            return false;
        }
        SoftwareTokenMfaConfigType softwareTokenMfaConfigType = (SoftwareTokenMfaConfigType) obj;
        if ((softwareTokenMfaConfigType.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        return softwareTokenMfaConfigType.getEnabled() == null || softwareTokenMfaConfigType.getEnabled().equals(getEnabled());
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public int hashCode() {
        return 31 + (getEnabled() == null ? 0 : getEnabled().hashCode());
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled());
        }
        sb.append("}");
        return sb.toString();
    }

    public SoftwareTokenMfaConfigType withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }
}
