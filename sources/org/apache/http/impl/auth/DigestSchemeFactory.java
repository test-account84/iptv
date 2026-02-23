package org.apache.http.impl.auth;

import java.nio.charset.Charset;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DigestSchemeFactory implements AuthSchemeFactory, AuthSchemeProvider {
    private final Charset charset;

    public DigestSchemeFactory() {
        this(null);
    }

    public AuthScheme create(HttpContext httpContext) {
        return new DigestScheme(this.charset);
    }

    public AuthScheme newInstance(HttpParams httpParams) {
        return new DigestScheme();
    }

    public DigestSchemeFactory(Charset charset) {
        this.charset = charset;
    }
}
