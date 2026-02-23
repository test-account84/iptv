package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class aqj {
    private final int a;
    private final String b;
    private final Object c;

    public /* synthetic */ aqj(int i, String str, Object obj) {
        this.a = i;
        this.b = str;
        this.c = obj;
        aqd.c().f(this);
    }

    public static aqj e(int i, String str, Boolean bool) {
        return new aqe(i, str, bool);
    }

    public static void i(String str, float f) {
        new aqh(str, Float.valueOf(f));
    }

    public static void j(String str, int i) {
        new aqf(str, Integer.valueOf(i));
    }

    public static aqj k(String str, long j) {
        return new aqg(str, Long.valueOf(j));
    }

    public static aqj l(String str, String str2) {
        return new aqi(str, str2);
    }

    public static void m() {
        aqd.c().e(l("gads:sdk_core_constants:experiment_id", null));
    }

    public abstract Object a(JSONObject jSONObject);

    public abstract Object b(Bundle bundle);

    public abstract Object c(SharedPreferences sharedPreferences);

    public final int d() {
        return this.a;
    }

    public final Object f() {
        return aqd.a().b(this);
    }

    public final Object g() {
        return this.c;
    }

    public final String h() {
        return this.b;
    }
}
