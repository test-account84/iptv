package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SetUserSettingsRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private List mFAOptions;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetUserSettingsRequest)) {
            return false;
        }
        SetUserSettingsRequest setUserSettingsRequest = (SetUserSettingsRequest) obj;
        if ((setUserSettingsRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        if (setUserSettingsRequest.getAccessToken() != null && !setUserSettingsRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if ((setUserSettingsRequest.getMFAOptions() == null) ^ (getMFAOptions() == null)) {
            return false;
        }
        return setUserSettingsRequest.getMFAOptions() == null || setUserSettingsRequest.getMFAOptions().equals(getMFAOptions());
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public List getMFAOptions() {
        return this.mFAOptions;
    }

    public int hashCode() {
        return (((getAccessToken() == null ? 0 : getAccessToken().hashCode()) + 31) * 31) + (getMFAOptions() != null ? getMFAOptions().hashCode() : 0);
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setMFAOptions(Collection collection) {
        if (collection == null) {
            this.mFAOptions = null;
        } else {
            this.mFAOptions = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getMFAOptions() != null) {
            sb.append("MFAOptions: " + getMFAOptions());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetUserSettingsRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public SetUserSettingsRequest withMFAOptions(Collection collection) {
        setMFAOptions(collection);
        return this;
    }

    public SetUserSettingsRequest withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }
}
