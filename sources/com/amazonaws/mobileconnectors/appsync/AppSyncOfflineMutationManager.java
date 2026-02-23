package com.amazonaws.mobileconnectors.appsync;

import D1.a;
import J1.h;
import K1.d;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.amazonaws.mobileconnectors.appsync.AppSyncOfflineMutationInterceptor;
import com.amazonaws.mobileconnectors.appsync.ConnectivityWatcher;
import java.io.IOException;
import java.util.Map;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;
import v1.e;
import v1.f;
import v1.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AppSyncOfflineMutationManager {
    static final int MSG_CHECK = 200;
    static final int MSG_DISCONNECT = 300;
    static final int MSG_EXEC = 100;
    private static final String TAG = "AppSyncOfflineMutationManager";
    private ConnectivityWatcher connectivityWatcher;
    private Context context;
    private HandlerThread handlerThread;
    InMemoryOfflineMutationManager inMemoryOfflineMutationManager;
    private AppSyncMutationSqlCacheOperations mutationSqlCacheOperations;
    private NetworkUpdateHandler networkUpdateHandler;
    PersistentOfflineMutationManager persistentOfflineMutationManager;
    private AppSyncOfflineMutationInterceptor.QueueUpdateHandler queueHandler;
    private d scalarTypeAdapters;
    private boolean shouldProcessMutations;
    private final Object shouldProcessMutationsLock = new Object();
    private InMemoryOfflineMutationObject currentMutation = null;

    public static class NetworkInfoReceiver implements ConnectivityWatcher.Callback {
        private final Handler handler;

        public NetworkInfoReceiver(Handler handler) {
            this.handler = handler;
        }

        public void onConnectivityChanged(boolean z) {
            this.handler.sendEmptyMessage(z ? 200 : 300);
        }
    }

    public class NetworkUpdateHandler extends Handler {
        public NetworkUpdateHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 200) {
                if (i == 300) {
                    Log.d(AppSyncOfflineMutationManager.access$000(), "Thread:[" + Thread.currentThread().getId() + "]: Internet DISCONNECTED.");
                    synchronized (AppSyncOfflineMutationManager.access$100(AppSyncOfflineMutationManager.this)) {
                        AppSyncOfflineMutationManager.access$202(AppSyncOfflineMutationManager.this, false);
                    }
                    AWSAppSyncDeltaSync.handleNetworkDownEvent();
                    return;
                }
                return;
            }
            Log.d(AppSyncOfflineMutationManager.access$000(), "Thread:[" + Thread.currentThread().getId() + "]: Internet CONNECTED.");
            synchronized (AppSyncOfflineMutationManager.access$100(AppSyncOfflineMutationManager.this)) {
                AppSyncOfflineMutationManager.access$202(AppSyncOfflineMutationManager.this, true);
            }
            if (AppSyncOfflineMutationManager.access$300(AppSyncOfflineMutationManager.this) != null) {
                Message message2 = new Message();
                message2.obj = new MutationInterceptorMessage();
                message2.what = 400;
                AppSyncOfflineMutationManager.access$300(AppSyncOfflineMutationManager.this).sendMessage(message2);
            }
            AWSAppSyncDeltaSync.handleNetworkUpEvent();
        }
    }

    public AppSyncOfflineMutationManager(Context context, Map map, AppSyncMutationSqlCacheOperations appSyncMutationSqlCacheOperations, AppSyncCustomNetworkInvoker appSyncCustomNetworkInvoker) {
        this.context = context;
        HandlerThread handlerThread = new HandlerThread(TAG + "-AWSAppSyncOfflineMutationsHandlerThread");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.inMemoryOfflineMutationManager = new InMemoryOfflineMutationManager();
        this.persistentOfflineMutationManager = new PersistentOfflineMutationManager(appSyncMutationSqlCacheOperations, appSyncCustomNetworkInvoker);
        NetworkUpdateHandler networkUpdateHandler = new NetworkUpdateHandler(this.handlerThread.getLooper());
        this.networkUpdateHandler = networkUpdateHandler;
        ConnectivityWatcher connectivityWatcher = this.connectivityWatcher;
        if (connectivityWatcher == null) {
            this.connectivityWatcher = new ConnectivityWatcher(context, new NetworkInfoReceiver(networkUpdateHandler));
        } else {
            connectivityWatcher.unregister();
        }
        this.connectivityWatcher.register();
        this.scalarTypeAdapters = new d(map);
        this.mutationSqlCacheOperations = appSyncMutationSqlCacheOperations;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ Object access$100(AppSyncOfflineMutationManager appSyncOfflineMutationManager) {
        return appSyncOfflineMutationManager.shouldProcessMutationsLock;
    }

    public static /* synthetic */ boolean access$202(AppSyncOfflineMutationManager appSyncOfflineMutationManager, boolean z) {
        appSyncOfflineMutationManager.shouldProcessMutations = z;
        return z;
    }

    public static /* synthetic */ AppSyncOfflineMutationInterceptor.QueueUpdateHandler access$300(AppSyncOfflineMutationManager appSyncOfflineMutationManager) {
        return appSyncOfflineMutationManager.queueHandler;
    }

    private String httpRequestBody(f fVar) throws IOException {
        Buffer buffer = new Buffer();
        h i = h.i(buffer);
        i.c();
        i.g("query").p(fVar.queryDocument().replaceAll("\\n", ""));
        i.g("variables").c();
        fVar.variables().marshaller().marshal(new J1.d(i, this.scalarTypeAdapters));
        i.e();
        i.e();
        i.close();
        return buffer.readUtf8();
    }

    public void addMutationObjectInQueue(InMemoryOfflineMutationObject inMemoryOfflineMutationObject) throws IOException {
        this.inMemoryOfflineMutationManager.addMutationObjectInQueue(inMemoryOfflineMutationObject);
        String str = TAG;
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]:  Added mutation[" + inMemoryOfflineMutationObject.recordIdentifier + "] to inMemory Queue");
        p s3ComplexObject = S3ObjectManagerImplementation.getS3ComplexObject(inMemoryOfflineMutationObject.request.b.variables().valueMap());
        if (s3ComplexObject == null) {
            this.persistentOfflineMutationManager.addPersistentMutationObject(new PersistentOfflineMutationObject(inMemoryOfflineMutationObject.recordIdentifier, httpRequestBody(inMemoryOfflineMutationObject.request.b), inMemoryOfflineMutationObject.request.b.getClass().getSimpleName(), getClientStateFromMutation((e) inMemoryOfflineMutationObject.request.b)));
            Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Added mutation[" + inMemoryOfflineMutationObject.recordIdentifier + "] to Persistent Queue. No S3 Objects found");
        } else {
            this.persistentOfflineMutationManager.addPersistentMutationObject(new PersistentOfflineMutationObject(inMemoryOfflineMutationObject.recordIdentifier, httpRequestBody(inMemoryOfflineMutationObject.request.b), inMemoryOfflineMutationObject.request.b.getClass().getSimpleName(), getClientStateFromMutation((e) inMemoryOfflineMutationObject.request.b), s3ComplexObject.bucket(), s3ComplexObject.key(), s3ComplexObject.region(), s3ComplexObject.localUri(), s3ComplexObject.mimeType()));
            Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Added mutation[" + inMemoryOfflineMutationObject.recordIdentifier + "] to Persistent Queue. S3 Object found");
        }
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Created both in-memory and persistent records. Now going to signal queue handler.");
        Message message = new Message();
        message.obj = new MutationInterceptorMessage();
        message.what = 400;
        this.queueHandler.sendMessage(message);
    }

    public void clearMutationQueue() {
        this.inMemoryOfflineMutationManager.clearMutationQueue();
        this.persistentOfflineMutationManager.clearMutationQueue();
    }

    public String getClientStateFromMutation(e eVar) {
        String str;
        StringBuilder sb;
        try {
            return new JSONObject(httpRequestBody(eVar)).getJSONObject("variables").toString();
        } catch (IOException e) {
            e = e;
            str = TAG;
            sb = new StringBuilder();
            sb.append("IOException while getting clientState from Mutation: [");
            sb.append(e);
            sb.append("]");
            Log.v(str, sb.toString());
            return "";
        } catch (JSONException e2) {
            e = e2;
            str = TAG;
            sb = new StringBuilder();
            sb.append("IOException while getting clientState from Mutation: [");
            sb.append(e);
            sb.append("]");
            Log.v(str, sb.toString());
            return "";
        }
    }

    public void handleMutationCancellation(e eVar) {
        a.c cVar;
        String str = TAG;
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Handling cancellation for mutation [" + eVar + "]");
        InMemoryOfflineMutationObject inMemoryOfflineMutationObject = this.currentMutation;
        if (inMemoryOfflineMutationObject != null && (cVar = inMemoryOfflineMutationObject.request) != null && eVar.equals(cVar.b)) {
            Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Mutation being canceled is the one currently in progress. Handling it ");
            setInProgressMutationAsCompleted(this.currentMutation.recordIdentifier);
            this.queueHandler.sendEmptyMessage(500);
            return;
        }
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Lodging mutation in cancelled mutations list ");
        this.inMemoryOfflineMutationManager.addCancelledMutation(eVar);
        InMemoryOfflineMutationObject mutationObject = this.inMemoryOfflineMutationManager.getMutationObject(eVar);
        if (mutationObject != null) {
            this.persistentOfflineMutationManager.removePersistentMutationObject(mutationObject.recordIdentifier);
        }
    }

    public boolean mutationQueueEmpty() {
        return this.persistentOfflineMutationManager.isQueueEmpty() && this.inMemoryOfflineMutationManager.isQueueEmpty();
    }

    public void processNextInQueueMutation() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            Log.v(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Internet wasn't available. Exiting");
            return;
        }
        if (!this.persistentOfflineMutationManager.isQueueEmpty()) {
            if (this.queueHandler.setMutationInProgress()) {
                Log.d(TAG, "Thread:[" + Thread.currentThread().getId() + "]: Processing next from persistent queue");
                PersistentOfflineMutationObject processNextMutationObject = this.persistentOfflineMutationManager.processNextMutationObject();
                if (processNextMutationObject != null) {
                    this.queueHandler.setPersistentOfflineMutationObjectBeingExecuted(processNextMutationObject);
                    return;
                }
                return;
            }
            return;
        }
        String str = TAG;
        Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]:Persistent mutations queue is EMPTY!. Will check inMemory Queue next");
        if (this.inMemoryOfflineMutationManager.isQueueEmpty()) {
            Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: In Memory mutations queue was EMPTY!. Nothing to process, exiting");
            return;
        }
        if (this.queueHandler.setMutationInProgress()) {
            Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Processing next from in Memory queue");
            InMemoryOfflineMutationObject processNextMutation = this.inMemoryOfflineMutationManager.processNextMutation();
            this.currentMutation = processNextMutation;
            if (processNextMutation == null) {
                return;
            }
            this.queueHandler.setInMemoryOfflineMutationObjectBeingExecuted(processNextMutation);
            if (this.inMemoryOfflineMutationManager.getCancelledMutations().contains((e) this.currentMutation.request.b)) {
                Log.v(str, "Thread:[" + Thread.currentThread().getId() + "]: Handling cancellation for mutation [" + this.currentMutation.recordIdentifier + "] ");
                setInProgressMutationAsCompleted(this.currentMutation.recordIdentifier);
                this.inMemoryOfflineMutationManager.removeCancelledMutation((e) this.currentMutation.request.b);
                this.queueHandler.sendEmptyMessage(500);
            }
        }
    }

    public void setInProgressMutationAsCompleted(String str) {
        this.persistentOfflineMutationManager.removePersistentMutationObject(str);
        this.inMemoryOfflineMutationManager.removeFromQueue(str);
        this.queueHandler.setMutationInProgressStatusToFalse();
        this.queueHandler.clearInMemoryOfflineMutationObjectBeingExecuted();
        this.queueHandler.clearPersistentOfflineMutationObjectBeingExecuted();
    }

    public void setInProgressPersistentMutationAsCompleted(String str) {
        this.persistentOfflineMutationManager.removePersistentMutationObject(str);
        this.queueHandler.setMutationInProgressStatusToFalse();
        this.queueHandler.clearInMemoryOfflineMutationObjectBeingExecuted();
        this.queueHandler.clearPersistentOfflineMutationObjectBeingExecuted();
    }

    public void updateQueueHandler(AppSyncOfflineMutationInterceptor.QueueUpdateHandler queueUpdateHandler) {
        this.queueHandler = queueUpdateHandler;
        this.persistentOfflineMutationManager.updateQueueHandler(queueUpdateHandler);
    }
}
