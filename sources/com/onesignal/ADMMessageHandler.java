package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.onesignal.F1;
import com.onesignal.T;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class ADMMessageHandler extends ADMMessageHandlerBase {
    private static final int JOB_ID = 123891;

    public class a implements T.e {
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ Context b;

        public a(Bundle bundle, Context context) {
            this.a = bundle;
            this.b = context;
        }

        public void a(T.f fVar) {
            if (fVar.c()) {
                return;
            }
            JSONObject a = T.a(this.a);
            Q0 q0 = new Q0(a);
            V0 v0 = new V0(this.b);
            v0.q(a);
            v0.o(this.b);
            v0.r(q0);
            T.m(v0, true);
        }
    }

    public ADMMessageHandler() {
        super("ADMMessageHandler");
    }

    public void onMessage(Intent intent) {
        Context applicationContext = getApplicationContext();
        Bundle extras = intent.getExtras();
        T.h(applicationContext, extras, new a(extras, applicationContext));
    }

    public void onRegistered(String str) {
        F1.a(F1.v.INFO, "ADM registration ID: " + str);
        Z1.c(str);
    }

    public void onRegistrationError(String str) {
        F1.v vVar = F1.v.ERROR;
        F1.a(vVar, "ADM:onRegistrationError: " + str);
        if ("INVALID_SENDER".equals(str)) {
            F1.a(vVar, "Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.");
        }
        Z1.c(null);
    }

    public void onUnregistered(String str) {
        F1.a(F1.v.INFO, "ADM:onUnregistered: " + str);
    }
}
