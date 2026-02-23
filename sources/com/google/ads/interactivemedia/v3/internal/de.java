package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class de implements cy {
    private final Context a;
    private final List b;
    private final cy c;
    private cy d;
    private cy e;
    private cy f;
    private cy g;
    private cy h;
    private cy i;
    private cy j;
    private cy k;

    public de(Context context, cy cyVar) {
        this.a = context.getApplicationContext();
        af.s(cyVar);
        this.c = cyVar;
        this.b = new ArrayList();
    }

    private final cy g() {
        if (this.e == null) {
            cs csVar = new cs(this.a);
            this.e = csVar;
            h(csVar);
        }
        return this.e;
    }

    private final void h(cy cyVar) {
        for (int i = 0; i < this.b.size(); i++) {
            cyVar.f((dw) this.b.get(i));
        }
    }

    private static final void i(cy cyVar, dw dwVar) {
        if (cyVar != null) {
            cyVar.f(dwVar);
        }
    }

    public final int a(byte[] bArr, int i, int i2) throws IOException {
        cy cyVar = this.k;
        af.s(cyVar);
        return cyVar.a(bArr, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long b(com.google.ads.interactivemedia.v3.internal.dc r3) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.de.b(com.google.ads.interactivemedia.v3.internal.dc):long");
    }

    public final Uri c() {
        cy cyVar = this.k;
        if (cyVar == null) {
            return null;
        }
        return cyVar.c();
    }

    public final void d() throws IOException {
        cy cyVar = this.k;
        if (cyVar != null) {
            try {
                cyVar.d();
            } finally {
                this.k = null;
            }
        }
    }

    public final Map e() {
        cy cyVar = this.k;
        return cyVar == null ? Collections.emptyMap() : cyVar.e();
    }

    public final void f(dw dwVar) {
        af.s(dwVar);
        this.c.f(dwVar);
        this.b.add(dwVar);
        i(this.d, dwVar);
        i(this.e, dwVar);
        i(this.f, dwVar);
        i(this.g, dwVar);
        i(this.h, dwVar);
        i(this.i, dwVar);
        i(this.j, dwVar);
    }
}
