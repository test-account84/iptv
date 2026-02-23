package org.apache.http.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.AuthState;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.Configurable;
import org.apache.http.client.methods.HttpExecutionAware;
import org.apache.http.client.methods.HttpRequestWrapper;
import org.apache.http.client.params.HttpClientParamConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpParamsNames;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class InternalHttpClient extends CloseableHttpClient implements Configurable {
    private final Lookup authSchemeRegistry;
    private final List closeables;
    private final HttpClientConnectionManager connManager;
    private final Lookup cookieSpecRegistry;
    private final CookieStore cookieStore;
    private final CredentialsProvider credentialsProvider;
    private final RequestConfig defaultConfig;
    private final ClientExecChain execChain;
    private final Log log = LogFactory.getLog(getClass());
    private final HttpRoutePlanner routePlanner;

    public class 1 implements ClientConnectionManager {
        public 1() {
        }

        public void closeExpiredConnections() {
            InternalHttpClient.access$000(InternalHttpClient.this).closeExpiredConnections();
        }

        public void closeIdleConnections(long j, TimeUnit timeUnit) {
            InternalHttpClient.access$000(InternalHttpClient.this).closeIdleConnections(j, timeUnit);
        }

        public SchemeRegistry getSchemeRegistry() {
            throw new UnsupportedOperationException();
        }

        public void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }

        public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
            throw new UnsupportedOperationException();
        }

        public void shutdown() {
            InternalHttpClient.access$000(InternalHttpClient.this).shutdown();
        }
    }

    public InternalHttpClient(ClientExecChain clientExecChain, HttpClientConnectionManager httpClientConnectionManager, HttpRoutePlanner httpRoutePlanner, Lookup lookup, Lookup lookup2, CookieStore cookieStore, CredentialsProvider credentialsProvider, RequestConfig requestConfig, List list) {
        Args.notNull(clientExecChain, "HTTP client exec chain");
        Args.notNull(httpClientConnectionManager, "HTTP connection manager");
        Args.notNull(httpRoutePlanner, "HTTP route planner");
        this.execChain = clientExecChain;
        this.connManager = httpClientConnectionManager;
        this.routePlanner = httpRoutePlanner;
        this.cookieSpecRegistry = lookup;
        this.authSchemeRegistry = lookup2;
        this.cookieStore = cookieStore;
        this.credentialsProvider = credentialsProvider;
        this.defaultConfig = requestConfig;
        this.closeables = list;
    }

    public static /* synthetic */ HttpClientConnectionManager access$000(InternalHttpClient internalHttpClient) {
        return internalHttpClient.connManager;
    }

    private HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        if (httpHost == null) {
            httpHost = (HttpHost) httpRequest.getParams().getParameter("http.default-host");
        }
        return this.routePlanner.determineRoute(httpHost, httpRequest, httpContext);
    }

    private void setupContext(HttpClientContext httpClientContext) {
        if (httpClientContext.getAttribute("http.auth.target-scope") == null) {
            httpClientContext.setAttribute("http.auth.target-scope", new AuthState());
        }
        if (httpClientContext.getAttribute("http.auth.proxy-scope") == null) {
            httpClientContext.setAttribute("http.auth.proxy-scope", new AuthState());
        }
        if (httpClientContext.getAttribute("http.authscheme-registry") == null) {
            httpClientContext.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        }
        if (httpClientContext.getAttribute("http.cookiespec-registry") == null) {
            httpClientContext.setAttribute("http.cookiespec-registry", this.cookieSpecRegistry);
        }
        if (httpClientContext.getAttribute("http.cookie-store") == null) {
            httpClientContext.setAttribute("http.cookie-store", this.cookieStore);
        }
        if (httpClientContext.getAttribute("http.auth.credentials-provider") == null) {
            httpClientContext.setAttribute("http.auth.credentials-provider", this.credentialsProvider);
        }
        if (httpClientContext.getAttribute("http.request-config") == null) {
            httpClientContext.setAttribute("http.request-config", this.defaultConfig);
        }
    }

    public void close() {
        List list = this.closeables;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    ((Closeable) it.next()).close();
                } catch (IOException e) {
                    this.log.error(e.getMessage(), e);
                }
            }
        }
    }

    public CloseableHttpResponse doExecute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        RequestConfig requestConfig;
        Args.notNull(httpRequest, "HTTP request");
        HttpExecutionAware httpExecutionAware = httpRequest instanceof HttpExecutionAware ? (HttpExecutionAware) httpRequest : null;
        try {
            HttpRequestWrapper wrap = HttpRequestWrapper.wrap(httpRequest, httpHost);
            if (httpContext == null) {
                httpContext = new BasicHttpContext();
            }
            HttpClientContext adapt = HttpClientContext.adapt(httpContext);
            RequestConfig config = httpRequest instanceof Configurable ? ((Configurable) httpRequest).getConfig() : null;
            if (config == null) {
                HttpParams params = httpRequest.getParams();
                if (!(params instanceof HttpParamsNames)) {
                    requestConfig = this.defaultConfig;
                } else if (!((HttpParamsNames) params).getNames().isEmpty()) {
                    requestConfig = this.defaultConfig;
                }
                config = HttpClientParamConfig.getRequestConfig(params, requestConfig);
            }
            if (config != null) {
                adapt.setRequestConfig(config);
            }
            setupContext(adapt);
            return this.execChain.execute(determineRoute(httpHost, wrap, adapt), wrap, adapt, httpExecutionAware);
        } catch (HttpException e) {
            throw new ClientProtocolException((Throwable) e);
        }
    }

    public RequestConfig getConfig() {
        return this.defaultConfig;
    }

    public ClientConnectionManager getConnectionManager() {
        return new 1();
    }

    public HttpParams getParams() {
        throw new UnsupportedOperationException();
    }
}
