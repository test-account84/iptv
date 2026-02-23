package K5;

import C5.a;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d {
    public final j6.a a;
    public volatile M5.a b;
    public volatile N5.b c;
    public final List d;

    public d(j6.a aVar) {
        this(aVar, new N5.c(), new M5.f());
    }

    public static /* synthetic */ void a(d dVar, j6.b bVar) {
        dVar.i(bVar);
    }

    public static /* synthetic */ void b(d dVar, String str, Bundle bundle) {
        dVar.g(str, bundle);
    }

    public static /* synthetic */ void c(d dVar, N5.a aVar) {
        dVar.h(aVar);
    }

    public static a.a j(C5.a aVar, e eVar) {
        a.a c = aVar.c("clx", eVar);
        if (c == null) {
            L5.f.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            c = aVar.c("crash", eVar);
            if (c != null) {
                L5.f.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return c;
    }

    public M5.a d() {
        return new b(this);
    }

    public N5.b e() {
        return new a(this);
    }

    public final void f() {
        this.a.a(new c(this));
    }

    public final /* synthetic */ void g(String str, Bundle bundle) {
        this.b.a(str, bundle);
    }

    public final /* synthetic */ void h(N5.a aVar) {
        synchronized (this) {
            try {
                if (this.c instanceof N5.c) {
                    this.d.add(aVar);
                }
                this.c.a(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void i(j6.b bVar) {
        L5.f.f().b("AnalyticsConnector now available.");
        C5.a aVar = (C5.a) bVar.get();
        M5.e eVar = new M5.e(aVar);
        e eVar2 = new e();
        if (j(aVar, eVar2) == null) {
            L5.f.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        L5.f.f().b("Registered Firebase Analytics listener.");
        M5.d dVar = new M5.d();
        M5.c cVar = new M5.c(eVar, 500, TimeUnit.MILLISECONDS);
        synchronized (this) {
            try {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    dVar.a((N5.a) it.next());
                }
                eVar2.d(dVar);
                eVar2.e(cVar);
                this.c = dVar;
                this.b = cVar;
            } finally {
            }
        }
    }

    public d(j6.a aVar, N5.b bVar, M5.a aVar2) {
        this.a = aVar;
        this.c = bVar;
        this.d = new ArrayList();
        this.b = aVar2;
        f();
    }
}
