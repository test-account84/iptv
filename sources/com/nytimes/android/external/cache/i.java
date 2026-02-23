package com.nytimes.android.external.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class i {

    public static class b extends c {
        public final Throwable c;

        public b(Throwable th) {
            super(null);
            this.c = th;
        }

        public Object get() {
            throw new ExecutionException(this.c);
        }
    }

    public static abstract class c implements j {
        public static final Logger a = Logger.getLogger(c.class.getName());

        public c() {
        }

        public void addListener(Runnable runnable, Executor executor) {
            o.b(runnable, "Runnable was null.");
            o.b(executor, "Executor was null.");
            try {
                executor.execute(runnable);
            } catch (RuntimeException e) {
                a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
            }
        }

        public boolean cancel(boolean z) {
            return false;
        }

        public abstract Object get();

        public Object get(long j, TimeUnit timeUnit) {
            o.a(timeUnit);
            return get();
        }

        public boolean isCancelled() {
            return false;
        }

        public boolean isDone() {
            return true;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public static j a(Throwable th) {
        o.a(th);
        return new b(th);
    }
}
