package h1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e implements r {
    public int a;
    public int b;
    public final int c;
    public final float d;

    public e() {
        this(2500, 1, 1.0f);
    }

    public void a(u uVar) {
        this.b++;
        int i = this.a;
        this.a = i + ((int) (i * this.d));
        if (!d()) {
            throw uVar;
        }
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean d() {
        return this.b <= this.c;
    }

    public e(int i, int i2, float f) {
        this.a = i;
        this.c = i2;
        this.d = f;
    }
}
