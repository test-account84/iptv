package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface FileSystem {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class SystemFileSystem implements FileSystem {
            @NotNull
            public Sink appendingSink(@NotNull File file) throws FileNotFoundException {
                l.e(file, "file");
                try {
                    return Okio.appendingSink(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.appendingSink(file);
                }
            }

            public void delete(@NotNull File file) throws IOException {
                l.e(file, "file");
                if (file.delete() || !file.exists()) {
                    return;
                }
                throw new IOException("failed to delete " + file);
            }

            public void deleteContents(@NotNull File directory) throws IOException {
                l.e(directory, "directory");
                File[] listFiles = directory.listFiles();
                if (listFiles == null) {
                    throw new IOException("not a readable directory: " + directory);
                }
                for (File file : listFiles) {
                    l.d(file, "file");
                    if (file.isDirectory()) {
                        deleteContents(file);
                    }
                    if (!file.delete()) {
                        throw new IOException("failed to delete " + file);
                    }
                }
            }

            public boolean exists(@NotNull File file) {
                l.e(file, "file");
                return file.exists();
            }

            public void rename(@NotNull File from, @NotNull File to) throws IOException {
                l.e(from, "from");
                l.e(to, "to");
                delete(to);
                if (from.renameTo(to)) {
                    return;
                }
                throw new IOException("failed to rename " + from + " to " + to);
            }

            @NotNull
            public Sink sink(@NotNull File file) throws FileNotFoundException {
                l.e(file, "file");
                try {
                    return Okio.sink$default(file, false, 1, null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return Okio.sink$default(file, false, 1, null);
                }
            }

            public long size(@NotNull File file) {
                l.e(file, "file");
                return file.length();
            }

            @NotNull
            public Source source(@NotNull File file) throws FileNotFoundException {
                l.e(file, "file");
                return Okio.source(file);
            }

            @NotNull
            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @NotNull
    Sink appendingSink(@NotNull File file) throws FileNotFoundException;

    void delete(@NotNull File file) throws IOException;

    void deleteContents(@NotNull File file) throws IOException;

    boolean exists(@NotNull File file);

    void rename(@NotNull File file, @NotNull File file2) throws IOException;

    @NotNull
    Sink sink(@NotNull File file) throws FileNotFoundException;

    long size(@NotNull File file);

    @NotNull
    Source source(@NotNull File file) throws FileNotFoundException;
}
