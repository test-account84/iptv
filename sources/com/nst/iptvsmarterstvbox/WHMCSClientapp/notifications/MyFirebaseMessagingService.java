package com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications;

import android.content.Intent;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.nst.iptvsmarterstvbox.sbpfunction.activitypushnotification.NotificationPanelActivtiy;
import java.util.Iterator;
import q6.S;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public NotificationUtils h;
    public Intent i;

    public void d(Intent intent) {
        NotificationUtils notificationUtils;
        String str;
        Log.e("jaskirat", "handleIntent called");
        v(intent);
        Intent intent2 = new Intent(getApplicationContext(), NotificationPanelActivtiy.class);
        intent2.putExtra("fromNotification", "fromNotification");
        intent2.setFlags(335544320);
        intent2.setAction("notification_action");
        this.h = new NotificationUtils(getApplicationContext());
        if (t() != null && t().getExtras() != null) {
            Iterator it = t().getExtras().keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next();
                Object obj = t().getExtras().get(str2);
                if (!str2.equalsIgnoreCase("gcm.notification.title")) {
                    Log.e("jaskirat", "else condition");
                } else if (obj != null && obj.toString().equalsIgnoreCase("This app has been updated in the background.")) {
                    this.h.q("This app has been updated in the background.", "", "", intent2, "", "");
                    return;
                }
            }
            if (intent.getExtras() != null) {
                String stringExtra = intent.hasExtra("gcm.notification.title") ? intent.getStringExtra("gcm.notification.title") : "";
                String stringExtra2 = intent.hasExtra("gcm.notification.body") ? intent.getStringExtra("gcm.notification.body") : "";
                String stringExtra3 = intent.hasExtra("gcm.notification.image") ? intent.getStringExtra("gcm.notification.image") : "";
                String stringExtra4 = intent.hasExtra("custombody") ? intent.getStringExtra("custombody") : "";
                if (stringExtra != null && stringExtra.length() > 0 && stringExtra2 != null && stringExtra2.length() > 0) {
                    if (stringExtra3 == null || stringExtra3.length() <= 0) {
                        notificationUtils = this.h;
                        str = "";
                        stringExtra3 = "";
                    } else {
                        notificationUtils = this.h;
                        str = "";
                    }
                    notificationUtils.q(stringExtra, stringExtra2, str, intent2, stringExtra3, stringExtra4);
                    return;
                }
            }
        }
        super.d(intent);
    }

    public void o(S s) {
        Log.e("Result<<<>>>", "From: " + s.H());
        Intent intent = new Intent(getApplicationContext(), NotificationPanelActivtiy.class);
        intent.putExtra("fromNotification", "fromNotification");
        intent.setFlags(335544320);
        intent.setAction("notification_action");
        this.h = new NotificationUtils(getApplicationContext());
        Log.e("jaskirat", "noti called");
        u(s, intent);
    }

    public void q(String str) {
        super.q(str);
    }

    public Intent t() {
        return this.i;
    }

    public final void u(S s, Intent intent) {
        NotificationUtils notificationUtils;
        String str;
        String str2;
        String str3;
        String str4;
        if (s == null || s.I() == null) {
            if (t() == null || t().getExtras() == null) {
                return;
            }
            for (String str5 : t().getExtras().keySet()) {
                Object obj = t().getExtras().get(str5);
                Log.d("jaskirat", "Key: " + str5 + " Value: " + obj);
                if (str5.equalsIgnoreCase("gcm.notification.title")) {
                    if (obj == null || !obj.toString().equalsIgnoreCase("This app has been updated in the background.")) {
                        return;
                    }
                    notificationUtils = this.h;
                    str = "";
                    str2 = "";
                    str3 = "This app has been updated in the background.";
                    str4 = "";
                }
            }
            return;
        }
        if (s.I().b() == null) {
            this.h.q(s.I().d(), s.I().a(), "", intent, "", "");
            return;
        }
        notificationUtils = this.h;
        str3 = s.I().d();
        str4 = s.I().a();
        str = s.I().b().toString();
        str2 = "";
        notificationUtils.q(str3, str4, "", intent, str, str2);
    }

    public void v(Intent intent) {
        this.i = intent;
    }
}
