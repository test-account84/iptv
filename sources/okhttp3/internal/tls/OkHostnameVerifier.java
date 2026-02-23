package okhttp3.internal.tls;

import E8.n;
import E8.o;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.jvm.internal.l;
import l8.k;
import l8.s;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale locale = Locale.US;
        l.d(locale, "Locale.US");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        l.d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final List getSubjectAltNames(X509Certificate x509Certificate, int i) {
        Object obj;
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return k.f();
            }
            ArrayList arrayList = new ArrayList();
            for (List list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!l.a(list.get(0), Integer.valueOf(i))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return k.f();
        }
    }

    private final boolean isAscii(String str) {
        return str.length() == ((int) Utf8.size$default(str, 0, 0, 3, null));
    }

    private final boolean verifyHostname(String str, String str2) {
        if (str != null && str.length() != 0 && !n.B(str, ".", false, 2, null) && !n.n(str, "..", false, 2, null) && str2 != null && str2.length() != 0 && !n.B(str2, ".", false, 2, null) && !n.n(str2, "..", false, 2, null)) {
            if (!n.n(str, ".", false, 2, null)) {
                str = str + ".";
            }
            String str3 = str;
            if (!n.n(str2, ".", false, 2, null)) {
                str2 = str2 + ".";
            }
            String asciiToLowercase = asciiToLowercase(str2);
            if (!o.G(asciiToLowercase, "*", false, 2, null)) {
                return l.a(str3, asciiToLowercase);
            }
            if (!n.B(asciiToLowercase, "*.", false, 2, null) || o.Q(asciiToLowercase, '*', 1, false, 4, null) != -1 || str3.length() < asciiToLowercase.length() || l.a("*.", asciiToLowercase)) {
                return false;
            }
            String substring = asciiToLowercase.substring(1);
            l.d(substring, "(this as java.lang.String).substring(startIndex)");
            if (!n.n(str3, substring, false, 2, null)) {
                return false;
            }
            int length = str3.length() - substring.length();
            return length <= 0 || o.V(str3, '.', length + (-1), false, 4, null) == -1;
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = HostnamesKt.toCanonicalHost(str);
        Collection collection = (Iterable) getSubjectAltNames(x509Certificate, 7);
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return false;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (l.a(canonicalHost, HostnamesKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List allSubjectAltNames(@NotNull X509Certificate certificate) {
        l.e(certificate, "certificate");
        return s.D(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
    }

    public final boolean verify(@NotNull String host, @NotNull X509Certificate certificate) {
        l.e(host, "host");
        l.e(certificate, "certificate");
        return Util.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        Collection collection = (Iterable) getSubjectAltNames(x509Certificate, 2);
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return false;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(asciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean verify(@NotNull String host, @NotNull SSLSession session) {
        l.e(host, "host");
        l.e(session, "session");
        if (!isAscii(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            if (certificate != null) {
                return verify(host, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
