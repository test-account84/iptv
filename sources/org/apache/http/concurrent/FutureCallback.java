package org.apache.http.concurrent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface FutureCallback {
    void cancelled();

    void completed(Object obj);

    void failed(Exception exc);
}
