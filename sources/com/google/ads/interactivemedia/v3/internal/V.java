package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class v {
    private String a;
    private Uri b;
    private final w c = new w();
    private final z d = new z(null);
    private final List e = Collections.emptyList();
    private final avo f = avo.o();
    private final ab g = new ab();
    private final ag h = ag.a;

    public final ai a() {
        af.w(true);
        Uri uri = this.b;
        ae aeVar = uri != null ? new ae(uri, null, this.e, this.f) : null;
        String str = this.a;
        if (str == null) {
            str = "";
        }
        return new ai(str, this.c.a(), aeVar, this.g.f(), al.a, this.h);
    }

    public final void b(String str) {
        this.a = str;
    }

    public final void c(Uri uri) {
        this.b = uri;
    }
}
