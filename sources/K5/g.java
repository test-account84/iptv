package K5;

import O5.i;
import O5.j;
import O5.o;
import O5.u;
import O5.w;
import O5.y;
import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import k6.h;
import t6.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g {
    public final o a;

    public class a implements Continuation {
        public Object then(Task task) {
            if (task.isSuccessful()) {
                return null;
            }
            L5.f.f().e("Error fetching settings.", task.getException());
            return null;
        }
    }

    public class b implements Callable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ o b;
        public final /* synthetic */ V5.f c;

        public b(boolean z, o oVar, V5.f fVar) {
            this.a = z;
            this.b = oVar;
            this.c = fVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            if (!this.a) {
                return null;
            }
            this.b.g(this.c);
            return null;
        }
    }

    public g(o oVar) {
        this.a = oVar;
    }

    public static g a(A5.f fVar, h hVar, l lVar, j6.a aVar, j6.a aVar2) {
        Context l = fVar.l();
        String packageName = l.getPackageName();
        L5.f.f().g("Initializing Firebase Crashlytics " + o.i() + " for " + packageName);
        T5.f fVar2 = new T5.f(l);
        u uVar = new u(fVar);
        y yVar = new y(l, packageName, hVar, uVar);
        L5.d dVar = new L5.d(aVar);
        d dVar2 = new d(aVar2);
        ExecutorService c = w.c("Crashlytics Exception Handler");
        j jVar = new j(uVar);
        lVar.c(jVar);
        o oVar = new o(fVar, yVar, dVar, uVar, dVar2.e(), dVar2.d(), fVar2, c, jVar);
        String c2 = fVar.p().c();
        String o = i.o(l);
        List<O5.f> l2 = i.l(l);
        L5.f.f().b("Mapping file ID is: " + o);
        for (O5.f fVar3 : l2) {
            L5.f.f().b(String.format("Build id for %s on %s: %s", new Object[]{fVar3.c(), fVar3.a(), fVar3.b()}));
        }
        try {
            O5.a a2 = O5.a.a(l, yVar, c2, o, l2, new L5.e(l));
            L5.f.f().i("Installer package name is: " + a2.d);
            Executor c3 = w.c("com.google.firebase.crashlytics.startup");
            V5.f l3 = V5.f.l(l, c2, yVar, new S5.b(), a2.f, a2.g, fVar2, uVar);
            l3.p(c3).continueWith(c3, new a());
            Tasks.call(c3, new b(oVar.n(a2, l3), oVar, l3));
            return new g(oVar);
        } catch (PackageManager.NameNotFoundException e) {
            L5.f.f().e("Error retrieving app package info.", e);
            return null;
        }
    }
}
