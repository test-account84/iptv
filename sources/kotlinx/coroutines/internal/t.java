package kotlinx.coroutines.internal;

import G8.K;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class t {

    public static final class a extends kotlin.jvm.internal.m implements w8.l {
        public final /* synthetic */ w8.l a;
        public final /* synthetic */ Object c;
        public final /* synthetic */ o8.g d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w8.l lVar, Object obj, o8.g gVar) {
            super(1);
            this.a = lVar;
            this.c = obj;
            this.d = gVar;
        }

        public final void a(Throwable th) {
            t.b(this.a, this.c, this.d);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return k8.q.a;
        }
    }

    public static final w8.l a(w8.l lVar, Object obj, o8.g gVar) {
        return new a(lVar, obj, gVar);
    }

    public static final void b(w8.l lVar, Object obj, o8.g gVar) {
        G c = c(lVar, obj, null);
        if (c != null) {
            K.a(gVar, c);
        }
    }

    public static final G c(w8.l lVar, Object obj, G g) {
        try {
            lVar.invoke(obj);
        } catch (Throwable th) {
            if (g == null || g.getCause() == th) {
                return new G("Exception in undelivered element handler for " + obj, th);
            }
            k8.a.a(g, th);
        }
        return g;
    }

    public static /* synthetic */ G d(w8.l lVar, Object obj, G g, int i, Object obj2) {
        if ((i & 2) != 0) {
            g = null;
        }
        return c(lVar, obj, g);
    }
}
