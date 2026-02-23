package org.apache.http.impl.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.BasicManagedEntity;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultRequestDirector implements RequestDirector {
    private final HttpAuthenticator authenticator;
    protected final ClientConnectionManager connManager;
    private int execCount;
    protected final HttpProcessor httpProcessor;
    protected final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log;
    protected ManagedClientConnection managedConn;
    private final int maxRedirects;
    protected final HttpParams params;

    @Deprecated
    protected final AuthenticationHandler proxyAuthHandler;
    protected final AuthState proxyAuthState;
    protected final AuthenticationStrategy proxyAuthStrategy;
    private int redirectCount;

    @Deprecated
    protected final RedirectHandler redirectHandler;
    protected final RedirectStrategy redirectStrategy;
    protected final HttpRequestExecutor requestExec;
    protected final HttpRequestRetryHandler retryHandler;
    protected final ConnectionReuseStrategy reuseStrategy;
    protected final HttpRoutePlanner routePlanner;

    @Deprecated
    protected final AuthenticationHandler targetAuthHandler;
    protected final AuthState targetAuthState;
    protected final AuthenticationStrategy targetAuthStrategy;
    protected final UserTokenHandler userTokenHandler;
    private HttpHost virtualHost;

    @Deprecated
    public DefaultRequestDirector(Log log, HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectStrategy redirectStrategy, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        this(LogFactory.getLog(DefaultRequestDirector.class), httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectStrategy, new AuthenticationStrategyAdaptor(authenticationHandler), new AuthenticationStrategyAdaptor(authenticationHandler2), userTokenHandler, httpParams);
    }

    private void abortConnection() {
        ManagedClientConnection managedClientConnection = this.managedConn;
        if (managedClientConnection != null) {
            this.managedConn = null;
            try {
                managedClientConnection.abortConnection();
            } catch (IOException e) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug(e.getMessage(), e);
                }
            }
            try {
                managedClientConnection.releaseConnection();
            } catch (IOException e2) {
                this.log.debug("Error releasing connection", e2);
            }
        }
    }

    private void tryConnect(RoutedRequest routedRequest, HttpContext httpContext) throws HttpException, IOException {
        HttpRoute route = routedRequest.getRoute();
        RequestWrapper request = routedRequest.getRequest();
        int i = 0;
        while (true) {
            httpContext.setAttribute("http.request", request);
            i++;
            try {
                if (this.managedConn.isOpen()) {
                    this.managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(this.params));
                } else {
                    this.managedConn.open(route, httpContext, this.params);
                }
                establishRoute(route, httpContext);
                return;
            } catch (IOException e) {
                try {
                    this.managedConn.close();
                } catch (IOException unused) {
                }
                if (!this.retryHandler.retryRequest(e, i, httpContext)) {
                    throw e;
                }
                if (this.log.isInfoEnabled()) {
                    this.log.info("I/O exception (" + e.getClass().getName() + ") caught when connecting to " + route + ": " + e.getMessage());
                    if (this.log.isDebugEnabled()) {
                        this.log.debug(e.getMessage(), e);
                    }
                    this.log.info("Retrying connect to " + route);
                }
            }
        }
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(Unknown Source:7)
        */
    private org.apache.http.HttpResponse tryExecute(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.util.ArrayList$Itr.next(ArrayList.java:860)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(Unknown Source:39)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(Unknown Source:123)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(Unknown Source:59)
        */
    /*  JADX ERROR: Method generation error
        LL1ili1iI1iI.IIiLliI1l1li1: Code variable not set in r7v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(Unknown Source:28)
        	at l111lLIIl11iL.L111LiLLi1iiliL.lILLi11Li1lll(Unknown Source:44)
        	at l111lLIIl11iL.L111LiLLi1iiliL.iliLiI1iLLIL(Unknown Source:469)
        	at l111lLIIl11iL.l1LII1ii11LI11.iLIi1LlIlIil1(Unknown Source:61)
        	at l111lLIIl11iL.l1LII1ii11LI11.LIi1LL1Ilill1l(Unknown Source:22)
        	at l111lLIIl11iL.l1LII1ii11LI11.lL111llILliLi(Unknown Source:12)
        	at l111lLIIl11iL.l1LII1ii11LI11.LlIIlIliLlL1IiL(Unknown Source:0)
        	at l111lLIIl11iL.IIiLliI1l1li1.accept(Unknown Source:6)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.util.stream.-$$Lambda$Abl7XfE0Z4AgkViLas9vhsO9mjw.accept(Unknown Source:2)
        	at java.util.ArrayList.forEach(ArrayList.java:1262)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:260)
        */

    private RequestWrapper wrapRequest(HttpRequest httpRequest) throws ProtocolException {
        return httpRequest instanceof HttpEntityEnclosingRequest ? new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpRequest) : new RequestWrapper(httpRequest);
    }

    public HttpRequest createConnectRequest(HttpRoute httpRoute, HttpContext httpContext) {
        HttpHost targetHost = httpRoute.getTargetHost();
        String hostName = targetHost.getHostName();
        int port = targetHost.getPort();
        if (port < 0) {
            port = this.connManager.getSchemeRegistry().getScheme(targetHost.getSchemeName()).getDefaultPort();
        }
        StringBuilder sb = new StringBuilder(hostName.length() + 6);
        sb.append(hostName);
        sb.append(':');
        sb.append(Integer.toString(port));
        return new BasicHttpRequest("CONNECT", sb.toString(), HttpProtocolParams.getVersion(this.params));
    }

    public boolean createTunnelToProxy(HttpRoute httpRoute, int i, HttpContext httpContext) throws HttpException, IOException {
        throw new HttpException("Proxy chains are not supported.");
    }

    public boolean createTunnelToTarget(HttpRoute httpRoute, HttpContext httpContext) throws HttpException, IOException {
        HttpResponse execute;
        HttpHost proxyHost = httpRoute.getProxyHost();
        HttpHost targetHost = httpRoute.getTargetHost();
        while (true) {
            if (!this.managedConn.isOpen()) {
                this.managedConn.open(httpRoute, httpContext, this.params);
            }
            HttpRequest createConnectRequest = createConnectRequest(httpRoute, httpContext);
            createConnectRequest.setParams(this.params);
            httpContext.setAttribute("http.target_host", targetHost);
            httpContext.setAttribute("http.route", httpRoute);
            httpContext.setAttribute("http.proxy_host", proxyHost);
            httpContext.setAttribute("http.connection", this.managedConn);
            httpContext.setAttribute("http.request", createConnectRequest);
            this.requestExec.preProcess(createConnectRequest, this.httpProcessor, httpContext);
            execute = this.requestExec.execute(createConnectRequest, this.managedConn, httpContext);
            execute.setParams(this.params);
            this.requestExec.postProcess(execute, this.httpProcessor, httpContext);
            if (execute.getStatusLine().getStatusCode() < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " + execute.getStatusLine());
            }
            if (HttpClientParams.isAuthenticating(this.params)) {
                if (!this.authenticator.isAuthenticationRequested(proxyHost, execute, this.proxyAuthStrategy, this.proxyAuthState, httpContext) || !this.authenticator.authenticate(proxyHost, execute, this.proxyAuthStrategy, this.proxyAuthState, httpContext)) {
                    break;
                }
                if (this.reuseStrategy.keepAlive(execute, httpContext)) {
                    this.log.debug("Connection kept alive");
                    EntityUtils.consume(execute.getEntity());
                } else {
                    this.managedConn.close();
                }
            }
        }
        if (execute.getStatusLine().getStatusCode() <= 299) {
            this.managedConn.markReusable();
            return false;
        }
        HttpEntity entity = execute.getEntity();
        if (entity != null) {
            execute.setEntity(new BufferedHttpEntity(entity));
        }
        this.managedConn.close();
        throw new TunnelRefusedException("CONNECT refused by proxy: " + execute.getStatusLine(), execute);
    }

    public HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        HttpRoutePlanner httpRoutePlanner = this.routePlanner;
        if (httpHost == null) {
            httpHost = (HttpHost) httpRequest.getParams().getParameter("http.default-host");
        }
        return httpRoutePlanner.determineRoute(httpHost, httpRequest, httpContext);
    }

    public void establishRoute(HttpRoute httpRoute, HttpContext httpContext) throws HttpException, IOException {
        int nextStep;
        BasicRouteDirector basicRouteDirector = new BasicRouteDirector();
        do {
            HttpRoute route = this.managedConn.getRoute();
            nextStep = basicRouteDirector.nextStep(httpRoute, route);
            switch (nextStep) {
                case -1:
                    throw new HttpException("Unable to establish route: planned = " + httpRoute + "; current = " + route);
                case 0:
                    break;
                case 1:
                case 2:
                    this.managedConn.open(httpRoute, httpContext, this.params);
                    break;
                case 3:
                    boolean createTunnelToTarget = createTunnelToTarget(httpRoute, httpContext);
                    this.log.debug("Tunnel to target created.");
                    this.managedConn.tunnelTarget(createTunnelToTarget, this.params);
                    break;
                case 4:
                    int hopCount = route.getHopCount() - 1;
                    boolean createTunnelToProxy = createTunnelToProxy(httpRoute, hopCount, httpContext);
                    this.log.debug("Tunnel to proxy created.");
                    this.managedConn.tunnelProxy(httpRoute.getHopTarget(hopCount), createTunnelToProxy, this.params);
                    break;
                case 5:
                    this.managedConn.layerProtocol(httpContext, this.params);
                    break;
                default:
                    throw new IllegalStateException("Unknown step indicator " + nextStep + " from RouteDirector.");
            }
        } while (nextStep > 0);
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        String str;
        httpContext.setAttribute("http.auth.target-scope", this.targetAuthState);
        httpContext.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
        RequestWrapper wrapRequest = wrapRequest(httpRequest);
        wrapRequest.setParams(this.params);
        HttpRoute determineRoute = determineRoute(httpHost, wrapRequest, httpContext);
        HttpHost httpHost2 = (HttpHost) wrapRequest.getParams().getParameter("http.virtual-host");
        this.virtualHost = httpHost2;
        if (httpHost2 != null && httpHost2.getPort() == -1) {
            int port = (httpHost != null ? httpHost : determineRoute.getTargetHost()).getPort();
            if (port != -1) {
                this.virtualHost = new HttpHost(this.virtualHost.getHostName(), port, this.virtualHost.getSchemeName());
            }
        }
        RoutedRequest routedRequest = new RoutedRequest(wrapRequest, determineRoute);
        boolean z = false;
        RoutedRequest routedRequest2 = routedRequest;
        HttpResponse httpResponse = null;
        boolean z2 = false;
        while (!z) {
            try {
                RequestWrapper request = routedRequest2.getRequest();
                HttpRoute route = routedRequest2.getRoute();
                Object attribute = httpContext.getAttribute("http.user-token");
                if (this.managedConn == null) {
                    ClientConnectionRequest requestConnection = this.connManager.requestConnection(route, attribute);
                    if (httpRequest instanceof AbortableHttpRequest) {
                        ((AbortableHttpRequest) httpRequest).setConnectionRequest(requestConnection);
                    }
                    try {
                        this.managedConn = requestConnection.getConnection(HttpClientParams.getConnectionManagerTimeout(this.params), TimeUnit.MILLISECONDS);
                        if (HttpConnectionParams.isStaleCheckingEnabled(this.params) && this.managedConn.isOpen()) {
                            this.log.debug("Stale connection check");
                            if (this.managedConn.isStale()) {
                                this.log.debug("Stale connection detected");
                                this.managedConn.close();
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                if (httpRequest instanceof AbortableHttpRequest) {
                    ((AbortableHttpRequest) httpRequest).setReleaseTrigger(this.managedConn);
                }
                try {
                    tryConnect(routedRequest2, httpContext);
                    String userInfo = request.getURI().getUserInfo();
                    if (userInfo != null) {
                        this.targetAuthState.update(new BasicScheme(), new UsernamePasswordCredentials(userInfo));
                    }
                    HttpHost httpHost3 = this.virtualHost;
                    if (httpHost3 != null) {
                        httpHost = httpHost3;
                    } else {
                        URI uri = request.getURI();
                        if (uri.isAbsolute()) {
                            httpHost = URIUtils.extractHost(uri);
                        }
                    }
                    if (httpHost == null) {
                        httpHost = route.getTargetHost();
                    }
                    request.resetHeaders();
                    rewriteRequestURI(request, route);
                    httpContext.setAttribute("http.target_host", httpHost);
                    httpContext.setAttribute("http.route", route);
                    httpContext.setAttribute("http.connection", this.managedConn);
                    this.requestExec.preProcess(request, this.httpProcessor, httpContext);
                    httpResponse = tryExecute(routedRequest2, httpContext);
                    if (httpResponse != null) {
                        httpResponse.setParams(this.params);
                        this.requestExec.postProcess(httpResponse, this.httpProcessor, httpContext);
                        z2 = this.reuseStrategy.keepAlive(httpResponse, httpContext);
                        if (z2) {
                            long keepAliveDuration = this.keepAliveStrategy.getKeepAliveDuration(httpResponse, httpContext);
                            if (this.log.isDebugEnabled()) {
                                if (keepAliveDuration > 0) {
                                    str = "for " + keepAliveDuration + " " + TimeUnit.MILLISECONDS;
                                } else {
                                    str = "indefinitely";
                                }
                                this.log.debug("Connection can be kept alive " + str);
                            }
                            this.managedConn.setIdleDuration(keepAliveDuration, TimeUnit.MILLISECONDS);
                        }
                        RoutedRequest handleResponse = handleResponse(routedRequest2, httpResponse, httpContext);
                        if (handleResponse == null) {
                            z = true;
                        } else {
                            if (z2) {
                                EntityUtils.consume(httpResponse.getEntity());
                                this.managedConn.markReusable();
                            } else {
                                this.managedConn.close();
                                AuthProtocolState state = this.proxyAuthState.getState();
                                AuthProtocolState authProtocolState = AuthProtocolState.CHALLENGED;
                                if (state.compareTo(authProtocolState) > 0 && this.proxyAuthState.getAuthScheme() != null && this.proxyAuthState.getAuthScheme().isConnectionBased()) {
                                    this.log.debug("Resetting proxy auth state");
                                    this.proxyAuthState.reset();
                                }
                                if (this.targetAuthState.getState().compareTo(authProtocolState) > 0 && this.targetAuthState.getAuthScheme() != null && this.targetAuthState.getAuthScheme().isConnectionBased()) {
                                    this.log.debug("Resetting target auth state");
                                    this.targetAuthState.reset();
                                }
                            }
                            if (!handleResponse.getRoute().equals(routedRequest2.getRoute())) {
                                releaseConnection();
                            }
                            routedRequest2 = handleResponse;
                        }
                        if (this.managedConn != null) {
                            if (attribute == null) {
                                attribute = this.userTokenHandler.getUserToken(httpContext);
                                httpContext.setAttribute("http.user-token", attribute);
                            }
                            if (attribute != null) {
                                this.managedConn.setState(attribute);
                            }
                        }
                    }
                } catch (TunnelRefusedException e) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug(e.getMessage());
                    }
                    httpResponse = e.getResponse();
                }
            } catch (ConnectionShutdownException e2) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
                interruptedIOException.initCause(e2);
                throw interruptedIOException;
            } catch (IOException e3) {
                abortConnection();
                throw e3;
            } catch (RuntimeException e4) {
                abortConnection();
                throw e4;
            } catch (HttpException e5) {
                abortConnection();
                throw e5;
            }
        }
        if (httpResponse == null || httpResponse.getEntity() == null || !httpResponse.getEntity().isStreaming()) {
            if (z2) {
                this.managedConn.markReusable();
            }
            releaseConnection();
        } else {
            httpResponse.setEntity(new BasicManagedEntity(httpResponse.getEntity(), this.managedConn, z2));
        }
        return httpResponse;
    }

    public RoutedRequest handleResponse(RoutedRequest routedRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpHost httpHost;
        HttpRoute route = routedRequest.getRoute();
        RequestWrapper request = routedRequest.getRequest();
        HttpParams params = request.getParams();
        if (HttpClientParams.isAuthenticating(params)) {
            HttpHost httpHost2 = (HttpHost) httpContext.getAttribute("http.target_host");
            if (httpHost2 == null) {
                httpHost2 = route.getTargetHost();
            }
            if (httpHost2.getPort() < 0) {
                httpHost = new HttpHost(httpHost2.getHostName(), this.connManager.getSchemeRegistry().getScheme(httpHost2).getDefaultPort(), httpHost2.getSchemeName());
            } else {
                httpHost = httpHost2;
            }
            boolean isAuthenticationRequested = this.authenticator.isAuthenticationRequested(httpHost, httpResponse, this.targetAuthStrategy, this.targetAuthState, httpContext);
            HttpHost proxyHost = route.getProxyHost();
            if (proxyHost == null) {
                proxyHost = route.getTargetHost();
            }
            HttpHost httpHost3 = proxyHost;
            boolean isAuthenticationRequested2 = this.authenticator.isAuthenticationRequested(httpHost3, httpResponse, this.proxyAuthStrategy, this.proxyAuthState, httpContext);
            if (isAuthenticationRequested) {
                if (this.authenticator.authenticate(httpHost, httpResponse, this.targetAuthStrategy, this.targetAuthState, httpContext)) {
                    return routedRequest;
                }
            }
            if (isAuthenticationRequested2 && this.authenticator.authenticate(httpHost3, httpResponse, this.proxyAuthStrategy, this.proxyAuthState, httpContext)) {
                return routedRequest;
            }
        }
        if (!HttpClientParams.isRedirecting(params) || !this.redirectStrategy.isRedirected(request, httpResponse, httpContext)) {
            return null;
        }
        int i = this.redirectCount;
        if (i >= this.maxRedirects) {
            throw new RedirectException("Maximum redirects (" + this.maxRedirects + ") exceeded");
        }
        this.redirectCount = i + 1;
        this.virtualHost = null;
        HttpUriRequest redirect = this.redirectStrategy.getRedirect(request, httpResponse, httpContext);
        redirect.setHeaders(request.getOriginal().getAllHeaders());
        URI uri = redirect.getURI();
        HttpHost extractHost = URIUtils.extractHost(uri);
        if (extractHost == null) {
            throw new ProtocolException("Redirect URI does not specify a valid host name: " + uri);
        }
        if (!route.getTargetHost().equals(extractHost)) {
            this.log.debug("Resetting target auth state");
            this.targetAuthState.reset();
            AuthScheme authScheme = this.proxyAuthState.getAuthScheme();
            if (authScheme != null && authScheme.isConnectionBased()) {
                this.log.debug("Resetting proxy auth state");
                this.proxyAuthState.reset();
            }
        }
        RequestWrapper wrapRequest = wrapRequest(redirect);
        wrapRequest.setParams(params);
        HttpRoute determineRoute = determineRoute(extractHost, wrapRequest, httpContext);
        RoutedRequest routedRequest2 = new RoutedRequest(wrapRequest, determineRoute);
        if (this.log.isDebugEnabled()) {
            this.log.debug("Redirecting to '" + uri + "' via " + determineRoute);
        }
        return routedRequest2;
    }

    public void releaseConnection() {
        try {
            this.managedConn.releaseConnection();
        } catch (IOException e) {
            this.log.debug("IOException releasing connection", e);
        }
        this.managedConn = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022 A[Catch: URISyntaxException -> 0x0020, TryCatch #0 {URISyntaxException -> 0x0020, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x0011, B:8:0x0017, B:9:0x0032, B:13:0x0022, B:14:0x0027, B:16:0x002d), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void rewriteRequestURI(org.apache.http.impl.client.RequestWrapper r4, org.apache.http.conn.routing.HttpRoute r5) throws org.apache.http.ProtocolException {
        /*
            r3 = this;
            java.net.URI r0 = r4.getURI()     // Catch: java.net.URISyntaxException -> L20
            org.apache.http.HttpHost r1 = r5.getProxyHost()     // Catch: java.net.URISyntaxException -> L20
            r2 = 1
            if (r1 == 0) goto L27
            boolean r1 = r5.isTunnelled()     // Catch: java.net.URISyntaxException -> L20
            if (r1 != 0) goto L27
            boolean r1 = r0.isAbsolute()     // Catch: java.net.URISyntaxException -> L20
            if (r1 != 0) goto L22
            org.apache.http.HttpHost r5 = r5.getTargetHost()     // Catch: java.net.URISyntaxException -> L20
            java.net.URI r5 = org.apache.http.client.utils.URIUtils.rewriteURI(r0, r5, r2)     // Catch: java.net.URISyntaxException -> L20
            goto L32
        L20:
            r5 = move-exception
            goto L36
        L22:
            java.net.URI r5 = org.apache.http.client.utils.URIUtils.rewriteURI(r0)     // Catch: java.net.URISyntaxException -> L20
            goto L32
        L27:
            boolean r5 = r0.isAbsolute()     // Catch: java.net.URISyntaxException -> L20
            if (r5 == 0) goto L22
            r5 = 0
            java.net.URI r5 = org.apache.http.client.utils.URIUtils.rewriteURI(r0, r5, r2)     // Catch: java.net.URISyntaxException -> L20
        L32:
            r4.setURI(r5)     // Catch: java.net.URISyntaxException -> L20
            return
        L36:
            org.apache.http.ProtocolException r0 = new org.apache.http.ProtocolException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid URI: "
            r1.append(r2)
            org.apache.http.RequestLine r4 = r4.getRequestLine()
            java.lang.String r4 = r4.getUri()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.client.DefaultRequestDirector.rewriteRequestURI(org.apache.http.impl.client.RequestWrapper, org.apache.http.conn.routing.HttpRoute):void");
    }

    public DefaultRequestDirector(Log log, HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectStrategy redirectStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        Args.notNull(log, "Log");
        Args.notNull(httpRequestExecutor, "Request executor");
        Args.notNull(clientConnectionManager, "Client connection manager");
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        Args.notNull(connectionKeepAliveStrategy, "Connection keep alive strategy");
        Args.notNull(httpRoutePlanner, "Route planner");
        Args.notNull(httpProcessor, "HTTP protocol processor");
        Args.notNull(httpRequestRetryHandler, "HTTP request retry handler");
        Args.notNull(redirectStrategy, "Redirect strategy");
        Args.notNull(authenticationStrategy, "Target authentication strategy");
        Args.notNull(authenticationStrategy2, "Proxy authentication strategy");
        Args.notNull(userTokenHandler, "User token handler");
        Args.notNull(httpParams, "HTTP parameters");
        this.log = log;
        this.authenticator = new HttpAuthenticator(log);
        this.requestExec = httpRequestExecutor;
        this.connManager = clientConnectionManager;
        this.reuseStrategy = connectionReuseStrategy;
        this.keepAliveStrategy = connectionKeepAliveStrategy;
        this.routePlanner = httpRoutePlanner;
        this.httpProcessor = httpProcessor;
        this.retryHandler = httpRequestRetryHandler;
        this.redirectStrategy = redirectStrategy;
        this.targetAuthStrategy = authenticationStrategy;
        this.proxyAuthStrategy = authenticationStrategy2;
        this.userTokenHandler = userTokenHandler;
        this.params = httpParams;
        if (redirectStrategy instanceof DefaultRedirectStrategyAdaptor) {
            this.redirectHandler = ((DefaultRedirectStrategyAdaptor) redirectStrategy).getHandler();
        } else {
            this.redirectHandler = null;
        }
        if (authenticationStrategy instanceof AuthenticationStrategyAdaptor) {
            this.targetAuthHandler = ((AuthenticationStrategyAdaptor) authenticationStrategy).getHandler();
        } else {
            this.targetAuthHandler = null;
        }
        if (authenticationStrategy2 instanceof AuthenticationStrategyAdaptor) {
            this.proxyAuthHandler = ((AuthenticationStrategyAdaptor) authenticationStrategy2).getHandler();
        } else {
            this.proxyAuthHandler = null;
        }
        this.managedConn = null;
        this.execCount = 0;
        this.redirectCount = 0;
        this.targetAuthState = new AuthState();
        this.proxyAuthState = new AuthState();
        this.maxRedirects = httpParams.getIntParameter("http.protocol.max-redirects", 100);
    }

    @Deprecated
    public DefaultRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        this(LogFactory.getLog(DefaultRequestDirector.class), httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, new DefaultRedirectStrategyAdaptor(redirectHandler), new AuthenticationStrategyAdaptor(authenticationHandler), new AuthenticationStrategyAdaptor(authenticationHandler2), userTokenHandler, httpParams);
    }
}
