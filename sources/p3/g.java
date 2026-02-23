package P3;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g implements j {
    public final c a = new c();
    public final n b = new n();
    public final Deque c = new ArrayDeque();
    public int d;
    public boolean e;

    public class a extends o {
        public a() {
        }

        public void release() {
            g.e(g.this, this);
        }
    }

    public static final class b implements i {
        public final long a;
        public final y c;

        public b(long j, y yVar) {
            this.a = j;
            this.c = yVar;
        }

        public int a(long j) {
            return this.a > j ? 0 : -1;
        }

        public List b(long j) {
            return j >= this.a ? this.c : y.z();
        }

        public long c(int i) {
            d4.a.a(i == 0);
            return this.a;
        }

        public int h() {
            return 1;
        }
    }

    public g() {
        for (int i = 0; i < 2; i++) {
            this.c.addFirst(new a());
        }
        this.d = 0;
    }

    public static /* synthetic */ void e(g gVar, o oVar) {
        gVar.i(oVar);
    }

    private void i(o oVar) {
        d4.a.g(this.c.size() < 2);
        d4.a.a(!this.c.contains(oVar));
        oVar.clear();
        this.c.addFirst(oVar);
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public n d() {
        d4.a.g(!this.e);
        if (this.d != 0) {
            return null;
        }
        this.d = 1;
        return this.b;
    }

    public void flush() {
        d4.a.g(!this.e);
        this.b.clear();
        this.d = 0;
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public o b() {
        d4.a.g(!this.e);
        if (this.d != 2 || this.c.isEmpty()) {
            return null;
        }
        o oVar = (o) this.c.removeFirst();
        if (this.b.isEndOfStream()) {
            oVar.addFlag(4);
        } else {
            n nVar = this.b;
            oVar.d(this.b.f, new b(nVar.f, this.a.a(((ByteBuffer) d4.a.e(nVar.d)).array())), 0L);
        }
        this.b.clear();
        this.d = 0;
        return oVar;
    }

    public String getName() {
        return "ExoplayerCuesDecoder";
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(n nVar) {
        d4.a.g(!this.e);
        d4.a.g(this.d == 1);
        d4.a.a(this.b == nVar);
        this.d = 2;
    }

    public void release() {
        this.e = true;
    }

    public void a(long j) {
    }
}
