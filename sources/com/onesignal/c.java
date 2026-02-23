package com.onesignal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class C {

    public class a implements Runnable {

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                R1.j(R1.a, "GT_DO_NOT_SHOW_MISSING_GPS", true);
            }
        }

        public class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ Activity a;

            public b(Activity activity) {
                this.a = activity;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                C.b(this.a);
            }
        }

        public void run() {
            Activity P = F1.P();
            if (P == null) {
                return;
            }
            String k = OSUtils.k(P, "onesignal_gms_missing_alert_text", "To receive push notifications please press 'Update' to enable 'Google Play services'.");
            String k2 = OSUtils.k(P, "onesignal_gms_missing_alert_button_update", "Update");
            String k3 = OSUtils.k(P, "onesignal_gms_missing_alert_button_skip", "Skip");
            new AlertDialog.Builder(P).setMessage(k).setPositiveButton(k2, new b(P)).setNegativeButton(k3, new a()).setNeutralButton(OSUtils.k(P, "onesignal_gms_missing_alert_button_close", "Close"), (DialogInterface.OnClickListener) null).create().show();
        }
    }

    public static void a(Activity activity) {
        try {
            w4.h q = w4.h.q();
            PendingIntent e = q.e(activity, q.i(F1.b), 9000);
            if (e != null) {
                e.send();
            }
        } catch (PendingIntent.CanceledException e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void b(Activity activity) {
        a(activity);
    }

    public static boolean c() {
        A a2 = X1.a.a(F1.b, "com.google.android.gms", 128);
        if (!a2.b() || a2.a() == null) {
            return false;
        }
        return !a2.a().applicationInfo.loadLabel(F1.b.getPackageManager()).equals("Market");
    }

    public static void d() {
        if (OSUtils.B() && c() && !F1.W() && !R1.b(R1.a, "GT_DO_NOT_SHOW_MISSING_GPS", false)) {
            OSUtils.S(new a());
        }
    }
}
