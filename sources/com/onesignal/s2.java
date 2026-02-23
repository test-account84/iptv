package com.onesignal;

import com.onesignal.W1;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class s2 extends t2 {
    public s2() {
        super(W1.c.SMS);
    }

    public String A() {
        return F1.l0();
    }

    public m2 N(String str, boolean z) {
        return new r2(str, z);
    }

    public void c0(String str) {
        F1.O1(str);
    }

    public void e0() {
        F1.J();
    }

    public void f0(JSONObject jSONObject) {
        F1.K(jSONObject);
    }

    public String g0() {
        return "sms_auth_hash";
    }

    public String h0() {
        return "sms_number";
    }

    public int i0() {
        return 14;
    }

    public void k0(String str) {
        F1.t1(str);
    }
}
