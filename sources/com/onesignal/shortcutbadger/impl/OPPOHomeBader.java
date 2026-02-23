package com.onesignal.shortcutbadger.impl;

import T7.a;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class OPPOHomeBader implements a {
    public int a = -1;

    public List a() {
        return Collections.singletonList("com.oppo.launcher");
    }

    public void b(Context context, ComponentName componentName, int i) {
        if (this.a == i) {
            return;
        }
        this.a = i;
        c(context, i);
    }

    public final void c(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
    }
}
