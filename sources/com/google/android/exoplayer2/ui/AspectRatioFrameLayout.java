package com.google.android.exoplayer2.ui;

import a4.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    public final c a;
    public float c;
    public int d;

    public interface b {
    }

    public final class c implements Runnable {
        public float a;
        public float c;
        public boolean d;
        public boolean e;

        public c() {
        }

        public void a(float f, float f2, boolean z) {
            this.a = f;
            this.c = f2;
            this.d = z;
            if (this.e) {
                return;
            }
            this.e = true;
            AspectRatioFrameLayout.this.post(this);
        }

        public void run() {
            this.e = false;
            AspectRatioFrameLayout.a(AspectRatioFrameLayout.this);
        }

        public /* synthetic */ c(AspectRatioFrameLayout aspectRatioFrameLayout, a aVar) {
            this();
        }
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, y.a, 0, 0);
            try {
                this.d = obtainStyledAttributes.getInt(y.b, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.a = new c(this, null);
    }

    public static /* synthetic */ b a(AspectRatioFrameLayout aspectRatioFrameLayout) {
        aspectRatioFrameLayout.getClass();
        return null;
    }

    public int getResizeMode() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            super.onMeasure(r9, r10)
            float r9 = r8.c
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 > 0) goto Lb
            return
        Lb:
            int r9 = r8.getMeasuredWidth()
            int r0 = r8.getMeasuredHeight()
            float r1 = (float) r9
            float r2 = (float) r0
            float r3 = r1 / r2
            float r4 = r8.c
            float r4 = r4 / r3
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r5
            float r5 = java.lang.Math.abs(r4)
            r6 = 1008981770(0x3c23d70a, float:0.01)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L31
            com.google.android.exoplayer2.ui.AspectRatioFrameLayout$c r9 = r8.a
            float r10 = r8.c
            r0 = 0
            r9.a(r10, r3, r0)
            return
        L31:
            int r5 = r8.d
            r6 = 1
            if (r5 == 0) goto L4e
            if (r5 == r6) goto L49
            r7 = 2
            if (r5 == r7) goto L43
            r7 = 4
            if (r5 == r7) goto L3f
            goto L53
        L3f:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 <= 0) goto L49
        L43:
            float r9 = r8.c
            float r2 = r2 * r9
            int r9 = (int) r2
            goto L53
        L49:
            float r10 = r8.c
            float r1 = r1 / r10
            int r0 = (int) r1
            goto L53
        L4e:
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 <= 0) goto L43
            goto L49
        L53:
            com.google.android.exoplayer2.ui.AspectRatioFrameLayout$c r10 = r8.a
            float r1 = r8.c
            r10.a(r1, r3, r6)
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r10)
            super.onMeasure(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.AspectRatioFrameLayout.onMeasure(int, int):void");
    }

    public void setAspectRatio(float f) {
        if (this.c != f) {
            this.c = f;
            requestLayout();
        }
    }

    public void setAspectRatioListener(b bVar) {
    }

    public void setResizeMode(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }
}
