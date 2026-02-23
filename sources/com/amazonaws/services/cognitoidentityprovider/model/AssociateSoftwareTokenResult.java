package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AssociateSoftwareTokenResult implements Serializable {
    private String secretCode;
    private String session;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssociateSoftwareTokenResult)) {
            return false;
        }
        AssociateSoftwareTokenResult associateSoftwareTokenResult = (AssociateSoftwareTokenResult) obj;
        if ((associateSoftwareTokenResult.getSecretCode() == null) ^ (getSecretCode() == null)) {
            return false;
        }
        if (associateSoftwareTokenResult.getSecretCode() != null && !associateSoftwareTokenResult.getSecretCode().equals(getSecretCode())) {
            return false;
        }
        if ((associateSoftwareTokenResult.getSession() == null) ^ (getSession() == null)) {
            return false;
        }
        return associateSoftwareTokenResult.getSession() == null || associateSoftwareTokenResult.getSession().equals(getSession());
    }

    public String getSecretCode() {
        return this.secretCode;
    }

    public String getSession() {
        return this.session;
    }

    public int hashCode() {
        return (((getSecretCode() == null ? 0 : getSecretCode().hashCode()) + 31) * 31) + (getSession() != null ? getSession().hashCode() : 0);
    }

    public void setSecretCode(String str) {
        this.secretCode = str;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSecretCode() != null) {
            sb.append("SecretCode: " + getSecretCode() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssociateSoftwareTokenResult withSecretCode(String str) {
        this.secretCode = str;
        return this;
    }

    public AssociateSoftwareTokenResult withSession(String str) {
        this.session = str;
        return this;
    }
}
