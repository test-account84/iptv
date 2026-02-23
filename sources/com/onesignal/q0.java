package com.onesignal;

import D.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Q0 {
    public List a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public JSONObject h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public String q;
    public String r;
    public List s;
    public String t;
    public b u;
    public String v;
    public int w;
    public String x;
    public long y;
    public int z;

    public static class a {
        public String a;
        public String b;
        public String c;

        public static /* synthetic */ String a(a aVar, String str) {
            aVar.a = str;
            return str;
        }

        public static /* synthetic */ String b(a aVar, String str) {
            aVar.b = str;
            return str;
        }

        public static /* synthetic */ String c(a aVar, String str) {
            aVar.c = str;
            return str;
        }
    }

    public static class b {
        public String a;
        public String b;
        public String c;

        public static /* synthetic */ String a(b bVar, String str) {
            bVar.a = str;
            return str;
        }

        public static /* synthetic */ String b(b bVar, String str) {
            bVar.b = str;
            return str;
        }

        public static /* synthetic */ String c(b bVar, String str) {
            bVar.c = str;
            return str;
        }
    }

    public Q0() {
        this.p = 1;
    }

    public static /* synthetic */ void a(Q0 q0, long j) {
        q0.J(j);
    }

    public static /* synthetic */ void b(Q0 q0, int i) {
        q0.Q(i);
    }

    public void A(List list) {
        this.a = list;
    }

    public void B(String str) {
        this.j = str;
    }

    public void C(String str) {
        this.m = str;
    }

    public void D(String str) {
        this.o = str;
    }

    public void E(int i) {
        this.p = i;
    }

    public void G(String str) {
        this.c = str;
    }

    public void H(int i) {
        this.w = i;
    }

    public void I(String str) {
        this.x = str;
    }

    public final void J(long j) {
        this.y = j;
    }

    public void K(String str) {
        this.i = str;
    }

    public void L(String str) {
        this.l = str;
    }

    public void M(String str) {
        this.n = str;
    }

    public void N(String str) {
        this.e = str;
    }

    public void O(String str) {
        this.d = str;
    }

    public void P(String str) {
        this.f = str;
    }

    public final void Q(int i) {
        this.z = i;
    }

    public Q0 c() {
        return new c().q(null).l(this.a).d(this.b).r(this.c).A(this.d).z(this.e).B(this.f).g(this.g).c(this.h).v(this.i).m(this.j).f(this.k).w(this.l).n(this.m).x(this.n).o(this.o).p(this.p).j(this.q).k(this.r).b(this.s).i(this.t).e(this.u).h(this.v).s(this.w).t(this.x).u(this.y).y(this.z).a();
    }

    public int d() {
        return this.b;
    }

    public String e() {
        return this.g;
    }

    public l.f f() {
        return null;
    }

    public String g() {
        return this.c;
    }

    public long h() {
        return this.y;
    }

    public String i() {
        return this.e;
    }

    public String j() {
        return this.d;
    }

    public String k() {
        return this.f;
    }

    public int l() {
        return this.z;
    }

    public boolean m() {
        return this.b != 0;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|2|3|(1:5)(2:26|(1:28)(10:29|7|(1:9)|10|(1:12)|13|14|15|16|18))|6|7|(0)|10|(0)|13|14|15|16|18|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00eb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ec, code lost:
    
        com.onesignal.F1.b(com.onesignal.F1.v.ERROR, "Error assigning OSNotificationReceivedEvent.actionButtons values!", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(org.json.JSONObject r9) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.Q0.n(org.json.JSONObject):void");
    }

    public final void o() {
        JSONObject jSONObject = this.h;
        if (jSONObject == null || !jSONObject.has("actionButtons")) {
            return;
        }
        JSONArray jSONArray = this.h.getJSONArray("actionButtons");
        this.s = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            a aVar = new a();
            a.a(aVar, jSONObject2.optString("id", (String) null));
            a.b(aVar, jSONObject2.optString("text", (String) null));
            a.c(aVar, jSONObject2.optString("icon", (String) null));
            this.s.add(aVar);
        }
        this.h.remove("actionId");
        this.h.remove("actionButtons");
    }

    public void p(List list) {
        this.s = list;
    }

    public void q(JSONObject jSONObject) {
        this.h = jSONObject;
    }

    public void r(int i) {
        this.b = i;
    }

    public void s(b bVar) {
        this.u = bVar;
    }

    public final void t(JSONObject jSONObject) {
        String optString = jSONObject.optString("bg_img", (String) null);
        if (optString != null) {
            JSONObject jSONObject2 = new JSONObject(optString);
            b bVar = new b();
            this.u = bVar;
            b.a(bVar, jSONObject2.optString("img"));
            b.b(this.u, jSONObject2.optString("tc"));
            b.c(this.u, jSONObject2.optString("bc"));
        }
    }

    public String toString() {
        return "OSNotification{notificationExtender=" + ((Object) null) + ", groupedNotifications=" + this.a + ", androidNotificationId=" + this.b + ", notificationId='" + this.c + "', templateName='" + this.d + "', templateId='" + this.e + "', title='" + this.f + "', body='" + this.g + "', additionalData=" + this.h + ", smallIcon='" + this.i + "', largeIcon='" + this.j + "', bigPicture='" + this.k + "', smallIconAccentColor='" + this.l + "', launchURL='" + this.m + "', sound='" + this.n + "', ledColor='" + this.o + "', lockScreenVisibility=" + this.p + ", groupKey='" + this.q + "', groupMessage='" + this.r + "', actionButtons=" + this.s + ", fromProjectNumber='" + this.t + "', backgroundImageLayout=" + this.u + ", collapseId='" + this.v + "', priority=" + this.w + ", rawPayload='" + this.x + "'}";
    }

    public void u(String str) {
        this.k = str;
    }

    public void v(String str) {
        this.g = str;
    }

    public void w(String str) {
        this.v = str;
    }

    public void x(String str) {
        this.t = str;
    }

    public void y(String str) {
        this.q = str;
    }

    public void z(String str) {
        this.r = str;
    }

    public Q0(List list, JSONObject jSONObject, int i) {
        this.p = 1;
        n(jSONObject);
        this.a = list;
        this.b = i;
    }

    public Q0(JSONObject jSONObject) {
        this(null, jSONObject, 0);
    }

    public static class c {
        public List a;
        public int b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public JSONObject h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public int p = 1;
        public String q;
        public String r;
        public List s;
        public String t;
        public b u;
        public String v;
        public int w;
        public String x;
        public long y;
        public int z;

        public c A(String str) {
            this.d = str;
            return this;
        }

        public c B(String str) {
            this.f = str;
            return this;
        }

        public Q0 a() {
            Q0 q0 = new Q0();
            q0.F(null);
            q0.A(this.a);
            q0.r(this.b);
            q0.G(this.c);
            q0.O(this.d);
            q0.N(this.e);
            q0.P(this.f);
            q0.v(this.g);
            q0.q(this.h);
            q0.K(this.i);
            q0.B(this.j);
            q0.u(this.k);
            q0.L(this.l);
            q0.C(this.m);
            q0.M(this.n);
            q0.D(this.o);
            q0.E(this.p);
            q0.y(this.q);
            q0.z(this.r);
            q0.p(this.s);
            q0.x(this.t);
            q0.s(this.u);
            q0.w(this.v);
            q0.H(this.w);
            q0.I(this.x);
            Q0.a(q0, this.y);
            Q0.b(q0, this.z);
            return q0;
        }

        public c b(List list) {
            this.s = list;
            return this;
        }

        public c c(JSONObject jSONObject) {
            this.h = jSONObject;
            return this;
        }

        public c d(int i) {
            this.b = i;
            return this;
        }

        public c e(b bVar) {
            this.u = bVar;
            return this;
        }

        public c f(String str) {
            this.k = str;
            return this;
        }

        public c g(String str) {
            this.g = str;
            return this;
        }

        public c h(String str) {
            this.v = str;
            return this;
        }

        public c i(String str) {
            this.t = str;
            return this;
        }

        public c j(String str) {
            this.q = str;
            return this;
        }

        public c k(String str) {
            this.r = str;
            return this;
        }

        public c l(List list) {
            this.a = list;
            return this;
        }

        public c m(String str) {
            this.j = str;
            return this;
        }

        public c n(String str) {
            this.m = str;
            return this;
        }

        public c o(String str) {
            this.o = str;
            return this;
        }

        public c p(int i) {
            this.p = i;
            return this;
        }

        public c r(String str) {
            this.c = str;
            return this;
        }

        public c s(int i) {
            this.w = i;
            return this;
        }

        public c t(String str) {
            this.x = str;
            return this;
        }

        public c u(long j) {
            this.y = j;
            return this;
        }

        public c v(String str) {
            this.i = str;
            return this;
        }

        public c w(String str) {
            this.l = str;
            return this;
        }

        public c x(String str) {
            this.n = str;
            return this;
        }

        public c y(int i) {
            this.z = i;
            return this;
        }

        public c z(String str) {
            this.e = str;
            return this;
        }

        public c q(l.f fVar) {
            return this;
        }
    }

    public void F(l.f fVar) {
    }
}
