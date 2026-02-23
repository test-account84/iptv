package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
class ResizingTextView extends TextView {
    public int a;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public int i;
    public float j;
    public int k;
    public int l;

    public ResizingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public final void a(int i, int i2) {
        if (isPaddingRelative()) {
            setPaddingRelative(getPaddingStart(), i, getPaddingEnd(), i2);
        } else {
            setPadding(getPaddingLeft(), i, getPaddingRight(), i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00d1 A[PHI: r2
      0x00d1: PHI (r2v7 boolean) = (r2v2 boolean), (r2v9 boolean) binds: [B:46:0x00ce, B:25:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ResizingTextView.onMeasure(int, int):void");
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(T.j.r(this, callback));
    }

    public ResizingTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ResizingTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.g = false;
        this.h = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g0.l.T, i, i2);
        try {
            this.a = obtainStyledAttributes.getInt(g0.l.V, 1);
            this.c = obtainStyledAttributes.getDimensionPixelSize(g0.l.Y, -1);
            this.d = obtainStyledAttributes.getBoolean(g0.l.U, false);
            this.e = obtainStyledAttributes.getDimensionPixelOffset(g0.l.X, 0);
            this.f = obtainStyledAttributes.getDimensionPixelOffset(g0.l.W, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
