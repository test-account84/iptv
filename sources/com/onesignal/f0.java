package com.onesignal;

import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class F0 {
    public String a;
    public float b;
    public boolean c;

    public F0(JSONObject jSONObject) {
        this.a = jSONObject.getString("name");
        this.b = jSONObject.has("weight") ? (float) jSONObject.getDouble("weight") : 0.0f;
        this.c = jSONObject.has("unique") && jSONObject.getBoolean("unique");
    }

    public String a() {
        return this.a;
    }

    public float b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public String toString() {
        return "OSInAppMessageOutcome{name='" + this.a + "', weight=" + this.b + ", unique=" + this.c + '}';
    }
}
