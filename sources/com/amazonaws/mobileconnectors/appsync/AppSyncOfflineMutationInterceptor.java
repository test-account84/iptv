package com.amazonaws.mobileconnectors.appsync;

import B1.b;
import B1.e;
import D1.a;
import K1.d;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;
import v1.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AppSyncOfflineMutationInterceptor implements a {
    private static final long QUEUE_POLL_INTERVAL = 10000;
    private static final String TAG = "AppSyncOfflineMutationInterceptor";
    AWSAppSyncClient appSyncClient;
    final AppSyncOfflineMutationManager appSyncOfflineMutationManager;
    Map callbackMapForInMemoryMutations;
    ConflictResolutionHandler conflictResolutionHandler;
    private final ConflictResolverInterface conflictResolver;
    private Map mutationsToRetryAfterConflictResolution;
    Map persistentOfflineMutationObjectMap;
    private QueueUpdateHandler queueHandler;
    private HandlerThread queueHandlerThread;
    final d scalarTypeAdapters = new d(new LinkedHashMap());
    final boolean sendOperationIdentifiers;

    public class 1 implements Runnable {
        public 1() {
        }

        public void run() {
            Log.v(AppSyncOfflineMutationInterceptor.access$100(), "Thread:[" + Thread.currentThread().getId() + "]: processing Mutations");
            Message message = new Message();
            message.obj = new MutationInterceptorMessage();
            message.what = 400;
            AppSyncOfflineMutationInterceptor.access$200(AppSyncOfflineMutationInterceptor.this).sendMessage(message);
            AppSyncOfflineMutationInterceptor.access$200(AppSyncOfflineMutationInterceptor.this).postDelayed(this, 10000L);
        }
    }

    public class 2 implements a.a {
        final /* synthetic */ a.a val$callBack;
        final /* synthetic */ PersistentMutationsCallback val$callbackForPersistentMutation;
        final /* synthetic */ PersistentOfflineMutationObject val$object;
        final /* synthetic */ a.c val$request;

        public 2(a.a aVar, PersistentMutationsCallback persistentMutationsCallback, a.c cVar, PersistentOfflineMutationObject persistentOfflineMutationObject) {
            this.val$callBack = aVar;
            this.val$callbackForPersistentMutation = persistentMutationsCallback;
            this.val$request = cVar;
            this.val$object = persistentOfflineMutationObject;
        }

        public void onCompleted() {
        }

        public void onFailure(b bVar) {
            this.val$callBack.onFailure(bVar);
            PersistentMutationsCallback persistentMutationsCallback = this.val$callbackForPersistentMutation;
            if (persistentMutationsCallback != null) {
                persistentMutationsCallback.onFailure(new PersistentMutationsError(this.val$request.b.getClass().getSimpleName(), this.val$object.recordIdentifier, bVar));
            }
            AppSyncOfflineMutationInterceptor.this.appSyncOfflineMutationManager.setInProgressPersistentMutationAsCompleted(this.val$object.recordIdentifier);
            AppSyncOfflineMutationInterceptor.access$200(AppSyncOfflineMutationInterceptor.this).clearPersistentOfflineMutationObjectBeingExecuted();
            AppSyncOfflineMutationInterceptor.access$200(AppSyncOfflineMutationInterceptor.this).clearInMemoryOfflineMutationObjectBeingExecuted();
            AppSyncOfflineMutationInterceptor.access$200(AppSyncOfflineMutationInterceptor.this).sendEmptyMessage(500);
        }

        public void onFetch(a.b bVar) {
            this.val$callBack.onFetch(bVar);
        }

        public void onResponse(a.d dVar) {
            this.val$callBack.onResponse(dVar);
            if (this.val$callbackForPersistentMutation != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) dVar.d.e());
                    this.val$callbackForPersistentMutation.onResponse(new PersistentMutationsResponse(jSONObject.getJSONObject("data"), jSONObject.getJSONArray("errors"), this.val$request.b.getClass().getSimpleName(), this.val$object.recordIdentifier));
                } catch (Exception e) {
                    this.val$callbackForPersistentMutation.onFailure(new PersistentMutationsError(this.val$request.b.getClass().getSimpleName(), this.val$object.recordIdentifier, new e(e.getLocalizedMessage())));
                }
            }
            AppSyncOfflineMutationInterceptor.this.appSyncOfflineMutationManager.setInProgressPersistentMutationAsCompleted(this.val$object.recordIdentifier);
            AppSyncOfflineMutationInterceptor.access$200(AppSyncOfflineMutationInterceptor.this).clearInMemoryOfflineMutationObjectBeingExecuted();
            AppSyncOfflineMutationInterceptor.access$200(AppSyncOfflineMutationInterceptor.this).clearPersistentOfflineMutationObjectBeingExecuted();
            AppSyncOfflineMutationInterceptor.access$200(AppSyncOfflineMutationInterceptor.this).sendEmptyMessage(400);
        }
    }

    public class QueueUpdateHandler extends Handler {
        private final long CANCEL_WINDOW;
        private final String TAG;
        private InMemoryOfflineMutationObject inMemoryOfflineMutationObjectBeingExecuted;
        private long maxMutationExecutionTime;
        private boolean mutationInProgress;
        private PersistentOfflineMutationObject persistentOfflineMutationObjectBeingExecuted;
        private long startTime;

        public QueueUpdateHandler(Looper looper) {
            super(looper);
            this.TAG = QueueUpdateHandler.class.getSimpleName();
            this.mutationInProgress = false;
            this.CANCEL_WINDOW = 15000L;
            this.inMemoryOfflineMutationObjectBeingExecuted = null;
            this.persistentOfflineMutationObjectBeingExecuted = null;
            this.startTime = 0L;
        }

        public static /* synthetic */ PersistentOfflineMutationObject access$300(QueueUpdateHandler queueUpdateHandler) {
            return queueUpdateHandler.persistentOfflineMutationObjectBeingExecuted;
        }

        private void checkAndHandleStuckMutation() {
            if (this.inMemoryOfflineMutationObjectBeingExecuted == null && this.persistentOfflineMutationObjectBeingExecuted == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.startTime;
            PersistentOfflineMutationObject persistentOfflineMutationObject = this.persistentOfflineMutationObjectBeingExecuted;
            if (persistentOfflineMutationObject != null) {
                long j = this.maxMutationExecutionTime;
                if (currentTimeMillis > 15000 + j) {
                    AppSyncOfflineMutationInterceptor.this.appSyncOfflineMutationManager.setInProgressMutationAsCompleted(persistentOfflineMutationObject.recordIdentifier);
                    sendEmptyMessage(500);
                    return;
                } else {
                    if (currentTimeMillis > j) {
                        AppSyncOfflineMutationInterceptor.this.appSyncOfflineMutationManager.persistentOfflineMutationManager.addTimedoutMutation(persistentOfflineMutationObject);
                        AppSyncOfflineMutationInterceptor.this.appSyncOfflineMutationManager.persistentOfflineMutationManager.removePersistentMutationObject(this.persistentOfflineMutationObjectBeingExecuted.recordIdentifier);
                        return;
                    }
                    return;
                }
            }
            InMemoryOfflineMutationObject inMemoryOfflineMutationObject = this.inMemoryOfflineMutationObjectBeingExecuted;
            if (inMemoryOfflineMutationObject != null) {
                long j2 = this.maxMutationExecutionTime;
                if (currentTimeMillis > 15000 + j2) {
                    AppSyncOfflineMutationInterceptor.this.appSyncOfflineMutationManager.setInProgressMutationAsCompleted(inMemoryOfflineMutationObject.recordIdentifier);
                    sendEmptyMessage(500);
                } else if (currentTimeMillis > j2) {
                    inMemoryOfflineMutationObject.chain.dispose();
                    AppSyncOfflineMutationInterceptor.this.dispose((v1.e) this.inMemoryOfflineMutationObjectBeingExecuted.request.b);
                }
            }
        }

        public void clearInMemoryOfflineMutationObjectBeingExecuted() {
            this.inMemoryOfflineMutationObjectBeingExecuted = null;
            this.startTime = 0L;
        }

        public void clearPersistentOfflineMutationObjectBeingExecuted() {
            this.persistentOfflineMutationObjectBeingExecuted = null;
            this.startTime = 0L;
        }

        public void handleMessage(Message message) {
            Log.v(this.TAG, "Thread:[" + Thread.currentThread().getId() + "]: Got message to take action on the mutation queue.");
            int i = message.what;
            if (i == 400 || i == 500) {
                if (!isMutationInProgress()) {
                    Log.v(this.TAG, "Thread:[" + Thread.currentThread().getId() + "]: Got message to process next mutation if one exists.");
                    AppSyncOfflineMutationInterceptor.this.appSyncOfflineMutationManager.processNextInQueueMutation();
                }
            } else if (i == 600) {
                Log.d(this.TAG, "Thread:[" + Thread.currentThread().getId() + "]: Got message that a originalMutation process needs to be retried.");
                MutationInterceptorMessage mutationInterceptorMessage = (MutationInterceptorMessage) message.obj;
                try {
                    if (AppSyncOfflineMutationInterceptor.access$000(AppSyncOfflineMutationInterceptor.this) != null) {
                        AppSyncOfflineMutationInterceptor.access$000(AppSyncOfflineMutationInterceptor.this).resolveConflict(AppSyncOfflineMutationInterceptor.this.conflictResolutionHandler, new JSONObject(mutationInterceptorMessage.serverState), new JSONObject(mutationInterceptorMessage.clientState), mutationInterceptorMessage.requestIdentifier, mutationInterceptorMessage.requestClassName);
                    } else {
                        AppSyncOfflineMutationInterceptor.this.failConflictMutation(mutationInterceptorMessage.requestIdentifier);
                    }
                } catch (Exception e) {
                    Log.v(this.TAG, "Thread:[" + Thread.currentThread().getId() + "]: " + e.toString());
                    e.printStackTrace();
                }
            } else {
                Log.d(this.TAG, "Unknown message received in QueueUpdateHandler. Ignoring");
            }
            checkAndHandleStuckMutation();
        }

        public synchronized boolean isMutationInProgress() {
            return this.mutationInProgress;
        }

        public void setInMemoryOfflineMutationObjectBeingExecuted(InMemoryOfflineMutationObject inMemoryOfflineMutationObject) {
            this.inMemoryOfflineMutationObjectBeingExecuted = inMemoryOfflineMutationObject;
            this.startTime = System.currentTimeMillis();
        }

        public void setMaximumMutationExecutionTime(long j) {
            this.maxMutationExecutionTime = j;
        }

        public synchronized boolean setMutationInProgress() {
            if (this.mutationInProgress) {
                return false;
            }
            Log.v(this.TAG, "Thread:[" + Thread.currentThread().getId() + "]: Setting mutationInProgress as true.");
            this.mutationInProgress = true;
            return true;
        }

        public synchronized void setMutationInProgressStatusToFalse() {
            Log.v(this.TAG, "Thread:[" + Thread.currentThread().getId() + "]: Setting mutationInProgress as false.");
            this.mutationInProgress = false;
        }

        public void setPersistentOfflineMutationObjectBeingExecuted(PersistentOfflineMutationObject persistentOfflineMutationObject) {
            this.persistentOfflineMutationObjectBeingExecuted = persistentOfflineMutationObject;
            this.startTime = System.currentTimeMillis();
        }
    }

    public AppSyncOfflineMutationInterceptor(AppSyncOfflineMutationManager appSyncOfflineMutationManager, boolean z, Context context, Map map, AWSAppSyncClient aWSAppSyncClient, ConflictResolverInterface conflictResolverInterface, long j) {
        this.sendOperationIdentifiers = z;
        this.appSyncOfflineMutationManager = appSyncOfflineMutationManager;
        this.appSyncClient = aWSAppSyncClient;
        this.mutationsToRetryAfterConflictResolution = map;
        HandlerThread handlerThread = new HandlerThread("AWSAppSyncMutationQueueThread");
        this.queueHandlerThread = handlerThread;
        handlerThread.start();
        QueueUpdateHandler queueUpdateHandler = new QueueUpdateHandler(this.queueHandlerThread.getLooper());
        this.queueHandler = queueUpdateHandler;
        queueUpdateHandler.setMaximumMutationExecutionTime(j);
        this.queueHandler.postDelayed(new 1(), 10000L);
        appSyncOfflineMutationManager.updateQueueHandler(this.queueHandler);
        this.callbackMapForInMemoryMutations = new HashMap();
        this.persistentOfflineMutationObjectMap = appSyncOfflineMutationManager.persistentOfflineMutationManager.persistentOfflineMutationObjectMap;
        this.conflictResolutionHandler = new ConflictResolutionHandler(this);
        this.conflictResolver = conflictResolverInterface;
    }

    public static /* synthetic */ ConflictResolverInterface access$000(AppSyncOfflineMutationInterceptor appSyncOfflineMutationInterceptor) {
        return appSyncOfflineMutationInterceptor.conflictResolver;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ QueueUpdateHandler access$200(AppSyncOfflineMutationInterceptor appSyncOfflineMutationInterceptor) {
        return appSyncOfflineMutationInterceptor.queueHandler;
    }

    public void dispose() {
        Log.v(TAG, "Dispose called");
    }

    public void failConflictMutation(String str) {
        ConflictResolutionFailedException conflictResolutionFailedException = new ConflictResolutionFailedException("Mutation [" + str + "] failed due to conflict");
        a.a aVar = (a.a) this.callbackMapForInMemoryMutations.get(str);
        if (aVar != null) {
            aVar.onFailure(conflictResolutionFailedException);
            this.callbackMapForInMemoryMutations.remove(str);
        } else {
            PersistentMutationsCallback persistentMutationsCallback = this.appSyncOfflineMutationManager.persistentOfflineMutationManager.networkInvoker.persistentMutationsCallback;
            if (persistentMutationsCallback != null) {
                persistentMutationsCallback.onFailure(new PersistentMutationsError(QueueUpdateHandler.access$300(this.queueHandler).getClass().getSimpleName(), str, conflictResolutionFailedException));
            }
        }
        this.mutationsToRetryAfterConflictResolution.remove(str);
        if (QueueUpdateHandler.access$300(this.queueHandler) != null) {
            this.appSyncOfflineMutationManager.setInProgressPersistentMutationAsCompleted(str);
        } else {
            this.appSyncOfflineMutationManager.setInProgressMutationAsCompleted(str);
        }
        this.queueHandler.clearPersistentOfflineMutationObjectBeingExecuted();
        this.queueHandler.clearInMemoryOfflineMutationObjectBeingExecuted();
        this.queueHandler.sendEmptyMessage(500);
    }

    public void interceptAsync(a.c cVar, D1.b bVar, Executor executor, a.a aVar) {
        if (!(cVar.b instanceof v1.e)) {
            bVar.a(cVar, executor, aVar);
            return;
        }
        String str = TAG;
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Processing mutation.");
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: First, checking if it is a retry of mutation that encountered a conflict.");
        if (!this.mutationsToRetryAfterConflictResolution.containsKey(cVar.b)) {
            Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]:Nope, hasn't encountered  conflict");
            QueueUpdateHandler queueUpdateHandler = this.queueHandler;
            f fVar = cVar.b;
            InterceptorCallback interceptorCallback = new InterceptorCallback(aVar, queueUpdateHandler, (v1.e) fVar, (v1.e) fVar, this.appSyncOfflineMutationManager.getClientStateFromMutation((v1.e) fVar), cVar.a.toString(), this.appSyncOfflineMutationManager);
            try {
                this.callbackMapForInMemoryMutations.put(cVar.a.toString(), interceptorCallback);
                this.appSyncOfflineMutationManager.addMutationObjectInQueue(new InMemoryOfflineMutationObject(cVar.a.toString(), cVar, bVar, executor, interceptorCallback));
                return;
            } catch (Exception e) {
                Log.e(TAG, "ERROR: " + e);
                e.printStackTrace();
                return;
            }
        }
        Log.d(str, "Thread:[" + Thread.currentThread().getId() + "]: Yes, this is a mutation that gone through conflict resolution. Executing it.");
        this.mutationsToRetryAfterConflictResolution.remove(cVar.b);
        Log.v(str, "Looking up originalCallback using key[" + cVar.b.toString() + "]");
        InterceptorCallback interceptorCallback2 = (InterceptorCallback) this.callbackMapForInMemoryMutations.get(cVar.b.toString());
        if (interceptorCallback2 != null) {
            Log.v(str, "callback found. Proceeding to execute inMemory offline mutation");
            bVar.a(cVar, executor, interceptorCallback2);
            return;
        }
        PersistentMutationsCallback persistentMutationsCallback = this.appSyncOfflineMutationManager.persistentOfflineMutationManager.networkInvoker.persistentMutationsCallback;
        PersistentOfflineMutationObject persistentOfflineMutationObject = (PersistentOfflineMutationObject) this.persistentOfflineMutationObjectMap.get(cVar.b.toString());
        Log.d(str, "Thread:[" + Thread.currentThread().getId() + "]: Fetched object: " + persistentOfflineMutationObject);
        bVar.a(cVar, executor, new 2(aVar, persistentMutationsCallback, cVar, persistentOfflineMutationObject));
    }

    public void retryConflictMutation(v1.e eVar, String str) {
        InterceptorCallback interceptorCallback = (InterceptorCallback) this.callbackMapForInMemoryMutations.remove(str);
        if (interceptorCallback != null) {
            Log.d(TAG, "Proceeding with retry for inMemory offline mutation [" + str + "]");
            this.callbackMapForInMemoryMutations.put(eVar.toString(), interceptorCallback);
        } else {
            String str2 = TAG;
            Log.d(str2, "Proceeding with retry for persistent offline mutation [" + str + "]");
            if (this.persistentOfflineMutationObjectMap.isEmpty()) {
                Log.d(str2, "Populating mutations map.");
                this.persistentOfflineMutationObjectMap.putAll(this.appSyncOfflineMutationManager.persistentOfflineMutationManager.persistentOfflineMutationObjectMap);
            }
            this.persistentOfflineMutationObjectMap.put(eVar.toString(), (PersistentOfflineMutationObject) this.persistentOfflineMutationObjectMap.remove(str));
        }
        this.appSyncClient.mutate(eVar, true).enqueue(null);
    }

    public void dispose(v1.e eVar) {
        Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Dispose called for mutation [" + eVar + "].");
        this.appSyncOfflineMutationManager.handleMutationCancellation(eVar);
    }
}
