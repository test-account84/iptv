package O1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import j2.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class e implements Cloneable {
    public boolean A;
    public boolean B;
    public Drawable C;
    public int D;
    public final Class a;
    public final Context c;
    public final g d;
    public final Class e;
    public final m f;
    public final j2.g g;
    public l2.a h;
    public Object i;
    public S1.c j;
    public boolean k;
    public int l;
    public int m;
    public m2.d n;
    public Float o;
    public e p;
    public Float q;
    public Drawable r;
    public Drawable s;
    public i t;
    public boolean u;
    public n2.d v;
    public int w;
    public int x;
    public U1.b y;
    public S1.g z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public e(Context context, Class cls, l2.f fVar, Class cls2, g gVar, m mVar, j2.g gVar2) {
        this.j = p2.a.b();
        this.q = Float.valueOf(1.0f);
        this.t = null;
        this.u = true;
        this.v = n2.e.d();
        this.w = -1;
        this.x = -1;
        this.y = U1.b.RESULT;
        this.z = c2.d.b();
        this.c = context;
        this.a = cls;
        this.e = cls2;
        this.d = gVar;
        this.f = mVar;
        this.g = gVar2;
        this.h = fVar != null ? new l2.a(fVar) : null;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (cls != null && fVar == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    public e b(n2.d dVar) {
        if (dVar == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.v = dVar;
        return this;
    }

    public final m2.b f(o2.j jVar) {
        if (this.t == null) {
            this.t = i.NORMAL;
        }
        return g(jVar, null);
    }

    public final m2.b g(o2.j jVar, m2.f fVar) {
        m2.f fVar2;
        m2.b p;
        m2.b p2;
        e eVar = this.p;
        if (eVar != null) {
            if (this.B) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (eVar.v.equals(n2.e.d())) {
                this.p.v = this.v;
            }
            e eVar2 = this.p;
            if (eVar2.t == null) {
                eVar2.t = k();
            }
            if (q2.h.k(this.x, this.w)) {
                e eVar3 = this.p;
                if (!q2.h.k(eVar3.x, eVar3.w)) {
                    this.p.q(this.x, this.w);
                }
            }
            fVar2 = new m2.f(fVar);
            p = p(jVar, this.q.floatValue(), this.t, fVar2);
            this.B = true;
            p2 = this.p.g(jVar, fVar2);
            this.B = false;
        } else {
            if (this.o == null) {
                return p(jVar, this.q.floatValue(), this.t, fVar);
            }
            fVar2 = new m2.f(fVar);
            p = p(jVar, this.q.floatValue(), this.t, fVar2);
            p2 = p(jVar, this.o.floatValue(), k(), fVar2);
        }
        fVar2.k(p, p2);
        return fVar2;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public e clone() {
        try {
            e eVar = (e) super.clone();
            l2.a aVar = this.h;
            eVar.h = aVar != null ? aVar.clone() : null;
            return eVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public e i(S1.e eVar) {
        l2.a aVar = this.h;
        if (aVar != null) {
            aVar.j(eVar);
        }
        return this;
    }

    public e j(U1.b bVar) {
        this.y = bVar;
        return this;
    }

    public final i k() {
        i iVar = this.t;
        return iVar == i.LOW ? i.NORMAL : iVar == i.NORMAL ? i.HIGH : i.IMMEDIATE;
    }

    public o2.j l(ImageView imageView) {
        q2.h.a();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!this.A && imageView.getScaleType() != null) {
            int i = a.a[imageView.getScaleType().ordinal()];
            if (i == 1) {
                d();
            } else if (i == 2 || i == 3 || i == 4) {
                e();
            }
        }
        return m(this.d.c(imageView, this.e));
    }

    public o2.j m(o2.j jVar) {
        q2.h.a();
        if (jVar == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.k) {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        m2.b e = jVar.e();
        if (e != null) {
            e.clear();
            this.f.c(e);
            e.b();
        }
        m2.b f = f(jVar);
        jVar.h(f);
        this.g.a(jVar);
        this.f.f(f);
        return jVar;
    }

    public e n(m2.d dVar) {
        this.n = dVar;
        return this;
    }

    public e o(Object obj) {
        this.i = obj;
        this.k = true;
        return this;
    }

    public final m2.b p(o2.j jVar, float f, i iVar, m2.c cVar) {
        return m2.a.t(this.h, this.i, this.j, this.c, iVar, jVar, f, this.r, this.l, this.s, this.m, this.C, this.D, this.n, cVar, this.d.p(), this.z, this.e, this.u, this.v, this.x, this.w, this.y);
    }

    public e q(int i, int i2) {
        if (!q2.h.k(i, i2)) {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        }
        this.x = i;
        this.w = i2;
        return this;
    }

    public e s(S1.c cVar) {
        if (cVar == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.j = cVar;
        return this;
    }

    public e t(boolean z) {
        this.u = !z;
        return this;
    }

    public e u(S1.b bVar) {
        l2.a aVar = this.h;
        if (aVar != null) {
            aVar.k(bVar);
        }
        return this;
    }

    public e v(S1.g... gVarArr) {
        this.A = true;
        if (gVarArr.length == 1) {
            this.z = gVarArr[0];
        } else {
            this.z = new S1.d(gVarArr);
        }
        return this;
    }

    public e(l2.f fVar, Class cls, e eVar) {
        this(eVar.c, eVar.a, fVar, cls, eVar.d, eVar.f, eVar.g);
        this.i = eVar.i;
        this.k = eVar.k;
        this.j = eVar.j;
        this.y = eVar.y;
        this.u = eVar.u;
    }

    public void d() {
    }

    public void e() {
    }
}
