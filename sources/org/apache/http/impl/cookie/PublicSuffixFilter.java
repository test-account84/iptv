package org.apache.http.impl.cookie;

import java.util.Collection;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PublicSuffixFilter implements CookieAttributeHandler {
    private Collection exceptions;
    private PublicSuffixMatcher matcher;
    private Collection suffixes;
    private final CookieAttributeHandler wrapped;

    public PublicSuffixFilter(CookieAttributeHandler cookieAttributeHandler) {
        this.wrapped = cookieAttributeHandler;
    }

    private boolean isForPublicSuffix(Cookie cookie) {
        if (this.matcher == null) {
            this.matcher = new PublicSuffixMatcher(this.suffixes, this.exceptions);
        }
        return this.matcher.matches(cookie.getDomain());
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        if (isForPublicSuffix(cookie)) {
            return false;
        }
        return this.wrapped.match(cookie, cookieOrigin);
    }

    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        this.wrapped.parse(setCookie, str);
    }

    public void setExceptions(Collection collection) {
        this.exceptions = collection;
        this.matcher = null;
    }

    public void setPublicSuffixes(Collection collection) {
        this.suffixes = collection;
        this.matcher = null;
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        this.wrapped.validate(cookie, cookieOrigin);
    }
}
