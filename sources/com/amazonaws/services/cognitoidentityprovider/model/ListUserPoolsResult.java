package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ListUserPoolsResult implements Serializable {
    private String nextToken;
    private List userPools;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUserPoolsResult)) {
            return false;
        }
        ListUserPoolsResult listUserPoolsResult = (ListUserPoolsResult) obj;
        if ((listUserPoolsResult.getUserPools() == null) ^ (getUserPools() == null)) {
            return false;
        }
        if (listUserPoolsResult.getUserPools() != null && !listUserPoolsResult.getUserPools().equals(getUserPools())) {
            return false;
        }
        if ((listUserPoolsResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return listUserPoolsResult.getNextToken() == null || listUserPoolsResult.getNextToken().equals(getNextToken());
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List getUserPools() {
        return this.userPools;
    }

    public int hashCode() {
        return (((getUserPools() == null ? 0 : getUserPools().hashCode()) + 31) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setUserPools(Collection collection) {
        if (collection == null) {
            this.userPools = null;
        } else {
            this.userPools = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPools() != null) {
            sb.append("UserPools: " + getUserPools() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListUserPoolsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListUserPoolsResult withUserPools(Collection collection) {
        setUserPools(collection);
        return this;
    }

    public ListUserPoolsResult withUserPools(UserPoolDescriptionType... userPoolDescriptionTypeArr) {
        if (getUserPools() == null) {
            this.userPools = new ArrayList(userPoolDescriptionTypeArr.length);
        }
        for (UserPoolDescriptionType userPoolDescriptionType : userPoolDescriptionTypeArr) {
            this.userPools.add(userPoolDescriptionType);
        }
        return this;
    }
}
