package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListResourceServersResult implements Serializable {
    private String nextToken;
    private List resourceServers;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListResourceServersResult)) {
            return false;
        }
        ListResourceServersResult listResourceServersResult = (ListResourceServersResult) obj;
        if ((listResourceServersResult.getResourceServers() == null) ^ (getResourceServers() == null)) {
            return false;
        }
        if (listResourceServersResult.getResourceServers() != null && !listResourceServersResult.getResourceServers().equals(getResourceServers())) {
            return false;
        }
        if ((listResourceServersResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listResourceServersResult.getNextToken() == null || listResourceServersResult.getNextToken().equals(getNextToken());
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List getResourceServers() {
        return this.resourceServers;
    }

    public int hashCode() {
        return (((getResourceServers() == null ? 0 : getResourceServers().hashCode()) + 31) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setResourceServers(Collection collection) {
        if (collection == null) {
            this.resourceServers = null;
        } else {
            this.resourceServers = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getResourceServers() != null) {
            sb.append("ResourceServers: " + getResourceServers() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListResourceServersResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListResourceServersResult withResourceServers(Collection collection) {
        setResourceServers(collection);
        return this;
    }

    public ListResourceServersResult withResourceServers(ResourceServerType... resourceServerTypeArr) {
        if (getResourceServers() == null) {
            this.resourceServers = new ArrayList(resourceServerTypeArr.length);
        }
        for (ResourceServerType resourceServerType : resourceServerTypeArr) {
            this.resourceServers.add(resourceServerType);
        }
        return this;
    }
}
