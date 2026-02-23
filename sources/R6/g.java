package R6;

import java.util.Formatter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g {
    public final c a;
    public final d[] b;

    public g(c cVar) {
        this.a = new c(cVar);
        this.b = new d[(cVar.e() - cVar.g()) + 1];
    }

    public final c a() {
        return this.a;
    }

    public final d b(int i) {
        return this.b[e(i)];
    }

    public final d c(int i) {
        d dVar;
        d dVar2;
        d b = b(i);
        if (b != null) {
            return b;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int e = e(i) - i2;
            if (e >= 0 && (dVar2 = this.b[e]) != null) {
                return dVar2;
            }
            int e2 = e(i) + i2;
            d[] dVarArr = this.b;
            if (e2 < dVarArr.length && (dVar = dVarArr[e2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    public final d[] d() {
        return this.b;
    }

    public final int e(int i) {
        return i - this.a.g();
    }

    public final void f(int i, d dVar) {
        this.b[e(i)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (d dVar : this.b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", new Object[]{Integer.valueOf(i)});
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", new Object[]{Integer.valueOf(i), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e())});
                    i++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
