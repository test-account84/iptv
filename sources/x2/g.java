package x2;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g extends f {
    public f[] F = O();
    public int G;

    public g() {
        M();
        N(this.F);
    }

    public void J(Canvas canvas) {
        f[] fVarArr = this.F;
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                int save = canvas.save();
                fVar.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
    }

    public f K(int i) {
        f[] fVarArr = this.F;
        if (fVarArr == null) {
            return null;
        }
        return fVarArr[i];
    }

    public int L() {
        f[] fVarArr = this.F;
        if (fVarArr == null) {
            return 0;
        }
        return fVarArr.length;
    }

    public final void M() {
        f[] fVarArr = this.F;
        if (fVarArr != null) {
            for (f fVar : fVarArr) {
                fVar.setCallback(this);
            }
        }
    }

    public abstract f[] O();

    public int c() {
        return this.G;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        J(canvas);
    }

    public boolean isRunning() {
        return v2.a.b(this.F) || super.isRunning();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        for (f fVar : this.F) {
            fVar.setBounds(rect);
        }
    }

    public ValueAnimator r() {
        return null;
    }

    public void start() {
        super.start();
        v2.a.e(this.F);
    }

    public void stop() {
        super.stop();
        v2.a.f(this.F);
    }

    public void u(int i) {
        this.G = i;
        for (int i2 = 0; i2 < L(); i2++) {
            K(i2).u(i);
        }
    }

    public void N(f... fVarArr) {
    }

    public void b(Canvas canvas) {
    }
}
