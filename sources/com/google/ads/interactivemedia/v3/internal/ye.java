package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class ye implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    private final /* synthetic */ int c;

    public /* synthetic */ ye(yh yhVar, bl blVar, int i) {
        this.c = i;
        this.a = yhVar;
        this.b = blVar;
    }

    public final void run() {
        int i = this.c;
        if (i == 0) {
            ((yh) this.a).k((ep) this.b);
            return;
        }
        if (i == 1) {
            ((yh) this.b).o((Exception) this.a);
        } else if (i == 2) {
            ((yh) this.a).i((ep) this.b);
        } else if (i != 3) {
            ((yh) this.b).h((String) this.a);
        } else {
            ((yh) this.a).p((bl) this.b);
        }
    }

    public /* synthetic */ ye(yh yhVar, ep epVar, int i) {
        this.c = i;
        this.a = yhVar;
        this.b = epVar;
    }

    public /* synthetic */ ye(yh yhVar, Exception exc, int i) {
        this.c = i;
        this.b = yhVar;
        this.a = exc;
    }

    public /* synthetic */ ye(yh yhVar, String str, int i) {
        this.c = i;
        this.b = yhVar;
        this.a = str;
    }
}
