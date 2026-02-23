package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class bsr {
    public bsr() {
    }

    public static final Object a(Object obj) {
        return ((bqn) obj).aA();
    }

    public static final Map b(Object obj) {
        return (brn) obj;
    }

    public static final brm c(Object obj) {
        throw null;
    }

    public static final Map d(Object obj) {
        return (brn) obj;
    }

    public static final int e(Object obj, Object obj2) {
        brn brnVar = (brn) obj;
        if (brnVar.isEmpty()) {
            return 0;
        }
        Iterator it = brnVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final boolean f(Object obj) {
        return !((brn) obj).e();
    }

    public static final Object g(Object obj, Object obj2) {
        brn brnVar = (brn) obj;
        brn brnVar2 = (brn) obj2;
        if (!brnVar2.isEmpty()) {
            if (!brnVar.e()) {
                brnVar = brnVar.b();
            }
            brnVar.d(brnVar2);
        }
        return brnVar;
    }

    public static final Object h() {
        return brn.a().b();
    }

    public static final void i(Object obj) {
        ((brn) obj).c();
    }

    public static int j(brm brmVar, Object obj, Object obj2) {
        btk btkVar = brmVar.a;
        return bqe.a(null, 1, obj) + bqe.a(null, 2, obj2);
    }

    public static void k(bpk bpkVar, brm brmVar, Object obj, Object obj2) throws IOException {
        btk btkVar = brmVar.a;
        bqe.o(bpkVar, 1, obj);
        bqe.o(bpkVar, 2, obj2);
    }

    public static int m(Map.Entry entry) {
        return ((bqm) entry.getKey()).b;
    }

    public static Object n(bqb bqbVar, brs brsVar, int i) {
        return bqbVar.c(brsVar, i);
    }

    public static bqe o(Object obj) {
        return ((bql) obj).a;
    }

    public static bqe p(Object obj) {
        return ((bql) obj).f();
    }

    public static boolean q(brs brsVar) {
        return brsVar instanceof bql;
    }

    public static void r(bsd bsdVar, Object obj, bqb bqbVar, bqe bqeVar) throws IOException {
        bpz bpzVar = (bpz) obj;
        bqeVar.k(bpzVar.b, bsdVar.s(bpzVar.a.getClass(), bqbVar));
    }

    public static void s(bpb bpbVar, Object obj, bqb bqbVar, bqe bqeVar) throws IOException {
        bpz bpzVar = (bpz) obj;
        brr bp = bpzVar.a.bp();
        bpg l = bpbVar.l();
        bp.aT(l, bqbVar);
        bqeVar.k(bpzVar.b, bp.aZ());
        l.z(0);
    }

    public static void t(btn btnVar, Map.Entry entry) throws IOException {
        bqm bqmVar = (bqm) entry.getKey();
        if (!bqmVar.d) {
            btk btkVar = btk.a;
            switch (bqmVar.c.ordinal()) {
                case 0:
                    btnVar.f(bqmVar.b, ((Double) entry.getValue()).doubleValue());
                    break;
                case 1:
                    btnVar.o(bqmVar.b, ((Float) entry.getValue()).floatValue());
                    break;
                case 2:
                    btnVar.t(bqmVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case 3:
                    btnVar.L(bqmVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    btnVar.r(bqmVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 5:
                    btnVar.m(bqmVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case 6:
                    btnVar.k(bqmVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 7:
                    btnVar.b(bqmVar.b, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 8:
                    btnVar.H(bqmVar.b, (String) entry.getValue());
                    break;
                case 9:
                    btnVar.q(bqmVar.b, entry.getValue(), bsa.a().b(entry.getValue().getClass()));
                    break;
                case 10:
                    btnVar.w(bqmVar.b, entry.getValue(), bsa.a().b(entry.getValue().getClass()));
                    break;
                case 11:
                    btnVar.d(bqmVar.b, (bpb) entry.getValue());
                    break;
                case 12:
                    btnVar.J(bqmVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    btnVar.r(bqmVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 14:
                    btnVar.y(bqmVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    btnVar.A(bqmVar.b, ((Long) entry.getValue()).longValue());
                    break;
                case 16:
                    btnVar.C(bqmVar.b, ((Integer) entry.getValue()).intValue());
                    break;
                case 17:
                    btnVar.E(bqmVar.b, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        btk btkVar2 = btk.a;
        switch (bqmVar.c.ordinal()) {
            case 0:
                bsk.s(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 1:
                bsk.w(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 2:
                bsk.z(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 3:
                bsk.H(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 4:
                bsk.y(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 5:
                bsk.v(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 6:
                bsk.u(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 7:
                bsk.q(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 8:
                bsk.F(bqmVar.b, (List) entry.getValue(), btnVar);
                break;
            case 9:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    bsk.x(bqmVar.b, (List) entry.getValue(), btnVar, bsa.a().b(list.get(0).getClass()));
                    break;
                }
                break;
            case 10:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    bsk.A(bqmVar.b, (List) entry.getValue(), btnVar, bsa.a().b(list2.get(0).getClass()));
                    break;
                }
                break;
            case 11:
                bsk.r(bqmVar.b, (List) entry.getValue(), btnVar);
                break;
            case 12:
                bsk.G(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 13:
                bsk.y(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 14:
                bsk.B(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 15:
                bsk.C(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 16:
                bsk.D(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
            case 17:
                bsk.E(bqmVar.b, (List) entry.getValue(), btnVar, false);
                break;
        }
    }

    public static Object u(Object obj, bsd bsdVar, Object obj2, bqb bqbVar, bqe bqeVar, Object obj3, bto btoVar) throws IOException {
        Object valueOf;
        long l;
        int g;
        Object f;
        bpz bpzVar = (bpz) obj2;
        int i = bpzVar.b.b;
        if (bpzVar.a() != btk.n) {
            switch (bpzVar.a().ordinal()) {
                case 0:
                    valueOf = Double.valueOf(bsdVar.a());
                    break;
                case 1:
                    valueOf = Float.valueOf(bsdVar.b());
                    break;
                case 2:
                    l = bsdVar.l();
                    valueOf = Long.valueOf(l);
                    break;
                case 3:
                    l = bsdVar.o();
                    valueOf = Long.valueOf(l);
                    break;
                case 4:
                    g = bsdVar.g();
                    valueOf = Integer.valueOf(g);
                    break;
                case 5:
                    l = bsdVar.k();
                    valueOf = Long.valueOf(l);
                    break;
                case 6:
                    g = bsdVar.f();
                    valueOf = Integer.valueOf(g);
                    break;
                case 7:
                    valueOf = Boolean.valueOf(bsdVar.P());
                    break;
                case 8:
                    valueOf = bsdVar.t();
                    break;
                case 9:
                    if (!bpzVar.b()) {
                        Object f2 = bqeVar.f(bpzVar.b);
                        if (f2 instanceof bqn) {
                            bsi c = bsa.a().c(f2);
                            if (!((bqn) f2).aO()) {
                                Object e = c.e();
                                c.g(e, f2);
                                bqeVar.k(bpzVar.b, e);
                                f2 = e;
                            }
                            bsdVar.v(f2, c, bqbVar);
                            return obj3;
                        }
                    }
                    valueOf = bsdVar.r(bpzVar.a.getClass(), bqbVar);
                    break;
                case 10:
                    if (!bpzVar.b()) {
                        Object f3 = bqeVar.f(bpzVar.b);
                        if (f3 instanceof bqn) {
                            bsi c2 = bsa.a().c(f3);
                            if (!((bqn) f3).aO()) {
                                Object e2 = c2.e();
                                c2.g(e2, f3);
                                bqeVar.k(bpzVar.b, e2);
                                f3 = e2;
                            }
                            bsdVar.w(f3, c2, bqbVar);
                            return obj3;
                        }
                    }
                    valueOf = bsdVar.s(bpzVar.a.getClass(), bqbVar);
                    break;
                case 11:
                    valueOf = bsdVar.p();
                    break;
                case 12:
                    g = bsdVar.j();
                    valueOf = Integer.valueOf(g);
                    break;
                case 13:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 14:
                    g = bsdVar.h();
                    valueOf = Integer.valueOf(g);
                    break;
                case 15:
                    l = bsdVar.m();
                    valueOf = Long.valueOf(l);
                    break;
                case 16:
                    g = bsdVar.i();
                    valueOf = Integer.valueOf(g);
                    break;
                case 17:
                    l = bsdVar.n();
                    valueOf = Long.valueOf(l);
                    break;
                default:
                    valueOf = null;
                    break;
            }
        } else {
            int g2 = bsdVar.g();
            if (bpzVar.b.a.a(g2) == null) {
                return bsk.X(obj, i, g2, obj3, btoVar);
            }
            valueOf = Integer.valueOf(g2);
        }
        if (bpzVar.b()) {
            bqeVar.h(bpzVar.b, valueOf);
        } else {
            int ordinal = bpzVar.a().ordinal();
            if ((ordinal == 9 || ordinal == 10) && (f = bqeVar.f(bpzVar.b)) != null) {
                valueOf = bqu.e(f, valueOf);
            }
            bqeVar.k(bpzVar.b, valueOf);
        }
        return obj3;
    }

    public final void l(Object obj) {
        o(obj).i();
    }

    public bsr(byte[] bArr) {
        this();
    }
}
