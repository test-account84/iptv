package O5;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class o {
    public final Context a;
    public final A5.f b;
    public final u c;
    public p f;
    public p g;
    public boolean h;
    public m i;
    public final y j;
    public final T5.f k;
    public final N5.b l;
    public final M5.a m;
    public final ExecutorService n;
    public final k o;
    public final j p;
    public final L5.a q;
    public final long e = System.currentTimeMillis();
    public final D d = new D();

    public class a implements Callable {
        public final /* synthetic */ V5.i a;

        public a(V5.i iVar) {
            this.a = iVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Task call() {
            return o.a(o.this, this.a);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ V5.i a;

        public b(V5.i iVar) {
            this.a = iVar;
        }

        public void run() {
            o.a(o.this, this.a);
        }
    }

    public class c implements Callable {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            try {
                boolean d = o.b(o.this).d();
                if (!d) {
                    L5.f.f().k("Initialization marker file was not properly removed.");
                }
                return Boolean.valueOf(d);
            } catch (Exception e) {
                L5.f.f().e("Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.FALSE;
            }
        }
    }

    public class d implements Callable {
        public d() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(o.c(o.this).s());
        }
    }

    public o(A5.f fVar, y yVar, L5.a aVar, u uVar, N5.b bVar, M5.a aVar2, T5.f fVar2, ExecutorService executorService, j jVar) {
        this.b = fVar;
        this.c = uVar;
        this.a = fVar.l();
        this.j = yVar;
        this.q = aVar;
        this.l = bVar;
        this.m = aVar2;
        this.n = executorService;
        this.k = fVar2;
        this.o = new k(executorService);
        this.p = jVar;
    }

    public static /* synthetic */ Task a(o oVar, V5.i iVar) {
        return oVar.f(iVar);
    }

    public static /* synthetic */ p b(o oVar) {
        return oVar.f;
    }

    public static /* synthetic */ m c(o oVar) {
        return oVar.i;
    }

    public static String i() {
        return "18.4.1";
    }

    public static boolean j(String str, boolean z) {
        if (!z) {
            L5.f.f().i("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".");
        return false;
    }

    public final void d() {
        boolean z;
        try {
            z = Boolean.TRUE.equals((Boolean) W.f(this.o.g(new d())));
        } catch (Exception unused) {
            z = false;
        }
        this.h = z;
    }

    public boolean e() {
        return this.f.c();
    }

    public final Task f(V5.i iVar) {
        m();
        try {
            this.l.a(new n(this));
            this.i.S();
            if (!iVar.b().b.a) {
                L5.f.f().b("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.i.z(iVar)) {
                L5.f.f().k("Previous sessions could not be finalized.");
            }
            return this.i.U(iVar.a());
        } catch (Exception e) {
            L5.f.f().e("Crashlytics encountered a problem during asynchronous initialization.", e);
            return Tasks.forException(e);
        } finally {
            l();
        }
    }

    public Task g(V5.i iVar) {
        return W.h(this.n, new a(iVar));
    }

    public final void h(V5.i iVar) {
        L5.f f;
        String str;
        Future submit = this.n.submit(new b(iVar));
        L5.f.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3L, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e = e;
            f = L5.f.f();
            str = "Crashlytics timed out during initialization.";
            f.e(str, e);
        } catch (InterruptedException e2) {
            e = e2;
            f = L5.f.f();
            str = "Crashlytics was interrupted during initialization.";
            f.e(str, e);
        } catch (ExecutionException e3) {
            e = e3;
            f = L5.f.f();
            str = "Crashlytics encountered a problem during initialization.";
            f.e(str, e);
        }
    }

    public void k(String str) {
        this.i.X(System.currentTimeMillis() - this.e, str);
    }

    public void l() {
        this.o.g(new c());
    }

    public void m() {
        this.o.b();
        this.f.a();
        L5.f.f().i("Initialization marker file was created.");
    }

    public boolean n(O5.a aVar, V5.i iVar) {
        if (!j(aVar.b, i.k(this.a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
        }
        String hVar = new h(this.j).toString();
        try {
            this.g = new p("crash_marker", this.k);
            this.f = new p("initialization_marker", this.k);
            P5.h hVar2 = new P5.h(hVar, this.k, this.o);
            P5.c cVar = new P5.c(this.k);
            this.i = new m(this.a, this.o, this.j, this.c, this.k, this.g, aVar, hVar2, cVar, O.g(this.a, this.j, this.k, aVar, cVar, hVar2, new W5.a(1024, new W5.c(10)), iVar, this.d, this.p), this.q, this.m);
            boolean e = e();
            d();
            this.i.x(hVar, Thread.getDefaultUncaughtExceptionHandler(), iVar);
            if (!e || !i.c(this.a)) {
                L5.f.f().b("Successfully configured exception handler.");
                return true;
            }
            L5.f.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            h(iVar);
            return false;
        } catch (Exception e2) {
            L5.f.f().e("Crashlytics was not started due to an exception during initialization", e2);
            this.i = null;
            return false;
        }
    }
}
