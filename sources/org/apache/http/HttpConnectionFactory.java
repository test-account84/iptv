package org.apache.http;

import java.io.IOException;
import java.net.Socket;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface HttpConnectionFactory {
    HttpConnection createConnection(Socket socket) throws IOException;
}
