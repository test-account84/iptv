package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

@SuppressLint({"SetJavaScriptEnabled", "NewApi"})
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ake {
    private final WebView a;
    private final Handler b;
    private akb c;
    private boolean d = false;

    public ake(Handler handler, WebView webView, Uri uri) {
        this.b = handler;
        this.a = webView;
        webView.setBackgroundColor(0);
        webView.getSettings().setMixedContentMode(0);
        webView.getSettings().setJavaScriptEnabled(true);
        if (O0.f.a("WEB_MESSAGE_LISTENER")) {
            String format = String.format("%s://%s", new Object[]{uri.getScheme(), uri.getHost()});
            O0.e.a(webView, "androidWebViewCompatSender", avx.n(uri.getPort() != -1 ? String.format("%s:%s", new Object[]{format, Integer.valueOf(uri.getPort())}) : format), new aka(this));
        }
        webView.setWebViewClient(new akd(this));
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(webView, true);
    }

    public final WebView a() {
        return this.a;
    }

    public final void b() {
        this.b.post(new ajy(this));
    }

    public final /* synthetic */ void c() {
        this.d = true;
        this.a.destroy();
    }

    public final /* synthetic */ void d(ajr ajrVar) {
        String g = ajrVar.g();
        boolean z = this.d;
        String valueOf = String.valueOf(ajrVar);
        if (z) {
            com.google.ads.interactivemedia.v3.impl.data.m.d("Attempted to send bridge message after cleanup: " + valueOf + "; " + g);
            return;
        }
        com.google.ads.interactivemedia.v3.impl.data.m.c("Sending Javascript msg: " + valueOf + "; URL: " + g);
        try {
            this.a.evaluateJavascript(g, (ValueCallback) null);
        } catch (IllegalStateException unused) {
            this.a.loadUrl(g);
        }
    }

    public final void e(String str) {
        this.a.loadUrl(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = ", Message Type: "
            int r1 = r7.hashCode()     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
            r2 = 48
            r3 = 1
            if (r1 == r2) goto L1a
            r2 = 52
            if (r1 == r2) goto L10
            goto L24
        L10:
            java.lang.String r1 = "4"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L24
            r1 = 1
            goto L25
        L1a:
            java.lang.String r1 = "0"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L24
            r1 = 0
            goto L25
        L24:
            r1 = -1
        L25:
            if (r1 == 0) goto L32
            if (r1 == r3) goto L2b
            r1 = 0
            goto L36
        L2b:
            com.google.ads.interactivemedia.v3.internal.ajr r1 = com.google.ads.interactivemedia.v3.internal.ajr.d(r6)     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
            goto L36
        L30:
            r1 = move-exception
            goto L54
        L32:
            com.google.ads.interactivemedia.v3.internal.ajr r1 = com.google.ads.interactivemedia.v3.internal.ajr.c(r6)     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
        L36:
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
            r3.<init>()     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
            java.lang.String r4 = "Received Javascript msg: "
            r3.append(r4)     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
            r3.append(r2)     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
            com.google.ads.interactivemedia.v3.impl.data.m.c(r2)     // Catch: java.lang.Exception -> L30 java.lang.IllegalArgumentException -> L6f
            com.google.ads.interactivemedia.v3.internal.akb r6 = r5.c
            r6.k(r1)
            return
        L54:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid internal message. Message could not be be parsed: "
            r2.append(r3)
            r2.append(r6)
            r2.append(r0)
            r2.append(r7)
            java.lang.String r6 = r2.toString()
            com.google.ads.interactivemedia.v3.impl.data.m.b(r6, r1)
            return
        L6f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid internal message. Make sure the Google IMA SDK library is up to date. Message: "
            r1.append(r2)
            r1.append(r6)
            r1.append(r0)
            r1.append(r7)
            java.lang.String r6 = r1.toString()
            com.google.ads.interactivemedia.v3.impl.data.m.d(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ake.f(java.lang.String, java.lang.String):void");
    }

    public final void g(akb akbVar) {
        this.c = akbVar;
    }

    public final void h(ajr ajrVar) {
        this.b.post(new ajz(this, ajrVar));
    }
}
