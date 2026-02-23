package com.onesignal;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class N0 {
    public JSONObject a;
    public JSONArray b;

    public N0(JSONObject jSONObject) {
        this.a = jSONObject.has("adds") ? jSONObject.getJSONObject("adds") : null;
        this.b = jSONObject.has("removes") ? jSONObject.getJSONArray("removes") : null;
    }

    public JSONObject a() {
        return this.a;
    }

    public JSONArray b() {
        return this.b;
    }

    public String toString() {
        return "OSInAppMessageTag{adds=" + this.a + ", removes=" + this.b + '}';
    }
}
