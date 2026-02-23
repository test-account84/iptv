package f5;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import k.C;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r {
    public static final int n;
    public static boolean o;
    public static Constructor p;
    public static Object q;
    public CharSequence a;
    public final TextPaint b;
    public final int c;
    public int e;
    public boolean l;
    public int d = 0;
    public Layout.Alignment f = Layout.Alignment.ALIGN_NORMAL;
    public int g = Integer.MAX_VALUE;
    public float h = 0.0f;
    public float i = 1.0f;
    public int j = n;
    public boolean k = true;
    public TextUtils.TruncateAt m = null;

    public static class a extends Exception {
        public a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        n = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public r(CharSequence charSequence, TextPaint textPaint, int i) {
        this.a = charSequence;
        this.b = textPaint;
        this.c = i;
        this.e = charSequence.length();
    }

    public static r c(CharSequence charSequence, TextPaint textPaint, int i) {
        return new r(charSequence, textPaint, i);
    }

    public StaticLayout a() {
        if (this.a == null) {
            this.a = "";
        }
        int max = Math.max(0, this.c);
        CharSequence charSequence = this.a;
        if (this.g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.b, max, this.m);
        }
        int min = Math.min(charSequence.length(), this.e);
        this.e = min;
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                return (StaticLayout) ((Constructor) O.h.f(p)).newInstance(new Object[]{charSequence, Integer.valueOf(this.d), Integer.valueOf(this.e), this.b, Integer.valueOf(max), this.f, O.h.f(q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.k), null, Integer.valueOf(max), Integer.valueOf(this.g)});
            } catch (Exception e) {
                throw new a(e);
            }
        }
        if (this.l && this.g == 1) {
            this.f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder a2 = j.a(charSequence, this.d, min, this.b, max);
        k.a(a2, this.f);
        l.a(a2, this.k);
        C.a(a2, this.l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.m;
        if (truncateAt != null) {
            m.a(a2, truncateAt);
        }
        n.a(a2, this.g);
        float f = this.h;
        if (f != 0.0f || this.i != 1.0f) {
            o.a(a2, f, this.i);
        }
        if (this.g > 1) {
            p.a(a2, this.j);
        }
        return q.a(a2);
    }

    public final void b() {
        if (o) {
            return;
        }
        try {
            q = this.l && Build.VERSION.SDK_INT >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls});
            p = declaredConstructor;
            declaredConstructor.setAccessible(true);
            o = true;
        } catch (Exception e) {
            throw new a(e);
        }
    }

    public r d(Layout.Alignment alignment) {
        this.f = alignment;
        return this;
    }

    public r e(TextUtils.TruncateAt truncateAt) {
        this.m = truncateAt;
        return this;
    }

    public r f(int i) {
        this.j = i;
        return this;
    }

    public r g(boolean z) {
        this.k = z;
        return this;
    }

    public r h(boolean z) {
        this.l = z;
        return this;
    }

    public r i(float f, float f2) {
        this.h = f;
        this.i = f2;
        return this;
    }

    public r j(int i) {
        this.g = i;
        return this;
    }
}
