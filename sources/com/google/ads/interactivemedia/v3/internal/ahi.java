package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import android.webkit.WebView;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class ahi {
    private aia a;
    private long b;
    private int c;

    public ahi() {
        b();
        this.a = new aia((WebView) null);
    }

    public final WebView a() {
        return (WebView) this.a.get();
    }

    public final void b() {
        this.b = System.nanoTime();
        this.c = 1;
    }

    public void c() {
        this.a.clear();
    }

    public final void d(String str, long j) {
        if (j < this.b || this.c == 3) {
            return;
        }
        this.c = 3;
        ahd.a().f(a(), str);
    }

    public final void e(String str, long j) {
        if (j >= this.b) {
            this.c = 2;
            ahd.a().f(a(), str);
        }
    }

    public void f(agt agtVar, agr agrVar) {
        g(agtVar, agrVar, null);
    }

    public final void g(agt agtVar, agr agrVar, JSONObject jSONObject) {
        String i = agtVar.i();
        JSONObject jSONObject2 = new JSONObject();
        ahn.h(jSONObject2, "environment", "app");
        ahn.h(jSONObject2, "adSessionType", agrVar.b());
        JSONObject jSONObject3 = new JSONObject();
        ahn.h(jSONObject3, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        ahn.h(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        ahn.h(jSONObject3, "os", "Android");
        ahn.h(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        ahn.h(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        ahn.h(jSONObject4, "partnerName", agrVar.h().i());
        ahn.h(jSONObject4, "partnerVersion", agrVar.h().j());
        ahn.h(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        ahn.h(jSONObject5, "libraryVersion", "1.3.37-google_20220829");
        ahn.h(jSONObject5, "appId", ahb.b().a().getApplicationContext().getPackageName());
        ahn.h(jSONObject2, "app", jSONObject5);
        if (agrVar.c() != null) {
            ahn.h(jSONObject2, "contentUrl", agrVar.c());
        }
        ahn.h(jSONObject2, "customReferenceData", agrVar.d());
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = agrVar.e().iterator();
        if (it.hasNext()) {
            throw null;
        }
        ahd.a().g(a(), i, jSONObject2, jSONObject6, jSONObject);
    }

    public final void h(float f) {
        ahd.a().e(a(), f);
    }

    public final void i(WebView webView) {
        this.a = new aia(webView);
    }

    public void j() {
    }

    public final boolean k() {
        return this.a.get() != null;
    }
}
