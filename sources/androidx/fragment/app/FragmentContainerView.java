package androidx.fragment.app;

import P.L;
import P.X;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public ArrayList a;
    public ArrayList c;
    public View.OnApplyWindowInsetsListener d;
    public boolean e;

    public FragmentContainerView(Context context) {
        super(context);
        this.e = true;
    }

    public final void a(View view) {
        ArrayList arrayList = this.c;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (m.z0(view) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        if (m.z0(view) != null) {
            return super.addViewInLayout(view, i, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        X u = X.u(windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.d;
        X u2 = onApplyWindowInsetsListener != null ? X.u(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : L.e0(this, u);
        if (!u2.n()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                L.i(getChildAt(i), u2);
            }
        }
        return windowInsets;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.e && this.a != null) {
            for (int i = 0; i < this.a.size(); i++) {
                super.drawChild(canvas, (View) this.a.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList arrayList;
        if (!this.e || (arrayList = this.a) == null || arrayList.size() <= 0 || !this.a.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    public void endViewTransition(View view) {
        ArrayList arrayList = this.c;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.e = true;
            }
        }
        super.endViewTransition(view);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    public void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    public void removeViewAt(int i) {
        a(getChildAt(i));
        super.removeViewAt(i);
    }

    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.e = z;
    }

    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.d = onApplyWindowInsetsListener;
    }

    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, int i) {
        String str;
        super(context, attributeSet, i);
        this.e = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.c.h);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(e0.c.i);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, m mVar) {
        String str;
        super(context, attributeSet);
        this.e = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e0.c.h);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(e0.c.i) : classAttribute;
        String string = obtainStyledAttributes.getString(e0.c.j);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment g0 = mVar.g0(id);
        if (classAttribute != null && g0 == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment a = mVar.q0().a(context.getClassLoader(), classAttribute);
            a.onInflate(context, attributeSet, (Bundle) null);
            mVar.m().w(true).d(this, a, string).l();
        }
        mVar.U0(this);
    }
}
