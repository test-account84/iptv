package d4;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class t {
    public final int a;
    public final int b;
    public final float c;
    public final long d;

    public static final class b {
        public int a;
        public int b;
        public float c = 1.0f;
        public long d;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public t a() {
            return new t(this.a, this.b, this.c, this.d, null);
        }

        public b b(float f) {
            this.c = f;
            return this;
        }
    }

    public t(int i, int i2, float f, long j) {
        d4.a.b(i > 0, "width must be positive, but is: " + i);
        d4.a.b(i2 > 0, "height must be positive, but is: " + i2);
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = j;
    }

    public /* synthetic */ t(int i, int i2, float f, long j, a aVar) {
        this(i, i2, f, j);
    }
}
