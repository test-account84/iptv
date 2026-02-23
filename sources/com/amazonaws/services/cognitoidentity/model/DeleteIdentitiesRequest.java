package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DeleteIdentitiesRequest extends AmazonWebServiceRequest implements Serializable {
    private List identityIdsToDelete;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteIdentitiesRequest)) {
            return false;
        }
        DeleteIdentitiesRequest deleteIdentitiesRequest = (DeleteIdentitiesRequest) obj;
        if ((deleteIdentitiesRequest.getIdentityIdsToDelete() == null) ^ (getIdentityIdsToDelete() == null)) {
            return false;
        }
        return deleteIdentitiesRequest.getIdentityIdsToDelete() == null || deleteIdentitiesRequest.getIdentityIdsToDelete().equals(getIdentityIdsToDelete());
    }

    public List getIdentityIdsToDelete() {
        return this.identityIdsToDelete;
    }

    public int hashCode() {
        return 31 + (getIdentityIdsToDelete() == null ? 0 : getIdentityIdsToDelete().hashCode());
    }

    public void setIdentityIdsToDelete(Collection collection) {
        if (collection == null) {
            this.identityIdsToDelete = null;
        } else {
            this.identityIdsToDelete = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityIdsToDelete() != null) {
            sb.append("IdentityIdsToDelete: " + getIdentityIdsToDelete());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeleteIdentitiesRequest withIdentityIdsToDelete(Collection collection) {
        setIdentityIdsToDelete(collection);
        return this;
    }

    public DeleteIdentitiesRequest withIdentityIdsToDelete(String... strArr) {
        if (getIdentityIdsToDelete() == null) {
            this.identityIdsToDelete = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.identityIdsToDelete.add(str);
        }
        return this;
    }
}
