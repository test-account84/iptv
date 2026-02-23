package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DescribeResourceServerResult implements Serializable {
    private ResourceServerType resourceServer;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeResourceServerResult)) {
            return false;
        }
        DescribeResourceServerResult describeResourceServerResult = (DescribeResourceServerResult) obj;
        if ((describeResourceServerResult.getResourceServer() == null) ^ (getResourceServer() == null)) {
            return false;
        }
        return describeResourceServerResult.getResourceServer() == null || describeResourceServerResult.getResourceServer().equals(getResourceServer());
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

    public DescribeResourceServerResult withResourceServer(ResourceServerType resourceServerType) {
        this.resourceServer = resourceServerType;
        return this;
    }
}
