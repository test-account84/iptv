package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ahl extends ahi {
    private WebView a;
    private Long b = null;
    private final Map c;

    public ahl(Map map) {
        this.c = map;
    }

    public static /* bridge */ /* synthetic */ WebView l(ahl ahlVar) {
        return ahlVar.a;
    }

    public final void c() {
        super.c();
        new Handler().postDelayed(new ahk(this), Math.max(4000 - (this.b == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.b.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.a = null;
    }

    public final void f(agt agtVar, agr agrVar) {
        JSONObject jSONObject = new JSONObject();
        Map f = agrVar.f();
        for (String str : f.keySet()) {
            ahn.h(jSONObject, str, (afe) f.get(str));
        }
        g(agtVar, agrVar, jSONObject);
    }

    public final void j() {
        WebView webView = new WebView(ahb.b().a());
        this.a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        i(this.a);
        ahd.a().h(this.a, null);
        Iterator it = this.c.keySet().iterator();
        if (!it.hasNext()) {
            this.b = Long.valueOf(System.nanoTime());
        } else {
            throw null;
        }
    }
}
