package com.google.ads.interactivemedia.v3.internal;

import android.os.ConditionVariable;
import j$.util.concurrent.ThreadLocalRandom;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class amu {
    protected volatile Boolean b;
    private final anw e;
    private static final ConditionVariable c = new ConditionVariable();
    protected static volatile ata a = null;
    private static volatile Random d = null;

    public amu(anw anwVar) {
        this.e = anwVar;
        anwVar.j().execute(new amt(this, 0));
    }

    public static /* bridge */ /* synthetic */ ConditionVariable a() {
        return c;
    }

    public static /* bridge */ /* synthetic */ anw b(amu amuVar) {
        return amuVar.e;
    }

    public static final int d() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            return f().nextInt();
        }
    }

    private static Random f() {
        if (d == null) {
            synchronized (amu.class) {
                try {
                    if (d == null) {
                        d = new Random();
                    }
                } finally {
                }
            }
        }
        return d;
    }

    public final void c(int i, int i2, long j, String str, Exception exc) {
        try {
            c.block();
            if (!this.b.booleanValue() || a == null) {
                return;
            }
            afl j2 = afk.j();
            j2.a(this.e.a.getPackageName());
            j2.e(j);
            if (str != null) {
                j2.b(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                j2.f(stringWriter.toString());
                j2.d(exc.getClass().getName());
            }
            asz a2 = a.a(((afk) j2.aY()).av());
            a2.b(i);
            if (i2 != -1) {
                a2.c(i2);
            }
            a2.a();
        } catch (Exception unused) {
        }
    }

    public final void e(int i, long j, String str) {
        c(i, -1, j, str, null);
    }
}
