package com.google.android.exoplayer2.source.smoothstreaming;

import B3.J;
import B3.Y;
import B3.Z;
import B3.g0;
import B3.i;
import B3.i0;
import B3.z;
import N3.a;
import O2.H1;
import O2.z0;
import V2.w;
import V2.y;
import Z3.s;
import b4.F;
import b4.H;
import b4.S;
import b4.h;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements z, Z.a {
    public final b.a a;
    public final S c;
    public final H d;
    public final y e;
    public final w.a f;
    public final F g;
    public final J.a h;
    public final b4.b i;
    public final i0 j;
    public final i k;
    public z.a l;
    public N3.a m;
    public D3.i[] n;
    public Z o;

    public c(N3.a aVar, b.a aVar2, S s, i iVar, h hVar, y yVar, w.a aVar3, F f, J.a aVar4, H h, b4.b bVar) {
        this.m = aVar;
        this.a = aVar2;
        this.c = s;
        this.d = h;
        this.e = yVar;
        this.f = aVar3;
        this.g = f;
        this.h = aVar4;
        this.i = bVar;
        this.k = iVar;
        this.j = o(aVar, yVar);
        D3.i[] q = q(0);
        this.n = q;
        this.o = iVar.a(q);
    }

    public static i0 o(N3.a aVar, y yVar) {
        g0[] g0VarArr = new g0[aVar.f.length];
        int i = 0;
        while (true) {
            a.b[] bVarArr = aVar.f;
            if (i >= bVarArr.length) {
                return new i0(g0VarArr);
            }
            z0[] z0VarArr = bVarArr[i].j;
            z0[] z0VarArr2 = new z0[z0VarArr.length];
            for (int i2 = 0; i2 < z0VarArr.length; i2++) {
                z0 z0Var = z0VarArr[i2];
                z0VarArr2[i2] = z0Var.c(yVar.a(z0Var));
            }
            g0VarArr[i] = new g0(Integer.toString(i), z0VarArr2);
            i++;
        }
    }

    private static D3.i[] q(int i) {
        return new D3.i[i];
    }

    public final D3.i a(s sVar, long j) {
        int c = this.j.c(sVar.k());
        return new D3.i(this.m.f[c].a, null, null, this.a.a(this.d, this.m, c, sVar, this.c, null), this, this.i, j, this.e, this.f, this.g, this.h);
    }

    public boolean b() {
        return this.o.b();
    }

    public long c() {
        return this.o.c();
    }

    public long d(long j, H1 h1) {
        for (D3.i iVar : this.n) {
            if (iVar.a == 2) {
                return iVar.d(j, h1);
            }
        }
        return j;
    }

    public boolean f(long j) {
        return this.o.f(j);
    }

    public long g() {
        return this.o.g();
    }

    public void h(long j) {
        this.o.h(j);
    }

    public long i(s[] sVarArr, boolean[] zArr, Y[] yArr, boolean[] zArr2, long j) {
        s sVar;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sVarArr.length; i++) {
            Y y = yArr[i];
            if (y != null) {
                D3.i iVar = (D3.i) y;
                if (sVarArr[i] == null || !zArr[i]) {
                    iVar.P();
                    yArr[i] = null;
                } else {
                    ((b) iVar.E()).b(sVarArr[i]);
                    arrayList.add(iVar);
                }
            }
            if (yArr[i] == null && (sVar = sVarArr[i]) != null) {
                D3.i a = a(sVar, j);
                arrayList.add(a);
                yArr[i] = a;
                zArr2[i] = true;
            }
        }
        D3.i[] q = q(arrayList.size());
        this.n = q;
        arrayList.toArray(q);
        this.o = this.k.a(this.n);
        return j;
    }

    public List k(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            s sVar = (s) list.get(i);
            int c = this.j.c(sVar.k());
            for (int i2 = 0; i2 < sVar.length(); i2++) {
                arrayList.add(new z3.H(c, sVar.d(i2)));
            }
        }
        return arrayList;
    }

    public long l(long j) {
        for (D3.i iVar : this.n) {
            iVar.S(j);
        }
        return j;
    }

    public long m() {
        return -9223372036854775807L;
    }

    public void p() {
        this.d.a();
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void j(D3.i iVar) {
        this.l.j(this);
    }

    public void s(z.a aVar, long j) {
        this.l = aVar;
        aVar.e(this);
    }

    public void t() {
        for (D3.i iVar : this.n) {
            iVar.P();
        }
        this.l = null;
    }

    public i0 u() {
        return this.j;
    }

    public void v(long j, boolean z) {
        for (D3.i iVar : this.n) {
            iVar.v(j, z);
        }
    }

    public void w(N3.a aVar) {
        this.m = aVar;
        for (D3.i iVar : this.n) {
            ((b) iVar.E()).f(aVar);
        }
        this.l.j(this);
    }
}
