package com.amazonaws.mobileconnectors.appsync;

import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall;
import v1.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class AppSyncWebSocketSubscriptionCall implements AppSyncSubscriptionCall {
    private final t subscription;
    private String subscriptionId;
    private final WebSocketConnectionManager websocketConnectionManager;
    private boolean isCanceled = false;
    private AppSyncSubscriptionCall.Callback callback = null;

    public AppSyncWebSocketSubscriptionCall(t tVar, WebSocketConnectionManager webSocketConnectionManager) {
        this.subscription = tVar;
        this.websocketConnectionManager = webSocketConnectionManager;
    }

    public synchronized void cancel() {
        this.isCanceled = true;
        this.websocketConnectionManager.releaseSubscription(this.subscriptionId);
        this.callback.onCompleted();
    }

    public AppSyncSubscriptionCall clone() {
        return new AppSyncWebSocketSubscriptionCall(this.subscription, this.websocketConnectionManager);
    }

    public synchronized void execute(AppSyncSubscriptionCall.Callback callback) {
        if (this.callback != null) {
            throw new IllegalStateException("Subscription call has already been executed.");
        }
        this.callback = callback;
        this.subscriptionId = this.websocketConnectionManager.requestSubscription(this.subscription, callback);
    }

    public synchronized boolean isCanceled() {
        return this.isCanceled;
    }
}
