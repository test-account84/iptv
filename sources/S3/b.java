package s3;

import d4.M;
import java.nio.ByteBuffer;
import java.util.Arrays;
import q3.e;
import q3.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b extends h {
    public q3.a b(e eVar, ByteBuffer byteBuffer) {
        return new q3.a(c(new M(byteBuffer.array(), byteBuffer.limit())));
    }

    public a c(M m) {
        return new a((String) d4.a.e(m.B()), (String) d4.a.e(m.B()), m.A(), m.A(), Arrays.copyOfRange(m.e(), m.f(), m.g()));
    }
}
