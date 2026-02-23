package v4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ Intent c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ BroadcastReceiver.PendingResult f;

    public /* synthetic */ i(b bVar, Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        this.a = bVar;
        this.c = intent;
        this.d = context;
        this.e = z;
        this.f = pendingResult;
    }

    public final void run() {
        this.a.d(this.c, this.d, this.e, this.f);
    }
}
