package Q3;

import P3.i;
import P3.j;
import P3.n;
import P3.o;
import com.google.android.exoplayer2.decoder.a;
import d4.k0;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class e implements j {
    public final ArrayDeque a = new ArrayDeque();
    public final ArrayDeque b;
    public final PriorityQueue c;
    public b d;
    public long e;
    public long f;

    public static final class b extends n implements Comparable {
        public long k;

        public b() {
        }

        public static /* synthetic */ long o(b bVar, long j) {
            bVar.k = j;
            return j;
        }

        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (isEndOfStream() != bVar.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j = this.f - bVar.f;
            if (j == 0) {
                j = this.k - bVar.k;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static final class c extends o {
        public a.a d;

        public c(a.a aVar) {
            this.d = aVar;
        }

        public final void release() {
            this.d.a(this);
        }
    }

    public e() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new b(null));
        }
        this.b = new ArrayDeque();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new c(new d(this)));
        }
        this.c = new PriorityQueue();
    }

    public void a(long j) {
        this.e = j;
    }

    public abstract i e();

    public abstract void f(n nVar);

    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            m((b) k0.j((b) this.c.poll()));
        }
        b bVar = this.d;
        if (bVar != null) {
            m(bVar);
            this.d = null;
        }
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public n d() {
        d4.a.g(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        b bVar = (b) this.a.pollFirst();
        this.d = bVar;
        return bVar;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public o b() {
        o oVar;
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && ((b) k0.j((b) this.c.peek())).f <= this.e) {
            b bVar = (b) k0.j((b) this.c.poll());
            if (bVar.isEndOfStream()) {
                oVar = (o) k0.j((o) this.b.pollFirst());
                oVar.addFlag(4);
            } else {
                f(bVar);
                if (k()) {
                    i e = e();
                    oVar = (o) k0.j((o) this.b.pollFirst());
                    oVar.d(bVar.f, e, Long.MAX_VALUE);
                } else {
                    m(bVar);
                }
            }
            m(bVar);
            return oVar;
        }
        return null;
    }

    public final o i() {
        return (o) this.b.pollFirst();
    }

    public final long j() {
        return this.e;
    }

    public abstract boolean k();

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void c(n nVar) {
        d4.a.a(nVar == this.d);
        b bVar = (b) nVar;
        if (bVar.isDecodeOnly()) {
            m(bVar);
        } else {
            long j = this.f;
            this.f = 1 + j;
            b.o(bVar, j);
            this.c.add(bVar);
        }
        this.d = null;
    }

    public final void m(b bVar) {
        bVar.clear();
        this.a.add(bVar);
    }

    public void n(o oVar) {
        oVar.clear();
        this.b.add(oVar);
    }

    public void release() {
    }
}
