package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.m;
import androidx.leanback.widget.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class s {
    public static Rect a = new Rect();

    public static int a(View view, r.a aVar, int i) {
        View view2;
        int i2;
        m.e layoutParams = view.getLayoutParams();
        int i3 = aVar.a;
        if (i3 == 0 || (view2 = view.findViewById(i3)) == null) {
            view2 = view;
        }
        int i4 = aVar.c;
        if (i != 0) {
            if (aVar.e) {
                float f = aVar.d;
                if (f == 0.0f) {
                    i4 += view2.getPaddingTop();
                } else if (f == 100.0f) {
                    i4 -= view2.getPaddingBottom();
                }
            }
            if (aVar.d != -1.0f) {
                i4 += (int) (((view2 == view ? layoutParams.t(view2) : view2.getHeight()) * aVar.d) / 100.0f);
            }
            if (view != view2) {
                Rect rect = a;
                rect.top = i4;
                ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
                i2 = a.top - layoutParams.G();
            } else {
                i2 = i4;
            }
            return aVar.d() ? i2 + view2.getBaseline() : i2;
        }
        if (view.getLayoutDirection() == 1) {
            int H = (view2 == view ? layoutParams.H(view2) : view2.getWidth()) - i4;
            if (aVar.e) {
                float f2 = aVar.d;
                if (f2 == 0.0f) {
                    H -= view2.getPaddingRight();
                } else if (f2 == 100.0f) {
                    H += view2.getPaddingLeft();
                }
            }
            if (aVar.d != -1.0f) {
                H -= (int) (((view2 == view ? layoutParams.H(view2) : view2.getWidth()) * aVar.d) / 100.0f);
            }
            if (view == view2) {
                return H;
            }
            Rect rect2 = a;
            rect2.right = H;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect2);
            return a.right + layoutParams.A();
        }
        if (aVar.e) {
            float f3 = aVar.d;
            if (f3 == 0.0f) {
                i4 += view2.getPaddingLeft();
            } else if (f3 == 100.0f) {
                i4 -= view2.getPaddingRight();
            }
        }
        if (aVar.d != -1.0f) {
            i4 += (int) (((view2 == view ? layoutParams.H(view2) : view2.getWidth()) * aVar.d) / 100.0f);
        }
        int i5 = i4;
        if (view == view2) {
            return i5;
        }
        Rect rect3 = a;
        rect3.left = i5;
        ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect3);
        return a.left - layoutParams.w();
    }
}
