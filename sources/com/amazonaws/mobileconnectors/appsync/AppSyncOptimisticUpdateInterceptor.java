package com.amazonaws.mobileconnectors.appsync;

import D1.a;
import D1.b;
import android.util.Log;
import java.util.concurrent.Executor;
import v1.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class AppSyncOptimisticUpdateInterceptor implements a {
    private static final String TAG = "AppSyncOptimisticUpdateInterceptor";
    private z1.a store;

    public class 1 implements Runnable {
        final /* synthetic */ f.a val$data;
        final /* synthetic */ a.c val$request;

        public 1(a.c cVar, f.a aVar) {
            this.val$request = cVar;
            this.val$data = aVar;
        }

        public void run() {
            try {
                Log.v(AppSyncOptimisticUpdateInterceptor.access$000(), "Thread:[" + Thread.currentThread().getId() + "]: Updating store with the optimistic update for [" + this.val$request.b + "]");
                AppSyncOptimisticUpdateInterceptor.access$100(AppSyncOptimisticUpdateInterceptor.this).i(this.val$request.b, this.val$data).c();
            } catch (Exception unused) {
                Log.e(AppSyncOptimisticUpdateInterceptor.access$000(), "Thread:[" + Thread.currentThread().getId() + "]: failed to update store with optimistic update for: [" + this.val$request.b + "]");
            }
        }
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ z1.a access$100(AppSyncOptimisticUpdateInterceptor appSyncOptimisticUpdateInterceptor) {
        return appSyncOptimisticUpdateInterceptor.store;
    }

    public void dispose() {
    }

    public void interceptAsync(a.c cVar, b bVar, Executor executor, a.a aVar) {
        if (cVar.e.f()) {
            executor.execute(new 1(cVar, (f.a) cVar.e.e()));
        }
        bVar.a(cVar, executor, aVar);
    }

    public void setStore(z1.a aVar) {
        this.store = aVar;
    }
}
