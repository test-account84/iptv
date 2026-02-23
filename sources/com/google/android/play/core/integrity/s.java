package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class s extends q5.l {
    final /* synthetic */ t a;
    private final q5.n b = new q5.n("OnRequestIntegrityTokenCallback");
    private final TaskCompletionSource c;

    public s(t tVar, TaskCompletionSource taskCompletionSource) {
        this.a = tVar;
        this.c = taskCompletionSource;
    }

    public final void b(Bundle bundle) {
        this.a.a.r(this.c);
        this.b.d("onRequestIntegrityToken", new Object[0]);
        int i = bundle.getInt("error");
        if (i != 0) {
            this.c.trySetException(new IntegrityServiceException(i, null));
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.c.trySetException(new IntegrityServiceException(-100, null));
            return;
        }
        TaskCompletionSource taskCompletionSource = this.c;
        d dVar = new d();
        dVar.a(string);
        taskCompletionSource.trySetResult(dVar.b());
    }
}
