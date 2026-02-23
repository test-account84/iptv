package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c0 implements v0, f1 {
    public final Lock a;
    public final Condition c;
    public final Context d;
    public final w4.i e;
    public final b0 f;
    public final Map g;
    public final com.google.android.gms.common.internal.e i;
    public final Map j;
    public final a.a k;
    public volatile Z l;
    public int n;
    public final Y o;
    public final t0 p;
    public final Map h = new HashMap();
    public w4.b m = null;

    public c0(Context context, Y y, Lock lock, Looper looper, w4.i iVar, Map map, com.google.android.gms.common.internal.e eVar, Map map2, a.a aVar, ArrayList arrayList, t0 t0Var) {
        this.d = context;
        this.a = lock;
        this.e = iVar;
        this.g = map;
        this.i = eVar;
        this.j = map2;
        this.k = aVar;
        this.o = y;
        this.p = t0Var;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((e1) arrayList.get(i)).a(this);
        }
        this.f = new b0(this, looper);
        this.c = lock.newCondition();
        this.l = new U(this);
    }

    public static /* bridge */ /* synthetic */ Z g(c0 c0Var) {
        return c0Var.l;
    }

    public static /* bridge */ /* synthetic */ Lock h(c0 c0Var) {
        return c0Var.a;
    }

    public final void A(w4.b bVar, com.google.android.gms.common.api.a aVar, boolean z) {
        this.a.lock();
        try {
            this.l.d(bVar, aVar, z);
        } finally {
            this.a.unlock();
        }
    }

    public final void a() {
        this.l.c();
    }

    public final void b() {
        if (this.l.g()) {
            this.h.clear();
        }
    }

    public final void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mState=").println(this.l);
        for (com.google.android.gms.common.api.a aVar : this.j.keySet()) {
            String valueOf = String.valueOf(str);
            printWriter.append(str).append(aVar.d()).println(":");
            ((a.f) com.google.android.gms.common.internal.r.m((a.f) this.g.get(aVar.b()))).dump(valueOf.concat("  "), fileDescriptor, printWriter, strArr);
        }
    }

    public final d d(d dVar) {
        dVar.zak();
        this.l.f(dVar);
        return dVar;
    }

    public final boolean e() {
        return this.l instanceof F;
    }

    public final d f(d dVar) {
        dVar.zak();
        return this.l.h(dVar);
    }

    public final void i() {
        this.a.lock();
        try {
            this.o.s();
            this.l = new F(this);
            this.l.b();
            this.c.signalAll();
        } finally {
            this.a.unlock();
        }
    }

    public final void j() {
        this.a.lock();
        try {
            this.l = new T(this, this.i, this.j, this.e, this.k, this.a, this.d);
            this.l.b();
            this.c.signalAll();
        } finally {
            this.a.unlock();
        }
    }

    public final void k(w4.b bVar) {
        this.a.lock();
        try {
            this.m = bVar;
            this.l = new U(this);
            this.l.b();
            this.c.signalAll();
        } finally {
            this.a.unlock();
        }
    }

    public final void l(a0 a0Var) {
        b0 b0Var = this.f;
        b0Var.sendMessage(b0Var.obtainMessage(1, a0Var));
    }

    public final void m(RuntimeException runtimeException) {
        b0 b0Var = this.f;
        b0Var.sendMessage(b0Var.obtainMessage(2, runtimeException));
    }

    public final void onConnected(Bundle bundle) {
        this.a.lock();
        try {
            this.l.a(bundle);
        } finally {
            this.a.unlock();
        }
    }

    public final void onConnectionSuspended(int i) {
        this.a.lock();
        try {
            this.l.e(i);
        } finally {
            this.a.unlock();
        }
    }
}
