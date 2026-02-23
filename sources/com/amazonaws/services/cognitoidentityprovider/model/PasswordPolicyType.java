package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PasswordPolicyType implements Serializable {
    private Integer minimumLength;
    private Boolean requireLowercase;
    private Boolean requireNumbers;
    private Boolean requireSymbols;
    private Boolean requireUppercase;
    private Integer temporaryPasswordValidityDays;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PasswordPolicyType)) {
            return false;
        }
        PasswordPolicyType passwordPolicyType = (PasswordPolicyType) obj;
        if ((passwordPolicyType.getMinimumLength() == null) ^ (getMinimumLength() == null)) {
            return false;
        }
        if (passwordPolicyType.getMinimumLength() != null && !passwordPolicyType.getMinimumLength().equals(getMinimumLength())) {
            return false;
        }
        if ((passwordPolicyType.getRequireUppercase() == null) ^ (getRequireUppercase() == null)) {
            return false;
        }
        if (passwordPolicyType.getRequireUppercase() != null && !passwordPolicyType.getRequireUppercase().equals(getRequireUppercase())) {
            return false;
        }
        if ((passwordPolicyType.getRequireLowercase() == null) ^ (getRequireLowercase() == null)) {
            return false;
        }
        if (passwordPolicyType.getRequireLowercase() != null && !passwordPolicyType.getRequireLowercase().equals(getRequireLowercase())) {
            return false;
        }
        if ((passwordPolicyType.getRequireNumbers() == null) ^ (getRequireNumbers() == null)) {
            return false;
        }
        if (passwordPolicyType.getRequireNumbers() != null && !passwordPolicyType.getRequireNumbers().equals(getRequireNumbers())) {
            return false;
        }
        if ((passwordPolicyType.getRequireSymbols() == null) ^ (getRequireSymbols() == null)) {
            return false;
        }
        if (passwordPolicyType.getRequireSymbols() != null && !passwordPolicyType.getRequireSymbols().equals(getRequireSymbols())) {
            return false;
        }
        if ((passwordPolicyType.getTemporaryPasswordValidityDays() == null) ^ (getTemporaryPasswordValidityDays() == null)) {
            return false;
        }
        return passwordPolicyType.getTemporaryPasswordValidityDays() == null || passwordPolicyType.getTemporaryPasswordValidityDays().equals(getTemporaryPasswordValidityDays());
    }

    public Integer getMinimumLength() {
        return this.minimumLength;
    }

    public Boolean getRequireLowercase() {
        return this.requireLowercase;
    }

    public Boolean getRequireNumbers() {
        return this.requireNumbers;
    }

    public Boolean getRequireSymbols() {
        return this.requireSymbols;
    }

    public Boolean getRequireUppercase() {
        return this.requireUppercase;
    }

    public Integer getTemporaryPasswordValidityDays() {
        return this.temporaryPasswordValidityDays;
    }

    public int hashCode() {
        return (((((((((((getMinimumLength() == null ? 0 : getMinimumLength().hashCode()) + 31) * 31) + (getRequireUppercase() == null ? 0 : getRequireUppercase().hashCode())) * 31) + (getRequireLowercase() == null ? 0 : getRequireLowercase().hashCode())) * 31) + (getRequireNumbers() == null ? 0 : getRequireNumbers().hashCode())) * 31) + (getRequireSymbols() == null ? 0 : getRequireSymbols().hashCode())) * 31) + (getTemporaryPasswordValidityDays() != null ? getTemporaryPasswordValidityDays().hashCode() : 0);
    }

    public Boolean isRequireLowercase() {
        return this.requireLowercase;
    }

    public Boolean isRequireNumbers() {
        return this.requireNumbers;
    }

    public Boolean isRequireSymbols() {
        return this.requireSymbols;
    }

    public Boolean isRequireUppercase() {
        return this.requireUppercase;
    }

    public void setMinimumLength(Integer num) {
        this.minimumLength = num;
    }

    public void setRequireLowercase(Boolean bool) {
        this.requireLowercase = bool;
    }

    public void setRequireNumbers(Boolean bool) {
        this.requireNumbers = bool;
    }

    public void setRequireSymbols(Boolean bool) {
        this.requireSymbols = bool;
    }

    public void setRequireUppercase(Boolean bool) {
        this.requireUppercase = bool;
    }

    public void setTemporaryPasswordValidityDays(Integer num) {
        this.temporaryPasswordValidityDays = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getMinimumLength() != null) {
            sb.append("MinimumLength: " + getMinimumLength() + ",");
        }
        if (getRequireUppercase() != null) {
            sb.append("RequireUppercase: " + getRequireUppercase() + ",");
        }
        if (getRequireLowercase() != null) {
            sb.append("RequireLowercase: " + getRequireLowercase() + ",");
        }
        if (getRequireNumbers() != null) {
            sb.append("RequireNumbers: " + getRequireNumbers() + ",");
        }
        if (getRequireSymbols() != null) {
            sb.append("RequireSymbols: " + getRequireSymbols() + ",");
        }
        if (getTemporaryPasswordValidityDays() != null) {
            sb.append("TemporaryPasswordValidityDays: " + getTemporaryPasswordValidityDays());
        }
        sb.append("}");
        return sb.toString();
    }

    public PasswordPolicyType withMinimumLength(Integer num) {
        this.minimumLength = num;
        return this;
    }

    public PasswordPolicyType withRequireLowercase(Boolean bool) {
        this.requireLowercase = bool;
        return this;
    }

    public PasswordPolicyType withRequireNumbers(Boolean bool) {
        this.requireNumbers = bool;
        return this;
    }

    public PasswordPolicyType withRequireSymbols(Boolean bool) {
        this.requireSymbols = bool;
        return this;
    }

    public PasswordPolicyType withRequireUppercase(Boolean bool) {
        this.requireUppercase = bool;
        return this;
    }

    public PasswordPolicyType withTemporaryPasswordValidityDays(Integer num) {
        this.temporaryPasswordValidityDays = num;
        return this;
    }
}
