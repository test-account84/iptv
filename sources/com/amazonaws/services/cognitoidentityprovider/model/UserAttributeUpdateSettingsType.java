package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UserAttributeUpdateSettingsType implements Serializable {
    private List attributesRequireVerificationBeforeUpdate;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserAttributeUpdateSettingsType)) {
            return false;
        }
        UserAttributeUpdateSettingsType userAttributeUpdateSettingsType = (UserAttributeUpdateSettingsType) obj;
        if ((userAttributeUpdateSettingsType.getAttributesRequireVerificationBeforeUpdate() == null) ^ (getAttributesRequireVerificationBeforeUpdate() == null)) {
            return false;
        }
        return userAttributeUpdateSettingsType.getAttributesRequireVerificationBeforeUpdate() == null || userAttributeUpdateSettingsType.getAttributesRequireVerificationBeforeUpdate().equals(getAttributesRequireVerificationBeforeUpdate());
    }

    public List getAttributesRequireVerificationBeforeUpdate() {
        return this.attributesRequireVerificationBeforeUpdate;
    }

    public int hashCode() {
        return 31 + (getAttributesRequireVerificationBeforeUpdate() == null ? 0 : getAttributesRequireVerificationBeforeUpdate().hashCode());
    }

    public void setAttributesRequireVerificationBeforeUpdate(Collection collection) {
        if (collection == null) {
            this.attributesRequireVerificationBeforeUpdate = null;
        } else {
            this.attributesRequireVerificationBeforeUpdate = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAttributesRequireVerificationBeforeUpdate() != null) {
            sb.append("AttributesRequireVerificationBeforeUpdate: " + getAttributesRequireVerificationBeforeUpdate());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserAttributeUpdateSettingsType withAttributesRequireVerificationBeforeUpdate(Collection collection) {
        setAttributesRequireVerificationBeforeUpdate(collection);
        return this;
    }

    public UserAttributeUpdateSettingsType withAttributesRequireVerificationBeforeUpdate(String... strArr) {
        if (getAttributesRequireVerificationBeforeUpdate() == null) {
            this.attributesRequireVerificationBeforeUpdate = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.attributesRequireVerificationBeforeUpdate.add(str);
        }
        return this;
    }
}
