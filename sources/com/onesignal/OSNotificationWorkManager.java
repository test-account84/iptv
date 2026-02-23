package com.onesignal;

import Q0.m;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.b;
import com.onesignal.F1;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class OSNotificationWorkManager {
    public static Set a = OSUtils.K();

    public static class NotificationWorker extends Worker {
        public NotificationWorker(Context context, WorkerParameters workerParameters) {
            super(context, workerParameters);
        }

        public ListenableWorker.a r() {
            androidx.work.b g = g();
            try {
                F1.c1(F1.v.DEBUG, "NotificationWorker running doWork with data: " + g);
                s(a(), g.i("android_notif_id", 0), new JSONObject(g.l("json_payload")), g.h("is_restoring", false), Long.valueOf(g.k("timestamp", System.currentTimeMillis() / 1000)));
                return ListenableWorker.a.c();
            } catch (JSONException e) {
                F1.c1(F1.v.ERROR, "Error occurred doing work for job with id: " + e().toString());
                e.printStackTrace();
                return ListenableWorker.a.a();
            }
        }

        public final void s(Context context, int i, JSONObject jSONObject, boolean z, Long l) {
            Q0 q0 = new Q0(null, jSONObject, i);
            a1 a1Var = new a1(new S0(context, q0, jSONObject, z, true, l), q0);
            List list = F1.a;
            F1.a(F1.v.WARN, "remoteNotificationReceivedHandler not setup, displaying normal OneSignal notification");
            a1Var.b(q0);
        }
    }

    public static boolean a(String str) {
        if (!OSUtils.I(str)) {
            return true;
        }
        if (!a.contains(str)) {
            a.add(str);
            return true;
        }
        F1.a(F1.v.DEBUG, "OSNotificationWorkManager notification with notificationId: " + str + " already queued");
        return false;
    }

    public static void b(Context context, String str, int i, String str2, long j, boolean z, boolean z2) {
        Q0.m b = new m.a(NotificationWorker.class).g(new b.a().f("android_notif_id", i).h("json_payload", str2).g("timestamp", j).e("is_restoring", z).a()).b();
        F1.a(F1.v.DEBUG, "OSNotificationWorkManager enqueueing notification work with notificationId: " + str + " and jsonPayload: " + str2);
        E1.a(context).d(str, Q0.d.KEEP, b);
    }

    public static void c(String str) {
        if (OSUtils.I(str)) {
            a.remove(str);
        }
    }
}
