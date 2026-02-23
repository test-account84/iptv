package com.onesignal;

import com.onesignal.v2;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class A0 {
    public String a;
    public boolean b;
    public boolean c;
    public boolean d;
    public v2.m e;
    public Double f;
    public int g;

    public A0(JSONObject jsonObject) {
        kotlin.jvm.internal.l.e(jsonObject, "jsonObject");
        this.b = true;
        this.c = true;
        this.a = jsonObject.optString("html");
        this.f = Double.valueOf(jsonObject.optDouble("display_duration"));
        JSONObject optJSONObject = jsonObject.optJSONObject("styles");
        this.b = !(optJSONObject == null ? false : optJSONObject.optBoolean("remove_height_margin", false));
        this.c = !(optJSONObject != null ? optJSONObject.optBoolean("remove_width_margin", false) : false);
        this.d = !this.b;
    }

    public final String a() {
        return this.a;
    }

    public final Double b() {
        return this.f;
    }

    public final v2.m c() {
        return this.e;
    }

    public final int d() {
        return this.g;
    }

    public final boolean e() {
        return this.b;
    }

    public final boolean f() {
        return this.c;
    }

    public final boolean g() {
        return this.d;
    }

    public final void h(String str) {
        this.a = str;
    }

    public final void i(v2.m mVar) {
        this.e = mVar;
    }

    public final void j(int i) {
        this.g = i;
    }
}
