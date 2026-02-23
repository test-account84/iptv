package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.l;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(@NotNull FileChannel fileChannel) {
        l.e(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j, @NotNull Buffer sink, long j2) {
        l.e(sink, "sink");
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j2 > 0) {
            long transferTo = this.fileChannel.transferTo(j, j2, sink);
            j += transferTo;
            j2 -= transferTo;
        }
    }

    public final void write(long j, @NotNull Buffer source, long j2) throws IOException {
        l.e(source, "source");
        if (j2 < 0 || j2 > source.size()) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long transferFrom = this.fileChannel.transferFrom(source, j3, j4);
            j3 += transferFrom;
            j4 -= transferFrom;
        }
    }
}
