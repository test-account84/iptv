package Y6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class v implements Comparable {
    public final int a;
    public final int c;

    public v(int i, int i2) {
        this.a = i;
        this.c = i2;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(v vVar) {
        int i = this.c * this.a;
        int i2 = vVar.c * vVar.a;
        if (i2 < i) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public v b() {
        return new v(this.c, this.a);
    }

    public v c(v vVar) {
        int i = this.a;
        int i2 = vVar.c;
        int i3 = i * i2;
        int i4 = vVar.a;
        int i5 = this.c;
        return i3 <= i4 * i5 ? new v(i4, (i5 * i4) / i) : new v((i * i2) / i5, i2);
    }

    public v d(v vVar) {
        int i = this.a;
        int i2 = vVar.c;
        int i3 = i * i2;
        int i4 = vVar.a;
        int i5 = this.c;
        return i3 >= i4 * i5 ? new v(i4, (i5 * i4) / i) : new v((i * i2) / i5, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return this.a == vVar.a && this.c == vVar.c;
    }

    public int hashCode() {
        return (this.a * 31) + this.c;
    }

    public String toString() {
        return this.a + "x" + this.c;
    }
}
