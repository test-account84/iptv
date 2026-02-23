package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aqe extends aqj {
    public aqe(int i, String str, Boolean bool) {
        super(i, str, bool);
    }

    public final /* bridge */ /* synthetic */ Object a(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(h(), ((Boolean) g()).booleanValue()));
    }

    public final /* bridge */ /* synthetic */ Object b(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(h())) ? Boolean.valueOf(bundle.getBoolean("com.google.android.gms.ads.flag.".concat(h()))) : (Boolean) g();
    }

    public final /* bridge */ /* synthetic */ Object c(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(h(), ((Boolean) g()).booleanValue()));
    }
}
