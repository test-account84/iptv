package com.google.firebase.auth;

import A5.f;
import G5.F;
import G5.e;
import G5.g;
import G5.h;
import G5.i0;
import G5.j0;
import G5.k0;
import G5.u;
import H5.I;
import H5.M;
import H5.N;
import H5.Q;
import H5.S;
import H5.T;
import H5.d0;
import H5.s;
import H5.t;
import H5.v;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.firebase-auth-api.zzaai;
import com.google.android.gms.internal.firebase-auth-api.zzacf;
import com.google.android.gms.internal.firebase-auth-api.zzafn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class FirebaseAuth implements H5.a {
    public f a;
    public final List b;
    public final List c;
    public List d;
    public zzaai e;
    public u f;
    public H5.c g;
    public final Object h;
    public String i;
    public final Object j;
    public String k;
    public I l;
    public final RecaptchaAction m;
    public final RecaptchaAction n;
    public final RecaptchaAction o;
    public final N p;
    public final S q;
    public final t r;
    public final j6.b s;
    public final j6.b t;
    public M u;
    public final Executor v;
    public final Executor w;
    public final Executor x;
    public String y;

    public class a implements T {
        public a() {
        }

        public final void a(zzafn zzafnVar, u uVar) {
            r.m(zzafnVar);
            r.m(uVar);
            uVar.P(zzafnVar);
            FirebaseAuth.this.r(uVar, zzafnVar, true);
        }
    }

    public class b implements s, T {
        public b() {
        }

        public final void a(zzafn zzafnVar, u uVar) {
            r.m(zzafnVar);
            r.m(uVar);
            uVar.P(zzafnVar);
            FirebaseAuth.this.s(uVar, zzafnVar, true, true);
        }

        public final void zza(Status status) {
            if (status.I() == 17011 || status.I() == 17021 || status.I() == 17005 || status.I() == 17091) {
                FirebaseAuth.this.k();
            }
        }
    }

    public FirebaseAuth(f fVar, zzaai zzaaiVar, N n, S s, t tVar, j6.b bVar, j6.b bVar2, Executor executor, Executor executor2, Executor executor3, Executor executor4) {
        zzafn c;
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
        this.h = new Object();
        this.j = new Object();
        this.m = RecaptchaAction.custom("getOobCode");
        this.n = RecaptchaAction.custom("signInWithPassword");
        this.o = RecaptchaAction.custom("signUpPassword");
        this.a = (f) r.m(fVar);
        this.e = (zzaai) r.m(zzaaiVar);
        N n2 = (N) r.m(n);
        this.p = n2;
        this.g = new H5.c();
        S s2 = (S) r.m(s);
        this.q = s2;
        this.r = (t) r.m(tVar);
        this.s = bVar;
        this.t = bVar2;
        this.v = executor2;
        this.w = executor3;
        this.x = executor4;
        u a2 = n2.a();
        this.f = a2;
        if (a2 != null && (c = n2.c(a2)) != null) {
            v(this, this.f, c, false, false);
        }
        s2.b(this);
    }

    public static /* bridge */ /* synthetic */ List E(FirebaseAuth firebaseAuth) {
        return firebaseAuth.d;
    }

    public static /* bridge */ /* synthetic */ List F(FirebaseAuth firebaseAuth) {
        return firebaseAuth.b;
    }

    public static /* bridge */ /* synthetic */ List H(FirebaseAuth firebaseAuth) {
        return firebaseAuth.c;
    }

    public static M I(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.u == null) {
            firebaseAuth.u = new M((f) r.m(firebaseAuth.a));
        }
        return firebaseAuth.u;
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) f.m().j(FirebaseAuth.class);
    }

    public static /* bridge */ /* synthetic */ f l(FirebaseAuth firebaseAuth) {
        return firebaseAuth.a;
    }

    public static void u(FirebaseAuth firebaseAuth, u uVar) {
        String str;
        if (uVar != null) {
            str = "Notifying auth state listeners about user ( " + uVar.L() + " ).";
        } else {
            str = "Notifying auth state listeners about a sign-out event.";
        }
        Log.d("FirebaseAuth", str);
        firebaseAuth.x.execute(new k0(firebaseAuth));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028 A[PHI: r2
      0x0028: PHI (r2v3 boolean) = (r2v0 boolean), (r2v1 boolean) binds: [B:11:0x0026, B:43:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void v(com.google.firebase.auth.FirebaseAuth r4, G5.u r5, com.google.android.gms.internal.firebase-auth-api.zzafn r6, boolean r7, boolean r8) {
        /*
            com.google.android.gms.common.internal.r.m(r5)
            com.google.android.gms.common.internal.r.m(r6)
            G5.u r0 = r4.f
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            java.lang.String r0 = r5.L()
            G5.u r3 = r4.f
            java.lang.String r3 = r3.L()
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            if (r0 != 0) goto L24
            if (r8 == 0) goto L24
            return
        L24:
            G5.u r8 = r4.f
            if (r8 != 0) goto L2a
        L28:
            r1 = 1
            goto L46
        L2a:
            com.google.android.gms.internal.firebase-auth-api.zzafn r8 = r8.S()
            java.lang.String r8 = r8.zzc()
            java.lang.String r3 = r6.zzc()
            boolean r8 = r8.equals(r3)
            r8 = r8 ^ r2
            if (r0 == 0) goto L41
            if (r8 != 0) goto L41
            r8 = 0
            goto L42
        L41:
            r8 = 1
        L42:
            r2 = r8
            if (r0 != 0) goto L46
            goto L28
        L46:
            com.google.android.gms.common.internal.r.m(r5)
            G5.u r8 = r4.f
            if (r8 == 0) goto L7e
            java.lang.String r8 = r5.L()
            java.lang.String r0 = r4.g()
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L5c
            goto L7e
        L5c:
            G5.u r8 = r4.f
            java.util.List r0 = r5.J()
            r8.O(r0)
            boolean r8 = r5.M()
            if (r8 != 0) goto L70
            G5.u r8 = r4.f
            r8.Q()
        L70:
            G5.z r8 = r5.I()
            java.util.List r8 = r8.a()
            G5.u r0 = r4.f
            r0.R(r8)
            goto L80
        L7e:
            r4.f = r5
        L80:
            if (r7 == 0) goto L89
            H5.N r8 = r4.p
            G5.u r0 = r4.f
            r8.f(r0)
        L89:
            if (r2 == 0) goto L97
            G5.u r8 = r4.f
            if (r8 == 0) goto L92
            r8.P(r6)
        L92:
            G5.u r8 = r4.f
            x(r4, r8)
        L97:
            if (r1 == 0) goto L9e
            G5.u r8 = r4.f
            u(r4, r8)
        L9e:
            if (r7 == 0) goto La5
            H5.N r7 = r4.p
            r7.d(r5, r6)
        La5:
            G5.u r5 = r4.f
            if (r5 == 0) goto Lb4
            H5.M r4 = I(r4)
            com.google.android.gms.internal.firebase-auth-api.zzafn r5 = r5.S()
            r4.d(r5)
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.v(com.google.firebase.auth.FirebaseAuth, G5.u, com.google.android.gms.internal.firebase-auth-api.zzafn, boolean, boolean):void");
    }

    public static void x(FirebaseAuth firebaseAuth, u uVar) {
        String str;
        if (uVar != null) {
            str = "Notifying id token listeners about user ( " + uVar.L() + " ).";
        } else {
            str = "Notifying id token listeners about a sign-out event.";
        }
        Log.d("FirebaseAuth", str);
        firebaseAuth.x.execute(new i0(firebaseAuth, new o6.b(uVar != null ? uVar.zzd() : null)));
    }

    public static /* bridge */ /* synthetic */ zzaai z(FirebaseAuth firebaseAuth) {
        return firebaseAuth.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [H5.Q, com.google.firebase.auth.FirebaseAuth$b] */
    /* JADX WARN: Type inference failed for: r9v0, types: [H5.Q, com.google.firebase.auth.FirebaseAuth$b] */
    public final Task A(u uVar, g gVar) {
        r.m(uVar);
        r.m(gVar);
        g J = gVar.J();
        if (!(J instanceof h)) {
            return J instanceof F ? this.e.zzb(this.a, uVar, (F) J, this.k, (Q) new b()) : this.e.zzc(this.a, uVar, J, uVar.K(), new b());
        }
        h hVar = (h) J;
        return "password".equals(hVar.I()) ? q(hVar.zzc(), r.g(hVar.zzd()), uVar.K(), uVar, true) : y(r.g(hVar.zze())) ? Tasks.forException(zzacf.zza(new Status(17072))) : m(hVar, uVar, true);
    }

    public final j6.b B() {
        return this.s;
    }

    public final j6.b C() {
        return this.t;
    }

    public final Executor D() {
        return this.v;
    }

    public final void G() {
        r.m(this.p);
        u uVar = this.f;
        if (uVar != null) {
            N n = this.p;
            r.m(uVar);
            n.e(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{uVar.L()}));
            this.f = null;
        }
        this.p.e("com.google.firebase.auth.FIREBASE_USER");
        x(this, null);
        u(this, null);
    }

    public Task a(boolean z) {
        return o(this.f, z);
    }

    public f b() {
        return this.a;
    }

    public u c() {
        return this.f;
    }

    public String d() {
        return this.y;
    }

    public String e() {
        String str;
        synchronized (this.h) {
            str = this.i;
        }
        return str;
    }

    public String f() {
        String str;
        synchronized (this.j) {
            str = this.k;
        }
        return str;
    }

    public String g() {
        u uVar = this.f;
        if (uVar == null) {
            return null;
        }
        return uVar.L();
    }

    public void h(String str) {
        r.g(str);
        synchronized (this.j) {
            this.k = str;
        }
    }

    public Task i() {
        u uVar = this.f;
        if (uVar == null || !uVar.M()) {
            return this.e.zza(this.a, new a(), this.k);
        }
        H5.b bVar = (H5.b) this.f;
        bVar.X(false);
        return Tasks.forResult(new d0(bVar));
    }

    public Task j(g gVar) {
        r.m(gVar);
        g J = gVar.J();
        if (J instanceof h) {
            h hVar = (h) J;
            return !hVar.M() ? q(hVar.zzc(), (String) r.m(hVar.zzd()), this.k, null, false) : y(r.g(hVar.zze())) ? Tasks.forException(zzacf.zza(new Status(17072))) : m(hVar, null, false);
        }
        if (J instanceof F) {
            return this.e.zza(this.a, (F) J, this.k, (T) new a());
        }
        return this.e.zza(this.a, J, this.k, new a());
    }

    public void k() {
        G();
        M m = this.u;
        if (m != null) {
            m.b();
        }
    }

    public final Task m(h hVar, u uVar, boolean z) {
        return new com.google.firebase.auth.b(this, z, uVar, hVar).c(this, this.k, this.m, "EMAIL_PASSWORD_PROVIDER");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [H5.Q, com.google.firebase.auth.FirebaseAuth$b] */
    public final Task n(u uVar, g gVar) {
        r.m(gVar);
        r.m(uVar);
        return gVar instanceof h ? new c(this, uVar, (h) gVar.J()).c(this, uVar.K(), this.o, "EMAIL_PASSWORD_PROVIDER") : this.e.zza(this.a, uVar, gVar.J(), (String) null, (Q) new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [G5.j0, H5.Q] */
    public final Task o(u uVar, boolean z) {
        if (uVar == null) {
            return Tasks.forException(zzacf.zza(new Status(17495)));
        }
        zzafn S = uVar.S();
        return (!S.zzg() || z) ? this.e.zza(this.a, uVar, S.zzd(), (Q) new j0(this)) : Tasks.forResult(v.a(S.zzc()));
    }

    public final Task p(String str) {
        return this.e.zza(this.k, str);
    }

    public final Task q(String str, String str2, String str3, u uVar, boolean z) {
        return new com.google.firebase.auth.a(this, str, z, uVar, str2, str3).c(this, str3, this.n, "EMAIL_PASSWORD_PROVIDER");
    }

    public final void r(u uVar, zzafn zzafnVar, boolean z) {
        s(uVar, zzafnVar, true, false);
    }

    public final void s(u uVar, zzafn zzafnVar, boolean z, boolean z2) {
        v(this, uVar, zzafnVar, true, z2);
    }

    public final synchronized void t(I i) {
        this.l = i;
    }

    public final synchronized I w() {
        return this.l;
    }

    public final boolean y(String str) {
        e b2 = e.b(str);
        return (b2 == null || TextUtils.equals(this.k, b2.c())) ? false : true;
    }

    public FirebaseAuth(f fVar, j6.b bVar, j6.b bVar2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        this(fVar, new zzaai(fVar, executor2, scheduledExecutorService), new N(fVar.l(), fVar.q()), S.c(), t.a(), bVar, bVar2, executor, executor2, executor3, executor4);
    }

    @Keep
    public static FirebaseAuth getInstance(f fVar) {
        return (FirebaseAuth) fVar.j(FirebaseAuth.class);
    }
}
