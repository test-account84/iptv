package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminListGroupsForUserResult implements Serializable {
    private List groups;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminListGroupsForUserResult)) {
            return false;
        }
        AdminListGroupsForUserResult adminListGroupsForUserResult = (AdminListGroupsForUserResult) obj;
        if ((adminListGroupsForUserResult.getGroups() == null) ^ (getGroups() == null)) {
            return false;
        }
        if (adminListGroupsForUserResult.getGroups() != null && !adminListGroupsForUserResult.getGroups().equals(getGroups())) {
            return false;
        }
        if ((adminListGroupsForUserResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return adminListGroupsForUserResult.getNextToken() == null || adminListGroupsForUserResult.getNextToken().equals(getNextToken());
    }

    public List getGroups() {
        return this.groups;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        return (((getGroups() == null ? 0 : getGroups().hashCode()) + 31) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public void setGroups(Collection collection) {
        if (collection == null) {
            this.groups = null;
        } else {
            this.groups = new ArrayList(collection);
        }
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getGroups() != null) {
            sb.append("Groups: " + getGroups() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminListGroupsForUserResult withGroups(Collection collection) {
        setGroups(collection);
        return this;
    }

    public AdminListGroupsForUserResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public AdminListGroupsForUserResult withGroups(GroupType... groupTypeArr) {
        if (getGroups() == null) {
            this.groups = new ArrayList(groupTypeArr.length);
        }
        for (GroupType groupType : groupTypeArr) {
            this.groups.add(groupType);
        }
        return this;
    }
}
