package com.amazonaws.mobileconnectors.appsync;

import B1.e;
import K1.d;
import android.os.Message;
import android.util.Log;
import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.appsync.AppSyncOfflineMutationInterceptor;
import com.amazonaws.mobileconnectors.appsync.utils.StringUtils;
import com.amazonaws.util.VersionInfoUtils;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v1.p;
import v1.r;
import x1.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AppSyncCustomNetworkInvoker {
    private static final String ACCEPT_TYPE = "application/json";
    private static final String CONTENT_TYPE = "application/json";
    private static final String HEADER_ACCEPT_TYPE = "Accept";
    private static final String HEADER_CONTENT_TYPE = "CONTENT_TYPE";
    private static final String HEADER_USER_AGENT = "User-Agent";
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    private static final String TAG = AppSyncCustomNetworkInvoker.class.getSimpleName();
    Executor dispatcher = defaultDispatcher();
    volatile boolean disposed;
    volatile Call httpCall;
    final Call.Factory httpCallFactory;
    final PersistentMutationsCallback persistentMutationsCallback;
    PersistentOfflineMutationManager persistentOfflineMutationManager;
    AppSyncOfflineMutationInterceptor.QueueUpdateHandler queueHandler;
    final r s3ObjectManager;
    final d scalarTypeAdapters;
    final HttpUrl serverUrl;

    public class 1 implements ThreadFactory {
        public 1() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AppSync Persistent Mutations Dispatcher");
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ PersistentOfflineMutationObject val$persistentOfflineMutationObject;

        public class 1 implements p {
            public 1() {
            }

            public String bucket() {
                return 2.this.val$persistentOfflineMutationObject.bucket;
            }

            public String key() {
                return 2.this.val$persistentOfflineMutationObject.key;
            }

            public String localUri() {
                return 2.this.val$persistentOfflineMutationObject.localURI;
            }

            public String mimeType() {
                return 2.this.val$persistentOfflineMutationObject.mimeType;
            }

            public String region() {
                return 2.this.val$persistentOfflineMutationObject.region;
            }
        }

        public class 2 implements Callback {
            public 2() {
            }

            public void onFailure(Call call, IOException iOException) {
                Log.e(AppSyncCustomNetworkInvoker.access$200(), "Thread:[" + Thread.currentThread().getId() + "]: Failed to execute http call for [" + 2.this.val$persistentOfflineMutationObject.recordIdentifier + "]. Exception is [" + iOException + "]");
                if (!AppSyncCustomNetworkInvoker.this.disposed) {
                    AppSyncCustomNetworkInvoker.this.queueHandler.setMutationInProgressStatusToFalse();
                    return;
                }
                2 r4 = 2.this;
                AppSyncCustomNetworkInvoker.access$000(AppSyncCustomNetworkInvoker.this, r4.val$persistentOfflineMutationObject);
                AppSyncCustomNetworkInvoker.this.queueHandler.sendEmptyMessage(500);
            }

            public void onResponse(Call call, Response response) throws IOException {
                PersistentMutationsCallback persistentMutationsCallback;
                PersistentMutationsError persistentMutationsError;
                if (AppSyncCustomNetworkInvoker.this.disposed) {
                    2 r8 = 2.this;
                    AppSyncCustomNetworkInvoker.access$000(AppSyncCustomNetworkInvoker.this, r8.val$persistentOfflineMutationObject);
                    AppSyncCustomNetworkInvoker.this.queueHandler.sendEmptyMessage(500);
                    return;
                }
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        if (!ConflictResolutionHandler.conflictPresent(string)) {
                            PersistentMutationsCallback persistentMutationsCallback2 = AppSyncCustomNetworkInvoker.this.persistentMutationsCallback;
                            if (persistentMutationsCallback2 != null) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                JSONArray optJSONArray = jSONObject.optJSONArray("errors");
                                PersistentOfflineMutationObject persistentOfflineMutationObject = 2.this.val$persistentOfflineMutationObject;
                                persistentMutationsCallback2.onResponse(new PersistentMutationsResponse(optJSONObject, optJSONArray, persistentOfflineMutationObject.responseClassName, persistentOfflineMutationObject.recordIdentifier));
                            }
                            2 r82 = 2.this;
                            AppSyncCustomNetworkInvoker.access$000(AppSyncCustomNetworkInvoker.this, r82.val$persistentOfflineMutationObject);
                            AppSyncCustomNetworkInvoker.this.queueHandler.sendEmptyMessage(400);
                            return;
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("errors");
                        MutationInterceptorMessage mutationInterceptorMessage = new MutationInterceptorMessage();
                        PersistentOfflineMutationObject persistentOfflineMutationObject2 = 2.this.val$persistentOfflineMutationObject;
                        mutationInterceptorMessage.requestIdentifier = persistentOfflineMutationObject2.recordIdentifier;
                        mutationInterceptorMessage.clientState = persistentOfflineMutationObject2.clientState;
                        mutationInterceptorMessage.requestClassName = persistentOfflineMutationObject2.responseClassName;
                        mutationInterceptorMessage.serverState = new JSONObject(optJSONArray2.getJSONObject(0).getString("data")).toString();
                        Message message = new Message();
                        message.obj = mutationInterceptorMessage;
                        message.what = 600;
                        AppSyncCustomNetworkInvoker.this.queueHandler.sendMessage(message);
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d(AppSyncCustomNetworkInvoker.access$200(), "Thread:[" + Thread.currentThread().getId() + "]: JSON Parse error" + e.toString());
                        2 r9 = 2.this;
                        persistentMutationsCallback = AppSyncCustomNetworkInvoker.this.persistentMutationsCallback;
                        if (persistentMutationsCallback != null) {
                            PersistentOfflineMutationObject persistentOfflineMutationObject3 = r9.val$persistentOfflineMutationObject;
                            persistentMutationsError = new PersistentMutationsError(persistentOfflineMutationObject3.responseClassName, persistentOfflineMutationObject3.recordIdentifier, new e("Failed to parse http response", e));
                        }
                    }
                } else {
                    2 r83 = 2.this;
                    persistentMutationsCallback = AppSyncCustomNetworkInvoker.this.persistentMutationsCallback;
                    if (persistentMutationsCallback != null) {
                        PersistentOfflineMutationObject persistentOfflineMutationObject4 = r83.val$persistentOfflineMutationObject;
                        persistentMutationsError = new PersistentMutationsError(persistentOfflineMutationObject4.responseClassName, persistentOfflineMutationObject4.recordIdentifier, new B1.d("Failed to execute http call with error code and message: " + response.code() + response.message()));
                        persistentMutationsCallback.onFailure(persistentMutationsError);
                    }
                }
                2 r84 = 2.this;
                AppSyncCustomNetworkInvoker.access$000(AppSyncCustomNetworkInvoker.this, r84.val$persistentOfflineMutationObject);
                AppSyncCustomNetworkInvoker.this.queueHandler.sendEmptyMessage(500);
            }
        }

        public 2(PersistentOfflineMutationObject persistentOfflineMutationObject) {
            this.val$persistentOfflineMutationObject = persistentOfflineMutationObject;
        }

        public void run() {
            if (!this.val$persistentOfflineMutationObject.bucket.equals("")) {
                AppSyncCustomNetworkInvoker appSyncCustomNetworkInvoker = AppSyncCustomNetworkInvoker.this;
                r rVar = appSyncCustomNetworkInvoker.s3ObjectManager;
                if (rVar == null) {
                    PersistentMutationsCallback persistentMutationsCallback = appSyncCustomNetworkInvoker.persistentMutationsCallback;
                    if (persistentMutationsCallback != null) {
                        PersistentOfflineMutationObject persistentOfflineMutationObject = this.val$persistentOfflineMutationObject;
                        persistentMutationsCallback.onFailure(new PersistentMutationsError(persistentOfflineMutationObject.responseClassName, persistentOfflineMutationObject.recordIdentifier, new B1.d("S3 upload failed.", new IllegalArgumentException("S3ObjectManager not provided."))));
                    }
                    AppSyncCustomNetworkInvoker.access$000(AppSyncCustomNetworkInvoker.this, this.val$persistentOfflineMutationObject);
                    AppSyncCustomNetworkInvoker.this.queueHandler.sendEmptyMessage(500);
                    return;
                }
                try {
                    rVar.upload(new 1());
                } catch (Exception e) {
                    PersistentMutationsCallback persistentMutationsCallback2 = AppSyncCustomNetworkInvoker.this.persistentMutationsCallback;
                    if (persistentMutationsCallback2 != null) {
                        PersistentOfflineMutationObject persistentOfflineMutationObject2 = this.val$persistentOfflineMutationObject;
                        persistentMutationsCallback2.onFailure(new PersistentMutationsError(persistentOfflineMutationObject2.responseClassName, persistentOfflineMutationObject2.recordIdentifier, new B1.d("S3 upload failed.", e)));
                    }
                    AppSyncCustomNetworkInvoker.access$000(AppSyncCustomNetworkInvoker.this, this.val$persistentOfflineMutationObject);
                    AppSyncCustomNetworkInvoker.this.queueHandler.sendEmptyMessage(500);
                    return;
                } catch (AmazonClientException e2) {
                    if (e2.getCause() instanceof IOException) {
                        AppSyncCustomNetworkInvoker.this.queueHandler.setMutationInProgressStatusToFalse();
                        return;
                    }
                    PersistentMutationsCallback persistentMutationsCallback3 = AppSyncCustomNetworkInvoker.this.persistentMutationsCallback;
                    if (persistentMutationsCallback3 != null) {
                        PersistentOfflineMutationObject persistentOfflineMutationObject3 = this.val$persistentOfflineMutationObject;
                        persistentMutationsCallback3.onFailure(new PersistentMutationsError(persistentOfflineMutationObject3.responseClassName, persistentOfflineMutationObject3.recordIdentifier, new B1.d("S3 upload failed.", e2)));
                    }
                    AppSyncCustomNetworkInvoker.access$000(AppSyncCustomNetworkInvoker.this, this.val$persistentOfflineMutationObject);
                    AppSyncCustomNetworkInvoker.this.queueHandler.sendEmptyMessage(500);
                    return;
                }
            }
            AppSyncCustomNetworkInvoker appSyncCustomNetworkInvoker2 = AppSyncCustomNetworkInvoker.this;
            appSyncCustomNetworkInvoker2.httpCall = AppSyncCustomNetworkInvoker.access$100(appSyncCustomNetworkInvoker2, this.val$persistentOfflineMutationObject);
            AppSyncCustomNetworkInvoker.this.httpCall.enqueue(new 2());
        }
    }

    public AppSyncCustomNetworkInvoker(HttpUrl httpUrl, Call.Factory factory, d dVar, PersistentMutationsCallback persistentMutationsCallback, r rVar) {
        this.serverUrl = (HttpUrl) g.c(httpUrl, "serverUrl == null");
        this.httpCallFactory = (Call.Factory) g.c(factory, "httpCallFactory == null");
        this.scalarTypeAdapters = (d) g.c(dVar, "scalarTypeAdapters == null");
        this.persistentMutationsCallback = persistentMutationsCallback;
        this.s3ObjectManager = rVar;
    }

    public static /* synthetic */ void access$000(AppSyncCustomNetworkInvoker appSyncCustomNetworkInvoker, PersistentOfflineMutationObject persistentOfflineMutationObject) {
        appSyncCustomNetworkInvoker.setMutationExecutionAsCompletedAndRemoveFromQueue(persistentOfflineMutationObject);
    }

    public static /* synthetic */ Call access$100(AppSyncCustomNetworkInvoker appSyncCustomNetworkInvoker, PersistentOfflineMutationObject persistentOfflineMutationObject) {
        return appSyncCustomNetworkInvoker.httpCall(persistentOfflineMutationObject);
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    private Executor defaultDispatcher() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new 1());
    }

    private Call httpCall(PersistentOfflineMutationObject persistentOfflineMutationObject) {
        RequestBody create = RequestBody.create(MEDIA_TYPE, persistentOfflineMutationObject.requestString);
        String humanReadableAscii = StringUtils.toHumanReadableAscii(VersionInfoUtils.getUserAgent());
        return this.httpCallFactory.newCall(new Request.Builder().url(this.serverUrl).post(create).addHeader("User-Agent", humanReadableAscii + " OfflineMutation").header("Accept", "application/json").header("CONTENT_TYPE", "application/json").build());
    }

    private void setMutationExecutionAsCompletedAndRemoveFromQueue(PersistentOfflineMutationObject persistentOfflineMutationObject) {
        this.persistentOfflineMutationManager.removePersistentMutationObject(persistentOfflineMutationObject.recordIdentifier);
        if (this.persistentOfflineMutationManager.getTimedoutMutations().contains(persistentOfflineMutationObject)) {
            this.persistentOfflineMutationManager.removeTimedoutMutation(persistentOfflineMutationObject);
        } else {
            this.queueHandler.setMutationInProgressStatusToFalse();
        }
    }

    public void executeRequest(PersistentOfflineMutationObject persistentOfflineMutationObject) {
        this.dispatcher.execute(new 2(persistentOfflineMutationObject));
    }

    public void setPersistentOfflineMutationManager(PersistentOfflineMutationManager persistentOfflineMutationManager) {
        this.persistentOfflineMutationManager = persistentOfflineMutationManager;
    }

    public void updateQueueHandler(AppSyncOfflineMutationInterceptor.QueueUpdateHandler queueUpdateHandler) {
        this.queueHandler = queueUpdateHandler;
    }
}
