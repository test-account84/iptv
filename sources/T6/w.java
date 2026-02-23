package t6;

import G8.L;
import G8.M;
import G8.N;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class w {
    public final y a;
    public final o8.g b;
    public final v c;
    public final v6.f d;
    public final t e;
    public long f;
    public final Application.ActivityLifecycleCallbacks g;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.l.e(activity, "activity");
        }

        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.l.e(activity, "activity");
        }

        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.l.e(activity, "activity");
            w.this.b();
        }

        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.l.e(activity, "activity");
            w.this.c();
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.l.e(activity, "activity");
            kotlin.jvm.internal.l.e(bundle, "outState");
        }

        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.l.e(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.l.e(activity, "activity");
        }
    }

    public static final class b extends q8.l implements w8.p {
        public int a;
        public final /* synthetic */ q d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q qVar, o8.d dVar) {
            super(2, dVar);
            this.d = qVar;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(L l, o8.d dVar) {
            return create(l, dVar).invokeSuspend(k8.q.a);
        }

        public final o8.d create(Object obj, o8.d dVar) {
            return w.this.new b(this.d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d = p8.c.d();
            int i = this.a;
            if (i == 0) {
                k8.k.b(obj);
                v a = w.a(w.this);
                q qVar = this.d;
                this.a = 1;
                if (a.a(qVar, this) == d) {
                    return d;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                k8.k.b(obj);
            }
            return k8.q.a;
        }
    }

    public w(y yVar, o8.g gVar, v vVar, v6.f fVar, t tVar) {
        kotlin.jvm.internal.l.e(yVar, "timeProvider");
        kotlin.jvm.internal.l.e(gVar, "backgroundDispatcher");
        kotlin.jvm.internal.l.e(vVar, "sessionInitiateListener");
        kotlin.jvm.internal.l.e(fVar, "sessionsSettings");
        kotlin.jvm.internal.l.e(tVar, "sessionGenerator");
        this.a = yVar;
        this.b = gVar;
        this.c = vVar;
        this.d = fVar;
        this.e = tVar;
        this.f = yVar.a();
        e();
        this.g = new a();
    }

    public static final /* synthetic */ v a(w wVar) {
        return wVar.c;
    }

    public final void b() {
        this.f = this.a.a();
    }

    public final void c() {
        if (F8.a.e(F8.a.B(this.a.a(), this.f), this.d.c()) > 0) {
            e();
        }
    }

    public final Application.ActivityLifecycleCallbacks d() {
        return this.g;
    }

    public final void e() {
        G8.i.d(M.a(this.b), (o8.g) null, (N) null, new b(this.e.a(), null), 3, (Object) null);
    }
}
