package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b0 extends zau {
    public final /* synthetic */ c0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(c0 c0Var, Looper looper) {
        super(looper);
        this.a = c0Var;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((a0) message.obj).b(this.a);
        } else {
            if (i == 2) {
                throw ((RuntimeException) message.obj);
            }
            Log.w("GACStateManager", "Unknown message id: " + i);
        }
    }
}
