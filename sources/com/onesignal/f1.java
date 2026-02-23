package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.onesignal.O;
import com.onesignal.R0;
import com.onesignal.S1;
import com.onesignal.T0;
import com.onesignal.T1;
import com.onesignal.Y1;
import com.onesignal.b2;
import com.onesignal.k1;
import com.onesignal.u2;
import j$.time.ZoneId;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class F1 {
    public static l1 B;
    public static O7.e C;
    public static k1 D;
    public static d1 E;
    public static R7.c F;
    public static T0 G;
    public static final Object H;
    public static String I;
    public static String J;
    public static OSUtils K;
    public static boolean L;
    public static boolean M;
    public static boolean N;
    public static boolean O;
    public static boolean P;
    public static O.d Q;
    public static Collection R;
    public static HashSet S;
    public static final ArrayList T;
    public static com.onesignal.s U;
    public static e1 V;
    public static e1 W;
    public static b1 X;
    public static OSSubscriptionState Y;
    public static OSSubscriptionState Z;
    public static b1 a0;
    public static Context b;
    public static u0 b0;
    public static WeakReference c;
    public static u0 c0;
    public static String d;
    public static b1 d0;
    public static String e;
    public static i1 e0;
    public static i1 f0;
    public static b1 g0;
    public static u h0;
    public static Y1 i0;
    public static final List j0;
    public static boolean m;
    public static boolean n;
    public static l2 p;
    public static j2 q;
    public static k2 r;
    public static com.onesignal.u t;
    public static List a = new ArrayList();
    public static v f = v.NONE;
    public static v g = v.WARN;
    public static String h = null;
    public static String i = null;
    public static String j = null;
    public static int k = Integer.MAX_VALUE;
    public static Q7.a l = null;
    public static r o = r.APP_CLOSE;
    public static P0 s = new O0();
    public static k1.b u = new c();
    public static C0 v = new C0();
    public static t1 w = new u1();
    public static h1 x = new h1();
    public static q1 y = new q1(s);
    public static r1 z = new r1(x, s);
    public static G1 A = new U1();

    public interface A {
        void a(boolean z);
    }

    public static class B {
        public String a;
        public int b;

        public B(int i, String str) {
            this.a = str;
            this.b = i;
        }
    }

    public class a implements Runnable {
        public void run() {
            try {
                F1.j();
            } catch (JSONException e) {
                F1.b(v.FATAL, "FATAL Error registering device!", e);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ JSONObject a;

        public b(JSONObject jSONObject, s sVar) {
            this.a = jSONObject;
        }

        public void run() {
            F1.d().debug("Running sendTags() operation from pending task queue.");
            F1.z1(this.a, null);
        }
    }

    public class c implements k1.b {
        public void a(List list) {
            if (F1.c() == null) {
                F1.a(v.WARN, "OneSignal onSessionEnding called before init!");
            }
            if (F1.c() != null) {
                F1.c().e();
            }
            F1.a0().g(list);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ JSONObject a;

        public d(JSONObject jSONObject, s sVar) {
            this.a = jSONObject;
        }

        public void run() {
            if (this.a == null) {
                F1.d().error("Attempted to send null tags");
                return;
            }
            JSONObject jSONObject = W1.h(false).b;
            JSONObject jSONObject2 = new JSONObject();
            Iterator keys = this.a.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                try {
                    Object opt = this.a.opt(str);
                    if ((opt instanceof JSONArray) || (opt instanceof JSONObject)) {
                        F1.a(v.ERROR, "Omitting key '" + str + "'! sendTags DO NOT supported nested values!");
                    } else if (!this.a.isNull(str) && !"".equals(opt)) {
                        jSONObject2.put(str, opt.toString());
                    } else if (jSONObject != null && jSONObject.has(str)) {
                        jSONObject2.put(str, "");
                    }
                } catch (Throwable unused) {
                }
            }
            if (jSONObject2.toString().equals("{}")) {
                F1.d().debug("Send tags ended successfully");
                return;
            }
            F1.d().debug("Available tags to send: " + jSONObject2.toString());
            W1.q(jSONObject2, null);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ w a;

        public e(w wVar) {
            this.a = wVar;
        }

        public void run() {
            F1.d().debug("Running getTags() operation from pending queue.");
            F1.u0(this.a);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ w a;

        public f(w wVar) {
            this.a = wVar;
        }

        public void run() {
            synchronized (F1.k()) {
                try {
                    F1.k().add(this.a);
                    if (F1.k().size() > 1) {
                        return;
                    }
                    F1.l();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class g implements Runnable {
        public void run() {
            u2.e h = W1.h(!F1.m());
            if (h.a) {
                F1.n(true);
            }
            synchronized (F1.k()) {
                try {
                    Iterator it = F1.k().iterator();
                    while (it.hasNext()) {
                        ((w) it.next()).a((h.b == null || h.toString().equals("{}")) ? null : h.b);
                    }
                    F1.k().clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public class h extends T1.g {
        public void a(int i, String str, Throwable th) {
            F1.T0("sending Notification Opened Failed", i, th, str);
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ x a;
        public final /* synthetic */ boolean c;

        public i(x xVar, boolean z) {
            this.a = xVar;
            this.c = z;
        }

        public void run() {
            F1.d().debug("Running promptLocation() operation from pending queue.");
            F1.f1(this.a, this.c);
        }
    }

    public class j {
    }

    public class k extends O.e {
        public final /* synthetic */ x a;

        public k(x xVar) {
            this.a = xVar;
        }

        public void a(O.d dVar) {
            if (F1.I1("promptLocation()") || dVar == null) {
                return;
            }
            W1.w(dVar);
        }

        public void b(z zVar) {
            super.b(zVar);
            x xVar = this.a;
            if (xVar != null) {
                xVar.a(zVar);
            }
        }

        public O.f getType() {
            return O.f.PROMPT_LOCATION;
        }
    }

    public class l implements Runnable {
        public final /* synthetic */ int a;

        public l(int i) {
            this.a = i;
        }

        public void run() {
            F1.d().debug("Running removeNotification() operation from pending queue.");
            F1.n1(this.a);
        }
    }

    public class m implements O.b {
        public void a(O.d dVar) {
            F1.o(dVar);
            F1.p(true);
            F1.q();
        }

        public O.f getType() {
            return O.f.STARTUP;
        }
    }

    public class n implements Y1.a {
        public void a(String str, int i) {
            F1.d().debug("registerForPushToken completed with id: " + str + " status: " + i);
            if (i >= 1 ? F1.t(F1.r()) : !(W1.e() != null || (F1.r() != 1 && !F1.t(F1.r())))) {
                F1.s(i);
            }
            F1.u(str);
            F1.v(true);
            F1.w(F1.b).h(str);
            F1.q();
        }
    }

    public class o implements S1.c {
        public final /* synthetic */ boolean a;

        public o(boolean z) {
            this.a = z;
        }

        public void a(S1.f fVar) {
            F1.e(false);
            String str = fVar.a;
            if (str != null) {
                F1.e = str;
            }
            F1.h().q(fVar, F1.f(), F1.g(), F1.d());
            F1.b1();
            j0.g(F1.b, fVar.e);
            if (this.a) {
                F1.i();
            }
        }
    }

    public class p implements Runnable {
        public final /* synthetic */ v a;
        public final /* synthetic */ String c;

        public p(v vVar, String str) {
            this.a = vVar;
            this.c = str;
        }

        public void run() {
            if (F1.P() != null) {
                new AlertDialog.Builder(F1.P()).setTitle(this.a.toString()).setMessage(this.c).show();
            }
        }
    }

    public class q implements Runnable {
        public void run() {
            F1.d().debug("Running onAppLostFocus() operation from a pending task queue.");
            F1.B();
        }
    }

    public enum r {
        NOTIFICATION_CLICK,
        APP_OPEN,
        APP_CLOSE;

        public boolean isAppClose() {
            return equals(APP_CLOSE);
        }

        public boolean isAppOpen() {
            return equals(APP_OPEN);
        }

        public boolean isNotificationClick() {
            return equals(NOTIFICATION_CLICK);
        }
    }

    public interface s {
        void a(B b);
    }

    public interface t {
        void a(r rVar);
    }

    public static class u {
        public JSONArray a;
        public boolean b;
        public T1.g c;

        public u(JSONArray jSONArray) {
            this.a = jSONArray;
        }
    }

    public enum v {
        NONE,
        FATAL,
        ERROR,
        WARN,
        INFO,
        DEBUG,
        VERBOSE
    }

    public interface w {
        void a(JSONObject jSONObject);
    }

    public interface x {
        void a(z zVar);
    }

    public interface y {
        void a(c1 c1Var);
    }

    public enum z {
        PERMISSION_GRANTED,
        PERMISSION_DENIED,
        LOCATION_PERMISSIONS_MISSING_MANIFEST,
        ERROR
    }

    static {
        m1 m1Var = new m1();
        B = m1Var;
        O7.e eVar = new O7.e(m1Var, s, w);
        C = eVar;
        D = new k1(u, eVar, s);
        H = new j();
        I = "native";
        K = new OSUtils();
        R = new ArrayList();
        S = new HashSet();
        T = new ArrayList();
        j0 = new CopyOnWriteArrayList();
    }

    public static boolean A(v vVar) {
        return vVar.compareTo(f) < 1 || vVar.compareTo(g) < 1;
    }

    public static void A0() {
        try {
            Class.forName("com.amazon.device.iap.PurchasingListener");
            q = new j2(b);
        } catch (ClassNotFoundException unused) {
        }
    }

    public static void A1(String str) {
        if (str == null || str.isEmpty()) {
            s.a("setAppId called with id: " + str + ", ignoring!");
            return;
        }
        if (!str.equals(d)) {
            m = false;
            s.verbose("setAppId called with id: " + str + " changing id from: " + d);
        }
        d = str;
        if (b == null) {
            s.a("appId set, but please call initWithContext(appContext) with Application context to complete OneSignal init!");
        } else {
            WeakReference weakReference = c;
            J0((weakReference == null || weakReference.get() == null) ? b : (Context) c.get());
        }
    }

    public static void B() {
        if (n) {
            return;
        }
        j2 j2Var = q;
        if (j2Var != null) {
            j2Var.c();
        }
        a0().a();
        v1();
    }

    public static void B0() {
        String n0 = n0();
        if (n0 == null) {
            a(v.DEBUG, "App id set for first time:  " + d);
            com.onesignal.l.d(0, b);
            r1(d);
            return;
        }
        if (n0.equals(d)) {
            return;
        }
        a(v.DEBUG, "App id has changed:\nFrom: " + n0 + "\n To: " + d + "\nClearing the user id, app state, and remoteParams as they are no longer valid");
        r1(d);
        W1.o();
        x.a();
    }

    public static void B1(boolean z2) {
        n = z2;
    }

    public static void C(r rVar) {
        Iterator it = new ArrayList(a).iterator();
        while (it.hasNext()) {
            ((t) it.next()).a(rVar);
        }
    }

    public static void C0() {
    }

    public static void C1(long j2) {
        s.debug("Last session time set to: " + j2);
        R1.l(R1.a, "OS_LAST_SESSION_TIME", j2);
    }

    public static void D(v vVar, String str, Throwable th) {
        if (th != null) {
            str = str + "\n" + Log.getStackTraceString(th);
        }
        Iterator it = j0.iterator();
        if (it.hasNext()) {
            d.D.a(it.next());
            new M7.a(vVar, str);
            throw null;
        }
    }

    public static void D0(Activity activity, JSONArray jSONArray, String str) {
        if (I1(null)) {
            return;
        }
        W0(activity, jSONArray);
        if (r != null && Z()) {
            r.g(L(jSONArray));
        }
        if (H1(activity, jSONArray)) {
            y(str);
        }
        d1(activity, jSONArray);
        q1(jSONArray);
    }

    public static void D1(boolean z2) {
        if (j0().f()) {
            s.a("setRequiresUserPrivacyConsent already called by remote params!, ignoring user set");
        } else if (!o1() || z2) {
            j0().o(z2);
        } else {
            a(v.ERROR, "Cannot change requiresUserPrivacyConsent() from TRUE to FALSE");
        }
    }

    public static void E(JSONArray jSONArray, s sVar) {
        if (I1("deleteTags()")) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                jSONObject.put(jSONArray.getString(i2), "");
            }
            z1(jSONObject, sVar);
        } catch (Throwable th) {
            b(v.ERROR, "Failed to generate JSON for deleteTags.", th);
        }
    }

    public static void E0(V0 v0) {
        try {
            JSONObject jSONObject = new JSONObject(v0.e().toString());
            jSONObject.put("androidNotificationId", v0.a());
            Z0 L2 = L(T.g(jSONObject));
            if (r == null || !Z()) {
                return;
            }
            r.h(L2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void E1(boolean z2) {
        com.onesignal.b.c(b);
        if (z2) {
            l = new Q7.a(B);
            R1.o();
            M1 U2 = U();
            T0 t0 = new T0(U2, s);
            G = t0;
            t0.h();
            b0().D();
            if (F == null) {
                F = new R7.c(s, A, U2, B);
            }
            D.g();
            f0().d();
        }
    }

    public static void F() {
        if (J1()) {
            s.debug("Starting new session with appEntryState: " + M());
            W1.r();
            f0().e();
            D.m(M());
            b0().n0();
            C1(w.a());
        } else if (N0()) {
            s.debug("Continue on same session with appEntryState: " + M());
            D.c(M());
        }
        b0().T();
        if (!n && I0()) {
            s.debug("doSessionInit on background with already registered user");
        }
        M1();
    }

    public static void F0() {
    }

    public static void F1(Context context) {
        String string;
        ApplicationInfo a2 = com.onesignal.j.a.a(context);
        if (a2 == null || (string = a2.metaData.getString("com.onesignal.PrivacyConsent")) == null) {
            return;
        }
        D1("ENABLE".equalsIgnoreCase(string));
    }

    public static void G() {
    }

    public static boolean G0() {
        return !TextUtils.isEmpty(i);
    }

    public static boolean G1(V0 v0) {
        v vVar;
        String str;
        if (N0()) {
            vVar = v.INFO;
            str = "No NotificationWillShowInForegroundHandler setup, show notification";
        } else {
            vVar = v.INFO;
            str = "App is in background, show notification";
        }
        c1(vVar, str);
        return false;
    }

    public static void H() {
    }

    public static boolean H0() {
        return !TextUtils.isEmpty(j);
    }

    public static boolean H1(Activity activity, JSONArray jSONArray) {
        if (n) {
            return false;
        }
        try {
            return new Y0(activity, jSONArray.getJSONObject(0)).a();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static void I(S0 s0) {
        c1(v.INFO, "Fire notificationWillShowInForegroundHandler");
        a1 c2 = s0.c();
        try {
            throw null;
        } catch (Throwable th) {
            c1(v.ERROR, "Exception thrown while notification was being processed for display by notificationWillShowInForegroundHandler, showing notification in foreground!");
            c2.b(c2.c());
            throw th;
        }
    }

    public static boolean I0() {
        return y0() != null;
    }

    public static boolean I1(String str) {
        if (!o1()) {
            return false;
        }
        if (str == null) {
            return true;
        }
        a(v.WARN, "Method " + str + " was called before the user provided privacy consent. Your application is set to require the user's privacy consent before the OneSignal SDK can be initialized. Please ensure the user has provided consent before calling this method. You can check the latest OneSignal consent status by calling OneSignal.userProvidedPrivacyConsent()");
        return true;
    }

    public static void J() {
    }

    public static synchronized void J0(Context context) {
        P0 p0;
        String str;
        synchronized (F1.class) {
            s.verbose("Starting OneSignal initialization!");
            S0.h(b);
            if (!o1() && x.k()) {
                int i2 = k;
                if (i2 == Integer.MAX_VALUE) {
                    i2 = K.A(b, d);
                }
                k = i2;
                if (R0()) {
                    return;
                }
                if (m) {
                    s.debug("OneSignal SDK initialization already completed.");
                    return;
                }
                z0(context);
                c = null;
                W1.k();
                B0();
                A0();
                OSPermissionChangedInternalObserver.b(R(b));
                F();
                if (l2.a(b)) {
                    p = new l2(b);
                }
                if (k2.a()) {
                    r = new k2(b);
                }
                m = true;
                a(v.VERBOSE, "OneSignal SDK initialization done.");
                f0().q();
                z.f();
                return;
            }
            if (x.k()) {
                p0 = s;
                str = "OneSignal SDK initialization delayed, waiting for privacy consent to be set.";
            } else {
                p0 = s;
                str = "OneSignal SDK initialization delayed, waiting for remote params.";
            }
            p0.verbose(str);
            U = new com.onesignal.s(b, d);
            String str2 = d;
            d = null;
            if (str2 != null && context != null) {
                U0(str2, y0(), false);
            }
        }
    }

    public static boolean J1() {
        return N0() && Q0();
    }

    public static void K(JSONObject jSONObject) {
    }

    public static void K0(Context context) {
        if (context == null) {
            s.a("initWithContext called with null context, ignoring!");
            return;
        }
        if (context instanceof Activity) {
            c = new WeakReference((Activity) context);
        }
        boolean z2 = b == null;
        b = context.getApplicationContext();
        E1(z2);
        F1(b);
        if (d != null) {
            s.verbose("initWithContext called with: " + context);
            J0(context);
            return;
        }
        String n0 = n0();
        if (n0 == null) {
            s.a("appContext set, but please call setAppId(appId) with a valid appId to complete OneSignal init!");
            return;
        }
        s.verbose("appContext set and cached app id found, calling setAppId with: " + n0);
        A1(n0);
    }

    public static void K1(boolean z2) {
        s.debug("OneSignal startLocationShared: " + z2);
        j0().n(z2);
        if (z2) {
            return;
        }
        s.debug("OneSignal is shareLocation set false, clearing last location!");
        W1.a();
    }

    public static Z0 L(JSONArray jSONArray) {
        int length = jSONArray.length();
        int optInt = jSONArray.optJSONObject(0).optInt("androidNotificationId");
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        String str = null;
        JSONObject jSONObject = null;
        for (int i2 = 0; i2 < length; i2++) {
            try {
                jSONObject = jSONArray.getJSONObject(i2);
                if (str == null && jSONObject.has("actionId")) {
                    str = jSONObject.optString("actionId", (String) null);
                }
                if (z2) {
                    z2 = false;
                } else {
                    arrayList.add(new Q0(jSONObject));
                }
            } catch (Throwable th) {
                b(v.ERROR, "Error parsing JSON item " + i2 + "/" + length + " for callback.", th);
            }
        }
        return new Z0(new Q0(arrayList, jSONObject, optInt), new R0(str != null ? R0.a.ActionTaken : R0.a.Opened, str));
    }

    public static void L0() {
        ArrayList arrayList = T;
        synchronized (arrayList) {
            try {
                if (arrayList.size() == 0) {
                    return;
                }
                new Thread(new g(), "OS_GETTAGS_CALLBACK").start();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void L1() {
        O.g(b, false, false, new m());
    }

    public static r M() {
        return o;
    }

    public static boolean M0() {
        return m && N0();
    }

    public static void M1() {
        if (O) {
            return;
        }
        O = true;
        if (n && W1.g()) {
            M = false;
        }
        L1();
        L = false;
        if (k0() != null) {
            j1();
        } else {
            U0(d, y0(), true);
        }
    }

    public static Integer N() {
        com.onesignal.A a2 = X1.a.a(b, b.getPackageName(), 0);
        if (!a2.b() || a2.a() == null) {
            return null;
        }
        return Integer.valueOf(a2.a().versionCode);
    }

    public static boolean N0() {
        return n;
    }

    public static void N1(String str) {
        s1(str);
        Q(b).f(str);
        try {
            W1.x(new JSONObject().put("parent_player_id", str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean O() {
        return x.b();
    }

    public static boolean O0() {
        return m;
    }

    public static void O1(String str) {
        t1(str);
        S(b).f(str);
    }

    public static Activity P() {
        com.onesignal.a b2 = com.onesignal.b.b();
        if (b2 != null) {
            return b2.e();
        }
        return null;
    }

    public static boolean P0() {
        return x.h();
    }

    public static void P1(String str) {
        u1(str);
        L0();
        T(b).i(str);
        u uVar = h0;
        if (uVar != null) {
            x1(uVar.a, uVar.b, uVar.c);
            h0 = null;
        }
        W1.n();
    }

    public static u0 Q(Context context) {
        if (context == null) {
            return null;
        }
        if (b0 == null) {
            u0 u0Var = new u0(false);
            b0 = u0Var;
            u0Var.b().b(new OSEmailSubscriptionChangedInternalObserver());
        }
        return b0;
    }

    public static boolean Q0() {
        long a2 = v0().a();
        long c02 = c0();
        long j2 = a2 - c02;
        s.debug("isPastOnSessionTime currentTimeMillis: " + a2 + " lastSessionTime: " + c02 + " difference: " + j2);
        return j2 >= 30000;
    }

    public static boolean Q1() {
        return x.e();
    }

    public static e1 R(Context context) {
        if (context == null) {
            return null;
        }
        if (V == null) {
            e1 e1Var = new e1(false);
            V = e1Var;
            e1Var.d().b(new OSPermissionChangedInternalObserver());
        }
        return V;
    }

    public static boolean R0() {
        return k == -999;
    }

    public static i1 S(Context context) {
        if (context == null) {
            return null;
        }
        if (e0 == null) {
            i1 i1Var = new i1(false);
            e0 = i1Var;
            i1Var.b().b(new OSSMSSubscriptionChangedInternalObserver());
        }
        return e0;
    }

    public static boolean S0() {
        return x.i();
    }

    public static OSSubscriptionState T(Context context) {
        if (context == null) {
            return null;
        }
        if (Y == null) {
            Y = new OSSubscriptionState(false, R(context).b());
            R(context).d().a(Y);
            Y.b().b(new OSSubscriptionChangedInternalObserver());
        }
        return Y;
    }

    public static void T0(String str, int i2, Throwable th, String str2) {
        String str3;
        if (str2 == null || !A(v.INFO)) {
            str3 = "";
        } else {
            str3 = "\n" + str2 + "\n";
        }
        b(v.WARN, "HTTP code: " + i2 + " " + str + str3, th);
    }

    public static M1 U() {
        return M1.i(b);
    }

    public static void U0(String str, String str2, boolean z2) {
        if (k0() != null || P) {
            return;
        }
        P = true;
        S1.e(str, str2, new o(z2));
    }

    public static M1 V(Context context) {
        return M1.i(context);
    }

    public static void V0(Context context, JSONObject jSONObject, T0.d dVar) {
        if (G == null) {
            G = new T0(V(context), s);
        }
        G.j(jSONObject, dVar);
    }

    public static boolean W() {
        return x.g();
    }

    public static void W0(Context context, JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                String optString = new JSONObject(jSONArray.getJSONObject(i2).optString("custom", (String) null)).optString("i", (String) null);
                if (!S.contains(optString)) {
                    S.add(optString);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("app_id", o0(context));
                    jSONObject.put("player_id", p0(context));
                    jSONObject.put("opened", true);
                    jSONObject.put("device_type", K.e());
                    T1.l("notifications/" + optString, jSONObject, new h());
                }
            } catch (Throwable th) {
                b(v.ERROR, "Failed to generate JSON to send notification opened.", th);
            }
        }
    }

    public static String X() {
        if (i == null && b != null) {
            i = R1.f(R1.a, "OS_EMAIL_ID", null);
        }
        if (TextUtils.isEmpty(i)) {
            return null;
        }
        return i;
    }

    public static void X0() {
        v vVar = v.DEBUG;
        a(vVar, "Application on focus");
        B1(true);
        r rVar = o;
        r rVar2 = r.NOTIFICATION_CLICK;
        if (!rVar.equals(rVar2)) {
            C(o);
            if (!o.equals(rVar2)) {
                o = r.APP_OPEN;
            }
        }
        O.l();
        o0.a.h();
        if (OSUtils.T(d)) {
            return;
        }
        if (x.k()) {
            Y0();
        } else {
            a(vVar, "Delay onAppFocus logic due to missing remote params");
            U0(d, y0(), false);
        }
    }

    public static b1 Y() {
        if (d0 == null) {
            d0 = new b1("onOSEmailSubscriptionChanged", true);
        }
        return d0;
    }

    public static void Y0() {
        if (I1("onAppFocus")) {
            return;
        }
        a0().b();
        F();
        l2 l2Var = p;
        if (l2Var != null) {
            l2Var.u();
        }
        OSNotificationRestoreWorkManager.c(b, false);
        i1();
        if (r != null && Z()) {
            r.f();
        }
        o1.q().p(b);
    }

    public static boolean Z() {
        return x.c();
    }

    public static void Z0() {
        a(v.DEBUG, "Application lost focus initDone: " + m);
        B1(false);
        o = r.APP_CLOSE;
        C1(v0().a());
        O.l();
        if (m) {
            B();
        } else if (z.g("onAppLostFocus()")) {
            s.error("Waiting for remote params. Moving onAppLostFocus() operation to a pending task queue.");
            z.c(new q());
        }
    }

    public static void a(v vVar, String str) {
        b(vVar, str, null);
    }

    public static com.onesignal.u a0() {
        if (t == null) {
            t = new com.onesignal.u(new x0(), s);
        }
        return t;
    }

    public static void a1() {
        i1();
    }

    public static void b(v vVar, String str, Throwable th) {
        if (vVar.compareTo(g) < 1) {
            if (vVar == v.VERBOSE) {
                Log.v("OneSignal", str, th);
            } else if (vVar == v.DEBUG) {
                Log.d("OneSignal", str, th);
            } else if (vVar == v.INFO) {
                Log.i("OneSignal", str, th);
            } else if (vVar == v.WARN) {
                Log.w("OneSignal", str, th);
            } else if (vVar == v.ERROR || vVar == v.FATAL) {
                Log.e("OneSignal", str, th);
            }
        }
        if (vVar.compareTo(f) < 1 && P() != null) {
            try {
                String str2 = str + "\n";
                if (th != null) {
                    String str3 = str2 + th.getMessage();
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    str2 = str3 + stringWriter.toString();
                }
                OSUtils.S(new p(vVar, str2));
            } catch (Throwable th2) {
                Log.e("OneSignal", "Error showing logging message.", th2);
            }
        }
        D(vVar, str, th);
    }

    public static B0 b0() {
        return v.a(U(), y, d0(), s0(), l);
    }

    public static void b1() {
        if (h1() || !n) {
            return;
        }
        Y0();
    }

    public static /* synthetic */ d1 c() {
        return E;
    }

    public static long c0() {
        return R1.d(R1.a, "OS_LAST_SESSION_TIME", -31000L);
    }

    public static void c1(v vVar, String str) {
        a(vVar, str);
    }

    public static /* synthetic */ P0 d() {
        return s;
    }

    public static P0 d0() {
        return s;
    }

    public static void d1(Activity activity, JSONArray jSONArray) {
        try {
            Intent b2 = com.onesignal.z.a.a(activity, jSONArray.getJSONObject(0)).b();
            if (b2 != null) {
                s.info("SDK running startActivity with Intent: " + b2);
                activity.startActivity(b2);
            } else {
                s.info("SDK not showing an Activity automatically due to it's settings.");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ boolean e(boolean z2) {
        P = z2;
        return z2;
    }

    public static String e0(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject2 = new JSONObject(jSONObject.getString("custom"));
        } catch (JSONException unused) {
            s.debug("Not a OneSignal formatted FCM message. No 'custom' field in the JSONObject.");
        }
        if (jSONObject2.has("i")) {
            return jSONObject2.optString("i", (String) null);
        }
        s.debug("Not a OneSignal formatted FCM message. No 'i' field in custom.");
        return null;
    }

    public static void e1(boolean z2, A a2) {
        o0.a.i(z2, a2);
    }

    public static /* synthetic */ O7.e f() {
        return C;
    }

    public static d1 f0() {
        if (E == null) {
            synchronized (H) {
                try {
                    if (E == null) {
                        if (F == null) {
                            F = new R7.c(s, A, U(), B);
                        }
                        E = new d1(D, F);
                    }
                } finally {
                }
            }
        }
        return E;
    }

    public static void f1(x xVar, boolean z2) {
        if (z.g("promptLocation()")) {
            s.error("Waiting for remote params. Moving promptLocation() operation to a pending queue.");
            z.c(new i(xVar, z2));
        } else {
            if (I1("promptLocation()")) {
                return;
            }
            O.g(b, true, z2, new k(xVar));
        }
    }

    public static /* synthetic */ l1 g() {
        return B;
    }

    public static b1 g0() {
        if (X == null) {
            X = new b1("onOSPermissionChanged", true);
        }
        return X;
    }

    public static boolean g1(int i2) {
        return i2 < -6;
    }

    public static /* synthetic */ h1 h() {
        return x;
    }

    public static Y1 h0() {
        Y1 c2Var;
        Y1 y1 = i0;
        if (y1 != null) {
            return y1;
        }
        if (OSUtils.C()) {
            c2Var = new Z1();
        } else {
            if (OSUtils.B()) {
                if (OSUtils.r()) {
                    c2Var = i0();
                }
                return i0;
            }
            c2Var = new c2();
        }
        i0 = c2Var;
        return i0;
    }

    public static boolean h1() {
        String a2;
        Context b2;
        if (m) {
            return false;
        }
        com.onesignal.s sVar = U;
        if (sVar == null) {
            a2 = n0();
            b2 = b;
            s.error("Trying to continue OneSignal with null delayed params");
        } else {
            a2 = sVar.a();
            b2 = U.b();
        }
        s.debug("reassignDelayedInitParams with appContext: " + b);
        U = null;
        A1(a2);
        if (m) {
            return true;
        }
        if (b2 == null) {
            s.error("Trying to continue OneSignal with null delayed params context");
            return false;
        }
        K0(b2);
        return true;
    }

    public static /* synthetic */ void i() {
        j1();
    }

    public static b2 i0() {
        S1.d dVar = x.d().o;
        return new b2(b, dVar != null ? new b2.a(dVar.a, dVar.b, dVar.c) : null);
    }

    public static void i1() {
        R(b).f();
    }

    public static /* synthetic */ void j() {
        l1();
    }

    public static h1 j0() {
        return x;
    }

    public static void j1() {
        h0().a(b, e, new n());
    }

    public static /* synthetic */ ArrayList k() {
        return T;
    }

    public static S1.f k0() {
        return x.d();
    }

    public static void k1() {
        s.debug("registerUser:registerForPushFired:" + L + ", locationFired: " + M + ", remoteParams: " + k0() + ", appId: " + d);
        if (!L || !M || k0() == null || d == null) {
            s.debug("registerUser not possible");
        } else {
            OSUtils.W(new Thread(new a(), "OS_REG_USER"));
        }
    }

    public static /* synthetic */ void l() {
        p1();
    }

    public static String l0() {
        if (j == null && b != null) {
            j = R1.f(R1.a, "PREFS_OS_SMS_ID", null);
        }
        if (TextUtils.isEmpty(j)) {
            return null;
        }
        return j;
    }

    public static void l1() {
        O.d dVar;
        String packageName = b.getPackageName();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_id", n0());
        jSONObject.put("device_os", Build.VERSION.RELEASE);
        jSONObject.put("timezone", x0());
        jSONObject.put("timezone_id", w0());
        jSONObject.put("language", l.b());
        jSONObject.put("sdk", "040812");
        jSONObject.put("sdk_type", I);
        jSONObject.put("android_package", packageName);
        jSONObject.put("device_model", Build.MODEL);
        Integer N2 = N();
        if (N2 != null) {
            jSONObject.put("game_version", N2);
        }
        jSONObject.put("net_type", K.i());
        jSONObject.put("carrier", K.d());
        jSONObject.put("rooted", h2.a());
        W1.v(jSONObject, null);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("identifier", J);
        jSONObject2.put("subscribableStatus", k);
        jSONObject2.put("androidPermission", z());
        jSONObject2.put("device_type", K.e());
        W1.x(jSONObject2);
        if (P0() && (dVar = Q) != null) {
            W1.w(dVar);
        }
        s.debug("registerUserTask calling readyToUpdate");
        W1.m(true);
        O = false;
    }

    public static /* synthetic */ boolean m() {
        return N;
    }

    public static b1 m0() {
        if (g0 == null) {
            g0 = new b1("onSMSSubscriptionChanged", true);
        }
        return g0;
    }

    public static void m1(t tVar) {
        a.remove(tVar);
    }

    public static /* synthetic */ boolean n(boolean z2) {
        N = z2;
        return z2;
    }

    public static String n0() {
        return o0(b);
    }

    public static void n1(int i2) {
        if (z.g("removeNotification()") || G == null) {
            s.error("Waiting for remote params. Moving removeNotification() operation to a pending queue.");
            z.c(new l(i2));
        } else {
            if (I1("removeNotification()")) {
                return;
            }
            G.k(i2, new WeakReference(b));
        }
    }

    public static /* synthetic */ O.d o(O.d dVar) {
        Q = dVar;
        return dVar;
    }

    public static String o0(Context context) {
        if (context == null) {
            return null;
        }
        return R1.f(R1.a, "GT_APP_ID", null);
    }

    public static boolean o1() {
        return b == null || (S0() && !Q1());
    }

    public static /* synthetic */ boolean p(boolean z2) {
        M = z2;
        return z2;
    }

    public static String p0(Context context) {
        if (context == null) {
            return null;
        }
        return R1.f(R1.a, "GT_PLAYER_ID", null);
    }

    public static void p1() {
        if (y0() == null) {
            s.a("getTags called under a null user!");
        } else {
            L0();
        }
    }

    public static /* synthetic */ void q() {
        k1();
    }

    public static String q0() {
        return "040812";
    }

    public static void q1(JSONArray jSONArray) {
        R.add(jSONArray);
    }

    public static /* synthetic */ int r() {
        return k;
    }

    public static k1 r0() {
        return D;
    }

    public static void r1(String str) {
        if (b == null) {
            return;
        }
        R1.m(R1.a, "GT_APP_ID", str);
    }

    public static /* synthetic */ int s(int i2) {
        k = i2;
        return i2;
    }

    public static l1 s0() {
        return B;
    }

    public static void s1(String str) {
        i = str;
        if (b == null) {
            return;
        }
        R1.m(R1.a, "OS_EMAIL_ID", "".equals(i) ? null : i);
    }

    public static /* synthetic */ boolean t(int i2) {
        return g1(i2);
    }

    public static b1 t0() {
        if (a0 == null) {
            a0 = new b1("onOSSubscriptionChanged", true);
        }
        return a0;
    }

    public static void t1(String str) {
        j = str;
        if (b == null) {
            return;
        }
        R1.m(R1.a, "PREFS_OS_SMS_ID", "".equals(j) ? null : j);
    }

    public static /* synthetic */ String u(String str) {
        J = str;
        return str;
    }

    public static void u0(w wVar) {
        if (z.g("getTags()")) {
            s.error("Waiting for remote params. Moving getTags() operation to a pending queue.");
            z.c(new e(wVar));
        } else {
            if (I1("getTags()")) {
                return;
            }
            if (wVar == null) {
                s.error("getTags called with null GetTagsHandler!");
            } else {
                new Thread(new f(wVar), "OS_GETTAGS").start();
            }
        }
    }

    public static void u1(String str) {
        h = str;
        if (b == null) {
            return;
        }
        R1.m(R1.a, "GT_PLAYER_ID", h);
    }

    public static /* synthetic */ boolean v(boolean z2) {
        L = z2;
        return z2;
    }

    public static t1 v0() {
        return w;
    }

    public static boolean v1() {
        boolean l2 = W1.l();
        s.debug("OneSignal scheduleSyncService unsyncedChanges: " + l2);
        if (l2) {
            o1.q().s(b);
        }
        boolean m2 = O.m(b);
        s.debug("OneSignal scheduleSyncService locationScheduled: " + m2);
        return m2 || l2;
    }

    public static /* synthetic */ OSSubscriptionState w(Context context) {
        return T(context);
    }

    public static String w0() {
        return Build.VERSION.SDK_INT >= 26 ? ZoneId.systemDefault().getId() : TimeZone.getDefault().getID();
    }

    public static void w1(List list) {
        d1 d1Var = E;
        if (d1Var == null || d == null) {
            a(v.ERROR, "Make sure OneSignal.init is called first");
        } else {
            d1Var.m(list);
        }
    }

    public static void x(JSONObject jSONObject) {
        try {
            jSONObject.put("net_type", K.i());
        } catch (Throwable unused) {
        }
    }

    public static int x0() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        if (timeZone.inDaylightTime(new Date())) {
            rawOffset += timeZone.getDSTSavings();
        }
        return rawOffset / 1000;
    }

    public static void x1(JSONArray jSONArray, boolean z2, T1.g gVar) {
        if (I1("sendPurchases()")) {
            return;
        }
        if (y0() == null) {
            u uVar = new u(jSONArray);
            h0 = uVar;
            uVar.b = z2;
            uVar.c = gVar;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_id", n0());
            if (z2) {
                jSONObject.put("existing", true);
            }
            jSONObject.put("purchases", jSONArray);
            W1.p(jSONObject, gVar);
        } catch (Throwable th) {
            b(v.ERROR, "Failed to generate JSON for sendPurchases.", th);
        }
    }

    public static void y(String str) {
        r rVar = r.NOTIFICATION_CLICK;
        o = rVar;
        D.j(rVar, str);
    }

    public static String y0() {
        Context context;
        if (h == null && (context = b) != null) {
            h = p0(context);
        }
        return h;
    }

    public static void y1(JSONObject jSONObject) {
        z1(jSONObject, null);
    }

    public static boolean z() {
        if (x.t()) {
            return OSUtils.a(b);
        }
        return true;
    }

    public static void z0(Context context) {
        com.onesignal.a b2 = com.onesignal.b.b();
        boolean z2 = context instanceof Activity;
        boolean z3 = P() == null;
        B1(!z3 || z2);
        s.debug("OneSignal handleActivityLifecycleHandler inForeground: " + n);
        if (!n) {
            if (b2 != null) {
                b2.t(true);
                return;
            }
            return;
        }
        if (z3 && z2 && b2 != null) {
            b2.s((Activity) context);
            b2.t(true);
        }
        OSNotificationRestoreWorkManager.c(context, false);
        a0().b();
    }

    public static void z1(JSONObject jSONObject, s sVar) {
        if (z.g("sendTags()")) {
            s.error("Waiting for remote params. Moving sendTags() operation to a pending task queue.");
            z.c(new b(jSONObject, sVar));
        } else {
            if (I1("sendTags()")) {
                return;
            }
            d dVar = new d(jSONObject, sVar);
            if (!z.e()) {
                dVar.run();
            } else {
                s.debug("Sending sendTags() operation to pending task queue.");
                z.c(dVar);
            }
        }
    }
}
