package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class Q {
    public static final Q a = new Q();

    public final void a(Context context) {
        kotlin.jvm.internal.l.e(context, "context");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse(kotlin.jvm.internal.l.l("package:", context.getPackageName())));
        context.startActivity(intent);
    }
}
