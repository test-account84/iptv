package com.onesignal.shortcutbadger.impl;

import T7.a;
import T7.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class DefaultBadger implements a {
    public List a() {
        return new ArrayList(0);
    }

    public void b(Context context, ComponentName componentName, int i) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        if (U7.a.a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new b("unable to resolve intent: " + intent.toString());
    }

    public boolean c(Context context) {
        return U7.a.a(context, new Intent("android.intent.action.BADGE_COUNT_UPDATE"));
    }
}
