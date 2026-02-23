package com.amazonaws.mobileconnectors.appsync.subscription;

import B1.b;
import B1.e;
import F1.h;
import K1.a;
import K1.d;
import android.util.Log;
import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import v1.i;
import v1.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class SubscriptionObject {
    private static final String CONTENT_TYPE = "application/json";
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json");
    private static final String TAG = "SubscriptionObject";
    public h normalizer;
    public d scalarTypeAdapters;
    public t subscription;
    private boolean cancelled = false;
    public Set topics = new HashSet();
    public Set listeners = new HashSet();

    private void notifyDisconnectionEventToAllListeners() {
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((AppSyncSubscriptionCall.Callback) it.next()).onCompleted();
        }
    }

    private void notifyErrorToAllListeners(b bVar) {
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((AppSyncSubscriptionCall.Callback) it.next()).onFailure(bVar);
        }
    }

    private void propagateMessageToAllListeners(i iVar) {
        for (AppSyncSubscriptionCall.Callback callback : this.listeners) {
            Log.v(TAG, "Propagating message to : " + callback.toString());
            callback.onResponse(iVar);
        }
    }

    public void addListener(AppSyncSubscriptionCall.Callback callback) {
        Log.v(TAG, "Adding listener to " + this);
        this.listeners.add(callback);
    }

    public Set getListeners() {
        return this.listeners;
    }

    public Set getTopics() {
        return this.topics;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void onFailure(b bVar) {
        if (bVar.getCause() instanceof SubscriptionDisconnectedException) {
            notifyDisconnectionEventToAllListeners();
        } else {
            notifyErrorToAllListeners(bVar);
        }
    }

    public void onMessage(String str) {
        try {
            ResponseBody create = ResponseBody.create(str, MEDIA_TYPE);
            t tVar = this.subscription;
            i f = new a(tVar, tVar.responseFieldMapper(), this.scalarTypeAdapters, this.normalizer).f(create.source());
            if (f.e()) {
                Log.w(TAG, "Errors detected in parsed subscription message");
            }
            propagateMessageToAllListeners(f);
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse: " + str, e);
            notifyErrorToAllListeners(new e("Failed to parse http response", e));
        }
    }

    public void setCancelled() {
        this.cancelled = true;
    }
}
