package x3;

import d4.L;
import d4.M;
import d4.Z;
import java.nio.ByteBuffer;
import q3.a;
import q3.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c extends h {
    public final M a = new M();
    public final L b = new L();
    public Z c;

    public q3.a b(q3.e eVar, ByteBuffer byteBuffer) {
        Z z = this.c;
        if (z == null || eVar.j != z.e()) {
            Z z2 = new Z(eVar.f);
            this.c = z2;
            z2.a(eVar.f - eVar.j);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.a.S(array, limit);
        this.b.o(array, limit);
        this.b.r(39);
        long h = (this.b.h(1) << 32) | this.b.h(32);
        this.b.r(20);
        int h2 = this.b.h(12);
        int h3 = this.b.h(8);
        this.a.V(14);
        a.b a = h3 != 0 ? h3 != 255 ? h3 != 4 ? h3 != 5 ? h3 != 6 ? null : g.a(this.a, h, this.c) : d.a(this.a, h, this.c) : f.a(this.a) : a.a(this.a, h2, h) : new e();
        return a == null ? new q3.a(new a.b[0]) : new q3.a(a);
    }
}
