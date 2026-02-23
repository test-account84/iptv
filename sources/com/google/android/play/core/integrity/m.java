package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class m implements IntegrityManager {
    private final t a;

    public m(t tVar) {
        this.a = tVar;
    }

    public final Task requestIntegrityToken(IntegrityTokenRequest integrityTokenRequest) {
        return this.a.b(integrityTokenRequest);
    }
}
