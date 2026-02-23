package P5;

import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class c {
    public static final b c = new b(null);
    public final T5.f a;
    public P5.a b;

    public static final class b implements P5.a {
        public b() {
        }

        public String b() {
            return null;
        }

        public byte[] c() {
            return null;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public void a() {
        }

        public void d() {
        }

        public void e(long j, String str) {
        }
    }

    public c(T5.f fVar) {
        this.a = fVar;
        this.b = c;
    }

    public void a() {
        this.b.d();
    }

    public byte[] b() {
        return this.b.c();
    }

    public String c() {
        return this.b.b();
    }

    public final File d(String str) {
        return this.a.o(str, "userlog");
    }

    public final void e(String str) {
        this.b.a();
        this.b = c;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    public void f(File file, int i) {
        this.b = new f(file, i);
    }

    public void g(long j, String str) {
        this.b.e(j, str);
    }

    public c(T5.f fVar, String str) {
        this(fVar);
        e(str);
    }
}
