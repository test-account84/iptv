package com.onesignal;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class OSSubscriptionState implements Cloneable {
    public b1 a = new b1("changed", false);
    public String c;
    public String d;
    public boolean e;
    public boolean f;

    public OSSubscriptionState(boolean z, boolean z2) {
        if (!z) {
            this.f = !W1.j();
            this.c = F1.y0();
            this.d = W1.e();
            this.e = z2;
            return;
        }
        String str = R1.a;
        this.f = R1.b(str, "ONESIGNAL_SUBSCRIPTION_LAST", true);
        this.c = R1.f(str, "ONESIGNAL_PLAYER_ID_LAST", null);
        this.d = R1.f(str, "ONESIGNAL_PUSH_TOKEN_LAST", null);
        this.e = R1.b(str, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", false);
    }

    public b1 b() {
        return this.a;
    }

    public void changed(e1 e1Var) {
        g(e1Var.b());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return (this.c == null || this.d == null || this.f || !this.e) ? false : true;
    }

    public void f() {
        String str = R1.a;
        R1.j(str, "ONESIGNAL_SUBSCRIPTION_LAST", this.f);
        R1.m(str, "ONESIGNAL_PLAYER_ID_LAST", this.c);
        R1.m(str, "ONESIGNAL_PUSH_TOKEN_LAST", this.d);
        R1.j(str, "ONESIGNAL_PERMISSION_ACCEPTED_LAST", this.e);
    }

    public final void g(boolean z) {
        boolean e = e();
        this.e = z;
        if (e != e()) {
            this.a.c(this);
        }
    }

    public void h(String str) {
        if (str == null) {
            return;
        }
        boolean z = !str.equals(this.d);
        this.d = str;
        if (z) {
            this.a.c(this);
        }
    }

    public void i(String str) {
        boolean z = true;
        String str2 = this.c;
        if (str != null ? str.equals(str2) : str2 == null) {
            z = false;
        }
        this.c = str;
        if (z) {
            this.a.c(this);
        }
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj = this.c;
            if (obj == null) {
                obj = JSONObject.NULL;
            }
            jSONObject.put("userId", obj);
            Object obj2 = this.d;
            if (obj2 == null) {
                obj2 = JSONObject.NULL;
            }
            jSONObject.put("pushToken", obj2);
            jSONObject.put("isPushDisabled", d());
            jSONObject.put("isSubscribed", e());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return j().toString();
    }
}
