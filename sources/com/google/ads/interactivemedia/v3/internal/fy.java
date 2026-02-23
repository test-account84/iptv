package com.google.ads.interactivemedia.v3.internal;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class fy implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, yi, jj, em, ei, hp, ew {
    public static final /* synthetic */ int b = 0;
    final /* synthetic */ gc a;

    public /* synthetic */ fy(gc gcVar) {
        this.a = gcVar;
    }

    public final void a() {
        gc.L(this.a);
    }

    public final void b(Exception exc) {
        gc.C(this.a).x(exc);
    }

    public final void c(String str, long j, long j2) {
        gc.C(this.a).y(str, j, j2);
    }

    public final void d(String str) {
        gc.C(this.a).z(str);
    }

    public final void e(ep epVar) {
        gc.C(this.a).A(epVar);
    }

    public final void f(ep epVar) {
        gc.C(this.a).B(epVar);
    }

    public final void g(s sVar, eq eqVar) {
        gc.C(this.a).C(sVar, eqVar);
    }

    public final void h(long j) {
        gc.C(this.a).D(j);
    }

    public final void i(Exception exc) {
        gc.C(this.a).E(exc);
    }

    public final void j(int i, long j, long j2) {
        gc.C(this.a).F(i, j, j2);
    }

    public final void k(int i, long j) {
        gc.C(this.a).G(i, j);
    }

    public final void l(Object obj, long j) {
        gc.C(this.a).H(obj, j);
        gc gcVar = this.a;
        if (gc.D(gcVar) == obj) {
            gc.z(gcVar).g(26, fs.c);
        }
    }

    public final void m(boolean z) {
        gc gcVar = this.a;
        if (gc.aa(gcVar) == z) {
            return;
        }
        gc.F(gcVar, z);
        gc.z(this.a).g(23, new fx(z));
    }

    public final void n(Exception exc) {
        gc.C(this.a).I(exc);
    }

    public final void o(String str, long j, long j2) {
        gc.C(this.a).J(str, j, j2);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        gc.I(this.a, surfaceTexture);
        gc.G(this.a, i, i2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        gc.J(this.a, null);
        gc.G(this.a, 0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        gc.G(this.a, i, i2);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void p(String str) {
        gc.C(this.a).K(str);
    }

    public final void q(ep epVar) {
        gc.C(this.a).L(epVar);
    }

    public final void r(ep epVar) {
        gc.C(this.a).M(epVar);
    }

    public final void s(long j, int i) {
        gc.C(this.a).N(j, i);
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        gc.G(this.a, i2, i3);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        gc gcVar = this.a;
        if (gc.ab(gcVar)) {
            gc.J(gcVar, surfaceHolder.getSurface());
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        gc gcVar = this.a;
        if (gc.ab(gcVar)) {
            gc.J(gcVar, null);
        }
        gc.G(this.a, 0, 0);
    }

    public final void t(s sVar, eq eqVar) {
        gc.C(this.a).O(sVar, eqVar);
    }

    public final void u(bl blVar) {
        gc.z(this.a).g(25, new fw(blVar, 2));
    }
}
