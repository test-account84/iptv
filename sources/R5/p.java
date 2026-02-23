package r5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p {
    public final r5.c a;
    public final boolean b;
    public final c c;
    public final int d;

    public class a implements c {
        public final /* synthetic */ r5.c a;

        public class a extends b {
            public a(p pVar, CharSequence charSequence) {
                super(pVar, charSequence);
            }

            public int f(int i) {
                return i + 1;
            }

            public int g(int i) {
                return a.this.a.c(this.d, i);
            }
        }

        public a(r5.c cVar) {
            this.a = cVar;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(p pVar, CharSequence charSequence) {
            return new a(pVar, charSequence);
        }
    }

    public static abstract class b extends r5.a {
        public final CharSequence d;
        public final r5.c e;
        public final boolean f;
        public int g = 0;
        public int h;

        public b(p pVar, CharSequence charSequence) {
            this.e = p.a(pVar);
            this.f = p.b(pVar);
            this.h = p.c(pVar);
            this.d = charSequence;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        
            if (r0 >= r1) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
        
            if (r6.e.e(r6.d.charAt(r0)) == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        
            r0 = r0 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
        
            if (r1 <= r0) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        
            if (r6.e.e(r6.d.charAt(r1 - 1)) == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        
            r1 = r1 - 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        
            if (r6.f == false) goto L39;
         */
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String b() {
            /*
                r6 = this;
            L0:
                int r0 = r6.g
            L2:
                int r1 = r6.g
                r2 = -1
                if (r1 == r2) goto L8e
                int r1 = r6.g(r1)
                if (r1 != r2) goto L16
                java.lang.CharSequence r1 = r6.d
                int r1 = r1.length()
                r6.g = r2
                goto L1c
            L16:
                int r3 = r6.f(r1)
                r6.g = r3
            L1c:
                int r3 = r6.g
                if (r3 != r0) goto L2f
                int r3 = r3 + 1
                r6.g = r3
                java.lang.CharSequence r1 = r6.d
                int r1 = r1.length()
                if (r3 <= r1) goto L2
                r6.g = r2
                goto L2
            L2f:
                if (r0 >= r1) goto L42
                r5.c r3 = r6.e
                java.lang.CharSequence r4 = r6.d
                char r4 = r4.charAt(r0)
                boolean r3 = r3.e(r4)
                if (r3 == 0) goto L42
                int r0 = r0 + 1
                goto L2f
            L42:
                if (r1 <= r0) goto L57
                r5.c r3 = r6.e
                java.lang.CharSequence r4 = r6.d
                int r5 = r1 + (-1)
                char r4 = r4.charAt(r5)
                boolean r3 = r3.e(r4)
                if (r3 == 0) goto L57
                int r1 = r1 + (-1)
                goto L42
            L57:
                boolean r3 = r6.f
                if (r3 == 0) goto L5e
                if (r0 != r1) goto L5e
                goto L0
            L5e:
                int r3 = r6.h
                r4 = 1
                if (r3 != r4) goto L80
                java.lang.CharSequence r1 = r6.d
                int r1 = r1.length()
                r6.g = r2
            L6b:
                if (r1 <= r0) goto L83
                r5.c r2 = r6.e
                java.lang.CharSequence r3 = r6.d
                int r4 = r1 + (-1)
                char r3 = r3.charAt(r4)
                boolean r2 = r2.e(r3)
                if (r2 == 0) goto L83
                int r1 = r1 + (-1)
                goto L6b
            L80:
                int r3 = r3 - r4
                r6.h = r3
            L83:
                java.lang.CharSequence r2 = r6.d
                java.lang.CharSequence r0 = r2.subSequence(r0, r1)
                java.lang.String r0 = r0.toString()
                return r0
            L8e:
                java.lang.Object r0 = r6.c()
                java.lang.String r0 = (java.lang.String) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: r5.p.b.b():java.lang.String");
        }

        public abstract int f(int i);

        public abstract int g(int i);
    }

    public interface c {
        Iterator a(p pVar, CharSequence charSequence);
    }

    public p(c cVar) {
        this(cVar, false, r5.c.f(), Integer.MAX_VALUE);
    }

    public static /* synthetic */ r5.c a(p pVar) {
        return pVar.a;
    }

    public static /* synthetic */ boolean b(p pVar) {
        return pVar.b;
    }

    public static /* synthetic */ int c(p pVar) {
        return pVar.d;
    }

    public static p d(char c2) {
        return e(r5.c.d(c2));
    }

    public static p e(r5.c cVar) {
        m.k(cVar);
        return new p(new a(cVar));
    }

    public List f(CharSequence charSequence) {
        m.k(charSequence);
        Iterator g = g(charSequence);
        ArrayList arrayList = new ArrayList();
        while (g.hasNext()) {
            arrayList.add((String) g.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator g(CharSequence charSequence) {
        return this.c.a(this, charSequence);
    }

    public p(c cVar, boolean z, r5.c cVar2, int i) {
        this.c = cVar;
        this.b = z;
        this.a = cVar2;
        this.d = i;
    }
}
