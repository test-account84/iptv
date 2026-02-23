package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ConnectionPool {

    @NotNull
    private final RealConnectionPool delegate;

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    @NotNull
    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i, long j, @NotNull TimeUnit timeUnit) {
        this(new RealConnectionPool(TaskRunner.INSTANCE, i, j, timeUnit));
        l.e(timeUnit, "timeUnit");
    }

    public ConnectionPool(@NotNull RealConnectionPool delegate) {
        l.e(delegate, "delegate");
        this.delegate = delegate;
    }
}
