package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ok extends IOException {
    public final dc a;
    public final Uri b;
    public final Map c;
    public final long d;

    public ok(dc dcVar, Uri uri, Map map, long j, Throwable th) {
        super(th);
        this.a = dcVar;
        this.b = uri;
        this.c = map;
        this.d = j;
    }
}
