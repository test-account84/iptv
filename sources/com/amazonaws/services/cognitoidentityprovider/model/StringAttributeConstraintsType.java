package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class StringAttributeConstraintsType implements Serializable {
    private String maxLength;
    private String minLength;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StringAttributeConstraintsType)) {
            return false;
        }
        StringAttributeConstraintsType stringAttributeConstraintsType = (StringAttributeConstraintsType) obj;
        if ((stringAttributeConstraintsType.getMinLength() == null) ^ (getMinLength() == null)) {
            return false;
        }
        if (stringAttributeConstraintsType.getMinLength() != null && !stringAttributeConstraintsType.getMinLength().equals(getMinLength())) {
            return false;
        }
        if ((stringAttributeConstraintsType.getMaxLength() == null) ^ (getMaxLength() == null)) {
            return false;
        }
        return stringAttributeConstraintsType.getMaxLength() == null || stringAttributeConstraintsType.getMaxLength().equals(getMaxLength());
    }

    public String getMaxLength() {
        return this.maxLength;
    }

    public String getMinLength() {
        return this.minLength;
    }

    public int hashCode() {
        return (((getMinLength() == null ? 0 : getMinLength().hashCode()) + 31) * 31) + (getMaxLength() != null ? getMaxLength().hashCode() : 0);
    }

    public void setMaxLength(String str) {
        this.maxLength = str;
    }

    public void setMinLength(String str) {
        this.minLength = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getMinLength() != null) {
            sb.append("MinLength: " + getMinLength() + ",");
        }
        if (getMaxLength() != null) {
            sb.append("MaxLength: " + getMaxLength());
        }
        sb.append("}");
        return sb.toString();
    }

    public StringAttributeConstraintsType withMaxLength(String str) {
        this.maxLength = str;
        return this;
    }

    public StringAttributeConstraintsType withMinLength(String str) {
        this.minLength = str;
        return this;
    }
}
