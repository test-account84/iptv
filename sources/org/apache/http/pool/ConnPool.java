package org.apache.http.pool;

import java.util.concurrent.Future;
import org.apache.http.concurrent.FutureCallback;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface ConnPool {
    Future lease(Object obj, Object obj2, FutureCallback futureCallback);

    void release(Object obj, boolean z);
}
