package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class vd extends uu {
    private final uv a;
    private long b;
    private volatile boolean c;
    private zo d;

    public vd(cy cyVar, dc dcVar, s sVar, int i, uv uvVar) {
        super(cyVar, dcVar, 2, sVar, i, -9223372036854775807L, -9223372036854775807L);
        this.a = uvVar;
    }

    public final void a(zo zoVar) {
        this.d = zoVar;
    }

    public final void e() throws IOException {
        if (this.b == 0) {
            this.a.e(this.d, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            dc b = this.g.b(this.b);
            dv dvVar = this.n;
            zb zbVar = new zb(dvVar, b.e, dvVar.b(b));
            while (!this.c && this.a.c(zbVar)) {
                try {
                } finally {
                    this.b = zbVar.d() - this.g.e;
                }
            }
        } finally {
            af.e(this.n);
        }
    }

    public final void r() {
        this.c = true;
    }
}
