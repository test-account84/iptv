package com.amazonaws.mobileconnectors.appsync;

import B1.b;
import B1.d;
import B1.e;
import android.os.Handler;
import android.os.Looper;
import u1.c;
import v1.i;
import x1.g;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class AppSyncCallback extends c.a {
    private final c.a delegate;
    private final Handler handler;

    public class 1 implements Runnable {
        final /* synthetic */ i val$response;

        public 1(i iVar) {
            this.val$response = iVar;
        }

        public void run() {
            AppSyncCallback.access$000(AppSyncCallback.this).onResponse(this.val$response);
        }
    }

    public class 2 implements Runnable {
        final /* synthetic */ c.b val$event;

        public 2(c.b bVar) {
            this.val$event = bVar;
        }

        public void run() {
            AppSyncCallback.access$000(AppSyncCallback.this).onStatusEvent(this.val$event);
        }
    }

    public class 3 implements Runnable {
        final /* synthetic */ b val$e;

        public 3(b bVar) {
            this.val$e = bVar;
        }

        public void run() {
            AppSyncCallback.access$000(AppSyncCallback.this).onFailure(this.val$e);
        }
    }

    public class 4 implements Runnable {
        final /* synthetic */ B1.c val$e;

        public 4(B1.c cVar) {
            this.val$e = cVar;
        }

        public void run() {
            AppSyncCallback.access$000(AppSyncCallback.this).onHttpError(this.val$e);
        }
    }

    public class 5 implements Runnable {
        final /* synthetic */ d val$e;

        public 5(d dVar) {
            this.val$e = dVar;
        }

        public void run() {
            AppSyncCallback.access$000(AppSyncCallback.this).onNetworkError(this.val$e);
        }
    }

    public class 6 implements Runnable {
        final /* synthetic */ e val$e;

        public 6(e eVar) {
            this.val$e = eVar;
        }

        public void run() {
            AppSyncCallback.access$000(AppSyncCallback.this).onParseError(this.val$e);
        }
    }

    public AppSyncCallback(c.a aVar, Handler handler) {
        this.delegate = (c.a) g.c(aVar, "callback == null");
        this.handler = (Handler) g.c(handler, "handler == null");
    }

    public static /* synthetic */ c.a access$000(AppSyncCallback appSyncCallback) {
        return appSyncCallback.delegate;
    }

    public static AppSyncCallback wrap(c.a aVar, Handler handler) {
        return new AppSyncCallback(aVar, handler);
    }

    public void onFailure(b bVar) {
        this.handler.post(new 3(bVar));
    }

    public void onHttpError(B1.c cVar) {
        if (Looper.getMainLooper() == this.handler.getLooper()) {
            this.delegate.onHttpError(cVar);
        } else {
            this.handler.post(new 4(cVar));
        }
    }

    public void onNetworkError(d dVar) {
        this.handler.post(new 5(dVar));
    }

    public void onParseError(e eVar) {
        this.handler.post(new 6(eVar));
    }

    public void onResponse(i iVar) {
        this.handler.post(new 1(iVar));
    }

    public void onStatusEvent(c.b bVar) {
        this.handler.post(new 2(bVar));
    }
}
