package com.amazonaws.mobileconnectors.appsync;

import B1.b;
import B1.d;
import D1.a;
import android.os.Message;
import android.util.Log;
import com.amazonaws.mobileconnectors.appsync.AppSyncOfflineMutationInterceptor;
import java.util.Map;
import org.json.JSONObject;
import v1.f;
import v1.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class InterceptorCallback implements a.a {
    private static final String TAG = "InterceptorCallback";
    AppSyncOfflineMutationManager appSyncOfflineMutationManager;
    String clientState;
    f currentMutation;
    a.a customerCallBack;
    f originalMutation;
    final AppSyncOfflineMutationInterceptor.QueueUpdateHandler queueHandler;
    String recordIdentifier;
    boolean shouldRetry = true;

    public InterceptorCallback(a.a aVar, AppSyncOfflineMutationInterceptor.QueueUpdateHandler queueUpdateHandler, f fVar, f fVar2, String str, String str2, AppSyncOfflineMutationManager appSyncOfflineMutationManager) {
        this.customerCallBack = aVar;
        this.queueHandler = queueUpdateHandler;
        this.originalMutation = fVar;
        this.currentMutation = fVar2;
        this.clientState = str;
        this.recordIdentifier = str2;
        this.appSyncOfflineMutationManager = appSyncOfflineMutationManager;
    }

    public void onCompleted() {
        Log.d(TAG, "Thread:[" + Thread.currentThread().getId() + "]: onCompleted()");
    }

    public void onFailure(b bVar) {
        String str = TAG;
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: onFailure() " + bVar.getLocalizedMessage());
        if (!(bVar instanceof d)) {
            this.shouldRetry = false;
            this.customerCallBack.onFailure(bVar);
            this.appSyncOfflineMutationManager.setInProgressMutationAsCompleted(this.recordIdentifier);
            Message message = new Message();
            message.obj = new MutationInterceptorMessage(this.originalMutation, this.currentMutation);
            message.what = 500;
            this.queueHandler.sendMessage(message);
            return;
        }
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Network Exception " + bVar.getLocalizedMessage());
        StringBuilder sb = new StringBuilder();
        sb.append("Thread:[");
        sb.append(Thread.currentThread().getId());
        sb.append("]: Will retry mutation when back on network");
        Log.v(str, sb.toString());
        this.queueHandler.setMutationInProgressStatusToFalse();
    }

    public void onFetch(a.b bVar) {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: onFetch()");
        this.customerCallBack.onFetch(bVar);
    }

    public void onResponse(a.d dVar) {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: onResponse()");
        if (!this.shouldRetry || !ConflictResolutionHandler.conflictPresent(dVar.b)) {
            this.customerCallBack.onResponse(dVar);
            this.appSyncOfflineMutationManager.setInProgressMutationAsCompleted(this.recordIdentifier);
            Message message = new Message();
            message.obj = new MutationInterceptorMessage();
            message.what = 400;
            this.queueHandler.sendMessage(message);
            return;
        }
        this.shouldRetry = false;
        String jSONObject = new JSONObject((Map) ((v1.a) ((i) dVar.b.e()).d().get(0)).a().get("data")).toString();
        Message message2 = new Message();
        MutationInterceptorMessage mutationInterceptorMessage = new MutationInterceptorMessage(this.originalMutation, this.currentMutation);
        mutationInterceptorMessage.serverState = jSONObject;
        mutationInterceptorMessage.clientState = this.clientState;
        mutationInterceptorMessage.requestIdentifier = this.recordIdentifier;
        mutationInterceptorMessage.requestClassName = this.currentMutation.getClass().getSimpleName();
        message2.obj = mutationInterceptorMessage;
        message2.what = 600;
        this.queueHandler.sendMessage(message2);
    }
}
