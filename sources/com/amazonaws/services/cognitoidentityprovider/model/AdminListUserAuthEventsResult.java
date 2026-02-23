package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminListUserAuthEventsResult implements Serializable {
    private List authEvents;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminListUserAuthEventsResult)) {
            return false;
        }
        AdminListUserAuthEventsResult adminListUserAuthEventsResult = (AdminListUserAuthEventsResult) obj;
        if ((adminListUserAuthEventsResult.getAuthEvents() == null) ^ (getAuthEvents() == null)) {
            return false;
        }
        if (adminListUserAuthEventsResult.getAuthEvents() != null && !adminListUserAuthEventsResult.getAuthEvents().equals(getAuthEvents())) {
            return false;
        }
        if ((adminListUserAuthEventsResult.getNextToken() == null) ^ (getNextToken() == null)) {
            return false;
        }
        return adminListUserAuthEventsResult.getNextToken() == null || adminListUserAuthEventsResult.getNextToken().equals(getNextToken());
    }

    public List getAuthEvents() {
        return this.authEvents;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        return (((getAuthEvents() == null ? 0 : getAuthEvents().hashCode()) + 31) * 31) + (getNextToken() != null ? getNextToken().hashCode() : 0);
    }

    public void setAuthEvents(Collection collection) {
        if (collection == null) {
            this.authEvents = null;
        } else {
            this.authEvents = new ArrayList(collection);
        }
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAuthEvents() != null) {
            sb.append("AuthEvents: " + getAuthEvents() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminListUserAuthEventsResult withAuthEvents(Collection collection) {
        setAuthEvents(collection);
        return this;
    }

    public AdminListUserAuthEventsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public AdminListUserAuthEventsResult withAuthEvents(AuthEventType... authEventTypeArr) {
        if (getAuthEvents() == null) {
            this.authEvents = new ArrayList(authEventTypeArr.length);
        }
        for (AuthEventType authEventType : authEventTypeArr) {
            this.authEvents.add(authEventType);
        }
        return this;
    }
}
