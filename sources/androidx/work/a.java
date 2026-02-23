package androidx.work;

import Q0.g;
import Q0.i;
import Q0.r;
import Q0.w;
import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a {
    public final Executor a;
    public final Executor b;
    public final w c;
    public final i d;
    public final r e;
    public final String f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final boolean k;

    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(0);
        public final /* synthetic */ boolean b;

        public a(boolean z) {
            this.b = z;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, (this.b ? "WM.task-" : "androidx.work-") + this.a.incrementAndGet());
        }
    }

    public static final class b {
        public Executor a;
        public w b;
        public i c;
        public Executor d;
        public r e;
        public String f;
        public int g = 4;
        public int h = 0;
        public int i = Integer.MAX_VALUE;
        public int j = 20;

        public a a() {
            return new a(this);
        }
    }

    public a(b bVar) {
        Executor executor = bVar.a;
        this.a = executor == null ? a(false) : executor;
        Executor executor2 = bVar.d;
        if (executor2 == null) {
            this.k = true;
            executor2 = a(true);
        } else {
            this.k = false;
        }
        this.b = executor2;
        w wVar = bVar.b;
        this.c = wVar == null ? w.c() : wVar;
        i iVar = bVar.c;
        this.d = iVar == null ? i.c() : iVar;
        r rVar = bVar.e;
        this.e = rVar == null ? new R0.a() : rVar;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.f = bVar.f;
    }

    public final Executor a(boolean z) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z));
    }

    public final ThreadFactory b(boolean z) {
        return new a(z);
    }

    public String c() {
        return this.f;
    }

    public g d() {
        return null;
    }

    public Executor e() {
        return this.a;
    }

    public i f() {
        return this.d;
    }

    public int g() {
        return this.i;
    }

    public int h() {
        return Build.VERSION.SDK_INT == 23 ? this.j / 2 : this.j;
    }

    public int i() {
        return this.h;
    }

    public int j() {
        return this.g;
    }

    public r k() {
        return this.e;
    }

    public Executor l() {
        return this.b;
    }

    public w m() {
        return this.c;
    }
}
