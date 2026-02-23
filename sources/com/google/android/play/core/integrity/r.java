package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import q5.z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class r extends q5.o {
    final /* synthetic */ byte[] a;
    final /* synthetic */ Long b;
    final /* synthetic */ TaskCompletionSource c;
    final /* synthetic */ IntegrityTokenRequest d;
    final /* synthetic */ t e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(t tVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.e = tVar;
        this.a = bArr;
        this.b = l;
        this.c = taskCompletionSource2;
        this.d = integrityTokenRequest;
    }

    public final void a(Exception exc) {
        if (exc instanceof z) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, q5.k] */
    public final void b() {
        try {
            this.e.a.e().n(t.a(this.e, this.a, this.b), new s(this.e, this.c));
        } catch (RemoteException e) {
            t.c(this.e).c(e, "requestIntegrityToken(%s)", this.d);
            this.c.trySetException(new IntegrityServiceException(-100, e));
        }
    }
}
