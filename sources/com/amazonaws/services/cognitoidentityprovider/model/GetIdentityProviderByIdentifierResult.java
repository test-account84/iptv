package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class GetIdentityProviderByIdentifierResult implements Serializable {
    private IdentityProviderType identityProvider;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityProviderByIdentifierResult)) {
            return false;
        }
        GetIdentityProviderByIdentifierResult getIdentityProviderByIdentifierResult = (GetIdentityProviderByIdentifierResult) obj;
        if ((getIdentityProviderByIdentifierResult.getIdentityProvider() == null) ^ (getIdentityProvider() == null)) {
            return false;
        }
        return getIdentityProviderByIdentifierResult.getIdentityProvider() == null || getIdentityProviderByIdentifierResult.getIdentityProvider().equals(getIdentityProvider());
    }

    public IdentityProviderType getIdentityProvider() {
        return this.identityProvider;
    }

    public int hashCode() {
        return 31 + (getIdentityProvider() == null ? 0 : getIdentityProvider().hashCode());
    }

    public void setIdentityProvider(IdentityProviderType identityProviderType) {
        this.identityProvider = identityProviderType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityProvider() != null) {
            sb.append("IdentityProvider: " + getIdentityProvider());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetIdentityProviderByIdentifierResult withIdentityProvider(IdentityProviderType identityProviderType) {
        this.identityProvider = identityProviderType;
        return this;
    }
}
