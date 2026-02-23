package org.apache.http.pool;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface ConnPoolControl {
    int getDefaultMaxPerRoute();

    int getMaxPerRoute(Object obj);

    int getMaxTotal();

    PoolStats getStats(Object obj);

    PoolStats getTotalStats();

    void setDefaultMaxPerRoute(int i);

    void setMaxPerRoute(Object obj, int i);

    void setMaxTotal(int i);
}
