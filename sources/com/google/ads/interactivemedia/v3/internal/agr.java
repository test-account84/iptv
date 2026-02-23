package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class agr {
    private final WebView a;
    private final List b = new ArrayList();
    private final Map c = new HashMap();
    private final String d;
    private final String e;
    private final ags f;
    private final bdy g;

    private agr(bdy bdyVar, WebView webView, String str, String str2, ags agsVar, byte[] bArr, byte[] bArr2) {
        this.g = bdyVar;
        this.a = webView;
        this.f = agsVar;
        this.e = str;
        this.d = str2;
    }

    public static agr g(bdy bdyVar, WebView webView, String str, String str2) {
        if (str2.length() <= 256) {
            return new agr(bdyVar, webView, str, str2, ags.c, null, null);
        }
        throw new IllegalArgumentException("CustomReferenceData is greater than 256 characters");
    }

    public final WebView a() {
        return this.a;
    }

    public final ags b() {
        return this.f;
    }

    public final String c() {
        return this.e;
    }

    public final String d() {
        return this.d;
    }

    public final List e() {
        return Collections.unmodifiableList(this.b);
    }

    public final Map f() {
        return Collections.unmodifiableMap(this.c);
    }

    public final bdy h() {
        return this.g;
    }
}
