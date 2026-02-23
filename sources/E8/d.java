package E8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class d implements D8.d {
    public final CharSequence a;
    public final int b;
    public final int c;
    public final w8.p d;

    public static final class a implements Iterator, x8.a {
        public int a = -1;
        public int c;
        public int d;
        public B8.c e;
        public int f;

        public a() {
            int h = B8.h.h(d.e(d.this), 0, d.c(d.this).length());
            this.c = h;
            this.d = h;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b() {
            /*
                r6 = this;
                int r0 = r6.d
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.a = r1
                r0 = 0
                r6.e = r0
                goto L99
            Lc:
                E8.d r0 = E8.d.this
                int r0 = E8.d.d(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f
                int r0 = r0 + r3
                r6.f = r0
                E8.d r4 = E8.d.this
                int r4 = E8.d.d(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.d
                E8.d r4 = E8.d.this
                java.lang.CharSequence r4 = E8.d.c(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                B8.c r0 = new B8.c
                int r1 = r6.c
                E8.d r4 = E8.d.this
                java.lang.CharSequence r4 = E8.d.c(r4)
                int r4 = E8.o.L(r4)
                r0.<init>(r1, r4)
            L42:
                r6.e = r0
            L44:
                r6.d = r2
                goto L97
            L47:
                E8.d r0 = E8.d.this
                w8.p r0 = E8.d.b(r0)
                E8.d r4 = E8.d.this
                java.lang.CharSequence r4 = E8.d.c(r4)
                int r5 = r6.d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                k8.i r0 = (k8.i) r0
                if (r0 != 0) goto L73
                B8.c r0 = new B8.c
                int r1 = r6.c
                E8.d r4 = E8.d.this
                java.lang.CharSequence r4 = E8.d.c(r4)
                int r4 = E8.o.L(r4)
                r0.<init>(r1, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.c
                B8.c r4 = B8.h.m(r4, r2)
                r6.e = r4
                int r2 = r2 + r0
                r6.c = r2
                if (r0 != 0) goto L95
                r1 = 1
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.a = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: E8.d.a.b():void");
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public B8.c next() {
            if (this.a == -1) {
                b();
            }
            if (this.a == 0) {
                throw new NoSuchElementException();
            }
            B8.c cVar = this.e;
            kotlin.jvm.internal.l.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.e = null;
            this.a = -1;
            return cVar;
        }

        public boolean hasNext() {
            if (this.a == -1) {
                b();
            }
            return this.a == 1;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(CharSequence input, int i, int i2, w8.p getNextMatch) {
        kotlin.jvm.internal.l.e(input, "input");
        kotlin.jvm.internal.l.e(getNextMatch, "getNextMatch");
        this.a = input;
        this.b = i;
        this.c = i2;
        this.d = getNextMatch;
    }

    public static final /* synthetic */ w8.p b(d dVar) {
        return dVar.d;
    }

    public static final /* synthetic */ CharSequence c(d dVar) {
        return dVar.a;
    }

    public static final /* synthetic */ int d(d dVar) {
        return dVar.c;
    }

    public static final /* synthetic */ int e(d dVar) {
        return dVar.b;
    }

    public Iterator iterator() {
        return new a();
    }
}
