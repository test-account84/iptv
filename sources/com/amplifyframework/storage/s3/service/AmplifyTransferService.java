package com.amplifyframework.storage.s3.service;

import D.l;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdaterAccessor;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.storage.s3.R;
import k8.q;
import kotlin.jvm.internal.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AmplifyTransferService extends Service {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NOTIFICATION_ID = 9382;
    private static final long SHUTDOWN_CHECK_INTERVAL_MILLIS = 8000;
    private static AmplifyTransferService boundService;
    private static ServiceConnection boundServiceConnection;
    private static Notification notification;
    private final LocalBinder binder;
    private boolean isReceiverRegistered;
    private final Logger log;
    private TransferNetworkLossHandler transferNetworkLossHandler;
    private Handler unbindCheckHandler;
    private Runnable unbindCheckRunnable;

    public static final class Companion {
        private Companion() {
        }

        private final void createChannel(Context context) {
            Object systemService = context.getSystemService("notification");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
            }
            c.a();
            a.a((NotificationManager) systemService, b.a(context.getString(R.string.amplify_storage_notification_channel_id), context.getString(R.string.amplify_storage_notification_channel_name), 2));
        }

        private final Notification createDefaultNotification(Context context) {
            if (Build.VERSION.SDK_INT >= 26) {
                createChannel(context);
            }
            return new l.e(context, context.getString(R.string.amplify_storage_notification_channel_id)).D(R.drawable.amplify_storage_transfer_notification_icon).n(context.getString(R.string.amplify_storage_notification_title)).A(-1).c();
        }

        public final void bind(@NotNull Context context) {
            kotlin.jvm.internal.l.e(context, "context");
            if (AmplifyTransferService.access$getBoundServiceConnection$cp() == null) {
                AmplifyTransferService.access$setBoundServiceConnection$cp(new AmplifyTransferService$Companion$bind$1(context));
            }
            ServiceConnection access$getBoundServiceConnection$cp = AmplifyTransferService.access$getBoundServiceConnection$cp();
            if (access$getBoundServiceConnection$cp != null) {
                context.bindService(new Intent(context, AmplifyTransferService.class), access$getBoundServiceConnection$cp, 1);
            }
            AmplifyTransferService access$getBoundService$cp = AmplifyTransferService.access$getBoundService$cp();
            if (access$getBoundService$cp != null) {
                AmplifyTransferService.access$startUnbindCheck(access$getBoundService$cp);
            }
        }

        public final boolean isNotificationShowing() {
            return AmplifyTransferService.access$getNotification$cp() != null;
        }

        public final void startForeground(@NotNull Context context) {
            kotlin.jvm.internal.l.e(context, "context");
            if (isNotificationShowing()) {
                return;
            }
            Notification createDefaultNotification = createDefaultNotification(context);
            AmplifyTransferService access$getBoundService$cp = AmplifyTransferService.access$getBoundService$cp();
            if (access$getBoundService$cp != null) {
                access$getBoundService$cp.startForeground(9382, createDefaultNotification);
            }
            AmplifyTransferService.access$setNotification$cp(createDefaultNotification);
        }

        public final void stopForegroundAndUnbind(@NotNull Context context) {
            kotlin.jvm.internal.l.e(context, "context");
            AmplifyTransferService access$getBoundService$cp = AmplifyTransferService.access$getBoundService$cp();
            if (access$getBoundService$cp != null) {
                access$getBoundService$cp.stopForeground(true);
            }
            ServiceConnection access$getBoundServiceConnection$cp = AmplifyTransferService.access$getBoundServiceConnection$cp();
            if (access$getBoundServiceConnection$cp != null) {
                context.unbindService(access$getBoundServiceConnection$cp);
            }
            AmplifyTransferService.access$setBoundServiceConnection$cp(null);
            AmplifyTransferService.access$setNotification$cp(null);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final class LocalBinder extends Binder {
        public LocalBinder() {
        }

        @NotNull
        public final AmplifyTransferService getService() {
            return AmplifyTransferService.this;
        }
    }

    public static final class 1 implements Runnable {
        public 1() {
        }

        public final void run() {
            Handler access$getUnbindCheckHandler$p;
            AmplifyTransferService.access$getLog$p(AmplifyTransferService.this).verbose("AmplifyTransferService unbind check running");
            TransferStatusUpdaterAccessor transferStatusUpdaterAccessor = TransferStatusUpdaterAccessor.INSTANCE;
            Context applicationContext = AmplifyTransferService.this.getApplicationContext();
            kotlin.jvm.internal.l.d(applicationContext, "applicationContext");
            if (transferStatusUpdaterAccessor.hasActiveTransfer(applicationContext)) {
                AmplifyTransferService.access$getLog$p(AmplifyTransferService.this).verbose("Transfers in progress, rescheduling unbind check");
                Runnable access$getUnbindCheckRunnable$p = AmplifyTransferService.access$getUnbindCheckRunnable$p(AmplifyTransferService.this);
                if (access$getUnbindCheckRunnable$p == null || (access$getUnbindCheckHandler$p = AmplifyTransferService.access$getUnbindCheckHandler$p(AmplifyTransferService.this)) == null) {
                    return;
                }
                access$getUnbindCheckHandler$p.postDelayed(access$getUnbindCheckRunnable$p, 8000L);
                return;
            }
            try {
                AmplifyTransferService.access$getLog$p(AmplifyTransferService.this).verbose("Removing AmplifyTransferService from foreground and unbinding");
                Companion companion = AmplifyTransferService.Companion;
                Context applicationContext2 = AmplifyTransferService.this.getApplicationContext();
                kotlin.jvm.internal.l.d(applicationContext2, "applicationContext");
                companion.stopForegroundAndUnbind(applicationContext2);
            } catch (Exception e) {
                AmplifyTransferService.access$getLog$p(AmplifyTransferService.this).error("Error in moving the service out of the foreground state: " + e);
            }
        }
    }

    public AmplifyTransferService() {
        Logger forNamespace = Amplify.Logging.forNamespace("amplify:aws-s3");
        kotlin.jvm.internal.l.d(forNamespace, "Amplify.Logging.forNamespace(\"amplify:aws-s3\")");
        this.log = forNamespace;
        this.binder = new LocalBinder();
    }

    public static final /* synthetic */ AmplifyTransferService access$getBoundService$cp() {
        return boundService;
    }

    public static final /* synthetic */ ServiceConnection access$getBoundServiceConnection$cp() {
        return boundServiceConnection;
    }

    public static final /* synthetic */ Logger access$getLog$p(AmplifyTransferService amplifyTransferService) {
        return amplifyTransferService.log;
    }

    public static final /* synthetic */ Notification access$getNotification$cp() {
        return notification;
    }

    public static final /* synthetic */ Handler access$getUnbindCheckHandler$p(AmplifyTransferService amplifyTransferService) {
        return amplifyTransferService.unbindCheckHandler;
    }

    public static final /* synthetic */ Runnable access$getUnbindCheckRunnable$p(AmplifyTransferService amplifyTransferService) {
        return amplifyTransferService.unbindCheckRunnable;
    }

    public static final /* synthetic */ void access$setBoundService$cp(AmplifyTransferService amplifyTransferService) {
        boundService = amplifyTransferService;
    }

    public static final /* synthetic */ void access$setBoundServiceConnection$cp(ServiceConnection serviceConnection) {
        boundServiceConnection = serviceConnection;
    }

    public static final /* synthetic */ void access$setNotification$cp(Notification notification2) {
        notification = notification2;
    }

    public static final /* synthetic */ void access$setUnbindCheckHandler$p(AmplifyTransferService amplifyTransferService, Handler handler) {
        amplifyTransferService.unbindCheckHandler = handler;
    }

    public static final /* synthetic */ void access$setUnbindCheckRunnable$p(AmplifyTransferService amplifyTransferService, Runnable runnable) {
        amplifyTransferService.unbindCheckRunnable = runnable;
    }

    public static final /* synthetic */ void access$startUnbindCheck(AmplifyTransferService amplifyTransferService) {
        amplifyTransferService.startUnbindCheck();
    }

    private final void startUnbindCheck() {
        Handler handler = this.unbindCheckHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.unbindCheckRunnable = new 1();
        Handler handler2 = new Handler(Looper.getMainLooper());
        Runnable runnable = this.unbindCheckRunnable;
        if (runnable != null) {
            handler2.postDelayed(runnable, 8000L);
        }
        q qVar = q.a;
        this.unbindCheckHandler = handler2;
    }

    public static final void stopForegroundAndUnbind(@NotNull Context context) {
        Companion.stopForegroundAndUnbind(context);
    }

    private final void stopUnbindCheck() {
        this.log.info("Stopping AmplifyTransferService unbind check");
        Handler handler = this.unbindCheckHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.unbindCheckRunnable = null;
        this.unbindCheckHandler = null;
    }

    @NotNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.binder;
    }

    public void onCreate() {
        Logger logger;
        String str;
        super.onCreate();
        this.transferNetworkLossHandler = TransferNetworkLossHandler.getInstance(getApplicationContext());
        synchronized (this) {
            if (this.isReceiverRegistered) {
                q qVar = q.a;
            } else {
                try {
                    this.log.info("Registering the network receiver");
                    registerReceiver(this.transferNetworkLossHandler, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.isReceiverRegistered = true;
                } catch (IllegalArgumentException unused) {
                    logger = this.log;
                    str = "Ignoring the exception trying to register the receiver for connectivity change.";
                    logger.warn(str);
                    q qVar2 = q.a;
                } catch (IllegalStateException unused2) {
                    logger = this.log;
                    str = "Ignoring the leak in registering the receiver.";
                    logger.warn(str);
                    q qVar22 = q.a;
                }
                q qVar222 = q.a;
            }
        }
    }

    public void onDestroy() {
        try {
            stopUnbindCheck();
            this.log.info("De-registering the network receiver.");
            synchronized (this) {
                try {
                    if (this.isReceiverRegistered) {
                        unregisterReceiver(this.transferNetworkLossHandler);
                        this.isReceiverRegistered = false;
                        this.transferNetworkLossHandler = null;
                    }
                    q qVar = q.a;
                } finally {
                }
            }
        } catch (IllegalArgumentException unused) {
            this.log.warn("Exception trying to de-register the network receiver");
        }
        super.onDestroy();
    }

    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        return 1;
    }
}
