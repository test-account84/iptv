package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class sk implements Handler.Callback {
    public final /* synthetic */ Object a;
    private final /* synthetic */ int b;

    public /* synthetic */ sk(ca caVar, int i) {
        this.b = i;
        this.a = caVar;
    }

    public final boolean handleMessage(Message message) {
        if (this.b != 0) {
            ca.h((ca) this.a);
            return true;
        }
        sp.N((sp) this.a, message);
        return true;
    }

    public /* synthetic */ sk(sp spVar, int i) {
        this.b = i;
        this.a = spVar;
    }
}
