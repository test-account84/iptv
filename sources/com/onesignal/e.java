package com.onesignal;

import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class E {
    public final JSONObject a;

    public E() {
        this.a = new JSONObject();
    }

    public boolean a(String str) {
        return this.a.has(str);
    }

    public boolean b(String str) {
        return this.a.optBoolean(str);
    }

    public boolean c(String str, boolean z) {
        return this.a.optBoolean(str, z);
    }

    public int d(String str, int i) {
        return this.a.optInt(str, i);
    }

    public JSONObject e(String str) {
        return this.a.optJSONObject(str);
    }

    public String f(String str) {
        return this.a.optString(str);
    }

    public String g(String str, String str2) {
        return this.a.optString(str, str2);
    }

    public String toString() {
        return "ImmutableJSONObject{jsonObject=" + this.a + '}';
    }

    public E(JSONObject jSONObject) {
        this.a = jSONObject;
    }
}
