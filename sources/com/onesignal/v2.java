package com.onesignal;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.onesignal.F;
import com.onesignal.F1;
import com.onesignal.a;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class v2 extends a.b {
    public static final String k = "com.onesignal.v2";
    public static final int l = C1.b(24);
    public static v2 m = null;
    public D1 b;
    public F c;
    public Activity d;
    public D0 e;
    public A0 f;
    public final Object a = new b();
    public String g = null;
    public Integer h = null;
    public boolean i = false;
    public boolean j = false;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[m.values().length];
            a = iArr;
            try {
                iArr[m.TOP_BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[m.BOTTOM_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class b {
        public b() {
        }
    }

    public class c implements l {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ D0 b;
        public final /* synthetic */ A0 c;

        public c(Activity activity, D0 d0, A0 a0) {
            this.a = activity;
            this.b = d0;
            this.c = a0;
        }

        public void a() {
            v2.m = null;
            v2.c(this.a, this.b, this.c);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ D0 a;
        public final /* synthetic */ A0 c;

        public d(D0 d0, A0 a0) {
            this.a = d0;
            this.c = a0;
        }

        public void run() {
            v2.I(this.a, this.c);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ Activity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ A0 e;

        public e(Activity activity, String str, A0 a0) {
            this.c = activity;
            this.d = str;
            this.e = a0;
        }

        public void run() {
            try {
                v2.d(v2.this, this.c, this.d, this.e.g());
            } catch (Exception e) {
                if (e.getMessage() == null || !e.getMessage().contains("No WebView installed")) {
                    throw e;
                }
                F1.b(F1.v.ERROR, "Error setting up WebView: ", e);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            int[] c = C1.c(v2.n(v2.this));
            v2.s(v2.this).evaluateJavascript(String.format("setSafeAreaInsets(%s)", new Object[]{String.format("{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}", new Object[]{Integer.valueOf(c[0]), Integer.valueOf(c[1]), Integer.valueOf(c[2]), Integer.valueOf(c[3])})}), (ValueCallback) null);
        }
    }

    public class g implements Runnable {

        public class a implements ValueCallback {
            public a() {
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
                try {
                    v2 v2Var = v2.this;
                    v2.g(v2.this, Integer.valueOf(v2.o(v2Var, v2.n(v2Var), new JSONObject(str))));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public g() {
        }

        public void run() {
            v2 v2Var = v2.this;
            v2.e(v2Var, v2.n(v2Var));
            if (v2.l(v2.this).g()) {
                v2.f(v2.this);
            }
            v2.s(v2.this).evaluateJavascript("getPageMetaData()", new a());
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String c;

        public h(Activity activity, String str) {
            this.a = activity;
            this.c = str;
        }

        public void run() {
            v2.e(v2.this, this.a);
            v2.s(v2.this).loadData(this.c, "text/html; charset=utf-8", "base64");
        }
    }

    public class i implements F.j {
        public i() {
        }

        public void a() {
            F1.b0().d0(v2.r(v2.this));
        }

        public void b() {
            F1.b0().X(v2.r(v2.this));
            v2.h(v2.this);
        }

        public void c() {
            F1.b0().e0(v2.r(v2.this));
        }
    }

    public class j implements l {
        public final /* synthetic */ l a;

        public j(l lVar) {
            this.a = lVar;
        }

        public void a() {
            v2.i(v2.this, false);
            v2.j(v2.this, null);
            l lVar = this.a;
            if (lVar != null) {
                lVar.a();
            }
        }
    }

    public class k {
        public k() {
        }

        public final m a(JSONObject jSONObject) {
            m mVar = m.FULL_SCREEN;
            try {
                return (!jSONObject.has("displayLocation") || jSONObject.get("displayLocation").equals("")) ? mVar : m.valueOf(jSONObject.optString("displayLocation", "FULL_SCREEN").toUpperCase());
            } catch (JSONException e) {
                e.printStackTrace();
                return mVar;
            }
        }

        public final boolean b(JSONObject jSONObject) {
            try {
                return jSONObject.getBoolean("dragToDismissDisabled");
            } catch (JSONException unused) {
                return false;
            }
        }

        public final int c(JSONObject jSONObject) {
            try {
                v2 v2Var = v2.this;
                return v2.o(v2Var, v2.n(v2Var), jSONObject.getJSONObject("pageMetaData"));
            } catch (JSONException unused) {
                return -1;
            }
        }

        public final void d(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("body");
            String optString = jSONObject2.optString("id", (String) null);
            v2.q(v2.this, jSONObject2.getBoolean("close"));
            if (v2.r(v2.this).k) {
                F1.b0().a0(v2.r(v2.this), jSONObject2);
            } else if (optString != null) {
                F1.b0().Z(v2.r(v2.this), jSONObject2);
            }
            if (v2.p(v2.this)) {
                v2.this.w(null);
            }
        }

        public final void e(JSONObject jSONObject) {
            F1.b0().g0(v2.r(v2.this), jSONObject);
        }

        public final void f(JSONObject jSONObject) {
            m a = a(jSONObject);
            int c = a == m.FULL_SCREEN ? -1 : c(jSONObject);
            boolean b = b(jSONObject);
            v2.l(v2.this).i(a);
            v2.l(v2.this).j(c);
            v2.m(v2.this, b);
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x0055  */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void postMessage(java.lang.String r5) {
            /*
                r4 = this;
                com.onesignal.F1$v r0 = com.onesignal.F1.v.DEBUG     // Catch: org.json.JSONException -> L35
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> L35
                r1.<init>()     // Catch: org.json.JSONException -> L35
                java.lang.String r2 = "OSJavaScriptInterface:postMessage: "
                r1.append(r2)     // Catch: org.json.JSONException -> L35
                r1.append(r5)     // Catch: org.json.JSONException -> L35
                java.lang.String r1 = r1.toString()     // Catch: org.json.JSONException -> L35
                com.onesignal.F1.c1(r0, r1)     // Catch: org.json.JSONException -> L35
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L35
                r0.<init>(r5)     // Catch: org.json.JSONException -> L35
                java.lang.String r5 = "type"
                java.lang.String r5 = r0.getString(r5)     // Catch: org.json.JSONException -> L35
                int r1 = r5.hashCode()     // Catch: org.json.JSONException -> L35
                r2 = 3
                r3 = 1
                switch(r1) {
                    case -1484226720: goto L4b;
                    case -934437708: goto L41;
                    case 42998156: goto L37;
                    case 1851145598: goto L2b;
                    default: goto L2a;
                }     // Catch: org.json.JSONException -> L35
            L2a:
                goto L55
            L2b:
                java.lang.String r1 = "action_taken"
                boolean r5 = r5.equals(r1)     // Catch: org.json.JSONException -> L35
                if (r5 == 0) goto L55
                r5 = 1
                goto L56
            L35:
                r5 = move-exception
                goto L75
            L37:
                java.lang.String r1 = "rendering_complete"
                boolean r5 = r5.equals(r1)     // Catch: org.json.JSONException -> L35
                if (r5 == 0) goto L55
                r5 = 0
                goto L56
            L41:
                java.lang.String r1 = "resize"
                boolean r5 = r5.equals(r1)     // Catch: org.json.JSONException -> L35
                if (r5 == 0) goto L55
                r5 = 2
                goto L56
            L4b:
                java.lang.String r1 = "page_change"
                boolean r5 = r5.equals(r1)     // Catch: org.json.JSONException -> L35
                if (r5 == 0) goto L55
                r5 = 3
                goto L56
            L55:
                r5 = -1
            L56:
                if (r5 == 0) goto L71
                if (r5 == r3) goto L61
                if (r5 == r2) goto L5d
                goto L78
            L5d:
                r4.e(r0)     // Catch: org.json.JSONException -> L35
                goto L78
            L61:
                com.onesignal.v2 r5 = com.onesignal.v2.this     // Catch: org.json.JSONException -> L35
                com.onesignal.F r5 = com.onesignal.v2.k(r5)     // Catch: org.json.JSONException -> L35
                boolean r5 = r5.O()     // Catch: org.json.JSONException -> L35
                if (r5 != 0) goto L78
                r4.d(r0)     // Catch: org.json.JSONException -> L35
                goto L78
            L71:
                r4.f(r0)     // Catch: org.json.JSONException -> L35
                goto L78
            L75:
                r5.printStackTrace()
            L78:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.v2.k.postMessage(java.lang.String):void");
        }
    }

    public interface l {
        void a();
    }

    public enum m {
        TOP_BANNER,
        BOTTOM_BANNER,
        CENTER_MODAL,
        FULL_SCREEN;

        public boolean isBanner() {
            int i = a.a[ordinal()];
            return i == 1 || i == 2;
        }
    }

    public v2(D0 d0, Activity activity, A0 a0) {
        this.e = d0;
        this.d = activity;
        this.f = a0;
    }

    public static void B(Activity activity, D0 d0, A0 a0) {
        if (a0.g()) {
            E(a0, activity);
        }
        try {
            String encodeToString = Base64.encodeToString(a0.a().getBytes("UTF-8"), 2);
            v2 v2Var = new v2(d0, activity, a0);
            m = v2Var;
            OSUtils.S(v2Var.new e(activity, encodeToString, a0));
        } catch (UnsupportedEncodingException e2) {
            F1.b(F1.v.ERROR, "Catch on initInAppMessage: ", e2);
            e2.printStackTrace();
        }
    }

    public static void E(A0 a0, Activity activity) {
        String a2 = a0.a();
        int[] c2 = C1.c(activity);
        a0.h(a2 + String.format("\n\n<script>\n    setSafeAreaInsets(%s);\n</script>", new Object[]{String.format("{\n   top: %d,\n   bottom: %d,\n   right: %d,\n   left: %d,\n}", new Object[]{Integer.valueOf(c2[0]), Integer.valueOf(c2[1]), Integer.valueOf(c2[2]), Integer.valueOf(c2[3])})}));
    }

    public static void I(D0 d0, A0 a0) {
        Activity P = F1.P();
        F1.c1(F1.v.DEBUG, "in app message showMessageContent on currentActivity: " + P);
        if (P == null) {
            Looper.prepare();
            new Handler().postDelayed(new d(d0, a0), 200L);
            return;
        }
        v2 v2Var = m;
        if (v2Var == null || !d0.k) {
            B(P, d0, a0);
        } else {
            v2Var.w(new c(P, d0, a0));
        }
    }

    public static /* synthetic */ void c(Activity activity, D0 d0, A0 a0) {
        B(activity, d0, a0);
    }

    public static /* synthetic */ void d(v2 v2Var, Activity activity, String str, boolean z) {
        v2Var.H(activity, str, z);
    }

    public static /* synthetic */ void e(v2 v2Var, Activity activity) {
        v2Var.G(activity);
    }

    public static /* synthetic */ void f(v2 v2Var) {
        v2Var.K();
    }

    public static /* synthetic */ void g(v2 v2Var, Integer num) {
        v2Var.J(num);
    }

    public static /* synthetic */ void h(v2 v2Var) {
        v2Var.D();
    }

    public static /* synthetic */ boolean i(v2 v2Var, boolean z) {
        v2Var.i = z;
        return z;
    }

    public static /* synthetic */ void j(v2 v2Var, F f2) {
        v2Var.F(f2);
    }

    public static /* synthetic */ F k(v2 v2Var) {
        return v2Var.c;
    }

    public static /* synthetic */ A0 l(v2 v2Var) {
        return v2Var.f;
    }

    public static /* synthetic */ void m(v2 v2Var, boolean z) {
        v2Var.v(z);
    }

    public static /* synthetic */ Activity n(v2 v2Var) {
        return v2Var.d;
    }

    public static /* synthetic */ int o(v2 v2Var, Activity activity, JSONObject jSONObject) {
        return v2Var.C(activity, jSONObject);
    }

    public static /* synthetic */ boolean p(v2 v2Var) {
        return v2Var.j;
    }

    public static /* synthetic */ boolean q(v2 v2Var, boolean z) {
        v2Var.j = z;
        return z;
    }

    public static /* synthetic */ D0 r(v2 v2Var) {
        return v2Var.e;
    }

    public static /* synthetic */ D1 s(v2 v2Var) {
        return v2Var.b;
    }

    public static void x() {
        F1.c1(F1.v.DEBUG, "WebViewManager IAM dismissAndAwaitNextMessage lastInstance: " + m);
        v2 v2Var = m;
        if (v2Var != null) {
            v2Var.w(null);
        }
    }

    public static void y() {
        if (F1.A(F1.v.DEBUG)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    public final int A(Activity activity) {
        return C1.f(activity) - (this.f.g() ? 0 : l * 2);
    }

    public final int C(Activity activity, JSONObject jSONObject) {
        try {
            int b2 = C1.b(jSONObject.getJSONObject("rect").getInt("height"));
            F1.v vVar = F1.v.DEBUG;
            F1.c1(vVar, "getPageHeightData:pxHeight: " + b2);
            int A = A(activity);
            if (b2 <= A) {
                return b2;
            }
            F1.a(vVar, "getPageHeightData:pxHeight is over screen max: " + A);
            return A;
        } catch (JSONException e2) {
            F1.b(F1.v.ERROR, "pageRectToViewHeight could not get page height", e2);
            return -1;
        }
    }

    public final void D() {
        com.onesignal.a b2 = com.onesignal.b.b();
        if (b2 != null) {
            b2.r(k + this.e.a);
        }
    }

    public final void F(F f2) {
        synchronized (this.a) {
            this.c = f2;
        }
    }

    public final void G(Activity activity) {
        this.b.layout(0, 0, z(activity), A(activity));
    }

    public final void H(Activity activity, String str, boolean z) {
        y();
        D1 d1 = new D1(activity);
        this.b = d1;
        d1.setOverScrollMode(2);
        this.b.setVerticalScrollBarEnabled(false);
        this.b.setHorizontalScrollBarEnabled(false);
        this.b.getSettings().setJavaScriptEnabled(true);
        this.b.addJavascriptInterface(new k(), "OSAndroid");
        if (z) {
            this.b.setSystemUiVisibility(3074);
            if (Build.VERSION.SDK_INT >= 30) {
                this.b.setFitsSystemWindows(false);
            }
        }
        t(this.b);
        C1.a(activity, new h(activity, str));
    }

    public final void J(Integer num) {
        synchronized (this.a) {
            try {
                if (this.c == null) {
                    F1.a(F1.v.WARN, "No messageView found to update a with a new height.");
                    return;
                }
                F1.a(F1.v.DEBUG, "In app message, showing first one with height: " + num);
                this.c.U(this.b);
                if (num != null) {
                    this.h = num;
                    this.c.Z(num.intValue());
                }
                this.c.X(this.d);
                this.c.B();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void K() {
        OSUtils.S(new f());
    }

    public void a(Activity activity) {
        Integer num;
        String str = this.g;
        this.d = activity;
        this.g = activity.getLocalClassName();
        F1.a(F1.v.DEBUG, "In app message activity available currentActivityName: " + this.g + " lastActivityName: " + str);
        if (str == null) {
            num = null;
        } else if (str.equals(this.g)) {
            u();
            return;
        } else {
            if (this.j) {
                return;
            }
            F f2 = this.c;
            if (f2 != null) {
                f2.P();
            }
            num = this.h;
        }
        J(num);
    }

    public void b(Activity activity) {
        F1.a(F1.v.DEBUG, "In app message activity stopped, cleaning views, currentActivityName: " + this.g + "\nactivity: " + this.d + "\nmessageView: " + this.c);
        if (this.c == null || !activity.getLocalClassName().equals(this.g)) {
            return;
        }
        this.c.P();
    }

    public final void t(WebView webView) {
    }

    public final void u() {
        F f2 = this.c;
        if (f2 == null) {
            return;
        }
        if (f2.M() == m.FULL_SCREEN && !this.f.g()) {
            J(null);
        } else {
            F1.a(F1.v.DEBUG, "In app message new activity, calculate height and show ");
            C1.a(this.d, new g());
        }
    }

    public final void v(boolean z) {
        this.h = Integer.valueOf(this.f.d());
        F(new F(this.b, this.f, z));
        this.c.R(new i());
        com.onesignal.a b2 = com.onesignal.b.b();
        if (b2 != null) {
            b2.c(k + this.e.a, this);
        }
    }

    public void w(l lVar) {
        F f2 = this.c;
        if (f2 == null || this.i) {
            if (lVar != null) {
                lVar.a();
            }
        } else {
            if (this.e != null && f2 != null) {
                F1.b0().e0(this.e);
            }
            this.c.K(new j(lVar));
            this.i = true;
        }
    }

    public final int z(Activity activity) {
        if (this.f.g()) {
            return C1.e(activity);
        }
        return C1.j(activity) - (l * 2);
    }
}
