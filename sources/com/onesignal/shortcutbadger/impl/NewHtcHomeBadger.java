package com.onesignal.shortcutbadger.impl;

import T7.a;
import T7.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NewHtcHomeBadger implements a {
    public List a() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }

    public void b(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i);
        Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent2.putExtra("packagename", componentName.getPackageName());
        intent2.putExtra("count", i);
        if (U7.a.a(context, intent) || U7.a.a(context, intent2)) {
            context.sendBroadcast(intent);
            context.sendBroadcast(intent2);
        } else {
            throw new b("unable to resolve intent: " + intent2.toString());
        }
    }
}
