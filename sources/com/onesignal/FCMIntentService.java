package com.onesignal;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.T;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class FCMIntentService extends IntentService {

    public class a implements T.e {
        public final /* synthetic */ Intent a;

        public a(Intent intent) {
            this.a = intent;
        }

        public void a(T.f fVar) {
            k0.a.b(this.a);
        }
    }

    public FCMIntentService() {
        super("FCMIntentService");
        setIntentRedelivery(true);
    }

    public void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        F1.K0(this);
        T.h(this, extras, new a(intent));
    }
}
