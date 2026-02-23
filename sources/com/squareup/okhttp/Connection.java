package com.squareup.okhttp;

import java.net.Socket;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface Connection {
    Handshake getHandshake();

    Protocol getProtocol();

    Route getRoute();

    Socket getSocket();
}
