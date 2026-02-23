package com.onesignal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class OSPermissionChangedInternalObserver {
    public static void a(e1 e1Var) {
        if (F1.g0().c(new f1(F1.W, (e1) e1Var.clone()))) {
            e1 e1Var2 = (e1) e1Var.clone();
            F1.W = e1Var2;
            e1Var2.e();
        }
    }

    public static void b(e1 e1Var) {
        if (!e1Var.b()) {
            l.d(0, F1.b);
        }
        W1.t(F1.z());
    }

    public void changed(e1 e1Var) {
        b(e1Var);
        a(e1Var);
    }
}
