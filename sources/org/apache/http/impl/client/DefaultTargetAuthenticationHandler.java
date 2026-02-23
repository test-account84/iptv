package org.apache.http.impl.client;

import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultTargetAuthenticationHandler extends AbstractAuthenticationHandler {
    public List getAuthPreferences(HttpResponse httpResponse, HttpContext httpContext) {
        List list = (List) httpResponse.getParams().getParameter("http.auth.target-scheme-pref");
        return list != null ? list : super.getAuthPreferences(httpResponse, httpContext);
    }

    public Map getChallenges(HttpResponse httpResponse, HttpContext httpContext) throws MalformedChallengeException {
        Args.notNull(httpResponse, "HTTP response");
        return parseChallenges(httpResponse.getHeaders("WWW-Authenticate"));
    }

    public boolean isAuthenticationRequested(HttpResponse httpResponse, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        return httpResponse.getStatusLine().getStatusCode() == 401;
    }
}
