package com.amazonaws.mobile.client.internal;

import android.util.Log;
import com.amazonaws.mobile.client.Callback;
import java.util.concurrent.CountDownLatch;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class InternalCallback implements Callback {
    private static final String TAG = "InternalCallback";
    private Exception e;
    private CountDownLatch lock;
    private Mode mode;
    private Object result;
    private Runnable runnable;
    private Callback userCallback;

    public class 1 implements Runnable {
        final /* synthetic */ Runnable val$runnable;

        public 1(Runnable runnable) {
            this.val$runnable = runnable;
        }

        public void run() {
            try {
                this.val$runnable.run();
            } catch (Exception e) {
                InternalCallback.access$000(InternalCallback.this, null, e);
            }
        }
    }

    public static /* synthetic */ class 2 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode = iArr;
            try {
                iArr[Mode.Callback.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode[Mode.Async.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode[Mode.Sync.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode[Mode.Done.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum Mode {
        Callback,
        Async,
        Sync,
        Done
    }

    public InternalCallback() {
        this(null);
    }

    public static /* synthetic */ void access$000(InternalCallback internalCallback, Object obj, Exception exc) {
        internalCallback.call(obj, exc);
    }

    private void call(Object obj, Exception exc) {
        int i = 2.$SwitchMap$com$amazonaws$mobile$client$internal$InternalCallback$Mode[this.mode.ordinal()];
        if (i == 1 || i == 2) {
            if (exc == null) {
                this.userCallback.onResult(obj);
            } else {
                this.userCallback.onError(exc);
            }
        } else if (i == 3) {
            this.result = obj;
            this.e = exc;
            this.lock.countDown();
        } else if (i == 4) {
            Log.w(TAG, "Library attempted to call user callback twice, expected only once");
        }
        this.mode = Mode.Done;
        this.userCallback = null;
    }

    public void async(Runnable runnable) {
        if (this.mode == Mode.Done) {
            Log.e(TAG, "Duplicate call to execute code.", new RuntimeException("Internal error, duplicate call"));
        }
        this.mode = Mode.Async;
        this.lock = null;
        new Thread(new 1(runnable)).start();
    }

    public Object await(Runnable runnable) throws Exception {
        if (this.mode == Mode.Done) {
            Log.e(TAG, "Duplicate call to execute code.", new RuntimeException("Internal error, duplicate call"));
        }
        this.mode = Mode.Sync;
        try {
            runnable.run();
            this.lock.await();
        } catch (Exception e) {
            this.e = e;
        }
        Exception exc = this.e;
        Object obj = this.result;
        this.e = null;
        this.result = null;
        if (exc == null) {
            return obj;
        }
        throw exc;
    }

    public void onError(Exception exc) {
        call(null, exc);
    }

    public void onResult(Object obj) {
        call(obj, null);
    }

    public InternalCallback(Callback callback) {
        this.userCallback = callback;
        this.mode = Mode.Callback;
        this.lock = new CountDownLatch(1);
    }
}
