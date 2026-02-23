package com.onesignal.shortcutbadger.impl;

import T7.a;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ZukHomeBadger implements a {
    public final Uri a = Uri.parse("content://com.android.badge/badge");

    public List a() {
        return Collections.singletonList("com.zui.launcher");
    }

    public void b(Context context, ComponentName componentName, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        context.getContentResolver().call(this.a, "setAppBadgeCount", (String) null, bundle);
    }
}
