package com.onesignal;

import android.content.Context;
import com.onesignal.F1;
import com.onesignal.Y1;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a2 implements Y1 {
    public static int d = 5;
    public static int e = 10000;
    public Y1.a a;
    public Thread b;
    public boolean c;

    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        public void run() {
            int i = 0;
            while (i < a2.b() && !a2.c(a2.this, this.a, i)) {
                i++;
                OSUtils.V(a2.d() * i);
            }
        }
    }

    public static /* synthetic */ int b() {
        return d;
    }

    public static /* synthetic */ boolean c(a2 a2Var, String str, int i) {
        return a2Var.e(str, i);
    }

    public static /* synthetic */ int d() {
        return e;
    }

    public static int j(Throwable th) {
        String l = OSUtils.l(th);
        if (!(th instanceof IOException)) {
            return -12;
        }
        if ("SERVICE_NOT_AVAILABLE".equals(l)) {
            return -9;
        }
        return "AUTHENTICATION_FAILED".equals(l) ? -29 : -11;
    }

    public void a(Context context, String str, Y1.a aVar) {
        this.a = aVar;
        if (i(str, aVar)) {
            h(str);
        }
    }

    public final boolean e(String str, int i) {
        try {
            String g = g(str);
            F1.a(F1.v.INFO, "Device registered, push token = " + g);
            this.a.a(g, 1);
            return true;
        } catch (IOException e2) {
            int j = j(e2);
            String l = OSUtils.l(e2);
            if (!"SERVICE_NOT_AVAILABLE".equals(l) && !"AUTHENTICATION_FAILED".equals(l)) {
                Exception exc = new Exception(e2);
                F1.b(F1.v.ERROR, "Error Getting " + f() + " Token", exc);
                if (!this.c) {
                    this.a.a(null, j);
                }
                return true;
            }
            Exception exc2 = new Exception(e2);
            if (i >= d - 1) {
                F1.b(F1.v.ERROR, "Retry count of " + d + " exceed! Could not get a " + f() + " Token.", exc2);
                return false;
            }
            F1.b(F1.v.INFO, "'Google Play services' returned " + l + " error. Current retry count: " + i, exc2);
            if (i != 2) {
                return false;
            }
            this.a.a(null, j);
            this.c = true;
            return true;
        } catch (Throwable th) {
            Exception exc3 = new Exception(th);
            int j2 = j(th);
            F1.b(F1.v.ERROR, "Unknown error getting " + f() + " Token", exc3);
            this.a.a(null, j2);
            return true;
        }
    }

    public abstract String f();

    public abstract String g(String str);

    public final void h(String str) {
        try {
            if (OSUtils.D()) {
                k(str);
            } else {
                C.d();
                F1.a(F1.v.ERROR, "'Google Play services' app not installed or disabled on the device.");
                this.a.a(null, -7);
            }
        } catch (Throwable th) {
            F1.b(F1.v.ERROR, "Could not register with " + f() + " due to an issue with your AndroidManifest.xml or with 'Google Play services'.", th);
            this.a.a(null, -8);
        }
    }

    public final boolean i(String str, Y1.a aVar) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (Throwable unused) {
            F1.a(F1.v.ERROR, "Missing Google Project number!\nPlease enter a Google Project number / Sender ID on under App Settings > Android > Configuration on the OneSignal dashboard.");
            aVar.a(null, -6);
            return false;
        }
    }

    public final synchronized void k(String str) {
        Thread thread = this.b;
        if (thread == null || !thread.isAlive()) {
            Thread thread2 = new Thread(new a(str));
            this.b = thread2;
            thread2.start();
        }
    }
}
