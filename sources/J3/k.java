package J3;

import B3.J;
import android.net.Uri;
import b4.F;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface k {

    public interface a {
        k a(H3.g gVar, F f, j jVar);
    }

    public interface b {
        boolean a(Uri uri, F.c cVar, boolean z);

        void e();
    }

    public static final class c extends IOException {
        public final Uri a;

        public c(Uri uri) {
            this.a = uri;
        }
    }

    public static final class d extends IOException {
        public final Uri a;

        public d(Uri uri) {
            this.a = uri;
        }
    }

    public interface e {
        void M(f fVar);
    }

    void a(Uri uri, J.a aVar, e eVar);

    void b(b bVar);

    void c(Uri uri);

    long d();

    g e();

    void f(b bVar);

    void g(Uri uri);

    boolean h(Uri uri);

    boolean i();

    boolean k(Uri uri, long j);

    void l();

    f m(Uri uri, boolean z);

    void stop();
}
