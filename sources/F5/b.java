package f5;

import P.L;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import f5.r;
import i5.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b {
    public static final boolean t0 = false;
    public static final Paint u0 = null;
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public Typeface D;
    public i5.a E;
    public i5.a F;
    public CharSequence G;
    public CharSequence H;
    public boolean I;
    public boolean K;
    public Bitmap L;
    public Paint M;
    public float N;
    public float O;
    public float P;
    public float Q;
    public float R;
    public int S;
    public int[] T;
    public boolean U;
    public final TextPaint V;
    public final TextPaint W;
    public TimeInterpolator X;
    public TimeInterpolator Y;
    public float Z;
    public final View a;
    public float a0;
    public boolean b;
    public float b0;
    public float c;
    public ColorStateList c0;
    public boolean d;
    public float d0;
    public float e;
    public float e0;
    public float f;
    public float f0;
    public int g;
    public ColorStateList g0;
    public final Rect h;
    public float h0;
    public final Rect i;
    public float i0;
    public final RectF j;
    public float j0;
    public StaticLayout k0;
    public float l0;
    public float m0;
    public float n0;
    public ColorStateList o;
    public CharSequence o0;
    public ColorStateList p;
    public int q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;
    public Typeface x;
    public Typeface y;
    public Typeface z;
    public int k = 16;
    public int l = 16;
    public float m = 15.0f;
    public float n = 15.0f;
    public boolean J = true;
    public int p0 = 1;
    public float q0 = 0.0f;
    public float r0 = 1.0f;
    public int s0 = r.n;

    public class a implements a.a {
        public a() {
        }

        public void a(Typeface typeface) {
            b.this.T(typeface);
        }
    }

    public b(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.i = new Rect();
        this.h = new Rect();
        this.j = new RectF();
        this.f = e();
        H(view.getContext().getResources().getConfiguration());
    }

    public static boolean C(float f, float f2) {
        return Math.abs(f - f2) < 1.0E-5f;
    }

    public static float G(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return S4.a.a(f, f2, f3);
    }

    public static boolean M(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    public static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), Math.round((Color.red(i) * f2) + (Color.red(i2) * f)), Math.round((Color.green(i) * f2) + (Color.green(i2) * f)), Math.round((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    public final void A(TextPaint textPaint) {
        textPaint.setTextSize(this.m);
        textPaint.setTypeface(this.A);
        textPaint.setLetterSpacing(this.i0);
    }

    public final void B(float f) {
        if (this.d) {
            this.j.set(f < this.f ? this.h : this.i);
            return;
        }
        this.j.left = G(this.h.left, this.i.left, f, this.X);
        this.j.top = G(this.r, this.s, f, this.X);
        this.j.right = G(this.h.right, this.i.right, f, this.X);
        this.j.bottom = G(this.h.bottom, this.i.bottom, f, this.X);
    }

    public final boolean D() {
        return L.E(this.a) == 1;
    }

    public final boolean E() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.o) != null && colorStateList.isStateful());
    }

    public final boolean F(CharSequence charSequence, boolean z) {
        return (z ? N.o.d : N.o.c).a(charSequence, 0, charSequence.length());
    }

    public void H(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.z;
            if (typeface != null) {
                this.y = i5.j.b(configuration, typeface);
            }
            Typeface typeface2 = this.C;
            if (typeface2 != null) {
                this.B = i5.j.b(configuration, typeface2);
            }
            Typeface typeface3 = this.y;
            if (typeface3 == null) {
                typeface3 = this.z;
            }
            this.x = typeface3;
            Typeface typeface4 = this.B;
            if (typeface4 == null) {
                typeface4 = this.C;
            }
            this.A = typeface4;
            L(true);
        }
    }

    public final float I(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void J() {
        this.b = this.i.width() > 0 && this.i.height() > 0 && this.h.width() > 0 && this.h.height() > 0;
    }

    public void K() {
        L(false);
    }

    public void L(boolean z) {
        if ((this.a.getHeight() <= 0 || this.a.getWidth() <= 0) && !z) {
            return;
        }
        b(z);
        c();
    }

    public void N(int i, int i2, int i3, int i4) {
        if (M(this.i, i, i2, i3, i4)) {
            return;
        }
        this.i.set(i, i2, i3, i4);
        this.U = true;
        J();
    }

    public void O(Rect rect) {
        N(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void P(int i) {
        i5.d dVar = new i5.d(this.a.getContext(), i);
        if (dVar.i() != null) {
            this.p = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.n = dVar.j();
        }
        ColorStateList colorStateList = dVar.c;
        if (colorStateList != null) {
            this.c0 = colorStateList;
        }
        this.a0 = dVar.h;
        this.b0 = dVar.i;
        this.Z = dVar.j;
        this.h0 = dVar.l;
        i5.a aVar = this.F;
        if (aVar != null) {
            aVar.c();
        }
        this.F = new i5.a(new a(), dVar.e());
        dVar.h(this.a.getContext(), this.F);
        K();
    }

    public final void Q(float f) {
        this.m0 = f;
        L.j0(this.a);
    }

    public void R(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            K();
        }
    }

    public void S(int i) {
        if (this.l != i) {
            this.l = i;
            K();
        }
    }

    public void T(Typeface typeface) {
        if (U(typeface)) {
            K();
        }
    }

    public final boolean U(Typeface typeface) {
        i5.a aVar = this.F;
        if (aVar != null) {
            aVar.c();
        }
        if (this.z == typeface) {
            return false;
        }
        this.z = typeface;
        Typeface b = i5.j.b(this.a.getContext().getResources().getConfiguration(), typeface);
        this.y = b;
        if (b == null) {
            b = this.z;
        }
        this.x = b;
        return true;
    }

    public void V(int i, int i2, int i3, int i4) {
        if (M(this.h, i, i2, i3, i4)) {
            return;
        }
        this.h.set(i, i2, i3, i4);
        this.U = true;
        J();
    }

    public void W(Rect rect) {
        V(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void X(float f) {
        if (this.i0 != f) {
            this.i0 = f;
            K();
        }
    }

    public final void Y(float f) {
        this.n0 = f;
        L.j0(this.a);
    }

    public void Z(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            K();
        }
    }

    public void a0(int i) {
        if (this.k != i) {
            this.k = i;
            K();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(boolean r10) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.b.b(boolean):void");
    }

    public void b0(float f) {
        if (this.m != f) {
            this.m = f;
            K();
        }
    }

    public final void c() {
        g(this.c);
    }

    public final boolean c0(Typeface typeface) {
        i5.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.C == typeface) {
            return false;
        }
        this.C = typeface;
        Typeface b = i5.j.b(this.a.getContext().getResources().getConfiguration(), typeface);
        this.B = b;
        if (b == null) {
            b = this.C;
        }
        this.A = b;
        return true;
    }

    public final float d(float f) {
        float f2 = this.f;
        return f <= f2 ? S4.a.b(1.0f, 0.0f, this.e, f2, f) : S4.a.b(0.0f, 1.0f, f2, 1.0f, f);
    }

    public void d0(float f) {
        float a2 = J.a.a(f, 0.0f, 1.0f);
        if (a2 != this.c) {
            this.c = a2;
            c();
        }
    }

    public final float e() {
        float f = this.e;
        return f + ((1.0f - f) * 0.5f);
    }

    public final void e0(float f) {
        h(f);
        boolean z = t0 && this.N != 1.0f;
        this.K = z;
        if (z) {
            n();
        }
        L.j0(this.a);
    }

    public final boolean f(CharSequence charSequence) {
        boolean D = D();
        return this.J ? F(charSequence, D) : D;
    }

    public void f0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        K();
    }

    public final void g(float f) {
        float f2;
        B(f);
        if (!this.d) {
            this.v = G(this.t, this.u, f, this.X);
            this.w = G(this.r, this.s, f, this.X);
            e0(f);
            f2 = f;
        } else if (f < this.f) {
            this.v = this.t;
            this.w = this.r;
            e0(0.0f);
            f2 = 0.0f;
        } else {
            this.v = this.u;
            this.w = this.s - Math.max(0, this.g);
            e0(1.0f);
            f2 = 1.0f;
        }
        TimeInterpolator timeInterpolator = S4.a.b;
        Q(1.0f - G(0.0f, 1.0f, 1.0f - f, timeInterpolator));
        Y(G(1.0f, 0.0f, f, timeInterpolator));
        if (this.p != this.o) {
            this.V.setColor(a(v(), t(), f2));
        } else {
            this.V.setColor(t());
        }
        float f3 = this.h0;
        float f4 = this.i0;
        if (f3 != f4) {
            this.V.setLetterSpacing(G(f4, f3, f, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f3);
        }
        this.P = G(this.d0, this.Z, f, null);
        this.Q = G(this.e0, this.a0, f, null);
        this.R = G(this.f0, this.b0, f, null);
        int a2 = a(u(this.g0), u(this.c0), f);
        this.S = a2;
        this.V.setShadowLayer(this.P, this.Q, this.R, a2);
        if (this.d) {
            this.V.setAlpha((int) (d(f) * this.V.getAlpha()));
        }
        L.j0(this.a);
    }

    public final boolean g0(int[] iArr) {
        this.T = iArr;
        if (!E()) {
            return false;
        }
        K();
        return true;
    }

    public final void h(float f) {
        i(f, false);
    }

    public void h0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            K();
        }
    }

    public final void i(float f, boolean z) {
        boolean z2;
        float f2;
        float f3;
        boolean z3;
        if (this.G == null) {
            return;
        }
        float width = this.i.width();
        float width2 = this.h.width();
        if (C(f, 1.0f)) {
            f2 = this.n;
            f3 = this.h0;
            this.N = 1.0f;
            Typeface typeface = this.D;
            Typeface typeface2 = this.x;
            if (typeface != typeface2) {
                this.D = typeface2;
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            float f4 = this.m;
            float f5 = this.i0;
            Typeface typeface3 = this.D;
            Typeface typeface4 = this.A;
            if (typeface3 != typeface4) {
                this.D = typeface4;
                z2 = true;
            } else {
                z2 = false;
            }
            if (C(f, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = G(this.m, this.n, f, this.Y) / this.m;
            }
            float f6 = this.n / this.m;
            width = (!z && width2 * f6 > width) ? Math.min(width / f6, width2) : width2;
            f2 = f4;
            f3 = f5;
            z3 = z2;
        }
        if (width > 0.0f) {
            z3 = ((this.O > f2 ? 1 : (this.O == f2 ? 0 : -1)) != 0) || ((this.j0 > f3 ? 1 : (this.j0 == f3 ? 0 : -1)) != 0) || this.U || z3;
            this.O = f2;
            this.j0 = f3;
            this.U = false;
        }
        if (this.H == null || z3) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.D);
            this.V.setLetterSpacing(this.j0);
            this.V.setLinearText(this.N != 1.0f);
            this.I = f(this.G);
            StaticLayout k = k(k0() ? this.p0 : 1, width, this.I);
            this.k0 = k;
            this.H = k.getText();
        }
    }

    public void i0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        K();
    }

    public final void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    public void j0(Typeface typeface) {
        boolean U = U(typeface);
        boolean c0 = c0(typeface);
        if (U || c0) {
            K();
        }
    }

    public final StaticLayout k(int i, float f, boolean z) {
        StaticLayout staticLayout;
        try {
            staticLayout = r.c(this.G, this.V, (int) f).e(TextUtils.TruncateAt.END).h(z).d(i == 1 ? Layout.Alignment.ALIGN_NORMAL : y()).g(false).j(i).i(this.q0, this.r0).f(this.s0).a();
        } catch (r.a e) {
            Log.e("CollapsingTextHelper", e.getCause().getMessage(), e);
            staticLayout = null;
        }
        return (StaticLayout) O.h.f(staticLayout);
    }

    public final boolean k0() {
        return this.p0 > 1 && (!this.I || this.d) && !this.K;
    }

    public void l(Canvas canvas) {
        int save = canvas.save();
        if (this.H == null || !this.b) {
            return;
        }
        this.V.setTextSize(this.O);
        float f = this.v;
        float f2 = this.w;
        boolean z = this.K && this.L != null;
        float f3 = this.N;
        if (f3 != 1.0f && !this.d) {
            canvas.scale(f3, f3, f, f2);
        }
        if (z) {
            canvas.drawBitmap(this.L, f, f2, this.M);
            canvas.restoreToCount(save);
            return;
        }
        if (!k0() || (this.d && this.c <= this.f)) {
            canvas.translate(f, f2);
            this.k0.draw(canvas);
        } else {
            m(canvas, this.v - this.k0.getLineStart(0), f2);
        }
        canvas.restoreToCount(save);
    }

    public final void m(Canvas canvas, float f, float f2) {
        int alpha = this.V.getAlpha();
        canvas.translate(f, f2);
        float f3 = alpha;
        this.V.setAlpha((int) (this.n0 * f3));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            TextPaint textPaint = this.V;
            textPaint.setShadowLayer(this.P, this.Q, this.R, Z4.a.a(this.S, textPaint.getAlpha()));
        }
        this.k0.draw(canvas);
        this.V.setAlpha((int) (this.m0 * f3));
        if (i >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, Z4.a.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.k0.getLineBaseline(0);
        CharSequence charSequence = this.o0;
        float f4 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f4, this.V);
        if (i >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.d) {
            return;
        }
        String trim = this.o0.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.k0.getLineEnd(0), str.length()), 0.0f, f4, this.V);
    }

    public final void n() {
        if (this.L != null || this.h.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.k0.getWidth();
        int height = this.k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    public void o(RectF rectF, int i, int i2) {
        this.I = f(this.G);
        rectF.left = r(i, i2);
        rectF.top = this.i.top;
        rectF.right = s(rectF, i, i2);
        rectF.bottom = this.i.top + q();
    }

    public ColorStateList p() {
        return this.p;
    }

    public float q() {
        z(this.W);
        return -this.W.ascent();
    }

    public final float r(int i, int i2) {
        return (i2 == 17 || (i2 & 7) == 1) ? (i / 2.0f) - (this.l0 / 2.0f) : ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.I ? this.i.left : this.i.right - this.l0 : this.I ? this.i.right - this.l0 : this.i.left;
    }

    public final float s(RectF rectF, int i, int i2) {
        return (i2 == 17 || (i2 & 7) == 1) ? (i / 2.0f) + (this.l0 / 2.0f) : ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.I ? rectF.left + this.l0 : this.i.right : this.I ? this.i.right : rectF.left + this.l0;
    }

    public int t() {
        return u(this.p);
    }

    public final int u(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final int v() {
        return u(this.o);
    }

    public float w() {
        A(this.W);
        return -this.W.ascent();
    }

    public float x() {
        return this.c;
    }

    public final Layout.Alignment y() {
        int b = P.p.b(this.k, this.I ? 1 : 0) & 7;
        return b != 1 ? b != 5 ? this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    public final void z(TextPaint textPaint) {
        textPaint.setTextSize(this.n);
        textPaint.setTypeface(this.x);
        textPaint.setLetterSpacing(this.h0);
    }
}
