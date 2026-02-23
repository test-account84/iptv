package com.onesignal;

import com.onesignal.F1;
import com.onesignal.T1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class S1 {
    public static int a;

    public class a extends T1.g {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c c;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                int a = (S1.a() * 10000) + 30000;
                if (a > 90000) {
                    a = 90000;
                }
                F1.a(F1.v.INFO, "Failed to get Android parameters, trying again in " + (a / 1000) + " seconds.");
                try {
                    Thread.sleep(a);
                    S1.b();
                    a aVar = a.this;
                    S1.e(aVar.a, aVar.b, aVar.c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public a(String str, String str2, c cVar) {
            this.a = str;
            this.b = str2;
            this.c = cVar;
        }

        public void a(int i, String str, Throwable th) {
            if (i == 403) {
                F1.a(F1.v.FATAL, "403 error getting OneSignal params, omitting further retries!");
            } else {
                new Thread(new a(), "OS_PARAMS_REQUEST").start();
            }
        }

        public void b(String str) {
            S1.c(str, this.c);
        }
    }

    public class b extends f {
        public final /* synthetic */ JSONObject p;

        public b(JSONObject jSONObject) {
            this.p = jSONObject;
            this.b = jSONObject.optBoolean("enterp", false);
            this.c = jSONObject.optBoolean("require_email_auth", false);
            this.d = jSONObject.optBoolean("require_user_id_auth", false);
            this.e = jSONObject.optJSONArray("chnl_lst");
            this.f = jSONObject.optBoolean("fba", false);
            this.g = jSONObject.optBoolean("restore_ttl_filter", true);
            this.a = jSONObject.optString("android_sender_id", (String) null);
            this.h = jSONObject.optBoolean("clear_group_on_summary_click", true);
            this.i = jSONObject.optBoolean("receive_receipts_enable", false);
            this.j = !jSONObject.has("disable_gms_missing_prompt") ? null : Boolean.valueOf(jSONObject.optBoolean("disable_gms_missing_prompt", false));
            this.k = !jSONObject.has("unsubscribe_on_notifications_disabled") ? null : Boolean.valueOf(jSONObject.optBoolean("unsubscribe_on_notifications_disabled", true));
            this.l = !jSONObject.has("location_shared") ? null : Boolean.valueOf(jSONObject.optBoolean("location_shared", true));
            this.m = !jSONObject.has("requires_user_privacy_consent") ? null : Boolean.valueOf(jSONObject.optBoolean("requires_user_privacy_consent", false));
            this.n = new e();
            if (jSONObject.has("outcomes")) {
                S1.d(jSONObject.optJSONObject("outcomes"), this.n);
            }
            this.o = new d();
            if (jSONObject.has("fcm")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("fcm");
                this.o.c = optJSONObject.optString("api_key", (String) null);
                this.o.b = optJSONObject.optString("app_id", (String) null);
                this.o.a = optJSONObject.optString("project_id", (String) null);
            }
        }
    }

    public interface c {
        void a(f fVar);
    }

    public static class d {
        public String a;
        public String b;
        public String c;
    }

    public static class e {
        public int a = 1440;
        public int b = 10;
        public int c = 1440;
        public int d = 10;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;

        public int a() {
            return this.d;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.b;
        }

        public boolean e() {
            return this.e;
        }

        public boolean f() {
            return this.f;
        }

        public boolean g() {
            return this.g;
        }

        public String toString() {
            return "InfluenceParams{indirectNotificationAttributionWindow=" + this.a + ", notificationLimit=" + this.b + ", indirectIAMAttributionWindow=" + this.c + ", iamLimit=" + this.d + ", directEnabled=" + this.e + ", indirectEnabled=" + this.f + ", unattributedEnabled=" + this.g + '}';
        }
    }

    public static class f {
        public String a;
        public boolean b;
        public boolean c;
        public boolean d;
        public JSONArray e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public Boolean j;
        public Boolean k;
        public Boolean l;
        public Boolean m;
        public e n;
        public d o;
    }

    public static /* synthetic */ int a() {
        return a;
    }

    public static /* synthetic */ int b() {
        int i = a;
        a = i + 1;
        return i;
    }

    public static /* synthetic */ void c(String str, c cVar) {
        f(str, cVar);
    }

    public static /* synthetic */ void d(JSONObject jSONObject, e eVar) {
        g(jSONObject, eVar);
    }

    public static void e(String str, String str2, c cVar) {
        a aVar = new a(str, str2, cVar);
        String str3 = "apps/" + str + "/android_params.js";
        if (str2 != null) {
            str3 = str3 + "?player_id=" + str2;
        }
        F1.a(F1.v.DEBUG, "Starting request to get Android parameters.");
        T1.e(str3, aVar, "CACHE_KEY_REMOTE_PARAMS");
    }

    public static void f(String str, c cVar) {
        try {
            cVar.a(new b(new JSONObject(str)));
        } catch (NullPointerException | JSONException e2) {
            F1.v vVar = F1.v.FATAL;
            F1.b(vVar, "Error parsing android_params!: ", e2);
            F1.a(vVar, "Response that errored from android_params!: " + str);
        }
    }

    public static void g(JSONObject jSONObject, e eVar) {
        if (jSONObject.has("v2_enabled")) {
            eVar.h = jSONObject.optBoolean("v2_enabled");
        }
        if (jSONObject.has("direct")) {
            eVar.e = jSONObject.optJSONObject("direct").optBoolean("enabled");
        }
        if (jSONObject.has("indirect")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("indirect");
            eVar.f = optJSONObject.optBoolean("enabled");
            if (optJSONObject.has("notification_attribution")) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("notification_attribution");
                eVar.a = optJSONObject2.optInt("minutes_since_displayed", 1440);
                eVar.b = optJSONObject2.optInt("limit", 10);
            }
            if (optJSONObject.has("in_app_message_attribution")) {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("in_app_message_attribution");
                eVar.c = optJSONObject3.optInt("minutes_since_displayed", 1440);
                eVar.d = optJSONObject3.optInt("limit", 10);
            }
        }
        if (jSONObject.has("unattributed")) {
            eVar.g = jSONObject.optJSONObject("unattributed").optBoolean("enabled");
        }
    }
}
