package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class db {
    private Uri a;
    private int b;
    private byte[] c;
    private Map d;
    private long e;
    private long f;
    private String g;
    private int h;

    public db() {
        this.b = 1;
        this.d = Collections.emptyMap();
        this.f = -1L;
    }

    public final dc a() {
        if (this.a != null) {
            return new dc(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }
        throw new IllegalStateException("The uri must be set.");
    }

    public final void b(int i) {
        this.h = i;
    }

    public final void c(byte[] bArr) {
        this.c = bArr;
    }

    public final void d() {
        this.b = 2;
    }

    public final void e(Map map) {
        this.d = map;
    }

    public final void f(String str) {
        this.g = str;
    }

    public final void g(long j) {
        this.f = j;
    }

    public final void h(long j) {
        this.e = j;
    }

    public final void i(Uri uri) {
        this.a = uri;
    }

    public final void j(String str) {
        this.a = Uri.parse(str);
    }

    public /* synthetic */ db(dc dcVar) {
        this.a = dcVar.a;
        this.b = dcVar.b;
        this.c = dcVar.c;
        this.d = dcVar.d;
        this.e = dcVar.e;
        this.f = dcVar.f;
        this.g = dcVar.g;
        this.h = dcVar.h;
    }
}
