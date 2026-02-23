package org.apache.http.impl.client;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthOption;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthCache;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
abstract class AuthenticationStrategyImpl implements AuthenticationStrategy {
    private static final List DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[]{"Negotiate", "Kerberos", "NTLM", "CredSSP", "Digest", "Basic"}));
    private final int challengeCode;
    private final String headerName;
    private final Log log = LogFactory.getLog(getClass());

    public AuthenticationStrategyImpl(int i, String str) {
        this.challengeCode = i;
        this.headerName = str;
    }

    public void authFailed(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        Args.notNull(httpHost, "Host");
        Args.notNull(httpContext, "HTTP context");
        AuthCache authCache = HttpClientContext.adapt(httpContext).getAuthCache();
        if (authCache != null) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Clearing cached auth scheme for " + httpHost);
            }
            authCache.remove(httpHost);
        }
    }

    public void authSucceeded(HttpHost httpHost, AuthScheme authScheme, HttpContext httpContext) {
        Args.notNull(httpHost, "Host");
        Args.notNull(authScheme, "Auth scheme");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        if (isCachable(authScheme)) {
            AuthCache authCache = adapt.getAuthCache();
            if (authCache == null) {
                authCache = new BasicAuthCache();
                adapt.setAuthCache(authCache);
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug("Caching '" + authScheme.getSchemeName() + "' auth scheme for " + httpHost);
            }
            authCache.put(httpHost, authScheme);
        }
    }

    public Map getChallenges(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        CharArrayBuffer charArrayBuffer;
        int i;
        Args.notNull(httpResponse, "HTTP response");
        Header[] headers = httpResponse.getHeaders(this.headerName);
        HashMap hashMap = new HashMap(headers.length);
        for (Header header : headers) {
            if (header instanceof FormattedHeader) {
                FormattedHeader formattedHeader = (FormattedHeader) header;
                charArrayBuffer = formattedHeader.getBuffer();
                i = formattedHeader.getValuePos();
            } else {
                String value = header.getValue();
                if (value == null) {
                    throw new MalformedChallengeException("Header value is null");
                }
                charArrayBuffer = new CharArrayBuffer(value.length());
                charArrayBuffer.append(value);
                i = 0;
            }
            while (i < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(i))) {
                i++;
            }
            int i2 = i;
            while (i2 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(i2))) {
                i2++;
            }
            hashMap.put(charArrayBuffer.substring(i, i2).toLowerCase(Locale.ROOT), header);
        }
        return hashMap;
    }

    public abstract Collection getPreferredAuthSchemes(RequestConfig requestConfig);

    public boolean isAuthenticationRequested(HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        return httpResponse.getStatusLine().getStatusCode() == this.challengeCode;
    }

    public boolean isCachable(AuthScheme authScheme) {
        if (authScheme == null || !authScheme.isComplete()) {
            return false;
        }
        return authScheme.getSchemeName().equalsIgnoreCase("Basic");
    }

    public Queue select(Map map, HttpHost httpHost, HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        Log log;
        String str;
        Args.notNull(map, "Map of auth challenges");
        Args.notNull(httpHost, "Host");
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        LinkedList linkedList = new LinkedList();
        Lookup authSchemeRegistry = adapt.getAuthSchemeRegistry();
        if (authSchemeRegistry == null) {
            log = this.log;
            str = "Auth scheme registry not set in the context";
        } else {
            CredentialsProvider credentialsProvider = adapt.getCredentialsProvider();
            if (credentialsProvider != null) {
                List<String> preferredAuthSchemes = getPreferredAuthSchemes(adapt.getRequestConfig());
                if (preferredAuthSchemes == null) {
                    preferredAuthSchemes = DEFAULT_SCHEME_PRIORITY;
                }
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Authentication schemes in the order of preference: " + preferredAuthSchemes);
                }
                for (String str2 : preferredAuthSchemes) {
                    Header header = (Header) map.get(str2.toLowerCase(Locale.ROOT));
                    if (header != null) {
                        AuthSchemeProvider authSchemeProvider = (AuthSchemeProvider) authSchemeRegistry.lookup(str2);
                        if (authSchemeProvider != null) {
                            AuthScheme create = authSchemeProvider.create(httpContext);
                            create.processChallenge(header);
                            Credentials credentials = credentialsProvider.getCredentials(new AuthScope(httpHost, create.getRealm(), create.getSchemeName()));
                            if (credentials != null) {
                                linkedList.add(new AuthOption(create, credentials));
                            }
                        } else if (this.log.isWarnEnabled()) {
                            this.log.warn("Authentication scheme " + str2 + " not supported");
                        }
                    } else if (this.log.isDebugEnabled()) {
                        this.log.debug("Challenge for " + str2 + " authentication scheme not available");
                    }
                }
                return linkedList;
            }
            log = this.log;
            str = "Credentials provider not set in the context";
        }
        log.debug(str);
        return linkedList;
    }
}
