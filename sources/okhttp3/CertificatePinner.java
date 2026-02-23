package okhttp3;

import E8.n;
import E8.o;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import l8.h;
import l8.k;
import l8.s;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class CertificatePinner {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final CertificatePinner DEFAULT = new Builder().build();

    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;

    @NotNull
    private final Set pins;

    public static final class Builder {

        @NotNull
        private final List pins = new ArrayList();

        @NotNull
        public final Builder add(@NotNull String pattern, @NotNull String... pins) {
            l.e(pattern, "pattern");
            l.e(pins, "pins");
            for (String str : pins) {
                this.pins.add(new Pin(pattern, str));
            }
            return this;
        }

        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(s.O(this.pins), null, 2, null);
        }

        @NotNull
        public final List getPins() {
            return this.pins;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String pin(@NotNull Certificate certificate) {
            l.e(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).base64();
        }

        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate sha1Hash) {
            l.e(sha1Hash, "$this$sha1Hash");
            ByteString.Companion companion = ByteString.Companion;
            PublicKey publicKey = sha1Hash.getPublicKey();
            l.d(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            l.d(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha1();
        }

        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate sha256Hash) {
            l.e(sha256Hash, "$this$sha256Hash");
            ByteString.Companion companion = ByteString.Companion;
            PublicKey publicKey = sha256Hash.getPublicKey();
            l.d(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            l.d(encoded, "publicKey.encoded");
            return ByteString.Companion.of$default(companion, encoded, 0, 0, 3, null).sha256();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public static final class Pin {

        @NotNull
        private final ByteString hash;

        @NotNull
        private final String hashAlgorithm;

        @NotNull
        private final String pattern;

        public Pin(@NotNull String pattern, @NotNull String pin) {
            ByteString decodeBase64;
            l.e(pattern, "pattern");
            l.e(pin, "pin");
            if (!((n.B(pattern, "*.", false, 2, null) && o.R(pattern, "*", 1, false, 4, null) == -1) || (n.B(pattern, "**.", false, 2, null) && o.R(pattern, "*", 2, false, 4, null) == -1) || o.R(pattern, "*", 0, false, 6, null) == -1)) {
                throw new IllegalArgumentException(("Unexpected pattern: " + pattern).toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(pattern);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("Invalid pattern: " + pattern);
            }
            this.pattern = canonicalHost;
            if (n.B(pin, "sha1/", false, 2, null)) {
                this.hashAlgorithm = "sha1";
                ByteString.Companion companion = ByteString.Companion;
                String substring = pin.substring(5);
                l.d(substring, "(this as java.lang.String).substring(startIndex)");
                decodeBase64 = companion.decodeBase64(substring);
                if (decodeBase64 == null) {
                    throw new IllegalArgumentException("Invalid pin hash: " + pin);
                }
            } else {
                if (!n.B(pin, "sha256/", false, 2, null)) {
                    throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + pin);
                }
                this.hashAlgorithm = "sha256";
                ByteString.Companion companion2 = ByteString.Companion;
                String substring2 = pin.substring(7);
                l.d(substring2, "(this as java.lang.String).substring(startIndex)");
                decodeBase64 = companion2.decodeBase64(substring2);
                if (decodeBase64 == null) {
                    throw new IllegalArgumentException("Invalid pin hash: " + pin);
                }
            }
            this.hash = decodeBase64;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) obj;
            return ((l.a(this.pattern, pin.pattern) ^ true) || (l.a(this.hashAlgorithm, pin.hashAlgorithm) ^ true) || (l.a(this.hash, pin.hash) ^ true)) ? false : true;
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(@NotNull X509Certificate certificate) {
            ByteString byteString;
            ByteString sha256Hash;
            l.e(certificate, "certificate");
            String str = this.hashAlgorithm;
            int hashCode = str.hashCode();
            if (hashCode == -903629273) {
                if (str.equals("sha256")) {
                    byteString = this.hash;
                    sha256Hash = CertificatePinner.Companion.sha256Hash(certificate);
                    return l.a(byteString, sha256Hash);
                }
                return false;
            }
            if (hashCode == 3528965 && str.equals("sha1")) {
                byteString = this.hash;
                sha256Hash = CertificatePinner.Companion.sha1Hash(certificate);
                return l.a(byteString, sha256Hash);
            }
            return false;
        }

        public final boolean matchesHostname(@NotNull String hostname) {
            l.e(hostname, "hostname");
            if (n.B(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                if (!n.s(hostname, hostname.length() - length, this.pattern, 3, length, false, 16, null)) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!n.B(this.pattern, "*.", false, 2, null)) {
                    return l.a(hostname, this.pattern);
                }
                int length3 = this.pattern.length() - 1;
                int length4 = hostname.length() - length3;
                if (!n.s(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, null) || o.V(hostname, '.', length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            }
            return true;
        }

        @NotNull
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }
    }

    public static final class 1 extends m implements w8.a {
        final /* synthetic */ String $hostname;
        final /* synthetic */ List $peerCertificates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 1(List list, String str) {
            super(0);
            this.$peerCertificates = list;
            this.$hostname = str;
        }

        @NotNull
        public final List invoke() {
            List list;
            CertificateChainCleaner certificateChainCleaner$okhttp = CertificatePinner.this.getCertificateChainCleaner$okhttp();
            if (certificateChainCleaner$okhttp == null || (list = certificateChainCleaner$okhttp.clean(this.$peerCertificates, this.$hostname)) == null) {
                list = this.$peerCertificates;
            }
            Iterable<X509Certificate> iterable = (Iterable) list;
            ArrayList arrayList = new ArrayList(l8.l.o(iterable, 10));
            for (X509Certificate x509Certificate : iterable) {
                if (x509Certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add(x509Certificate);
            }
            return arrayList;
        }
    }

    public CertificatePinner(@NotNull Set pins, @Nullable CertificateChainCleaner certificateChainCleaner) {
        l.e(pins, "pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    @NotNull
    public static final String pin(@NotNull Certificate certificate) {
        return Companion.pin(certificate);
    }

    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha1Hash(x509Certificate);
    }

    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate x509Certificate) {
        return Companion.sha256Hash(x509Certificate);
    }

    public final void check(@NotNull String hostname, @NotNull List peerCertificates) throws SSLPeerUnverifiedException {
        l.e(hostname, "hostname");
        l.e(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new 1(peerCertificates, hostname));
    }

    public final void check$okhttp(@NotNull String hostname, @NotNull w8.a cleanedPeerCertificatesFn) {
        l.e(hostname, "hostname");
        l.e(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> findMatchingPins = findMatchingPins(hostname);
        if (findMatchingPins.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : list) {
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (Pin pin : findMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                int hashCode = hashAlgorithm.hashCode();
                if (hashCode != -903629273) {
                    if (hashCode == 3528965 && hashAlgorithm.equals("sha1")) {
                        if (byteString2 == null) {
                            byteString2 = Companion.sha1Hash(x509Certificate);
                        }
                        if (l.a(pin.getHash(), byteString2)) {
                            return;
                        }
                    }
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                }
                if (!hashAlgorithm.equals("sha256")) {
                    throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                }
                if (byteString == null) {
                    byteString = Companion.sha256Hash(x509Certificate);
                }
                if (l.a(pin.getHash(), byteString)) {
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Certificate certificate = (X509Certificate) it.next();
            sb.append("\n    ");
            sb.append(Companion.pin(certificate));
            sb.append(": ");
            Principal subjectDN = certificate.getSubjectDN();
            l.d(subjectDN, "element.subjectDN");
            sb.append(subjectDN.getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (Pin pin2 : findMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String sb2 = sb.toString();
        l.d(sb2, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(sb2);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (l.a(certificatePinner.pins, this.pins) && l.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List findMatchingPins(@NotNull String hostname) {
        l.e(hostname, "hostname");
        Iterable iterable = this.pins;
        ArrayList f = k.f();
        for (Object obj : iterable) {
            if (((Pin) obj).matchesHostname(hostname)) {
                if (f.isEmpty()) {
                    f = new ArrayList();
                }
                F.a(f).add(obj);
            }
        }
        return f;
    }

    @Nullable
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    @NotNull
    public final Set getPins() {
        return this.pins;
    }

    public int hashCode() {
        int hashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return hashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner certificateChainCleaner) {
        l.e(certificateChainCleaner, "certificateChainCleaner");
        return l.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i, g gVar) {
        this(set, (i & 2) != 0 ? null : certificateChainCleaner);
    }

    public final void check(@NotNull String hostname, @NotNull Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        l.e(hostname, "hostname");
        l.e(peerCertificates, "peerCertificates");
        check(hostname, h.T(peerCertificates));
    }
}
