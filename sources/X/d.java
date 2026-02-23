package x;

import java.util.HashSet;
import java.util.Iterator;
import w.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d {
    public final e b;
    public final b c;
    public d d;
    public w.i g;
    public HashSet a = null;
    public int e = 0;
    public int f = -1;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public d(e eVar, b bVar) {
        this.b = eVar;
        this.c = bVar;
    }

    public boolean a(d dVar, int i, int i2, boolean z) {
        if (dVar == null) {
            k();
            return true;
        }
        if (!z && !j(dVar)) {
            return false;
        }
        this.d = dVar;
        if (dVar.a == null) {
            dVar.a = new HashSet();
        }
        this.d.a.add(this);
        if (i > 0) {
            this.e = i;
        } else {
            this.e = 0;
        }
        this.f = i2;
        return true;
    }

    public int b() {
        d dVar;
        if (this.b.M() == 8) {
            return 0;
        }
        return (this.f <= -1 || (dVar = this.d) == null || dVar.b.M() != 8) ? this.e : this.f;
    }

    public final d c() {
        switch (a.a[this.c.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.b.D;
            case 3:
                return this.b.B;
            case 4:
                return this.b.E;
            case 5:
                return this.b.C;
            default:
                throw new AssertionError(this.c.name());
        }
    }

    public e d() {
        return this.b;
    }

    public w.i e() {
        return this.g;
    }

    public d f() {
        return this.d;
    }

    public b g() {
        return this.c;
    }

    public boolean h() {
        HashSet hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).c().i()) {
                return true;
            }
        }
        return false;
    }

    public boolean i() {
        return this.d != null;
    }

    public boolean j(d dVar) {
        if (dVar == null) {
            return false;
        }
        b g = dVar.g();
        b bVar = this.c;
        if (g == bVar) {
            return bVar != b.BASELINE || (dVar.d().Q() && d().Q());
        }
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return (g == b.BASELINE || g == b.CENTER_X || g == b.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = g == b.LEFT || g == b.RIGHT;
                if (dVar.d() instanceof g) {
                    return z || g == b.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = g == b.TOP || g == b.BOTTOM;
                if (dVar.d() instanceof g) {
                    return z2 || g == b.CENTER_Y;
                }
                return z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.c.name());
        }
    }

    public void k() {
        HashSet hashSet;
        d dVar = this.d;
        if (dVar != null && (hashSet = dVar.a) != null) {
            hashSet.remove(this);
        }
        this.d = null;
        this.e = 0;
        this.f = -1;
    }

    public void l(w.c cVar) {
        w.i iVar = this.g;
        if (iVar == null) {
            this.g = new w.i(i.a.UNRESTRICTED, null);
        } else {
            iVar.d();
        }
    }

    public String toString() {
        return this.b.p() + ":" + this.c.toString();
    }
}
