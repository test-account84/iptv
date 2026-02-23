package j$.util.stream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class r2 extends m2 {
    long b;
    long c;
    final /* synthetic */ s2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    r2(s2 s2Var, q2 q2Var) {
        super(q2Var);
        this.d = s2Var;
        this.b = s2Var.m;
        long j = s2Var.n;
        this.c = j < 0 ? Long.MAX_VALUE : j;
    }

    public final void accept(Object obj) {
        long j = this.b;
        if (j != 0) {
            this.b = j - 1;
            return;
        }
        long j2 = this.c;
        if (j2 > 0) {
            this.c = j2 - 1;
            this.a.accept(obj);
        }
    }

    public final void m(long j) {
        this.a.m(y0.A(j, this.d.m, this.c));
    }

    public final boolean o() {
        return this.c == 0 || this.a.o();
    }
}
