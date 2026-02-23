package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.ads.interactivemedia.v3.api.AdsRenderingSettings;
import java.util.HashSet;
import org.json.JSONObject;
import p.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aly {
    private final Object a;
    private Object b;

    public aly(Context context, AdsRenderingSettings adsRenderingSettings) {
        this.a = context;
        this.b = adsRenderingSettings;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.ads.interactivemedia.v3.api.AdsRenderingSettings, java.lang.Object] */
    public final void a(String str) {
        if (this.b.getEnableCustomTabs()) {
            new d.a().a().a((Context) this.a, Uri.parse(str));
            return;
        }
        Object obj = this.a;
        if (str == null || str.length() <= 0) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!(obj instanceof Activity)) {
            intent.setFlags(268435456);
        }
        ((Context) obj).startActivity(intent);
    }

    public final void b(AdsRenderingSettings adsRenderingSettings) {
        this.b = adsRenderingSettings;
    }

    public final JSONObject c() {
        return (JSONObject) this.b;
    }

    public final void d() {
        ((ahw) this.a).a(new ahx(this, null));
    }

    public final void e(JSONObject jSONObject, HashSet hashSet, long j) {
        ((ahw) this.a).a(new ahy(this, hashSet, jSONObject, j, null));
    }

    public final void f(JSONObject jSONObject, HashSet hashSet, long j) {
        ((ahw) this.a).a(new ahz(this, hashSet, jSONObject, j, null));
    }

    public final void g(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public aly(ahw ahwVar) {
        this.a = ahwVar;
    }
}
