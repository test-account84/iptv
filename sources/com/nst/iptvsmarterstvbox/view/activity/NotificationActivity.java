package com.nst.iptvsmarterstvbox.view.activity;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NotificationActivity extends Activity {
    public SharedPreferences a;
    public final String c = "CANCELLED";

    public static PendingIntent a(int i, Context context) {
        Intent intent = new Intent(context, NotificationActivity.class);
        intent.setFlags(268468224);
        intent.putExtra("NOTIFICATION_ID", i);
        return PendingIntent.getActivity(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 67108864 : 268435456);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.a = defaultSharedPreferences;
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.putBoolean("CANCELLED", true);
        edit.apply();
        notificationManager.cancel(getIntent().getIntExtra("NOTIFICATION_ID", -1));
        finish();
    }
}
