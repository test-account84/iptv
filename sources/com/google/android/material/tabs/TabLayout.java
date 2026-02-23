package com.google.android.material.tabs;

import P.I;
import P.L;
import P.s;
import Q.C;
import R4.k;
import R4.l;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import f5.u;
import f5.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import k.g0;

@ViewPager.e
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int S = k.h;
    public static final O.e T = new O.g(16);
    public int A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public boolean F;
    public com.google.android.material.tabs.a G;
    public c H;
    public final ArrayList I;
    public c J;
    public ValueAnimator K;
    public ViewPager L;
    public N0.a M;
    public DataSetObserver N;
    public h O;
    public b P;
    public boolean Q;
    public final O.e R;
    public final ArrayList a;
    public g c;
    public final f d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public int n;
    public PorterDuff.Mode o;
    public float p;
    public float q;
    public final int r;
    public int s;
    public final int t;
    public final int u;
    public final int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.i {
        public boolean a;

        public b() {
        }

        public void a(ViewPager viewPager, N0.a aVar, N0.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.L == viewPager) {
                tabLayout.H(aVar2, this.a);
            }
        }

        public void b(boolean z) {
            this.a = z;
        }
    }

    public interface c {
        void a(g gVar);

        void b(g gVar);

        void c(g gVar);
    }

    public interface d extends c {
    }

    public class e extends DataSetObserver {
        public e() {
        }

        public void onChanged() {
            TabLayout.this.A();
        }

        public void onInvalidated() {
            TabLayout.this.A();
        }
    }

    public class f extends LinearLayout {
        public ValueAnimator a;
        public int c;
        public float d;
        public int e;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ View c;

            public a(View view, View view2) {
                this.a = view;
                this.c = view2;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.b(f.this, this.a, this.c, valueAnimator.getAnimatedFraction());
            }
        }

        public class b extends AnimatorListenerAdapter {
            public final /* synthetic */ int a;

            public b(int i) {
                this.a = i;
            }

            public void onAnimationEnd(Animator animator) {
                f.this.c = this.a;
            }

            public void onAnimationStart(Animator animator) {
                f.this.c = this.a;
            }
        }

        public f(Context context) {
            super(context);
            this.c = -1;
            this.e = -1;
            setWillNotDraw(false);
        }

        public static /* synthetic */ void a(f fVar) {
            fVar.e();
        }

        public static /* synthetic */ void b(f fVar, View view, View view2, float f) {
            fVar.h(view, view2, f);
        }

        public void c(int i, int i2) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.a.cancel();
            }
            i(true, i, i2);
        }

        public boolean d() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void draw(android.graphics.Canvas r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.m
                android.graphics.Rect r0 = r0.getBounds()
                int r0 = r0.height()
                if (r0 >= 0) goto L16
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.m
                int r0 = r0.getIntrinsicHeight()
            L16:
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                int r1 = r1.z
                if (r1 == 0) goto L3c
                r2 = 1
                r3 = 2
                if (r1 == r2) goto L2d
                r2 = 0
                if (r1 == r3) goto L43
                r0 = 3
                if (r1 == r0) goto L28
                r0 = 0
                goto L43
            L28:
                int r0 = r5.getHeight()
                goto L43
            L2d:
                int r1 = r5.getHeight()
                int r1 = r1 - r0
                int r2 = r1 / 2
                int r1 = r5.getHeight()
                int r1 = r1 + r0
                int r0 = r1 / 2
                goto L43
            L3c:
                int r1 = r5.getHeight()
                int r2 = r1 - r0
                goto L28
            L43:
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r1 = r1.m
                android.graphics.Rect r1 = r1.getBounds()
                int r1 = r1.width()
                if (r1 <= 0) goto L9d
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r1 = r1.m
                android.graphics.Rect r1 = r1.getBounds()
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r3 = r3.m
                int r4 = r1.left
                int r1 = r1.right
                r3.setBounds(r4, r2, r1, r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r1 = r0.m
                int r0 = com.google.android.material.tabs.TabLayout.b(r0)
                r2 = 21
                if (r0 == 0) goto L8e
                android.graphics.drawable.Drawable r1 = H.a.r(r1)
                int r0 = android.os.Build.VERSION.SDK_INT
                if (r0 != r2) goto L84
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = com.google.android.material.tabs.TabLayout.b(r0)
                android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
                r1.setColorFilter(r0, r2)
                goto L9a
            L84:
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = com.google.android.material.tabs.TabLayout.b(r0)
                H.a.n(r1, r0)
                goto L9a
            L8e:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 0
                if (r0 != r2) goto L97
                r1.setColorFilter(r3)
                goto L9a
            L97:
                H.a.o(r1, r3)
            L9a:
                r1.draw(r6)
            L9d:
                super.draw(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.f.draw(android.graphics.Canvas):void");
        }

        public final void e() {
            View childAt = getChildAt(this.c);
            com.google.android.material.tabs.a a2 = TabLayout.a(TabLayout.this);
            TabLayout tabLayout = TabLayout.this;
            a2.c(tabLayout, childAt, tabLayout.m);
        }

        public void f(int i, float f) {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.a.cancel();
            }
            this.c = i;
            this.d = f;
            h(getChildAt(i), getChildAt(this.c + 1), this.d);
        }

        public void g(int i) {
            Rect bounds = TabLayout.this.m.getBounds();
            TabLayout.this.m.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        public final void h(View view, View view2, float f) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.m;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.m.getBounds().bottom);
            } else {
                com.google.android.material.tabs.a a2 = TabLayout.a(TabLayout.this);
                TabLayout tabLayout = TabLayout.this;
                a2.d(tabLayout, view, view2, f, tabLayout.m);
            }
            L.j0(this);
        }

        public final void i(boolean z, int i, int i2) {
            View childAt = getChildAt(this.c);
            View childAt2 = getChildAt(i);
            if (childAt2 == null) {
                e();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (!z) {
                this.a.removeAllUpdateListeners();
                this.a.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.a = valueAnimator;
            valueAnimator.setInterpolator(S4.a.b);
            valueAnimator.setDuration(i2);
            valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.addListener(new b(i));
            valueAnimator.start();
        }

        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                i(false, this.c, -1);
            }
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.x == 1 || tabLayout.A == 2) {
                int childCount = getChildCount();
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        i3 = Math.max(i3, childAt.getMeasuredWidth());
                    }
                }
                if (i3 <= 0) {
                    return;
                }
                if (i3 * childCount <= getMeasuredWidth() - (((int) w.b(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.x = 0;
                    tabLayout2.O(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.e == i) {
                return;
            }
            requestLayout();
            this.e = i;
        }
    }

    public static class g {
        public Object a;
        public Drawable b;
        public CharSequence c;
        public CharSequence d;
        public View f;
        public TabLayout h;
        public i i;
        public int e = -1;
        public int g = 1;
        public int j = -1;

        public static /* synthetic */ int a(g gVar) {
            return gVar.j;
        }

        public static /* synthetic */ int b(g gVar) {
            return gVar.g;
        }

        public static /* synthetic */ CharSequence c(g gVar) {
            return gVar.d;
        }

        public static /* synthetic */ CharSequence d(g gVar) {
            return gVar.c;
        }

        public View e() {
            return this.f;
        }

        public Drawable f() {
            return this.b;
        }

        public int g() {
            return this.e;
        }

        public int h() {
            return this.g;
        }

        public CharSequence i() {
            return this.c;
        }

        public boolean j() {
            TabLayout tabLayout = this.h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.e;
        }

        public void k() {
            this.h = null;
            this.i = null;
            this.a = null;
            this.b = null;
            this.j = -1;
            this.c = null;
            this.d = null;
            this.e = -1;
            this.f = null;
        }

        public void l() {
            TabLayout tabLayout = this.h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.F(this);
        }

        public g m(View view) {
            this.f = view;
            p();
            return this;
        }

        public void n(int i) {
            this.e = i;
        }

        public g o(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(charSequence)) {
                this.i.setContentDescription(charSequence);
            }
            this.c = charSequence;
            p();
            return this;
        }

        public void p() {
            i iVar = this.i;
            if (iVar != null) {
                iVar.r();
            }
        }
    }

    public static class h implements ViewPager.j {
        public final WeakReference a;
        public int b;
        public int c;

        public h(TabLayout tabLayout) {
            this.a = new WeakReference(tabLayout);
        }

        public void a(int i, float f, int i2) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                tabLayout.J(i, f, i3 != 2 || this.b == 1, (i3 == 2 && this.b == 0) ? false : true);
            }
        }

        public void b(int i) {
            this.b = this.c;
            this.c = i;
        }

        public void c(int i) {
            TabLayout tabLayout = (TabLayout) this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            tabLayout.G(tabLayout.w(i), i2 == 0 || (i2 == 2 && this.b == 0));
        }

        public void d() {
            this.c = 0;
            this.b = 0;
        }
    }

    public final class i extends LinearLayout {
        public g a;
        public TextView c;
        public ImageView d;
        public View e;
        public U4.a f;
        public View g;
        public TextView h;
        public ImageView i;
        public Drawable j;
        public int k;

        public class a implements View.OnLayoutChangeListener {
            public final /* synthetic */ View a;

            public a(View view) {
                this.a = view;
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (this.a.getVisibility() == 0) {
                    i.a(i.this, this.a);
                }
            }
        }

        public i(Context context) {
            super(context);
            this.k = 2;
            s(context);
            L.F0(this, TabLayout.this.e, TabLayout.this.f, TabLayout.this.g, TabLayout.this.h);
            setGravity(17);
            setOrientation(!TabLayout.this.B ? 1 : 0);
            setClickable(true);
            L.G0(this, I.b(getContext(), 1002));
        }

        public static /* synthetic */ void a(i iVar, View view) {
            iVar.q(view);
        }

        public static /* synthetic */ void b(i iVar, Context context) {
            iVar.s(context);
        }

        public static /* synthetic */ void c(i iVar, Canvas canvas) {
            iVar.h(canvas);
        }

        private U4.a getBadge() {
            return this.f;
        }

        private U4.a getOrCreateBadge() {
            if (this.f == null) {
                this.f = U4.a.c(getContext());
            }
            p();
            U4.a aVar = this.f;
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void d(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.j;
            if ((drawable == null || !drawable.isStateful()) ? false : this.j.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final float e(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        public final void f(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup parent = getParent();
            if (parent != null) {
                parent.setClipChildren(z);
                parent.setClipToPadding(z);
            }
        }

        public final FrameLayout g() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        public int getContentHeight() {
            View[] viewArr = {this.c, this.d, this.g};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getTop()) : view.getTop();
                    i = z ? Math.max(i, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i - i2;
        }

        public int getContentWidth() {
            View[] viewArr = {this.c, this.d, this.g};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getLeft()) : view.getLeft();
                    i = z ? Math.max(i, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i - i2;
        }

        public g getTab() {
            return this.a;
        }

        public final void h(Canvas canvas) {
            Drawable drawable = this.j;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.j.draw(canvas);
            }
        }

        public final FrameLayout i(View view) {
            if ((view == this.d || view == this.c) && U4.d.a) {
                return view.getParent();
            }
            return null;
        }

        public final boolean j() {
            return this.f != null;
        }

        public final void k() {
            i iVar;
            if (U4.d.a) {
                iVar = g();
                addView(iVar, 0);
            } else {
                iVar = this;
            }
            ImageView inflate = LayoutInflater.from(getContext()).inflate(R4.h.a, iVar, false);
            this.d = inflate;
            iVar.addView(inflate, 0);
        }

        public final void l() {
            i iVar;
            if (U4.d.a) {
                iVar = g();
                addView(iVar);
            } else {
                iVar = this;
            }
            TextView inflate = LayoutInflater.from(getContext()).inflate(R4.h.b, iVar, false);
            this.c = inflate;
            iVar.addView(inflate);
        }

        public void m() {
            setTab(null);
            setSelected(false);
        }

        public final void n(View view) {
            if (j() && view != null) {
                f(false);
                U4.d.a(this.f, view, i(view));
                this.e = view;
            }
        }

        public final void o() {
            if (j()) {
                f(true);
                View view = this.e;
                if (view != null) {
                    U4.d.b(this.f, view);
                    this.e = null;
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            U4.a aVar = this.f;
            if (aVar != null && aVar.isVisible()) {
                accessibilityNodeInfo.setContentDescription(getContentDescription() + ", " + this.f.f());
            }
            C y0 = C.y0(accessibilityNodeInfo);
            y0.a0(C.c.a(0, 1, this.a.g(), 1, false, isSelected()));
            if (isSelected()) {
                y0.Y(false);
                y0.P(C.a.i);
            }
            y0.o0(getResources().getString(R4.j.h));
        }

        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.s, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.c != null) {
                float f = TabLayout.this.p;
                int i3 = this.k;
                ImageView imageView = this.d;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.q;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.c.getTextSize();
                int lineCount = this.c.getLineCount();
                int d = T.j.d(this.c);
                if (f != textSize || (d >= 0 && i3 != d)) {
                    if (TabLayout.this.A != 1 || f <= textSize || lineCount != 1 || ((layout = this.c.getLayout()) != null && e(layout, 0, f) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.c.setTextSize(0, f);
                        this.c.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        public final void p() {
            g gVar;
            ImageView imageView;
            ImageView imageView2;
            g gVar2;
            if (j()) {
                if (this.g == null) {
                    if (this.d != null && (gVar2 = this.a) != null && gVar2.f() != null) {
                        ImageView imageView3 = this.e;
                        imageView = this.d;
                        if (imageView3 != imageView) {
                            o();
                            imageView2 = this.d;
                            n(imageView2);
                            return;
                        }
                        q(imageView);
                        return;
                    }
                    if (this.c != null && (gVar = this.a) != null && gVar.h() == 1) {
                        ImageView imageView4 = this.e;
                        imageView = this.c;
                        if (imageView4 != imageView) {
                            o();
                            imageView2 = this.c;
                            n(imageView2);
                            return;
                        }
                        q(imageView);
                        return;
                    }
                }
                o();
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.a.l();
            return true;
        }

        public final void q(View view) {
            if (j() && view == this.e) {
                U4.d.c(this.f, view, i(view));
            }
        }

        public final void r() {
            g gVar = this.a;
            ImageView imageView = null;
            View e = gVar != null ? gVar.e() : null;
            if (e != null) {
                ViewGroup parent = e.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(e);
                    }
                    addView(e);
                }
                this.g = e;
                TextView textView = this.c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView2 = this.d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.d.setImageDrawable((Drawable) null);
                }
                TextView findViewById = e.findViewById(16908308);
                this.h = findViewById;
                if (findViewById != null) {
                    this.k = T.j.d(findViewById);
                }
                imageView = (ImageView) e.findViewById(16908294);
            } else {
                View view = this.g;
                if (view != null) {
                    removeView(view);
                    this.g = null;
                }
                this.h = null;
            }
            this.i = imageView;
            if (this.g == null) {
                if (this.d == null) {
                    k();
                }
                if (this.c == null) {
                    l();
                    this.k = T.j.d(this.c);
                }
                T.j.o(this.c, TabLayout.this.i);
                ColorStateList colorStateList = TabLayout.this.j;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
                u(this.c, this.d);
                p();
                d(this.d);
                d(this.c);
            } else {
                TextView textView2 = this.h;
                if (textView2 != null || this.i != null) {
                    u(textView2, this.i);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(g.c(gVar))) {
                setContentDescription(g.c(gVar));
            }
            setSelected(gVar != null && gVar.j());
        }

        public final void s(Context context) {
            int i = TabLayout.this.r;
            if (i != 0) {
                Drawable b = e.a.b(context, i);
                this.j = b;
                if (b != null && b.isStateful()) {
                    this.j.setState(getDrawableState());
                }
            } else {
                this.j = null;
            }
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.l != null) {
                Drawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a2 = j5.b.a(TabLayout.this.l);
                boolean z = TabLayout.this.F;
                if (z) {
                    gradientDrawable = null;
                }
                gradientDrawable = new RippleDrawable(a2, gradientDrawable, z ? null : gradientDrawable2);
            }
            L.w0(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        public void setSelected(boolean z) {
            isSelected();
            super.setSelected(z);
            TextView textView = this.c;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.g;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.a) {
                this.a = gVar;
                r();
            }
        }

        public final void t() {
            ImageView imageView;
            setOrientation(!TabLayout.this.B ? 1 : 0);
            TextView textView = this.h;
            if (textView == null && this.i == null) {
                textView = this.c;
                imageView = this.d;
            } else {
                imageView = this.i;
            }
            u(textView, imageView);
        }

        public final void u(TextView textView, ImageView imageView) {
            g gVar = this.a;
            Drawable mutate = (gVar == null || gVar.f() == null) ? null : H.a.r(this.a.f()).mutate();
            if (mutate != null) {
                H.a.o(mutate, TabLayout.this.k);
                PorterDuff.Mode mode = TabLayout.this.o;
                if (mode != null) {
                    H.a.p(mutate, mode);
                }
            }
            g gVar2 = this.a;
            CharSequence i = gVar2 != null ? gVar2.i() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(i);
            if (textView != null) {
                if (z) {
                    textView.setText(i);
                    if (g.b(this.a) == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams layoutParams = imageView.getLayoutParams();
                int b = (z && imageView.getVisibility() == 0) ? (int) w.b(getContext(), 8) : 0;
                if (TabLayout.this.B) {
                    if (b != s.a(layoutParams)) {
                        s.c(layoutParams, b);
                        layoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(layoutParams);
                        imageView.requestLayout();
                    }
                } else if (b != layoutParams.bottomMargin) {
                    layoutParams.bottomMargin = b;
                    s.c(layoutParams, 0);
                    imageView.setLayoutParams(layoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.a;
            CharSequence c = gVar3 != null ? g.c(gVar3) : null;
            if (Build.VERSION.SDK_INT > 23) {
                if (!z) {
                    i = c;
                }
                g0.a(this, i);
            }
        }
    }

    public static class j implements d {
        public final ViewPager a;

        public j(ViewPager viewPager) {
            this.a = viewPager;
        }

        public void a(g gVar) {
            this.a.setCurrentItem(gVar.g());
        }

        public void b(g gVar) {
        }

        public void c(g gVar) {
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R4.b.G);
    }

    public static /* synthetic */ com.google.android.material.tabs.a a(TabLayout tabLayout) {
        return tabLayout.G;
    }

    public static /* synthetic */ int b(TabLayout tabLayout) {
        return tabLayout.n;
    }

    private int getDefaultHeight() {
        int size = this.a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            g gVar = (g) this.a.get(i2);
            if (gVar == null || gVar.f() == null || TextUtils.isEmpty(gVar.i())) {
                i2++;
            } else if (!this.B) {
                return 72;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.A;
        if (i3 == 0 || i3 == 2) {
            return this.v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.d.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public static ColorStateList o(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.d.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.d.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    public void A() {
        int currentItem;
        C();
        N0.a aVar = this.M;
        if (aVar != null) {
            int c2 = aVar.c();
            for (int i2 = 0; i2 < c2; i2++) {
                g(z().o(this.M.e(i2)), false);
            }
            ViewPager viewPager = this.L;
            if (viewPager == null || c2 <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            F(w(currentItem));
        }
    }

    public boolean B(g gVar) {
        return T.a(gVar);
    }

    public void C() {
        for (int childCount = this.d.getChildCount() - 1; childCount >= 0; childCount--) {
            E(childCount);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            it.remove();
            gVar.k();
            B(gVar);
        }
        this.c = null;
    }

    public void D(c cVar) {
        this.I.remove(cVar);
    }

    public final void E(int i2) {
        i childAt = this.d.getChildAt(i2);
        this.d.removeViewAt(i2);
        if (childAt != null) {
            childAt.m();
            this.R.a(childAt);
        }
        requestLayout();
    }

    public void F(g gVar) {
        G(gVar, true);
    }

    public void G(g gVar, boolean z) {
        g gVar2 = this.c;
        if (gVar2 == gVar) {
            if (gVar2 != null) {
                s(gVar);
                j(gVar.g());
                return;
            }
            return;
        }
        int g2 = gVar != null ? gVar.g() : -1;
        if (z) {
            if ((gVar2 == null || gVar2.g() == -1) && g2 != -1) {
                I(g2, 0.0f, true);
            } else {
                j(g2);
            }
            if (g2 != -1) {
                setSelectedTabView(g2);
            }
        }
        this.c = gVar;
        if (gVar2 != null) {
            u(gVar2);
        }
        if (gVar != null) {
            t(gVar);
        }
    }

    public void H(N0.a aVar, boolean z) {
        DataSetObserver dataSetObserver;
        N0.a aVar2 = this.M;
        if (aVar2 != null && (dataSetObserver = this.N) != null) {
            aVar2.o(dataSetObserver);
        }
        this.M = aVar;
        if (z && aVar != null) {
            if (this.N == null) {
                this.N = new e();
            }
            aVar.i(this.N);
        }
        A();
    }

    public void I(int i2, float f2, boolean z) {
        J(i2, f2, z, true);
    }

    public void J(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.d.getChildCount()) {
            return;
        }
        if (z2) {
            this.d.f(i2, f2);
        }
        ValueAnimator valueAnimator = this.K;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K.cancel();
        }
        scrollTo(i2 < 0 ? 0 : m(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void K(ViewPager viewPager, boolean z) {
        L(viewPager, z, false);
    }

    public final void L(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.L;
        if (viewPager2 != null) {
            h hVar = this.O;
            if (hVar != null) {
                viewPager2.I(hVar);
            }
            b bVar = this.P;
            if (bVar != null) {
                this.L.H(bVar);
            }
        }
        c cVar = this.J;
        if (cVar != null) {
            D(cVar);
            this.J = null;
        }
        if (viewPager != null) {
            this.L = viewPager;
            if (this.O == null) {
                this.O = new h(this);
            }
            this.O.d();
            viewPager.c(this.O);
            j jVar = new j(viewPager);
            this.J = jVar;
            c(jVar);
            N0.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                H(adapter, z);
            }
            if (this.P == null) {
                this.P = new b();
            }
            this.P.b(z);
            viewPager.b(this.P);
            I(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.L = null;
            H(null, false);
        }
        this.Q = z2;
    }

    public final void M() {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((g) this.a.get(i2)).p();
        }
    }

    public final void N(LinearLayout.LayoutParams layoutParams) {
        float f2;
        if (this.A == 1 && this.x == 0) {
            layoutParams.width = 0;
            f2 = 1.0f;
        } else {
            layoutParams.width = -2;
            f2 = 0.0f;
        }
        layoutParams.weight = f2;
    }

    public void O(boolean z) {
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            View childAt = this.d.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            N((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public void addView(View view) {
        i(view);
    }

    public void c(c cVar) {
        if (this.I.contains(cVar)) {
            return;
        }
        this.I.add(cVar);
    }

    public void d(d dVar) {
        c(dVar);
    }

    public void e(g gVar) {
        g(gVar, this.a.isEmpty());
    }

    public void f(g gVar, int i2, boolean z) {
        if (gVar.h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        n(gVar, i2);
        h(gVar);
        if (z) {
            gVar.l();
        }
    }

    public void g(g gVar, boolean z) {
        f(gVar, this.a.size(), z);
    }

    public int getSelectedTabPosition() {
        g gVar = this.c;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.a.size();
    }

    public int getTabGravity() {
        return this.x;
    }

    public ColorStateList getTabIconTint() {
        return this.k;
    }

    public int getTabIndicatorAnimationMode() {
        return this.E;
    }

    public int getTabIndicatorGravity() {
        return this.z;
    }

    public int getTabMaxWidth() {
        return this.s;
    }

    public int getTabMode() {
        return this.A;
    }

    public ColorStateList getTabRippleColor() {
        return this.l;
    }

    public Drawable getTabSelectedIndicator() {
        return this.m;
    }

    public ColorStateList getTabTextColors() {
        return this.j;
    }

    public final void h(g gVar) {
        i iVar = gVar.i;
        iVar.setSelected(false);
        iVar.setActivated(false);
        this.d.addView(iVar, gVar.g(), p());
    }

    public final void i(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void j(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() == null || !L.W(this) || this.d.d()) {
            I(i2, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int m = m(i2, 0.0f);
        if (scrollX != m) {
            v();
            this.K.setIntValues(new int[]{scrollX, m});
            this.K.start();
        }
        this.d.c(i2, this.y);
    }

    public final void k(int i2) {
        f fVar;
        int i3;
        if (i2 != 0) {
            i3 = 1;
            if (i2 == 1) {
                fVar = this.d;
                fVar.setGravity(i3);
            } else if (i2 != 2) {
                return;
            }
        } else {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        }
        fVar = this.d;
        i3 = 8388611;
        fVar.setGravity(i3);
    }

    public final void l() {
        int i2 = this.A;
        L.F0(this.d, (i2 == 0 || i2 == 2) ? Math.max(0, this.w - this.e) : 0, 0, 0, 0);
        int i3 = this.A;
        if (i3 == 0) {
            k(this.x);
        } else if (i3 == 1 || i3 == 2) {
            if (this.x == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.d.setGravity(1);
        }
        O(true);
    }

    public final int m(int i2, float f2) {
        View childAt;
        int i3 = this.A;
        if ((i3 != 0 && i3 != 2) || (childAt = this.d.getChildAt(i2)) == null) {
            return 0;
        }
        int i4 = i2 + 1;
        View childAt2 = i4 < this.d.getChildCount() ? this.d.getChildAt(i4) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        return L.E(this) == 0 ? left + i5 : left - i5;
    }

    public final void n(g gVar, int i2) {
        gVar.n(i2);
        this.a.add(i2, gVar);
        int size = this.a.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                ((g) this.a.get(i2)).n(i2);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l5.h.e(this);
        if (this.L == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                L((ViewPager) parent, true, true);
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Q) {
            setupWithViewPager(null);
            this.Q = false;
        }
    }

    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            i childAt = this.d.getChildAt(i2);
            if (childAt instanceof i) {
                i.c(childAt, canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C.y0(accessibilityNodeInfo).Z(C.b.a(1, getTabCount(), false, 1));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return x() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = f5.w.b(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.u
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = f5.w.b(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.s = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto La9
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.A
            if (r0 == 0) goto L81
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L81
            goto La9
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto La9
            goto L8b
        L81:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto La9
        L8b:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            r7.measure(r0, r8)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || x()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final LinearLayout.LayoutParams p() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        N(layoutParams);
        return layoutParams;
    }

    public g q() {
        g gVar = (g) T.b();
        return gVar == null ? new g() : gVar;
    }

    public final i r(g gVar) {
        O.e eVar = this.R;
        i iVar = eVar != null ? (i) eVar.b() : null;
        if (iVar == null) {
            iVar = new i(getContext());
        }
        iVar.setTab(gVar);
        iVar.setFocusable(true);
        iVar.setMinimumWidth(getTabMinWidth());
        iVar.setContentDescription(TextUtils.isEmpty(g.c(gVar)) ? g.d(gVar) : g.c(gVar));
        return iVar;
    }

    public final void s(g gVar) {
        for (int size = this.I.size() - 1; size >= 0; size--) {
            ((c) this.I.get(size)).c(gVar);
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        l5.h.d(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.B != z) {
            this.B = z;
            for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
                i childAt = this.d.getChildAt(i2);
                if (childAt instanceof i) {
                    childAt.t();
                }
            }
            l();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.H;
        if (cVar2 != null) {
            D(cVar2);
        }
        this.H = cVar;
        if (cVar != null) {
            c(cVar);
        }
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        v();
        this.K.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(int i2) {
        setSelectedTabIndicator(i2 != 0 ? e.a.b(getContext(), i2) : null);
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.n = i2;
        O(false);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.z != i2) {
            this.z = i2;
            L.j0(this.d);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.D = i2;
        this.d.g(i2);
    }

    public void setTabGravity(int i2) {
        if (this.x != i2) {
            this.x = i2;
            l();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            M();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(e.a.a(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        com.google.android.material.tabs.a aVar;
        this.E = i2;
        if (i2 == 0) {
            aVar = new com.google.android.material.tabs.a();
        } else if (i2 == 1) {
            aVar = new n5.a();
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
            }
            aVar = new n5.b();
        }
        this.G = aVar;
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.C = z;
        f.a(this.d);
        L.j0(this.d);
    }

    public void setTabMode(int i2) {
        if (i2 != this.A) {
            this.A = i2;
            l();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
                i childAt = this.d.getChildAt(i2);
                if (childAt instanceof i) {
                    i.b(childAt, getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(e.a.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            M();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(N0.a aVar) {
        H(aVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.F != z) {
            this.F = z;
            for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
                i childAt = this.d.getChildAt(i2);
                if (childAt instanceof i) {
                    i.b(childAt, getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        K(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public final void t(g gVar) {
        for (int size = this.I.size() - 1; size >= 0; size--) {
            ((c) this.I.get(size)).a(gVar);
        }
    }

    public final void u(g gVar) {
        for (int size = this.I.size() - 1; size >= 0; size--) {
            ((c) this.I.get(size)).b(gVar);
        }
    }

    public final void v() {
        if (this.K == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.K = valueAnimator;
            valueAnimator.setInterpolator(S4.a.b);
            this.K.setDuration(this.y);
            this.K.addUpdateListener(new a());
        }
    }

    public g w(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return (g) this.a.get(i2);
    }

    public final boolean x() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    public boolean y() {
        return this.C;
    }

    public g z() {
        g q = q();
        q.h = this;
        q.i = r(q);
        if (g.a(q) != -1) {
            q.i.setId(g.a(q));
        }
        return q;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        int i3 = S;
        super(p5.a.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.a = new ArrayList();
        this.m = new GradientDrawable();
        this.n = 0;
        this.s = Integer.MAX_VALUE;
        this.D = -1;
        this.I = new ArrayList();
        this.R = new O.f(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.d = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray h2 = u.h(context2, attributeSet, l.k5, i2, i3, l.I5);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable background = getBackground();
            l5.g gVar = new l5.g();
            gVar.W(ColorStateList.valueOf(background.getColor()));
            gVar.L(context2);
            gVar.V(L.y(this));
            L.w0(this, gVar);
        }
        setSelectedTabIndicator(i5.c.d(context2, h2, l.q5));
        setSelectedTabIndicatorColor(h2.getColor(l.t5, 0));
        fVar.g(h2.getDimensionPixelSize(l.w5, -1));
        setSelectedTabIndicatorGravity(h2.getInt(l.v5, 0));
        setTabIndicatorAnimationMode(h2.getInt(l.s5, 0));
        setTabIndicatorFullWidth(h2.getBoolean(l.u5, true));
        int dimensionPixelSize = h2.getDimensionPixelSize(l.B5, 0);
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        this.f = dimensionPixelSize;
        this.e = dimensionPixelSize;
        this.e = h2.getDimensionPixelSize(l.E5, dimensionPixelSize);
        this.f = h2.getDimensionPixelSize(l.F5, this.f);
        this.g = h2.getDimensionPixelSize(l.D5, this.g);
        this.h = h2.getDimensionPixelSize(l.C5, this.h);
        int resourceId = h2.getResourceId(l.I5, k.b);
        this.i = resourceId;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, c.j.a3);
        try {
            this.p = obtainStyledAttributes.getDimensionPixelSize(c.j.b3, 0);
            this.j = i5.c.a(context2, obtainStyledAttributes, c.j.e3);
            obtainStyledAttributes.recycle();
            if (h2.hasValue(l.J5)) {
                this.j = i5.c.a(context2, h2, l.J5);
            }
            if (h2.hasValue(l.H5)) {
                this.j = o(this.j.getDefaultColor(), h2.getColor(l.H5, 0));
            }
            this.k = i5.c.a(context2, h2, l.o5);
            this.o = w.f(h2.getInt(l.p5, -1), null);
            this.l = i5.c.a(context2, h2, l.G5);
            this.y = h2.getInt(l.r5, 300);
            this.t = h2.getDimensionPixelSize(l.z5, -1);
            this.u = h2.getDimensionPixelSize(l.y5, -1);
            this.r = h2.getResourceId(l.l5, 0);
            this.w = h2.getDimensionPixelSize(l.m5, 0);
            this.A = h2.getInt(l.A5, 1);
            this.x = h2.getInt(l.n5, 0);
            this.B = h2.getBoolean(l.x5, false);
            this.F = h2.getBoolean(l.K5, false);
            h2.recycle();
            Resources resources = getResources();
            this.q = resources.getDimensionPixelSize(R4.d.i);
            this.v = resources.getDimensionPixelSize(R4.d.h);
            l();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void addView(View view, int i2) {
        i(view);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.m != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.m = drawable;
            int i2 = this.D;
            if (i2 == -1) {
                i2 = drawable.getIntrinsicHeight();
            }
            this.d.g(i2);
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        i(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        i(view);
    }
}
