package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class TransferService extends Service {
    private static final int ANDROID_OREO = 26;
    public static final String INTENT_KEY_NOTIFICATION = "notification";
    public static final String INTENT_KEY_NOTIFICATION_ID = "ongoing-notification-id";
    public static final String INTENT_KEY_REMOVE_NOTIFICATION = "remove-notification";
    private static final Log LOGGER = LogFactory.getLog(TransferService.class);
    static TransferNetworkLossHandler transferNetworkLossHandler;
    boolean isReceiverNotRegistered = true;
    private int ongoingNotificationId = 3462;
    private boolean removeNotification = true;

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) == 0) {
            return;
        }
        printWriter.printf("network status: %s\n", new Object[]{Boolean.valueOf(transferNetworkLossHandler.isNetworkConnected())});
        Map transfers = TransferStatusUpdater.getInstance(this).getTransfers();
        printWriter.printf("# of active transfers: %d\n", new Object[]{Integer.valueOf(transfers.size())});
        for (TransferRecord transferRecord : transfers.values()) {
            printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", new Object[]{transferRecord.bucketName, transferRecord.key, transferRecord.state, Long.valueOf(transferRecord.bytesTotal), Long.valueOf(transferRecord.bytesCurrent)});
        }
        printWriter.flush();
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    public void onCreate() {
        Log log;
        String str;
        super.onCreate();
        Log log2 = LOGGER;
        log2.info("Starting Transfer Service to listen for network connectivity changes.");
        transferNetworkLossHandler = TransferNetworkLossHandler.getInstance(getApplicationContext());
        synchronized (this) {
            if (this.isReceiverNotRegistered) {
                try {
                    log2.info("Registering the network receiver");
                    registerReceiver(transferNetworkLossHandler, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.isReceiverNotRegistered = false;
                } catch (IllegalStateException unused) {
                    log = LOGGER;
                    str = "Ignoring the leak in registering the receiver.";
                    log.warn(str);
                } catch (IllegalArgumentException unused2) {
                    log = LOGGER;
                    str = "Ignoring the exception trying to register the receiver for connectivity change.";
                    log.warn(str);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|2|(6:4|d|23|24|25|26)|16|17|36|(2:(0)|(1:32))) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER.warn("Exception trying to de-register the network receiver");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDestroy() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L18
            r1 = 26
            if (r0 < r1) goto L2f
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER     // Catch: java.lang.Exception -> L18
            java.lang.String r1 = "Moving the service out of the Foreground state."
            r0.info(r1)     // Catch: java.lang.Exception -> L18
            monitor-enter(r4)     // Catch: java.lang.Exception -> L18
            boolean r0 = r4.removeNotification     // Catch: java.lang.Throwable -> L15
            r4.stopForeground(r0)     // Catch: java.lang.Throwable -> L15
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            goto L2f
        L15:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L15
            throw r0     // Catch: java.lang.Exception -> L18
        L18:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error in moving the service out of the foreground state: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.error(r0)
        L2f:
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER     // Catch: java.lang.IllegalArgumentException -> L4d
            java.lang.String r1 = "De-registering the network receiver."
            r0.info(r1)     // Catch: java.lang.IllegalArgumentException -> L4d
            monitor-enter(r4)     // Catch: java.lang.IllegalArgumentException -> L4d
            boolean r0 = r4.isReceiverNotRegistered     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L49
            com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.transferNetworkLossHandler     // Catch: java.lang.Throwable -> L47
            r4.unregisterReceiver(r0)     // Catch: java.lang.Throwable -> L47
            r0 = 1
            r4.isReceiverNotRegistered = r0     // Catch: java.lang.Throwable -> L47
            r0 = 0
            com.amazonaws.mobileconnectors.s3.transferutility.TransferService.transferNetworkLossHandler = r0     // Catch: java.lang.Throwable -> L47
            goto L49
        L47:
            r0 = move-exception
            goto L4b
        L49:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L47
            goto L54
        L4b:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L47
            throw r0     // Catch: java.lang.IllegalArgumentException -> L4d
        L4d:
            com.amazonaws.logging.Log r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferService.LOGGER
            java.lang.String r1 = "Exception trying to de-register the network receiver"
            r0.warn(r1)
        L54:
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferService.onDestroy():void");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log log;
        String str;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                synchronized (this) {
                    try {
                        Notification parcelableExtra = intent.getParcelableExtra("notification");
                        if (parcelableExtra != null) {
                            this.ongoingNotificationId = intent.getIntExtra("ongoing-notification-id", this.ongoingNotificationId);
                            this.removeNotification = intent.getBooleanExtra("remove-notification", this.removeNotification);
                            LOGGER.info("Putting the service in Foreground state.");
                            startForeground(this.ongoingNotificationId, parcelableExtra);
                        } else {
                            LOGGER.error("No notification is passed in the intent. Unable to transition to foreground.");
                        }
                    } finally {
                    }
                }
            } catch (Exception e) {
                LOGGER.error("Error in moving the service to foreground state: " + e);
            }
            return 1;
        }
        synchronized (this) {
            if (!this.isReceiverNotRegistered) {
                return 1;
            }
            try {
                try {
                    LOGGER.info("Registering the network receiver");
                    registerReceiver(transferNetworkLossHandler, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.isReceiverNotRegistered = false;
                } catch (IllegalStateException unused) {
                    log = LOGGER;
                    str = "Ignoring the leak in registering the receiver.";
                    log.warn(str);
                    return 1;
                }
            } catch (IllegalArgumentException unused2) {
                log = LOGGER;
                str = "Ignoring the exception trying to register the receiver for connectivity change.";
                log.warn(str);
                return 1;
            }
            return 1;
        }
    }
}
