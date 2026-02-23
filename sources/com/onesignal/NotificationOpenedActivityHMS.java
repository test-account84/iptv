package com.onesignal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class NotificationOpenedActivityHMS extends Activity {
    public final void a() {
        b(getIntent());
        finish();
    }

    public final void b(Intent intent) {
        n0.b(this, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a();
    }
}
