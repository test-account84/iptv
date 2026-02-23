package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class rz implements xe {
    private final xe a;
    private final List b;

    public rz(xe xeVar, List list) {
        this.a = xeVar;
        this.b = list;
    }

    public final /* bridge */ /* synthetic */ Object a(Uri uri, InputStream inputStream) throws IOException {
        ry ryVar = (ry) this.a.a(uri, inputStream);
        List list = this.b;
        return (list == null || list.isEmpty()) ? ryVar : (ry) ryVar.e(this.b);
    }
}
