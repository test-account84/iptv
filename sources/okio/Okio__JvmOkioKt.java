package okio;

import E8.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.jvm.internal.l;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import p7.H;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final /* synthetic */ class Okio__JvmOkioKt {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    public static final /* synthetic */ Logger access$getLogger$p() {
        return logger;
    }

    @NotNull
    public static final Sink appendingSink(@NotNull File appendingSink) throws FileNotFoundException {
        l.e(appendingSink, "$this$appendingSink");
        return Okio.sink((OutputStream) new FileOutputStream(appendingSink, true));
    }

    private static final Logger getLogger$Okio__JvmOkioKt() {
        return logger;
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError isAndroidGetsocknameError) {
        l.e(isAndroidGetsocknameError, "$this$isAndroidGetsocknameError");
        if (isAndroidGetsocknameError.getCause() == null) {
            return false;
        }
        String message = isAndroidGetsocknameError.getMessage();
        return message != null ? o.G(message, "getsockname failed", false, 2, null) : false;
    }

    @NotNull
    public static final Sink sink(@NotNull File file) throws FileNotFoundException {
        return Okio.sink$default(file, false, 1, null);
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    @NotNull
    public static final Source source(@NotNull File source) throws FileNotFoundException {
        l.e(source, "$this$source");
        return Okio.source((InputStream) new FileInputStream(source));
    }

    @NotNull
    public static final Sink sink(@NotNull File sink, boolean z) throws FileNotFoundException {
        l.e(sink, "$this$sink");
        return Okio.sink((OutputStream) new FileOutputStream(sink, z));
    }

    @NotNull
    public static final Source source(@NotNull InputStream source) {
        l.e(source, "$this$source");
        return new InputStreamSource(source, new Timeout());
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream sink) {
        l.e(sink, "$this$sink");
        return new OutputStreamSink(sink, new Timeout());
    }

    @NotNull
    public static final Source source(@NotNull Socket source) throws IOException {
        l.e(source, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(source);
        InputStream inputStream = source.getInputStream();
        l.d(inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    @NotNull
    public static final Sink sink(@NotNull Socket sink) throws IOException {
        l.e(sink, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(sink);
        OutputStream outputStream = sink.getOutputStream();
        l.d(outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Source source(@NotNull Path source, @NotNull OpenOption... options) throws IOException {
        l.e(source, "$this$source");
        l.e(options, "options");
        InputStream a = a.a(source, (OpenOption[]) Arrays.copyOf(options, options.length));
        l.d(a, "Files.newInputStream(this, *options)");
        return Okio.source(a);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Sink sink(@NotNull Path sink, @NotNull OpenOption... options) throws IOException {
        l.e(sink, "$this$sink");
        l.e(options, "options");
        OutputStream a = H.a(sink, (OpenOption[]) Arrays.copyOf(options, options.length));
        l.d(a, "Files.newOutputStream(this, *options)");
        return Okio.sink(a);
    }
}
