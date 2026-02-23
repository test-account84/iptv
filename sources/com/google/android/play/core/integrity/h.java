package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class h implements k {
    private Context a;

    private h() {
    }

    public final h a(Context context) {
        context.getClass();
        this.a = context;
        return this;
    }

    public final j b() {
        Context context = this.a;
        if (context != null) {
            return new j(context, null);
        }
        throw new IllegalStateException(String.valueOf(Context.class.getCanonicalName()).concat(" must be set"));
    }

    public /* synthetic */ h(g gVar) {
    }
}
