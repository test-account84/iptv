package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bpl implements btn {
    private final bpk a;

    private bpl(bpk bpkVar) {
        bqu.j(bpkVar, "output");
        this.a = bpkVar;
        bpkVar.a = this;
    }

    public static bpl a(bpk bpkVar) {
        bpl bplVar = bpkVar.a;
        return bplVar != null ? bplVar : new bpl(bpkVar);
    }

    public final void A(int i, long j) throws IOException {
        this.a.an(i, j);
    }

    public final void B(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.an(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.ao(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void C(int i, int i2) throws IOException {
        this.a.ad(i, i2);
    }

    public final void D(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.ad(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bpk.L(((Integer) list.get(i4)).intValue());
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.az(bpk.V(((Integer) list.get(i2)).intValue()));
            i2++;
        }
    }

    public final void E(int i, long j) throws IOException {
        this.a.ae(i, j);
    }

    public final void F(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.ae(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bpk.N(((Long) list.get(i4)).longValue());
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.aB(bpk.W(((Long) list.get(i2)).longValue()));
            i2++;
        }
    }

    @Deprecated
    public final void G(int i) throws IOException {
        this.a.ax(i, 3);
    }

    public final void H(int i, String str) throws IOException {
        this.a.av(i, str);
    }

    public final void I(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof bre)) {
            while (i2 < list.size()) {
                this.a.av(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        bre breVar = (bre) list;
        while (i2 < list.size()) {
            Object f = breVar.f(i2);
            if (f instanceof String) {
                this.a.av(i, (String) f);
            } else {
                this.a.ak(i, (bpb) f);
            }
            i2++;
        }
    }

    public final void J(int i, int i2) throws IOException {
        this.a.ay(i, i2);
    }

    public final void K(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.ay(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bpk.S(((Integer) list.get(i4)).intValue());
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.az(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void L(int i, long j) throws IOException {
        this.a.aA(i, j);
    }

    public final void M(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.aA(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bpk.U(((Long) list.get(i4)).longValue());
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.aB(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void b(int i, boolean z) throws IOException {
        this.a.aj(i, z);
    }

    public final void c(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.aj(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.ah(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public final void d(int i, bpb bpbVar) throws IOException {
        this.a.ak(i, bpbVar);
    }

    public final void e(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.ak(i, (bpb) list.get(i2));
        }
    }

    public final void f(int i, double d) throws IOException {
        this.a.aa(i, d);
    }

    public final void g(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.aa(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.ao(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Deprecated
    public final void h(int i) throws IOException {
        this.a.ax(i, 4);
    }

    public final void i(int i, int i2) throws IOException {
        this.a.ap(i, i2);
    }

    public final void j(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.ap(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bpk.D(((Integer) list.get(i4)).intValue());
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.aq(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void k(int i, int i2) throws IOException {
        this.a.al(i, i2);
    }

    public final void l(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.al(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.am(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void m(int i, long j) throws IOException {
        this.a.an(i, j);
    }

    public final void n(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.an(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.ao(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void o(int i, float f) throws IOException {
        this.a.ab(i, f);
    }

    public final void p(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.ab(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.am(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public final void q(int i, Object obj, bsi bsiVar) throws IOException {
        bpk bpkVar = this.a;
        bpkVar.ax(i, 3);
        bsiVar.j((brs) obj, bpkVar.a);
        bpkVar.ax(i, 4);
    }

    public final void r(int i, int i2) throws IOException {
        this.a.ap(i, i2);
    }

    public final void s(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.ap(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bpk.D(((Integer) list.get(i4)).intValue());
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.aq(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void t(int i, long j) throws IOException {
        this.a.aA(i, j);
    }

    public final void u(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.aA(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bpk.U(((Long) list.get(i4)).longValue());
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.aB(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void v(int i, brm brmVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            this.a.ax(i, 2);
            this.a.az(bsr.j(brmVar, entry.getKey(), entry.getValue()));
            bsr.k(this.a, brmVar, entry.getKey(), entry.getValue());
        }
    }

    public final void w(int i, Object obj, bsi bsiVar) throws IOException {
        this.a.as(i, (brs) obj, bsiVar);
    }

    public final void x(int i, Object obj) throws IOException {
        if (obj instanceof bpb) {
            this.a.au(i, (bpb) obj);
        } else {
            this.a.at(i, (brs) obj);
        }
    }

    public final void y(int i, int i2) throws IOException {
        this.a.al(i, i2);
    }

    public final void z(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.al(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.ax(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.a.az(i3);
        while (i2 < list.size()) {
            this.a.am(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }
}
