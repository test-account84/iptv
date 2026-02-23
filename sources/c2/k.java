package C2;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k implements E2.b {

    public static final class a {
        public static final k a = new k();

        public static /* synthetic */ k a() {
            return a;
        }
    }

    public static k a() {
        return a.a();
    }

    public static Executor b() {
        return (Executor) E2.d.c(j.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
