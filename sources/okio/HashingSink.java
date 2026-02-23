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
public final class HashingSink extends ForwardingSink {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString key) {
            l.e(sink, "sink");
            l.e(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @NotNull
        public final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString key) {
            l.e(sink, "sink");
            l.e(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @NotNull
        public final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString key) {
            l.e(sink, "sink");
            l.e(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }

        @NotNull
        public final HashingSink md5(@NotNull Sink sink) {
            l.e(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @NotNull
        public final HashingSink sha1(@NotNull Sink sink) {
            l.e(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @NotNull
        public final HashingSink sha256(@NotNull Sink sink) {
            l.e(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @NotNull
        public final HashingSink sha512(@NotNull Sink sink) {
            l.e(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull String algorithm) {
        super(sink);
        l.e(sink, "sink");
        l.e(algorithm, "algorithm");
        this.messageDigest = MessageDigest.getInstance(algorithm);
        this.mac = null;
    }

    @NotNull
    public static final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    @NotNull
    public static final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    @NotNull
    public static final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    @NotNull
    public static final HashingSink md5(@NotNull Sink sink) {
        return Companion.md5(sink);
    }

    @NotNull
    public static final HashingSink sha1(@NotNull Sink sink) {
        return Companion.sha1(sink);
    }

    @NotNull
    public static final HashingSink sha256(@NotNull Sink sink) {
        return Companion.sha256(sink);
    }

    @NotNull
    public static final HashingSink sha512(@NotNull Sink sink) {
        return Companion.sha512(sink);
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

    public void write(@NotNull Buffer source, long j) throws IOException {
        l.e(source, "source");
        -Util.checkOffsetAndCount(source.size(), 0L, j);
        Segment segment = source.head;
        l.b(segment);
        long j2 = 0;
        while (j2 < j) {
            int min = (int) Math.min(j - j2, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, min);
            } else {
                Mac mac = this.mac;
                l.b(mac);
                mac.update(segment.data, segment.pos, min);
            }
            j2 += min;
            segment = segment.next;
            l.b(segment);
        }
        super.write(source, j);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull ByteString key, @NotNull String algorithm) {
        super(sink);
        l.e(sink, "sink");
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
