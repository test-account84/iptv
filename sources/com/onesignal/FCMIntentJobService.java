package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.T;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class FCMIntentJobService extends JobIntentService {

    public class a implements T.e {
        public a() {
        }

        public void a(T.f fVar) {
        }
    }

    public static void j(Context context, Intent intent) {
        JobIntentService.d(context, FCMIntentJobService.class, 123890, intent, false);
    }

    public void g(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        F1.K0(this);
        T.h(this, extras, new a());
    }

    public /* bridge */ /* synthetic */ boolean h() {
        return super.h();
    }

    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public /* bridge */ /* synthetic */ void onCreate() {
        super.onCreate();
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
