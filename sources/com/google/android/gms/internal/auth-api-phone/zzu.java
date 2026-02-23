package com.google.android.gms.internal.auth-api-phone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.tasks.Task;
import j4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzu extends b {
    public zzu(Activity activity) {
        super(activity);
    }

    public final Task startSmsRetriever() {
        return doWrite(t.a().b(new zzx(this)).d(zzaa.zzb).a());
    }

    public final Task startSmsUserConsent(String str) {
        return doWrite(t.a().b(new zzw(this, str)).d(zzaa.zzc).a());
    }

    public zzu(Context context) {
        super(context);
    }
}
