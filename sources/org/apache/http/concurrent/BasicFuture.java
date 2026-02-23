package org.apache.http.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.util.Args;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class BasicFuture implements Future, Cancellable {
    private final FutureCallback callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private volatile Exception ex;
    private volatile Object result;

    public BasicFuture(FutureCallback futureCallback) {
        this.callback = futureCallback;
    }

    private Object getResult() throws ExecutionException {
        if (this.ex != null) {
            throw new ExecutionException(this.ex);
        }
        if (this.cancelled) {
            throw new CancellationException();
        }
        return this.result;
    }

    public boolean cancel() {
        return cancel(true);
    }

    public boolean completed(Object obj) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                this.result = obj;
                notifyAll();
                FutureCallback futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.completed(obj);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean failed(Exception exc) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                this.ex = exc;
                notifyAll();
                FutureCallback futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.failed(exc);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized Object get() throws InterruptedException, ExecutionException {
        while (!this.completed) {
            try {
                wait();
            } catch (Throwable th) {
                throw th;
            }
        }
        return getResult();
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isDone() {
        return this.completed;
    }

    public boolean cancel(boolean z) {
        synchronized (this) {
            try {
                if (this.completed) {
                    return false;
                }
                this.completed = true;
                this.cancelled = true;
                notifyAll();
                FutureCallback futureCallback = this.callback;
                if (futureCallback != null) {
                    futureCallback.cancelled();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        long currentTimeMillis = millis <= 0 ? 0L : System.currentTimeMillis();
        if (this.completed) {
            return getResult();
        }
        if (millis <= 0) {
            throw new TimeoutException();
        }
        long j2 = millis;
        do {
            wait(j2);
            if (this.completed) {
                return getResult();
            }
            j2 = millis - (System.currentTimeMillis() - currentTimeMillis);
        } while (j2 > 0);
        throw new TimeoutException();
    }
}
