package org.apache.http.impl.bootstrap;

import java.io.IOException;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpServerConnection;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.protocol.HttpService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Worker implements Runnable {
    private final HttpServerConnection conn;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpservice;

    public Worker(HttpService httpService, HttpServerConnection httpServerConnection, ExceptionLogger exceptionLogger) {
        this.httpservice = httpService;
        this.conn = httpServerConnection;
        this.exceptionLogger = exceptionLogger;
    }

    public HttpServerConnection getConnection() {
        return this.conn;
    }

    public void run() {
        try {
            try {
                try {
                    BasicHttpContext basicHttpContext = new BasicHttpContext();
                    HttpCoreContext adapt = HttpCoreContext.adapt(basicHttpContext);
                    while (!Thread.interrupted() && this.conn.isOpen()) {
                        this.httpservice.handleRequest(this.conn, adapt);
                        basicHttpContext.clear();
                    }
                    this.conn.close();
                    this.conn.shutdown();
                } catch (Throwable th) {
                    try {
                        this.conn.shutdown();
                    } catch (IOException e) {
                        this.exceptionLogger.log(e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.exceptionLogger.log(e2);
                this.conn.shutdown();
            }
        } catch (IOException e3) {
            this.exceptionLogger.log(e3);
        }
    }
}
