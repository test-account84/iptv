package com.onesignal;

import android.content.Context;
import androidx.work.a;
import com.onesignal.F1;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class E1 {
    public static final E1 a = new E1();

    public static final synchronized Q0.u a(Context context) {
        Q0.u f;
        synchronized (E1.class) {
            kotlin.jvm.internal.l.e(context, "context");
            try {
                f = Q0.u.f(context);
                kotlin.jvm.internal.l.d(f, "{\n            WorkManage…stance(context)\n        }");
            } catch (IllegalStateException e) {
                F1.b(F1.v.ERROR, "OSWorkManagerHelper.getInstance failed, attempting to initialize: ", e);
                a.b(context);
                f = Q0.u.f(context);
                kotlin.jvm.internal.l.d(f, "{\n            /*\n       …stance(context)\n        }");
            }
        }
        return f;
    }

    public final void b(Context context) {
        try {
            context.getApplicationContext();
            androidx.work.a a2 = new a.b().a();
            kotlin.jvm.internal.l.d(a2, "(context.applicationCont…uration.Builder().build()");
            Q0.u.g(context, a2);
        } catch (IllegalStateException e) {
            F1.b(F1.v.ERROR, "OSWorkManagerHelper initializing WorkManager failed: ", e);
        }
    }
}
