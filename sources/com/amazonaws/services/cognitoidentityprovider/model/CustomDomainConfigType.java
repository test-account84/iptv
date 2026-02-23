package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CustomDomainConfigType implements Serializable {
    private String certificateArn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CustomDomainConfigType)) {
            return false;
        }
        CustomDomainConfigType customDomainConfigType = (CustomDomainConfigType) obj;
        if ((customDomainConfigType.getCertificateArn() == null) ^ (getCertificateArn() == null)) {
            return false;
        }
        return customDomainConfigType.getCertificateArn() == null || customDomainConfigType.getCertificateArn().equals(getCertificateArn());
    }

    public String getCertificateArn() {
        return this.certificateArn;
    }

    public int hashCode() {
        return 31 + (getCertificateArn() == null ? 0 : getCertificateArn().hashCode());
    }

    public void setCertificateArn(String str) {
        this.certificateArn = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCertificateArn() != null) {
            sb.append("CertificateArn: " + getCertificateArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public CustomDomainConfigType withCertificateArn(String str) {
        this.certificateArn = str;
        return this;
    }
}
