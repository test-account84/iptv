package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final Map hostnameToPins;

    public static final class Builder {
        private final Map hostnameToPins = new LinkedHashMap();

        public static /* synthetic */ Map access$000(Builder builder) {
            return builder.hostnameToPins;
        }

        public Builder add(String str, String... strArr) {
            if (str == null) {
                throw new IllegalArgumentException("hostname == null");
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Set set = (Set) this.hostnameToPins.put(str, Collections.unmodifiableSet(linkedHashSet));
            if (set != null) {
                linkedHashSet.addAll(set);
            }
            for (String str2 : strArr) {
                if (!str2.startsWith("sha1/")) {
                    throw new IllegalArgumentException("pins must start with 'sha1/': " + str2);
                }
                ByteString decodeBase64 = ByteString.decodeBase64(str2.substring(5));
                if (decodeBase64 == null) {
                    throw new IllegalArgumentException("pins must be base64: " + str2);
                }
                linkedHashSet.add(decodeBase64);
            }
            return this;
        }

        public CertificatePinner build() {
            return new CertificatePinner(this, null);
        }
    }

    private CertificatePinner(Builder builder) {
        this.hostnameToPins = Util.immutableMap(Builder.access$000(builder));
    }

    public static String pin(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha1/" + sha1((X509Certificate) certificate).base64();
    }

    private static ByteString sha1(X509Certificate x509Certificate) {
        return Util.sha1(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }

    public void check(String str, List list) throws SSLPeerUnverifiedException {
        Set<ByteString> findMatchingPins = findMatchingPins(str);
        if (findMatchingPins == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (findMatchingPins.contains(sha1((X509Certificate) list.get(i)))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            sb.append("\n    ");
            sb.append(pin(x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        for (ByteString byteString : findMatchingPins) {
            sb.append("\n    sha1/");
            sb.append(byteString.base64());
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public Set findMatchingPins(String str) {
        Set set;
        Set set2 = (Set) this.hostnameToPins.get(str);
        int indexOf = str.indexOf(46);
        if (indexOf != str.lastIndexOf(46)) {
            set = (Set) this.hostnameToPins.get("*." + str.substring(indexOf + 1));
        } else {
            set = null;
        }
        if (set2 == null && set == null) {
            return null;
        }
        if (set2 == null || set == null) {
            return set2 != null ? set2 : set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set2);
        linkedHashSet.addAll(set);
        return linkedHashSet;
    }

    public /* synthetic */ CertificatePinner(Builder builder, 1 r2) {
        this(builder);
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }
}
