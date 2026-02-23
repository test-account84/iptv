package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import k8.f;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import l8.k;
import l8.s;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Handshake {
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final CipherSuite cipherSuite;

    @NotNull
    private final List localCertificates;

    @NotNull
    private final f peerCertificates$delegate;

    @NotNull
    private final TlsVersion tlsVersion;

    public static final class Companion {
        private Companion() {
        }

        private final List toImmutableList(Certificate[] certificateArr) {
            return certificateArr != null ? Util.immutableListOf((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : k.f();
        }

        @NotNull
        public final Handshake -deprecated_get(@NotNull SSLSession sslSession) throws IOException {
            l.e(sslSession, "sslSession");
            return get(sslSession);
        }

        @NotNull
        public final Handshake get(@NotNull SSLSession handshake) throws IOException {
            List f;
            l.e(handshake, "$this$handshake");
            String cipherSuite = handshake.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            int hashCode = cipherSuite.hashCode();
            if (hashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : hashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            CipherSuite forJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
            String protocol = handshake.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (l.a("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion forJavaName2 = TlsVersion.Companion.forJavaName(protocol);
            try {
                f = toImmutableList(handshake.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                f = k.f();
            }
            return new Handshake(forJavaName2, forJavaName, toImmutableList(handshake.getLocalCertificates()), new Handshake$Companion$handshake$1(f));
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        @NotNull
        public final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List peerCertificates, @NotNull List localCertificates) {
            l.e(tlsVersion, "tlsVersion");
            l.e(cipherSuite, "cipherSuite");
            l.e(peerCertificates, "peerCertificates");
            l.e(localCertificates, "localCertificates");
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(localCertificates), new Handshake$Companion$get$1(Util.toImmutableList(peerCertificates)));
        }
    }

    public static final class 2 extends m implements w8.a {
        final /* synthetic */ w8.a $peerCertificatesFn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public 2(w8.a aVar) {
            super(0);
            this.$peerCertificatesFn = aVar;
        }

        @NotNull
        public final List invoke() {
            try {
                return (List) this.$peerCertificatesFn.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return k.f();
            }
        }
    }

    public Handshake(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List localCertificates, @NotNull w8.a peerCertificatesFn) {
        l.e(tlsVersion, "tlsVersion");
        l.e(cipherSuite, "cipherSuite");
        l.e(localCertificates, "localCertificates");
        l.e(peerCertificatesFn, "peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates$delegate = k8.g.a(new 2(peerCertificatesFn));
    }

    @NotNull
    public static final Handshake get(@NotNull SSLSession sSLSession) throws IOException {
        return Companion.get(sSLSession);
    }

    private final String getName(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        l.d(type, "type");
        return type;
    }

    @NotNull
    public final CipherSuite -deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @NotNull
    public final List -deprecated_localCertificates() {
        return this.localCertificates;
    }

    @Nullable
    public final Principal -deprecated_localPrincipal() {
        return localPrincipal();
    }

    @NotNull
    public final List -deprecated_peerCertificates() {
        return peerCertificates();
    }

    @Nullable
    public final Principal -deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    @NotNull
    public final TlsVersion -deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @NotNull
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.tlsVersion == this.tlsVersion && l.a(handshake.cipherSuite, this.cipherSuite) && l.a(handshake.peerCertificates(), peerCertificates()) && l.a(handshake.localCertificates, this.localCertificates)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.tlsVersion.hashCode()) * 31) + this.cipherSuite.hashCode()) * 31) + peerCertificates().hashCode()) * 31) + this.localCertificates.hashCode();
    }

    @NotNull
    public final List localCertificates() {
        return this.localCertificates;
    }

    @Nullable
    public final Principal localPrincipal() {
        Object w = s.w(this.localCertificates);
        if (!(w instanceof X509Certificate)) {
            w = null;
        }
        X509Certificate x509Certificate = (X509Certificate) w;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    @NotNull
    public final List peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    @Nullable
    public final Principal peerPrincipal() {
        Object w = s.w(peerCertificates());
        if (!(w instanceof X509Certificate)) {
            w = null;
        }
        X509Certificate x509Certificate = (X509Certificate) w;
        if (x509Certificate != null) {
            return x509Certificate.getSubjectX500Principal();
        }
        return null;
    }

    @NotNull
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    @NotNull
    public String toString() {
        Iterable peerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(l8.l.o(peerCertificates, 10));
        Iterator it = peerCertificates.iterator();
        while (it.hasNext()) {
            arrayList.add(getName((Certificate) it.next()));
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{");
        sb.append("tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(' ');
        sb.append("cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(' ');
        sb.append("peerCertificates=");
        sb.append(obj);
        sb.append(' ');
        sb.append("localCertificates=");
        Iterable iterable = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(l8.l.o(iterable, 10));
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList2.add(getName((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }

    @NotNull
    public static final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List list, @NotNull List list2) {
        return Companion.get(tlsVersion, cipherSuite, list, list2);
    }
}
