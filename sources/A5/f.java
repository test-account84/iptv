package A5;

import I5.o;
import I5.x;
import J5.C;
import L.u;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.google.ads.interactivemedia.v3.internal.z1;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class f {
    public static final Object k = new Object();
    public static final Map l = new s.a();
    public final Context a;
    public final String b;
    public final o c;
    public final I5.o d;
    public final x g;
    public final j6.b h;
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final AtomicBoolean f = new AtomicBoolean();
    public final List i = new CopyOnWriteArrayList();
    public final List j = new CopyOnWriteArrayList();

    public interface a {
        void a(boolean z);
    }

    public static class b implements c.a {
        public static AtomicReference a = new AtomicReference();

        public static /* synthetic */ void b(Context context) {
            c(context);
        }

        public static void c(Context context) {
            if (C4.m.a() && (context.getApplicationContext() instanceof Application)) {
                Application applicationContext = context.getApplicationContext();
                if (a.get() == null) {
                    b bVar = new b();
                    if (z1.a(a, null, bVar)) {
                        com.google.android.gms.common.api.internal.c.c(applicationContext);
                        com.google.android.gms.common.api.internal.c.b().a(bVar);
                    }
                }
            }
        }

        public void a(boolean z) {
            synchronized (f.c()) {
                try {
                    Iterator it = new ArrayList(f.l.values()).iterator();
                    while (it.hasNext()) {
                        f fVar = (f) it.next();
                        if (f.e(fVar).get()) {
                            f.f(fVar, z);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class c extends BroadcastReceiver {
        public static AtomicReference b = new AtomicReference();
        public final Context a;

        public c(Context context) {
            this.a = context;
        }

        public static /* synthetic */ void a(Context context) {
            b(context);
        }

        public static void b(Context context) {
            if (b.get() == null) {
                c cVar = new c(context);
                if (z1.a(b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.a.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (f.c()) {
                try {
                    Iterator it = f.l.values().iterator();
                    while (it.hasNext()) {
                        f.d((f) it.next());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            c();
        }
    }

    public f(Context context, String str, o oVar) {
        this.a = (Context) r.m(context);
        this.b = r.g(str);
        this.c = (o) r.m(oVar);
        q b2 = FirebaseInitProvider.b();
        w6.c.b("Firebase");
        w6.c.b("ComponentDiscovery");
        Collection b3 = I5.g.c(context, ComponentDiscoveryService.class).b();
        w6.c.a();
        w6.c.b("Runtime");
        o.b g = I5.o.m(C.INSTANCE).d(b3).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(I5.c.s(context, Context.class, new Class[0])).b(I5.c.s(this, f.class, new Class[0])).b(I5.c.s(oVar, o.class, new Class[0])).g(new w6.b());
        if (u.a(context) && FirebaseInitProvider.c()) {
            g.b(I5.c.s(b2, q.class, new Class[0]));
        }
        I5.o e = g.e();
        this.d = e;
        w6.c.a();
        this.g = new x(new d(this, context));
        this.h = e.g(h6.f.class);
        g(new e(this));
        w6.c.a();
    }

    public static /* synthetic */ void a(f fVar, boolean z) {
        fVar.y(z);
    }

    public static /* synthetic */ o6.a b(f fVar, Context context) {
        return fVar.x(context);
    }

    public static /* synthetic */ Object c() {
        return k;
    }

    public static /* synthetic */ void d(f fVar) {
        fVar.r();
    }

    public static /* synthetic */ AtomicBoolean e(f fVar) {
        return fVar.e;
    }

    public static /* synthetic */ void f(f fVar, boolean z) {
        fVar.A(z);
    }

    public static List k() {
        ArrayList arrayList = new ArrayList();
        synchronized (k) {
            try {
                Iterator it = l.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(((f) it.next()).o());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static f m() {
        f fVar;
        synchronized (k) {
            try {
                fVar = (f) l.get("[DEFAULT]");
                if (fVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + C4.n.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((h6.f) fVar.h.get()).l();
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public static f n(String str) {
        f fVar;
        String str2;
        synchronized (k) {
            try {
                fVar = (f) l.get(z(str));
                if (fVar == null) {
                    List k2 = k();
                    if (k2.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", k2);
                    }
                    throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
                }
                ((h6.f) fVar.h.get()).l();
            } finally {
            }
        }
        return fVar;
    }

    public static f s(Context context) {
        synchronized (k) {
            try {
                if (l.containsKey("[DEFAULT]")) {
                    return m();
                }
                o a2 = o.a(context);
                if (a2 == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return t(context, a2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static f t(Context context, o oVar) {
        return u(context, oVar, "[DEFAULT]");
    }

    public static f u(Context context, o oVar, String str) {
        f fVar;
        b.b(context);
        String z = z(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (k) {
            Map map = l;
            r.q(!map.containsKey(z), "FirebaseApp name " + z + " already exists!");
            r.n(context, "Application context cannot be null.");
            fVar = new f(context, z, oVar);
            map.put(z, fVar);
        }
        fVar.r();
        return fVar;
    }

    public static String z(String str) {
        return str.trim();
    }

    public final void A(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.b.equals(((f) obj).o());
        }
        return false;
    }

    public void g(a aVar) {
        i();
        if (this.e.get() && com.google.android.gms.common.api.internal.c.b().d()) {
            aVar.a(true);
        }
        this.i.add(aVar);
    }

    public void h(g gVar) {
        i();
        r.m(gVar);
        this.j.add(gVar);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public final void i() {
        r.q(!this.f.get(), "FirebaseApp was deleted");
    }

    public Object j(Class cls) {
        i();
        return this.d.a(cls);
    }

    public Context l() {
        i();
        return this.a;
    }

    public String o() {
        i();
        return this.b;
    }

    public o p() {
        i();
        return this.c;
    }

    public String q() {
        return C4.c.e(o().getBytes(Charset.defaultCharset())) + "+" + C4.c.e(p().c().getBytes(Charset.defaultCharset()));
    }

    public final void r() {
        if (!u.a(this.a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + o());
            c.a(this.a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + o());
        this.d.p(w());
        ((h6.f) this.h.get()).l();
    }

    public String toString() {
        return com.google.android.gms.common.internal.q.d(this).a("name", this.b).a("options", this.c).toString();
    }

    public boolean v() {
        i();
        return ((o6.a) this.g.get()).b();
    }

    public boolean w() {
        return "[DEFAULT]".equals(o());
    }

    public final /* synthetic */ o6.a x(Context context) {
        return new o6.a(context, q(), (g6.c) this.d.a(g6.c.class));
    }

    public final /* synthetic */ void y(boolean z) {
        if (z) {
            return;
        }
        ((h6.f) this.h.get()).l();
    }
}
