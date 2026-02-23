package g2;

import Q1.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import g2.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends e2.b implements f.c {
    public final Paint a;
    public final Rect c;
    public final a d;
    public final Q1.a e;
    public final f f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;

    public static class a extends Drawable.ConstantState {
        public Q1.c a;
        public byte[] b;
        public Context c;
        public S1.g d;
        public int e;
        public int f;
        public a.a g;
        public V1.b h;
        public Bitmap i;

        public a(Q1.c cVar, byte[] bArr, Context context, S1.g gVar, int i, int i2, a.a aVar, V1.b bVar, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.a = cVar;
            this.b = bArr;
            this.h = bVar;
            this.i = bitmap;
            this.c = context.getApplicationContext();
            this.d = gVar;
            this.e = i;
            this.f = i2;
            this.g = aVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new b(this);
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public b(Context context, a.a aVar, V1.b bVar, S1.g gVar, int i, int i2, Q1.c cVar, byte[] bArr, Bitmap bitmap) {
        this(new a(cVar, bArr, context, gVar, i, i2, aVar, bVar, bitmap));
    }

    public void a(int i) {
        if (getCallback() == null) {
            stop();
            i();
            return;
        }
        invalidateSelf();
        if (i == this.e.f() - 1) {
            this.k++;
        }
        int i2 = this.l;
        if (i2 == -1 || this.k < i2) {
            return;
        }
        stop();
    }

    public boolean b() {
        return true;
    }

    public void c(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i != 0) {
            this.l = i;
        } else {
            int j = this.e.j();
            this.l = j != 0 ? j : -1;
        }
    }

    public byte[] d() {
        return this.d.b;
    }

    public void draw(Canvas canvas) {
        if (this.i) {
            return;
        }
        if (this.m) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.c);
            this.m = false;
        }
        Bitmap b = this.f.b();
        if (b == null) {
            b = this.d.i;
        }
        canvas.drawBitmap(b, (Rect) null, this.c, this.a);
    }

    public Bitmap e() {
        return this.d.i;
    }

    public int f() {
        return this.e.f();
    }

    public S1.g g() {
        return this.d.d;
    }

    public Drawable.ConstantState getConstantState() {
        return this.d;
    }

    public int getIntrinsicHeight() {
        return this.d.i.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.d.i.getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public void h() {
        this.i = true;
        a aVar = this.d;
        aVar.h.a(aVar.i);
        this.f.a();
        this.f.h();
    }

    public final void i() {
        this.f.a();
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.g;
    }

    public final void j() {
        this.k = 0;
    }

    public final void k() {
        if (this.e.f() != 1) {
            if (this.g) {
                return;
            }
            this.g = true;
            this.f.g();
        }
        invalidateSelf();
    }

    public final void l() {
        this.g = false;
        this.f.h();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.m = true;
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        this.j = z;
        if (!z) {
            l();
        } else if (this.h) {
            k();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.h = true;
        j();
        if (this.j) {
            k();
        }
    }

    public void stop() {
        this.h = false;
        l();
    }

    public b(a aVar) {
        this.c = new Rect();
        this.j = true;
        this.l = -1;
        if (aVar == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.d = aVar;
        Q1.a aVar2 = new Q1.a(aVar.g);
        this.e = aVar2;
        this.a = new Paint();
        aVar2.n(aVar.a, aVar.b);
        f fVar = new f(aVar.c, this, aVar2, aVar.e, aVar.f);
        this.f = fVar;
        fVar.f(aVar.d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(b bVar, Bitmap bitmap, S1.g gVar) {
        a aVar = bVar.d;
        this(new a(aVar.a, aVar.b, aVar.c, gVar, aVar.e, aVar.f, aVar.g, aVar.h, bitmap));
    }
}
