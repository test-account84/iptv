package V2;

import V2.w;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface o {

    public static class a extends IOException {
        public final int a;

        public a(Throwable th, int i) {
            super(th);
            this.a = i;
        }
    }

    UUID a();

    boolean b();

    byte[] c();

    CryptoConfig d();

    Map e();

    void f(w.a aVar);

    void g(w.a aVar);

    a getError();

    int getState();

    boolean h(String str);
}
