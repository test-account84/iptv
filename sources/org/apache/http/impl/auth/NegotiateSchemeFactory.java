package org.apache.http.impl.auth;

import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NegotiateSchemeFactory implements AuthSchemeFactory {
    private final SpnegoTokenGenerator spengoGenerator;
    private final boolean stripPort;

    public NegotiateSchemeFactory() {
        this(null, false);
    }

    public SpnegoTokenGenerator getSpengoGenerator() {
        return this.spengoGenerator;
    }

    public boolean isStripPort() {
        return this.stripPort;
    }

    public AuthScheme newInstance(HttpParams httpParams) {
        return new NegotiateScheme(this.spengoGenerator, this.stripPort);
    }

    public NegotiateSchemeFactory(SpnegoTokenGenerator spnegoTokenGenerator) {
        this(spnegoTokenGenerator, false);
    }

    public NegotiateSchemeFactory(SpnegoTokenGenerator spnegoTokenGenerator, boolean z) {
        this.spengoGenerator = spnegoTokenGenerator;
        this.stripPort = z;
    }
}
