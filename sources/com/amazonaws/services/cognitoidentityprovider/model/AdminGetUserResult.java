package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminGetUserResult implements Serializable {
    private Boolean enabled;
    private List mFAOptions;
    private String preferredMfaSetting;
    private List userAttributes;
    private Date userCreateDate;
    private Date userLastModifiedDate;
    private List userMFASettingList;
    private String userStatus;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminGetUserResult)) {
            return false;
        }
        AdminGetUserResult adminGetUserResult = (AdminGetUserResult) obj;
        if ((adminGetUserResult.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminGetUserResult.getUsername() != null && !adminGetUserResult.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminGetUserResult.getUserAttributes() == null) ^ (getUserAttributes() == null)) {
            return false;
        }
        if (adminGetUserResult.getUserAttributes() != null && !adminGetUserResult.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if ((adminGetUserResult.getUserCreateDate() == null) ^ (getUserCreateDate() == null)) {
            return false;
        }
        if (adminGetUserResult.getUserCreateDate() != null && !adminGetUserResult.getUserCreateDate().equals(getUserCreateDate())) {
            return false;
        }
        if ((adminGetUserResult.getUserLastModifiedDate() == null) ^ (getUserLastModifiedDate() == null)) {
            return false;
        }
        if (adminGetUserResult.getUserLastModifiedDate() != null && !adminGetUserResult.getUserLastModifiedDate().equals(getUserLastModifiedDate())) {
            return false;
        }
        if ((adminGetUserResult.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        if (adminGetUserResult.getEnabled() != null && !adminGetUserResult.getEnabled().equals(getEnabled())) {
            return false;
        }
        if ((adminGetUserResult.getUserStatus() == null) ^ (getUserStatus() == null)) {
            return false;
        }
        if (adminGetUserResult.getUserStatus() != null && !adminGetUserResult.getUserStatus().equals(getUserStatus())) {
            return false;
        }
        if ((adminGetUserResult.getMFAOptions() == null) ^ (getMFAOptions() == null)) {
            return false;
        }
        if (adminGetUserResult.getMFAOptions() != null && !adminGetUserResult.getMFAOptions().equals(getMFAOptions())) {
            return false;
        }
        if ((adminGetUserResult.getPreferredMfaSetting() == null) ^ (getPreferredMfaSetting() == null)) {
            return false;
        }
        if (adminGetUserResult.getPreferredMfaSetting() != null && !adminGetUserResult.getPreferredMfaSetting().equals(getPreferredMfaSetting())) {
            return false;
        }
        if ((adminGetUserResult.getUserMFASettingList() == null) ^ (getUserMFASettingList() == null)) {
            return false;
        }
        return adminGetUserResult.getUserMFASettingList() == null || adminGetUserResult.getUserMFASettingList().equals(getUserMFASettingList());
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public List getMFAOptions() {
        return this.mFAOptions;
    }

    public String getPreferredMfaSetting() {
        return this.preferredMfaSetting;
    }

    public List getUserAttributes() {
        return this.userAttributes;
    }

    public Date getUserCreateDate() {
        return this.userCreateDate;
    }

    public Date getUserLastModifiedDate() {
        return this.userLastModifiedDate;
    }

    public List getUserMFASettingList() {
        return this.userMFASettingList;
    }

    public String getUserStatus() {
        return this.userStatus;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((((((((((((getUsername() == null ? 0 : getUsername().hashCode()) + 31) * 31) + (getUserAttributes() == null ? 0 : getUserAttributes().hashCode())) * 31) + (getUserCreateDate() == null ? 0 : getUserCreateDate().hashCode())) * 31) + (getUserLastModifiedDate() == null ? 0 : getUserLastModifiedDate().hashCode())) * 31) + (getEnabled() == null ? 0 : getEnabled().hashCode())) * 31) + (getUserStatus() == null ? 0 : getUserStatus().hashCode())) * 31) + (getMFAOptions() == null ? 0 : getMFAOptions().hashCode())) * 31) + (getPreferredMfaSetting() == null ? 0 : getPreferredMfaSetting().hashCode())) * 31) + (getUserMFASettingList() != null ? getUserMFASettingList().hashCode() : 0);
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public void setMFAOptions(Collection collection) {
        if (collection == null) {
            this.mFAOptions = null;
        } else {
            this.mFAOptions = new ArrayList(collection);
        }
    }

    public void setPreferredMfaSetting(String str) {
        this.preferredMfaSetting = str;
    }

    public void setUserAttributes(Collection collection) {
        if (collection == null) {
            this.userAttributes = null;
        } else {
            this.userAttributes = new ArrayList(collection);
        }
    }

    public void setUserCreateDate(Date date) {
        this.userCreateDate = date;
    }

    public void setUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
    }

    public void setUserMFASettingList(Collection collection) {
        if (collection == null) {
            this.userMFASettingList = null;
        } else {
            this.userMFASettingList = new ArrayList(collection);
        }
    }

    public void setUserStatus(UserStatusType userStatusType) {
        this.userStatus = userStatusType.toString();
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getUserCreateDate() != null) {
            sb.append("UserCreateDate: " + getUserCreateDate() + ",");
        }
        if (getUserLastModifiedDate() != null) {
            sb.append("UserLastModifiedDate: " + getUserLastModifiedDate() + ",");
        }
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled() + ",");
        }
        if (getUserStatus() != null) {
            sb.append("UserStatus: " + getUserStatus() + ",");
        }
        if (getMFAOptions() != null) {
            sb.append("MFAOptions: " + getMFAOptions() + ",");
        }
        if (getPreferredMfaSetting() != null) {
            sb.append("PreferredMfaSetting: " + getPreferredMfaSetting() + ",");
        }
        if (getUserMFASettingList() != null) {
            sb.append("UserMFASettingList: " + getUserMFASettingList());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminGetUserResult withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public AdminGetUserResult withMFAOptions(Collection collection) {
        setMFAOptions(collection);
        return this;
    }

    public AdminGetUserResult withPreferredMfaSetting(String str) {
        this.preferredMfaSetting = str;
        return this;
    }

    public AdminGetUserResult withUserAttributes(Collection collection) {
        setUserAttributes(collection);
        return this;
    }

    public AdminGetUserResult withUserCreateDate(Date date) {
        this.userCreateDate = date;
        return this;
    }

    public AdminGetUserResult withUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
        return this;
    }

    public AdminGetUserResult withUserMFASettingList(Collection collection) {
        setUserMFASettingList(collection);
        return this;
    }

    public AdminGetUserResult withUserStatus(UserStatusType userStatusType) {
        this.userStatus = userStatusType.toString();
        return this;
    }

    public AdminGetUserResult withUsername(String str) {
        this.username = str;
        return this;
    }

    public void setUserStatus(String str) {
        this.userStatus = str;
    }

    public AdminGetUserResult withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }

    public AdminGetUserResult withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public AdminGetUserResult withUserMFASettingList(String... strArr) {
        if (getUserMFASettingList() == null) {
            this.userMFASettingList = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.userMFASettingList.add(str);
        }
        return this;
    }

    public AdminGetUserResult withUserStatus(String str) {
        this.userStatus = str;
        return this;
    }
}
