package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aje extends WebViewClient {
    final /* synthetic */ ajf a;

    public aje(ajf ajfVar) {
        this.a = ajfVar;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.a.b.a(str);
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((CompanionAdSlot.ClickListener) it.next()).onCompanionAdClick();
        }
        return true;
    }
}
