package com.amplifyframework.hub;

import android.util.Log;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.hub.HubEvent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class i {
    public static HubSubscriber a(Consumer consumer) {
        return new h(consumer);
    }

    public static /* synthetic */ void b(Consumer consumer, HubEvent hubEvent) {
        try {
            consumer.accept((HubEvent.Data) hubEvent.getData());
        } catch (Exception e) {
            Log.w("amplify:aws-hub", "Unable to cast event data for event type " + hubEvent.getName(), e);
        }
    }
}
