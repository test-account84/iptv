package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class sc implements tl {
    private final zn a;
    private zh b;
    private zi c;

    public sc(zn znVar) {
        this.a = znVar;
    }

    public final int a(zy zyVar) throws IOException {
        zh zhVar = this.b;
        af.s(zhVar);
        zi ziVar = this.c;
        af.s(ziVar);
        return zhVar.a(ziVar, zyVar);
    }

    public final long b() {
        zi ziVar = this.c;
        if (ziVar != null) {
            return ziVar.d();
        }
        return -1L;
    }

    public final void c() {
        zh zhVar = this.b;
        if (zhVar instanceof aby) {
            ((aby) zhVar).f();
        }
    }

    public final void d(k kVar, Uri uri, Map map, long j, long j2, zk zkVar) throws IOException {
        zb zbVar = new zb(kVar, j, j2);
        this.c = zbVar;
        if (this.b != null) {
            return;
        }
        zh[] a = zm.a(this.a);
        int length = a.length;
        if (length == 1) {
            this.b = a[0];
        } else {
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                zh zhVar = a[i];
                try {
                } catch (EOFException unused) {
                    if (this.b != null || zbVar.d() == j) {
                    }
                } catch (Throwable th) {
                    af.w(this.b != null || zbVar.d() == j);
                    zbVar.h();
                    throw th;
                }
                if (zhVar.C(zbVar)) {
                    this.b = zhVar;
                    af.w(true);
                    zbVar.h();
                    break;
                } else {
                    boolean z = this.b != null || zbVar.d() == j;
                    af.w(z);
                    zbVar.h();
                    i++;
                }
            }
            if (this.b == null) {
                throw new un("None of the available extractors (" + cq.L(a) + ") could read the stream.");
            }
        }
        this.b.b(zkVar);
    }

    public final void e() {
        if (this.b != null) {
            this.b = null;
        }
        this.c = null;
    }

    public final void f(long j, long j2) {
        zh zhVar = this.b;
        af.s(zhVar);
        zhVar.d(j, j2);
    }
}
