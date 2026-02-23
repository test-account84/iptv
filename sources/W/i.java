package w;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i {
    public static int o = 1;
    public boolean a;
    public String b;
    public float f;
    public a j;
    public int c = -1;
    public int d = -1;
    public int e = 0;
    public boolean g = false;
    public float[] h = new float[9];
    public float[] i = new float[9];
    public b[] k = new b[16];
    public int l = 0;
    public int m = 0;
    public HashSet n = null;

    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.j = aVar;
    }

    public static void b() {
        o++;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.l;
            if (i >= i2) {
                b[] bVarArr = this.k;
                if (i2 >= bVarArr.length) {
                    this.k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.k;
                int i3 = this.l;
                bVarArr2[i3] = bVar;
                this.l = i3 + 1;
                return;
            }
            if (this.k[i] == bVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void c(b bVar) {
        int i = this.l;
        int i2 = 0;
        while (i2 < i) {
            if (this.k[i2] == bVar) {
                while (i2 < i - 1) {
                    b[] bVarArr = this.k;
                    int i3 = i2 + 1;
                    bVarArr[i2] = bVarArr[i3];
                    i2 = i3;
                }
                this.l--;
                return;
            }
            i2++;
        }
    }

    public void d() {
        this.b = null;
        this.j = a.UNKNOWN;
        this.e = 0;
        this.c = -1;
        this.d = -1;
        this.f = 0.0f;
        this.g = false;
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2] = null;
        }
        this.l = 0;
        this.m = 0;
        this.a = false;
        Arrays.fill(this.i, 0.0f);
    }

    public void e(d dVar, float f) {
        this.f = f;
        this.g = true;
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2].B(dVar, this, false);
        }
        this.l = 0;
    }

    public void f(a aVar, String str) {
        this.j = aVar;
    }

    public final void g(b bVar) {
        int i = this.l;
        for (int i2 = 0; i2 < i; i2++) {
            this.k[i2].C(bVar, false);
        }
        this.l = 0;
    }

    public String toString() {
        StringBuilder sb;
        if (this.b != null) {
            sb = new StringBuilder();
            sb.append("");
            sb.append(this.b);
        } else {
            sb = new StringBuilder();
            sb.append("");
            sb.append(this.c);
        }
        return sb.toString();
    }
}
