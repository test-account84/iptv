package P8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class k extends e {
    public k(i iVar, d dVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(dVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = dVar.c + (j * dVar.e);
        this.a = iVar.k(allocate, j2);
        this.b = iVar.i(allocate, 8 + j2);
        this.c = iVar.i(allocate, 16 + j2);
        this.d = iVar.i(allocate, j2 + 40);
    }
}
