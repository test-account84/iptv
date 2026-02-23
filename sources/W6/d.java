package W6;

import x6.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d extends q {
    public final float c;
    public final int d;

    public d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    public boolean f(float f, float f2, float f3) {
        if (Math.abs(f2 - d()) > f || Math.abs(f3 - c()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.c);
        return abs <= 1.0f || abs <= this.c;
    }

    public d g(float f, float f2, float f3) {
        int i = this.d;
        int i2 = i + 1;
        float c = (i * c()) + f2;
        float f4 = i2;
        return new d(c / f4, ((this.d * d()) + f) / f4, ((this.d * this.c) + f3) / f4, i2);
    }

    public int h() {
        return this.d;
    }

    public float i() {
        return this.c;
    }

    public d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.c = f3;
        this.d = i;
    }
}
