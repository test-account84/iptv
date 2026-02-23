package org.apache.http.impl.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.ConnectionBackoffStrategy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NullBackoffStrategy implements ConnectionBackoffStrategy {
    public boolean shouldBackoff(Throwable th) {
        return false;
    }

    public boolean shouldBackoff(HttpResponse httpResponse) {
        return false;
    }
}
