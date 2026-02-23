package org.apache.http.impl.cookie;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.util.PublicSuffixList;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.cookie.CommonCookieAttributeHandler;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PublicSuffixDomainFilter implements CommonCookieAttributeHandler {
    private final CommonCookieAttributeHandler handler;
    private final Map localDomainMap;
    private final PublicSuffixMatcher publicSuffixMatcher;

    public PublicSuffixDomainFilter(CommonCookieAttributeHandler commonCookieAttributeHandler, PublicSuffixList publicSuffixList) {
        Args.notNull(commonCookieAttributeHandler, "Cookie handler");
        Args.notNull(publicSuffixList, "Public suffix list");
        this.handler = commonCookieAttributeHandler;
        this.publicSuffixMatcher = new PublicSuffixMatcher(publicSuffixList.getRules(), publicSuffixList.getExceptions());
        this.localDomainMap = createLocalDomainMap();
    }

    private static Map createLocalDomainMap() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Boolean bool = Boolean.TRUE;
        concurrentHashMap.put(".localhost.", bool);
        concurrentHashMap.put(".test.", bool);
        concurrentHashMap.put(".local.", bool);
        concurrentHashMap.put(".local", bool);
        concurrentHashMap.put(".localdomain", bool);
        return concurrentHashMap;
    }

    public static CommonCookieAttributeHandler decorate(CommonCookieAttributeHandler commonCookieAttributeHandler, PublicSuffixMatcher publicSuffixMatcher) {
        Args.notNull(commonCookieAttributeHandler, "Cookie attribute handler");
        return publicSuffixMatcher != null ? new PublicSuffixDomainFilter(commonCookieAttributeHandler, publicSuffixMatcher) : commonCookieAttributeHandler;
    }

    public String getAttributeName() {
        return this.handler.getAttributeName();
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        String domain = cookie.getDomain();
        if (domain == null) {
            return false;
        }
        int indexOf = domain.indexOf(46);
        if (indexOf >= 0) {
            if (!this.localDomainMap.containsKey(domain.substring(indexOf)) && this.publicSuffixMatcher.matches(domain)) {
                return false;
            }
        } else if (!domain.equalsIgnoreCase(cookieOrigin.getHost()) && this.publicSuffixMatcher.matches(domain)) {
            return false;
        }
        return this.handler.match(cookie, cookieOrigin);
    }

    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        this.handler.parse(setCookie, str);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        this.handler.validate(cookie, cookieOrigin);
    }

    public PublicSuffixDomainFilter(CommonCookieAttributeHandler commonCookieAttributeHandler, PublicSuffixMatcher publicSuffixMatcher) {
        this.handler = (CommonCookieAttributeHandler) Args.notNull(commonCookieAttributeHandler, "Cookie handler");
        this.publicSuffixMatcher = (PublicSuffixMatcher) Args.notNull(publicSuffixMatcher, "Public suffix matcher");
        this.localDomainMap = createLocalDomainMap();
    }
}
