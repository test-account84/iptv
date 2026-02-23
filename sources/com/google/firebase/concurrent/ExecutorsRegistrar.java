package com.google.firebase.concurrent;

import E5.a;
import E5.d;
import I5.F;
import I5.c;
import I5.e;
import I5.x;
import J5.C;
import J5.b;
import J5.o;
import J5.q;
import J5.r;
import J5.s;
import J5.t;
import J5.u;
import J5.v;
import J5.w;
import J5.y;
import J5.z;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

@SuppressLint({"ThreadPoolCreation"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ExecutorsRegistrar implements ComponentRegistrar {
    public static final x a = new x(new s());
    public static final x b = new x(new t());
    public static final x c = new x(new u());
    public static final x d = new x(new v());

    public static /* synthetic */ ScheduledExecutorService a(e eVar) {
        return n(eVar);
    }

    public static /* synthetic */ ScheduledExecutorService b() {
        return s();
    }

    public static /* synthetic */ ScheduledExecutorService c() {
        return q();
    }

    public static /* synthetic */ Executor d(e eVar) {
        return o(eVar);
    }

    public static /* synthetic */ ScheduledExecutorService e(e eVar) {
        return m(eVar);
    }

    public static /* synthetic */ ScheduledExecutorService f() {
        return p();
    }

    public static /* synthetic */ ScheduledExecutorService g(e eVar) {
        return l(eVar);
    }

    public static /* synthetic */ ScheduledExecutorService h() {
        return r();
    }

    public static StrictMode.ThreadPolicy i() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            q.a(detectNetwork);
            if (i >= 26) {
                r.a(detectNetwork);
            }
        }
        return detectNetwork.penaltyLog().build();
    }

    public static ThreadFactory j(String str, int i) {
        return new b(str, i, null);
    }

    public static ThreadFactory k(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        return new b(str, i, threadPolicy);
    }

    public static /* synthetic */ ScheduledExecutorService l(e eVar) {
        return (ScheduledExecutorService) a.get();
    }

    public static /* synthetic */ ScheduledExecutorService m(e eVar) {
        return (ScheduledExecutorService) c.get();
    }

    public static /* synthetic */ ScheduledExecutorService n(e eVar) {
        return (ScheduledExecutorService) b.get();
    }

    public static /* synthetic */ Executor o(e eVar) {
        return C.INSTANCE;
    }

    public static /* synthetic */ ScheduledExecutorService p() {
        return u(Executors.newFixedThreadPool(4, k("Firebase Background", 10, i())));
    }

    public static /* synthetic */ ScheduledExecutorService q() {
        return u(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), k("Firebase Lite", 0, t())));
    }

    public static /* synthetic */ ScheduledExecutorService r() {
        return u(Executors.newCachedThreadPool(j("Firebase Blocking", 11)));
    }

    public static /* synthetic */ ScheduledExecutorService s() {
        return Executors.newSingleThreadScheduledExecutor(j("Firebase Scheduler", 0));
    }

    public static StrictMode.ThreadPolicy t() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    public static ScheduledExecutorService u(ExecutorService executorService) {
        return new o(executorService, (ScheduledExecutorService) d.get());
    }

    public List getComponents() {
        return Arrays.asList(new c[]{c.d(F.a(a.class, ScheduledExecutorService.class), F.a(a.class, ExecutorService.class), F.a(a.class, Executor.class)).f(new w()).d(), c.d(F.a(E5.b.class, ScheduledExecutorService.class), F.a(E5.b.class, ExecutorService.class), F.a(E5.b.class, Executor.class)).f(new J5.x()).d(), c.d(F.a(E5.c.class, ScheduledExecutorService.class), F.a(E5.c.class, ExecutorService.class), F.a(E5.c.class, Executor.class)).f(new y()).d(), c.c(F.a(d.class, Executor.class)).f(new z()).d()});
    }
}
