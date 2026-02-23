package com.nst.iptvsmarterstvbox.WHMCSClientapp.notifications;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class MyFirebaseInstanceIDService extends FirebaseMessagingService {
    public static final String h = "MyFirebaseInstanceIDService";

    public void q(String str) {
        super.q(str);
        u(str);
        t(str);
        Intent intent = new Intent("registrationComplete");
        intent.putExtra("token", str);
        p0.a.b(this).d(intent);
    }

    public final void t(String str) {
        Log.e(h, "sendRegistrationToServer: " + str);
    }

    public final void u(String str) {
        SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("ah_firebase", 0).edit();
        edit.putString("regId", str);
        edit.commit();
    }
}
