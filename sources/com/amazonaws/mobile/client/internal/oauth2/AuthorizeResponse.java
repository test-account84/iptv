package com.amazonaws.mobile.client.internal.oauth2;

import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class AuthorizeResponse {
    String code;
    Uri responseUri;

    public String getCode() {
        return this.code;
    }

    public Uri getResponseUri() {
        return this.responseUri;
    }
}
