package R6;

import x6.k;
import x6.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c {
    public final D6.b a;
    public final q b;
    public final q c;
    public final q d;
    public final q e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public c(D6.b bVar, q qVar, q qVar2, q qVar3, q qVar4) {
        boolean z = qVar == null || qVar2 == null;
        boolean z2 = qVar3 == null || qVar4 == null;
        if (z && z2) {
            throw k.a();
        }
        if (z) {
            qVar = new q(0.0f, qVar3.d());
            qVar2 = new q(0.0f, qVar4.d());
        } else if (z2) {
            qVar3 = new q(bVar.l() - 1, qVar.d());
            qVar4 = new q(bVar.l() - 1, qVar2.d());
        }
        this.a = bVar;
        this.b = qVar;
        this.c = qVar2;
        this.d = qVar3;
        this.e = qVar4;
        this.f = (int) Math.min(qVar.c(), qVar2.c());
        this.g = (int) Math.max(qVar3.c(), qVar4.c());
        this.h = (int) Math.min(qVar.d(), qVar3.d());
        this.i = (int) Math.max(qVar2.d(), qVar4.d());
    }

    public static c j(c cVar, c cVar2) {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.a, cVar.b, cVar.c, cVar2.d, cVar2.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public R6.c a(int r13, int r14, boolean r15) {
        /*
            r12 = this;
            x6.q r0 = r12.b
            x6.q r1 = r12.c
            x6.q r2 = r12.d
            x6.q r3 = r12.e
            if (r13 <= 0) goto L2a
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            x6.q r13 = new x6.q
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L27
            r8 = r13
        L25:
            r10 = r2
            goto L2c
        L27:
            r10 = r13
            r8 = r0
            goto L2c
        L2a:
            r8 = r0
            goto L25
        L2c:
            if (r14 <= 0) goto L5d
            if (r15 == 0) goto L33
            x6.q r13 = r12.c
            goto L35
        L33:
            x6.q r13 = r12.e
        L35:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            D6.b r14 = r12.a
            int r14 = r14.i()
            if (r0 < r14) goto L4b
            D6.b r14 = r12.a
            int r14 = r14.i()
            int r0 = r14 + (-1)
        L4b:
            x6.q r14 = new x6.q
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L5a
            r9 = r14
        L58:
            r11 = r3
            goto L5f
        L5a:
            r11 = r14
            r9 = r1
            goto L5f
        L5d:
            r9 = r1
            goto L58
        L5f:
            R6.c r13 = new R6.c
            D6.b r7 = r12.a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.c.a(int, int, boolean):R6.c");
    }

    public q b() {
        return this.c;
    }

    public q c() {
        return this.e;
    }

    public int d() {
        return this.g;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.h;
    }

    public q h() {
        return this.b;
    }

    public q i() {
        return this.d;
    }

    public c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
    }
}
