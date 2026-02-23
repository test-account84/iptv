package com.amplifyframework.api.events;

import O.c;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.hub.HubEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class ApiEndpointStatusChangeEvent implements HubEvent.Data {
    private final ApiEndpointStatus currentStatus;
    private final ApiEndpointStatus previousStatus;

    public enum ApiEndpointStatus {
        UNKOWN,
        REACHABLE,
        NOT_REACHABLE;

        public ApiEndpointStatusChangeEvent transitionTo(ApiEndpointStatus apiEndpointStatus) {
            return new ApiEndpointStatusChangeEvent(apiEndpointStatus, this);
        }
    }

    public ApiEndpointStatusChangeEvent(ApiEndpointStatus apiEndpointStatus, ApiEndpointStatus apiEndpointStatus2) {
        this.currentStatus = apiEndpointStatus;
        this.previousStatus = apiEndpointStatus2;
    }

    public static ApiEndpointStatusChangeEvent from(HubEvent hubEvent) throws AmplifyException {
        if (hubEvent.getData() instanceof ApiEndpointStatusChangeEvent) {
            return (ApiEndpointStatusChangeEvent) hubEvent.getData();
        }
        String simpleName = ApiEndpointStatusChangeEvent.class.getSimpleName();
        throw new AmplifyException("Unable to cast event data from " + simpleName, "Ensure that the event payload is of type " + simpleName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApiEndpointStatusChangeEvent.class != obj.getClass()) {
            return false;
        }
        ApiEndpointStatusChangeEvent apiEndpointStatusChangeEvent = (ApiEndpointStatusChangeEvent) obj;
        if (c.a(this.currentStatus, apiEndpointStatusChangeEvent.currentStatus)) {
            return c.a(this.previousStatus, apiEndpointStatusChangeEvent.previousStatus);
        }
        return false;
    }

    public ApiEndpointStatus getCurrentStatus() {
        return this.currentStatus;
    }

    public ApiEndpointStatus getPreviousStatus() {
        return this.previousStatus;
    }

    public int hashCode() {
        ApiEndpointStatus apiEndpointStatus = this.currentStatus;
        int hashCode = (apiEndpointStatus != null ? apiEndpointStatus.hashCode() : 0) * 31;
        ApiEndpointStatus apiEndpointStatus2 = this.previousStatus;
        return hashCode + (apiEndpointStatus2 != null ? apiEndpointStatus2.hashCode() : 0);
    }

    public HubEvent toHubEvent() {
        return HubEvent.create(ApiChannelEventName.API_ENDPOINT_STATUS_CHANGED, this);
    }

    public String toString() {
        return "ApiEndpointStatusChangeEvent{currentStatus=" + this.currentStatus + ", previousStatus=" + this.previousStatus + "}";
    }
}
