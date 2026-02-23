package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f0 implements c.a {
    public final /* synthetic */ g a;

    public f0(g gVar) {
        this.a = gVar;
    }

    public final void a(boolean z) {
        g gVar = this.a;
        g.n(gVar).sendMessage(g.n(gVar).obtainMessage(1, Boolean.valueOf(z)));
    }
}
