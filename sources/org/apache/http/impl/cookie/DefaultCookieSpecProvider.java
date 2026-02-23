package org.apache.http.impl.cookie;

import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.cookie.CommonCookieAttributeHandler;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.protocol.HttpContext;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultCookieSpecProvider implements CookieSpecProvider {
    private final CompatibilityLevel compatibilityLevel;
    private volatile CookieSpec cookieSpec;
    private final String[] datepatterns;
    private final boolean oneHeader;
    private final PublicSuffixMatcher publicSuffixMatcher;

    public class 1 extends BasicPathHandler {
        public 1() {
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        }
    }

    public enum CompatibilityLevel {
        DEFAULT,
        IE_MEDIUM_SECURITY
    }

    public DefaultCookieSpecProvider() {
        this(CompatibilityLevel.DEFAULT, null, null, false);
    }

    public CookieSpec create(HttpContext httpContext) {
        if (this.cookieSpec == null) {
            synchronized (this) {
                try {
                    if (this.cookieSpec == null) {
                        RFC2965Spec rFC2965Spec = new RFC2965Spec(this.oneHeader, new RFC2965VersionAttributeHandler(), new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new RFC2965DomainAttributeHandler(), this.publicSuffixMatcher), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler());
                        RFC2109Spec rFC2109Spec = new RFC2109Spec(this.oneHeader, new RFC2109VersionHandler(), new BasicPathHandler(), PublicSuffixDomainFilter.decorate(new RFC2109DomainHandler(), this.publicSuffixMatcher), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler());
                        CommonCookieAttributeHandler decorate = PublicSuffixDomainFilter.decorate(new BasicDomainHandler(), this.publicSuffixMatcher);
                        CommonCookieAttributeHandler commonCookieAttributeHandler = this.compatibilityLevel == CompatibilityLevel.IE_MEDIUM_SECURITY ? new 1() : new BasicPathHandler();
                        BasicSecureHandler basicSecureHandler = new BasicSecureHandler();
                        BasicCommentHandler basicCommentHandler = new BasicCommentHandler();
                        String[] strArr = this.datepatterns;
                        this.cookieSpec = new DefaultCookieSpec(rFC2965Spec, rFC2109Spec, new NetscapeDraftSpec(decorate, commonCookieAttributeHandler, basicSecureHandler, basicCommentHandler, new BasicExpiresHandler(strArr != null ? (String[]) strArr.clone() : new String[]{"EEE, dd-MMM-yy HH:mm:ss z"})));
                    }
                } finally {
                }
            }
        }
        return this.cookieSpec;
    }

    public DefaultCookieSpecProvider(PublicSuffixMatcher publicSuffixMatcher) {
        this(CompatibilityLevel.DEFAULT, publicSuffixMatcher, null, false);
    }

    public DefaultCookieSpecProvider(CompatibilityLevel compatibilityLevel, PublicSuffixMatcher publicSuffixMatcher) {
        this(compatibilityLevel, publicSuffixMatcher, null, false);
    }

    public DefaultCookieSpecProvider(CompatibilityLevel compatibilityLevel, PublicSuffixMatcher publicSuffixMatcher, String[] strArr, boolean z) {
        this.compatibilityLevel = compatibilityLevel == null ? CompatibilityLevel.DEFAULT : compatibilityLevel;
        this.publicSuffixMatcher = publicSuffixMatcher;
        this.datepatterns = strArr;
        this.oneHeader = z;
    }
}
