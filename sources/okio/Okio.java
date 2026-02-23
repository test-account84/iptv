package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Okio {
    @NotNull
    public static final Sink appendingSink(@NotNull File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(file);
    }

    @NotNull
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink) {
        return Okio__OkioKt.buffer(sink);
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError assertionError) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(assertionError);
    }

    @NotNull
    public static final Sink sink(@NotNull File file) throws FileNotFoundException {
        return sink$default(file, false, 1, null);
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink$default(file, z, i, obj);
    }

    @NotNull
    public static final Source source(@NotNull File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(file);
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source source) {
        return Okio__OkioKt.buffer(source);
    }

    @NotNull
    public static final Sink sink(@NotNull File file, boolean z) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file, z);
    }

    @NotNull
    public static final Source source(@NotNull InputStream inputStream) {
        return Okio__JvmOkioKt.source(inputStream);
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream outputStream) {
        return Okio__JvmOkioKt.sink(outputStream);
    }

    @NotNull
    public static final Source source(@NotNull Socket socket) throws IOException {
        return Okio__JvmOkioKt.source(socket);
    }

    @NotNull
    public static final Sink sink(@NotNull Socket socket) throws IOException {
        return Okio__JvmOkioKt.sink(socket);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Source source(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.source(path, openOptionArr);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Sink sink(@NotNull Path path, @NotNull OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.sink(path, openOptionArr);
    }
}
