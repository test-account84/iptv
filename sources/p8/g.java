package P8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class g extends d {
    public final i j;

    public g(boolean z, i iVar) {
        this.a = z;
        this.j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.b = iVar.h(allocate, 16L);
        this.c = iVar.k(allocate, 28L);
        this.d = iVar.k(allocate, 32L);
        this.e = iVar.h(allocate, 42L);
        this.f = iVar.h(allocate, 44L);
        this.g = iVar.h(allocate, 46L);
        this.h = iVar.h(allocate, 48L);
        this.i = iVar.h(allocate, 50L);
    }

    public c a(long j, int i) {
        return new a(this.j, this, j, i);
    }

    public e b(long j) {
        return new j(this.j, this, j);
    }

    public f c(int i) {
        return new l(this.j, this, i);
    }
}
