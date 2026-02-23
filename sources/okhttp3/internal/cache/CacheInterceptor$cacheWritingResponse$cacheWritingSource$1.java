package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class CacheInterceptor$cacheWritingResponse$cacheWritingSource$1 implements Source {
    final /* synthetic */ BufferedSink $cacheBody;
    final /* synthetic */ CacheRequest $cacheRequest;
    final /* synthetic */ BufferedSource $source;
    private boolean cacheRequestClosed;

    public CacheInterceptor$cacheWritingResponse$cacheWritingSource$1(BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
        this.$source = bufferedSource;
        this.$cacheRequest = cacheRequest;
        this.$cacheBody = bufferedSink;
    }

    public void close() throws IOException {
        if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.cacheRequestClosed = true;
            this.$cacheRequest.abort();
        }
        this.$source.close();
    }

    public long read(@NotNull Buffer sink, long j) throws IOException {
        l.e(sink, "sink");
        try {
            long read = this.$source.read(sink, j);
            if (read != -1) {
                sink.copyTo(this.$cacheBody.getBuffer(), sink.size() - read, read);
                this.$cacheBody.emitCompleteSegments();
                return read;
            }
            if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                this.$cacheBody.close();
            }
            return -1L;
        } catch (IOException e) {
            if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                this.$cacheRequest.abort();
            }
            throw e;
        }
    }

    @NotNull
    public Timeout timeout() {
        return this.$source.timeout();
    }
}
