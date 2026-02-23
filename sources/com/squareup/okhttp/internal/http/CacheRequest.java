package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
