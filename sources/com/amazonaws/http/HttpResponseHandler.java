package com.amazonaws.http;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface HttpResponseHandler {
    Object handle(HttpResponse httpResponse) throws Exception;

    boolean needsConnectionLeftOpen();
}
