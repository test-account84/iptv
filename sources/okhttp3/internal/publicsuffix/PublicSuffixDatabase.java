package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import k8.q;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.o;
import l8.j;
import l8.k;
import l8.s;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u8.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';

    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {(byte) 42};
    private static final List PREVAILING_RULE = j.b("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$binarySearch(Companion companion, byte[] bArr, byte[][] bArr2, int i) {
            return companion.binarySearch(bArr, bArr2, i);
        }

        private final String binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int and;
            boolean z;
            int and2;
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = (i3 + length) / 2;
                while (i4 > -1 && bArr[i4] != ((byte) 10)) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (bArr[i2] == ((byte) 10)) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        and = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        and = Util.and(bArr2[i8][i9], 255);
                        z = z3;
                    }
                    and2 = and - Util.and(bArr[i5 + i10], 255);
                    if (and2 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    }
                    if (bArr2[i8].length != i9) {
                        z2 = z;
                    } else {
                        if (i8 == bArr2.length - 1) {
                            break;
                        }
                        i8++;
                        z2 = true;
                        i9 = -1;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i11 = i7 - i10;
                        int length2 = bArr2[i8].length - i9;
                        int length3 = bArr2.length;
                        for (int i12 = i8 + 1; i12 < length3; i12++) {
                            length2 += bArr2[i12].length;
                        }
                        if (length2 >= i11) {
                            if (length2 <= i11) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                l.d(UTF_8, "UTF_8");
                                return new String(bArr, i5, i7, UTF_8);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                length = i4;
            }
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.access$getInstance$cp();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    final /* synthetic */ class 1 extends o {
        public 1(PublicSuffixDatabase publicSuffixDatabase) {
            super(publicSuffixDatabase, PublicSuffixDatabase.class, "publicSuffixListBytes", "getPublicSuffixListBytes()[B", 0);
        }

        @Nullable
        public Object get() {
            return PublicSuffixDatabase.access$getPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver);
        }

        public void set(@Nullable Object obj) {
            PublicSuffixDatabase.access$setPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver, (byte[]) obj);
        }
    }

    public static final /* synthetic */ PublicSuffixDatabase access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase publicSuffixDatabase) {
        byte[] bArr = publicSuffixDatabase.publicSuffixListBytes;
        if (bArr == null) {
            l.s("publicSuffixListBytes");
        }
        return bArr;
    }

    public static final /* synthetic */ void access$setPublicSuffixListBytes$p(PublicSuffixDatabase publicSuffixDatabase, byte[] bArr) {
        publicSuffixDatabase.publicSuffixListBytes = bArr;
    }

    private final List findMatchingRule(List list) {
        String str;
        String str2;
        String str3;
        List f;
        List f2;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (!(this.publicSuffixListBytes != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i < size; i++) {
            String str4 = (String) list.get(i);
            Charset UTF_8 = StandardCharsets.UTF_8;
            l.d(UTF_8, "UTF_8");
            if (str4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str4.getBytes(UTF_8);
            l.d(bytes, "(this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= size) {
                str2 = null;
                break;
            }
            Companion companion = Companion;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                l.s("publicSuffixListBytes");
            }
            str2 = Companion.access$binarySearch(companion, bArr2, bArr, i2);
            if (str2 != null) {
                break;
            }
            i2++;
        }
        if (size > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            for (int i3 = 0; i3 < length; i3++) {
                bArr3[i3] = WILDCARD_LABEL;
                Companion companion2 = Companion;
                byte[] bArr4 = this.publicSuffixListBytes;
                if (bArr4 == null) {
                    l.s("publicSuffixListBytes");
                }
                String access$binarySearch = Companion.access$binarySearch(companion2, bArr4, bArr3, i3);
                if (access$binarySearch != null) {
                    str3 = access$binarySearch;
                    break;
                }
            }
            str3 = null;
        } else {
            str3 = null;
        }
        if (str3 != null) {
            int i4 = size - 1;
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    break;
                }
                Companion companion3 = Companion;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    l.s("publicSuffixExceptionListBytes");
                }
                String access$binarySearch2 = Companion.access$binarySearch(companion3, bArr5, bArr, i5);
                if (access$binarySearch2 != null) {
                    str = access$binarySearch2;
                    break;
                }
                i5++;
            }
        }
        if (str != null) {
            return E8.o.r0('!' + str, new char[]{'.'}, false, 0, 6, null);
        }
        if (str2 == null && str3 == null) {
            return PREVAILING_RULE;
        }
        if (str2 == null || (f = E8.o.r0(str2, new char[]{'.'}, false, 0, 6, null)) == null) {
            f = k.f();
        }
        if (str3 == null || (f2 = E8.o.r0(str3, new char[]{'.'}, false, 0, 6, null)) == null) {
            f2 = k.f();
        }
        return f.size() > f2.size() ? f : f2;
    }

    private final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] readByteArray = buffer.readByteArray(buffer.readInt());
            byte[] readByteArray2 = buffer.readByteArray(buffer.readInt());
            q qVar = q.a;
            a.a(buffer, null);
            synchronized (this) {
                l.b(readByteArray);
                this.publicSuffixListBytes = readByteArray;
                l.b(readByteArray2);
                this.publicSuffixExceptionListBytes = readByteArray2;
            }
            this.readCompleteLatch.countDown();
        } finally {
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final List splitDomain(String str) {
        List r0 = E8.o.r0(str, new char[]{'.'}, false, 0, 6, null);
        return l.a((String) s.B(r0), "") ? s.t(r0, 1) : r0;
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String domain) {
        l.e(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        l.d(unicodeDomain, "unicodeDomain");
        List splitDomain = splitDomain(unicodeDomain);
        List findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && ((String) findMatchingRule.get(0)).charAt(0) != '!') {
            return null;
        }
        char charAt = ((String) findMatchingRule.get(0)).charAt(0);
        int size = splitDomain.size();
        int size2 = findMatchingRule.size();
        if (charAt != '!') {
            size2++;
        }
        return D8.k.i(D8.k.f(s.s(splitDomain(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    public final void setListBytes(@NotNull byte[] publicSuffixListBytes, @NotNull byte[] publicSuffixExceptionListBytes) {
        l.e(publicSuffixListBytes, "publicSuffixListBytes");
        l.e(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = publicSuffixListBytes;
        this.publicSuffixExceptionListBytes = publicSuffixExceptionListBytes;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
