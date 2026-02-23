package J8;

import java.util.Arrays;
import k8.j;
import k8.q;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class b {
    public d[] a;
    public int c;
    public int d;

    public final d c() {
        d dVar;
        synchronized (this) {
            try {
                d[] dVarArr = this.a;
                if (dVarArr == null) {
                    dVarArr = e(2);
                    this.a = dVarArr;
                } else if (this.c >= dVarArr.length) {
                    Object[] copyOf = Arrays.copyOf(dVarArr, dVarArr.length * 2);
                    l.d(copyOf, "copyOf(this, newSize)");
                    this.a = (d[]) copyOf;
                    dVarArr = (d[]) copyOf;
                }
                int i = this.d;
                do {
                    dVar = dVarArr[i];
                    if (dVar == null) {
                        dVar = d();
                        dVarArr[i] = dVar;
                    }
                    i++;
                    if (i >= dVarArr.length) {
                        i = 0;
                    }
                } while (!dVar.a(this));
                this.d = i;
                this.c++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public abstract d d();

    public abstract d[] e(int i);

    public final void f(d dVar) {
        int i;
        o8.d[] b;
        synchronized (this) {
            try {
                int i2 = this.c - 1;
                this.c = i2;
                if (i2 == 0) {
                    this.d = 0;
                }
                b = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (o8.d dVar2 : b) {
            if (dVar2 != null) {
                j.a aVar = k8.j.c;
                dVar2.resumeWith(k8.j.b(q.a));
            }
        }
    }

    public final d[] g() {
        return this.a;
    }
}
