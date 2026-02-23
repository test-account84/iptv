package com.google.android.play.core.integrity;

import android.content.Context;
import q5.C;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class j {
    private final j a = this;
    private final q5.d b;
    private final q5.d c;
    private final q5.d d;
    private final q5.d e;

    public /* synthetic */ j(Context context, i iVar) {
        q5.b b = q5.c.b(context);
        this.b = b;
        q5.d b2 = C.b(o.a());
        this.c = b2;
        q5.d b3 = C.b(new v(b, b2));
        this.d = b3;
        this.e = C.b(new n(b3));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.e.a();
    }
}
