package com.onesignal;

import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.F1;
import com.onesignal.O;
import com.onesignal.T1;
import com.onesignal.W1;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class u2 {
    public W1.c b;
    public boolean c;
    public m2 k;
    public m2 l;
    public final Object a = new Object();
    public AtomicBoolean d = new AtomicBoolean();
    public final Queue e = new LinkedBlockingQueue();
    public final Queue f = new LinkedBlockingQueue();
    public final Queue g = new LinkedBlockingQueue();
    public HashMap h = new HashMap();
    public final Object i = new a();
    public boolean j = false;

    public class a {
        public a() {
        }
    }

    public class b extends T1.g {
        public b() {
        }

        public void a(int i, String str, Throwable th) {
            F1.a(F1.v.WARN, "Failed last request. statusCode: " + i + "\nresponse: " + str);
            if (u2.g(u2.this, i, str, "already logged out of email")) {
                u2.h(u2.this);
            } else if (u2.g(u2.this, i, str, "not a valid device_type")) {
                u2.i(u2.this);
            } else {
                u2.j(u2.this, i);
            }
        }

        public void b(String str) {
            u2.h(u2.this);
        }
    }

    public class c extends T1.g {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ JSONObject b;

        public c(JSONObject jSONObject, JSONObject jSONObject2) {
            this.a = jSONObject;
            this.b = jSONObject2;
        }

        public void a(int i, String str, Throwable th) {
            F1.v vVar = F1.v.ERROR;
            F1.a(vVar, "Failed PUT sync request with status code: " + i + " and response: " + str);
            synchronized (u2.this.a) {
                try {
                    if (u2.g(u2.this, i, str, "No user with this id found")) {
                        u2.i(u2.this);
                    } else {
                        u2.j(u2.this, i);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.a.has("tags")) {
                u2.k(u2.this, new F1.B(i, str));
            }
            if (this.a.has("external_user_id")) {
                F1.c1(vVar, "Error setting external user id for push with status code: " + i + " and message: " + str);
                u2.l(u2.this);
            }
            if (this.a.has("language")) {
                u2.m(u2.this, new W1.b(i, str));
            }
        }

        public void b(String str) {
            synchronized (u2.this.a) {
                u2.this.z().r(this.b, this.a);
                u2.this.O(this.a);
            }
            if (this.a.has("tags")) {
                u2.c(u2.this);
            }
            if (this.a.has("external_user_id")) {
                u2.d(u2.this);
            }
            if (this.a.has("language")) {
                u2.e(u2.this);
            }
        }
    }

    public class d extends T1.g {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;

        public d(JSONObject jSONObject, JSONObject jSONObject2, String str) {
            this.a = jSONObject;
            this.b = jSONObject2;
            this.c = str;
        }

        public void a(int i, String str, Throwable th) {
            synchronized (u2.this.a) {
                try {
                    u2.this.j = false;
                    F1.a(F1.v.WARN, "Failed last request. statusCode: " + i + "\nresponse: " + str);
                    if (u2.g(u2.this, i, str, "not a valid device_type")) {
                        u2.i(u2.this);
                    } else {
                        u2.j(u2.this, i);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void b(String str) {
            synchronized (u2.this.a) {
                try {
                    u2 u2Var = u2.this;
                    u2Var.j = false;
                    u2Var.z().r(this.a, this.b);
                    try {
                        F1.c1(F1.v.DEBUG, "doCreateOrNewSession:response: " + str);
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("id")) {
                            String optString = jSONObject.optString("id");
                            u2.this.c0(optString);
                            F1.a(F1.v.INFO, "Device registered, UserId = " + optString);
                        } else {
                            F1.a(F1.v.INFO, "session sent, UserId = " + this.c);
                        }
                        u2.this.G().s("session", Boolean.FALSE);
                        u2.this.G().q();
                        if (jSONObject.has("in_app_messages")) {
                            F1.b0().l0(jSONObject.getJSONArray("in_app_messages"));
                        }
                        u2.this.O(this.b);
                    } catch (JSONException e) {
                        F1.b(F1.v.ERROR, "ERROR parsing on_session or create JSON Response.", e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class e {
        public boolean a;
        public JSONObject b;

        public e(boolean z, JSONObject jSONObject) {
            this.a = z;
            this.b = jSONObject;
        }
    }

    public class f extends HandlerThread {
        public int a;
        public Handler c;
        public int d;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                if (!u2.f(u2.this).get()) {
                    u2.this.a0(false);
                }
            }
        }

        public f(int i) {
            super("OSH_NetworkHandlerThread_" + u2.a(u2.this));
            this.a = i;
            start();
            this.c = new Handler(getLooper());
        }

        public boolean a() {
            boolean hasMessages;
            synchronized (this.c) {
                try {
                    boolean z = this.d < 3;
                    boolean hasMessages2 = this.c.hasMessages(0);
                    if (z && !hasMessages2) {
                        this.d++;
                        this.c.postDelayed(b(), this.d * 15000);
                    }
                    hasMessages = this.c.hasMessages(0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return hasMessages;
        }

        public final Runnable b() {
            if (this.a != 0) {
                return null;
            }
            return new a();
        }

        public void c() {
            if (u2.b(u2.this)) {
                synchronized (this.c) {
                    this.d = 0;
                    this.c.removeCallbacksAndMessages((Object) null);
                    this.c.postDelayed(b(), 5000L);
                }
            }
        }
    }

    public u2(W1.c cVar) {
        this.b = cVar;
    }

    public static /* synthetic */ W1.c a(u2 u2Var) {
        return u2Var.b;
    }

    public static /* synthetic */ boolean b(u2 u2Var) {
        return u2Var.c;
    }

    public static /* synthetic */ void c(u2 u2Var) {
        u2Var.X();
    }

    public static /* synthetic */ void d(u2 u2Var) {
        u2Var.v();
    }

    public static /* synthetic */ void e(u2 u2Var) {
        u2Var.q();
    }

    public static /* synthetic */ AtomicBoolean f(u2 u2Var) {
        return u2Var.d;
    }

    public static /* synthetic */ boolean g(u2 u2Var, int i, String str, String str2) {
        return u2Var.S(i, str, str2);
    }

    public static /* synthetic */ void h(u2 u2Var) {
        u2Var.M();
    }

    public static /* synthetic */ void i(u2 u2Var) {
        u2Var.I();
    }

    public static /* synthetic */ void j(u2 u2Var, int i) {
        u2Var.H(i);
    }

    public static /* synthetic */ void k(u2 u2Var, F1.B b2) {
        u2Var.W(b2);
    }

    public static /* synthetic */ void l(u2 u2Var) {
        u2Var.u();
    }

    public static /* synthetic */ void m(u2 u2Var, W1.b bVar) {
        u2Var.p(bVar);
    }

    public abstract String A();

    public abstract F1.v B();

    public f C(Integer num) {
        f fVar;
        synchronized (this.i) {
            try {
                if (!this.h.containsKey(num)) {
                    this.h.put(num, new f(num.intValue()));
                }
                fVar = (f) this.h.get(num);
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public String D() {
        return F().l().g("identifier", null);
    }

    public boolean E() {
        return G().i().b("session");
    }

    public m2 F() {
        if (this.l == null) {
            synchronized (this.a) {
                try {
                    if (this.l == null) {
                        this.l = N("TOSYNC_STATE", true);
                    }
                } finally {
                }
            }
        }
        return this.l;
    }

    public m2 G() {
        if (this.l == null) {
            this.l = z().c("TOSYNC_STATE");
        }
        T();
        return this.l;
    }

    public final void H(int i) {
        if (i == 403) {
            F1.a(F1.v.FATAL, "403 error updating player, omitting further retries!");
            x();
        } else {
            if (C(0).a()) {
                return;
            }
            x();
        }
    }

    public final void I() {
        F1.a(F1.v.WARN, "Creating new player based on missing player_id noted above.");
        F1.F0();
        R();
        c0(null);
        T();
    }

    public void J() {
        if (this.k == null) {
            synchronized (this.a) {
                try {
                    if (this.k == null) {
                        this.k = N("CURRENT_STATE", true);
                    }
                } finally {
                }
            }
        }
        F();
    }

    public final void K(boolean z) {
        String A = A();
        if (Z() && A != null) {
            s(A);
            return;
        }
        if (this.k == null) {
            J();
        }
        boolean z2 = !z && L();
        synchronized (this.a) {
            try {
                JSONObject d2 = z().d(F(), z2);
                JSONObject f2 = z().f(F(), null);
                F1.c1(F1.v.DEBUG, "UserStateSynchronizer internalSyncUserState from session call: " + z2 + " jsonBody: " + d2);
                if (d2 == null) {
                    z().r(f2, null);
                    X();
                    v();
                    q();
                    return;
                }
                F().q();
                if (z2) {
                    r(A, d2, f2);
                } else {
                    t(A, d2, f2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean L() {
        return (F().i().b("session") || A() == null) && !this.j;
    }

    public final void M() {
        F().v("logoutEmail");
        this.l.v("email_auth_hash");
        this.l.w("parent_player_id");
        this.l.w("email");
        this.l.q();
        z().v("email_auth_hash");
        z().w("parent_player_id");
        String f2 = z().l().f("email");
        z().w("email");
        W1.s();
        F1.a(F1.v.INFO, "Device successfully logged out of email: " + f2);
        F1.F0();
    }

    public abstract m2 N(String str, boolean z);

    public abstract void O(JSONObject jSONObject);

    public boolean P() {
        boolean z;
        if (this.l == null) {
            return false;
        }
        synchronized (this.a) {
            z = z().d(this.l, L()) != null;
            this.l.q();
        }
        return z;
    }

    public void Q(boolean z) {
        boolean z2 = this.c != z;
        this.c = z;
        if (z2 && z) {
            T();
        }
    }

    public void R() {
        z().z(new JSONObject());
        z().q();
    }

    public final boolean S(int i, String str, String str2) {
        if (i == 400 && str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("errors")) {
                    return jSONObject.optString("errors").contains(str2);
                }
                return false;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public abstract void T();

    public void U(JSONObject jSONObject, T1.g gVar) {
        T1.j("players/" + A() + "/on_purchase", jSONObject, gVar);
    }

    public void V(JSONObject jSONObject, F1.s sVar) {
        if (sVar != null) {
            this.e.add(sVar);
        }
        G().h(jSONObject, null);
    }

    public final void W(F1.B b2) {
        d.D.a(this.e.poll());
    }

    public final void X() {
        JSONObject jSONObject = W1.h(false).b;
        d.D.a(this.e.poll());
    }

    public void Y() {
        try {
            synchronized (this.a) {
                G().s("session", Boolean.TRUE);
                G().q();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final boolean Z() {
        return F().i().c("logoutEmail", false);
    }

    public void a0(boolean z) {
        this.d.set(true);
        K(z);
        this.d.set(false);
    }

    public void b0(JSONObject jSONObject, W1.a aVar) {
        if (aVar != null) {
            this.g.add(aVar);
        }
        G().h(jSONObject, null);
    }

    public abstract void c0(String str);

    public void d0(O.d dVar) {
        G().y(dVar);
    }

    public abstract void n(JSONObject jSONObject);

    public void o() {
        F().b();
        F().q();
    }

    public final void p(W1.b bVar) {
        d.D.a(this.g.poll());
    }

    public final void q() {
        W1.c();
        d.D.a(this.g.poll());
    }

    public final void r(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        String str2;
        if (str == null) {
            str2 = "players";
        } else {
            str2 = "players/" + str + "/on_session";
        }
        this.j = true;
        n(jSONObject);
        T1.k(str2, jSONObject, new d(jSONObject2, jSONObject, str));
    }

    public final void s(String str) {
        String str2 = "players/" + str + "/email_logout";
        JSONObject jSONObject = new JSONObject();
        try {
            E i = z().i();
            if (i.a("email_auth_hash")) {
                jSONObject.put("email_auth_hash", i.f("email_auth_hash"));
            }
            E l = z().l();
            if (l.a("parent_player_id")) {
                jSONObject.put("parent_player_id", l.f("parent_player_id"));
            }
            jSONObject.put("app_id", l.f("app_id"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        T1.k(str2, jSONObject, new b());
    }

    public final void t(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (str == null) {
            F1.c1(B(), "Error updating the user record because of the null user id");
            W(new F1.B(-1, "Unable to update tags: the current user is not registered with OneSignal"));
            u();
            p(new W1.b(-1, "Unable to set Language: the current user is not registered with OneSignal"));
            return;
        }
        T1.m("players/" + str, jSONObject, new c(jSONObject, jSONObject2));
    }

    public final void u() {
        d.D.a(this.f.poll());
    }

    public final void v() {
        d.D.a(this.f.poll());
    }

    public abstract void w(JSONObject jSONObject);

    public final void x() {
        JSONObject d2 = z().d(this.l, false);
        if (d2 != null) {
            w(d2);
        }
        if (F().i().c("logoutEmail", false)) {
            F1.C0();
        }
    }

    public JSONObject y(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Set set) {
        JSONObject b2;
        synchronized (this.a) {
            b2 = H.b(jSONObject, jSONObject2, jSONObject3, set);
        }
        return b2;
    }

    public m2 z() {
        if (this.k == null) {
            synchronized (this.a) {
                try {
                    if (this.k == null) {
                        this.k = N("CURRENT_STATE", true);
                    }
                } finally {
                }
            }
        }
        return this.k;
    }
}
