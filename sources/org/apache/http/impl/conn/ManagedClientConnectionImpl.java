package org.apache.http.impl.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class ManagedClientConnectionImpl implements ManagedClientConnection {
    private volatile long duration;
    private final ClientConnectionManager manager;
    private final ClientConnectionOperator operator;
    private volatile HttpPoolEntry poolEntry;
    private volatile boolean reusable;

    public ManagedClientConnectionImpl(ClientConnectionManager clientConnectionManager, ClientConnectionOperator clientConnectionOperator, HttpPoolEntry httpPoolEntry) {
        Args.notNull(clientConnectionManager, "Connection manager");
        Args.notNull(clientConnectionOperator, "Connection operator");
        Args.notNull(httpPoolEntry, "HTTP pool entry");
        this.manager = clientConnectionManager;
        this.operator = clientConnectionOperator;
        this.poolEntry = httpPoolEntry;
        this.reusable = false;
        this.duration = Long.MAX_VALUE;
    }

    private OperatedClientConnection ensureConnection() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            return (OperatedClientConnection) httpPoolEntry.getConnection();
        }
        throw new ConnectionShutdownException();
    }

    private HttpPoolEntry ensurePoolEntry() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            return httpPoolEntry;
        }
        throw new ConnectionShutdownException();
    }

    private OperatedClientConnection getConnection() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry == null) {
            return null;
        }
        return (OperatedClientConnection) httpPoolEntry.getConnection();
    }

    public void abortConnection() {
        synchronized (this) {
            try {
                if (this.poolEntry == null) {
                    return;
                }
                this.reusable = false;
                try {
                    ((OperatedClientConnection) this.poolEntry.getConnection()).shutdown();
                } catch (IOException unused) {
                }
                this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
                this.poolEntry = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void bind(Socket socket) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void close() throws IOException {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            OperatedClientConnection operatedClientConnection = (OperatedClientConnection) httpPoolEntry.getConnection();
            httpPoolEntry.getTracker().reset();
            operatedClientConnection.close();
        }
    }

    public HttpPoolEntry detach() {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        this.poolEntry = null;
        return httpPoolEntry;
    }

    public void flush() throws IOException {
        ensureConnection().flush();
    }

    public Object getAttribute(String str) {
        OperatedClientConnection ensureConnection = ensureConnection();
        if (ensureConnection instanceof HttpContext) {
            return ((HttpContext) ensureConnection).getAttribute(str);
        }
        return null;
    }

    public String getId() {
        return null;
    }

    public InetAddress getLocalAddress() {
        return ensureConnection().getLocalAddress();
    }

    public int getLocalPort() {
        return ensureConnection().getLocalPort();
    }

    public ClientConnectionManager getManager() {
        return this.manager;
    }

    public HttpConnectionMetrics getMetrics() {
        return ensureConnection().getMetrics();
    }

    public HttpPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    public InetAddress getRemoteAddress() {
        return ensureConnection().getRemoteAddress();
    }

    public int getRemotePort() {
        return ensureConnection().getRemotePort();
    }

    public HttpRoute getRoute() {
        return ensurePoolEntry().getEffectiveRoute();
    }

    public SSLSession getSSLSession() {
        SSLSocket socket = ensureConnection().getSocket();
        if (socket instanceof SSLSocket) {
            return socket.getSession();
        }
        return null;
    }

    public Socket getSocket() {
        return ensureConnection().getSocket();
    }

    public int getSocketTimeout() {
        return ensureConnection().getSocketTimeout();
    }

    public Object getState() {
        return ensurePoolEntry().getState();
    }

    public boolean isMarkedReusable() {
        return this.reusable;
    }

    public boolean isOpen() {
        OperatedClientConnection connection = getConnection();
        if (connection != null) {
            return connection.isOpen();
        }
        return false;
    }

    public boolean isResponseAvailable(int i) throws IOException {
        return ensureConnection().isResponseAvailable(i);
    }

    public boolean isSecure() {
        return ensureConnection().isSecure();
    }

    public boolean isStale() {
        OperatedClientConnection connection = getConnection();
        if (connection != null) {
            return connection.isStale();
        }
        return true;
    }

    public void layerProtocol(HttpContext httpContext, HttpParams httpParams) throws IOException {
        HttpHost targetHost;
        OperatedClientConnection operatedClientConnection;
        Args.notNull(httpParams, "HTTP parameters");
        synchronized (this) {
            if (this.poolEntry == null) {
                throw new ConnectionShutdownException();
            }
            RouteTracker tracker = this.poolEntry.getTracker();
            Asserts.notNull(tracker, "Route tracker");
            Asserts.check(tracker.isConnected(), "Connection not open");
            Asserts.check(tracker.isTunnelled(), "Protocol layering without a tunnel not supported");
            Asserts.check(!tracker.isLayered(), "Multiple protocol layering not supported");
            targetHost = tracker.getTargetHost();
            operatedClientConnection = (OperatedClientConnection) this.poolEntry.getConnection();
        }
        this.operator.updateSecureConnection(operatedClientConnection, targetHost, httpContext, httpParams);
        synchronized (this) {
            try {
                if (this.poolEntry == null) {
                    throw new InterruptedIOException();
                }
                this.poolEntry.getTracker().layerProtocol(operatedClientConnection.isSecure());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void markReusable() {
        this.reusable = true;
    }

    public void open(HttpRoute httpRoute, HttpContext httpContext, HttpParams httpParams) throws IOException {
        OperatedClientConnection operatedClientConnection;
        Args.notNull(httpRoute, "Route");
        Args.notNull(httpParams, "HTTP parameters");
        synchronized (this) {
            if (this.poolEntry == null) {
                throw new ConnectionShutdownException();
            }
            Asserts.notNull(this.poolEntry.getTracker(), "Route tracker");
            Asserts.check(!r0.isConnected(), "Connection already open");
            operatedClientConnection = (OperatedClientConnection) this.poolEntry.getConnection();
        }
        HttpHost proxyHost = httpRoute.getProxyHost();
        this.operator.openConnection(operatedClientConnection, proxyHost != null ? proxyHost : httpRoute.getTargetHost(), httpRoute.getLocalAddress(), httpContext, httpParams);
        synchronized (this) {
            try {
                if (this.poolEntry == null) {
                    throw new InterruptedIOException();
                }
                RouteTracker tracker = this.poolEntry.getTracker();
                if (proxyHost == null) {
                    tracker.connectTarget(operatedClientConnection.isSecure());
                } else {
                    tracker.connectProxy(proxyHost, operatedClientConnection.isSecure());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        ensureConnection().receiveResponseEntity(httpResponse);
    }

    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        return ensureConnection().receiveResponseHeader();
    }

    public void releaseConnection() {
        synchronized (this) {
            try {
                if (this.poolEntry == null) {
                    return;
                }
                this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
                this.poolEntry = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object removeAttribute(String str) {
        OperatedClientConnection ensureConnection = ensureConnection();
        if (ensureConnection instanceof HttpContext) {
            return ((HttpContext) ensureConnection).removeAttribute(str);
        }
        return null;
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        ensureConnection().sendRequestEntity(httpEntityEnclosingRequest);
    }

    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        ensureConnection().sendRequestHeader(httpRequest);
    }

    public void setAttribute(String str, Object obj) {
        OperatedClientConnection ensureConnection = ensureConnection();
        if (ensureConnection instanceof HttpContext) {
            ((HttpContext) ensureConnection).setAttribute(str, obj);
        }
    }

    public void setIdleDuration(long j, TimeUnit timeUnit) {
        this.duration = j > 0 ? timeUnit.toMillis(j) : -1L;
    }

    public void setSocketTimeout(int i) {
        ensureConnection().setSocketTimeout(i);
    }

    public void setState(Object obj) {
        ensurePoolEntry().setState(obj);
    }

    public void shutdown() throws IOException {
        HttpPoolEntry httpPoolEntry = this.poolEntry;
        if (httpPoolEntry != null) {
            OperatedClientConnection operatedClientConnection = (OperatedClientConnection) httpPoolEntry.getConnection();
            httpPoolEntry.getTracker().reset();
            operatedClientConnection.shutdown();
        }
    }

    public void tunnelProxy(HttpHost httpHost, boolean z, HttpParams httpParams) throws IOException {
        OperatedClientConnection operatedClientConnection;
        Args.notNull(httpHost, "Next proxy");
        Args.notNull(httpParams, "HTTP parameters");
        synchronized (this) {
            if (this.poolEntry == null) {
                throw new ConnectionShutdownException();
            }
            RouteTracker tracker = this.poolEntry.getTracker();
            Asserts.notNull(tracker, "Route tracker");
            Asserts.check(tracker.isConnected(), "Connection not open");
            operatedClientConnection = (OperatedClientConnection) this.poolEntry.getConnection();
        }
        operatedClientConnection.update(null, httpHost, z, httpParams);
        synchronized (this) {
            try {
                if (this.poolEntry == null) {
                    throw new InterruptedIOException();
                }
                this.poolEntry.getTracker().tunnelProxy(httpHost, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void tunnelTarget(boolean z, HttpParams httpParams) throws IOException {
        HttpHost targetHost;
        OperatedClientConnection operatedClientConnection;
        Args.notNull(httpParams, "HTTP parameters");
        synchronized (this) {
            if (this.poolEntry == null) {
                throw new ConnectionShutdownException();
            }
            RouteTracker tracker = this.poolEntry.getTracker();
            Asserts.notNull(tracker, "Route tracker");
            Asserts.check(tracker.isConnected(), "Connection not open");
            Asserts.check(!tracker.isTunnelled(), "Connection is already tunnelled");
            targetHost = tracker.getTargetHost();
            operatedClientConnection = (OperatedClientConnection) this.poolEntry.getConnection();
        }
        operatedClientConnection.update(null, targetHost, z, httpParams);
        synchronized (this) {
            try {
                if (this.poolEntry == null) {
                    throw new InterruptedIOException();
                }
                this.poolEntry.getTracker().tunnelTarget(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unmarkReusable() {
        this.reusable = false;
    }
}
