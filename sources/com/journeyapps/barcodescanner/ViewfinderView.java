package com.journeyapps.barcodescanner;

import B6.j;
import B6.o;
import Y6.v;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.journeyapps.barcodescanner.a;
import java.util.ArrayList;
import java.util.List;
import x6.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ViewfinderView extends View {
    public static final int[] o = {0, 64, 128, 192, 255, 192, 128, 64};
    public final Paint a;
    public Bitmap c;
    public int d;
    public final int e;
    public final int f;
    public final int g;
    public boolean h;
    public int i;
    public List j;
    public List k;
    public com.journeyapps.barcodescanner.a l;
    public Rect m;
    public v n;

    public class a implements a.f {
        public a() {
        }

        public void a() {
            ViewfinderView.this.b();
            ViewfinderView.this.invalidate();
        }

        public void b() {
        }

        public void c(Exception exc) {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint(1);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f);
        this.d = obtainStyledAttributes.getColor(o.k, resources.getColor(j.d));
        this.e = obtainStyledAttributes.getColor(o.h, resources.getColor(j.b));
        this.f = obtainStyledAttributes.getColor(o.i, resources.getColor(j.c));
        this.g = obtainStyledAttributes.getColor(o.g, resources.getColor(j.a));
        this.h = obtainStyledAttributes.getBoolean(o.j, true);
        obtainStyledAttributes.recycle();
        this.i = 0;
        this.j = new ArrayList(20);
        this.k = new ArrayList(20);
    }

    public void a(q qVar) {
        if (this.j.size() < 20) {
            this.j.add(qVar);
        }
    }

    public void b() {
        com.journeyapps.barcodescanner.a aVar = this.l;
        if (aVar == null) {
            return;
        }
        Rect framingRect = aVar.getFramingRect();
        v previewSize = this.l.getPreviewSize();
        if (framingRect == null || previewSize == null) {
            return;
        }
        this.m = framingRect;
        this.n = previewSize;
    }

    public void onDraw(Canvas canvas) {
        v vVar;
        b();
        Rect rect = this.m;
        if (rect == null || (vVar = this.n) == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.a.setColor(this.c != null ? this.e : this.d);
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, rect.top, this.a);
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom + 1, this.a);
        canvas.drawRect(rect.right + 1, rect.top, f, rect.bottom + 1, this.a);
        canvas.drawRect(0.0f, rect.bottom + 1, f, height, this.a);
        if (this.c != null) {
            this.a.setAlpha(160);
            canvas.drawBitmap(this.c, (Rect) null, rect, this.a);
            return;
        }
        if (this.h) {
            this.a.setColor(this.f);
            Paint paint = this.a;
            int[] iArr = o;
            paint.setAlpha(iArr[this.i]);
            this.i = (this.i + 1) % iArr.length;
            int height2 = (rect.height() / 2) + rect.top;
            canvas.drawRect(rect.left + 2, height2 - 1, rect.right - 1, height2 + 2, this.a);
        }
        float width2 = getWidth() / vVar.a;
        float height3 = getHeight() / vVar.c;
        if (!this.k.isEmpty()) {
            this.a.setAlpha(80);
            this.a.setColor(this.g);
            for (q qVar : this.k) {
                canvas.drawCircle((int) (qVar.c() * width2), (int) (qVar.d() * height3), 3.0f, this.a);
            }
            this.k.clear();
        }
        if (!this.j.isEmpty()) {
            this.a.setAlpha(160);
            this.a.setColor(this.g);
            for (q qVar2 : this.j) {
                canvas.drawCircle((int) (qVar2.c() * width2), (int) (qVar2.d() * height3), 6.0f, this.a);
            }
            List list = this.j;
            List list2 = this.k;
            this.j = list2;
            this.k = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect.left - 6, rect.top - 6, rect.right + 6, rect.bottom + 6);
    }

    public void setCameraPreview(com.journeyapps.barcodescanner.a aVar) {
        this.l = aVar;
        aVar.i(new a());
    }

    public void setLaserVisibility(boolean z) {
        this.h = z;
    }

    public void setMaskColor(int i) {
        this.d = i;
    }
}
