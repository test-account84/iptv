package com.google.android.material.bottomappbar;

import P.L;
import R4.k;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d.D;
import java.lang.ref.WeakReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final int V = k.l;

    public static class Behavior extends HideBottomViewOnScrollBehavior {
        public final Rect e;
        public WeakReference f;
        public int g;
        public final View.OnLayoutChangeListener h;

        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                D.a(Behavior.M(Behavior.this).get());
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.h = new a();
            this.e = new Rect();
        }

        public static /* synthetic */ WeakReference M(Behavior behavior) {
            return behavior.f;
        }

        public /* bridge */ /* synthetic */ boolean A(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            D.a(view);
            return O(coordinatorLayout, null, view2, view3, i, i2);
        }

        public boolean N(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            this.f = new WeakReference(bottomAppBar);
            FloatingActionButton T = BottomAppBar.T(bottomAppBar);
            if (T != null && !L.W(T)) {
                CoordinatorLayout.f layoutParams = T.getLayoutParams();
                layoutParams.d = 49;
                this.g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (T instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = T;
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R4.a.b);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R4.a.a);
                    }
                    floatingActionButton.addOnLayoutChangeListener(this.h);
                    BottomAppBar.U(bottomAppBar, floatingActionButton);
                }
                BottomAppBar.S(bottomAppBar);
            }
            coordinatorLayout.J(bottomAppBar, i);
            return super.l(coordinatorLayout, bottomAppBar, i);
        }

        public boolean O(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            throw null;
        }

        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            D.a(view);
            return N(coordinatorLayout, null, i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = new a();
            this.e = new Rect();
        }
    }

    public static /* synthetic */ void S(BottomAppBar bottomAppBar) {
        throw null;
    }

    public static /* synthetic */ View T(BottomAppBar bottomAppBar) {
        throw null;
    }

    public static /* synthetic */ void U(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        throw null;
    }
}
