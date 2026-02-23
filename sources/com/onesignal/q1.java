package com.onesignal;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class Q1 {
    public static boolean a(Context context, String str) {
        NotificationChannel a;
        if (D.L.d(context).a()) {
            return Build.VERSION.SDK_INT < 26 || (a = w4.e.a(i(context), str)) == null || O1.a(a) != 0;
        }
        return false;
    }

    public static void b(Context context, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            StatusBarNotification statusBarNotification = (StatusBarNotification) it.next();
            D.L.d(context).f(statusBarNotification.getId(), P1.a(context, statusBarNotification.getNotification()).setGroup("os_group_undefined").setOnlyAlertOnce(true).build());
        }
    }

    public static ArrayList c(Context context) {
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : d(context)) {
            Notification notification = statusBarNotification.getNotification();
            boolean f = k0.f(statusBarNotification);
            boolean z = notification.getGroup() == null || notification.getGroup().equals(g());
            if (!f && z) {
                arrayList.add(statusBarNotification);
            }
        }
        return arrayList;
    }

    public static StatusBarNotification[] d(Context context) {
        StatusBarNotification[] statusBarNotificationArr = new StatusBarNotification[0];
        try {
            return N1.a(i(context));
        } catch (Throwable unused) {
            return statusBarNotificationArr;
        }
    }

    public static Integer e(Context context) {
        int i = 0;
        for (StatusBarNotification statusBarNotification : d(context)) {
            if (!D.l.b(statusBarNotification.getNotification()) && "os_group_undefined".equals(statusBarNotification.getNotification().getGroup())) {
                i++;
            }
        }
        return Integer.valueOf(i);
    }

    public static int f() {
        return -718463522;
    }

    public static String g() {
        return "os_group_undefined";
    }

    public static Integer h(M1 m1, String str, boolean z) {
        Cursor c = m1.c("notification", null, (z ? "group_id IS NULL" : "group_id = ?") + " AND dismissed = 0 AND opened = 0 AND is_summary = 0", z ? null : new String[]{str}, null, null, "created_time DESC", "1");
        if (!c.moveToFirst()) {
            c.close();
            return null;
        }
        Integer valueOf = Integer.valueOf(c.getInt(c.getColumnIndex("android_notification_id")));
        c.close();
        return valueOf;
    }

    public static NotificationManager i(Context context) {
        return (NotificationManager) context.getSystemService("notification");
    }
}
