package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.WindowManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class xy implements xx {
    private final WindowManager a;

    private xy(WindowManager windowManager) {
        this.a = windowManager;
    }

    public static xx c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            return new xy(windowManager);
        }
        return null;
    }

    public final void a() {
    }

    public final void b(xv xvVar) {
        xvVar.a(this.a.getDefaultDisplay());
    }
}
