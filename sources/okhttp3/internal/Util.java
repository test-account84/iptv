package okhttp3.internal;

import E8.c;
import E8.e;
import E8.n;
import E8.o;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import k8.q;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.l;
import l8.B;
import l8.h;
import l8.k;
import l8.s;
import l8.x;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w8.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Util {

    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY;

    @NotNull
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);

    @NotNull
    public static final RequestBody EMPTY_REQUEST;

    @NotNull
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;

    @NotNull
    public static final TimeZone UTC;
    private static final e VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;

    @NotNull
    public static final String okHttpName;

    @NotNull
    public static final String userAgent = "okhttp/4.9.3";

    public static final class 1 implements EventListener.Factory {
        final /* synthetic */ EventListener $this_asFactory;

        public 1(EventListener eventListener) {
            this.$this_asFactory = eventListener;
        }

        @NotNull
        public final EventListener create(@NotNull Call it) {
            l.e(it, "it");
            return this.$this_asFactory;
        }
    }

    public static final class 1 implements ThreadFactory {
        final /* synthetic */ boolean $daemon;
        final /* synthetic */ String $name;

        public 1(String str, boolean z) {
            this.$name = str;
            this.$daemon = z;
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.$name);
            thread.setDaemon(this.$daemon);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = DesugarTimeZone.getTimeZone("GMT");
        l.b(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new e("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        l.d(name, "OkHttpClient::class.java.name");
        okHttpName = o.l0(o.k0(name, "okhttp3."), "Client");
    }

    public static final void addIfAbsent(@NotNull List addIfAbsent, Object obj) {
        l.e(addIfAbsent, "$this$addIfAbsent");
        if (addIfAbsent.contains(obj)) {
            return;
        }
        addIfAbsent.add(obj);
    }

    public static final int and(byte b, int i) {
        return b & i;
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull EventListener asFactory) {
        l.e(asFactory, "$this$asFactory");
        return new 1(asFactory);
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object assertThreadDoesntHoldLock) {
        l.e(assertThreadDoesntHoldLock, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled && Thread.holdsLock(assertThreadDoesntHoldLock)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            l.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(assertThreadDoesntHoldLock);
            throw new AssertionError(sb.toString());
        }
    }

    public static final void assertThreadHoldsLock(@NotNull Object assertThreadHoldsLock) {
        l.e(assertThreadHoldsLock, "$this$assertThreadHoldsLock");
        if (!assertionsEnabled || Thread.holdsLock(assertThreadHoldsLock)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread currentThread = Thread.currentThread();
        l.d(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(assertThreadHoldsLock);
        throw new AssertionError(sb.toString());
    }

    public static final boolean canParseAsIpAddress(@NotNull String canParseAsIpAddress) {
        l.e(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.a(canParseAsIpAddress);
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl canReuseConnectionFor, @NotNull HttpUrl other) {
        l.e(canReuseConnectionFor, "$this$canReuseConnectionFor");
        l.e(other, "other");
        return l.a(canReuseConnectionFor.host(), other.host()) && canReuseConnectionFor.port() == other.port() && l.a(canReuseConnectionFor.scheme(), other.scheme());
    }

    public static final int checkDuration(@NotNull String name, long j, @Nullable TimeUnit timeUnit) {
        l.e(name, "name");
        if (!(j >= 0)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j);
        if (!(millis <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException((name + " too large.").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException((name + " too small.").toString());
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(@NotNull Closeable closeQuietly) {
        l.e(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (Exception unused) {
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @NotNull
    public static final String[] concat(@NotNull String[] concat, @NotNull String value) {
        l.e(concat, "$this$concat");
        l.e(value, "value");
        Object[] copyOf = Arrays.copyOf(concat, concat.length + 1);
        l.d(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) copyOf;
        strArr[h.r(strArr)] = value;
        return strArr;
    }

    public static final int delimiterOffset(@NotNull String delimiterOffset, char c, int i, int i2) {
        l.e(delimiterOffset, "$this$delimiterOffset");
        while (i < i2) {
            if (delimiterOffset.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    public static final boolean discard(@NotNull Source discard, int i, @NotNull TimeUnit timeUnit) {
        l.e(discard, "$this$discard");
        l.e(timeUnit, "timeUnit");
        try {
            return skipAll(discard, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @NotNull
    public static final List filterList(@NotNull Iterable filterList, @NotNull w8.l predicate) {
        l.e(filterList, "$this$filterList");
        l.e(predicate, "predicate");
        ArrayList f = k.f();
        for (Object obj : filterList) {
            if (((Boolean) predicate.invoke(obj)).booleanValue()) {
                if (f.isEmpty()) {
                    f = new ArrayList();
                }
                F.a(f).add(obj);
            }
        }
        return f;
    }

    @NotNull
    public static final String format(@NotNull String format, @NotNull Object... args) {
        l.e(format, "format");
        l.e(args, "args");
        E e = E.a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        l.d(format2, "java.lang.String.format(locale, format, *args)");
        return format2;
    }

    public static final boolean hasIntersection(@NotNull String[] hasIntersection, @Nullable String[] strArr, @NotNull Comparator comparator) {
        l.e(hasIntersection, "$this$hasIntersection");
        l.e(comparator, "comparator");
        if (hasIntersection.length != 0 && strArr != null && strArr.length != 0) {
            for (String str : hasIntersection) {
                for (String str2 : strArr) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(@NotNull Response headersContentLength) {
        l.e(headersContentLength, "$this$headersContentLength");
        String str = headersContentLength.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(@NotNull a block) {
        l.e(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    @NotNull
    public static final List immutableListOf(@NotNull Object... elements) {
        l.e(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List unmodifiableList = Collections.unmodifiableList(k.h(Arrays.copyOf(objArr, objArr.length)));
        l.d(unmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(@NotNull String[] indexOf, @NotNull String value, @NotNull Comparator comparator) {
        l.e(indexOf, "$this$indexOf");
        l.e(value, "value");
        l.e(comparator, "comparator");
        int length = indexOf.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(indexOf[i], value) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@NotNull String indexOfControlOrNonAscii) {
        l.e(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i = 0; i < length; i++) {
            char charAt = indexOfControlOrNonAscii.charAt(i);
            if (l.f(charAt, 31) <= 0 || l.f(charAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String indexOfFirstNonAsciiWhitespace, int i, int i2) {
        l.e(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char charAt = indexOfFirstNonAsciiWhitespace.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String indexOfLastNonAsciiWhitespace, int i, int i2) {
        l.e(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char charAt = indexOfLastNonAsciiWhitespace.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3--;
            }
        }
        return i;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfNonWhitespace(@NotNull String indexOfNonWhitespace, int i) {
        l.e(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i < length) {
            char charAt = indexOfNonWhitespace.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                return i;
            }
            i++;
        }
        return indexOfNonWhitespace.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return indexOfNonWhitespace(str, i);
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] intersect, @NotNull String[] other, @NotNull Comparator comparator) {
        l.e(intersect, "$this$intersect");
        l.e(other, "other");
        l.e(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            int length = other.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, other[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean isCivilized(@NotNull FileSystem isCivilized, @NotNull File file) {
        l.e(isCivilized, "$this$isCivilized");
        l.e(file, "file");
        Sink sink = isCivilized.sink(file);
        try {
            try {
                isCivilized.delete(file);
                u8.a.a(sink, null);
                return true;
            } catch (IOException unused) {
                q qVar = q.a;
                u8.a.a(sink, null);
                isCivilized.delete(file);
                return false;
            }
        } finally {
        }
    }

    public static final boolean isHealthy(@NotNull Socket isHealthy, @NotNull BufferedSource source) {
        l.e(isHealthy, "$this$isHealthy");
        l.e(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                boolean z = !source.exhausted();
                isHealthy.setSoTimeout(soTimeout);
                return z;
            } catch (Throwable th) {
                isHealthy.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(@NotNull String name) {
        l.e(name, "name");
        return n.o(name, "Authorization", true) || n.o(name, "Cookie", true) || n.o(name, "Proxy-Authorization", true) || n.o(name, "Set-Cookie", true);
    }

    public static final void notify(@NotNull Object notify) {
        l.e(notify, "$this$notify");
        notify.notify();
    }

    public static final void notifyAll(@NotNull Object notifyAll) {
        l.e(notifyAll, "$this$notifyAll");
        notifyAll.notifyAll();
    }

    public static final int parseHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        if ('a' <= c && 'f' >= c) {
            return c - 'W';
        }
        if ('A' <= c && 'F' >= c) {
            return c - '7';
        }
        return -1;
    }

    @NotNull
    public static final String peerName(@NotNull Socket peerName) {
        l.e(peerName, "$this$peerName");
        InetSocketAddress remoteSocketAddress = peerName.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = remoteSocketAddress.getHostName();
        l.d(hostName, "address.hostName");
        return hostName;
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource readBomAsCharset, @NotNull Charset charset) throws IOException {
        Charset charset2;
        String str;
        l.e(readBomAsCharset, "$this$readBomAsCharset");
        l.e(charset, "default");
        int select = readBomAsCharset.select(UNICODE_BOMS);
        if (select == -1) {
            return charset;
        }
        if (select == 0) {
            charset2 = StandardCharsets.UTF_8;
            str = "UTF_8";
        } else if (select == 1) {
            charset2 = StandardCharsets.UTF_16BE;
            str = "UTF_16BE";
        } else {
            if (select != 2) {
                if (select == 3) {
                    return c.a.a();
                }
                if (select == 4) {
                    return c.a.b();
                }
                throw new AssertionError();
            }
            charset2 = StandardCharsets.UTF_16LE;
            str = "UTF_16LE";
        }
        l.d(charset2, str);
        return charset2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        return r4;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readFieldOrNull(@org.jetbrains.annotations.NotNull java.lang.Object r5, @org.jetbrains.annotations.NotNull java.lang.Class r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            java.lang.String r0 = "instance"
            kotlin.jvm.internal.l.e(r5, r0)
            java.lang.String r0 = "fieldType"
            kotlin.jvm.internal.l.e(r6, r0)
            java.lang.String r0 = "fieldName"
            kotlin.jvm.internal.l.e(r7, r0)
            java.lang.Class r0 = r5.getClass()
        L13:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r2 = kotlin.jvm.internal.l.a(r0, r1)
            r3 = 1
            r2 = r2 ^ r3
            r4 = 0
            if (r2 == 0) goto L44
            java.lang.reflect.Field r1 = r0.getDeclaredField(r7)     // Catch: java.lang.NoSuchFieldException -> L3a
            java.lang.String r2 = "field"
            kotlin.jvm.internal.l.d(r1, r2)     // Catch: java.lang.NoSuchFieldException -> L3a
            r1.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L3a
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.NoSuchFieldException -> L3a
            boolean r2 = r6.isInstance(r1)     // Catch: java.lang.NoSuchFieldException -> L3a
            if (r2 != 0) goto L35
            goto L39
        L35:
            java.lang.Object r4 = r6.cast(r1)     // Catch: java.lang.NoSuchFieldException -> L3a
        L39:
            return r4
        L3a:
            java.lang.Class r0 = r0.getSuperclass()
            java.lang.String r1 = "c.superclass"
            kotlin.jvm.internal.l.d(r0, r1)
            goto L13
        L44:
            java.lang.String r0 = "delegate"
            boolean r2 = kotlin.jvm.internal.l.a(r7, r0)
            r2 = r2 ^ r3
            if (r2 == 0) goto L58
            java.lang.Object r5 = readFieldOrNull(r5, r1, r0)
            if (r5 == 0) goto L58
            java.lang.Object r5 = readFieldOrNull(r5, r6, r7)
            return r5
        L58:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.readFieldOrNull(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static final int readMedium(@NotNull BufferedSource readMedium) throws IOException {
        l.e(readMedium, "$this$readMedium");
        return and(readMedium.readByte(), 255) | (and(readMedium.readByte(), 255) << 16) | (and(readMedium.readByte(), 255) << 8);
    }

    public static final int skipAll(@NotNull Buffer skipAll, byte b) {
        l.e(skipAll, "$this$skipAll");
        int i = 0;
        while (!skipAll.exhausted() && skipAll.getByte(0L) == b) {
            i++;
            skipAll.readByte();
        }
        return i;
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull String name, boolean z) {
        l.e(name, "name");
        return new 1(name, z);
    }

    public static final void threadName(@NotNull String name, @NotNull a block) {
        l.e(name, "name");
        l.e(block, "block");
        Thread currentThread = Thread.currentThread();
        l.d(currentThread, "currentThread");
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            kotlin.jvm.internal.k.b(1);
            currentThread.setName(name2);
            kotlin.jvm.internal.k.a(1);
        }
    }

    @NotNull
    public static final List toHeaderList(@NotNull Headers toHeaderList) {
        l.e(toHeaderList, "$this$toHeaderList");
        B8.c m = B8.h.m(0, toHeaderList.size());
        ArrayList arrayList = new ArrayList(l8.l.o(m, 10));
        Iterator it = m.iterator();
        while (it.hasNext()) {
            int b = ((x) it).b();
            arrayList.add(new Header(toHeaderList.name(b), toHeaderList.value(b)));
        }
        return arrayList;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List toHeaders) {
        l.e(toHeaders, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        Iterator it = toHeaders.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    @NotNull
    public static final String toHexString(int i) {
        String hexString = Integer.toHexString(i);
        l.d(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl toHostHeader, boolean z) {
        String host;
        l.e(toHostHeader, "$this$toHostHeader");
        if (o.G(toHostHeader.host(), ":", false, 2, null)) {
            host = '[' + toHostHeader.host() + ']';
        } else {
            host = toHostHeader.host();
        }
        if (!z && toHostHeader.port() == HttpUrl.Companion.defaultPort(toHostHeader.scheme())) {
            return host;
        }
        return host + ':' + toHostHeader.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    @NotNull
    public static final List toImmutableList(@NotNull List toImmutableList) {
        l.e(toImmutableList, "$this$toImmutableList");
        List unmodifiableList = Collections.unmodifiableList(s.N((Collection) toImmutableList));
        l.d(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    @NotNull
    public static final Map toImmutableMap(@NotNull Map toImmutableMap) {
        l.e(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            return B.d();
        }
        Map unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        l.d(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(@NotNull String toLongOrDefault, long j) {
        l.e(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int toNonNegativeInt(@Nullable String str, int i) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    @NotNull
    public static final String trimSubstring(@NotNull String trimSubstring, int i, int i2) {
        l.e(trimSubstring, "$this$trimSubstring");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(trimSubstring, i, i2);
        String substring = trimSubstring.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(trimSubstring, indexOfFirstNonAsciiWhitespace, i2));
        l.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return trimSubstring(str, i, i2);
    }

    public static final void wait(@NotNull Object wait) {
        l.e(wait, "$this$wait");
        wait.wait();
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception withSuppressed, @NotNull List suppressed) {
        l.e(withSuppressed, "$this$withSuppressed");
        l.e(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator it = suppressed.iterator();
        while (it.hasNext()) {
            k8.a.a(withSuppressed, (Exception) it.next());
        }
        return withSuppressed;
    }

    public static final void writeMedium(@NotNull BufferedSink writeMedium, int i) throws IOException {
        l.e(writeMedium, "$this$writeMedium");
        writeMedium.writeByte((i >>> 16) & 255);
        writeMedium.writeByte((i >>> 8) & 255);
        writeMedium.writeByte(i & 255);
    }

    public static final int and(short s, int i) {
        return s & i;
    }

    public static final void closeQuietly(@NotNull ServerSocket closeQuietly) {
        l.e(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (Exception unused) {
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public static final int delimiterOffset(@NotNull String delimiterOffset, @NotNull String delimiters, int i, int i2) {
        l.e(delimiterOffset, "$this$delimiterOffset");
        l.e(delimiters, "delimiters");
        while (i < i2) {
            if (o.F(delimiters, delimiterOffset.charAt(i), false, 2, null)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, str2, i, i2);
    }

    public static final boolean skipAll(@NotNull Source skipAll, int i, @NotNull TimeUnit timeUnit) throws IOException {
        l.e(skipAll, "$this$skipAll");
        l.e(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = skipAll.timeout().hasDeadline() ? skipAll.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        skipAll.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (skipAll.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            Timeout timeout = skipAll.timeout();
            if (deadlineNanoTime == Long.MAX_VALUE) {
                timeout.clearDeadline();
            } else {
                timeout.deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            Timeout timeout2 = skipAll.timeout();
            if (deadlineNanoTime == Long.MAX_VALUE) {
                timeout2.clearDeadline();
            } else {
                timeout2.deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            Timeout timeout3 = skipAll.timeout();
            if (deadlineNanoTime == Long.MAX_VALUE) {
                timeout3.clearDeadline();
            } else {
                timeout3.deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    @NotNull
    public static final String toHexString(long j) {
        String hexString = Long.toHexString(j);
        l.d(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    public static final long and(int i, long j) {
        return i & j;
    }

    public static final void closeQuietly(@NotNull Socket closeQuietly) {
        l.e(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e) {
            if (!l.a(e.getMessage(), "bio == null")) {
                throw e;
            }
        } catch (AssertionError e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }
}
