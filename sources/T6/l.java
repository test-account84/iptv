package t6;

import G8.H;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import u6.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l {
    public static final a h = new a(null);
    public final A5.f a;
    public final t6.b b;
    public final v6.f c;
    public final y d;
    public final t e;
    public final h f;
    public final o g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b extends q8.d {
        public Object a;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public int g;

        public b(o8.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return l.a(l.this, null, this);
        }
    }

    public static final class c implements v {
        public c() {
        }

        public Object a(q qVar, o8.d dVar) {
            Object a = l.a(l.this, qVar, dVar);
            return a == p8.c.d() ? a : k8.q.a;
        }
    }

    public l(A5.f fVar, k6.h hVar, H h2, H h3, j6.b bVar) {
        kotlin.jvm.internal.l.e(fVar, "firebaseApp");
        kotlin.jvm.internal.l.e(hVar, "firebaseInstallations");
        kotlin.jvm.internal.l.e(h2, "backgroundDispatcher");
        kotlin.jvm.internal.l.e(h3, "blockingDispatcher");
        kotlin.jvm.internal.l.e(bVar, "transportFactoryProvider");
        this.a = fVar;
        t6.b a2 = s.a.a(fVar);
        this.b = a2;
        Context l = fVar.l();
        kotlin.jvm.internal.l.d(l, "firebaseApp.applicationContext");
        v6.f fVar2 = new v6.f(l, h3, h2, hVar, a2);
        this.c = fVar2;
        x xVar = new x();
        this.d = xVar;
        h hVar2 = new h(bVar);
        this.f = hVar2;
        this.g = new o(hVar, hVar2);
        t tVar = new t(d(), xVar, null, 4, null);
        this.e = tVar;
        w wVar = new w(xVar, h2, new c(), fVar2, tVar);
        Application applicationContext = fVar.l().getApplicationContext();
        if (applicationContext instanceof Application) {
            applicationContext.registerActivityLifecycleCallbacks(wVar.d());
            fVar.h(new k(applicationContext, wVar));
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + '.');
    }

    public static final /* synthetic */ Object a(l lVar, q qVar, o8.d dVar) {
        return lVar.b(qVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(t6.q r11, o8.d r12) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.l.b(t6.q, o8.d):java.lang.Object");
    }

    public final void c(u6.b bVar) {
        kotlin.jvm.internal.l.e(bVar, "subscriber");
        u6.a.a.e(bVar);
        Log.d("FirebaseSessions", "Registering Sessions SDK subscriber with name: " + bVar.c() + ", data collection enabled: " + bVar.b());
        if (this.e.e()) {
            bVar.a(new b.b(this.e.d().b()));
        }
    }

    public final boolean d() {
        return Math.random() <= this.c.b();
    }
}
