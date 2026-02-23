package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class EventFeedbackType implements Serializable {
    private Date feedbackDate;
    private String feedbackValue;
    private String provider;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EventFeedbackType)) {
            return false;
        }
        EventFeedbackType eventFeedbackType = (EventFeedbackType) obj;
        if ((eventFeedbackType.getFeedbackValue() == null) ^ (getFeedbackValue() == null)) {
            return false;
        }
        if (eventFeedbackType.getFeedbackValue() != null && !eventFeedbackType.getFeedbackValue().equals(getFeedbackValue())) {
            return false;
        }
        if ((eventFeedbackType.getProvider() == null) ^ (getProvider() == null)) {
            return false;
        }
        if (eventFeedbackType.getProvider() != null && !eventFeedbackType.getProvider().equals(getProvider())) {
            return false;
        }
        if ((eventFeedbackType.getFeedbackDate() == null) ^ (getFeedbackDate() == null)) {
            return false;
        }
        return eventFeedbackType.getFeedbackDate() == null || eventFeedbackType.getFeedbackDate().equals(getFeedbackDate());
    }

    public Date getFeedbackDate() {
        return this.feedbackDate;
    }

    public String getFeedbackValue() {
        return this.feedbackValue;
    }

    public String getProvider() {
        return this.provider;
    }

    public int hashCode() {
        return (((((getFeedbackValue() == null ? 0 : getFeedbackValue().hashCode()) + 31) * 31) + (getProvider() == null ? 0 : getProvider().hashCode())) * 31) + (getFeedbackDate() != null ? getFeedbackDate().hashCode() : 0);
    }

    public void setFeedbackDate(Date date) {
        this.feedbackDate = date;
    }

    public void setFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getFeedbackValue() != null) {
            sb.append("FeedbackValue: " + getFeedbackValue() + ",");
        }
        if (getProvider() != null) {
            sb.append("Provider: " + getProvider() + ",");
        }
        if (getFeedbackDate() != null) {
            sb.append("FeedbackDate: " + getFeedbackDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public EventFeedbackType withFeedbackDate(Date date) {
        this.feedbackDate = date;
        return this;
    }

    public EventFeedbackType withFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
        return this;
    }

    public EventFeedbackType withProvider(String str) {
        this.provider = str;
        return this;
    }

    public void setFeedbackValue(String str) {
        this.feedbackValue = str;
    }

    public EventFeedbackType withFeedbackValue(String str) {
        this.feedbackValue = str;
        return this;
    }
}
