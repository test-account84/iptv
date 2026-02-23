package C2;

import C2.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class o {

    public static abstract class a {
        public abstract o a();

        public abstract a b(z2.b bVar);

        public abstract a c(z2.c cVar);

        public abstract a d(z2.e eVar);

        public abstract a e(p pVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new c.b();
    }

    public abstract z2.b b();

    public abstract z2.c c();

    public byte[] d() {
        return (byte[]) e().apply(c().b());
    }

    public abstract z2.e e();

    public abstract p f();

    public abstract String g();
}
