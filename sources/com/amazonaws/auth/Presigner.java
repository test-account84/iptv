package com.amazonaws.auth;

import com.amazonaws.Request;
import java.util.Date;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public interface Presigner {
    void presignRequest(Request request, AWSCredentials aWSCredentials, Date date);
}
