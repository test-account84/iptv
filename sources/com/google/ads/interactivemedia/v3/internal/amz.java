package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class amz implements ash {
    final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public amz(ana anaVar, int i) {
        this.b = i;
        this.a = anaVar;
    }

    public final void a(int i, long j) {
        aru b;
        long currentTimeMillis;
        if (this.b != 0) {
            Object obj = this.a;
            currentTimeMillis = System.currentTimeMillis();
            b = (aru) obj;
        } else {
            b = ana.b((ana) this.a);
            currentTimeMillis = System.currentTimeMillis();
        }
        b.d(i, currentTimeMillis - j);
    }

    public final void b(int i, long j, String str) {
        aru b;
        long currentTimeMillis;
        if (this.b != 0) {
            Object obj = this.a;
            currentTimeMillis = System.currentTimeMillis();
            b = (aru) obj;
        } else {
            b = ana.b((ana) this.a);
            currentTimeMillis = System.currentTimeMillis();
        }
        b.e(i, currentTimeMillis - j, str);
    }

    public amz(aru aruVar, int i) {
        this.b = i;
        this.a = aruVar;
    }
}
