package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class l {

    public static class a implements c {
        public final ByteBuffer a;

        public a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public void b(int i) {
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + i);
        }

        public int c() {
            return this.a.getInt();
        }

        public int d() {
            return l.d(this.a.getShort());
        }

        public long e() {
            return l.c(this.a.getInt());
        }

        public long getPosition() {
            return this.a.position();
        }
    }

    public static class b {
        public final long a;
        public final long b;

        public b(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public long a() {
            return this.a;
        }
    }

    public interface c {
        void b(int i);

        int c();

        int d();

        long e();

        long getPosition();
    }

    public static b a(c cVar) {
        long j;
        cVar.b(4);
        int d = cVar.d();
        if (d > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.b(6);
        int i = 0;
        while (true) {
            if (i >= d) {
                j = -1;
                break;
            }
            int c2 = cVar.c();
            cVar.b(4);
            j = cVar.e();
            cVar.b(4);
            if (1835365473 == c2) {
                break;
            }
            i++;
        }
        if (j != -1) {
            cVar.b((int) (j - cVar.getPosition()));
            cVar.b(12);
            long e = cVar.e();
            for (int i2 = 0; i2 < e; i2++) {
                int c3 = cVar.c();
                long e2 = cVar.e();
                long e3 = cVar.e();
                if (1164798569 == c3 || 1701669481 == c3) {
                    return new b(e2 + j, e3);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static c0.b b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new a(duplicate)).a());
        return c0.b.h(duplicate);
    }

    public static long c(int i) {
        return i & 4294967295L;
    }

    public static int d(short s) {
        return s & 65535;
    }
}
