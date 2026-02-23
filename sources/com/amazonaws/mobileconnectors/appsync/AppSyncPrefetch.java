package com.amazonaws.mobileconnectors.appsync;

import B1.b;
import B1.c;
import B1.d;
import M1.a;
import okhttp3.Response;
import v1.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AppSyncPrefetch extends a {

    public static abstract class Callback {
        public void onCanceledError(B1.a aVar) {
            onFailure(aVar);
        }

        public abstract void onFailure(b bVar);

        public void onHttpError(c cVar) {
            onFailure(cVar);
            Response b = cVar.b();
            if (b != null) {
                b.close();
            }
        }

        public void onNetworkError(d dVar) {
            onFailure(dVar);
        }

        public abstract void onSuccess();
    }

    public interface Factory {
        AppSyncPrefetch prefetch(f fVar);
    }

    void cancel();

    AppSyncPrefetch clone();

    void enqueue(Callback callback);

    /* synthetic */ boolean isCanceled();

    f operation();
}
