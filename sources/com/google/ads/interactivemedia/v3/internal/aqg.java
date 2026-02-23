package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aqg extends aqj {
    public aqg(String str, Long l) {
        super(1, str, l);
    }

    public final /* bridge */ /* synthetic */ Object a(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(h(), ((Long) g()).longValue()));
    }

    public final /* bridge */ /* synthetic */ Object b(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(h())) ? Long.valueOf(bundle.getLong("com.google.android.gms.ads.flag.".concat(h()))) : (Long) g();
    }

    public final /* bridge */ /* synthetic */ Object c(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(h(), ((Long) g()).longValue()));
    }
}
