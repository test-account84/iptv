package com.onesignal.shortcutbadger.impl;

import T7.a;
import T7.b;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Deprecated
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class XiaomiHomeBadger implements a {
    public ResolveInfo a;

    public List a() {
        return Arrays.asList(new String[]{"com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher"});
    }

    public void b(Context context, ComponentName componentName, int i) {
        Integer valueOf;
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            if (i == 0) {
                valueOf = "";
            } else {
                try {
                    valueOf = Integer.valueOf(i);
                } catch (Exception unused) {
                    declaredField.set(newInstance, Integer.valueOf(i));
                }
            }
            declaredField.set(newInstance, String.valueOf(valueOf));
        } catch (Exception unused2) {
            Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent.putExtra("android.intent.extra.update_application_component_name", componentName.getPackageName() + "/" + componentName.getClassName());
            intent.putExtra("android.intent.extra.update_application_message_text", String.valueOf(i != 0 ? Integer.valueOf(i) : ""));
            if (U7.a.a(context, intent)) {
                context.sendBroadcast(intent);
            }
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            c(context, i);
        }
    }

    public final void c(Context context, int i) {
        if (this.a == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            this.a = context.getPackageManager().resolveActivity(intent, 65536);
        }
        if (this.a != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Notification build = new Notification.Builder(context).setContentTitle("").setContentText("").setSmallIcon(this.a.getIconResource()).build();
            try {
                Object obj = build.getClass().getDeclaredField("extraNotification").get(build);
                obj.getClass().getDeclaredMethod("setMessageCount", new Class[]{Integer.TYPE}).invoke(obj, new Object[]{Integer.valueOf(i)});
                notificationManager.notify(0, build);
            } catch (Exception e) {
                throw new b("not able to set badge", e);
            }
        }
    }
}
