package P8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class l extends f {
    public l(i iVar, d dVar, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(dVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.a = iVar.k(allocate, dVar.d + (i * dVar.g) + 28);
    }
}
