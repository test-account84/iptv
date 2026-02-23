package f;

import F.k;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import f.b;
import f.e;
import k.V;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a extends f.e implements H.b {
    public c p;
    public g q;
    public int r;
    public int s;
    public boolean t;

    public static class b extends g {
        public final Animatable a;

        public b(Animatable animatable) {
            super(null);
            this.a = animatable;
        }

        public void c() {
            this.a.start();
        }

        public void d() {
            this.a.stop();
        }
    }

    public static class c extends e.a {
        public s.f K;
        public j L;

        public c(c cVar, a aVar, Resources resources) {
            j jVar;
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                jVar = cVar.L;
            } else {
                this.K = new s.f();
                jVar = new j();
            }
            this.L = jVar;
        }

        public static long D(int i, int i2) {
            return i2 | (i << 32);
        }

        public int B(int[] iArr, Drawable drawable, int i) {
            int z = super.z(iArr, drawable);
            this.L.k(z, Integer.valueOf(i));
            return z;
        }

        public int C(int i, int i2, Drawable drawable, boolean z) {
            int a = super.a(drawable);
            long D = D(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = a;
            this.K.b(D, Long.valueOf(j2 | j));
            if (z) {
                this.K.b(D(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a;
        }

        public int E(int i) {
            if (i < 0) {
                return 0;
            }
            return ((Integer) this.L.h(i, 0)).intValue();
        }

        public int F(int[] iArr) {
            int A = super.A(iArr);
            return A >= 0 ? A : super.A(StateSet.WILD_CARD);
        }

        public int G(int i, int i2) {
            return (int) ((Long) this.K.h(D(i, i2), -1L)).longValue();
        }

        public boolean H(int i, int i2) {
            return (((Long) this.K.h(D(i, i2), -1L)).longValue() & 4294967296L) != 0;
        }

        public boolean I(int i, int i2) {
            return (((Long) this.K.h(D(i, i2), -1L)).longValue() & 8589934592L) != 0;
        }

        public Drawable newDrawable() {
            return new a(this, null);
        }

        public void r() {
            this.K = this.K.e();
            this.L = this.L.e();
        }

        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    public static class d extends g {
        public final L0.b a;

        public d(L0.b bVar) {
            super(null);
            this.a = bVar;
        }

        public void c() {
            this.a.start();
        }

        public void d() {
            this.a.stop();
        }
    }

    public static class e extends g {
        public final ObjectAnimator a;
        public final boolean b;

        public e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, i2});
            g.b.a(ofInt, true);
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.b = z2;
            this.a = ofInt;
        }

        public boolean a() {
            return this.b;
        }

        public void b() {
            this.a.reverse();
        }

        public void c() {
            this.a.start();
        }

        public void d() {
            this.a.cancel();
        }
    }

    public static class f implements TimeInterpolator {
        public int[] a;
        public int b;
        public int c;

        public f(AnimationDrawable animationDrawable, boolean z) {
            b(animationDrawable, z);
        }

        public int a() {
            return this.c;
        }

        public int b(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            int[] iArr = this.a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.a = new int[numberOfFrames];
            }
            int[] iArr2 = this.a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.c = i;
            return i;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * this.c) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.a;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3];
                if (i < i4) {
                    break;
                }
                i -= i4;
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.c : 0.0f);
        }
    }

    public static abstract class g {
        public g() {
        }

        public boolean a() {
            return false;
        }

        public abstract void c();

        public abstract void d();

        public /* synthetic */ g(a aVar) {
            this();
        }

        public void b() {
        }
    }

    public a() {
        this(null, null);
    }

    public static a l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.m(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    public void h(b.d dVar) {
        super.h(dVar);
        if (dVar instanceof c) {
            this.p = (c) dVar;
        }
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.q;
        if (gVar != null) {
            gVar.d();
            this.q = null;
            g(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public c b() {
        return new c(this.p, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray s = k.s(resources, theme, attributeSet, g.e.a);
        setVisible(s.getBoolean(g.e.c, true), true);
        s(s);
        i(resources);
        s.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    public Drawable mutate() {
        if (!this.t && super.mutate() == this) {
            this.p.r();
            this.t = true;
        }
        return this;
    }

    public final void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    p(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    public final void o() {
        onStateChange(getState());
    }

    public boolean onStateChange(int[] iArr) {
        int F = this.p.F(iArr);
        boolean z = F != c() && (r(F) || g(F));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public final int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray s = k.s(resources, theme, attributeSet, g.e.h);
        int resourceId = s.getResourceId(g.e.i, 0);
        int resourceId2 = s.getResourceId(g.e.j, -1);
        Drawable j = resourceId2 > 0 ? V.h().j(context, resourceId2) : null;
        s.recycle();
        int[] j2 = j(attributeSet);
        if (j == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            j = xmlPullParser.getName().equals("vector") ? L0.g.c(resources, xmlPullParser, attributeSet, theme) : g.c.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (j != null) {
            return this.p.B(j2, j, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public final int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray s = k.s(resources, theme, attributeSet, g.e.k);
        int resourceId = s.getResourceId(g.e.n, -1);
        int resourceId2 = s.getResourceId(g.e.m, -1);
        int resourceId3 = s.getResourceId(g.e.l, -1);
        Drawable j = resourceId3 > 0 ? V.h().j(context, resourceId3) : null;
        boolean z = s.getBoolean(g.e.o, false);
        s.recycle();
        if (j == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            j = xmlPullParser.getName().equals("animated-vector") ? L0.b.a(context, resources, xmlPullParser, attributeSet, theme) : g.c.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (j == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.p.C(resourceId, resourceId2, j, z);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    public final boolean r(int i) {
        int c2;
        int G;
        g bVar;
        g gVar = this.q;
        if (gVar == null) {
            c2 = c();
        } else {
            if (i == this.r) {
                return true;
            }
            if (i == this.s && gVar.a()) {
                gVar.b();
                this.r = this.s;
                this.s = i;
                return true;
            }
            c2 = this.r;
            gVar.d();
        }
        this.q = null;
        this.s = -1;
        this.r = -1;
        c cVar = this.p;
        int E = cVar.E(c2);
        int E2 = cVar.E(i);
        if (E2 == 0 || E == 0 || (G = cVar.G(E, E2)) < 0) {
            return false;
        }
        boolean I = cVar.I(E, E2);
        g(G);
        AnimationDrawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e(current, cVar.H(E, E2), I);
        } else {
            if (!(current instanceof L0.b)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((L0.b) current);
        }
        bVar.c();
        this.q = bVar;
        this.s = c2;
        this.r = i;
        return true;
    }

    public final void s(TypedArray typedArray) {
        c cVar = this.p;
        cVar.d |= g.c.b(typedArray);
        cVar.x(typedArray.getBoolean(g.e.d, cVar.i));
        cVar.t(typedArray.getBoolean(g.e.e, cVar.l));
        cVar.u(typedArray.getInt(g.e.f, cVar.A));
        cVar.v(typedArray.getInt(g.e.g, cVar.B));
        setDither(typedArray.getBoolean(g.e.b, cVar.x));
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        g gVar = this.q;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public a(c cVar, Resources resources) {
        super(null);
        this.r = -1;
        this.s = -1;
        h(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
