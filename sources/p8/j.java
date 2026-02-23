package P8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class j extends e {
    public j(i iVar, d dVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(dVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = dVar.c + (j * dVar.e);
        this.a = iVar.k(allocate, j2);
        this.b = iVar.k(allocate, 4 + j2);
        this.c = iVar.k(allocate, 8 + j2);
        this.d = iVar.k(allocate, j2 + 20);
    }
}
