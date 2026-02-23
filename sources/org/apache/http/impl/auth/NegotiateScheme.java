package org.apache.http.impl.auth;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.Oid;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NegotiateScheme extends GGSSchemeBase {
    private static final String KERBEROS_OID = "1.2.840.113554.1.2.2";
    private static final String SPNEGO_OID = "1.3.6.1.5.5.2";
    private final Log log;
    private final SpnegoTokenGenerator spengoGenerator;

    public NegotiateScheme() {
        this(null, false);
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        return authenticate(credentials, httpRequest, null);
    }

    public byte[] generateToken(byte[] bArr, String str) throws GSSException {
        return super.generateToken(bArr, str);
    }

    public String getParameter(String str) {
        Args.notNull(str, "Parameter name");
        return null;
    }

    public String getRealm() {
        return null;
    }

    public String getSchemeName() {
        return "Negotiate";
    }

    public boolean isConnectionBased() {
        return true;
    }

    public NegotiateScheme(SpnegoTokenGenerator spnegoTokenGenerator) {
        this(spnegoTokenGenerator, false);
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) throws AuthenticationException {
        return super.authenticate(credentials, httpRequest, httpContext);
    }

    public byte[] generateToken(byte[] bArr, String str, Credentials credentials) throws GSSException {
        boolean z;
        SpnegoTokenGenerator spnegoTokenGenerator;
        try {
            bArr = generateGSSToken(bArr, new Oid("1.3.6.1.5.5.2"), str, credentials);
            z = false;
        } catch (GSSException e) {
            if (e.getMajor() != 2) {
                throw e;
            }
            this.log.debug("GSSException BAD_MECH, retry with Kerberos MECH");
            z = true;
        }
        if (!z) {
            return bArr;
        }
        this.log.debug("Using Kerberos MECH 1.2.840.113554.1.2.2");
        byte[] generateGSSToken = generateGSSToken(bArr, new Oid("1.2.840.113554.1.2.2"), str, credentials);
        if (generateGSSToken == null || (spnegoTokenGenerator = this.spengoGenerator) == null) {
            return generateGSSToken;
        }
        try {
            return spnegoTokenGenerator.generateSpnegoDERObject(generateGSSToken);
        } catch (IOException e2) {
            this.log.error(e2.getMessage(), e2);
            return generateGSSToken;
        }
    }

    public NegotiateScheme(SpnegoTokenGenerator spnegoTokenGenerator, boolean z) {
        super(z);
        this.log = LogFactory.getLog(getClass());
        this.spengoGenerator = spnegoTokenGenerator;
    }
}
