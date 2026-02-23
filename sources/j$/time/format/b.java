package j$.time.format;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Comparator;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class b {
    private static final Comparator b;
    public static final /* synthetic */ int c = 0;
    final /* synthetic */ r a;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
        b = new q();
    }

    b(r rVar) {
        this.a = rVar;
    }

    static /* bridge */ /* synthetic */ Comparator a() {
        return b;
    }

    public final String b(j$.time.chrono.n nVar, j$.time.temporal.r rVar, long j, v vVar, Locale locale) {
        return this.a.a(j, vVar);
    }

    public final String c(j$.time.temporal.r rVar, long j, v vVar, Locale locale) {
        return this.a.a(j, vVar);
    }
}
