package com.onesignal;

import Q0.m;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.onesignal.F1;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class OSNotificationRestoreWorkManager {
    public static final String[] a = {"notification_id", "android_notification_id", "full_data", "created_time"};
    public static final String b = NotificationRestoreWorker.class.getCanonicalName();
    public static boolean c;

    public static class NotificationRestoreWorker extends Worker {
        public NotificationRestoreWorker(Context context, WorkerParameters workerParameters) {
            super(context, workerParameters);
        }

        public ListenableWorker.a r() {
            Context a = a();
            if (F1.b == null) {
                F1.K0(a);
            }
            if (OSUtils.a(a) && !OSNotificationRestoreWorkManager.c) {
                OSNotificationRestoreWorkManager.c = true;
                F1.a(F1.v.INFO, "Restoring notifications");
                M1 i = M1.i(a);
                StringBuilder n = M1.n();
                OSNotificationRestoreWorkManager.a(a, n);
                OSNotificationRestoreWorkManager.b(a, i, n);
                return ListenableWorker.a.c();
            }
            return ListenableWorker.a.a();
        }
    }

    public static /* synthetic */ void a(Context context, StringBuilder sb) {
        f(context, sb);
    }

    public static /* synthetic */ void b(Context context, M1 m1, StringBuilder sb) {
        d(context, m1, sb);
    }

    public static void c(Context context, boolean z) {
        E1.a(context).d(b, Q0.d.KEEP, new m.a(NotificationRestoreWorker.class).f(z ? 15 : 0, TimeUnit.SECONDS).b());
    }

    public static void d(Context context, M1 m1, StringBuilder sb) {
        F1.a(F1.v.INFO, "Querying DB for notifications to restore: " + sb.toString());
        Cursor cursor = null;
        try {
            cursor = m1.c("notification", a, sb.toString(), null, null, null, "_id DESC", k0.a);
            e(context, cursor, 200);
            l.c(m1, context);
        } catch (Throwable th) {
            try {
                F1.b(F1.v.ERROR, "Error restoring notification records! ", th);
                if (cursor == null || cursor.isClosed()) {
                    return;
                }
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
    }

    public static void e(Context context, Cursor cursor, int i) {
        if (cursor.moveToFirst()) {
            do {
                OSNotificationWorkManager.b(context, cursor.getString(cursor.getColumnIndex("notification_id")), cursor.getInt(cursor.getColumnIndex("android_notification_id")), cursor.getString(cursor.getColumnIndex("full_data")), cursor.getLong(cursor.getColumnIndex("created_time")), true, false);
                if (i > 0) {
                    OSUtils.V(i);
                }
            } while (cursor.moveToNext());
        }
    }

    public static void f(Context context, StringBuilder sb) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        StatusBarNotification[] d = Q1.d(context);
        if (d.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (StatusBarNotification statusBarNotification : d) {
            arrayList.add(Integer.valueOf(statusBarNotification.getId()));
        }
        sb.append(" AND android_notification_id NOT IN (");
        sb.append(TextUtils.join(",", arrayList));
        sb.append(")");
    }
}
