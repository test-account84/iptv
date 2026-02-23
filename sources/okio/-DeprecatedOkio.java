package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class -DeprecatedOkio {
    public static final -DeprecatedOkio INSTANCE = new -DeprecatedOkio();

    private -DeprecatedOkio() {
    }

    @NotNull
    public final Sink appendingSink(@NotNull File file) {
        l.e(file, "file");
        return Okio.appendingSink(file);
    }

    @NotNull
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @NotNull
    public final BufferedSink buffer(@NotNull Sink sink) {
        l.e(sink, "sink");
        return Okio.buffer(sink);
    }

    @NotNull
    public final Sink sink(@NotNull File file) {
        l.e(file, "file");
        return Okio.sink$default(file, false, 1, null);
    }

    @NotNull
    public final Source source(@NotNull File file) {
        l.e(file, "file");
        return Okio.source(file);
    }

    @NotNull
    public final BufferedSource buffer(@NotNull Source source) {
        l.e(source, "source");
        return Okio.buffer(source);
    }

    @NotNull
    public final Sink sink(@NotNull OutputStream outputStream) {
        l.e(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @NotNull
    public final Source source(@NotNull InputStream inputStream) {
        l.e(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @NotNull
    public final Sink sink(@NotNull Socket socket) {
        l.e(socket, "socket");
        return Okio.sink(socket);
    }

    @NotNull
    public final Source source(@NotNull Socket socket) {
        l.e(socket, "socket");
        return Okio.source(socket);
    }

    @NotNull
    public final Sink sink(@NotNull Path path, @NotNull OpenOption... options) {
        l.e(path, "path");
        l.e(options, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @NotNull
    public final Source source(@NotNull Path path, @NotNull OpenOption... options) {
        l.e(path, "path");
        l.e(options, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }
}
