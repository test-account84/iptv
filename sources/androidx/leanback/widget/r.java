package androidx.leanback.widget;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class r {

    public static class a {
        public int a = -1;
        public int b = -1;
        public int c = 0;
        public float d = 50.0f;
        public boolean e = false;
        public boolean f;

        public final int a() {
            return this.c;
        }

        public final float b() {
            return this.d;
        }

        public final int c() {
            return this.a;
        }

        public boolean d() {
            return this.f;
        }

        public final void e(int i) {
            this.c = i;
        }

        public final void f(float f) {
            if ((f < 0.0f || f > 100.0f) && f != -1.0f) {
                throw new IllegalArgumentException();
            }
            this.d = f;
        }

        public final void g(boolean z) {
            this.e = z;
        }

        public final void h(int i) {
            this.a = i;
        }
    }
}
