package com.squareup.okhttp;

import java.io.IOException;
import java.net.Proxy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Authenticator {
    Request authenticate(Proxy proxy, Response response) throws IOException;

    Request authenticateProxy(Proxy proxy, Response response) throws IOException;
}
