package org.apache.http.impl.cookie;

import java.util.Iterator;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie2;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultCookieSpec implements CookieSpec {
    private final NetscapeDraftSpec netscapeDraft;
    private final RFC2109Spec obsoleteStrict;
    private final RFC2965Spec strict;

    public DefaultCookieSpec() {
        this(null, false);
    }

    public List formatCookies(List list) {
        Args.notNull(list, "List of cookies");
        Iterator it = list.iterator();
        int i = Integer.MAX_VALUE;
        boolean z = true;
        while (it.hasNext()) {
            Cookie cookie = (Cookie) it.next();
            if (!(cookie instanceof SetCookie2)) {
                z = false;
            }
            if (cookie.getVersion() < i) {
                i = cookie.getVersion();
            }
        }
        return i > 0 ? z ? this.strict.formatCookies(list) : this.obsoleteStrict.formatCookies(list) : this.netscapeDraft.formatCookies(list);
    }

    public int getVersion() {
        return this.strict.getVersion();
    }

    public Header getVersionHeader() {
        return null;
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        return cookie.getVersion() > 0 ? cookie instanceof SetCookie2 ? this.strict.match(cookie, cookieOrigin) : this.obsoleteStrict.match(cookie, cookieOrigin) : this.netscapeDraft.match(cookie, cookieOrigin);
    }

    public List parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        CharArrayBuffer charArrayBuffer;
        ParserCursor parserCursor;
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        HeaderElement[] elements = header.getElements();
        boolean z = false;
        boolean z2 = false;
        for (HeaderElement headerElement : elements) {
            if (headerElement.getParameterByName("version") != null) {
                z2 = true;
            }
            if (headerElement.getParameterByName("expires") != null) {
                z = true;
            }
        }
        if (!z && z2) {
            return "Set-Cookie2".equals(header.getName()) ? this.strict.parse(elements, cookieOrigin) : this.obsoleteStrict.parse(elements, cookieOrigin);
        }
        NetscapeDraftHeaderParser netscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
        if (header instanceof FormattedHeader) {
            FormattedHeader formattedHeader = (FormattedHeader) header;
            charArrayBuffer = formattedHeader.getBuffer();
            parserCursor = new ParserCursor(formattedHeader.getValuePos(), charArrayBuffer.length());
        } else {
            String value = header.getValue();
            if (value == null) {
                throw new MalformedCookieException("Header value is null");
            }
            charArrayBuffer = new CharArrayBuffer(value.length());
            charArrayBuffer.append(value);
            parserCursor = new ParserCursor(0, charArrayBuffer.length());
        }
        return this.netscapeDraft.parse(new HeaderElement[]{netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor)}, cookieOrigin);
    }

    public String toString() {
        return "default";
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (cookie.getVersion() <= 0) {
            this.netscapeDraft.validate(cookie, cookieOrigin);
        } else if (cookie instanceof SetCookie2) {
            this.strict.validate(cookie, cookieOrigin);
        } else {
            this.obsoleteStrict.validate(cookie, cookieOrigin);
        }
    }

    public DefaultCookieSpec(RFC2965Spec rFC2965Spec, RFC2109Spec rFC2109Spec, NetscapeDraftSpec netscapeDraftSpec) {
        this.strict = rFC2965Spec;
        this.obsoleteStrict = rFC2109Spec;
        this.netscapeDraft = netscapeDraftSpec;
    }

    public DefaultCookieSpec(String[] strArr, boolean z) {
        this.strict = new RFC2965Spec(z, new RFC2965VersionAttributeHandler(), new BasicPathHandler(), new RFC2965DomainAttributeHandler(), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler());
        this.obsoleteStrict = new RFC2109Spec(z, new RFC2109VersionHandler(), new BasicPathHandler(), new RFC2109DomainHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler());
        this.netscapeDraft = new NetscapeDraftSpec(new BasicDomainHandler(), new BasicPathHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new BasicExpiresHandler(strArr != null ? (String[]) strArr.clone() : new String[]{"EEE, dd-MMM-yy HH:mm:ss z"}));
    }
}
