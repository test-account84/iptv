package com.amazonaws.mobileconnectors.appsync;

import B1.b;
import B1.c;
import B1.d;
import android.os.Handler;
import com.amazonaws.mobileconnectors.appsync.AppSyncPrefetch;
import x1.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AppSyncPrefetchCallback extends AppSyncPrefetch.Callback {
    private final AppSyncPrefetch.Callback delegate;
    private final Handler handler;

    public class 1 implements Runnable {
        public 1() {
        }

        public void run() {
            AppSyncPrefetchCallback.access$000(AppSyncPrefetchCallback.this).onSuccess();
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ b val$e;

        public 2(b bVar) {
            this.val$e = bVar;
        }

        public void run() {
            AppSyncPrefetchCallback.access$000(AppSyncPrefetchCallback.this).onFailure(this.val$e);
        }
    }

    public class 3 implements Runnable {
        final /* synthetic */ c val$e;

        public 3(c cVar) {
            this.val$e = cVar;
        }

        public void run() {
            AppSyncPrefetchCallback.access$000(AppSyncPrefetchCallback.this).onHttpError(this.val$e);
        }
    }

    public class 4 implements Runnable {
        final /* synthetic */ d val$e;

        public 4(d dVar) {
            this.val$e = dVar;
        }

        public void run() {
            AppSyncPrefetchCallback.access$000(AppSyncPrefetchCallback.this).onNetworkError(this.val$e);
        }
    }

    public AppSyncPrefetchCallback(AppSyncPrefetch.Callback callback, Handler handler) {
        this.delegate = (AppSyncPrefetch.Callback) g.c(callback, "callback == null");
        this.handler = (Handler) g.c(handler, "handler == null");
    }

    public static /* synthetic */ AppSyncPrefetch.Callback access$000(AppSyncPrefetchCallback appSyncPrefetchCallback) {
        return appSyncPrefetchCallback.delegate;
    }

    public static AppSyncPrefetchCallback wrap(AppSyncPrefetch.Callback callback, Handler handler) {
        return new AppSyncPrefetchCallback(callback, handler);
    }

    public void onFailure(b bVar) {
        this.handler.post(new 2(bVar));
    }

    public void onHttpError(c cVar) {
        this.handler.post(new 3(cVar));
    }

    public void onNetworkError(d dVar) {
        this.handler.post(new 4(dVar));
    }

    public void onSuccess() {
        this.handler.post(new 1());
    }
}
