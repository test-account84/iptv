package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UsernameConfigurationType implements Serializable {
    private Boolean caseSensitive;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UsernameConfigurationType)) {
            return false;
        }
        UsernameConfigurationType usernameConfigurationType = (UsernameConfigurationType) obj;
        if ((usernameConfigurationType.getCaseSensitive() == null) ^ (getCaseSensitive() == null)) {
            return false;
        }
        return usernameConfigurationType.getCaseSensitive() == null || usernameConfigurationType.getCaseSensitive().equals(getCaseSensitive());
    }

    public Boolean getCaseSensitive() {
        return this.caseSensitive;
    }

    public int hashCode() {
        return 31 + (getCaseSensitive() == null ? 0 : getCaseSensitive().hashCode());
    }

    public Boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    public void setCaseSensitive(Boolean bool) {
        this.caseSensitive = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCaseSensitive() != null) {
            sb.append("CaseSensitive: " + getCaseSensitive());
        }
        sb.append("}");
        return sb.toString();
    }

    public UsernameConfigurationType withCaseSensitive(Boolean bool) {
        this.caseSensitive = bool;
        return this;
    }
}
