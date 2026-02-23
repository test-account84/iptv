package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class m extends m2 {
    public final /* synthetic */ int b = 2;
    boolean c;
    Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(O3 o3, q2 q2Var) {
        super(q2Var);
        this.d = o3;
        this.c = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(f2 f2Var, q2 q2Var) {
        super(q2Var);
        this.d = f2Var;
    }

    public /* synthetic */ m(q2 q2Var) {
        super(q2Var);
    }

    public final void accept(Object obj) {
        switch (this.b) {
            case 0:
                q2 q2Var = this.a;
                if (obj != null) {
                    Object obj2 = this.d;
                    if (obj2 != null && obj.equals(obj2)) {
                        return;
                    }
                } else {
                    if (this.c) {
                        return;
                    }
                    this.c = true;
                    obj = null;
                }
                this.d = obj;
                q2Var.accept(obj);
                return;
            case 1:
                Stream stream = (Stream) ((f2) this.d).n.apply(obj);
                if (stream != null) {
                    try {
                        boolean z = this.c;
                        q2 q2Var2 = this.a;
                        if (z) {
                            Spliterator spliterator = ((Stream) stream.sequential()).spliterator();
                            while (!q2Var2.o() && spliterator.tryAdvance(q2Var2)) {
                            }
                        } else {
                            ((Stream) stream.sequential()).forEach(q2Var2);
                        }
                    } catch (Throwable th) {
                        try {
                            stream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (stream != null) {
                    stream.close();
                    return;
                }
                return;
            default:
                if (this.c) {
                    boolean test = ((O3) this.d).m.test(obj);
                    this.c = test;
                    if (test) {
                        this.a.accept(obj);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public void l() {
        switch (this.b) {
            case 0:
                this.c = false;
                this.d = null;
                this.a.l();
                break;
            default:
                super.l();
                break;
        }
    }

    public final void m(long j) {
        switch (this.b) {
            case 0:
                this.c = false;
                this.d = null;
                this.a.m(-1L);
                break;
            case 1:
                this.a.m(-1L);
                break;
            default:
                this.a.m(-1L);
                break;
        }
    }

    public boolean o() {
        switch (this.b) {
            case 1:
                this.c = true;
                return this.a.o();
            case 2:
                return !this.c || this.a.o();
            default:
                return super.o();
        }
    }
}
