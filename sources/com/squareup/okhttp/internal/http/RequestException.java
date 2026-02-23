package com.squareup.okhttp.internal.http;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class RequestException extends Exception {
    public RequestException(IOException iOException) {
        super(iOException);
    }

    public IOException getCause() {
        return super.getCause();
    }
}
