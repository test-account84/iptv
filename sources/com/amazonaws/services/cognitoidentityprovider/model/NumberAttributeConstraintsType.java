package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class NumberAttributeConstraintsType implements Serializable {
    private String maxValue;
    private String minValue;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NumberAttributeConstraintsType)) {
            return false;
        }
        NumberAttributeConstraintsType numberAttributeConstraintsType = (NumberAttributeConstraintsType) obj;
        if ((numberAttributeConstraintsType.getMinValue() == null) ^ (getMinValue() == null)) {
            return false;
        }
        if (numberAttributeConstraintsType.getMinValue() != null && !numberAttributeConstraintsType.getMinValue().equals(getMinValue())) {
            return false;
        }
        if ((numberAttributeConstraintsType.getMaxValue() == null) ^ (getMaxValue() == null)) {
            return false;
        }
        return numberAttributeConstraintsType.getMaxValue() == null || numberAttributeConstraintsType.getMaxValue().equals(getMaxValue());
    }

    public String getMaxValue() {
        return this.maxValue;
    }

    public String getMinValue() {
        return this.minValue;
    }

    public int hashCode() {
        return (((getMinValue() == null ? 0 : getMinValue().hashCode()) + 31) * 31) + (getMaxValue() != null ? getMaxValue().hashCode() : 0);
    }

    public void setMaxValue(String str) {
        this.maxValue = str;
    }

    public void setMinValue(String str) {
        this.minValue = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getMinValue() != null) {
            sb.append("MinValue: " + getMinValue() + ",");
        }
        if (getMaxValue() != null) {
            sb.append("MaxValue: " + getMaxValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public NumberAttributeConstraintsType withMaxValue(String str) {
        this.maxValue = str;
        return this;
    }

    public NumberAttributeConstraintsType withMinValue(String str) {
        this.minValue = str;
        return this;
    }
}
