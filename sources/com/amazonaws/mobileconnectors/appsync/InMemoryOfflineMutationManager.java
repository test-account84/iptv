package com.amazonaws.mobileconnectors.appsync;

import android.util.Log;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import v1.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InMemoryOfflineMutationManager {
    private static final String TAG = "InMemoryOfflineMutationManager";
    List inMemoryOfflineMutationObjects = new LinkedList();
    Set cancelledMutations = new HashSet();
    Object lock = new Object();

    private InMemoryOfflineMutationObject getFirstInQueue() {
        synchronized (this.lock) {
            try {
                if (this.inMemoryOfflineMutationObjects.isEmpty()) {
                    return null;
                }
                return (InMemoryOfflineMutationObject) this.inMemoryOfflineMutationObjects.get(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addCancelledMutation(e eVar) {
        synchronized (this.lock) {
            this.cancelledMutations.add(eVar);
        }
    }

    public void addMutationObjectInQueue(InMemoryOfflineMutationObject inMemoryOfflineMutationObject) {
        synchronized (this.lock) {
            this.inMemoryOfflineMutationObjects.add(inMemoryOfflineMutationObject);
        }
    }

    public void clearMutationQueue() {
        synchronized (this.lock) {
            this.inMemoryOfflineMutationObjects.clear();
            this.cancelledMutations.clear();
        }
    }

    public Set getCancelledMutations() {
        Set set;
        synchronized (this.lock) {
            set = this.cancelledMutations;
        }
        return set;
    }

    public InMemoryOfflineMutationObject getMutationObject(e eVar) {
        for (InMemoryOfflineMutationObject inMemoryOfflineMutationObject : this.inMemoryOfflineMutationObjects) {
            if (inMemoryOfflineMutationObject.equals(eVar)) {
                return inMemoryOfflineMutationObject;
            }
        }
        return null;
    }

    public boolean isQueueEmpty() {
        boolean isEmpty;
        synchronized (this.lock) {
            isEmpty = this.inMemoryOfflineMutationObjects.isEmpty();
        }
        return isEmpty;
    }

    public InMemoryOfflineMutationObject processNextMutation() {
        InMemoryOfflineMutationObject firstInQueue = getFirstInQueue();
        if (firstInQueue != null && !getCancelledMutations().contains(firstInQueue.request.b)) {
            Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]:Executing mutation [" + firstInQueue.recordIdentifier + "]");
            firstInQueue.execute();
        }
        return firstInQueue;
    }

    public void removeCancelledMutation(e eVar) {
        synchronized (this.lock) {
            this.cancelledMutations.remove(eVar);
        }
    }

    public InMemoryOfflineMutationObject removeFromQueue(String str) {
        InMemoryOfflineMutationObject inMemoryOfflineMutationObject;
        synchronized (this.lock) {
            try {
                if (this.inMemoryOfflineMutationObjects.isEmpty() || (inMemoryOfflineMutationObject = (InMemoryOfflineMutationObject) this.inMemoryOfflineMutationObjects.get(0)) == null || !str.equals(inMemoryOfflineMutationObject.recordIdentifier)) {
                    return null;
                }
                return (InMemoryOfflineMutationObject) this.inMemoryOfflineMutationObjects.remove(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
