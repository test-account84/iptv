package com.onesignal;

import Q0.b;
import Q0.m;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.onesignal.F1;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class OSFocusHandler {
    public static final a b = new a(null);
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public Runnable a;

    public static final class OnLostFocusWorker extends Worker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnLostFocusWorker(@NotNull Context context, @NotNull WorkerParameters workerParams) {
            super(context, workerParams);
            kotlin.jvm.internal.l.e(context, "context");
            kotlin.jvm.internal.l.e(workerParams, "workerParams");
        }

        public ListenableWorker.a r() {
            OSFocusHandler.b.a();
            ListenableWorker.a c = ListenableWorker.a.c();
            kotlin.jvm.internal.l.d(c, "success()");
            return c;
        }
    }

    public static final class a {
        public a() {
        }

        public final void a() {
            com.onesignal.a b = b.b();
            if (b == null || b.e() == null) {
                F1.B1(false);
            }
            F1.c1(F1.v.DEBUG, "OSFocusHandler running onAppLostFocus");
            OSFocusHandler.b(true);
            F1.Z0();
            OSFocusHandler.c(true);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static /* synthetic */ void a() {
        n();
    }

    public static final /* synthetic */ void b(boolean z) {
        d = z;
    }

    public static final /* synthetic */ void c(boolean z) {
        e = z;
    }

    public static final void n() {
        c = true;
        F1.c1(F1.v.DEBUG, "OSFocusHandler setting stop state: true");
    }

    public final Q0.b d() {
        Q0.b a2 = new b.a().b(Q0.l.CONNECTED).a();
        kotlin.jvm.internal.l.d(a2, "Builder()\n            .s…TED)\n            .build()");
        return a2;
    }

    public final void e(String tag, Context context) {
        kotlin.jvm.internal.l.e(tag, "tag");
        kotlin.jvm.internal.l.e(context, "context");
        E1.a(context).a(tag);
    }

    public final boolean f() {
        return d;
    }

    public final boolean g() {
        return e;
    }

    public final void h() {
        i();
        d = false;
    }

    public final void i() {
        c = false;
        Runnable runnable = this.a;
        if (runnable == null) {
            return;
        }
        v1.b().a(runnable);
    }

    public final void j() {
        h();
        F1.c1(F1.v.DEBUG, "OSFocusHandler running onAppFocus");
        F1.X0();
    }

    public final void k(String tag, long j, Context context) {
        kotlin.jvm.internal.l.e(tag, "tag");
        kotlin.jvm.internal.l.e(context, "context");
        Q0.m b2 = new m.a(OnLostFocusWorker.class).e(d()).f(j, TimeUnit.MILLISECONDS).a(tag).b();
        kotlin.jvm.internal.l.d(b2, "Builder(OnLostFocusWorke…tag)\n            .build()");
        E1.a(context).d(tag, Q0.d.KEEP, b2);
    }

    public final void l() {
        if (!c) {
            i();
            return;
        }
        c = false;
        this.a = null;
        F1.c1(F1.v.DEBUG, "OSFocusHandler running onAppStartFocusLogic");
        F1.a1();
    }

    public final void m() {
        w0 w0Var = new w0();
        v1.b().c(1500L, w0Var);
        k8.q qVar = k8.q.a;
        this.a = w0Var;
    }
}
