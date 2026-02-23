package org.apache.http.impl.cookie;

import java.util.Locale;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.CommonCookieAttributeHandler;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieRestrictionViolationException;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RFC2965DomainAttributeHandler implements CommonCookieAttributeHandler {
    public boolean domainMatch(String str, String str2) {
        return str.equals(str2) || (str2.startsWith(".") && str.endsWith(str2));
    }

    public String getAttributeName() {
        return "domain";
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String lowerCase = cookieOrigin.getHost().toLowerCase(Locale.ROOT);
        String domain = cookie.getDomain();
        return domainMatch(lowerCase, domain) && lowerCase.substring(0, lowerCase.length() - domain.length()).indexOf(46) == -1;
    }

    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        }
        if (str.trim().isEmpty()) {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        if (!str.startsWith(".")) {
            lowerCase = '.' + lowerCase;
        }
        setCookie.setDomain(lowerCase);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String host = cookieOrigin.getHost();
        Locale locale = Locale.ROOT;
        String lowerCase = host.toLowerCase(locale);
        if (cookie.getDomain() == null) {
            throw new CookieRestrictionViolationException("Invalid cookie state: domain not specified");
        }
        String lowerCase2 = cookie.getDomain().toLowerCase(locale);
        if (!(cookie instanceof ClientCookie) || !((ClientCookie) cookie).containsAttribute("domain")) {
            if (cookie.getDomain().equals(lowerCase)) {
                return;
            }
            throw new CookieRestrictionViolationException("Illegal domain attribute: \"" + cookie.getDomain() + "\".Domain of origin: \"" + lowerCase + "\"");
        }
        if (!lowerCase2.startsWith(".")) {
            throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
        }
        int indexOf = lowerCase2.indexOf(46, 1);
        if ((indexOf < 0 || indexOf == lowerCase2.length() - 1) && !lowerCase2.equals(".local")) {
            throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: the value contains no embedded dots and the value is not .local");
        }
        if (!domainMatch(lowerCase, lowerCase2)) {
            throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: effective host name does not domain-match domain attribute.");
        }
        if (lowerCase.substring(0, lowerCase.length() - lowerCase2.length()).indexOf(46) == -1) {
            return;
        }
        throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: effective host minus domain may not contain any dots");
    }
}
