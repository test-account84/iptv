package com.onesignal;

import com.onesignal.F1;
import com.onesignal.T1;
import com.onesignal.W1;
import com.onesignal.u2;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class q2 extends u2 {
    public static boolean m;

    public class a extends T1.g {
        public a() {
        }

        public void b(String str) {
            q2.e0(true);
            if (str == null || str.isEmpty()) {
                str = "{}";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("tags")) {
                    synchronized (q2.this.a) {
                        q2 q2Var = q2.this;
                        JSONObject y = q2Var.y(q2Var.z().l().e("tags"), q2.this.F().l().e("tags"), null, null);
                        q2.this.z().t("tags", jSONObject.optJSONObject("tags"));
                        q2.this.z().q();
                        q2.this.F().o(jSONObject, y);
                        q2.this.F().q();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public q2() {
        super(W1.c.PUSH);
    }

    public static /* synthetic */ boolean e0(boolean z) {
        m = z;
        return z;
    }

    public String A() {
        return F1.y0();
    }

    public F1.v B() {
        return F1.v.ERROR;
    }

    public m2 N(String str, boolean z) {
        return new p2(str, z);
    }

    public void O(JSONObject jSONObject) {
    }

    public void T() {
        C(0).c();
    }

    public void c0(String str) {
        F1.P1(str);
    }

    public String f0() {
        return F().i().g("language", null);
    }

    public u2.e g0(boolean z) {
        u2.e eVar;
        if (z) {
            T1.f("players/" + F1.y0() + "?app_id=" + F1.n0(), new a(), "CACHE_KEY_GET_TAGS");
        }
        synchronized (this.a) {
            eVar = new u2.e(m, H.c(F().l(), "tags"));
        }
        return eVar;
    }

    public boolean h0() {
        return F().i().c("userSubscribePref", true);
    }

    public void i0(String str) {
        F1.u1(str);
    }

    public void j0(boolean z) {
        try {
            G().s("androidPermission", Boolean.valueOf(z));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void k0(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("identifier", jSONObject.optString("identifier", (String) null));
            if (jSONObject.has("device_type")) {
                jSONObject2.put("device_type", jSONObject.optInt("device_type"));
            }
            jSONObject2.putOpt("parent_player_id", jSONObject.optString("parent_player_id", (String) null));
            G().h(jSONObject2, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has("subscribableStatus")) {
                jSONObject3.put("subscribableStatus", jSONObject.optInt("subscribableStatus"));
            }
            if (jSONObject.has("androidPermission")) {
                jSONObject3.put("androidPermission", jSONObject.optBoolean("androidPermission"));
            }
            G().g(jSONObject3, null);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void n(JSONObject jSONObject) {
    }

    public void w(JSONObject jSONObject) {
        if (jSONObject.has("email")) {
            F1.G();
        }
        if (jSONObject.has("sms_number")) {
            F1.J();
        }
    }
}
