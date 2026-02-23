package com.amazonaws.auth;

import com.amazonaws.Request;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface Signer {
    void sign(Request request, AWSCredentials aWSCredentials);
}
