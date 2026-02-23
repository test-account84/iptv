package l5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import l5.k;
import l5.l;
import l5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g extends Drawable implements H.b, n {
    public static final String y = "g";
    public static final Paint z;
    public c a;
    public final m.g[] c;
    public final m.g[] d;
    public final BitSet e;
    public boolean f;
    public final Matrix g;
    public final Path h;
    public final Path i;
    public final RectF j;
    public final RectF k;
    public final Region l;
    public final Region m;
    public k n;
    public final Paint o;
    public final Paint p;
    public final k5.a q;
    public final l.b r;
    public final l s;
    public PorterDuffColorFilter t;
    public PorterDuffColorFilter u;
    public int v;
    public final RectF w;
    public boolean x;

    public class a implements l.b {
        public a() {
        }

        public void a(m mVar, Matrix matrix, int i) {
            g.b(g.this).set(i, mVar.e());
            g.c(g.this)[i] = mVar.f(matrix);
        }

        public void b(m mVar, Matrix matrix, int i) {
            g.b(g.this).set(i + 4, mVar.e());
            g.d(g.this)[i] = mVar.f(matrix);
        }
    }

    public class b implements k.c {
        public final /* synthetic */ float a;

        public b(float f) {
            this.a = f;
        }

        public l5.c a(l5.c cVar) {
            return cVar instanceof i ? cVar : new l5.b(this.a, cVar);
        }
    }

    public static final class c extends Drawable.ConstantState {
        public k a;
        public c5.a b;
        public ColorFilter c;
        public ColorStateList d;
        public ColorStateList e;
        public ColorStateList f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public c(c cVar) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.b = cVar.b;
            this.l = cVar.l;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.h = cVar.h;
            this.g = cVar.g;
            this.m = cVar.m;
            this.j = cVar.j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.k = cVar.k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f = cVar.f;
            this.v = cVar.v;
            if (cVar.i != null) {
                this.i = new Rect(cVar.i);
            }
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            g gVar = new g(this, null);
            g.e(gVar, true);
            return gVar;
        }

        public c(k kVar, c5.a aVar) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = kVar;
            this.b = aVar;
        }
    }

    static {
        Paint paint = new Paint(1);
        z = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public g() {
        this(new k());
    }

    public static int Q(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    public static /* synthetic */ BitSet b(g gVar) {
        return gVar.e;
    }

    public static /* synthetic */ m.g[] c(g gVar) {
        return gVar.c;
    }

    public static /* synthetic */ m.g[] d(g gVar) {
        return gVar.d;
    }

    public static /* synthetic */ boolean e(g gVar, boolean z2) {
        gVar.f = z2;
        return z2;
    }

    public static g m(Context context, float f) {
        int c2 = Z4.a.c(context, R4.b.m, g.class.getSimpleName());
        g gVar = new g();
        gVar.L(context);
        gVar.W(ColorStateList.valueOf(c2));
        gVar.V(f);
        return gVar;
    }

    public int A() {
        c cVar = this.a;
        return (int) (cVar.s * Math.sin(Math.toRadians(cVar.t)));
    }

    public int B() {
        c cVar = this.a;
        return (int) (cVar.s * Math.cos(Math.toRadians(cVar.t)));
    }

    public k C() {
        return this.a.a;
    }

    public final float D() {
        if (K()) {
            return this.p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float E() {
        return this.a.a.r().a(u());
    }

    public float F() {
        return this.a.a.t().a(u());
    }

    public float G() {
        return this.a.p;
    }

    public float H() {
        return w() + G();
    }

    public final boolean I() {
        c cVar = this.a;
        int i = cVar.q;
        return i != 1 && cVar.r > 0 && (i == 2 || S());
    }

    public final boolean J() {
        Paint.Style style = this.a.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean K() {
        Paint.Style style = this.a.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.p.getStrokeWidth() > 0.0f;
    }

    public void L(Context context) {
        this.a.b = new c5.a(context);
        g0();
    }

    public final void M() {
        super.invalidateSelf();
    }

    public boolean N() {
        c5.a aVar = this.a.b;
        return aVar != null && aVar.d();
    }

    public boolean O() {
        return this.a.a.u(u());
    }

    public final void P(Canvas canvas) {
        if (I()) {
            canvas.save();
            R(canvas);
            if (this.x) {
                int width = (int) (this.w.width() - getBounds().width());
                int height = (int) (this.w.height() - getBounds().height());
                if (width < 0 || height < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.w.width()) + (this.a.r * 2) + width, ((int) this.w.height()) + (this.a.r * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f = (getBounds().left - this.a.r) - width;
                float f2 = (getBounds().top - this.a.r) - height;
                canvas2.translate(-f, -f2);
                n(canvas2);
                canvas.drawBitmap(createBitmap, f, f2, (Paint) null);
                createBitmap.recycle();
            } else {
                n(canvas);
            }
            canvas.restore();
        }
    }

    public final void R(Canvas canvas) {
        canvas.translate(A(), B());
    }

    public boolean S() {
        return (O() || this.h.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void T(float f) {
        setShapeAppearanceModel(this.a.a.w(f));
    }

    public void U(l5.c cVar) {
        setShapeAppearanceModel(this.a.a.x(cVar));
    }

    public void V(float f) {
        c cVar = this.a;
        if (cVar.o != f) {
            cVar.o = f;
            g0();
        }
    }

    public void W(ColorStateList colorStateList) {
        c cVar = this.a;
        if (cVar.d != colorStateList) {
            cVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    public void X(float f) {
        c cVar = this.a;
        if (cVar.k != f) {
            cVar.k = f;
            this.f = true;
            invalidateSelf();
        }
    }

    public void Y(int i, int i2, int i3, int i4) {
        c cVar = this.a;
        if (cVar.i == null) {
            cVar.i = new Rect();
        }
        this.a.i.set(i, i2, i3, i4);
        invalidateSelf();
    }

    public void Z(float f) {
        c cVar = this.a;
        if (cVar.n != f) {
            cVar.n = f;
            g0();
        }
    }

    public void a0(float f, int i) {
        d0(f);
        c0(ColorStateList.valueOf(i));
    }

    public void b0(float f, ColorStateList colorStateList) {
        d0(f);
        c0(colorStateList);
    }

    public void c0(ColorStateList colorStateList) {
        c cVar = this.a;
        if (cVar.e != colorStateList) {
            cVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public void d0(float f) {
        this.a.l = f;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        this.o.setColorFilter(this.t);
        int alpha = this.o.getAlpha();
        this.o.setAlpha(Q(alpha, this.a.m));
        this.p.setColorFilter(this.u);
        this.p.setStrokeWidth(this.a.l);
        int alpha2 = this.p.getAlpha();
        this.p.setAlpha(Q(alpha2, this.a.m));
        if (this.f) {
            i();
            g(u(), this.h);
            this.f = false;
        }
        P(canvas);
        if (J()) {
            o(canvas);
        }
        if (K()) {
            r(canvas);
        }
        this.o.setAlpha(alpha);
        this.p.setAlpha(alpha2);
    }

    public final boolean e0(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.a.d == null || color2 == (colorForState2 = this.a.d.getColorForState(iArr, (color2 = this.o.getColor())))) {
            z2 = false;
        } else {
            this.o.setColor(colorForState2);
            z2 = true;
        }
        if (this.a.e == null || color == (colorForState = this.a.e.getColorForState(iArr, (color = this.p.getColor())))) {
            return z2;
        }
        this.p.setColor(colorForState);
        return true;
    }

    public final PorterDuffColorFilter f(Paint paint, boolean z2) {
        if (!z2) {
            return null;
        }
        int color = paint.getColor();
        int l = l(color);
        this.v = l;
        if (l != color) {
            return new PorterDuffColorFilter(l, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    public final boolean f0() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        c cVar = this.a;
        this.t = k(cVar.g, cVar.h, this.o, true);
        c cVar2 = this.a;
        this.u = k(cVar2.f, cVar2.h, this.p, false);
        c cVar3 = this.a;
        if (cVar3.u) {
            this.q.d(cVar3.g.getColorForState(getState(), 0));
        }
        return (O.c.a(porterDuffColorFilter, this.t) && O.c.a(porterDuffColorFilter2, this.u)) ? false : true;
    }

    public final void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.a.j != 1.0f) {
            this.g.reset();
            Matrix matrix = this.g;
            float f = this.a.j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.g);
        }
        path.computeBounds(this.w, true);
    }

    public final void g0() {
        float H = H();
        this.a.r = (int) Math.ceil(0.75f * H);
        this.a.s = (int) Math.ceil(H * 0.25f);
        f0();
        M();
    }

    public int getAlpha() {
        return this.a.m;
    }

    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        if (this.a.q == 2) {
            return;
        }
        if (O()) {
            outline.setRoundRect(getBounds(), E() * this.a.k);
            return;
        }
        g(u(), this.h);
        if (this.h.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.h);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.a.i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public Region getTransparentRegion() {
        this.l.set(getBounds());
        g(u(), this.h);
        this.m.setPath(this.h, this.l);
        this.l.op(this.m, Region.Op.DIFFERENCE);
        return this.l;
    }

    public final void h(RectF rectF, Path path) {
        l lVar = this.s;
        c cVar = this.a;
        lVar.e(cVar.a, cVar.k, rectF, this.r, path);
    }

    public final void i() {
        k y2 = C().y(new b(-D()));
        this.n = y2;
        this.s.d(y2, this.a.k, v(), this.i);
    }

    public void invalidateSelf() {
        this.f = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.a.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.a.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.a.e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.a.d) != null && colorStateList4.isStateful())));
    }

    public final PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z2) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = l(colorForState);
        }
        this.v = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public final PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z2) {
        return (colorStateList == null || mode == null) ? f(paint, z2) : j(colorStateList, mode, z2);
    }

    public int l(int i) {
        float H = H() + y();
        c5.a aVar = this.a.b;
        return aVar != null ? aVar.c(i, H) : i;
    }

    public Drawable mutate() {
        this.a = new c(this.a);
        return this;
    }

    public final void n(Canvas canvas) {
        if (this.e.cardinality() > 0) {
            Log.w(y, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.a.s != 0) {
            canvas.drawPath(this.h, this.q.c());
        }
        for (int i = 0; i < 4; i++) {
            this.c[i].b(this.q, this.a.r, canvas);
            this.d[i].b(this.q, this.a.r, canvas);
        }
        if (this.x) {
            int A = A();
            int B = B();
            canvas.translate(-A, -B);
            canvas.drawPath(this.h, z);
            canvas.translate(A, B);
        }
    }

    public final void o(Canvas canvas) {
        q(canvas, this.o, this.h, this.a.a, u());
    }

    public void onBoundsChange(Rect rect) {
        this.f = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z2 = e0(iArr) || f0();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        q(canvas, paint, path, this.a.a, rectF);
    }

    public final void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float a2 = kVar.t().a(rectF) * this.a.k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
        }
    }

    public void r(Canvas canvas) {
        q(canvas, this.p, this.i, this.n, v());
    }

    public float s() {
        return this.a.a.j().a(u());
    }

    public void setAlpha(int i) {
        c cVar = this.a;
        if (cVar.m != i) {
            cVar.m = i;
            M();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.c = colorFilter;
        M();
    }

    public void setShapeAppearanceModel(k kVar) {
        this.a.a = kVar;
        invalidateSelf();
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.a.g = colorStateList;
        f0();
        M();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.a;
        if (cVar.h != mode) {
            cVar.h = mode;
            f0();
            M();
        }
    }

    public float t() {
        return this.a.a.l().a(u());
    }

    public RectF u() {
        this.j.set(getBounds());
        return this.j;
    }

    public final RectF v() {
        this.k.set(u());
        float D = D();
        this.k.inset(D, D);
        return this.k;
    }

    public float w() {
        return this.a.o;
    }

    public ColorStateList x() {
        return this.a.d;
    }

    public float y() {
        return this.a.n;
    }

    public int z() {
        return this.v;
    }

    public g(Context context, AttributeSet attributeSet, int i, int i2) {
        this(k.e(context, attributeSet, i, i2).m());
    }

    public g(c cVar) {
        this.c = new m.g[4];
        this.d = new m.g[4];
        this.e = new BitSet(8);
        this.g = new Matrix();
        this.h = new Path();
        this.i = new Path();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new Region();
        this.m = new Region();
        Paint paint = new Paint(1);
        this.o = paint;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        this.q = new k5.a();
        this.s = Looper.getMainLooper().getThread() == Thread.currentThread() ? l.k() : new l();
        this.w = new RectF();
        this.x = true;
        this.a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        f0();
        e0(getState());
        this.r = new a();
    }

    public /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }
}
