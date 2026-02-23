package org.apache.http.ssl;

import java.net.Socket;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface PrivateKeyStrategy {
    String chooseAlias(Map map, Socket socket);
}
