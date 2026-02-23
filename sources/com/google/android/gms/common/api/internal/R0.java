package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class r0 extends BroadcastReceiver {
    public Context a;
    public final q0 b;

    public r0(q0 q0Var) {
        this.b = q0Var;
    }

    public final void a(Context context) {
        this.a = context;
    }

    public final synchronized void b() {
        try {
            Context context = this.a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.b.a();
            b();
        }
    }
}
