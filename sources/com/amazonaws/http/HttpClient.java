package com.amazonaws.http;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface HttpClient {
    HttpResponse execute(HttpRequest httpRequest) throws IOException;

    void shutdown();
}
