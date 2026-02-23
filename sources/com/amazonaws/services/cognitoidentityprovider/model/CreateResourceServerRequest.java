package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateResourceServerRequest extends AmazonWebServiceRequest implements Serializable {
    private String identifier;
    private String name;
    private List scopes;
    private String userPoolId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateResourceServerRequest)) {
            return false;
        }
        CreateResourceServerRequest createResourceServerRequest = (CreateResourceServerRequest) obj;
        if ((createResourceServerRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (createResourceServerRequest.getUserPoolId() != null && !createResourceServerRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((createResourceServerRequest.getIdentifier() == null) ^ (getIdentifier() == null)) {
            return false;
        }
        if (createResourceServerRequest.getIdentifier() != null && !createResourceServerRequest.getIdentifier().equals(getIdentifier())) {
            return false;
        }
        if ((createResourceServerRequest.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (createResourceServerRequest.getName() != null && !createResourceServerRequest.getName().equals(getName())) {
            return false;
        }
        if ((createResourceServerRequest.getScopes() == null) ^ (getScopes() == null)) {
            return false;
        }
        return createResourceServerRequest.getScopes() == null || createResourceServerRequest.getScopes().equals(getScopes());
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public List getScopes() {
        return this.scopes;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getIdentifier() == null ? 0 : getIdentifier().hashCode())) * 31) + (getName() == null ? 0 : getName().hashCode())) * 31) + (getScopes() != null ? getScopes().hashCode() : 0);
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setScopes(Collection collection) {
        if (collection == null) {
            this.scopes = null;
        } else {
            this.scopes = new ArrayList(collection);
        }
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getIdentifier() != null) {
            sb.append("Identifier: " + getIdentifier() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getScopes() != null) {
            sb.append("Scopes: " + getScopes());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateResourceServerRequest withIdentifier(String str) {
        this.identifier = str;
        return this;
    }

    public CreateResourceServerRequest withName(String str) {
        this.name = str;
        return this;
    }

    public CreateResourceServerRequest withScopes(Collection collection) {
        setScopes(collection);
        return this;
    }

    public CreateResourceServerRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public CreateResourceServerRequest withScopes(ResourceServerScopeType... resourceServerScopeTypeArr) {
        if (getScopes() == null) {
            this.scopes = new ArrayList(resourceServerScopeTypeArr.length);
        }
        for (ResourceServerScopeType resourceServerScopeType : resourceServerScopeTypeArr) {
            this.scopes.add(resourceServerScopeType);
        }
        return this;
    }
}
