package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetSigningCertificateResult implements Serializable {
    private String certificate;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSigningCertificateResult)) {
            return false;
        }
        GetSigningCertificateResult getSigningCertificateResult = (GetSigningCertificateResult) obj;
        if ((getSigningCertificateResult.getCertificate() == null) ^ (getCertificate() == null)) {
            return false;
        }
        return getSigningCertificateResult.getCertificate() == null || getSigningCertificateResult.getCertificate().equals(getCertificate());
    }

    public String getCertificate() {
        return this.certificate;
    }

    public int hashCode() {
        return 31 + (getCertificate() == null ? 0 : getCertificate().hashCode());
    }

    public void setCertificate(String str) {
        this.certificate = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCertificate() != null) {
            sb.append("Certificate: " + getCertificate());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetSigningCertificateResult withCertificate(String str) {
        this.certificate = str;
        return this;
    }
}
