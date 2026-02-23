package l5;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class l {
    public final m[] a = new m[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final m g = new m();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public boolean l = true;

    public static class a {
        public static final l a = new l();
    }

    public interface b {
        void a(m mVar, Matrix matrix, int i);

        void b(m mVar, Matrix matrix, int i);
    }

    public static final class c {
        public final k a;
        public final Path b;
        public final RectF c;
        public final b d;
        public final float e;

        public c(k kVar, float f, RectF rectF, b bVar, Path path) {
            this.d = bVar;
            this.a = kVar;
            this.e = f;
            this.c = rectF;
            this.b = path;
        }
    }

    public l() {
        for (int i = 0; i < 4; i++) {
            this.a[i] = new m();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    public static l k() {
        return a.a;
    }

    public final float a(int i) {
        return (i + 1) * 90;
    }

    public final void b(c cVar, int i) {
        this.h[0] = this.a[i].k();
        this.h[1] = this.a[i].l();
        this.b[i].mapPoints(this.h);
        Path path = cVar.b;
        float[] fArr = this.h;
        if (i == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.a[i].d(this.b[i], cVar.b);
        b bVar = cVar.d;
        if (bVar != null) {
            bVar.a(this.a[i], this.b[i], i);
        }
    }

    public final void c(c cVar, int i) {
        m mVar;
        Matrix matrix;
        Path path;
        int i2 = (i + 1) % 4;
        this.h[0] = this.a[i].i();
        this.h[1] = this.a[i].j();
        this.b[i].mapPoints(this.h);
        this.i[0] = this.a[i2].k();
        this.i[1] = this.a[i2].l();
        this.b[i2].mapPoints(this.i);
        float f = this.h[0];
        float[] fArr = this.i;
        float max = Math.max(((float) Math.hypot(f - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float i3 = i(cVar.c, i);
        this.g.n(0.0f, 0.0f);
        f j = j(i, cVar.a);
        j.b(max, i3, cVar.e, this.g);
        this.j.reset();
        this.g.d(this.c[i], this.j);
        if (this.l && (j.a() || l(this.j, i) || l(this.j, i2))) {
            Path path2 = this.j;
            path2.op(path2, this.f, Path.Op.DIFFERENCE);
            this.h[0] = this.g.k();
            this.h[1] = this.g.l();
            this.c[i].mapPoints(this.h);
            Path path3 = this.e;
            float[] fArr2 = this.h;
            path3.moveTo(fArr2[0], fArr2[1]);
            mVar = this.g;
            matrix = this.c[i];
            path = this.e;
        } else {
            mVar = this.g;
            matrix = this.c[i];
            path = cVar.b;
        }
        mVar.d(matrix, path);
        b bVar = cVar.d;
        if (bVar != null) {
            bVar.b(this.g, this.c[i], i);
        }
    }

    public void d(k kVar, float f, RectF rectF, Path path) {
        e(kVar, f, rectF, null, path);
    }

    public void e(k kVar, float f, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f, rectF, bVar, path);
        for (int i = 0; i < 4; i++) {
            m(cVar, i);
            n(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            b(cVar, i2);
            c(cVar, i2);
        }
        path.close();
        this.e.close();
        if (this.e.isEmpty()) {
            return;
        }
        path.op(this.e, Path.Op.UNION);
    }

    public final void f(int i, RectF rectF, PointF pointF) {
        float f;
        float f2;
        if (i == 1) {
            f = rectF.right;
        } else {
            if (i != 2) {
                f = i != 3 ? rectF.right : rectF.left;
                f2 = rectF.top;
                pointF.set(f, f2);
            }
            f = rectF.left;
        }
        f2 = rectF.bottom;
        pointF.set(f, f2);
    }

    public final l5.c g(int i, k kVar) {
        return i != 1 ? i != 2 ? i != 3 ? kVar.t() : kVar.r() : kVar.j() : kVar.l();
    }

    public final d h(int i, k kVar) {
        return i != 1 ? i != 2 ? i != 3 ? kVar.s() : kVar.q() : kVar.i() : kVar.k();
    }

    public final float i(RectF rectF, int i) {
        float centerX;
        float f;
        float[] fArr = this.h;
        m mVar = this.a[i];
        fArr[0] = mVar.c;
        fArr[1] = mVar.d;
        this.b[i].mapPoints(fArr);
        if (i == 1 || i == 3) {
            centerX = rectF.centerX();
            f = this.h[0];
        } else {
            centerX = rectF.centerY();
            f = this.h[1];
        }
        return Math.abs(centerX - f);
    }

    public final f j(int i, k kVar) {
        return i != 1 ? i != 2 ? i != 3 ? kVar.o() : kVar.p() : kVar.n() : kVar.h();
    }

    public final boolean l(Path path, int i) {
        this.k.reset();
        this.a[i].d(this.b[i], this.k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.k.computeBounds(rectF, true);
        path.op(this.k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    public final void m(c cVar, int i) {
        h(i, cVar.a).b(this.a[i], 90.0f, cVar.e, cVar.c, g(i, cVar.a));
        float a2 = a(i);
        this.b[i].reset();
        f(i, cVar.c, this.d);
        Matrix matrix = this.b[i];
        PointF pointF = this.d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.b[i].preRotate(a2);
    }

    public final void n(int i) {
        this.h[0] = this.a[i].i();
        this.h[1] = this.a[i].j();
        this.b[i].mapPoints(this.h);
        float a2 = a(i);
        this.c[i].reset();
        Matrix matrix = this.c[i];
        float[] fArr = this.h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.c[i].preRotate(a2);
    }
}
