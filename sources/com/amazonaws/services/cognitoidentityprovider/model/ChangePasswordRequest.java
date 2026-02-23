package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ChangePasswordRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String previousPassword;
    private String proposedPassword;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChangePasswordRequest)) {
            return false;
        }
        ChangePasswordRequest changePasswordRequest = (ChangePasswordRequest) obj;
        if ((changePasswordRequest.getPreviousPassword() == null) ^ (getPreviousPassword() == null)) {
            return false;
        }
        if (changePasswordRequest.getPreviousPassword() != null && !changePasswordRequest.getPreviousPassword().equals(getPreviousPassword())) {
            return false;
        }
        if ((changePasswordRequest.getProposedPassword() == null) ^ (getProposedPassword() == null)) {
            return false;
        }
        if (changePasswordRequest.getProposedPassword() != null && !changePasswordRequest.getProposedPassword().equals(getProposedPassword())) {
            return false;
        }
        if ((changePasswordRequest.getAccessToken() == null) ^ (getAccessToken() == null)) {
            return false;
        }
        return changePasswordRequest.getAccessToken() == null || changePasswordRequest.getAccessToken().equals(getAccessToken());
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getPreviousPassword() {
        return this.previousPassword;
    }

    public String getProposedPassword() {
        return this.proposedPassword;
    }

    public int hashCode() {
        return (((((getPreviousPassword() == null ? 0 : getPreviousPassword().hashCode()) + 31) * 31) + (getProposedPassword() == null ? 0 : getProposedPassword().hashCode())) * 31) + (getAccessToken() != null ? getAccessToken().hashCode() : 0);
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setPreviousPassword(String str) {
        this.previousPassword = str;
    }

    public void setProposedPassword(String str) {
        this.proposedPassword = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPreviousPassword() != null) {
            sb.append("PreviousPassword: " + getPreviousPassword() + ",");
        }
        if (getProposedPassword() != null) {
            sb.append("ProposedPassword: " + getProposedPassword() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ChangePasswordRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public ChangePasswordRequest withPreviousPassword(String str) {
        this.previousPassword = str;
        return this;
    }

    public ChangePasswordRequest withProposedPassword(String str) {
        this.proposedPassword = str;
        return this;
    }
}
