package f4;

import O2.z0;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import d4.B;
import d4.Y;
import d4.v;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i implements e4.m, a {
    public int j;
    public SurfaceTexture k;
    public byte[] n;
    public final AtomicBoolean a = new AtomicBoolean();
    public final AtomicBoolean c = new AtomicBoolean(true);
    public final g d = new g();
    public final c e = new c();
    public final Y f = new Y();
    public final Y g = new Y();
    public final float[] h = new float[16];
    public final float[] i = new float[16];
    public volatile int l = 0;
    public int m = -1;

    public static /* synthetic */ void d(i iVar, SurfaceTexture surfaceTexture) {
        iVar.g(surfaceTexture);
    }

    public void a(long j, long j2, z0 z0Var, MediaFormat mediaFormat) {
        this.f.a(j2, Long.valueOf(j));
        i(z0Var.w, z0Var.x, j2);
    }

    public void b(long j, float[] fArr) {
        this.e.e(j, fArr);
    }

    public void c() {
        this.f.c();
        this.e.d();
        this.c.set(true);
    }

    public void e(float[] fArr, boolean z) {
        GLES20.glClear(16384);
        try {
            v.b();
        } catch (v.a e) {
            B.e("SceneRenderer", "Failed to draw a frame", e);
        }
        if (this.a.compareAndSet(true, false)) {
            ((SurfaceTexture) d4.a.e(this.k)).updateTexImage();
            try {
                v.b();
            } catch (v.a e2) {
                B.e("SceneRenderer", "Failed to draw a frame", e2);
            }
            if (this.c.compareAndSet(true, false)) {
                v.j(this.h);
            }
            long timestamp = this.k.getTimestamp();
            Long l = (Long) this.f.g(timestamp);
            if (l != null) {
                this.e.c(this.h, l.longValue());
            }
            e eVar = (e) this.g.j(timestamp);
            if (eVar != null) {
                this.d.d(eVar);
            }
        }
        Matrix.multiplyMM(this.i, 0, fArr, 0, this.h, 0);
        this.d.a(this.j, this.i, z);
    }

    public SurfaceTexture f() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            v.b();
            this.d.b();
            v.b();
            this.j = v.f();
        } catch (v.a e) {
            B.e("SceneRenderer", "Failed to initialize the renderer", e);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.j);
        this.k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new h(this));
        return this.k;
    }

    public final /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.a.set(true);
    }

    public void h(int i) {
        this.l = i;
    }

    public final void i(byte[] bArr, int i, long j) {
        byte[] bArr2 = this.n;
        int i2 = this.m;
        this.n = bArr;
        if (i == -1) {
            i = this.l;
        }
        this.m = i;
        if (i2 == i && Arrays.equals(bArr2, this.n)) {
            return;
        }
        byte[] bArr3 = this.n;
        e a = bArr3 != null ? f.a(bArr3, this.m) : null;
        if (a == null || !g.c(a)) {
            a = e.b(this.m);
        }
        this.g.a(j, a);
    }
}
