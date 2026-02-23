package com.amazonaws.internal;

import com.amazonaws.async.Callback;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ReturningRunnable {
    private final String operationDescription;

    public class 1 implements Runnable {
        final /* synthetic */ Callback val$callback;

        public 1(Callback callback) {
            this.val$callback = callback;
        }

        public void run() {
            try {
                this.val$callback.onResult(ReturningRunnable.this.run());
            } catch (Exception e) {
                if (ReturningRunnable.access$000(ReturningRunnable.this) == null) {
                    this.val$callback.onError(e);
                } else {
                    this.val$callback.onError(new Exception(ReturningRunnable.access$000(ReturningRunnable.this), e));
                }
            }
        }
    }

    public ReturningRunnable() {
        this.operationDescription = null;
    }

    public static /* synthetic */ String access$000(ReturningRunnable returningRunnable) {
        return returningRunnable.operationDescription;
    }

    public void async(Callback callback) {
        new Thread(new 1(callback)).start();
    }

    public Object await() throws Exception {
        return run();
    }

    public abstract Object run() throws Exception;

    public ReturningRunnable(String str) {
        this.operationDescription = str;
    }
}
