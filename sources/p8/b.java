package P8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class b extends c {
    public b(i iVar, d dVar, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(dVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i * 16);
        this.a = iVar.i(allocate, j2);
        this.b = iVar.i(allocate, j2 + 8);
    }
}
