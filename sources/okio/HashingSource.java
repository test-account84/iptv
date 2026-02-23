package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import k8.q;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashingSource hmacSha1(@NotNull Source source, @NotNull ByteString key) {
            l.e(source, "source");
            l.e(key, "key");
            return new HashingSource(source, key, "HmacSHA1");
        }

        @NotNull
        public final HashingSource hmacSha256(@NotNull Source source, @NotNull ByteString key) {
            l.e(source, "source");
            l.e(key, "key");
            return new HashingSource(source, key, "HmacSHA256");
        }

        @NotNull
        public final HashingSource hmacSha512(@NotNull Source source, @NotNull ByteString key) {
            l.e(source, "source");
            l.e(key, "key");
            return new HashingSource(source, key, "HmacSHA512");
        }

        @NotNull
        public final HashingSource md5(@NotNull Source source) {
            l.e(source, "source");
            return new HashingSource(source, "MD5");
        }

        @NotNull
        public final HashingSource sha1(@NotNull Source source) {
            l.e(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        @NotNull
        public final HashingSource sha256(@NotNull Source source) {
            l.e(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        @NotNull
        public final HashingSource sha512(@NotNull Source source) {
            l.e(source, "source");
            return new HashingSource(source, "SHA-512");
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull String algorithm) {
        super(source);
        l.e(source, "source");
        l.e(algorithm, "algorithm");
        this.messageDigest = MessageDigest.getInstance(algorithm);
        this.mac = null;
    }

    @NotNull
    public static final HashingSource hmacSha1(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    @NotNull
    public static final HashingSource hmacSha256(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    @NotNull
    public static final HashingSource hmacSha512(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    @NotNull
    public static final HashingSource md5(@NotNull Source source) {
        return Companion.md5(source);
    }

    @NotNull
    public static final HashingSource sha1(@NotNull Source source) {
        return Companion.sha1(source);
    }

    @NotNull
    public static final HashingSource sha256(@NotNull Source source) {
        return Companion.sha256(source);
    }

    @NotNull
    public static final HashingSource sha512(@NotNull Source source) {
        return Companion.sha512(source);
    }

    @NotNull
    public final ByteString -deprecated_hash() {
        return hash();
    }

    @NotNull
    public final ByteString hash() {
        byte[] result;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            l.b(mac);
            result = mac.doFinal();
        }
        l.d(result, "result");
        return new ByteString(result);
    }

    public long read(@NotNull Buffer sink, long j) throws IOException {
        l.e(sink, "sink");
        long read = super.read(sink, j);
        if (read != -1) {
            long size = sink.size() - read;
            long size2 = sink.size();
            Segment segment = sink.head;
            l.b(segment);
            while (size2 > size) {
                segment = segment.prev;
                l.b(segment);
                size2 -= segment.limit - segment.pos;
            }
            while (size2 < sink.size()) {
                int i = (int) ((segment.pos + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i, segment.limit - i);
                } else {
                    Mac mac = this.mac;
                    l.b(mac);
                    mac.update(segment.data, i, segment.limit - i);
                }
                size2 += segment.limit - segment.pos;
                segment = segment.next;
                l.b(segment);
                size = size2;
            }
        }
        return read;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull ByteString key, @NotNull String algorithm) {
        super(source);
        l.e(source, "source");
        l.e(key, "key");
        l.e(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            q qVar = q.a;
            this.mac = mac;
            this.messageDigest = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
