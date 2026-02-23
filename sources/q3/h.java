package q3;

import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h implements c {
    public final a a(e eVar) {
        ByteBuffer byteBuffer = (ByteBuffer) d4.a.e(eVar.d);
        d4.a.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (eVar.isDecodeOnly()) {
            return null;
        }
        return b(eVar, byteBuffer);
    }

    public abstract a b(e eVar, ByteBuffer byteBuffer);
}
