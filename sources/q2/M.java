package Q2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface m {
    public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class a {
        public static final a e = new a(-1, -1, -1);
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = d4.k0.D0(i3) ? d4.k0.j0(i3, i2) : -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            return r5.j.b(Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.a + ", channelCount=" + this.b + ", encoding=" + this.c + ']';
        }
    }

    public static final class b extends Exception {
        public b(a aVar) {
            this("Unhandled input format:", aVar);
        }

        public b(String str, a aVar) {
            super(str + " " + aVar);
        }
    }

    ByteBuffer a();

    void b(ByteBuffer byteBuffer);

    void c();

    boolean d();

    a e(a aVar);

    void flush();

    boolean isActive();

    void reset();
}
