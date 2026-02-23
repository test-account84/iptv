package com.amplifyframework.datastore.events;

import O.c;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.events.ApiEndpointStatusChangeEvent;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.DataStoreChannelEventName;
import com.amplifyframework.hub.HubEvent;
import com.amplifyframework.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class NetworkStatusEvent implements HubEvent.Data {
    private static final Logger LOG = Amplify.Logging.forNamespace("amplify:aws-datastore");
    private final boolean active;

    public NetworkStatusEvent(boolean z) {
        this.active = z;
    }

    public static NetworkStatusEvent from(ApiEndpointStatusChangeEvent apiEndpointStatusChangeEvent) {
        return new NetworkStatusEvent(ApiEndpointStatusChangeEvent.ApiEndpointStatus.REACHABLE.equals(apiEndpointStatusChangeEvent.getCurrentStatus()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NetworkStatusEvent.class != obj.getClass()) {
            return false;
        }
        return c.a(Boolean.valueOf(this.active), Boolean.valueOf(((NetworkStatusEvent) obj).active));
    }

    public boolean getActive() {
        return this.active;
    }

    public int hashCode() {
        return Boolean.valueOf(this.active).hashCode();
    }

    public HubEvent toHubEvent() {
        return HubEvent.create(DataStoreChannelEventName.NETWORK_STATUS, this);
    }

    public String toString() {
        return "NetworkStatus{active=" + this.active + "}";
    }

    public static NetworkStatusEvent from(HubEvent hubEvent) throws AmplifyException {
        if (hubEvent.getData() instanceof NetworkStatusEvent) {
            return (NetworkStatusEvent) hubEvent.getData();
        }
        String name = NetworkStatusEvent.class.getName();
        throw new AmplifyException("Unable to cast event data from " + name, "Ensure that the event payload is of type " + name);
    }
}
