package i3;

import com.google.android.exoplayer2.extractor.g;
import d3.k;
import d3.u;
import d3.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d implements k {
    public final long a;
    public final k c;

    public class a implements g {
        public final /* synthetic */ g a;

        public a(g gVar) {
            this.a = gVar;
        }

        public g.a e(long j) {
            g.a e = this.a.e(j);
            u uVar = e.a;
            u uVar2 = new u(uVar.a, uVar.b + d.a(d.this));
            u uVar3 = e.b;
            return new g.a(uVar2, new u(uVar3.a, uVar3.b + d.a(d.this)));
        }

        public boolean g() {
            return this.a.g();
        }

        public long i() {
            return this.a.i();
        }
    }

    public d(long j, k kVar) {
        this.a = j;
        this.c = kVar;
    }

    public static /* synthetic */ long a(d dVar) {
        return dVar.a;
    }

    public w e(int i, int i2) {
        return this.c.e(i, i2);
    }

    public void n(g gVar) {
        this.c.n(new a(gVar));
    }

    public void q() {
        this.c.q();
    }
}
