package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.util.TimingInfo;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class AbstractRequestHandler implements RequestHandler {
    public void afterError(Request request, Exception exc) {
    }

    public void afterResponse(Request request, Object obj, TimingInfo timingInfo) {
    }

    public void beforeRequest(Request request) {
    }
}
