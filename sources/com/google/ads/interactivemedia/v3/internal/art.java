package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class art implements Continuation {
    public final /* synthetic */ int a;
    public final /* synthetic */ afl b;

    public /* synthetic */ art(afl aflVar, int i, byte[] bArr) {
        this.b = aflVar;
        this.a = i;
    }

    public final Object then(Task task) {
        afl aflVar = this.b;
        int i = this.a;
        int i2 = aru.a;
        if (!task.isSuccessful()) {
            return Boolean.FALSE;
        }
        asz a = ((ata) task.getResult()).a(((afk) aflVar.aY()).av());
        a.b(i);
        a.a();
        return Boolean.TRUE;
    }
}
