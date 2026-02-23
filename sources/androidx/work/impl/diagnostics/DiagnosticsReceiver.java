package androidx.work.impl.diagnostics;

import Q0.k;
import Q0.m;
import Q0.u;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    public static final String a = k.f("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        k.c().a(a, "Requesting diagnostics", new Throwable[0]);
        try {
            u.f(context).b(m.d(DiagnosticsWorker.class));
        } catch (IllegalStateException e) {
            k.c().b(a, "WorkManager is not initialized", e);
        }
    }
}
