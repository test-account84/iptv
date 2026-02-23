package com.amazonaws.handlers;

import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface AsyncHandler {
    void onError(Exception exc);

    void onSuccess(AmazonWebServiceRequest amazonWebServiceRequest, Object obj);
}
