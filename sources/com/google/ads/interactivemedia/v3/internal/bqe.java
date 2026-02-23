package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bqe {
    private static final bqe b = new bqe(null);
    final bst a = bst.c(16);
    private boolean c;
    private boolean d;

    private bqe() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(com.google.ads.interactivemedia.v3.internal.btk r2, int r3, java.lang.Object r4) {
        /*
            int r3 = com.google.ads.interactivemedia.v3.internal.bpk.Q(r3)
            com.google.ads.interactivemedia.v3.internal.btk r0 = com.google.ads.interactivemedia.v3.internal.btk.j
            if (r2 != r0) goto Lf
            r0 = r4
            com.google.ads.interactivemedia.v3.internal.brs r0 = (com.google.ads.interactivemedia.v3.internal.brs) r0
            com.google.ads.interactivemedia.v3.internal.bqu.g(r0)
            int r3 = r3 + r3
        Lf:
            com.google.ads.interactivemedia.v3.internal.btl r0 = com.google.ads.interactivemedia.v3.internal.btl.a
            int r2 = r2.ordinal()
            r0 = 4
            r1 = 8
            switch(r2) {
                case 0: goto Lbc;
                case 1: goto Lb6;
                case 2: goto Lab;
                case 3: goto Lab;
                case 4: goto L5b;
                case 5: goto L3b;
                case 6: goto L44;
                case 7: goto La4;
                case 8: goto L98;
                case 9: goto L91;
                case 10: goto L7f;
                case 11: goto L6d;
                case 12: goto L62;
                case 13: goto L4b;
                case 14: goto L44;
                case 15: goto L3b;
                case 16: goto L2f;
                case 17: goto L23;
                default: goto L1b;
            }
        L1b:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "There is no way to get here, but the compiler thinks otherwise."
            r2.<init>(r3)
            throw r2
        L23:
            java.lang.Long r4 = (java.lang.Long) r4
            long r0 = r4.longValue()
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.N(r0)
            goto Lc3
        L2f:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r2 = r4.intValue()
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.L(r2)
            goto Lc3
        L3b:
            java.lang.Long r4 = (java.lang.Long) r4
            r4.longValue()
        L40:
            r0 = 8
            goto Lc3
        L44:
            java.lang.Integer r4 = (java.lang.Integer) r4
            r4.intValue()
            goto Lc3
        L4b:
            boolean r2 = r4 instanceof com.google.ads.interactivemedia.v3.internal.bqp
            if (r2 == 0) goto L5b
            com.google.ads.interactivemedia.v3.internal.bqp r4 = (com.google.ads.interactivemedia.v3.internal.bqp) r4
            int r2 = r4.getNumber()
        L55:
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.D(r2)
            goto Lc3
        L5b:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r2 = r4.intValue()
            goto L55
        L62:
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r2 = r4.intValue()
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.S(r2)
            goto Lc3
        L6d:
            boolean r2 = r4 instanceof com.google.ads.interactivemedia.v3.internal.bpb
            if (r2 == 0) goto L78
        L71:
            com.google.ads.interactivemedia.v3.internal.bpb r4 = (com.google.ads.interactivemedia.v3.internal.bpb) r4
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.y(r4)
            goto Lc3
        L78:
            byte[] r4 = (byte[]) r4
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.w(r4)
            goto Lc3
        L7f:
            boolean r2 = r4 instanceof com.google.ads.interactivemedia.v3.internal.brb
            if (r2 == 0) goto L8a
            com.google.ads.interactivemedia.v3.internal.brb r4 = (com.google.ads.interactivemedia.v3.internal.brb) r4
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.G(r4)
            goto Lc3
        L8a:
            com.google.ads.interactivemedia.v3.internal.brs r4 = (com.google.ads.interactivemedia.v3.internal.brs) r4
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.I(r4)
            goto Lc3
        L91:
            com.google.ads.interactivemedia.v3.internal.brs r4 = (com.google.ads.interactivemedia.v3.internal.brs) r4
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.B(r4)
            goto Lc3
        L98:
            boolean r2 = r4 instanceof com.google.ads.interactivemedia.v3.internal.bpb
            if (r2 == 0) goto L9d
            goto L71
        L9d:
            java.lang.String r4 = (java.lang.String) r4
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.P(r4)
            goto Lc3
        La4:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            r4.booleanValue()
            r0 = 1
            goto Lc3
        Lab:
            java.lang.Long r4 = (java.lang.Long) r4
            long r0 = r4.longValue()
            int r0 = com.google.ads.interactivemedia.v3.internal.bpk.U(r0)
            goto Lc3
        Lb6:
            java.lang.Float r4 = (java.lang.Float) r4
            r4.floatValue()
            goto Lc3
        Lbc:
            java.lang.Double r4 = (java.lang.Double) r4
            r4.doubleValue()
            goto L40
        Lc3:
            int r3 = r3 + r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.bqe.a(com.google.ads.interactivemedia.v3.internal.btk, int, java.lang.Object):int");
    }

    public static int b(bqd bqdVar, Object obj) {
        btk c = bqdVar.c();
        int a = bqdVar.a();
        if (!bqdVar.e()) {
            return a(c, a, obj);
        }
        bqdVar.g();
        Iterator it = ((List) obj).iterator();
        int i = 0;
        while (it.hasNext()) {
            i += a(c, a, it.next());
        }
        return i;
    }

    public static bqe e() {
        return b;
    }

    public static void o(bpk bpkVar, int i, Object obj) throws IOException {
        if (btk.j != null) {
            throw null;
        }
        brs brsVar = (brs) obj;
        bqu.g(brsVar);
        bpkVar.ax(i, 3);
        bpkVar.ac(brsVar);
        bpkVar.ax(i, 4);
    }

    private static Object p(Object obj) {
        if (obj instanceof brx) {
            return ((brx) obj).c();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void q(Map.Entry entry) {
        brs aY;
        bqd bqdVar = (bqd) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof brb) {
            throw null;
        }
        if (bqdVar.e()) {
            Object f = f(bqdVar);
            if (f == null) {
                f = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) f).add(p(it.next()));
            }
            this.a.e(bqdVar, f);
            return;
        }
        if (bqdVar.d() != btl.i) {
            this.a.e(bqdVar, p(value));
            return;
        }
        Object f2 = f(bqdVar);
        if (f2 == null) {
            this.a.e(bqdVar, p(value));
            return;
        }
        if (f2 instanceof brx) {
            aY = bqdVar.f();
        } else {
            aY = bqdVar.b(((brs) f2).bq(), (brs) value).aY();
        }
        this.a.e(bqdVar, aY);
    }

    private static boolean r(Map.Entry entry) {
        bqd bqdVar = (bqd) entry.getKey();
        if (bqdVar.d() != btl.i) {
            return true;
        }
        boolean e = bqdVar.e();
        Object value = entry.getValue();
        if (!e) {
            return s(value);
        }
        Iterator it = ((List) value).iterator();
        while (it.hasNext()) {
            if (!s(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean s(Object obj) {
        if (obj instanceof brt) {
            return ((brt) obj).bd();
        }
        if (obj instanceof brb) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int t(Map.Entry entry) {
        int R;
        int Q;
        bqd bqdVar = (bqd) entry.getKey();
        Object value = entry.getValue();
        if (bqdVar.d() != btl.i || bqdVar.e()) {
            return b(bqdVar, value);
        }
        bqdVar.g();
        boolean z = value instanceof brb;
        int a = ((bqd) entry.getKey()).a();
        if (z) {
            int Q2 = bpk.Q(1);
            R = Q2 + Q2 + bpk.R(2, a);
            Q = bpk.F(3, (brb) value);
        } else {
            int Q3 = bpk.Q(1);
            R = Q3 + Q3 + bpk.R(2, a);
            Q = bpk.Q(3) + bpk.I((brs) value);
        }
        return R + Q;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void u(com.google.ads.interactivemedia.v3.internal.bqd r4, java.lang.Object r5) {
        /*
            com.google.ads.interactivemedia.v3.internal.btk r0 = r4.c()
            com.google.ads.interactivemedia.v3.internal.bqu.i(r5)
            com.google.ads.interactivemedia.v3.internal.btk r1 = com.google.ads.interactivemedia.v3.internal.btk.a
            com.google.ads.interactivemedia.v3.internal.btl r1 = com.google.ads.interactivemedia.v3.internal.btl.a
            com.google.ads.interactivemedia.v3.internal.btl r0 = r0.a()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r5 instanceof com.google.ads.interactivemedia.v3.internal.brs
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.ads.interactivemedia.v3.internal.brb
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.ads.interactivemedia.v3.internal.bqp
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r5 instanceof com.google.ads.interactivemedia.v3.internal.bpb
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r5 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r5 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r5 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r5 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r5 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r4.a()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.ads.interactivemedia.v3.internal.btk r4 = r4.c()
            com.google.ads.interactivemedia.v3.internal.btl r4 = r4.a()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 1
            r2[r1] = r4
            r4 = 2
            r2[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r2)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.bqe.u(com.google.ads.interactivemedia.v3.internal.bqd, java.lang.Object):void");
    }

    public final int c() {
        int i = 0;
        for (int i2 = 0; i2 < this.a.b(); i2++) {
            i += t(this.a.g(i2));
        }
        Iterator it = this.a.d().iterator();
        while (it.hasNext()) {
            i += t((Map.Entry) it.next());
        }
        return i;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final bqe clone() {
        bqe bqeVar = new bqe();
        for (int i = 0; i < this.a.b(); i++) {
            Map.Entry g = this.a.g(i);
            bqeVar.k((bqd) g.getKey(), g.getValue());
        }
        for (Map.Entry entry : this.a.d()) {
            bqeVar.k((bqd) entry.getKey(), entry.getValue());
        }
        bqeVar.d = this.d;
        return bqeVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bqe) {
            return this.a.equals(((bqe) obj).a);
        }
        return false;
    }

    public final Object f(bqd bqdVar) {
        Object obj = this.a.get(bqdVar);
        if (obj instanceof brb) {
            throw null;
        }
        return obj;
    }

    public final Iterator g() {
        return this.d ? new bra(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public final void h(bqd bqdVar, Object obj) {
        ArrayList arrayList;
        if (!((bqm) bqdVar).d) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        u(bqdVar, obj);
        Object f = f(bqdVar);
        if (f == null) {
            arrayList = new ArrayList();
            this.a.e(bqdVar, arrayList);
        } else {
            arrayList = (List) f;
        }
        arrayList.add(obj);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final void i() {
        if (this.c) {
            return;
        }
        for (int i = 0; i < this.a.b(); i++) {
            Map.Entry g = this.a.g(i);
            if (g.getValue() instanceof bqn) {
                ((bqn) g.getValue()).aJ();
            }
        }
        this.a.a();
        this.c = true;
    }

    public final void j(bqe bqeVar) {
        for (int i = 0; i < bqeVar.a.b(); i++) {
            q(bqeVar.a.g(i));
        }
        Iterator it = bqeVar.a.d().iterator();
        while (it.hasNext()) {
            q((Map.Entry) it.next());
        }
    }

    public final void k(bqd bqdVar, Object obj) {
        if (!bqdVar.e()) {
            u(bqdVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                u(bqdVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof brb) {
            this.d = true;
        }
        this.a.e(bqdVar, obj);
    }

    public final boolean l() {
        return this.a.isEmpty();
    }

    public final boolean m() {
        return this.c;
    }

    public final boolean n() {
        for (int i = 0; i < this.a.b(); i++) {
            if (!r(this.a.g(i))) {
                return false;
            }
        }
        Iterator it = this.a.d().iterator();
        while (it.hasNext()) {
            if (!r((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private bqe(byte[] bArr) {
        i();
        i();
    }
}
