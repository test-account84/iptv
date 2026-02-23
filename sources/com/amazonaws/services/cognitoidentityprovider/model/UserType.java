package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserType implements Serializable {
    private List attributes;
    private Boolean enabled;
    private List mFAOptions;
    private Date userCreateDate;
    private Date userLastModifiedDate;
    private String userStatus;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserType)) {
            return false;
        }
        UserType userType = (UserType) obj;
        if ((userType.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (userType.getUsername() != null && !userType.getUsername().equals(getUsername())) {
            return false;
        }
        if ((userType.getAttributes() == null) ^ (getAttributes() == null)) {
            return false;
        }
        if (userType.getAttributes() != null && !userType.getAttributes().equals(getAttributes())) {
            return false;
        }
        if ((userType.getUserCreateDate() == null) ^ (getUserCreateDate() == null)) {
            return false;
        }
        if (userType.getUserCreateDate() != null && !userType.getUserCreateDate().equals(getUserCreateDate())) {
            return false;
        }
        if ((userType.getUserLastModifiedDate() == null) ^ (getUserLastModifiedDate() == null)) {
            return false;
        }
        if (userType.getUserLastModifiedDate() != null && !userType.getUserLastModifiedDate().equals(getUserLastModifiedDate())) {
            return false;
        }
        if ((userType.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        if (userType.getEnabled() != null && !userType.getEnabled().equals(getEnabled())) {
            return false;
        }
        if ((userType.getUserStatus() == null) ^ (getUserStatus() == null)) {
            return false;
        }
        if (userType.getUserStatus() != null && !userType.getUserStatus().equals(getUserStatus())) {
            return false;
        }
        if ((userType.getMFAOptions() == null) ^ (getMFAOptions() == null)) {
            return false;
        }
        return userType.getMFAOptions() == null || userType.getMFAOptions().equals(getMFAOptions());
    }

    public List getAttributes() {
        return this.attributes;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public List getMFAOptions() {
        return this.mFAOptions;
    }

    public Date getUserCreateDate() {
        return this.userCreateDate;
    }

    public Date getUserLastModifiedDate() {
        return this.userLastModifiedDate;
    }

    public String getUserStatus() {
        return this.userStatus;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((((((((getUsername() == null ? 0 : getUsername().hashCode()) + 31) * 31) + (getAttributes() == null ? 0 : getAttributes().hashCode())) * 31) + (getUserCreateDate() == null ? 0 : getUserCreateDate().hashCode())) * 31) + (getUserLastModifiedDate() == null ? 0 : getUserLastModifiedDate().hashCode())) * 31) + (getEnabled() == null ? 0 : getEnabled().hashCode())) * 31) + (getUserStatus() == null ? 0 : getUserStatus().hashCode())) * 31) + (getMFAOptions() != null ? getMFAOptions().hashCode() : 0);
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setAttributes(Collection collection) {
        if (collection == null) {
            this.attributes = null;
        } else {
            this.attributes = new ArrayList(collection);
        }
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

    public void setUserCreateDate(Date date) {
        this.userCreateDate = date;
    }

    public void setUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
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
        if (getAttributes() != null) {
            sb.append("Attributes: " + getAttributes() + ",");
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
            sb.append("MFAOptions: " + getMFAOptions());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserType withAttributes(Collection collection) {
        setAttributes(collection);
        return this;
    }

    public UserType withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public UserType withMFAOptions(Collection collection) {
        setMFAOptions(collection);
        return this;
    }

    public UserType withUserCreateDate(Date date) {
        this.userCreateDate = date;
        return this;
    }

    public UserType withUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
        return this;
    }

    public UserType withUserStatus(UserStatusType userStatusType) {
        this.userStatus = userStatusType.toString();
        return this;
    }

    public UserType withUsername(String str) {
        this.username = str;
        return this;
    }

    public void setUserStatus(String str) {
        this.userStatus = str;
    }

    public UserType withAttributes(AttributeType... attributeTypeArr) {
        if (getAttributes() == null) {
            this.attributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.attributes.add(attributeType);
        }
        return this;
    }

    public UserType withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }

    public UserType withUserStatus(String str) {
        this.userStatus = str;
        return this;
    }
}
