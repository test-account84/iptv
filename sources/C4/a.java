package c4;

import java.io.File;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface a {

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }

        public a(Throwable th) {
            super(th);
        }
    }

    public interface b {
        void a(a aVar, j jVar, j jVar2);

        void c(a aVar, j jVar);

        void d(a aVar, j jVar);
    }

    File a(String str, long j, long j2);

    o b(String str);

    long c(String str, long j, long j2);

    j d(String str, long j, long j2);

    long e(String str, long j, long j2);

    void f(String str, p pVar);

    void g(j jVar);

    j h(String str, long j, long j2);

    void i(File file, long j);

    void j(String str);
}
