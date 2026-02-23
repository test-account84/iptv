package org.apache.http.params;

import java.util.HashSet;
import java.util.Set;
import org.apache.http.util.Args;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class DefaultedHttpParams extends AbstractHttpParams {
    private final HttpParams defaults;
    private final HttpParams local;

    public DefaultedHttpParams(HttpParams httpParams, HttpParams httpParams2) {
        this.local = (HttpParams) Args.notNull(httpParams, "Local HTTP parameters");
        this.defaults = httpParams2;
    }

    public HttpParams copy() {
        return new DefaultedHttpParams(this.local.copy(), this.defaults);
    }

    public Set getDefaultNames() {
        return new HashSet(getNames(this.defaults));
    }

    public HttpParams getDefaults() {
        return this.defaults;
    }

    public Set getLocalNames() {
        return new HashSet(getNames(this.local));
    }

    public Set getNames() {
        HashSet hashSet = new HashSet(getNames(this.defaults));
        hashSet.addAll(getNames(this.local));
        return hashSet;
    }

    public Object getParameter(String str) {
        HttpParams httpParams;
        Object parameter = this.local.getParameter(str);
        return (parameter != null || (httpParams = this.defaults) == null) ? parameter : httpParams.getParameter(str);
    }

    public boolean removeParameter(String str) {
        return this.local.removeParameter(str);
    }

    public HttpParams setParameter(String str, Object obj) {
        return this.local.setParameter(str, obj);
    }

    private Set getNames(HttpParams httpParams) {
        if (httpParams instanceof HttpParamsNames) {
            return ((HttpParamsNames) httpParams).getNames();
        }
        throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
    }
}
