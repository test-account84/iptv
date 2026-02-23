package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.mediarouter.app.b;
import m0.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzz extends b {
    public /* bridge */ /* synthetic */ a getDefaultViewModelCreationExtras() {
        return h.a(this);
    }

    public final androidx.mediarouter.app.a onCreateChooserDialog(Context context, Bundle bundle) {
        zzy zzyVar = new zzy(context, 0);
        zzyVar.zze();
        return zzyVar;
    }
}
