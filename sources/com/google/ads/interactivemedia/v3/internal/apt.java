package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.Hide;
import h4.a;
import java.util.concurrent.Executor;

@Hide
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apt extends apw {
    private final amv a;
    private final amx b;
    private final and c;
    private boolean d = false;

    public apt(Context context, Executor executor, aff affVar) {
        ana anaVar = new ana(context, executor, affVar);
        this.a = anaVar;
        this.c = new and(anaVar);
        this.b = affVar.c() ? null : amx.j(context);
    }

    @Deprecated
    private final aro u(aro aroVar, aro aroVar2, boolean z) {
        try {
            Uri uri = (Uri) arp.d(aroVar);
            Context context = (Context) arp.d(aroVar2);
            return arp.c(z ? this.c.a(uri, context) : this.c.g(uri, context));
        } catch (ane unused) {
            return null;
        }
    }

    public final int b() {
        amv amvVar = this.a;
        if (!(amvVar instanceof ana)) {
            return -1;
        }
        amv a = ((ana) amvVar).a();
        if (a instanceof anc) {
            return 1;
        }
        return a instanceof ams ? 2 : -1;
    }

    @Deprecated
    public final aro c(aro aroVar, aro aroVar2) {
        return u(aroVar, aroVar2, false);
    }

    @Deprecated
    public final aro d(aro aroVar, aro aroVar2) {
        return u(aroVar, aroVar2, true);
    }

    @Deprecated
    public final String e(aro aroVar, String str) {
        return ((ana) this.a).e((Context) arp.d(aroVar), str, null, null);
    }

    @Deprecated
    public final String f(aro aroVar) {
        return g(aroVar, null);
    }

    @Deprecated
    public final String g(aro aroVar, byte[] bArr) {
        Context context = (Context) arp.d(aroVar);
        String g = this.a.g(context, bArr);
        amx amxVar = this.b;
        if (amxVar == null || !this.d) {
            return g;
        }
        String m = this.b.m(g, amxVar.g(context, bArr));
        this.d = false;
        return m;
    }

    public final String h(aro aroVar, aro aroVar2, aro aroVar3, aro aroVar4) {
        return this.a.e((Context) arp.d(aroVar), (String) arp.d(aroVar2), (View) arp.d(aroVar3), (Activity) arp.d(aroVar4));
    }

    public final String i(aro aroVar) {
        return this.a.f((Context) arp.d(aroVar));
    }

    public final String j() {
        return "ms";
    }

    public final String k(aro aroVar, aro aroVar2, aro aroVar3) {
        return this.a.h((Context) arp.d(aroVar), (View) arp.d(aroVar2), (Activity) arp.d(aroVar3));
    }

    public final void l(aro aroVar) {
        this.c.b((MotionEvent) arp.d(aroVar));
    }

    public final void m(aro aroVar) {
        this.a.n((View) arp.d(aroVar));
    }

    @Deprecated
    public final void n(String str, String str2) {
        this.c.c(str, str2);
    }

    @Deprecated
    public final void o(String str) {
        this.c.d(str);
    }

    @Deprecated
    public final boolean p(aro aroVar) {
        return this.c.f((Uri) arp.d(aroVar));
    }

    @Deprecated
    public final boolean q(aro aroVar) {
        return this.c.e((Uri) arp.d(aroVar));
    }

    public final boolean r() {
        return this.a.q();
    }

    @Deprecated
    public final boolean s(String str, boolean z) {
        if (this.b == null) {
            return false;
        }
        this.b.o(new a.a(str, z));
        this.d = true;
        return true;
    }

    public final boolean t() {
        return this.a.s();
    }
}
