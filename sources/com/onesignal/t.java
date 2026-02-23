package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import com.onesignal.F1;
import com.onesignal.T0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class T {

    public class a implements T0.d {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        public a(boolean z, JSONObject jSONObject, Context context, int i, String str, long j) {
            this.a = z;
            this.b = jSONObject;
            this.c = context;
            this.d = i;
            this.e = str;
            this.f = j;
        }

        public void a(boolean z) {
            if (this.a || !z) {
                OSNotificationWorkManager.b(this.c, U0.b(this.b), this.d, this.e, this.f, this.a, false);
                if (this.a) {
                    OSUtils.V(100);
                }
            }
        }
    }

    public class b implements d {
        public final /* synthetic */ f a;
        public final /* synthetic */ e b;

        public b(f fVar, e eVar) {
            this.a = fVar;
            this.b = eVar;
        }

        public void a(boolean z) {
            if (!z) {
                this.a.d(true);
            }
            this.b.a(this.a);
        }
    }

    public class c implements T0.d {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Bundle c;
        public final /* synthetic */ d d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ long f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ f h;

        public c(boolean z, Context context, Bundle bundle, d dVar, JSONObject jSONObject, long j, boolean z2, f fVar) {
            this.a = z;
            this.b = context;
            this.c = bundle;
            this.d = dVar;
            this.e = jSONObject;
            this.f = j;
            this.g = z2;
            this.h = fVar;
        }

        public void a(boolean z) {
            if (this.a || !z) {
                OSNotificationWorkManager.b(this.b, U0.b(this.e), this.c.containsKey("android_notif_id") ? this.c.getInt("android_notif_id") : 0, this.e.toString(), this.f, this.a, this.g);
                this.h.g(true);
                this.d.a(true);
                return;
            }
            F1.a(F1.v.DEBUG, "startNotificationProcessing returning, with context: " + this.b + " and bundle: " + this.c);
            this.d.a(false);
        }
    }

    public interface d {
        void a(boolean z);
    }

    public interface e {
        void a(f fVar);
    }

    public static class f {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;

        public boolean a() {
            return this.b;
        }

        public boolean b() {
            return this.d;
        }

        public boolean c() {
            return !this.a || this.b || this.c || this.d;
        }

        public void d(boolean z) {
            this.b = z;
        }

        public void e(boolean z) {
            this.c = z;
        }

        public void f(boolean z) {
            this.a = z;
        }

        public void g(boolean z) {
            this.d = z;
        }
    }

    public static JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException e2) {
                F1.b(F1.v.ERROR, "bundleAsJSONObject error for key: " + str, e2);
            }
        }
        return jSONObject;
    }

    public static JSONObject b(JSONObject jSONObject) {
        return new JSONObject(jSONObject.optString("custom"));
    }

    public static boolean c(Bundle bundle) {
        return d(bundle, "licon") || d(bundle, "bicon") || bundle.getString("bg_img", (String) null) != null;
    }

    public static boolean d(Bundle bundle, String str) {
        String trim = bundle.getString(str, "").trim();
        return trim.startsWith("http://") || trim.startsWith("https://");
    }

    public static void e(V0 v0) {
        if (v0.m()) {
            F1.a(F1.v.DEBUG, "Marking restored or disabled notifications as dismissed: " + v0.toString());
            String str = "android_notification_id = " + v0.a();
            M1 i = M1.i(v0.d());
            ContentValues contentValues = new ContentValues();
            contentValues.put("dismissed", 1);
            i.a("notification", contentValues, str, null);
            l.c(i, v0.d());
        }
    }

    public static void f(Bundle bundle) {
        String str;
        if (bundle.containsKey("o")) {
            try {
                JSONObject jSONObject = new JSONObject(bundle.getString("custom"));
                JSONObject jSONObject2 = jSONObject.has("a") ? jSONObject.getJSONObject("a") : new JSONObject();
                JSONArray jSONArray = new JSONArray(bundle.getString("o"));
                bundle.remove("o");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String string = jSONObject3.getString("n");
                    jSONObject3.remove("n");
                    if (jSONObject3.has("i")) {
                        str = jSONObject3.getString("i");
                        jSONObject3.remove("i");
                    } else {
                        str = string;
                    }
                    jSONObject3.put("id", str);
                    jSONObject3.put("text", string);
                    if (jSONObject3.has("p")) {
                        jSONObject3.put("icon", jSONObject3.getString("p"));
                        jSONObject3.remove("p");
                    }
                }
                jSONObject2.put("actionButtons", jSONArray);
                jSONObject2.put("actionId", "__DEFAULT__");
                if (!jSONObject.has("a")) {
                    jSONObject.put("a", jSONObject2);
                }
                bundle.putString("custom", jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static JSONArray g(JSONObject jSONObject) {
        return new JSONArray().put(jSONObject);
    }

    public static void h(Context context, Bundle bundle, e eVar) {
        f fVar = new f();
        if (!U0.d(bundle)) {
            eVar.a(fVar);
            return;
        }
        fVar.f(true);
        f(bundle);
        if (!H0.c(context, bundle)) {
            q(context, bundle, fVar, new b(fVar, eVar));
        } else {
            fVar.e(true);
            eVar.a(fVar);
        }
    }

    public static void i(V0 v0) {
        if (v0.n() || !v0.e().has("collapse_key") || "do_not_collapse".equals(v0.e().optString("collapse_key"))) {
            return;
        }
        Cursor d2 = M1.i(v0.d()).d("notification", new String[]{"android_notification_id"}, "collapse_id = ? AND dismissed = 0 AND opened = 0 ", new String[]{v0.e().optString("collapse_key")}, null, null, null);
        if (d2.moveToFirst()) {
            v0.f().r(d2.getInt(d2.getColumnIndex("android_notification_id")));
        }
        d2.close();
    }

    public static void j(Context context, m mVar) {
        F1.K0(context);
        try {
            String string = mVar.getString("json_payload");
            if (string != null) {
                JSONObject jSONObject = new JSONObject(string);
                F1.V0(context, jSONObject, new a(mVar.b("is_restoring", false), jSONObject, context, mVar.g("android_notif_id") ? mVar.d("android_notif_id").intValue() : 0, string, mVar.c("timestamp").longValue()));
                return;
            }
            F1.a(F1.v.ERROR, "json_payload key is nonexistent from mBundle passed to ProcessFromFCMIntentService: " + mVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static int k(S0 s0, boolean z) {
        return l(s0, false, z);
    }

    public static int l(S0 s0, boolean z, boolean z2) {
        F1.a(F1.v.DEBUG, "Starting processJobForDisplay opened: " + z + " fromBackgroundLogic: " + z2);
        V0 b2 = s0.b();
        i(b2);
        int intValue = b2.a().intValue();
        boolean z3 = false;
        if (p(b2)) {
            b2.p(true);
            if (z2 && F1.G1(b2)) {
                s0.g(false);
                F1.I(s0);
                return intValue;
            }
            z3 = x.n(b2);
        }
        if (!b2.n()) {
            n(b2, z, z3);
            OSNotificationWorkManager.c(U0.b(s0.b().e()));
            F1.E0(b2);
        }
        return intValue;
    }

    public static int m(V0 v0, boolean z) {
        return l(new S0(v0, v0.n(), true), false, z);
    }

    public static void n(V0 v0, boolean z, boolean z2) {
        o(v0, z);
        if (!z2) {
            e(v0);
            return;
        }
        String b2 = v0.b();
        OSReceiveReceiptController.c().a(v0.d(), b2);
        F1.r0().l(b2);
    }

    public static void o(V0 v0, boolean z) {
        F1.v vVar = F1.v.DEBUG;
        F1.a(vVar, "Saving Notification job: " + v0.toString());
        Context d2 = v0.d();
        JSONObject e2 = v0.e();
        try {
            JSONObject b2 = b(v0.e());
            M1 i = M1.i(v0.d());
            if (v0.m()) {
                String str = "android_notification_id = " + v0.a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("dismissed", 1);
                i.a("notification", contentValues, str, null);
                l.c(i, d2);
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("notification_id", b2.optString("i"));
            if (e2.has("grp")) {
                contentValues2.put("group_id", e2.optString("grp"));
            }
            if (e2.has("collapse_key") && !"do_not_collapse".equals(e2.optString("collapse_key"))) {
                contentValues2.put("collapse_id", e2.optString("collapse_key"));
            }
            contentValues2.put("opened", Integer.valueOf(z ? 1 : 0));
            if (!z) {
                contentValues2.put("android_notification_id", v0.a());
            }
            if (v0.k() != null) {
                contentValues2.put("title", v0.k().toString());
            }
            if (v0.c() != null) {
                contentValues2.put("message", v0.c().toString());
            }
            contentValues2.put("expire_time", Long.valueOf((e2.optLong("google.sent_time", F1.v0().a()) / 1000) + e2.optInt("google.ttl", 259200)));
            contentValues2.put("full_data", e2.toString());
            i.l("notification", null, contentValues2);
            F1.a(vVar, "Notification saved values: " + contentValues2.toString());
            if (z) {
                return;
            }
            l.c(i, d2);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static boolean p(V0 v0) {
        return v0.l() || OSUtils.I(v0.e().optString("alert"));
    }

    public static void q(Context context, Bundle bundle, f fVar, d dVar) {
        JSONObject a2 = a(bundle);
        F1.V0(context, a2, new c(bundle.getBoolean("is_restoring", false), context, bundle, dVar, a2, F1.v0().a() / 1000, Integer.parseInt(bundle.getString("pri", "0")) > 9, fVar));
    }
}
