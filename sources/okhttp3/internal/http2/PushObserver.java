package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface PushObserver {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        public static final class PushObserverCancel implements PushObserver {
            public boolean onData(int i, @NotNull BufferedSource source, int i2, boolean z) throws IOException {
                l.e(source, "source");
                source.skip(i2);
                return true;
            }

            public boolean onHeaders(int i, @NotNull List responseHeaders, boolean z) {
                l.e(responseHeaders, "responseHeaders");
                return true;
            }

            public boolean onRequest(int i, @NotNull List requestHeaders) {
                l.e(requestHeaders, "requestHeaders");
                return true;
            }

            public void onReset(int i, @NotNull ErrorCode errorCode) {
                l.e(errorCode, "errorCode");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    boolean onData(int i, @NotNull BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, @NotNull List list, boolean z);

    boolean onRequest(int i, @NotNull List list);

    void onReset(int i, @NotNull ErrorCode errorCode);
}
