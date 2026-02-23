package org.apache.http.client.params;

import java.util.Collection;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ClientParamBean extends HttpAbstractParamBean {
    public ClientParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setAllowCircularRedirects(boolean z) {
        this.params.setBooleanParameter("http.protocol.allow-circular-redirects", z);
    }

    @Deprecated
    public void setConnectionManagerFactoryClassName(String str) {
        this.params.setParameter("http.connection-manager.factory-class-name", str);
    }

    public void setConnectionManagerTimeout(long j) {
        this.params.setLongParameter("http.conn-manager.timeout", j);
    }

    public void setCookiePolicy(String str) {
        this.params.setParameter("http.protocol.cookie-policy", str);
    }

    public void setDefaultHeaders(Collection collection) {
        this.params.setParameter("http.default-headers", collection);
    }

    public void setDefaultHost(HttpHost httpHost) {
        this.params.setParameter("http.default-host", httpHost);
    }

    public void setHandleAuthentication(boolean z) {
        this.params.setBooleanParameter("http.protocol.handle-authentication", z);
    }

    public void setHandleRedirects(boolean z) {
        this.params.setBooleanParameter("http.protocol.handle-redirects", z);
    }

    public void setMaxRedirects(int i) {
        this.params.setIntParameter("http.protocol.max-redirects", i);
    }

    public void setRejectRelativeRedirect(boolean z) {
        this.params.setBooleanParameter("http.protocol.reject-relative-redirect", z);
    }

    public void setVirtualHost(HttpHost httpHost) {
        this.params.setParameter("http.virtual-host", httpHost);
    }
}
