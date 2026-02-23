package com.onesignal;

import Q0.b;
import Q0.m;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.b;
import com.onesignal.F1;
import com.onesignal.T1;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class OSReceiveReceiptController {
    public static OSReceiveReceiptController d;
    public int a = 0;
    public int b = 25;
    public final h1 c = F1.j0();

    public static class ReceiveReceiptWorker extends Worker {

        public class a extends T1.g {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            public void a(int i, String str, Throwable th) {
                F1.a(F1.v.ERROR, "Receive receipt failed with statusCode: " + i + " response: " + str);
            }

            public void b(String str) {
                F1.a(F1.v.DEBUG, "Receive receipt sent for notificationID: " + this.a);
            }
        }

        public ReceiveReceiptWorker(Context context, WorkerParameters workerParameters) {
            super(context, workerParameters);
        }

        public ListenableWorker.a r() {
            s(g().l("os_notification_id"));
            return ListenableWorker.a.c();
        }

        public void s(String str) {
            Integer num;
            String str2 = F1.d;
            String n0 = (str2 == null || str2.isEmpty()) ? F1.n0() : F1.d;
            String y0 = F1.y0();
            g1 g1Var = new g1();
            try {
                num = Integer.valueOf(new OSUtils().e());
            } catch (NullPointerException e) {
                e.printStackTrace();
                num = null;
            }
            Integer num2 = num;
            F1.a(F1.v.DEBUG, "ReceiveReceiptWorker: Device Type is: " + num2);
            g1Var.a(n0, y0, num2, str, new a(str));
        }
    }

    public static synchronized OSReceiveReceiptController c() {
        OSReceiveReceiptController oSReceiveReceiptController;
        synchronized (OSReceiveReceiptController.class) {
            try {
                if (d == null) {
                    d = new OSReceiveReceiptController();
                }
                oSReceiveReceiptController = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oSReceiveReceiptController;
    }

    public void a(Context context, String str) {
        if (!this.c.j()) {
            F1.a(F1.v.DEBUG, "sendReceiveReceipt disabled");
            return;
        }
        int j = OSUtils.j(this.a, this.b);
        Q0.m b = new m.a(ReceiveReceiptWorker.class).e(b()).f(j, TimeUnit.SECONDS).g(new b.a().h("os_notification_id", str).a()).b();
        F1.a(F1.v.DEBUG, "OSReceiveReceiptController enqueueing send receive receipt work with notificationId: " + str + " and delay: " + j + " seconds");
        Q0.u a = E1.a(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_receive_receipt");
        a.d(sb.toString(), Q0.d.KEEP, b);
    }

    public Q0.b b() {
        return new b.a().b(Q0.l.CONNECTED).a();
    }
}
