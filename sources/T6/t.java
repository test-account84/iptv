package t6;

import java.util.Locale;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class t {
    public final boolean a;
    public final y b;
    public final w8.a c;
    public final String d;
    public int e;
    public q f;

    public /* synthetic */ class a extends kotlin.jvm.internal.j implements w8.a {
        public static final a d = new a();

        public a() {
            super(0, UUID.class, "randomUUID", "randomUUID()Ljava/util/UUID;", 0);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    public t(boolean z, y yVar, w8.a aVar) {
        kotlin.jvm.internal.l.e(yVar, "timeProvider");
        kotlin.jvm.internal.l.e(aVar, "uuidGenerator");
        this.a = z;
        this.b = yVar;
        this.c = aVar;
        this.d = b();
        this.e = -1;
    }

    public final q a() {
        int i = this.e + 1;
        this.e = i;
        this.f = new q(i == 0 ? this.d : b(), this.d, this.e, this.b.b());
        return d();
    }

    public final String b() {
        String uuid = ((UUID) this.c.invoke()).toString();
        kotlin.jvm.internal.l.d(uuid, "uuidGenerator().toString()");
        String lowerCase = E8.n.x(uuid, "-", "", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.l.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public final boolean c() {
        return this.a;
    }

    public final q d() {
        q qVar = this.f;
        if (qVar != null) {
            return qVar;
        }
        kotlin.jvm.internal.l.s("currentSession");
        return null;
    }

    public final boolean e() {
        return this.f != null;
    }

    public /* synthetic */ t(boolean z, y yVar, w8.a aVar, int i, kotlin.jvm.internal.g gVar) {
        this(z, yVar, (i & 4) != 0 ? a.d : aVar);
    }
}
