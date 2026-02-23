package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateIdentityProviderRequest extends AmazonWebServiceRequest implements Serializable {
    private Map attributeMapping;
    private List idpIdentifiers;
    private Map providerDetails;
    private String providerName;
    private String providerType;
    private String userPoolId;

    public CreateIdentityProviderRequest addAttributeMappingEntry(String str, String str2) {
        if (this.attributeMapping == null) {
            this.attributeMapping = new HashMap();
        }
        if (!this.attributeMapping.containsKey(str)) {
            this.attributeMapping.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public CreateIdentityProviderRequest addProviderDetailsEntry(String str, String str2) {
        if (this.providerDetails == null) {
            this.providerDetails = new HashMap();
        }
        if (!this.providerDetails.containsKey(str)) {
            this.providerDetails.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public CreateIdentityProviderRequest clearAttributeMappingEntries() {
        this.attributeMapping = null;
        return this;
    }

    public CreateIdentityProviderRequest clearProviderDetailsEntries() {
        this.providerDetails = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateIdentityProviderRequest)) {
            return false;
        }
        CreateIdentityProviderRequest createIdentityProviderRequest = (CreateIdentityProviderRequest) obj;
        if ((createIdentityProviderRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (createIdentityProviderRequest.getUserPoolId() != null && !createIdentityProviderRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((createIdentityProviderRequest.getProviderName() == null) ^ (getProviderName() == null)) {
            return false;
        }
        if (createIdentityProviderRequest.getProviderName() != null && !createIdentityProviderRequest.getProviderName().equals(getProviderName())) {
            return false;
        }
        if ((createIdentityProviderRequest.getProviderType() == null) ^ (getProviderType() == null)) {
            return false;
        }
        if (createIdentityProviderRequest.getProviderType() != null && !createIdentityProviderRequest.getProviderType().equals(getProviderType())) {
            return false;
        }
        if ((createIdentityProviderRequest.getProviderDetails() == null) ^ (getProviderDetails() == null)) {
            return false;
        }
        if (createIdentityProviderRequest.getProviderDetails() != null && !createIdentityProviderRequest.getProviderDetails().equals(getProviderDetails())) {
            return false;
        }
        if ((createIdentityProviderRequest.getAttributeMapping() == null) ^ (getAttributeMapping() == null)) {
            return false;
        }
        if (createIdentityProviderRequest.getAttributeMapping() != null && !createIdentityProviderRequest.getAttributeMapping().equals(getAttributeMapping())) {
            return false;
        }
        if ((createIdentityProviderRequest.getIdpIdentifiers() == null) ^ (getIdpIdentifiers() == null)) {
            return false;
        }
        return createIdentityProviderRequest.getIdpIdentifiers() == null || createIdentityProviderRequest.getIdpIdentifiers().equals(getIdpIdentifiers());
    }

    public Map getAttributeMapping() {
        return this.attributeMapping;
    }

    public List getIdpIdentifiers() {
        return this.idpIdentifiers;
    }

    public Map getProviderDetails() {
        return this.providerDetails;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getProviderType() {
        return this.providerType;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        return (((((((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getProviderName() == null ? 0 : getProviderName().hashCode())) * 31) + (getProviderType() == null ? 0 : getProviderType().hashCode())) * 31) + (getProviderDetails() == null ? 0 : getProviderDetails().hashCode())) * 31) + (getAttributeMapping() == null ? 0 : getAttributeMapping().hashCode())) * 31) + (getIdpIdentifiers() != null ? getIdpIdentifiers().hashCode() : 0);
    }

    public void setAttributeMapping(Map map) {
        this.attributeMapping = map;
    }

    public void setIdpIdentifiers(Collection collection) {
        if (collection == null) {
            this.idpIdentifiers = null;
        } else {
            this.idpIdentifiers = new ArrayList(collection);
        }
    }

    public void setProviderDetails(Map map) {
        this.providerDetails = map;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void setProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
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
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName() + ",");
        }
        if (getProviderType() != null) {
            sb.append("ProviderType: " + getProviderType() + ",");
        }
        if (getProviderDetails() != null) {
            sb.append("ProviderDetails: " + getProviderDetails() + ",");
        }
        if (getAttributeMapping() != null) {
            sb.append("AttributeMapping: " + getAttributeMapping() + ",");
        }
        if (getIdpIdentifiers() != null) {
            sb.append("IdpIdentifiers: " + getIdpIdentifiers());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateIdentityProviderRequest withAttributeMapping(Map map) {
        this.attributeMapping = map;
        return this;
    }

    public CreateIdentityProviderRequest withIdpIdentifiers(Collection collection) {
        setIdpIdentifiers(collection);
        return this;
    }

    public CreateIdentityProviderRequest withProviderDetails(Map map) {
        this.providerDetails = map;
        return this;
    }

    public CreateIdentityProviderRequest withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public CreateIdentityProviderRequest withProviderType(IdentityProviderTypeType identityProviderTypeType) {
        this.providerType = identityProviderTypeType.toString();
        return this;
    }

    public CreateIdentityProviderRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public void setProviderType(String str) {
        this.providerType = str;
    }

    public CreateIdentityProviderRequest withIdpIdentifiers(String... strArr) {
        if (getIdpIdentifiers() == null) {
            this.idpIdentifiers = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.idpIdentifiers.add(str);
        }
        return this;
    }

    public CreateIdentityProviderRequest withProviderType(String str) {
        this.providerType = str;
        return this;
    }
}
