package org.apache.http.auth;

import org.apache.http.protocol.HttpContext;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface AuthSchemeProvider {
    AuthScheme create(HttpContext httpContext);
}
