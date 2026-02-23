package net.orandja.shadowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.renderscript.Type;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class ShadowLayout extends FrameLayout {
    public static final float C;
    public static final float D;
    public final Paint a;
    public final Paint c;
    public final N8.a d;
    public final N8.a e;
    public final N8.a f;
    public final N8.a g;
    public final N8.a h;
    public final N8.a i;
    public final N8.a j;
    public final N8.a k;
    public final N8.a l;
    public final N8.a m;
    public final Rect n;
    public Bitmap o;
    public Canvas p;
    public RenderScript q;
    public ScriptIntrinsicBlur r;
    public Allocation s;
    public Allocation t;
    public Boolean u;
    public final Rect v;
    public float w;
    public Boolean x;
    public Boolean y;
    public Boolean z;
    public static final /* synthetic */ C8.i[] B = {C.e(new q(C.b(ShadowLayout.class), "shadow_x_shift", "getShadow_x_shift()F")), C.e(new q(C.b(ShadowLayout.class), "shadow_y_shift", "getShadow_y_shift()F")), C.e(new q(C.b(ShadowLayout.class), "shadow_downscale", "getShadow_downscale()F")), C.e(new q(C.b(ShadowLayout.class), "shadow_radius", "getShadow_radius()F")), C.e(new q(C.b(ShadowLayout.class), "realRadius", "getRealRadius()F")), C.e(new q(C.b(ShadowLayout.class), "shadow_cast_only_background", "getShadow_cast_only_background()Z")), C.e(new q(C.b(ShadowLayout.class), "shadow_with_content", "getShadow_with_content()Z")), C.e(new q(C.b(ShadowLayout.class), "shadow_with_color", "getShadow_with_color()Z")), C.e(new q(C.b(ShadowLayout.class), "shadow_with_dpi_scale", "getShadow_with_dpi_scale()Z")), C.e(new q(C.b(ShadowLayout.class), "shadow_with_css_scale", "getShadow_with_css_scale()Z"))};
    public static final a A = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b extends ViewOutlineProvider {
        public void getOutline(View view, Outline outline) {
        }
    }

    public static final class c extends m implements l {
        public static final c a = new c();

        public c() {
            super(1);
        }

        public final float a(float f) {
            return B8.h.g(f, 0.0f, 25.0f);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Float.valueOf(a(((Number) obj).floatValue()));
        }
    }

    public static final class d extends m implements l {
        public static final d a = new d();

        public d() {
            super(1);
        }

        public final float a(float f) {
            return B8.h.b(f, 0.1f);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Float.valueOf(a(((Number) obj).floatValue()));
        }
    }

    public static final class e extends m implements l {
        public e() {
            super(1);
        }

        public final void a(float f) {
            ShadowLayout shadowLayout = ShadowLayout.this;
            ShadowLayout.f(shadowLayout, shadowLayout.getShadow_radius() / f);
            ShadowLayout.g(ShadowLayout.this);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).floatValue());
            return k8.q.a;
        }
    }

    public static final class f extends m implements l {
        public static final f a = new f();

        public f() {
            super(1);
        }

        public final float a(float f) {
            return B8.h.b(f, 0.0f);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Float.valueOf(a(((Number) obj).floatValue()));
        }
    }

    public static final class g extends m implements l {
        public g() {
            super(1);
        }

        public final void a(float f) {
            ShadowLayout shadowLayout = ShadowLayout.this;
            ShadowLayout.f(shadowLayout, f / shadowLayout.getShadow_downscale());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).floatValue());
            return k8.q.a;
        }
    }

    public static final class h extends m implements l {
        public h() {
            super(1);
        }

        public final void a(boolean z) {
            ShadowLayout.a(ShadowLayout.this);
            ShadowLayout.g(ShadowLayout.this);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return k8.q.a;
        }
    }

    public static final class i extends m implements l {
        public i() {
            super(1);
        }

        public final void a(boolean z) {
            ShadowLayout.a(ShadowLayout.this);
            ShadowLayout.g(ShadowLayout.this);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return k8.q.a;
        }
    }

    public static final class j extends m implements l {
        public j() {
            super(1);
        }

        public final void a(boolean z) {
            ShadowLayout.a(ShadowLayout.this);
            ShadowLayout.g(ShadowLayout.this);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return k8.q.a;
        }
    }

    static {
        float f2 = Resources.getSystem().getDisplayMetrics().densityDpi / 160;
        C = f2;
        D = (float) (1.0d / f2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.l.e(context, "context");
    }

    public static final /* synthetic */ void a(ShadowLayout shadowLayout) {
        shadowLayout.h();
    }

    public static final /* synthetic */ float b(ShadowLayout shadowLayout) {
        return shadowLayout.getCssRatio();
    }

    public static final /* synthetic */ int c(ShadowLayout shadowLayout) {
        return shadowLayout.getPixelsOverBoundaries();
    }

    public static final /* synthetic */ float d(ShadowLayout shadowLayout) {
        return shadowLayout.getRatioDpToPixels();
    }

    public static final /* synthetic */ float e(ShadowLayout shadowLayout) {
        return shadowLayout.getRatioPixelsToDp();
    }

    public static final /* synthetic */ void f(ShadowLayout shadowLayout, float f2) {
        shadowLayout.setRealRadius(f2);
    }

    public static final /* synthetic */ void g(ShadowLayout shadowLayout) {
        shadowLayout.j();
    }

    private final Matrix getBlurSMatrix() {
        return G.c.a((e(this) / getShadow_downscale()) / b(this), (e(this) / getShadow_downscale()) / b(this));
    }

    private final Matrix getBlurTMatrix() {
        return G.c.b(c(this), c(this));
    }

    private final float getCssRatio() {
        return getShadow_with_css_scale() ? 1.6666666f : 1.0f;
    }

    private final Matrix getDrawSMatrix() {
        return G.c.a(d(this) * getShadow_downscale() * b(this), d(this) * getShadow_downscale() * b(this));
    }

    private final Matrix getDrawTMatrix() {
        return G.c.b(-(c(this) * d(this) * getShadow_downscale() * b(this)), -(c(this) * d(this) * getShadow_downscale() * b(this)));
    }

    private final int getPixelsOverBoundaries() {
        if (getShadow_downscale() < 1.0f) {
            return 25;
        }
        return (int) Math.ceil(getShadow_downscale() * 25.0f);
    }

    private final float getRatioDpToPixels() {
        if (getShadow_with_dpi_scale()) {
            return C;
        }
        return 1.0f;
    }

    private final float getRatioPixelsToDp() {
        if (getShadow_with_dpi_scale()) {
            return D;
        }
        return 1.0f;
    }

    private final float getRealRadius() {
        return ((Number) this.h.a(this, B[4])).floatValue();
    }

    private final k8.i getScript() {
        RenderScript renderScript = this.q;
        if (renderScript == null) {
            renderScript = RenderScript.create(getContext());
        }
        if (!kotlin.jvm.internal.l.a(this.u, Boolean.valueOf(getShadow_with_color()))) {
            this.u = Boolean.valueOf(getShadow_with_color());
            this.r = null;
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.r;
        if (scriptIntrinsicBlur != null) {
            kotlin.jvm.internal.l.b(scriptIntrinsicBlur);
            kotlin.jvm.internal.l.b(renderScript);
            return new k8.i(scriptIntrinsicBlur, renderScript);
        }
        ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, getShadow_with_color() ? Element.U8_4(renderScript) : Element.U8(renderScript));
        this.r = create;
        kotlin.jvm.internal.l.b(create);
        kotlin.jvm.internal.l.b(renderScript);
        return new k8.i(create, renderScript);
    }

    private final Matrix getShiftTMatrix() {
        return G.c.b((getShadow_x_shift() / getShadow_downscale()) / b(this), (getShadow_y_shift() / getShadow_downscale()) / b(this));
    }

    private final void setRealRadius(float f2) {
        this.h.c(this, B[4], Float.valueOf(f2));
    }

    /* JADX WARN: Finally extract failed */
    public void draw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        if (isInEditMode()) {
            super.draw(canvas);
            return;
        }
        Canvas canvas2 = this.p;
        if (canvas2 != null) {
            kotlin.jvm.internal.l.b(canvas2);
            Canvas canvas3 = this.p;
            kotlin.jvm.internal.l.b(canvas3);
            canvas2.drawRect(canvas3.getClipBounds(), this.c);
            Canvas canvas4 = this.p;
            kotlin.jvm.internal.l.b(canvas4);
            Matrix b2 = G.c.b(c(this), c(this));
            Matrix a2 = G.c.a((e(this) / getShadow_downscale()) / b(this), (e(this) / getShadow_downscale()) / b(this));
            Matrix matrix = new Matrix(b2);
            matrix.preConcat(a2);
            int save = canvas4.save();
            canvas4.concat(matrix);
            try {
                if (getShadow_cast_only_background()) {
                    getBackground().setBounds(this.n);
                    Drawable background = getBackground();
                    if (background != null) {
                        Canvas canvas5 = this.p;
                        kotlin.jvm.internal.l.b(canvas5);
                        background.draw(canvas5);
                    }
                } else {
                    super.draw(this.p);
                }
                canvas4.restoreToCount(save);
                if (getRealRadius() > 0.0f) {
                    ScriptIntrinsicBlur scriptIntrinsicBlur = (ScriptIntrinsicBlur) getScript().a();
                    scriptIntrinsicBlur.setRadius(getRealRadius());
                    Allocation allocation = this.s;
                    if (allocation != null) {
                        allocation.copyFrom(this.o);
                    }
                    scriptIntrinsicBlur.forEach(this.t);
                    Allocation allocation2 = this.t;
                    if (allocation2 != null) {
                        allocation2.copyTo(this.o);
                    }
                }
                Matrix b3 = G.c.b(-(c(this) * d(this) * getShadow_downscale() * b(this)), -(c(this) * d(this) * getShadow_downscale() * b(this)));
                Matrix a3 = G.c.a(d(this) * getShadow_downscale() * b(this), d(this) * getShadow_downscale() * b(this));
                Matrix matrix2 = new Matrix(b3);
                matrix2.preConcat(a3);
                Matrix b4 = G.c.b((getShadow_x_shift() / getShadow_downscale()) / b(this), (getShadow_y_shift() / getShadow_downscale()) / b(this));
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.preConcat(b4);
                int save2 = canvas.save();
                canvas.concat(matrix3);
                try {
                    Bitmap bitmap = this.o;
                    kotlin.jvm.internal.l.b(bitmap);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.a);
                } finally {
                    canvas.restoreToCount(save2);
                }
            } catch (Throwable th) {
                canvas4.restoreToCount(save);
                throw th;
            }
        }
        if (getShadow_with_content()) {
            super.draw(canvas);
        }
    }

    @NotNull
    public ViewOutlineProvider getOutlineProvider() {
        return new b();
    }

    public final boolean getShadow_cast_only_background() {
        return ((Boolean) this.i.a(this, B[5])).booleanValue();
    }

    public final int getShadow_color() {
        return this.a.getColor();
    }

    public final float getShadow_downscale() {
        return ((Number) this.f.a(this, B[2])).floatValue();
    }

    public final float getShadow_radius() {
        return ((Number) this.g.a(this, B[3])).floatValue();
    }

    public final boolean getShadow_with_color() {
        return ((Boolean) this.k.a(this, B[7])).booleanValue();
    }

    public final boolean getShadow_with_content() {
        return ((Boolean) this.j.a(this, B[6])).booleanValue();
    }

    public final boolean getShadow_with_css_scale() {
        return ((Boolean) this.m.a(this, B[9])).booleanValue();
    }

    public final boolean getShadow_with_dpi_scale() {
        return ((Boolean) this.l.a(this, B[8])).booleanValue();
    }

    public final float getShadow_x_shift() {
        return ((Number) this.d.a(this, B[0])).floatValue();
    }

    public final float getShadow_y_shift() {
        return ((Number) this.e.a(this, B[1])).floatValue();
    }

    public final void h() {
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.o = null;
        this.p = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.r;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        this.r = null;
        Allocation allocation = this.s;
        if (allocation != null) {
            allocation.destroy();
        }
        this.s = null;
        Allocation allocation2 = this.t;
        if (allocation2 != null) {
            allocation2.destroy();
        }
        this.t = null;
        this.v.setEmpty();
        this.w = 0.0f;
        this.u = null;
        this.x = null;
        this.y = null;
        this.z = null;
    }

    public final void i(int i2, int i3) {
        this.n.set(0, 0, i2, i3);
        j();
    }

    public final void j() {
        if (this.n.isEmpty()) {
            return;
        }
        if (isAttachedToWindow() && kotlin.jvm.internal.l.a(this.v, this.n) && getShadow_downscale() == this.w && kotlin.jvm.internal.l.a(Boolean.valueOf(getShadow_with_color()), this.x) && kotlin.jvm.internal.l.a(Boolean.valueOf(getShadow_with_dpi_scale()), this.y) && kotlin.jvm.internal.l.a(Boolean.valueOf(getShadow_with_css_scale()), this.z)) {
            return;
        }
        this.v.set(this.n);
        this.w = getShadow_downscale();
        this.x = Boolean.valueOf(getShadow_with_color());
        this.x = Boolean.valueOf(getShadow_with_color());
        this.y = Boolean.valueOf(getShadow_with_dpi_scale());
        this.z = Boolean.valueOf(getShadow_with_css_scale());
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.o = Bitmap.createBitmap((int) (((float) Math.ceil(((this.n.width() * getRatioPixelsToDp()) / getShadow_downscale()) / getCssRatio())) + (getPixelsOverBoundaries() * 2)), (int) (((float) Math.ceil(((this.n.height() * getRatioPixelsToDp()) / getShadow_downscale()) / getCssRatio())) + (getPixelsOverBoundaries() * 2)), getShadow_with_color() ? Bitmap.Config.ARGB_8888 : Bitmap.Config.ALPHA_8);
        Bitmap bitmap2 = this.o;
        kotlin.jvm.internal.l.b(bitmap2);
        this.p = new Canvas(bitmap2);
        k8.i script = getScript();
        ScriptIntrinsicBlur scriptIntrinsicBlur = (ScriptIntrinsicBlur) script.a();
        RenderScript renderScript = (RenderScript) script.b();
        Allocation allocation = this.s;
        if (allocation != null) {
            allocation.destroy();
        }
        this.s = Allocation.createFromBitmap(renderScript, this.o);
        Allocation allocation2 = this.t;
        Type type = allocation2 == null ? null : allocation2.getType();
        Allocation allocation3 = this.s;
        if (!kotlin.jvm.internal.l.a(type, allocation3 != null ? allocation3.getType() : null)) {
            Allocation allocation4 = this.t;
            if (allocation4 != null) {
                allocation4.destroy();
            }
            Allocation allocation5 = this.s;
            kotlin.jvm.internal.l.b(allocation5);
            this.t = Allocation.createTyped(renderScript, allocation5.getType());
        }
        scriptIntrinsicBlur.setInput(this.s);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        j();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isInEditMode()) {
            return;
        }
        h();
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (isInEditMode()) {
            return;
        }
        i(i2, i3);
    }

    public final void setColorRes(int i2) {
        setShadow_color(F.h.d(getResources(), i2, getContext().getTheme()));
    }

    public final void setShadow_cast_only_background(boolean z) {
        this.i.c(this, B[5], Boolean.valueOf(z));
    }

    public final void setShadow_color(int i2) {
        if (this.a.getColor() == i2) {
            return;
        }
        this.a.setColor(i2);
        postInvalidate();
    }

    public final void setShadow_downscale(float f2) {
        this.f.c(this, B[2], Float.valueOf(f2));
    }

    public final void setShadow_radius(float f2) {
        this.g.c(this, B[3], Float.valueOf(f2));
    }

    public final void setShadow_with_color(boolean z) {
        this.k.c(this, B[7], Boolean.valueOf(z));
    }

    public final void setShadow_with_content(boolean z) {
        this.j.c(this, B[6], Boolean.valueOf(z));
    }

    public final void setShadow_with_css_scale(boolean z) {
        this.m.c(this, B[9], Boolean.valueOf(z));
    }

    public final void setShadow_with_dpi_scale(boolean z) {
        this.l.c(this, B[8], Boolean.valueOf(z));
    }

    public final void setShadow_x_shift(float f2) {
        this.d.c(this, B[0], Float.valueOf(f2));
    }

    public final void setShadow_y_shift(float f2) {
        this.e.c(this, B[1], Float.valueOf(f2));
    }

    public final void setXShift(int i2) {
        setShadow_x_shift(getContext().getResources().getDimension(i2));
    }

    public final void setYShift(int i2) {
        setShadow_y_shift(getContext().getResources().getDimension(i2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        kotlin.jvm.internal.l.e(context, "context");
        this.a = new Paint(5);
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        k8.q qVar = k8.q.a;
        this.c = paint;
        Float valueOf = Float.valueOf(0.0f);
        this.d = new N8.a(valueOf, null, null, 6, null);
        this.e = new N8.a(valueOf, null, null, 6, null);
        this.f = new N8.a(Float.valueOf(1.0f), d.a, new e());
        this.g = new N8.a(valueOf, f.a, new g());
        this.h = new N8.a(valueOf, c.a, null, 4, null);
        Boolean bool = Boolean.FALSE;
        this.i = new N8.a(bool, null, null, 6, null);
        Boolean bool2 = Boolean.TRUE;
        this.j = new N8.a(bool2, null, null, 6, null);
        this.k = new N8.a(bool, null, new h(), 2, null);
        this.l = new N8.a(bool2, null, new j(), 2, null);
        this.m = new N8.a(bool2, null, new i(), 2, null);
        this.n = new Rect();
        this.v = new Rect();
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, N8.c.f, i2, i3);
            kotlin.jvm.internal.l.d(obtainStyledAttributes, "context.obtainStyledAttributes(\n                attrs, R.styleable.ShadowLayout, defStyleAttr, defStyleRes\n            )");
            setShadow_color(obtainStyledAttributes.getColor(N8.c.h, 855638016));
            setShadow_with_color(obtainStyledAttributes.getBoolean(N8.c.k, false));
            setShadow_with_content(obtainStyledAttributes.getBoolean(N8.c.l, true));
            setShadow_with_dpi_scale(obtainStyledAttributes.getBoolean(N8.c.n, true));
            setShadow_with_css_scale(obtainStyledAttributes.getBoolean(N8.c.m, true));
            setShadow_x_shift(obtainStyledAttributes.getDimension(N8.c.o, 0.0f));
            setShadow_y_shift(obtainStyledAttributes.getDimension(N8.c.p, 0.0f));
            setShadow_downscale(obtainStyledAttributes.getFloat(N8.c.i, 1.0f));
            setShadow_radius(obtainStyledAttributes.getFloat(N8.c.j, 6.0f));
            setShadow_cast_only_background(obtainStyledAttributes.getBoolean(N8.c.g, false));
            obtainStyledAttributes.recycle();
        }
        setWillNotDraw(false);
    }

    public /* synthetic */ ShadowLayout(Context context, AttributeSet attributeSet, int i2, int i3, int i4, kotlin.jvm.internal.g gVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? N8.b.a : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
