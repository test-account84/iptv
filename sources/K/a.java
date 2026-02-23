package k;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a extends ViewGroup {
    public final a a;
    public final Context c;
    public ActionMenuView d;
    public androidx.appcompat.widget.a e;
    public int f;
    public P.S g;
    public boolean h;
    public boolean i;

    public class a implements P.T {
        public boolean a = false;
        public int b;

        public a() {
        }

        public void a(View view) {
            this.a = true;
        }

        public void b(View view) {
            if (this.a) {
                return;
            }
            a aVar = a.this;
            aVar.g = null;
            a.b(aVar, this.b);
        }

        public void c(View view) {
            a.a(a.this, 0);
            this.a = false;
        }

        public a d(P.S s, int i) {
            a.this.g = s;
            this.b = i;
            return this;
        }
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(c.a.a, typedValue, true) || typedValue.resourceId == 0) {
            this.c = context;
        } else {
            this.c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static /* synthetic */ void a(a aVar, int i) {
        super.setVisibility(i);
    }

    public static /* synthetic */ void b(a aVar, int i) {
        super.setVisibility(i);
    }

    public static int d(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    public int e(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public P.S f(int i, long j) {
        P.S b;
        P.S s = this.g;
        if (s != null) {
            s.c();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            b = P.L.e(this).b(1.0f);
        } else {
            b = P.L.e(this).b(0.0f);
        }
        b.h(j);
        b.j(this.a.d(b, i));
        return b;
    }

    public int getAnimatedVisibility() {
        return this.g != null ? this.a.b : getVisibility();
    }

    public int getContentHeight() {
        return this.f;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, c.j.a, c.a.c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(c.j.j, 0));
        obtainStyledAttributes.recycle();
        androidx.appcompat.widget.a aVar = this.e;
        if (aVar != null) {
            aVar.F(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.i = false;
        }
        if (!this.i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.i = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = false;
        }
        if (!this.h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            P.S s = this.g;
            if (s != null) {
                s.c();
            }
            super.setVisibility(i);
        }
    }
}
