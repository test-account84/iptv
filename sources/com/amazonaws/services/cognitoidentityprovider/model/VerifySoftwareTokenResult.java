package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class VerifySoftwareTokenResult implements Serializable {
    private String session;
    private String status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifySoftwareTokenResult)) {
            return false;
        }
        VerifySoftwareTokenResult verifySoftwareTokenResult = (VerifySoftwareTokenResult) obj;
        if ((verifySoftwareTokenResult.getStatus() == null) ^ (getStatus() == null)) {
            return false;
        }
        if (verifySoftwareTokenResult.getStatus() != null && !verifySoftwareTokenResult.getStatus().equals(getStatus())) {
            return false;
        }
        if ((verifySoftwareTokenResult.getSession() == null) ^ (getSession() == null)) {
            return false;
        }
        return verifySoftwareTokenResult.getSession() == null || verifySoftwareTokenResult.getSession().equals(getSession());
    }

    public String getSession() {
        return this.session;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((getStatus() == null ? 0 : getStatus().hashCode()) + 31) * 31) + (getSession() != null ? getSession().hashCode() : 0);
    }

    public void setSession(String str) {
        this.session = str;
    }

    public void setStatus(VerifySoftwareTokenResponseType verifySoftwareTokenResponseType) {
        this.status = verifySoftwareTokenResponseType.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifySoftwareTokenResult withSession(String str) {
        this.session = str;
        return this;
    }

    public VerifySoftwareTokenResult withStatus(VerifySoftwareTokenResponseType verifySoftwareTokenResponseType) {
        this.status = verifySoftwareTokenResponseType.toString();
        return this;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public VerifySoftwareTokenResult withStatus(String str) {
        this.status = str;
        return this;
    }
}
