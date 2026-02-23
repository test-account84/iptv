package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminSetUserSettingsRequest extends AmazonWebServiceRequest implements Serializable {
    private List mFAOptions;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminSetUserSettingsRequest)) {
            return false;
        }
        AdminSetUserSettingsRequest adminSetUserSettingsRequest = (AdminSetUserSettingsRequest) obj;
        if ((adminSetUserSettingsRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminSetUserSettingsRequest.getUserPoolId() != null && !adminSetUserSettingsRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminSetUserSettingsRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminSetUserSettingsRequest.getUsername() != null && !adminSetUserSettingsRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminSetUserSettingsRequest.getMFAOptions() == null) ^ (getMFAOptions() == null)) {
            return false;
        }
        return adminSetUserSettingsRequest.getMFAOptions() == null || adminSetUserSettingsRequest.getMFAOptions().equals(getMFAOptions());
    }

    public List getMFAOptions() {
        return this.mFAOptions;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getMFAOptions() != null ? getMFAOptions().hashCode() : 0);
    }

    public void setMFAOptions(Collection collection) {
        if (collection == null) {
            this.mFAOptions = null;
        } else {
            this.mFAOptions = new ArrayList(collection);
        }
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getMFAOptions() != null) {
            sb.append("MFAOptions: " + getMFAOptions());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminSetUserSettingsRequest withMFAOptions(Collection collection) {
        setMFAOptions(collection);
        return this;
    }

    public AdminSetUserSettingsRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminSetUserSettingsRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public AdminSetUserSettingsRequest withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }
}
