package com.amazonaws.mobileconnectors.appsync;

import B1.b;
import C1.a;
import android.content.Context;
import android.util.Log;
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSyncDBOperations;
import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import com.amazonaws.mobileconnectors.appsync.retry.RetryInterceptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import u1.c;
import v1.f;
import v1.h;
import v1.i;
import v1.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AWSAppSyncDeltaSync {
    private static final String PROCESSING_MODE = "PROCESSING_MODE";
    private static final String QUEUING_MODE = "QUEUING_MODE";
    private static final String TAG = "AWSAppSyncDeltaSync";
    private static Boolean appInForeground;
    private static AWSAppSyncDeltaSyncSqlHelper awsAppSyncDeltaSyncSqlHelper;
    private static Map deltaSyncObjects = new HashMap();
    private static Object foregroundLock;
    private static Object networkLock;
    private static Boolean networkUp;
    private AWSAppSyncClient awsAppSyncClient;
    private h baseQuery;
    private Long id;
    private Context mContext;
    private t subscription;
    private AppSyncSubscriptionCall.Callback subscriptionCallback;
    private String mode = null;
    private Object processingLock = new Object();
    private c.a baseQueryCallback = null;
    private h deltaQuery = null;
    private long lastRunTimeInMilliSeconds = 0;
    private long baseRefreshIntervalInSeconds = 86400;
    private c.a deltaQueryCallback = null;
    AppSyncSubscriptionCall deltaSyncSubscriptionWatcher = null;
    private ArrayDeque messageQueue = new ArrayDeque();
    private boolean deltaSyncOperationFailed = false;
    private boolean cancelled = false;
    private AWSAppSyncDeltaSyncDBOperations dbHelper = null;
    private Object initializationLock = new Object();
    private boolean recordCreatedOrFound = false;
    private ScheduledFuture nextScheduledRun = null;
    int retryAttempt = 0;
    private ScheduledFuture nextRetryAttempt = null;
    private AppSyncSubscriptionCall.Callback scb = null;
    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public class 1 implements Runnable {
        final /* synthetic */ boolean val$forceFetch;

        public 1(boolean z) {
            this.val$forceFetch = z;
        }

        /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
            java.util.ConcurrentModificationException
            	at java.util.ArrayList$Itr.next(ArrayList.java:860)
            	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
            	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
            	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
            	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
            */
        public void run() {
            /*
                Method dump skipped, instructions count: 321
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync.1.run():void");
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ WeakReference val$thisObjectRef;

        public 2(WeakReference weakReference) {
            this.val$thisObjectRef = weakReference;
        }

        public void run() {
            if (this.val$thisObjectRef.get() != null) {
                ((AWSAppSyncDeltaSync) this.val$thisObjectRef.get()).execute(true);
            }
        }
    }

    public class 3 implements Runnable {
        final /* synthetic */ WeakReference val$thisObjectRef;

        public 3(WeakReference weakReference) {
            this.val$thisObjectRef = weakReference;
        }

        public void run() {
            if (this.val$thisObjectRef.get() != null) {
                ((AWSAppSyncDeltaSync) this.val$thisObjectRef.get()).execute(false);
            }
        }
    }

    public class 4 extends c.a {
        final /* synthetic */ CountDownLatch val$baseQueryCountdownLatch;
        final /* synthetic */ long val$baseQueryInitiationTime;
        final /* synthetic */ a val$fetchPolicy;

        public 4(a aVar, long j, CountDownLatch countDownLatch) {
            this.val$fetchPolicy = aVar;
            this.val$baseQueryInitiationTime = j;
            this.val$baseQueryCountdownLatch = countDownLatch;
        }

        public void onFailure(b bVar) {
            Log.e(AWSAppSyncDeltaSync.access$000(), "Delta Query: BaseQuery failed with [" + bVar.getLocalizedMessage() + "]");
            bVar.printStackTrace();
            AWSAppSyncDeltaSync.access$102(AWSAppSyncDeltaSync.this, true);
            if (AWSAppSyncDeltaSync.access$1400(AWSAppSyncDeltaSync.this) != null) {
                AWSAppSyncDeltaSync.access$1400(AWSAppSyncDeltaSync.this).onFailure(bVar);
            }
            this.val$baseQueryCountdownLatch.countDown();
        }

        public void onResponse(i iVar) {
            Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Base query response received");
            if (AppSyncResponseFetchers.NETWORK_ONLY.equals(this.val$fetchPolicy)) {
                AWSAppSyncDeltaSync.access$1100(AWSAppSyncDeltaSync.this, this.val$baseQueryInitiationTime);
                AWSAppSyncDeltaSync.access$602(AWSAppSyncDeltaSync.this, this.val$baseQueryInitiationTime);
                AWSAppSyncDeltaSync.access$1300(AWSAppSyncDeltaSync.this).updateLastRunTime(AWSAppSyncDeltaSync.access$1200(AWSAppSyncDeltaSync.this).longValue(), AWSAppSyncDeltaSync.access$600(AWSAppSyncDeltaSync.this));
                Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Updating lastRunTime to [" + AWSAppSyncDeltaSync.access$600(AWSAppSyncDeltaSync.this) + "]");
            }
            AWSAppSyncDeltaSync.access$1300(AWSAppSyncDeltaSync.this).updateLastRunTime(AWSAppSyncDeltaSync.access$1200(AWSAppSyncDeltaSync.this).longValue(), AWSAppSyncDeltaSync.access$600(AWSAppSyncDeltaSync.this));
            if (AWSAppSyncDeltaSync.access$1400(AWSAppSyncDeltaSync.this) != null) {
                AWSAppSyncDeltaSync.access$1400(AWSAppSyncDeltaSync.this).onResponse(iVar);
            }
            Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Base query response propagated");
            this.val$baseQueryCountdownLatch.countDown();
        }
    }

    public class 5 implements AppSyncSubscriptionCall.Callback {
        public 5() {
        }

        public void onCompleted() {
            Log.e(AWSAppSyncDeltaSync.access$000(), "Delta Sync: onCompleted executed for subscription");
        }

        public void onFailure(b bVar) {
            Log.e(AWSAppSyncDeltaSync.access$000(), "Delta Sync: onFailure executed with exception: [" + bVar.getLocalizedMessage() + "]");
            if (AWSAppSyncDeltaSync.access$1000(AWSAppSyncDeltaSync.this) != null) {
                Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Propagating onFailure");
                AWSAppSyncDeltaSync.access$1000(AWSAppSyncDeltaSync.this).onFailure(bVar);
            }
        }

        public void onResponse(i iVar) {
            Log.d(AWSAppSyncDeltaSync.access$000(), "Got a Message. Current mode is " + AWSAppSyncDeltaSync.access$400(AWSAppSyncDeltaSync.this));
            synchronized (AWSAppSyncDeltaSync.access$800(AWSAppSyncDeltaSync.this)) {
                try {
                    if (AWSAppSyncDeltaSync.access$400(AWSAppSyncDeltaSync.this) == "QUEUING_MODE") {
                        Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Message received while in QUEUING mode. Adding to queue");
                        AWSAppSyncDeltaSync.access$900(AWSAppSyncDeltaSync.this).add(iVar);
                    } else {
                        Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Message received while in PROCESSING mode.");
                        AWSAppSyncDeltaSync.access$602(AWSAppSyncDeltaSync.this, System.currentTimeMillis());
                        AWSAppSyncDeltaSync.access$1300(AWSAppSyncDeltaSync.this).updateLastRunTime(AWSAppSyncDeltaSync.access$1200(AWSAppSyncDeltaSync.this).longValue(), AWSAppSyncDeltaSync.access$600(AWSAppSyncDeltaSync.this));
                        Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Updating lastRunTime to [" + AWSAppSyncDeltaSync.access$600(AWSAppSyncDeltaSync.this) + "]");
                        if (AWSAppSyncDeltaSync.access$1000(AWSAppSyncDeltaSync.this) != null) {
                            Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Propagating received message");
                            AWSAppSyncDeltaSync.access$1000(AWSAppSyncDeltaSync.this).onResponse(iVar);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class 6 extends c.a {
        final /* synthetic */ CountDownLatch val$deltaQueryCountdownLatch;
        final /* synthetic */ long val$deltaQueryInitiationTime;

        public 6(long j, CountDownLatch countDownLatch) {
            this.val$deltaQueryInitiationTime = j;
            this.val$deltaQueryCountdownLatch = countDownLatch;
        }

        public void onFailure(b bVar) {
            Log.e(AWSAppSyncDeltaSync.access$000(), "Delta Sync: onFailure executed for Delta Query with [" + bVar.getLocalizedMessage() + "]");
            AWSAppSyncDeltaSync.access$102(AWSAppSyncDeltaSync.this, true);
            if (AWSAppSyncDeltaSync.access$1500(AWSAppSyncDeltaSync.this) != null) {
                Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Propagating onFailure");
                AWSAppSyncDeltaSync.access$1500(AWSAppSyncDeltaSync.this).onFailure(bVar);
            }
            this.val$deltaQueryCountdownLatch.countDown();
        }

        public void onResponse(i iVar) {
            Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Received response for Delta Query.");
            AWSAppSyncDeltaSync.access$602(AWSAppSyncDeltaSync.this, this.val$deltaQueryInitiationTime);
            AWSAppSyncDeltaSync.access$1300(AWSAppSyncDeltaSync.this).updateLastRunTime(AWSAppSyncDeltaSync.access$1200(AWSAppSyncDeltaSync.this).longValue(), AWSAppSyncDeltaSync.access$600(AWSAppSyncDeltaSync.this));
            Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Updated lastRunTime to  [" + AWSAppSyncDeltaSync.access$600(AWSAppSyncDeltaSync.this) + "]");
            if (AWSAppSyncDeltaSync.access$1500(AWSAppSyncDeltaSync.this) != null) {
                Log.v(AWSAppSyncDeltaSync.access$000(), "Delta Sync: Propagating Delta query response.");
                AWSAppSyncDeltaSync.access$1500(AWSAppSyncDeltaSync.this).onResponse(iVar);
            }
            this.val$deltaQueryCountdownLatch.countDown();
        }
    }

    static {
        Boolean bool = Boolean.TRUE;
        networkUp = bool;
        networkLock = new Object();
        appInForeground = bool;
        foregroundLock = new Object();
        awsAppSyncDeltaSyncSqlHelper = null;
    }

    public AWSAppSyncDeltaSync(h hVar, AWSAppSyncClient aWSAppSyncClient, Context context) {
        this.mContext = context;
        this.baseQuery = hVar;
        this.awsAppSyncClient = aWSAppSyncClient;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ boolean access$100(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.deltaSyncOperationFailed;
    }

    public static /* synthetic */ AppSyncSubscriptionCall.Callback access$1000(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.subscriptionCallback;
    }

    public static /* synthetic */ boolean access$102(AWSAppSyncDeltaSync aWSAppSyncDeltaSync, boolean z) {
        aWSAppSyncDeltaSync.deltaSyncOperationFailed = z;
        return z;
    }

    public static /* synthetic */ void access$1100(AWSAppSyncDeltaSync aWSAppSyncDeltaSync, long j) {
        aWSAppSyncDeltaSync.scheduleFutureSync(j);
    }

    public static /* synthetic */ Long access$1200(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.id;
    }

    public static /* synthetic */ AWSAppSyncDeltaSyncDBOperations access$1300(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.dbHelper;
    }

    public static /* synthetic */ c.a access$1400(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.baseQueryCallback;
    }

    public static /* synthetic */ c.a access$1500(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.deltaQueryCallback;
    }

    public static /* synthetic */ void access$200(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        aWSAppSyncDeltaSync.scheduleRetry();
    }

    public static /* synthetic */ t access$300(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.subscription;
    }

    public static /* synthetic */ String access$400(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.mode;
    }

    public static /* synthetic */ String access$402(AWSAppSyncDeltaSync aWSAppSyncDeltaSync, String str) {
        aWSAppSyncDeltaSync.mode = str;
        return str;
    }

    public static /* synthetic */ h access$500(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.deltaQuery;
    }

    public static /* synthetic */ long access$600(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.lastRunTimeInMilliSeconds;
    }

    public static /* synthetic */ long access$602(AWSAppSyncDeltaSync aWSAppSyncDeltaSync, long j) {
        aWSAppSyncDeltaSync.lastRunTimeInMilliSeconds = j;
        return j;
    }

    public static /* synthetic */ long access$700(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.baseRefreshIntervalInSeconds;
    }

    public static /* synthetic */ Object access$800(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.processingLock;
    }

    public static /* synthetic */ ArrayDeque access$900(AWSAppSyncDeltaSync aWSAppSyncDeltaSync) {
        return aWSAppSyncDeltaSync.messageQueue;
    }

    private String getKey() {
        return "" + this.baseQuery + this.subscription + this.deltaQuery;
    }

    public static void handleAppBackground() {
        synchronized (foregroundLock) {
            try {
                if (appInForeground.booleanValue()) {
                    Log.d(TAG, "Delta Sync: Background transition detected.");
                    appInForeground = Boolean.FALSE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void handleAppForeground() {
        /*
            java.lang.Object r0 = com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync.foregroundLock
            monitor-enter(r0)
            java.lang.Boolean r1 = com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync.appInForeground     // Catch: java.lang.Throwable -> L69
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L69
            if (r1 != 0) goto L6b
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L69
            com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync.appInForeground = r1     // Catch: java.lang.Throwable -> L69
            java.lang.Object r1 = com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync.networkLock     // Catch: java.lang.Throwable -> L69
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.Boolean r2 = com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync.networkUp     // Catch: java.lang.Throwable -> L63
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L63
            if (r2 == 0) goto L65
            java.util.Map r2 = com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync.deltaSyncObjects     // Catch: java.lang.Throwable -> L63
            java.util.Set r2 = r2.entrySet()     // Catch: java.lang.Throwable -> L63
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L63
        L24:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L63
            if (r3 == 0) goto L65
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L63
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L63
            java.lang.String r4 = com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync.TAG     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r5.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = "Delta Sync: Foreground transition detected. Running DeltaSync for ds object ["
            r5.append(r6)     // Catch: java.lang.Throwable -> L63
            java.lang.Object r6 = r3.getKey()     // Catch: java.lang.Throwable -> L63
            r5.append(r6)     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = "]"
            r5.append(r6)     // Catch: java.lang.Throwable -> L63
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L63
            android.util.Log.d(r4, r5)     // Catch: java.lang.Throwable -> L63
            java.lang.Object r4 = r3.getValue()     // Catch: java.lang.Throwable -> L63
            com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync r4 = (com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync) r4     // Catch: java.lang.Throwable -> L63
            r4.cancelRetry()     // Catch: java.lang.Throwable -> L63
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> L63
            com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync r3 = (com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync) r3     // Catch: java.lang.Throwable -> L63
            r4 = 0
            r3.execute(r4)     // Catch: java.lang.Throwable -> L63
            goto L24
        L63:
            r2 = move-exception
            goto L67
        L65:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L63
            goto L6b
        L67:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L63
            throw r2     // Catch: java.lang.Throwable -> L69
        L69:
            r1 = move-exception
            goto L6d
        L6b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            return
        L6d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L69
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.appsync.AWSAppSyncDeltaSync.handleAppForeground():void");
    }

    public static void handleNetworkDownEvent() {
        synchronized (networkLock) {
            try {
                if (networkUp.booleanValue()) {
                    Log.d(TAG, "Delta Sync: Network Down detected.");
                    networkUp = Boolean.FALSE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void handleNetworkUpEvent() {
        synchronized (networkLock) {
            try {
                if (!networkUp.booleanValue()) {
                    networkUp = Boolean.TRUE;
                    for (Map.Entry entry : deltaSyncObjects.entrySet()) {
                        Log.d(TAG, "Delta Sync: Network Up detected. Running DeltaSync for ds object [" + entry.getKey() + "]");
                        ((AWSAppSyncDeltaSync) entry.getValue()).cancelRetry();
                        ((AWSAppSyncDeltaSync) entry.getValue()).execute(false);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void initializeIfRequired() {
        synchronized (this.initializationLock) {
            try {
                String str = TAG;
                Log.d(str, "In initialize method");
                if (awsAppSyncDeltaSyncSqlHelper == null) {
                    Log.d(str, "Initializing the database");
                    awsAppSyncDeltaSyncSqlHelper = new AWSAppSyncDeltaSyncSqlHelper(this.mContext, this.awsAppSyncClient.deltaSyncSqlStoreName);
                }
                if (this.dbHelper == null) {
                    this.dbHelper = new AWSAppSyncDeltaSyncDBOperations(awsAppSyncDeltaSyncSqlHelper);
                }
                if (!this.recordCreatedOrFound) {
                    AWSAppSyncDeltaSyncDBOperations.DeltaSyncRecord recordByKey = this.dbHelper.getRecordByKey(getKey());
                    if (recordByKey == null) {
                        this.id = Long.valueOf(this.dbHelper.createRecord(getKey(), this.lastRunTimeInMilliSeconds));
                    } else {
                        this.id = Long.valueOf(recordByKey.id);
                        this.lastRunTimeInMilliSeconds = recordByKey.lastRunTimeInMilliSeconds;
                    }
                    deltaSyncObjects.put(this.id, this);
                    this.recordCreatedOrFound = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void scheduleFutureSync(long j) {
        if (this.baseRefreshIntervalInSeconds <= 0) {
            Log.i(TAG, "Delta Sync: baseRefreshIntervalInSeconds value is [" + this.baseRefreshIntervalInSeconds + "]. Will not schedule future Deltasync");
            return;
        }
        ScheduledFuture scheduledFuture = this.nextScheduledRun;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        long currentTimeMillis = ((j - System.currentTimeMillis()) / 1000) + this.baseRefreshIntervalInSeconds;
        Log.v(TAG, "Delta Sync: Scheduling next run of the DeltaSync [" + currentTimeMillis + "] seconds from now");
        this.nextScheduledRun = this.scheduledExecutorService.schedule(new 2(new WeakReference(this)), currentTimeMillis, TimeUnit.SECONDS);
    }

    private void scheduleRetry() {
        long calculateBackoff = RetryInterceptor.calculateBackoff(this.retryAttempt);
        Log.v(TAG, "Delta Sync: Scheduling retry of the DeltaSync [" + calculateBackoff + "] milliseconds from now");
        this.nextRetryAttempt = this.scheduledExecutorService.schedule(new 3(new WeakReference(this)), calculateBackoff, TimeUnit.MILLISECONDS);
        this.retryAttempt = this.retryAttempt + 1;
    }

    public h adjust(h hVar) {
        String str;
        String str2;
        long j = this.lastRunTimeInMilliSeconds / 1000;
        String str3 = TAG;
        Log.v(str3, "Delta Sync: Attempting to set lastSync in DeltaQuery to [" + j + "]");
        try {
            f.b variables = hVar.variables();
            Field declaredField = variables.getClass().getDeclaredField("lastSync");
            declaredField.setAccessible(true);
            declaredField.set(variables, Long.valueOf(j));
            Log.v(str3, "Delta Sync: set lastSync in DeltaQuery to [" + j + "]");
        } catch (NoSuchFieldException unused) {
            str = TAG;
            str2 = "Delta Sync: field 'lastSync' not present in query. Skipping adjustment";
            Log.v(str, str2);
            return hVar;
        } catch (IllegalAccessException unused2) {
            str = TAG;
            str2 = "Delta Sync: Unable to override value in for 'lastSync'. Skipping adjustment";
            Log.v(str, str2);
            return hVar;
        }
        return hVar;
    }

    public void cancel() {
        Log.i(TAG, "Delta Sync: Cancelling Delta Sync operation [" + this.id + "]");
        this.cancelled = true;
        AppSyncSubscriptionCall appSyncSubscriptionCall = this.deltaSyncSubscriptionWatcher;
        if (appSyncSubscriptionCall != null) {
            appSyncSubscriptionCall.cancel();
        }
        ScheduledFuture scheduledFuture = this.nextRetryAttempt;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.nextRetryAttempt = null;
        }
        ScheduledFuture scheduledFuture2 = this.nextScheduledRun;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
            this.nextScheduledRun = null;
        }
        deltaSyncObjects.remove(this.id);
    }

    public void cancelRetry() {
        ScheduledFuture scheduledFuture = this.nextRetryAttempt;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.nextRetryAttempt = null;
        }
        this.retryAttempt = 0;
    }

    public Long execute(boolean z) {
        initializeIfRequired();
        if (this.cancelled) {
            Log.v(TAG, "Delta Sync: Cancelled. Quitting Delta Sync process for id [" + this.id + "]");
        } else {
            this.deltaSyncOperationFailed = false;
            new Thread(new 1(z)).start();
        }
        return this.id;
    }

    public void runBaseQuery(a aVar) {
        String str;
        String str2;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        4 r8 = new 4(aVar, System.currentTimeMillis(), countDownLatch);
        if (AppSyncResponseFetchers.CACHE_ONLY.equals(aVar)) {
            str = TAG;
            str2 = "Delta Sync: executing base query from cache";
        } else {
            str = TAG;
            str2 = "Delta Sync: executing base query from network";
        }
        Log.v(str, str2);
        this.awsAppSyncClient.query(this.baseQuery).responseFetcher(aVar).enqueue(r8);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Log.e(TAG, "Delta Sync: Base Query wait failed with [" + e + "]");
            this.deltaSyncOperationFailed = true;
        }
    }

    public void runDeltaQuery() {
        Log.v(TAG, "Delta Sync: executing Delta query");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.awsAppSyncClient.query(adjust(this.deltaQuery)).responseFetcher(AppSyncResponseFetchers.NETWORK_ONLY).enqueue(new 6(System.currentTimeMillis(), countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Log.e(TAG, "Delta Sync: Delta Query wait failed with [" + e + "]");
            this.deltaSyncOperationFailed = true;
        }
    }

    public void setBaseQuery(h hVar) {
        this.baseQuery = hVar;
    }

    public void setBaseQueryCallback(c.a aVar) {
        this.baseQueryCallback = aVar;
    }

    public void setBaseRefreshIntervalInSeconds(long j) {
        this.baseRefreshIntervalInSeconds = j;
    }

    public void setDeltaQuery(h hVar) {
        this.deltaQuery = hVar;
    }

    public void setDeltaQueryCallback(c.a aVar) {
        this.deltaQueryCallback = aVar;
    }

    public void setSubscription(t tVar) {
        this.subscription = tVar;
    }

    public void setSubscriptionCallback(AppSyncSubscriptionCall.Callback callback) {
        this.subscriptionCallback = callback;
    }

    public void subscribe() {
        String str = TAG;
        Log.v(str, "Delta Sync: Subscription was passed in. Setting it up");
        Log.v(str, "Delta Sync: Setting mode to QUEUING");
        if (this.scb == null) {
            this.scb = new 5();
        }
        Log.d(str, "Delta Sync: Setting up Delta Sync Subscription Watcher");
        AppSyncSubscriptionCall subscribe = this.awsAppSyncClient.subscribe(this.subscription);
        this.deltaSyncSubscriptionWatcher = subscribe;
        subscribe.execute(this.scb);
    }

    public static void cancel(Long l) {
        AWSAppSyncDeltaSync aWSAppSyncDeltaSync = (AWSAppSyncDeltaSync) deltaSyncObjects.get(l);
        if (aWSAppSyncDeltaSync != null) {
            aWSAppSyncDeltaSync.cancel();
        }
    }
}
