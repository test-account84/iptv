package C2;

import C2.d;
import android.util.Base64;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class p {

    public static abstract class a {
        public abstract p a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(z2.d dVar);
    }

    public static a a() {
        return new d.b().d(z2.d.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract z2.d d();

    public boolean e() {
        return c() != null;
    }

    public p f(z2.d dVar) {
        return a().b(b()).d(dVar).c(c()).a();
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", new Object[]{b(), d(), c() == null ? "" : Base64.encodeToString(c(), 2)});
    }
}
