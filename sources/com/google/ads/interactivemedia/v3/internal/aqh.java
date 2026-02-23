package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aqh extends aqj {
    public aqh(String str, Float f) {
        super(1, str, f);
    }

    public final /* bridge */ /* synthetic */ Object a(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(h(), ((Float) g()).floatValue()));
    }

    public final /* bridge */ /* synthetic */ Object b(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(h())) ? Float.valueOf(bundle.getFloat("com.google.android.gms.ads.flag.".concat(h()))) : (Float) g();
    }

    public final /* bridge */ /* synthetic */ Object c(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(h(), ((Float) g()).floatValue()));
    }
}
