package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserPoolPolicyType implements Serializable {
    private PasswordPolicyType passwordPolicy;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolPolicyType)) {
            return false;
        }
        UserPoolPolicyType userPoolPolicyType = (UserPoolPolicyType) obj;
        if ((userPoolPolicyType.getPasswordPolicy() == null) ^ (getPasswordPolicy() == null)) {
            return false;
        }
        return userPoolPolicyType.getPasswordPolicy() == null || userPoolPolicyType.getPasswordPolicy().equals(getPasswordPolicy());
    }

    public PasswordPolicyType getPasswordPolicy() {
        return this.passwordPolicy;
    }

    public int hashCode() {
        return 31 + (getPasswordPolicy() == null ? 0 : getPasswordPolicy().hashCode());
    }

    public void setPasswordPolicy(PasswordPolicyType passwordPolicyType) {
        this.passwordPolicy = passwordPolicyType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPasswordPolicy() != null) {
            sb.append("PasswordPolicy: " + getPasswordPolicy());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserPoolPolicyType withPasswordPolicy(PasswordPolicyType passwordPolicyType) {
        this.passwordPolicy = passwordPolicyType;
        return this;
    }
}
