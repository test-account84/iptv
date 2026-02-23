package com.amazonaws.event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ProgressListenerCallbackExecutor {
    static ExecutorService executor = createNewExecutorService();
    private final ProgressListener listener;

    public static class 1 implements Runnable {
        final /* synthetic */ ProgressListener val$listener;
        final /* synthetic */ ProgressEvent val$progressEvent;

        public 1(ProgressListener progressListener, ProgressEvent progressEvent) {
            this.val$listener = progressListener;
            this.val$progressEvent = progressEvent;
        }

        public void run() {
            this.val$listener.progressChanged(this.val$progressEvent);
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ ProgressEvent val$progressEvent;

        public 2(ProgressEvent progressEvent) {
            this.val$progressEvent = progressEvent;
        }

        public void run() {
            ProgressListenerCallbackExecutor.access$000(ProgressListenerCallbackExecutor.this).progressChanged(this.val$progressEvent);
        }
    }

    public static class 3 implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("android-sdk-progress-listener-callback-thread");
            thread.setDaemon(true);
            return thread;
        }
    }

    public ProgressListenerCallbackExecutor() {
        this.listener = null;
    }

    public static /* synthetic */ ProgressListener access$000(ProgressListenerCallbackExecutor progressListenerCallbackExecutor) {
        return progressListenerCallbackExecutor.listener;
    }

    public static ExecutorService createNewExecutorService() {
        return Executors.newSingleThreadExecutor(new 3());
    }

    public static ExecutorService getExecutorService() {
        return executor;
    }

    public static Future progressChanged(ProgressListener progressListener, ProgressEvent progressEvent) {
        if (progressListener == null) {
            return null;
        }
        return executor.submit(new 1(progressListener, progressEvent));
    }

    public static ProgressListenerCallbackExecutor wrapListener(ProgressListener progressListener) {
        if (progressListener == null) {
            return null;
        }
        return new ProgressListenerCallbackExecutor(progressListener);
    }

    public ProgressListener getListener() {
        return this.listener;
    }

    public ProgressListenerCallbackExecutor(ProgressListener progressListener) {
        this.listener = progressListener;
    }

    public void progressChanged(ProgressEvent progressEvent) {
        if (this.listener == null) {
            return;
        }
        executor.submit(new 2(progressEvent));
    }
}
