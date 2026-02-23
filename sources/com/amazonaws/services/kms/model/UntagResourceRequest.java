package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class UntagResourceRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private List tagKeys = new ArrayList();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UntagResourceRequest)) {
            return false;
        }
        UntagResourceRequest untagResourceRequest = (UntagResourceRequest) obj;
        if ((untagResourceRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (untagResourceRequest.getKeyId() != null && !untagResourceRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((untagResourceRequest.getTagKeys() == null) ^ (getTagKeys() == null)) {
            return false;
        }
        return untagResourceRequest.getTagKeys() == null || untagResourceRequest.getTagKeys().equals(getTagKeys());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public List getTagKeys() {
        return this.tagKeys;
    }

    public int hashCode() {
        return (((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getTagKeys() != null ? getTagKeys().hashCode() : 0);
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setTagKeys(Collection collection) {
        if (collection == null) {
            this.tagKeys = null;
        } else {
            this.tagKeys = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getTagKeys() != null) {
            sb.append("TagKeys: " + getTagKeys());
        }
        sb.append("}");
        return sb.toString();
    }

    public UntagResourceRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public UntagResourceRequest withTagKeys(Collection collection) {
        setTagKeys(collection);
        return this;
    }

    public UntagResourceRequest withTagKeys(String... strArr) {
        if (getTagKeys() == null) {
            this.tagKeys = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.tagKeys.add(str);
        }
        return this;
    }
}
