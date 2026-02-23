package com.amazonaws.mobileconnectors.appsync;

import android.util.Log;
import com.amazonaws.mobileconnectors.appsync.AppSyncOfflineMutationInterceptor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class PersistentOfflineMutationManager {
    private static final String TAG = "PersistentOfflineMutationManager";
    final AppSyncMutationSqlCacheOperations mutationSqlCacheOperations;
    final AppSyncCustomNetworkInvoker networkInvoker;
    List persistentOfflineMutationObjectList;
    Map persistentOfflineMutationObjectMap;
    AppSyncOfflineMutationInterceptor.QueueUpdateHandler queueHandler;
    Set timedOutMutations;

    public PersistentOfflineMutationManager(AppSyncMutationSqlCacheOperations appSyncMutationSqlCacheOperations, AppSyncCustomNetworkInvoker appSyncCustomNetworkInvoker) {
        String str = TAG;
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]:In Constructor");
        this.mutationSqlCacheOperations = appSyncMutationSqlCacheOperations;
        this.networkInvoker = appSyncCustomNetworkInvoker;
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]:Priming the pump - Fetching all the queued mutations from the persistent store");
        this.persistentOfflineMutationObjectList = fetchPersistentMutationsList();
        this.persistentOfflineMutationObjectMap = new HashMap();
        for (PersistentOfflineMutationObject persistentOfflineMutationObject : this.persistentOfflineMutationObjectList) {
            this.persistentOfflineMutationObjectMap.put(persistentOfflineMutationObject.recordIdentifier, persistentOfflineMutationObject);
        }
        this.timedOutMutations = new HashSet();
        appSyncCustomNetworkInvoker.setPersistentOfflineMutationManager(this);
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]:Exiting the constructor. There are [" + this.persistentOfflineMutationObjectList.size() + "] mutations in the persistent queue");
    }

    private synchronized PersistentOfflineMutationObject getFirstInQueue() {
        String str = TAG;
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]:In getFirstInQueue");
        if (this.persistentOfflineMutationObjectList.size() <= 0) {
            return null;
        }
        PersistentOfflineMutationObject persistentOfflineMutationObject = (PersistentOfflineMutationObject) this.persistentOfflineMutationObjectList.get(0);
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]:returning mutation[" + persistentOfflineMutationObject.recordIdentifier + "]: " + persistentOfflineMutationObject.responseClassName + " \n\n " + persistentOfflineMutationObject.requestString);
        return persistentOfflineMutationObject;
    }

    public synchronized void addPersistentMutationObject(PersistentOfflineMutationObject persistentOfflineMutationObject) {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]:addPersistentMutationObject: Adding mutation[" + persistentOfflineMutationObject.recordIdentifier + "]: " + persistentOfflineMutationObject.responseClassName + " \n" + persistentOfflineMutationObject.requestString);
        this.mutationSqlCacheOperations.createRecord(persistentOfflineMutationObject.recordIdentifier, persistentOfflineMutationObject.requestString, persistentOfflineMutationObject.responseClassName, persistentOfflineMutationObject.clientState, persistentOfflineMutationObject.bucket, persistentOfflineMutationObject.key, persistentOfflineMutationObject.region, persistentOfflineMutationObject.localURI, persistentOfflineMutationObject.mimeType);
    }

    public synchronized void addTimedoutMutation(PersistentOfflineMutationObject persistentOfflineMutationObject) {
        this.timedOutMutations.add(persistentOfflineMutationObject);
    }

    public synchronized void clearMutationQueue() {
        this.mutationSqlCacheOperations.clearCurrentCache();
        this.persistentOfflineMutationObjectList.clear();
    }

    public List fetchPersistentMutationsList() {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Fetching all mutation requests from persistent store");
        return this.mutationSqlCacheOperations.fetchAllRecords();
    }

    public synchronized Set getTimedoutMutations() {
        return this.timedOutMutations;
    }

    public synchronized boolean isQueueEmpty() {
        return this.persistentOfflineMutationObjectList.isEmpty();
    }

    public PersistentOfflineMutationObject processNextMutationObject() {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]:In processNextMutationObject");
        PersistentOfflineMutationObject firstInQueue = getFirstInQueue();
        if (firstInQueue != null) {
            this.networkInvoker.executeRequest(firstInQueue);
        }
        return firstInQueue;
    }

    public synchronized boolean removePersistentMutationObject(String str) {
        try {
            Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]:Removing mutation [" + str + "] from persistent store");
            if (this.persistentOfflineMutationObjectList.size() > 0 && str.equalsIgnoreCase(((PersistentOfflineMutationObject) this.persistentOfflineMutationObjectList.get(0)).recordIdentifier)) {
                this.persistentOfflineMutationObjectList.remove(0);
            }
            this.mutationSqlCacheOperations.deleteRecord(str);
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    public synchronized void removeTimedoutMutation(PersistentOfflineMutationObject persistentOfflineMutationObject) {
        this.timedOutMutations.remove(persistentOfflineMutationObject);
    }

    public void updateQueueHandler(AppSyncOfflineMutationInterceptor.QueueUpdateHandler queueUpdateHandler) {
        this.queueHandler = queueUpdateHandler;
        this.networkInvoker.updateQueueHandler(queueUpdateHandler);
    }
}
