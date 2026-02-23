package com.onesignal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.onesignal.F1;
import com.onesignal.M0;
import com.onesignal.p1;
import com.onesignal.s0;
import com.onesignal.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class B0 extends q0 implements s0.c, p1.c {
    public static final Object u = new Object();
    public static ArrayList v = new g();
    public final P0 a;
    public final q1 b;
    public final Q7.a c;
    public p1 d;
    public M0 e;
    public x1 f;
    public final Set h;
    public final Set i;
    public final Set j;
    public final Set k;
    public final ArrayList l;
    public Date t;
    public List m = null;
    public I0 n = null;
    public boolean o = true;
    public boolean p = false;
    public String q = "";
    public A0 r = null;
    public boolean s = false;
    public ArrayList g = new ArrayList();

    public class a implements M0.i {
        public final /* synthetic */ String a;
        public final /* synthetic */ D0 b;

        public a(String str, D0 d0) {
            this.a = str;
            this.b = d0;
        }

        public void a(String str) {
            B0.j(B0.this).remove(this.a);
            this.b.m(this.a);
        }

        public void onSuccess(String str) {
        }
    }

    public class b extends com.onesignal.k {
        public final /* synthetic */ D0 a;

        public b(D0 d0) {
            this.a = d0;
        }

        public void run() {
            super.run();
            B0.t(B0.this).A(this.a);
            B0.t(B0.this).B(B0.this.t);
        }
    }

    public class c implements F1.w {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ D0 b;

        public c(boolean z, D0 d0) {
            this.a = z;
            this.b = d0;
        }

        public void a(JSONObject jSONObject) {
            B0.l(B0.this, false);
            if (jSONObject != null) {
                B0.m(B0.this, jSONObject.toString());
            }
            if (B0.n(B0.this) != null) {
                if (!this.a) {
                    F1.r0().k(this.b.a);
                }
                A0 n = B0.n(B0.this);
                B0 b0 = B0.this;
                n.h(b0.t0(B0.n(b0).a()));
                v2.I(this.b, B0.n(B0.this));
                B0.o(B0.this, null);
            }
        }
    }

    public class d implements M0.i {
        public final /* synthetic */ D0 a;

        public d(D0 d0) {
            this.a = d0;
        }

        public void a(String str) {
            B0.q(B0.this, false);
            try {
                if (new JSONObject(str).getBoolean("retry")) {
                    B0.r(B0.this, this.a);
                } else {
                    B0.this.Y(this.a, true);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onSuccess(String str) {
            try {
                A0 p = B0.p(B0.this, new JSONObject(str), this.a);
                if (p.a() == null) {
                    B0.u(B0.this).debug("displayMessage:OnSuccess: No HTML retrieved from loadMessageContent");
                    return;
                }
                if (B0.k(B0.this)) {
                    B0.o(B0.this, p);
                    return;
                }
                F1.r0().k(this.a.a);
                B0.this.f0(this.a);
                p.h(B0.this.t0(p.a()));
                v2.I(this.a, p);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements M0.i {
        public final /* synthetic */ D0 a;

        public e(D0 d0) {
            this.a = d0;
        }

        public void a(String str) {
            B0.s(B0.this, null);
        }

        public void onSuccess(String str) {
            try {
                A0 p = B0.p(B0.this, new JSONObject(str), this.a);
                if (p.a() == null) {
                    B0.u(B0.this).debug("displayPreviewMessage:OnSuccess: No HTML retrieved from loadMessageContent");
                } else {
                    if (B0.k(B0.this)) {
                        B0.o(B0.this, p);
                        return;
                    }
                    B0.this.f0(this.a);
                    p.h(B0.this.t0(p.a()));
                    v2.I(this.a, p);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class f extends com.onesignal.k {
        public f() {
        }

        public void run() {
            super.run();
            B0.t(B0.this).h();
        }
    }

    public class g extends ArrayList {
        public g() {
            add("android");
            add("app");
            add("all");
        }
    }

    public class h extends com.onesignal.k {
        public h() {
        }

        public void run() {
            super.run();
            synchronized (B0.e()) {
                B0 b0 = B0.this;
                B0.h(b0, B0.t(b0).k());
                B0.u(B0.this).debug("Retrieved IAMs from DB redisplayedInAppMessages: " + B0.f(B0.this).toString());
            }
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ JSONArray a;

        public i(JSONArray jSONArray) {
            this.a = jSONArray;
        }

        public void run() {
            B0.v(B0.this);
            try {
                B0.w(B0.this, this.a);
            } catch (JSONException e) {
                B0.u(B0.this).error("ERROR processing InAppMessageJson JSON Response.", e);
            }
        }
    }

    public class j implements Runnable {
        public j() {
        }

        public void run() {
            B0.u(B0.this).debug("Delaying evaluateInAppMessages due to redisplay data not retrieved yet");
            B0.x(B0.this);
        }
    }

    public class k implements M0.i {
        public final /* synthetic */ D0 a;

        public k(D0 d0) {
            this.a = d0;
        }

        public void a(String str) {
            B0.y(B0.this).remove(this.a.a);
        }

        public void onSuccess(String str) {
        }
    }

    public class l implements F1.x {
        public final /* synthetic */ D0 a;
        public final /* synthetic */ List b;

        public l(D0 d0, List list) {
            this.a = d0;
            this.b = list;
        }

        public void a(F1.z zVar) {
            B0.z(B0.this, null);
            B0.u(B0.this).debug("IAM prompt to handle finished with result: " + zVar);
            D0 d0 = this.a;
            if (d0.k && zVar == F1.z.LOCATION_PERMISSIONS_MISSING_MANIFEST) {
                B0.A(B0.this, d0, this.b);
            } else {
                B0.g(B0.this, d0, this.b);
            }
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public final /* synthetic */ D0 a;
        public final /* synthetic */ List c;

        public m(D0 d0, List list) {
            this.a = d0;
            this.c = list;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            B0.g(B0.this, this.a, this.c);
        }
    }

    public class n implements M0.i {
        public final /* synthetic */ String a;

        public n(String str) {
            this.a = str;
        }

        public void a(String str) {
            B0.i(B0.this).remove(this.a);
        }

        public void onSuccess(String str) {
        }
    }

    public B0(M1 m1, q1 q1Var, P0 p0, l1 l1Var, Q7.a aVar) {
        this.t = null;
        this.b = q1Var;
        Set K = OSUtils.K();
        this.h = K;
        this.l = new ArrayList();
        Set K2 = OSUtils.K();
        this.i = K2;
        Set K3 = OSUtils.K();
        this.j = K3;
        Set K4 = OSUtils.K();
        this.k = K4;
        this.f = new x1(this);
        this.d = new p1(this);
        this.c = aVar;
        this.a = p0;
        M0 P = P(m1, p0, l1Var);
        this.e = P;
        Set m2 = P.m();
        if (m2 != null) {
            K.addAll(m2);
        }
        Set p = this.e.p();
        if (p != null) {
            K2.addAll(p);
        }
        Set s = this.e.s();
        if (s != null) {
            K3.addAll(s);
        }
        Set l2 = this.e.l();
        if (l2 != null) {
            K4.addAll(l2);
        }
        Date q = this.e.q();
        if (q != null) {
            this.t = q;
        }
        S();
    }

    public static /* synthetic */ void A(B0 b0, D0 d0, List list) {
        b0.r0(d0, list);
    }

    public static /* synthetic */ Object e() {
        return u;
    }

    public static /* synthetic */ List f(B0 b0) {
        return b0.m;
    }

    public static /* synthetic */ void g(B0 b0, D0 d0, List list) {
        b0.s0(d0, list);
    }

    public static /* synthetic */ List h(B0 b0, List list) {
        b0.m = list;
        return list;
    }

    public static /* synthetic */ Set i(B0 b0) {
        return b0.j;
    }

    public static /* synthetic */ Set j(B0 b0) {
        return b0.k;
    }

    public static /* synthetic */ boolean k(B0 b0) {
        return b0.s;
    }

    public static /* synthetic */ boolean l(B0 b0, boolean z) {
        b0.s = z;
        return z;
    }

    public static /* synthetic */ String m(B0 b0, String str) {
        b0.q = str;
        return str;
    }

    public static /* synthetic */ A0 n(B0 b0) {
        return b0.r;
    }

    public static /* synthetic */ A0 o(B0 b0, A0 a0) {
        b0.r = a0;
        return a0;
    }

    public static /* synthetic */ A0 p(B0 b0, JSONObject jSONObject, D0 d0) {
        return b0.h0(jSONObject, d0);
    }

    public static /* synthetic */ boolean q(B0 b0, boolean z) {
        b0.p = z;
        return z;
    }

    public static /* synthetic */ void r(B0 b0, D0 d0) {
        b0.k0(d0);
    }

    public static /* synthetic */ void s(B0 b0, D0 d0) {
        b0.E(d0);
    }

    public static /* synthetic */ M0 t(B0 b0) {
        return b0.e;
    }

    public static /* synthetic */ P0 u(B0 b0) {
        return b0.a;
    }

    public static /* synthetic */ void v(B0 b0) {
        b0.m0();
    }

    public static /* synthetic */ void w(B0 b0, JSONArray jSONArray) {
        b0.j0(jSONArray);
    }

    public static /* synthetic */ void x(B0 b0) {
        b0.H();
    }

    public static /* synthetic */ Set y(B0 b0) {
        return b0.i;
    }

    public static /* synthetic */ I0 z(B0 b0, I0 i0) {
        b0.n = i0;
        return i0;
    }

    public final void B() {
        synchronized (this.l) {
            try {
                if (!this.d.c()) {
                    this.a.a("In app message not showing due to system condition not correct");
                    return;
                }
                this.a.debug("displayFirstIAMOnQueue: " + this.l);
                if (this.l.size() > 0 && !U()) {
                    this.a.debug("No IAM showing currently, showing first item in the queue!");
                    F((D0) this.l.get(0));
                    return;
                }
                this.a.debug("In app message is currently showing or there are no IAMs left in the queue! isInAppMessageShowing: " + U());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void C(D0 d0, List list) {
        if (list.size() > 0) {
            this.a.debug("IAM showing prompts from IAM: " + d0.toString());
            v2.x();
            s0(d0, list);
        }
    }

    public void D() {
        d(new f(), "OS_IAM_DB_ACCESS");
    }

    public final void E(D0 d0) {
        F1.r0().i();
        if (q0()) {
            this.a.debug("Stop evaluateMessageDisplayQueue because prompt is currently displayed");
            return;
        }
        this.p = false;
        synchronized (this.l) {
            if (d0 != null) {
                try {
                    if (!d0.k && this.l.size() > 0) {
                        if (!this.l.contains(d0)) {
                            this.a.debug("Message already removed from the queue!");
                            return;
                        }
                        String str = ((D0) this.l.remove(0)).a;
                        this.a.debug("In app message with id: " + str + ", dismissed (removed) from the queue!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.l.size() > 0) {
                this.a.debug("In app message on queue available: " + ((D0) this.l.get(0)).a);
                F((D0) this.l.get(0));
            } else {
                this.a.debug("In app message dismissed evaluating messages");
                H();
            }
        }
    }

    public final void F(D0 d0) {
        if (!this.o) {
            this.a.verbose("In app messaging is currently paused, in app messages will not be shown!");
            return;
        }
        this.p = true;
        Q(d0, false);
        this.e.n(F1.d, d0.a, u0(d0), new d(d0));
    }

    public void G(String str) {
        this.p = true;
        D0 d0 = new D0(true);
        Q(d0, true);
        this.e.o(F1.d, str, new e(d0));
    }

    public final void H() {
        this.a.debug("Starting evaluateInAppMessages");
        if (p0()) {
            this.b.c(new j());
            return;
        }
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            D0 d0 = (D0) it.next();
            if (this.f.b(d0)) {
                o0(d0);
                if (!this.h.contains(d0.a) && !d0.h()) {
                    k0(d0);
                }
            }
        }
    }

    public void I(Runnable runnable) {
        synchronized (u) {
            try {
                if (p0()) {
                    this.a.debug("Delaying task due to redisplay data not retrieved yet");
                    this.b.c(runnable);
                } else {
                    runnable.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void J(z0 z0Var) {
        if (z0Var.b() == null || z0Var.b().isEmpty()) {
            return;
        }
        if (z0Var.f() == z0.a.BROWSER) {
            OSUtils.N(z0Var.b());
        } else if (z0Var.f() == z0.a.IN_APP_WEBVIEW) {
            K1.b(z0Var.b(), true);
        }
    }

    public final void K(String str, List list) {
        F1.r0().h(str);
        F1.w1(list);
    }

    public final void L(String str, z0 z0Var) {
        List list = F1.a;
    }

    public final void M(D0 d0, z0 z0Var) {
        String u0 = u0(d0);
        if (u0 == null) {
            return;
        }
        String a2 = z0Var.a();
        if (!(d0.e().e() && d0.f(a2)) && this.k.contains(a2)) {
            return;
        }
        this.k.add(a2);
        d0.a(a2);
        this.e.D(F1.d, F1.y0(), u0, new OSUtils().e(), d0.a, a2, z0Var.g(), this.k, new a(a2, d0));
    }

    public final void N(D0 d0, G0 g0) {
        String u0 = u0(d0);
        if (u0 == null) {
            return;
        }
        String a2 = g0.a();
        String str = d0.a + a2;
        if (!this.j.contains(str)) {
            this.j.add(str);
            this.e.F(F1.d, F1.y0(), u0, new OSUtils().e(), d0.a, a2, this.j, new n(str));
            return;
        }
        this.a.verbose("Already sent page impression for id: " + a2);
    }

    public final void O(z0 z0Var) {
        if (z0Var.e() != null) {
            N0 e2 = z0Var.e();
            if (e2.a() != null) {
                F1.y1(e2.a());
            }
            if (e2.b() != null) {
                F1.E(e2.b(), null);
            }
        }
    }

    public M0 P(M1 m1, P0 p0, l1 l1Var) {
        if (this.e == null) {
            this.e = new M0(m1, p0, l1Var);
        }
        return this.e;
    }

    public final void Q(D0 d0, boolean z) {
        this.s = false;
        if (z || d0.d()) {
            this.s = true;
            F1.u0(new c(z, d0));
        }
    }

    public final boolean R(D0 d0) {
        if (this.f.e(d0)) {
            return !d0.g();
        }
        return d0.i() || (!d0.g() && d0.c.isEmpty());
    }

    public void S() {
        this.b.c(new h());
        this.b.f();
    }

    public void T() {
        if (!this.g.isEmpty()) {
            this.a.debug("initWithCachedInAppMessages with already in memory messages: " + this.g);
            return;
        }
        String r = this.e.r();
        this.a.debug("initWithCachedInAppMessages: " + r);
        if (r == null || r.isEmpty()) {
            return;
        }
        synchronized (u) {
            try {
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (this.g.isEmpty()) {
                j0(new JSONArray(r));
            }
        }
    }

    public boolean U() {
        return this.p;
    }

    public final void V(z0 z0Var) {
        if (z0Var.e() != null) {
            this.a.debug("Tags detected inside of the action click payload, ignoring because action came from IAM preview:: " + z0Var.e().toString());
        }
        if (z0Var.c().size() > 0) {
            this.a.debug("Outcomes detected inside of the action click payload, ignoring because action came from IAM preview: " + z0Var.c().toString());
        }
    }

    public final void W(Collection collection) {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            D0 d0 = (D0) it.next();
            if (!d0.i() && this.m.contains(d0) && this.f.d(d0, collection)) {
                this.a.debug("Trigger changed for message: " + d0.toString());
                d0.p(true);
            }
        }
    }

    public void X(D0 d0) {
        Y(d0, false);
    }

    public void Y(D0 d0, boolean z) {
        if (!d0.k) {
            this.h.add(d0.a);
            if (!z) {
                this.e.x(this.h);
                this.t = new Date();
                i0(d0);
            }
            this.a.debug("OSInAppMessageController messageWasDismissed dismissedMessages: " + this.h.toString());
        }
        if (!q0()) {
            b0(d0);
        }
        E(d0);
    }

    public void Z(D0 d0, JSONObject jSONObject) {
        z0 z0Var = new z0(jSONObject);
        z0Var.j(d0.q());
        L(d0.a, z0Var);
        C(d0, z0Var.d());
        J(z0Var);
        M(d0, z0Var);
        O(z0Var);
        K(d0.a, z0Var.c());
    }

    public void a() {
        B();
    }

    public void a0(D0 d0, JSONObject jSONObject) {
        z0 z0Var = new z0(jSONObject);
        z0Var.j(d0.q());
        L(d0.a, z0Var);
        C(d0, z0Var.d());
        J(z0Var);
        V(z0Var);
    }

    public void b() {
        this.a.debug("messageTriggerConditionChanged called");
        H();
    }

    public void b0(D0 d0) {
        this.a.verbose("OSInAppMessageController onMessageDidDismiss: inAppMessageLifecycleHandler is null");
    }

    public void c(String str) {
        this.a.debug("messageDynamicTriggerCompleted called with triggerId: " + str);
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        W(hashSet);
    }

    public void c0(D0 d0) {
        this.a.verbose("OSInAppMessageController onMessageDidDisplay: inAppMessageLifecycleHandler is null");
    }

    public void d0(D0 d0) {
        c0(d0);
        if (d0.k || this.i.contains(d0.a)) {
            return;
        }
        this.i.add(d0.a);
        String u0 = u0(d0);
        if (u0 == null) {
            return;
        }
        this.e.E(F1.d, F1.y0(), u0, new OSUtils().e(), d0.a, this.i, new k(d0));
    }

    public void e0(D0 d0) {
        this.a.verbose("OSInAppMessageController onMessageWillDismiss: inAppMessageLifecycleHandler is null");
    }

    public void f0(D0 d0) {
        this.a.verbose("OSInAppMessageController onMessageWillDisplay: inAppMessageLifecycleHandler is null");
    }

    public void g0(D0 d0, JSONObject jSONObject) {
        G0 g0 = new G0(jSONObject);
        if (d0.k) {
            return;
        }
        N(d0, g0);
    }

    public final A0 h0(JSONObject jSONObject, D0 d0) {
        A0 a0 = new A0(jSONObject);
        d0.n(a0.b().doubleValue());
        return a0;
    }

    public final void i0(D0 d0) {
        d0.e().h(F1.v0().a() / 1000);
        d0.e().c();
        d0.p(false);
        d0.o(true);
        d(new b(d0), "OS_IAM_DB_ACCESS");
        int indexOf = this.m.indexOf(d0);
        if (indexOf != -1) {
            this.m.set(indexOf, d0);
        } else {
            this.m.add(d0);
        }
        this.a.debug("persistInAppMessageForRedisplay: " + d0.toString() + " with msg array data: " + this.m.toString());
    }

    public final void j0(JSONArray jSONArray) {
        synchronized (u) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    D0 d0 = new D0(jSONArray.getJSONObject(i2));
                    if (d0.a != null) {
                        arrayList.add(d0);
                    }
                }
                this.g = arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
        H();
    }

    public final void k0(D0 d0) {
        synchronized (this.l) {
            try {
                if (!this.l.contains(d0)) {
                    this.l.add(d0);
                    this.a.debug("In app message with id: " + d0.a + ", added to the queue");
                }
                B();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void l0(JSONArray jSONArray) {
        this.e.y(jSONArray.toString());
        I(new i(jSONArray));
    }

    public final void m0() {
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((D0) it.next()).o(false);
        }
    }

    public void n0() {
        s0.e();
    }

    public final void o0(D0 d0) {
        boolean contains = this.h.contains(d0.a);
        int indexOf = this.m.indexOf(d0);
        if (!contains || indexOf == -1) {
            return;
        }
        D0 d02 = (D0) this.m.get(indexOf);
        d0.e().g(d02.e());
        d0.o(d02.g());
        boolean R = R(d0);
        this.a.debug("setDataForRedisplay: " + d0.toString() + " triggerHasChanged: " + R);
        if (R && d0.e().d() && d0.e().i()) {
            this.a.debug("setDataForRedisplay message available for redisplay: " + d0.a);
            this.h.remove(d0.a);
            this.i.remove(d0.a);
            this.j.clear();
            this.e.C(this.j);
            d0.b();
        }
    }

    public boolean p0() {
        boolean z;
        synchronized (u) {
            try {
                z = this.m == null && this.b.e();
            } finally {
            }
        }
        return z;
    }

    public final boolean q0() {
        return this.n != null;
    }

    public final void r0(D0 d0, List list) {
        String string = F1.b.getString(g2.b);
        new AlertDialog.Builder(F1.P()).setTitle(string).setMessage(F1.b.getString(g2.a)).setPositiveButton(17039370, new m(d0, list)).show();
    }

    public final void s0(D0 d0, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            I0 i0 = (I0) it.next();
            if (!i0.c()) {
                this.n = i0;
                break;
            }
        }
        if (this.n == null) {
            this.a.debug("No IAM prompt to handle, dismiss message: " + d0.a);
            X(d0);
            return;
        }
        this.a.debug("IAM prompt to handle: " + this.n.toString());
        this.n.d(true);
        this.n.b(new l(d0, list));
    }

    public String t0(String str) {
        return str + String.format("\n\n<script>\n    setPlayerTags(%s);\n</script>", new Object[]{this.q});
    }

    public final String u0(D0 d0) {
        String b2 = this.c.b();
        Iterator it = v.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (d0.b.containsKey(str)) {
                HashMap hashMap = (HashMap) d0.b.get(str);
                if (!hashMap.containsKey(b2)) {
                    b2 = "default";
                }
                return (String) hashMap.get(b2);
            }
        }
        return null;
    }
}
