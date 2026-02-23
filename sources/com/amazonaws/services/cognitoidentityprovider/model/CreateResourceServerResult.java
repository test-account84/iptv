package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class CreateResourceServerResult implements Serializable {
    private ResourceServerType resourceServer;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateResourceServerResult)) {
            return false;
        }
        CreateResourceServerResult createResourceServerResult = (CreateResourceServerResult) obj;
        if ((createResourceServerResult.getResourceServer() == null) ^ (getResourceServer() == null)) {
            return false;
        }
        return createResourceServerResult.getResourceServer() == null || createResourceServerResult.getResourceServer().equals(getResourceServer());
    }

    public ResourceServerType getResourceServer() {
        return this.resourceServer;
    }

    public int hashCode() {
        return 31 + (getResourceServer() == null ? 0 : getResourceServer().hashCode());
    }

    public void setResourceServer(ResourceServerType resourceServerType) {
        this.resourceServer = resourceServerType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getResourceServer() != null) {
            sb.append("ResourceServer: " + getResourceServer());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateResourceServerResult withResourceServer(ResourceServerType resourceServerType) {
        this.resourceServer = resourceServerType;
        return this;
    }
}
