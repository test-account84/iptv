package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.q;
import java.util.ArrayList;
import java.util.List;
import o4.m;
import o4.o;
import o4.u;
import o4.v;
import s4.b;
import s4.d;
import s4.e;
import s4.f;
import s4.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class CastSeekBar extends View {
    public f a;
    public boolean c;
    public Integer d;
    public d e;
    public List f;
    public e g;
    public final float h;
    public final float i;
    public final float j;
    public final float k;
    public final float l;
    public final Paint m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public int[] r;
    public Point s;
    public Runnable t;

    public CastSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* bridge */ /* synthetic */ void a(CastSeekBar castSeekBar, int i) {
        castSeekBar.h(i);
    }

    public static /* bridge */ /* synthetic */ void b(CastSeekBar castSeekBar) {
        castSeekBar.i();
    }

    public static /* bridge */ /* synthetic */ void c(CastSeekBar castSeekBar) {
        castSeekBar.j();
    }

    public final void d(List list) {
        if (q.b(this.f, list)) {
            return;
        }
        this.f = list == null ? null : new ArrayList(list);
        postInvalidate();
    }

    public final void e(f fVar) {
        if (this.c) {
            return;
        }
        f fVar2 = new f();
        fVar2.a = fVar.a;
        fVar2.b = fVar.b;
        fVar2.c = fVar.c;
        fVar2.d = fVar.d;
        fVar2.e = fVar.e;
        fVar2.f = fVar.f;
        this.a = fVar2;
        this.d = null;
        e eVar = this.g;
        if (eVar != null) {
            eVar.a(this, getProgress(), false);
        }
        postInvalidate();
    }

    public final int f(int i) {
        return (int) ((i / ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) * this.a.b);
    }

    public final void g(Canvas canvas, int i, int i2, int i3, int i4, int i5) {
        this.m.setColor(i5);
        float f = this.j;
        float f2 = i3;
        float f3 = i2 / f2;
        float f4 = i / f2;
        float f5 = i4;
        canvas.drawRect(f4 * f5, -f, f3 * f5, f, this.m);
    }

    public int getMaxProgress() {
        return this.a.b;
    }

    public int getProgress() {
        Integer num = this.d;
        return num != null ? num.intValue() : this.a.a;
    }

    public final void h(int i) {
        f fVar = this.a;
        if (fVar.f) {
            int i2 = fVar.d;
            this.d = Integer.valueOf(Math.min(Math.max(i, i2), fVar.e));
            e eVar = this.g;
            if (eVar != null) {
                eVar.a(this, getProgress(), true);
            }
            Runnable runnable = this.t;
            if (runnable == null) {
                this.t = new b(this);
            } else {
                removeCallbacks(runnable);
            }
            postDelayed(this.t, 200L);
            postInvalidate();
        }
    }

    public final void i() {
        this.c = true;
        e eVar = this.g;
        if (eVar != null) {
            eVar.b(this);
        }
    }

    public final void j() {
        this.c = false;
        e eVar = this.g;
        if (eVar != null) {
            eVar.c(this);
        }
    }

    public void onDetachedFromWindow() {
        Runnable runnable = this.t;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(android.graphics.Canvas r16) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.widget.CastSeekBar.onDraw(android.graphics.Canvas):void");
    }

    public synchronized void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSizeAndState((int) (this.h + getPaddingLeft() + getPaddingRight()), i, 0), View.resolveSizeAndState((int) (this.i + getPaddingTop() + getPaddingBottom()), i2, 0));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !this.a.f) {
            return false;
        }
        if (this.s == null) {
            this.s = new Point();
        }
        if (this.r == null) {
            this.r = new int[2];
        }
        getLocationOnScreen(this.r);
        this.s.set((((int) motionEvent.getRawX()) - this.r[0]) - getPaddingLeft(), ((int) motionEvent.getRawY()) - this.r[1]);
        int action = motionEvent.getAction();
        if (action == 0) {
            i();
            h(f(this.s.x));
            return true;
        }
        if (action == 1) {
            h(f(this.s.x));
            j();
            return true;
        }
        if (action == 2) {
            h(f(this.s.x));
            return true;
        }
        if (action != 3) {
            return false;
        }
        this.c = false;
        this.d = null;
        e eVar = this.g;
        if (eVar != null) {
            eVar.a(this, getProgress(), true);
            this.g.c(this);
        }
        postInvalidate();
        return true;
    }

    public CastSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new ArrayList();
        setAccessibilityDelegate(new h(this, null));
        Paint paint = new Paint(1);
        this.m = paint;
        paint.setStyle(Paint.Style.FILL);
        this.h = context.getResources().getDimension(o.m);
        this.i = context.getResources().getDimension(o.l);
        this.j = context.getResources().getDimension(o.n) / 2.0f;
        this.k = context.getResources().getDimension(o.o) / 2.0f;
        this.l = context.getResources().getDimension(o.k);
        f fVar = new f();
        this.a = fVar;
        fVar.b = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, v.b, m.a, u.a);
        int resourceId = obtainStyledAttributes.getResourceId(v.u, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(v.v, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(v.x, 0);
        int resourceId4 = obtainStyledAttributes.getResourceId(v.c, 0);
        this.n = context.getResources().getColor(resourceId);
        this.o = context.getResources().getColor(resourceId2);
        this.p = context.getResources().getColor(resourceId3);
        this.q = context.getResources().getColor(resourceId4);
        obtainStyledAttributes.recycle();
    }
}
