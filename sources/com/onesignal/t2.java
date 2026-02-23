package com.onesignal;

import com.onesignal.F1;
import com.onesignal.W1;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class t2 extends u2 {
    public t2(W1.c cVar) {
        super(cVar);
    }

    public abstract String A();

    public F1.v B() {
        return F1.v.INFO;
    }

    public void O(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(h0(), jSONObject.get("identifier"));
                if (jSONObject.has(g0())) {
                    jSONObject2.put(g0(), jSONObject.get(g0()));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            f0(jSONObject2);
        }
    }

    public void T() {
        if ((A() == null && D() == null) || F1.y0() == null) {
            return;
        }
        C(0).c();
    }

    public abstract void e0();

    public abstract void f0(JSONObject jSONObject);

    public abstract String g0();

    public abstract String h0();

    public abstract int i0();

    public void j0() {
        T();
    }

    public void n(JSONObject jSONObject) {
        try {
            jSONObject.put("device_type", i0());
            jSONObject.putOpt("device_player_id", F1.y0());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void w(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            e0();
        }
    }
}
