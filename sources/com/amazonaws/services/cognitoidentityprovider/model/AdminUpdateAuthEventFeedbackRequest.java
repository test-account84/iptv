package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AdminUpdateAuthEventFeedbackRequest extends AmazonWebServiceRequest implements Serializable {
    private String eventId;
    private String feedbackValue;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminUpdateAuthEventFeedbackRequest)) {
            return false;
        }
        AdminUpdateAuthEventFeedbackRequest adminUpdateAuthEventFeedbackRequest = (AdminUpdateAuthEventFeedbackRequest) obj;
        if ((adminUpdateAuthEventFeedbackRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        if (adminUpdateAuthEventFeedbackRequest.getUserPoolId() != null && !adminUpdateAuthEventFeedbackRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if ((adminUpdateAuthEventFeedbackRequest.getUsername() == null) ^ (getUsername() == null)) {
            return false;
        }
        if (adminUpdateAuthEventFeedbackRequest.getUsername() != null && !adminUpdateAuthEventFeedbackRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if ((adminUpdateAuthEventFeedbackRequest.getEventId() == null) ^ (getEventId() == null)) {
            return false;
        }
        if (adminUpdateAuthEventFeedbackRequest.getEventId() != null && !adminUpdateAuthEventFeedbackRequest.getEventId().equals(getEventId())) {
            return false;
        }
        if ((adminUpdateAuthEventFeedbackRequest.getFeedbackValue() == null) ^ (getFeedbackValue() == null)) {
            return false;
        }
        return adminUpdateAuthEventFeedbackRequest.getFeedbackValue() == null || adminUpdateAuthEventFeedbackRequest.getFeedbackValue().equals(getFeedbackValue());
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getFeedbackValue() {
        return this.feedbackValue;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return (((((((getUserPoolId() == null ? 0 : getUserPoolId().hashCode()) + 31) * 31) + (getUsername() == null ? 0 : getUsername().hashCode())) * 31) + (getEventId() == null ? 0 : getEventId().hashCode())) * 31) + (getFeedbackValue() != null ? getFeedbackValue().hashCode() : 0);
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getEventId() != null) {
            sb.append("EventId: " + getEventId() + ",");
        }
        if (getFeedbackValue() != null) {
            sb.append("FeedbackValue: " + getFeedbackValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminUpdateAuthEventFeedbackRequest withEventId(String str) {
        this.eventId = str;
        return this;
    }

    public AdminUpdateAuthEventFeedbackRequest withFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
        return this;
    }

    public AdminUpdateAuthEventFeedbackRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminUpdateAuthEventFeedbackRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public void setFeedbackValue(String str) {
        this.feedbackValue = str;
    }

    public AdminUpdateAuthEventFeedbackRequest withFeedbackValue(String str) {
        this.feedbackValue = str;
        return this;
    }
}
