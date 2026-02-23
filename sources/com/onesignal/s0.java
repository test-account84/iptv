package com.onesignal;

import android.content.Context;
import com.onesignal.F1;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class S0 {
    public final V0 a;
    public boolean b;
    public boolean c;

    public S0(Context context, Q0 q0, JSONObject jSONObject, boolean z, boolean z2, Long l) {
        this.b = z;
        this.c = z2;
        this.a = a(context, q0, jSONObject, l);
    }

    public static void h(Context context) {
        String f = OSUtils.f(context, "com.onesignal.NotificationServiceExtension");
        if (f == null) {
            F1.c1(F1.v.VERBOSE, "No class found, not setting up OSRemoteNotificationReceivedHandler");
            return;
        }
        F1.c1(F1.v.VERBOSE, "Found class: " + f + ", attempting to call constructor");
        try {
            Class.forName(f).newInstance();
        } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public final V0 a(Context context, Q0 q0, JSONObject jSONObject, Long l) {
        V0 v0 = new V0(context);
        v0.q(jSONObject);
        v0.z(l);
        v0.y(this.b);
        v0.r(q0);
        return v0;
    }

    public V0 b() {
        return this.a;
    }

    public a1 c() {
        return new a1(this, this.a.f());
    }

    public boolean d() {
        if (F1.j0().l()) {
            return this.a.f().h() + ((long) this.a.f().l()) > F1.v0().a() / 1000;
        }
        return true;
    }

    public final void e(Q0 q0) {
        this.a.r(q0);
        if (this.b) {
            T.e(this.a);
            return;
        }
        this.a.p(false);
        T.n(this.a, true, false);
        F1.E0(this.a);
    }

    public void f(Q0 q0, Q0 q02) {
        if (q02 == null) {
            e(q0);
            return;
        }
        boolean I = OSUtils.I(q02.e());
        boolean d = d();
        if (I && d) {
            this.a.r(q02);
            T.k(this, this.c);
        } else {
            e(q0);
        }
        if (this.b) {
            OSUtils.V(100);
        }
    }

    public void g(boolean z) {
        this.c = z;
    }

    public String toString() {
        return "OSNotificationController{notificationJob=" + this.a + ", isRestoring=" + this.b + ", isBackgroundLogic=" + this.c + '}';
    }

    public S0(V0 v0, boolean z, boolean z2) {
        this.b = z;
        this.c = z2;
        this.a = v0;
    }
}
