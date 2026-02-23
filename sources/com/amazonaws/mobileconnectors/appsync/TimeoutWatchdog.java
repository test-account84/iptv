package com.amazonaws.mobileconnectors.appsync;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import okhttp3.WebSocket;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class TimeoutWatchdog {
    private static final int NORMAL_CLOSURE_STATUS = 1000;
    private static final String TAG = "TimeoutWatchdog";
    private final Handler handler = new Handler(Looper.getMainLooper());
    private long connectionTimeoutMs = -1;
    private Runnable cleanupRunnable = null;

    public class 1 implements Runnable {
        final /* synthetic */ WebSocket val$webSocket;

        public 1(WebSocket webSocket) {
            this.val$webSocket = webSocket;
        }

        public void run() {
            Log.d(TimeoutWatchdog.access$000(), "WebSocket closed gracefully due to timeout.");
            this.val$webSocket.close(1000, "WebSocket closed due to timeout.");
        }
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public synchronized void reset() {
        Runnable runnable = this.cleanupRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.handler.postDelayed(this.cleanupRunnable, this.connectionTimeoutMs);
        }
    }

    public synchronized void start(WebSocket webSocket, long j) {
        if (webSocket == null) {
            throw new NullPointerException("Passed null webSocket to watchdog.");
        }
        if (j <= 0) {
            throw new IllegalArgumentException("connectionTimeoutMs must be > 0.");
        }
        stop();
        this.connectionTimeoutMs = j;
        1 r0 = new 1(webSocket);
        this.cleanupRunnable = r0;
        this.handler.postDelayed(r0, j);
    }

    public synchronized void stop() {
        try {
            Runnable runnable = this.cleanupRunnable;
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
            this.cleanupRunnable = null;
            this.connectionTimeoutMs = -1L;
        } catch (Throwable th) {
            throw th;
        }
    }
}
