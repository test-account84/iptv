package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a implements i.a {
    public O.e a;
    public final ArrayList b;
    public final ArrayList c;
    public final a d;
    public Runnable e;
    public final boolean f;
    public final i g;
    public int h;

    public interface a {
        void a(int i, int i2);

        void b(b bVar);

        void c(b bVar);

        void d(int i, int i2);

        void e(int i, int i2, Object obj);

        RecyclerView.D f(int i);

        void g(int i, int i2);

        void h(int i, int i2);
    }

    public static class b {
        public int a;
        public int b;
        public Object c;
        public int d;

        public b(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.b = i2;
            this.d = i3;
            this.c = obj;
        }

        public String a() {
            int i = this.a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.a;
            if (i != bVar.a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.b) == 1 && this.d == bVar.b && this.b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.b != bVar.b) {
                return false;
            }
            Object obj2 = this.c;
            Object obj3 = bVar.c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.d + ",p:" + this.c + "]";
        }
    }

    public a(a aVar) {
        this(aVar, false);
    }

    public b a(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.a.b();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.a = i;
        bVar.b = i2;
        bVar.d = i3;
        bVar.c = obj;
        return bVar;
    }

    public void b(b bVar) {
        if (this.f) {
            return;
        }
        bVar.c = null;
        this.a.a(bVar);
    }

    public final void c(b bVar) {
        u(bVar);
    }

    public final void d(b bVar) {
        u(bVar);
    }

    public int e(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.b.get(i2);
            int i3 = bVar.a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.b;
                    if (i4 <= i) {
                        int i5 = bVar.d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.b;
                    if (i6 == i) {
                        i = bVar.d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.d <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.b <= i) {
                i += bVar.d;
            }
        }
        return i;
    }

    public final void f(b bVar) {
        boolean z;
        char c;
        int i = bVar.b;
        int i2 = bVar.d + i;
        char c2 = 65535;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.d.f(i3) != null || h(i3)) {
                if (c2 == 0) {
                    k(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    u(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.d) {
            b(bVar);
            bVar = a(2, i, i4, null);
        }
        if (c2 == 0) {
            k(bVar);
        } else {
            u(bVar);
        }
    }

    public final void g(b bVar) {
        int i = bVar.b;
        int i2 = bVar.d + i;
        int i3 = i;
        char c = 65535;
        int i4 = 0;
        while (i < i2) {
            if (this.d.f(i) != null || h(i)) {
                if (c == 0) {
                    k(a(4, i3, i4, bVar.c));
                    i3 = i;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    u(a(4, i3, i4, bVar.c));
                    i3 = i;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
            i++;
        }
        if (i4 != bVar.d) {
            Object obj = bVar.c;
            b(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (c == 0) {
            k(bVar);
        } else {
            u(bVar);
        }
    }

    public final boolean h(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                if (n(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.b;
                int i5 = bVar.d + i4;
                while (i4 < i5) {
                    if (n(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.d.c((b) this.c.get(i));
        }
        w(this.c);
        this.h = 0;
    }

    public void j() {
        i();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                this.d.c(bVar);
                this.d.g(bVar.b, bVar.d);
            } else if (i2 == 2) {
                this.d.c(bVar);
                this.d.h(bVar.b, bVar.d);
            } else if (i2 == 4) {
                this.d.c(bVar);
                this.d.e(bVar.b, bVar.d, bVar.c);
            } else if (i2 == 8) {
                this.d.c(bVar);
                this.d.a(bVar.b, bVar.d);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        w(this.b);
        this.h = 0;
    }

    public final void k(b bVar) {
        int i;
        int i2 = bVar.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int y = y(bVar.b, i2);
        int i3 = bVar.b;
        int i4 = bVar.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.d; i6++) {
            int y2 = y(bVar.b + (i * i6), bVar.a);
            int i7 = bVar.a;
            if (i7 == 2 ? y2 != y : !(i7 == 4 && y2 == y + 1)) {
                b a2 = a(i7, y, i5, bVar.c);
                l(a2, i3);
                b(a2);
                if (bVar.a == 4) {
                    i3 += i5;
                }
                y = y2;
                i5 = 1;
            } else {
                i5++;
            }
        }
        Object obj = bVar.c;
        b(bVar);
        if (i5 > 0) {
            b a3 = a(bVar.a, y, i5, obj);
            l(a3, i3);
            b(a3);
        }
    }

    public void l(b bVar, int i) {
        this.d.b(bVar);
        int i2 = bVar.a;
        if (i2 == 2) {
            this.d.h(i, bVar.d);
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.d.e(i, bVar.d, bVar.c);
        }
    }

    public int m(int i) {
        return n(i, 0);
    }

    public int n(int i, int i2) {
        int size = this.c.size();
        while (i2 < size) {
            b bVar = (b) this.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                int i4 = bVar.b;
                if (i4 == i) {
                    i = bVar.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.d;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean o(int i) {
        return (i & this.h) != 0;
    }

    public boolean p() {
        return this.b.size() > 0;
    }

    public boolean q() {
        return (this.c.isEmpty() || this.b.isEmpty()) ? false : true;
    }

    public boolean r(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.b.add(a(4, i, i2, obj));
        this.h |= 4;
        return this.b.size() == 1;
    }

    public boolean s(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.b.add(a(8, i, i2, null));
        this.h |= 8;
        return this.b.size() == 1;
    }

    public boolean t(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.b.add(a(2, i, i2, null));
        this.h |= 2;
        return this.b.size() == 1;
    }

    public final void u(b bVar) {
        this.c.add(bVar);
        int i = bVar.a;
        if (i == 1) {
            this.d.g(bVar.b, bVar.d);
            return;
        }
        if (i == 2) {
            this.d.d(bVar.b, bVar.d);
            return;
        }
        if (i == 4) {
            this.d.e(bVar.b, bVar.d, bVar.c);
        } else {
            if (i == 8) {
                this.d.a(bVar.b, bVar.d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void v() {
        this.g.b(this.b);
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                c(bVar);
            } else if (i2 == 2) {
                f(bVar);
            } else if (i2 == 4) {
                g(bVar);
            } else if (i2 == 8) {
                d(bVar);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.b.clear();
    }

    public void w(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            b((b) list.get(i));
        }
        list.clear();
    }

    public void x() {
        w(this.b);
        w(this.c);
        this.h = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int y(int r9, int r10) {
        /*
            r8 = this;
            java.util.ArrayList r0 = r8.c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            r2 = 8
            if (r0 < 0) goto L7d
            java.util.ArrayList r3 = r8.c
            java.lang.Object r3 = r3.get(r0)
            androidx.recyclerview.widget.a$b r3 = (androidx.recyclerview.widget.a.b) r3
            int r4 = r3.a
            r5 = 2
            if (r4 != r2) goto L5e
            int r2 = r3.b
            int r4 = r3.d
            if (r2 >= r4) goto L22
            r6 = r2
            r7 = r4
            goto L24
        L22:
            r7 = r2
            r6 = r4
        L24:
            if (r9 < r6) goto L48
            if (r9 > r7) goto L48
            if (r6 != r2) goto L39
            if (r10 != r1) goto L31
            int r4 = r4 + 1
        L2e:
            r3.d = r4
            goto L36
        L31:
            if (r10 != r5) goto L36
            int r4 = r4 + (-1)
            goto L2e
        L36:
            int r9 = r9 + 1
            goto L7a
        L39:
            if (r10 != r1) goto L40
            int r2 = r2 + 1
        L3d:
            r3.b = r2
            goto L45
        L40:
            if (r10 != r5) goto L45
            int r2 = r2 + (-1)
            goto L3d
        L45:
            int r9 = r9 + (-1)
            goto L7a
        L48:
            if (r9 >= r2) goto L7a
            if (r10 != r1) goto L55
            int r2 = r2 + 1
            r3.b = r2
            int r4 = r4 + 1
        L52:
            r3.d = r4
            goto L7a
        L55:
            if (r10 != r5) goto L7a
            int r2 = r2 + (-1)
            r3.b = r2
            int r4 = r4 + (-1)
            goto L52
        L5e:
            int r2 = r3.b
            if (r2 > r9) goto L6e
            if (r4 != r1) goto L68
            int r2 = r3.d
            int r9 = r9 - r2
            goto L7a
        L68:
            if (r4 != r5) goto L7a
            int r2 = r3.d
            int r9 = r9 + r2
            goto L7a
        L6e:
            if (r10 != r1) goto L75
            int r2 = r2 + 1
        L72:
            r3.b = r2
            goto L7a
        L75:
            if (r10 != r5) goto L7a
            int r2 = r2 + (-1)
            goto L72
        L7a:
            int r0 = r0 + (-1)
            goto L8
        L7d:
            java.util.ArrayList r10 = r8.c
            int r10 = r10.size()
            int r10 = r10 - r1
        L84:
            if (r10 < 0) goto Lab
            java.util.ArrayList r0 = r8.c
            java.lang.Object r0 = r0.get(r10)
            androidx.recyclerview.widget.a$b r0 = (androidx.recyclerview.widget.a.b) r0
            int r1 = r0.a
            if (r1 != r2) goto La3
            int r1 = r0.d
            int r3 = r0.b
            if (r1 == r3) goto L9a
            if (r1 >= 0) goto La8
        L9a:
            java.util.ArrayList r1 = r8.c
            r1.remove(r10)
            r8.b(r0)
            goto La8
        La3:
            int r1 = r0.d
            if (r1 > 0) goto La8
            goto L9a
        La8:
            int r10 = r10 + (-1)
            goto L84
        Lab:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.a.y(int, int):int");
    }

    public a(a aVar, boolean z) {
        this.a = new O.f(30);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.h = 0;
        this.d = aVar;
        this.f = z;
        this.g = new i(this);
    }
}
