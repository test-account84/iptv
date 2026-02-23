package G;

import android.graphics.Insets;
import android.graphics.Rect;
import k.I;
import k.J;
import k.K;
import k.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b {
    public static final b e = new b(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public static class a {
        public static Insets a(int i, int i2, int i3, int i4) {
            return Insets.of(i, i2, i3, i4);
        }
    }

    public b(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.a, bVar2.a), Math.max(bVar.b, bVar2.b), Math.max(bVar.c, bVar2.c), Math.max(bVar.d, bVar2.d));
    }

    public static b b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new b(i, i2, i3, i4);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(I.a(insets), J.a(insets), K.a(insets), L.a(insets));
    }

    public Insets e() {
        return a.a(this.a, this.b, this.c, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.d == bVar.d && this.a == bVar.a && this.c == bVar.c && this.b == bVar.b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        return "Insets{left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + '}';
    }
}
