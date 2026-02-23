package org.apache.http.cookie.params;

import java.util.Collection;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class CookieSpecParamBean extends HttpAbstractParamBean {
    public CookieSpecParamBean(HttpParams httpParams) {
        super(httpParams);
    }

    public void setDatePatterns(Collection collection) {
        this.params.setParameter("http.protocol.cookie-datepatterns", collection);
    }

    public void setSingleHeader(boolean z) {
        this.params.setBooleanParameter("http.protocol.single-cookie-header", z);
    }
}
