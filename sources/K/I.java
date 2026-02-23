package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import k.V;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static i c;
    public V a;

    public class a implements V.f {
        public final int[] a = {c.e.R, c.e.P, c.e.a};
        public final int[] b = {c.e.o, c.e.B, c.e.t, c.e.p, c.e.q, c.e.s, c.e.r};
        public final int[] c = {c.e.O, c.e.Q, c.e.k, c.e.K, c.e.L, c.e.M, c.e.N};
        public final int[] d = {c.e.w, c.e.i, c.e.v};
        public final int[] e = {c.e.J, c.e.S};
        public final int[] f = {c.e.c, c.e.g, c.e.d, c.e.h};

        public ColorStateList a(Context context, int i) {
            if (i == c.e.m) {
                return e.a.a(context, c.c.e);
            }
            if (i == c.e.I) {
                return e.a.a(context, c.c.h);
            }
            if (i == c.e.H) {
                return k(context);
            }
            if (i == c.e.f) {
                return j(context);
            }
            if (i == c.e.b) {
                return g(context);
            }
            if (i == c.e.e) {
                return i(context);
            }
            if (i == c.e.D || i == c.e.E) {
                return e.a.a(context, c.c.g);
            }
            if (f(this.b, i)) {
                return Z.e(context, c.a.u);
            }
            if (f(this.e, i)) {
                return e.a.a(context, c.c.d);
            }
            if (f(this.f, i)) {
                return e.a.a(context, c.c.c);
            }
            if (i == c.e.A) {
                return e.a.a(context, c.c.f);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x006d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0052  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = k.i.a()
                int[] r1 = r6.a
                boolean r1 = r6.f(r1, r8)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L15
                int r8 = c.a.u
            L11:
                r1 = r0
            L12:
                r0 = -1
                r5 = 1
                goto L50
            L15:
                int[] r1 = r6.c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L20
                int r8 = c.a.s
                goto L11
            L20:
                int[] r1 = r6.d
                boolean r1 = r6.f(r1, r8)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L32
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L2d:
                r1 = r0
                r8 = 16842801(0x1010031, float:2.3693695E-38)
                goto L12
            L32:
                int r1 = c.e.u
                if (r8 != r1) goto L47
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r1 = r0
                r5 = 1
                r0 = r8
                r8 = 16842800(0x1010030, float:2.3693693E-38)
                goto L50
            L47:
                int r1 = c.e.l
                if (r8 != r1) goto L4c
                goto L2d
            L4c:
                r1 = r0
                r8 = 0
                r0 = -1
                r5 = 0
            L50:
                if (r5 == 0) goto L6d
                boolean r3 = k.M.a(r9)
                if (r3 == 0) goto L5c
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L5c:
                int r7 = k.Z.c(r7, r8)
                android.graphics.PorterDuffColorFilter r7 = k.i.e(r7, r1)
                r9.setColorFilter(r7)
                if (r0 == r4) goto L6c
                r9.setAlpha(r0)
            L6c:
                return r2
            L6d:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: k.i.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        public PorterDuff.Mode c(int i) {
            if (i == c.e.H) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        public Drawable d(V v, Context context, int i) {
            int i2;
            if (i == c.e.j) {
                return new LayerDrawable(new Drawable[]{v.j(context, c.e.i), v.j(context, c.e.k)});
            }
            if (i == c.e.y) {
                i2 = c.d.g;
            } else if (i == c.e.x) {
                i2 = c.d.h;
            } else {
                if (i != c.e.z) {
                    return null;
                }
                i2 = c.d.i;
            }
            return l(v, context, i2);
        }

        public boolean e(Context context, int i, Drawable drawable) {
            LayerDrawable layerDrawable;
            Drawable findDrawableByLayerId;
            int i2;
            if (i == c.e.C) {
                layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(16908288), Z.c(context, c.a.u), i.a());
                findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
                i2 = c.a.u;
            } else {
                if (i != c.e.y && i != c.e.x && i != c.e.z) {
                    return false;
                }
                layerDrawable = (LayerDrawable) drawable;
                m(layerDrawable.findDrawableByLayerId(16908288), Z.b(context, c.a.u), i.a());
                findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
                i2 = c.a.s;
            }
            m(findDrawableByLayerId, Z.c(context, i2), i.a());
            m(layerDrawable.findDrawableByLayerId(16908301), Z.c(context, c.a.s), i.a());
            return true;
        }

        public final boolean f(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList g(Context context) {
            return h(context, 0);
        }

        public final ColorStateList h(Context context, int i) {
            int c = Z.c(context, c.a.t);
            return new ColorStateList(new int[][]{Z.b, Z.e, Z.c, Z.i}, new int[]{Z.b(context, c.a.r), G.a.j(c, i), G.a.j(c, i), i});
        }

        public final ColorStateList i(Context context) {
            return h(context, Z.c(context, c.a.q));
        }

        public final ColorStateList j(Context context) {
            return h(context, Z.c(context, c.a.r));
        }

        public final ColorStateList k(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList e = Z.e(context, c.a.x);
            if (e == null || !e.isStateful()) {
                iArr[0] = Z.b;
                iArr2[0] = Z.b(context, c.a.x);
                iArr[1] = Z.f;
                iArr2[1] = Z.c(context, c.a.s);
                iArr[2] = Z.i;
                iArr2[2] = Z.c(context, c.a.x);
            } else {
                int[] iArr3 = Z.b;
                iArr[0] = iArr3;
                iArr2[0] = e.getColorForState(iArr3, 0);
                iArr[1] = Z.f;
                iArr2[1] = Z.c(context, c.a.s);
                iArr[2] = Z.i;
                iArr2[2] = e.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public final LayerDrawable l(V v, Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            BitmapDrawable j = v.j(context, c.e.F);
            BitmapDrawable j2 = v.j(context, c.e.G);
            if ((j instanceof BitmapDrawable) && j.getIntrinsicWidth() == dimensionPixelSize && j.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = j;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                j.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((j2 instanceof BitmapDrawable) && j2.getIntrinsicWidth() == dimensionPixelSize && j2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = j2;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                j2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                j2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        public final void m(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (M.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = i.a();
            }
            drawable.setColorFilter(i.e(i, mode));
        }
    }

    public static /* synthetic */ PorterDuff.Mode a() {
        return b;
    }

    public static synchronized i b() {
        i iVar;
        synchronized (i.class) {
            try {
                if (c == null) {
                    h();
                }
                iVar = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter l;
        synchronized (i.class) {
            l = V.l(i, mode);
        }
        return l;
    }

    public static synchronized void h() {
        synchronized (i.class) {
            if (c == null) {
                i iVar = new i();
                c = iVar;
                iVar.a = V.h();
                c.a.u(new a());
            }
        }
    }

    public static void i(Drawable drawable, b0 b0Var, int[] iArr) {
        V.w(drawable, b0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i) {
        return this.a.j(context, i);
    }

    public synchronized Drawable d(Context context, int i, boolean z) {
        return this.a.k(context, i, z);
    }

    public synchronized ColorStateList f(Context context, int i) {
        return this.a.m(context, i);
    }

    public synchronized void g(Context context) {
        this.a.s(context);
    }
}
