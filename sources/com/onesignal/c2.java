package com.onesignal;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.onesignal.F1;
import com.onesignal.Y1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class c2 implements Y1 {
    public static boolean a;
    public static Y1.a b;

    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Y1.a c;

        public a(Context context, Y1.a aVar) {
            this.a = context;
            this.c = aVar;
        }

        public void run() {
            try {
                c2.b(c2.this, this.a, this.c);
            } catch (ApiException e) {
                F1.b(F1.v.ERROR, "HMS ApiException getting Huawei push token!", e);
                this.c.a(null, e.getStatusCode() == 907135000 ? -26 : -27);
            }
        }
    }

    public static /* synthetic */ void b(c2 c2Var, Context context, Y1.a aVar) {
        c2Var.d(context, aVar);
    }

    public static void c() {
        try {
            Thread.sleep(30000L);
        } catch (InterruptedException unused) {
        }
    }

    public void a(Context context, String str, Y1.a aVar) {
        b = aVar;
        new Thread(new a(context, aVar), "OS_HMS_GET_TOKEN").start();
    }

    public final synchronized void d(Context context, Y1.a aVar) {
        if (!OSUtils.p()) {
            aVar.a(null, -28);
            return;
        }
        String token = HmsInstanceId.getInstance(context).getToken(AGConnectServicesConfig.fromContext(context).getString("client/app_id"), "HCM");
        if (TextUtils.isEmpty(token)) {
            e(aVar);
        } else {
            F1.a(F1.v.INFO, "Device registered for HMS, push token = " + token);
            aVar.a(token, 1);
        }
    }

    public final void e(Y1.a aVar) {
        c();
        if (a) {
            return;
        }
        F1.a(F1.v.ERROR, "HmsMessageServiceOneSignal.onNewToken timed out.");
        aVar.a(null, -25);
    }
}
