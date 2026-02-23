package P8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class a extends c {
    public a(i iVar, d dVar, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(dVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i * 8);
        this.a = iVar.k(allocate, j2);
        this.b = iVar.k(allocate, j2 + 4);
    }
}
