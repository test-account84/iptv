package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class arg implements com.google.android.gms.common.api.internal.q {
    public final /* synthetic */ arj a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;

    public /* synthetic */ arg(arj arjVar, String str, int i, String str2) {
        this.a = arjVar;
        this.b = str;
        this.c = i;
        this.d = str2;
    }

    public final void accept(Object obj, Object obj2) {
        String str = this.b;
        int i = this.c;
        String str2 = this.d;
        ((ara) ((ark) obj).getService()).e(new arb(str, i, str2), new ari((TaskCompletionSource) obj2));
    }
}
