package t6;

import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h implements i {
    public static final a b = new a(null);
    public final j6.b a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public h(j6.b bVar) {
        kotlin.jvm.internal.l.e(bVar, "transportFactoryProvider");
        this.a = bVar;
    }

    public static /* synthetic */ byte[] b(h hVar, r rVar) {
        return hVar.c(rVar);
    }

    public void a(r rVar) {
        kotlin.jvm.internal.l.e(rVar, "sessionEvent");
        ((z2.g) this.a.get()).a("FIREBASE_APPQUALITY_SESSION", r.class, z2.b.b("json"), new g(this)).a(z2.c.e(rVar));
    }

    public final byte[] c(r rVar) {
        String encode = s.a.b().encode(rVar);
        kotlin.jvm.internal.l.d(encode, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        Log.d("EventGDTLogger", "Session Event: " + encode);
        byte[] bytes = encode.getBytes(E8.c.b);
        kotlin.jvm.internal.l.d(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }
}
