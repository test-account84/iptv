package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class pa implements td, pg, qm {
    private final ox a;
    private final qq b;
    private final dw c;
    private final nt d;
    private final nn e;
    private final tj f;
    private final iw j;
    private tc k;
    private int l;
    private um m;
    private int p;
    private final wr r;
    private final oq t;
    private final ws u;
    private final ws v;
    private final boolean h = true;
    private final int i = 1;
    private uh q = ws.f(new uh[0]);
    private final IdentityHashMap g = new IdentityHashMap();
    private final vk s = new vk((byte[]) null);
    private pk[] n = new pk[0];
    private pk[] o = new pk[0];

    public pa(ox oxVar, qq qqVar, oq oqVar, dw dwVar, nt ntVar, nn nnVar, ws wsVar, tj tjVar, wr wrVar, ws wsVar2, boolean z, int i, iw iwVar, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.a = oxVar;
        this.b = qqVar;
        this.t = oqVar;
        this.c = dwVar;
        this.d = ntVar;
        this.e = nnVar;
        this.u = wsVar;
        this.f = tjVar;
        this.r = wrVar;
        this.v = wsVar2;
        this.j = iwVar;
    }

    private static s t(s sVar, s sVar2, boolean z) {
        String K;
        ao aoVar;
        String str;
        int i;
        String str2;
        int i2;
        int i3;
        if (sVar2 != null) {
            K = sVar2.i;
            aoVar = sVar2.j;
            i2 = sVar2.y;
            i = sVar2.d;
            i3 = sVar2.e;
            str = sVar2.c;
            str2 = sVar2.b;
        } else {
            K = cq.K(sVar.i, 1);
            aoVar = sVar.j;
            if (z) {
                i2 = sVar.y;
                i = sVar.d;
                i3 = sVar.e;
                str = sVar.c;
                str2 = sVar.b;
            } else {
                str = null;
                i = 0;
                str2 = null;
                i2 = -1;
                i3 = 0;
            }
        }
        String g = ar.g(K);
        int i4 = z ? sVar.f : -1;
        int i5 = z ? sVar.g : -1;
        r rVar = new r();
        rVar.S(sVar.a);
        rVar.U(str2);
        rVar.K(sVar.k);
        rVar.ae(g);
        rVar.I(K);
        rVar.X(aoVar);
        rVar.G(i4);
        rVar.Z(i5);
        rVar.H(i2);
        rVar.ag(i);
        rVar.ac(i3);
        rVar.V(str);
        return rVar.v();
    }

    private final pk u(String str, int i, Uri[] uriArr, s[] sVarArr, s sVar, List list, Map map, long j) {
        return new pk(str, i, this, new ow(this.a, this.b, uriArr, sVarArr, this.t, this.c, this.s, list, this.j, null), map, this.r, j, sVar, this.d, this.e, this.u, this.f, 1, null, null, null);
    }

    public final long a(long j, hl hlVar) {
        for (pk pkVar : this.o) {
            if (pkVar.D()) {
                return pkVar.g(j, hlVar);
            }
        }
        return j;
    }

    public final void bm() throws IOException {
        for (pk pkVar : this.n) {
            pkVar.s();
        }
    }

    public final long bo() {
        return this.q.bo();
    }

    public final long c() {
        return this.q.c();
    }

    public final long d() {
        return -9223372036854775807L;
    }

    public final long e(long j) {
        pk[] pkVarArr = this.o;
        if (pkVarArr.length > 0) {
            boolean E = pkVarArr[0].E(j, false);
            int i = 1;
            while (true) {
                pk[] pkVarArr2 = this.o;
                if (i >= pkVarArr2.length) {
                    break;
                }
                pkVarArr2[i].E(j, E);
                i++;
            }
            if (E) {
                this.s.c();
            }
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long f(com.google.ads.interactivemedia.v3.internal.we[] r22, boolean[] r23, com.google.ads.interactivemedia.v3.internal.uf[] r24, boolean[] r25, long r26) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.pa.f(com.google.ads.interactivemedia.v3.internal.we[], boolean[], com.google.ads.interactivemedia.v3.internal.uf[], boolean[], long):long");
    }

    public final /* bridge */ /* synthetic */ void g(uh uhVar) {
        this.k.g(this);
    }

    public final um h() {
        um umVar = this.m;
        af.s(umVar);
        return umVar;
    }

    public final void j() {
        for (pk pkVar : this.n) {
            pkVar.v();
        }
        this.k.g(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00ed A[PHI: r1
      0x00ed: PHI (r1v27 int) = (r1v26 int), (r1v36 int) binds: [B:40:0x00d7, B:44:0x00e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9 A[PHI: r19
      0x00a9: PHI (r19v7 java.util.ArrayList) = (r19v5 java.util.ArrayList), (r19v8 java.util.ArrayList) binds: [B:34:0x00a6, B:28:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void k(com.google.ads.interactivemedia.v3.internal.tc r25, long r26) {
        /*
            Method dump skipped, instructions count: 1005
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.pa.k(com.google.ads.interactivemedia.v3.internal.tc, long):void");
    }

    public final void l(long j) {
        this.q.l(j);
    }

    public final void m(Uri uri) {
        this.b.t(uri);
    }

    public final void n() {
        int i = this.l - 1;
        this.l = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (pk pkVar : this.n) {
            i2 += pkVar.h().b;
        }
        bf[] bfVarArr = new bf[i2];
        int i3 = 0;
        for (pk pkVar2 : this.n) {
            int i4 = pkVar2.h().b;
            int i5 = 0;
            while (i5 < i4) {
                bfVarArr[i3] = pkVar2.h().b(i5);
                i5++;
                i3++;
            }
        }
        this.m = new um(bfVarArr);
        this.k.bl(this);
    }

    public final boolean o(long j) {
        if (this.m != null) {
            return this.q.o(j);
        }
        for (pk pkVar : this.n) {
            pkVar.m();
        }
        return false;
    }

    public final boolean p() {
        return this.q.p();
    }

    public final void q(long j) {
        for (pk pkVar : this.o) {
            pkVar.G(j);
        }
    }

    public final void r() {
        this.b.u(this);
        for (pk pkVar : this.n) {
            pkVar.w();
        }
        this.k = null;
    }

    public final boolean s(Uri uri, bdz bdzVar, boolean z) {
        boolean z2 = true;
        for (pk pkVar : this.n) {
            z2 &= pkVar.J(uri, bdzVar, z);
        }
        this.k.g(this);
        return z2;
    }
}
