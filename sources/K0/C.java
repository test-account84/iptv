package K0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends l {
    public static final String[] M = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property N = new b(PointF.class, "boundsOrigin");
    public static final Property O = new c(PointF.class, "topLeft");
    public static final Property P = new d(PointF.class, "bottomRight");
    public static final Property Q = new e(PointF.class, "bottomRight");
    public static final Property R = new f(PointF.class, "topLeft");
    public static final Property S = new g(PointF.class, "position");
    public static K0.j T = new K0.j();
    public int[] J = new int[2];
    public boolean K = false;
    public boolean L = false;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ BitmapDrawable c;
        public final /* synthetic */ View d;
        public final /* synthetic */ float e;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.a = viewGroup;
            this.c = bitmapDrawable;
            this.d = view;
            this.e = f;
        }

        public void onAnimationEnd(Animator animator) {
            A.b(this.a).b(this.c);
            A.g(this.d, this.e);
        }
    }

    public class b extends Property {
        public Rect a;

        public b(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF(rect.left, rect.top);
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    }

    public class c extends Property {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    public class d extends Property {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    public class e extends Property {
        public e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            A.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    public class f extends Property {
        public f(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            A.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    public class g extends Property {
        public g(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            A.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    public class h extends AnimatorListenerAdapter {
        public final /* synthetic */ k a;
        private k mViewBounds;

        public h(k kVar) {
            this.a = kVar;
            this.mViewBounds = kVar;
        }
    }

    public class i extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ View c;
        public final /* synthetic */ Rect d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;

        public i(View view, Rect rect, int i, int i2, int i3, int i4) {
            this.c = view;
            this.d = rect;
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.h = i4;
        }

        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            P.L.z0(this.c, this.d);
            A.f(this.c, this.e, this.f, this.g, this.h);
        }
    }

    public class j extends m {
        public boolean a = false;
        public final /* synthetic */ ViewGroup c;

        public j(ViewGroup viewGroup) {
            this.c = viewGroup;
        }

        public void b(l lVar) {
            x.c(this.c, false);
        }

        public void c(l lVar) {
            if (!this.a) {
                x.c(this.c, false);
            }
            lVar.Q(this);
        }

        public void d(l lVar) {
            x.c(this.c, false);
            this.a = true;
        }

        public void e(l lVar) {
            x.c(this.c, true);
        }
    }

    public static class k {
        public int a;
        public int b;
        public int c;
        public int d;
        public View e;
        public int f;
        public int g;

        public k(View view) {
            this.e = view;
        }

        public void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                b();
            }
        }

        public final void b() {
            A.f(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }

        public void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                b();
            }
        }
    }

    public String[] E() {
        return M;
    }

    public final void d0(s sVar) {
        View view = sVar.b;
        if (!P.L.W(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.a.put("android:changeBounds:parent", sVar.b.getParent());
        if (this.L) {
            sVar.b.getLocationInWindow(this.J);
            sVar.a.put("android:changeBounds:windowX", Integer.valueOf(this.J[0]));
            sVar.a.put("android:changeBounds:windowY", Integer.valueOf(this.J[1]));
        }
        if (this.K) {
            sVar.a.put("android:changeBounds:clip", P.L.w(view));
        }
    }

    public final boolean e0(View view, View view2) {
        if (!this.L) {
            return true;
        }
        s u = u(view, true);
        if (u == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == u.b) {
            return true;
        }
        return false;
    }

    public void g(s sVar) {
        d0(sVar);
    }

    public void j(s sVar) {
        d0(sVar);
    }

    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        int i2;
        View view;
        int i3;
        Animator animator;
        Animator c2;
        Path a2;
        Property property;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map map = sVar.a;
        Map map2 = sVar2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.b;
        if (!e0(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) sVar.a.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) sVar.a.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) sVar2.a.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) sVar2.a.get("android:changeBounds:windowY")).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.J);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            Drawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float c3 = A.c(view2);
            A.g(view2, 0.0f);
            A.b(viewGroup).a(bitmapDrawable);
            K0.g w = w();
            int[] iArr = this.J;
            int i4 = iArr[0];
            int i5 = iArr[1];
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{K0.h.a(N, w.a(intValue - i4, intValue2 - i5, intValue3 - i4, intValue4 - i5))});
            ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c3));
            return ofPropertyValuesHolder;
        }
        Rect rect = (Rect) sVar.a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) sVar2.a.get("android:changeBounds:bounds");
        int i6 = rect.left;
        int i7 = rect2.left;
        int i8 = rect.top;
        int i9 = rect2.top;
        int i10 = rect.right;
        int i11 = rect2.right;
        int i12 = rect.bottom;
        int i13 = rect2.bottom;
        int i14 = i10 - i6;
        int i15 = i12 - i8;
        int i16 = i11 - i7;
        int i17 = i13 - i9;
        Rect rect3 = (Rect) sVar.a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) sVar2.a.get("android:changeBounds:clip");
        if ((i14 == 0 || i15 == 0) && (i16 == 0 || i17 == 0)) {
            i2 = 0;
        } else {
            i2 = (i6 == i7 && i8 == i9) ? 0 : 1;
            if (i10 != i11 || i12 != i13) {
                i2++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        if (this.K) {
            view = view2;
            A.f(view, i6, i8, Math.max(i14, i16) + i6, Math.max(i15, i17) + i8);
            Animator a3 = (i6 == i7 && i8 == i9) ? null : K0.f.a(view, S, w().a(i6, i8, i7, i9));
            if (rect3 == null) {
                i3 = 0;
                rect3 = new Rect(0, 0, i14, i15);
            } else {
                i3 = 0;
            }
            Rect rect5 = rect4 == null ? new Rect(i3, i3, i16, i17) : rect4;
            if (rect3.equals(rect5)) {
                animator = null;
            } else {
                P.L.z0(view, rect3);
                K0.j jVar = T;
                Object[] objArr = new Object[2];
                objArr[i3] = rect3;
                objArr[1] = rect5;
                Animator ofObject = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                ofObject.addListener(new i(view, rect4, i7, i9, i11, i13));
                animator = ofObject;
            }
            c2 = r.c(a3, animator);
        } else {
            view = view2;
            A.f(view, i6, i8, i10, i12);
            if (i2 == 2) {
                if (i14 == i16 && i15 == i17) {
                    a2 = w().a(i6, i8, i7, i9);
                    property = S;
                } else {
                    k kVar = new k(view);
                    Animator a4 = K0.f.a(kVar, O, w().a(i6, i8, i7, i9));
                    Animator a5 = K0.f.a(kVar, P, w().a(i10, i12, i11, i13));
                    Animator animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new Animator[]{a4, a5});
                    animatorSet.addListener(new h(kVar));
                    c2 = animatorSet;
                }
            } else if (i6 == i7 && i8 == i9) {
                a2 = w().a(i10, i12, i11, i13);
                property = Q;
            } else {
                a2 = w().a(i6, i8, i7, i9);
                property = R;
            }
            c2 = K0.f.a(view, property, a2);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup parent = view.getParent();
            x.c(parent, true);
            b(new j(parent));
        }
        return c2;
    }
}
