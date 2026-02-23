package C0;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h implements G0.e, G0.d {
    public static final TreeMap j = new TreeMap();
    public volatile String a;
    public final long[] c;
    public final double[] d;
    public final String[] e;
    public final byte[][] f;
    public final int[] g;
    public final int h;
    public int i;

    public h(int i) {
        this.h = i;
        int i2 = i + 1;
        this.g = new int[i2];
        this.c = new long[i2];
        this.d = new double[i2];
        this.e = new String[i2];
        this.f = new byte[i2][];
    }

    public static h d(String str, int i) {
        TreeMap treeMap = j;
        synchronized (treeMap) {
            try {
                Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
                if (ceilingEntry == null) {
                    h hVar = new h(i);
                    hVar.e(str, i);
                    return hVar;
                }
                treeMap.remove(ceilingEntry.getKey());
                h hVar2 = (h) ceilingEntry.getValue();
                hVar2.e(str, i);
                return hVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void g() {
        TreeMap treeMap = j;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i;
        }
    }

    public void A(int i, long j2) {
        this.g[i] = 2;
        this.c[i] = j2;
    }

    public void S(int i, byte[] bArr) {
        this.g[i] = 5;
        this.f[i] = bArr;
    }

    public void X(int i) {
        this.g[i] = 1;
    }

    public String a() {
        return this.a;
    }

    public void c(G0.d dVar) {
        for (int i = 1; i <= this.i; i++) {
            int i2 = this.g[i];
            if (i2 == 1) {
                dVar.X(i);
            } else if (i2 == 2) {
                dVar.A(i, this.c[i]);
            } else if (i2 == 3) {
                dVar.f(i, this.d[i]);
            } else if (i2 == 4) {
                dVar.x(i, this.e[i]);
            } else if (i2 == 5) {
                dVar.S(i, this.f[i]);
            }
        }
    }

    public void e(String str, int i) {
        this.a = str;
        this.i = i;
    }

    public void f(int i, double d) {
        this.g[i] = 3;
        this.d[i] = d;
    }

    public void h() {
        TreeMap treeMap = j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.h), this);
            g();
        }
    }

    public void x(int i, String str) {
        this.g[i] = 4;
        this.e[i] = str;
    }

    public void close() {
    }
}
