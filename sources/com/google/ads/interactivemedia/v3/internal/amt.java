package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class amt implements Runnable {
    final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public amt(ams amsVar, int i) {
        this.b = i;
        this.a = amsVar;
    }

    public final void run() {
        boolean z;
        int i = this.b;
        boolean z2 = false;
        if (i == 0) {
            if (((amu) this.a).b != null) {
                return;
            }
            synchronized (amu.a()) {
                if (((amu) this.a).b != null) {
                    return;
                }
                try {
                    z = ((Boolean) aqo.i.b()).booleanValue();
                } catch (IllegalStateException unused) {
                    z = false;
                }
                if (z) {
                    try {
                        amu.a = ata.c(amu.b((amu) this.a).a, "ADSHIELD");
                        z2 = z;
                    } catch (Throwable unused2) {
                    }
                } else {
                    z2 = z;
                }
                ((amu) this.a).b = Boolean.valueOf(z2);
                amu.a().open();
                return;
            }
        }
        if (i != 1) {
            if (i == 2) {
                anw.m((anw) this.a);
                return;
            } else if (i != 3) {
                aod.c((aod) this.a);
                return;
            } else {
                aqo.a(((anw) this.a).a);
                return;
            }
        }
        synchronized (ams.d((ams) this.a)) {
            if (ams.p((ams) this.a)) {
                return;
            }
            ams.i((ams) this.a, true);
            try {
                ams.j((ams) this.a);
            } catch (Exception e) {
                ams.c((ams) this.a).c(2023, -1L, e);
            }
            synchronized (ams.d((ams) this.a)) {
                ams.i((ams) this.a, false);
            }
        }
    }

    public amt(amu amuVar, int i) {
        this.b = i;
        this.a = amuVar;
    }

    public amt(anw anwVar, int i) {
        this.b = i;
        this.a = anwVar;
    }

    public amt(aod aodVar, int i) {
        this.b = i;
        this.a = aodVar;
    }
}
