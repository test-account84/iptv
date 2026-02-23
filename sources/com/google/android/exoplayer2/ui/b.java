package com.google.android.exoplayer2.ui;

import a4.y;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.ui.f;
import d4.k0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class b extends View implements f {
    public final float A;
    public int B;
    public long C;
    public int D;
    public Rect E;
    public ValueAnimator F;
    public float G;
    public boolean H;
    public boolean I;
    public long J;
    public long K;
    public long L;
    public long M;
    public int N;
    public long[] O;
    public boolean[] P;
    public final Rect a;
    public final Rect c;
    public final Rect d;
    public final Rect e;
    public final Paint f;
    public final Paint g;
    public final Paint h;
    public final Paint i;
    public final Paint j;
    public final Paint k;
    public final Drawable l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final StringBuilder v;
    public final Formatter w;
    public final Runnable x;
    public final CopyOnWriteArraySet y;
    public final Point z;

    public b(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    public static /* synthetic */ void c(b bVar, ValueAnimator valueAnimator) {
        bVar.l(valueAnimator);
    }

    public static /* synthetic */ void d(b bVar) {
        bVar.k();
    }

    public static int e(float f, int i) {
        return (int) ((i * f) + 0.5f);
    }

    private long getPositionIncrement() {
        long j = this.C;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.K;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / this.B;
    }

    private String getProgressText() {
        return k0.m0(this.v, this.w, this.L);
    }

    private long getScrubberPosition() {
        if (this.c.width() <= 0 || this.K == -9223372036854775807L) {
            return 0L;
        }
        return (this.e.width() * this.K) / this.c.width();
    }

    public static int n(float f, int i) {
        return (int) (i / f);
    }

    public static boolean r(Drawable drawable, int i) {
        return k0.a >= 23 && a4.d.a(drawable, i);
    }

    public void a(f.a aVar) {
        d4.a.e(aVar);
        this.y.add(aVar);
    }

    public void b(long[] jArr, boolean[] zArr, int i) {
        d4.a.a(i == 0 || !(jArr == null || zArr == null));
        this.N = i;
        this.O = jArr;
        this.P = zArr;
        x();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        y();
    }

    public final void f(Canvas canvas) {
        if (this.K <= 0) {
            return;
        }
        Rect rect = this.e;
        int r = k0.r(rect.right, rect.left, this.c.right);
        int centerY = this.e.centerY();
        if (this.l == null) {
            canvas.drawCircle(r, centerY, (int) ((((this.I || isFocused()) ? this.s : isEnabled() ? this.q : this.r) * this.G) / 2.0f), this.k);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.G)) / 2;
        int intrinsicHeight = ((int) (this.l.getIntrinsicHeight() * this.G)) / 2;
        this.l.setBounds(r - intrinsicWidth, centerY - intrinsicHeight, r + intrinsicWidth, centerY + intrinsicHeight);
        this.l.draw(canvas);
    }

    public final void g(Canvas canvas) {
        int height = this.c.height();
        int centerY = this.c.centerY() - (height / 2);
        int i = height + centerY;
        if (this.K <= 0) {
            Rect rect = this.c;
            canvas.drawRect(rect.left, centerY, rect.right, i, this.h);
            return;
        }
        Rect rect2 = this.d;
        int i2 = rect2.left;
        int i3 = rect2.right;
        int max = Math.max(Math.max(this.c.left, i3), this.e.right);
        int i4 = this.c.right;
        if (max < i4) {
            canvas.drawRect(max, centerY, i4, i, this.h);
        }
        int max2 = Math.max(i2, this.e.right);
        if (i3 > max2) {
            canvas.drawRect(max2, centerY, i3, i, this.g);
        }
        if (this.e.width() > 0) {
            Rect rect3 = this.e;
            canvas.drawRect(rect3.left, centerY, rect3.right, i, this.f);
        }
        if (this.N == 0) {
            return;
        }
        long[] jArr = (long[]) d4.a.e(this.O);
        boolean[] zArr = (boolean[]) d4.a.e(this.P);
        int i5 = this.p / 2;
        for (int i6 = 0; i6 < this.N; i6++) {
            int width = ((int) ((this.c.width() * k0.s(jArr[i6], 0L, this.K)) / this.K)) - i5;
            Rect rect4 = this.c;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.p, Math.max(0, width)), centerY, r10 + this.p, i, zArr[i6] ? this.j : this.i);
        }
    }

    public long getPreferredUpdateDelay() {
        int n = n(this.A, this.c.width());
        if (n != 0) {
            long j = this.K;
            if (j != 0 && j != -9223372036854775807L) {
                return j / n;
            }
        }
        return Long.MAX_VALUE;
    }

    public void h(long j) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.F.setFloatValues(new float[]{this.G, 0.0f});
        this.F.setDuration(j);
        this.F.start();
    }

    public void i(boolean z) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = z;
        this.G = 0.0f;
        invalidate(this.a);
    }

    public final boolean j(float f, float f2) {
        return this.a.contains((int) f, (int) f2);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final /* synthetic */ void k() {
        w(false);
    }

    public final /* synthetic */ void l(ValueAnimator valueAnimator) {
        this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.a);
    }

    public final void m(float f) {
        Rect rect = this.e;
        Rect rect2 = this.c;
        rect.right = k0.r((int) f, rect2.left, rect2.right);
    }

    public final Point o(MotionEvent motionEvent) {
        this.z.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.z;
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        g(canvas);
        f(canvas);
        canvas.restore();
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!this.I || z) {
            return;
        }
        w(false);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.K <= 0) {
            return;
        }
        if (k0.a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L30
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L27
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L27;
                default: goto L12;
            }
        L12:
            goto L30
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.p(r0)
            if (r0 == 0) goto L30
            java.lang.Runnable r5 = r4.x
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.x
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L27:
            boolean r0 = r4.I
            if (r0 == 0) goto L30
            r5 = 0
            r4.w(r5)
            return r3
        L30:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i7 - getPaddingRight();
        int i9 = this.H ? 0 : this.t;
        if (this.o == 1) {
            i5 = (i8 - getPaddingBottom()) - this.n;
            int paddingBottom = i8 - getPaddingBottom();
            int i10 = this.m;
            i6 = (paddingBottom - i10) - Math.max(i9 - (i10 / 2), 0);
        } else {
            i5 = (i8 - this.n) / 2;
            i6 = (i8 - this.m) / 2;
        }
        this.a.set(paddingLeft, i5, paddingRight, this.n + i5);
        Rect rect = this.c;
        Rect rect2 = this.a;
        rect.set(rect2.left + i9, i6, rect2.right - i9, this.m + i6);
        if (k0.a >= 29) {
            s(i7, i8);
        }
        x();
    }

    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.n;
        } else if (mode != 1073741824) {
            size = Math.min(this.n, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        y();
    }

    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.l;
        if (drawable == null || !r(drawable, i)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L6e
            long r2 = r7.K
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L10
            goto L6e
        L10:
            android.graphics.Point r0 = r7.o(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L5b
            r5 = 3
            if (r3 == r4) goto L4c
            r6 = 2
            if (r3 == r6) goto L28
            if (r3 == r5) goto L4c
            goto L6e
        L28:
            boolean r8 = r7.I
            if (r8 == 0) goto L6e
            int r8 = r7.u
            if (r0 >= r8) goto L3a
            int r8 = r7.D
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
        L36:
            r7.m(r8)
            goto L3e
        L3a:
            r7.D = r2
            float r8 = (float) r2
            goto L36
        L3e:
            long r0 = r7.getScrubberPosition()
            r7.z(r0)
        L45:
            r7.x()
            r7.invalidate()
            return r4
        L4c:
            boolean r0 = r7.I
            if (r0 == 0) goto L6e
            int r8 = r8.getAction()
            if (r8 != r5) goto L57
            r1 = 1
        L57:
            r7.w(r1)
            return r4
        L5b:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.j(r8, r0)
            if (r0 == 0) goto L6e
            r7.m(r8)
            long r0 = r7.getScrubberPosition()
            r7.v(r0)
            goto L45
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean p(long j) {
        long j2 = this.K;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.I ? this.J : this.L;
        long s = k0.s(j3 + j, 0L, j2);
        if (s == j3) {
            return false;
        }
        if (this.I) {
            z(s);
        } else {
            v(s);
        }
        x();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performAccessibilityAction(int r7, android.os.Bundle r8) {
        /*
            r6 = this;
            boolean r8 = super.performAccessibilityAction(r7, r8)
            r0 = 1
            if (r8 == 0) goto L8
            return r0
        L8:
            long r1 = r6.K
            r3 = 0
            r8 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L12
            return r8
        L12:
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r7 != r1) goto L25
            long r1 = r6.getPositionIncrement()
            long r1 = -r1
            boolean r7 = r6.p(r1)
            if (r7 == 0) goto L34
        L21:
            r6.w(r8)
            goto L34
        L25:
            r1 = 4096(0x1000, float:5.74E-42)
            if (r7 != r1) goto L39
            long r1 = r6.getPositionIncrement()
            boolean r7 = r6.p(r1)
            if (r7 == 0) goto L34
            goto L21
        L34:
            r7 = 4
            r6.sendAccessibilityEvent(r7)
            return r0
        L39:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.performAccessibilityAction(int, android.os.Bundle):boolean");
    }

    public final boolean q(Drawable drawable) {
        return k0.a >= 23 && r(drawable, getLayoutDirection());
    }

    public final void s(int i, int i2) {
        Rect rect = this.E;
        if (rect != null && rect.width() == i && this.E.height() == i2) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i, i2);
        this.E = rect2;
        a4.e.a(this, Collections.singletonList(rect2));
    }

    public void setAdMarkerColor(int i) {
        this.i.setColor(i);
        invalidate(this.a);
    }

    public void setBufferedColor(int i) {
        this.g.setColor(i);
        invalidate(this.a);
    }

    public void setBufferedPosition(long j) {
        if (this.M == j) {
            return;
        }
        this.M = j;
        x();
    }

    public void setDuration(long j) {
        if (this.K == j) {
            return;
        }
        this.K = j;
        if (this.I && j == -9223372036854775807L) {
            w(true);
        }
        x();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!this.I || z) {
            return;
        }
        w(true);
    }

    public void setKeyCountIncrement(int i) {
        d4.a.a(i > 0);
        this.B = i;
        this.C = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j) {
        d4.a.a(j > 0);
        this.B = -1;
        this.C = j;
    }

    public void setPlayedAdMarkerColor(int i) {
        this.j.setColor(i);
        invalidate(this.a);
    }

    public void setPlayedColor(int i) {
        this.f.setColor(i);
        invalidate(this.a);
    }

    public void setPosition(long j) {
        if (this.L == j) {
            return;
        }
        this.L = j;
        setContentDescription(getProgressText());
        x();
    }

    public void setScrubberColor(int i) {
        this.k.setColor(i);
        invalidate(this.a);
    }

    public void setUnplayedColor(int i) {
        this.h.setColor(i);
        invalidate(this.a);
    }

    public void t() {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = false;
        this.G = 1.0f;
        invalidate(this.a);
    }

    public void u(long j) {
        if (this.F.isStarted()) {
            this.F.cancel();
        }
        this.H = false;
        this.F.setFloatValues(new float[]{this.G, 1.0f});
        this.F.setDuration(j);
        this.F.start();
    }

    public final void v(long j) {
        this.J = j;
        this.I = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            ((f.a) it.next()).D(this, j);
        }
    }

    public final void w(boolean z) {
        removeCallbacks(this.x);
        this.I = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            ((f.a) it.next()).C(this, this.J, z);
        }
    }

    public final void x() {
        this.d.set(this.c);
        this.e.set(this.c);
        long j = this.I ? this.J : this.L;
        if (this.K > 0) {
            int width = (int) ((this.c.width() * this.M) / this.K);
            Rect rect = this.d;
            Rect rect2 = this.c;
            rect.right = Math.min(rect2.left + width, rect2.right);
            int width2 = (int) ((this.c.width() * j) / this.K);
            Rect rect3 = this.e;
            Rect rect4 = this.c;
            rect3.right = Math.min(rect4.left + width2, rect4.right);
        } else {
            Rect rect5 = this.d;
            int i = this.c.left;
            rect5.right = i;
            this.e.right = i;
        }
        invalidate(this.a);
    }

    public final void y() {
        Drawable drawable = this.l;
        if (drawable != null && drawable.isStateful() && this.l.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void z(long j) {
        if (this.J == j) {
            return;
        }
        this.J = j;
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            ((f.a) it.next()).o(this, j);
        }
    }

    public b(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2, int i2) {
        int i3;
        int max;
        super(context, attributeSet, i);
        this.a = new Rect();
        this.c = new Rect();
        this.d = new Rect();
        this.e = new Rect();
        Paint paint = new Paint();
        this.f = paint;
        Paint paint2 = new Paint();
        this.g = paint2;
        Paint paint3 = new Paint();
        this.h = paint3;
        Paint paint4 = new Paint();
        this.i = paint4;
        Paint paint5 = new Paint();
        this.j = paint5;
        Paint paint6 = new Paint();
        this.k = paint6;
        paint6.setAntiAlias(true);
        this.y = new CopyOnWriteArraySet();
        this.z = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.A = f;
        this.u = e(f, -50);
        int e = e(f, 4);
        int e2 = e(f, 26);
        int e3 = e(f, 4);
        int e4 = e(f, 12);
        int e5 = e(f, 0);
        int e6 = e(f, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, y.c, i, i2);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(y.n);
                this.l = drawable;
                if (drawable != null) {
                    q(drawable);
                    e2 = Math.max(drawable.getMinimumHeight(), e2);
                }
                this.m = obtainStyledAttributes.getDimensionPixelSize(y.g, e);
                this.n = obtainStyledAttributes.getDimensionPixelSize(y.p, e2);
                this.o = obtainStyledAttributes.getInt(y.f, 0);
                this.p = obtainStyledAttributes.getDimensionPixelSize(y.e, e3);
                this.q = obtainStyledAttributes.getDimensionPixelSize(y.o, e4);
                this.r = obtainStyledAttributes.getDimensionPixelSize(y.l, e5);
                this.s = obtainStyledAttributes.getDimensionPixelSize(y.m, e6);
                int i4 = obtainStyledAttributes.getInt(y.j, -1);
                int i5 = obtainStyledAttributes.getInt(y.k, -1);
                int i6 = obtainStyledAttributes.getInt(y.h, -855638017);
                int i7 = obtainStyledAttributes.getInt(y.q, 872415231);
                int i8 = obtainStyledAttributes.getInt(y.d, -1291845888);
                int i9 = obtainStyledAttributes.getInt(y.i, 872414976);
                paint.setColor(i4);
                paint6.setColor(i5);
                paint2.setColor(i6);
                paint3.setColor(i7);
                paint4.setColor(i8);
                paint5.setColor(i9);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.m = e;
            this.n = e2;
            this.o = 0;
            this.p = e3;
            this.q = e4;
            this.r = e5;
            this.s = e6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.l = null;
        }
        StringBuilder sb = new StringBuilder();
        this.v = sb;
        this.w = new Formatter(sb, Locale.getDefault());
        this.x = new a4.f(this);
        Drawable drawable2 = this.l;
        if (drawable2 != null) {
            max = drawable2.getMinimumWidth();
            i3 = 1;
        } else {
            i3 = 1;
            max = Math.max(this.r, Math.max(this.q, this.s));
        }
        this.t = (max + i3) / 2;
        this.G = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.F = valueAnimator;
        valueAnimator.addUpdateListener(new a4.g(this));
        this.K = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.B = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
