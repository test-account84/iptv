package com.onesignal;

import android.app.Activity;
import com.onesignal.F1;
import com.onesignal.PermissionsActivity;
import com.onesignal.e;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class P implements PermissionsActivity.c {
    public static final P a;

    public static final class a implements e.a {
        public final /* synthetic */ Activity a;

        public a(Activity activity) {
            this.a = activity;
        }

        public void a() {
            Q.a.a(this.a);
            O.n(true, F1.z.PERMISSION_DENIED);
        }

        public void b() {
            O.n(true, F1.z.PERMISSION_DENIED);
        }
    }

    static {
        P p = new P();
        a = p;
        PermissionsActivity.e("LOCATION", p);
    }

    public void a() {
        c(F1.z.PERMISSION_GRANTED);
        O.p();
    }

    public void b(boolean z) {
        c(F1.z.PERMISSION_DENIED);
        if (z) {
            e();
        }
        O.e();
    }

    public final void c(F1.z zVar) {
        O.n(true, zVar);
    }

    public final void d(boolean z, String androidPermissionString) {
        kotlin.jvm.internal.l.e(androidPermissionString, "androidPermissionString");
        PermissionsActivity.i(z, "LOCATION", androidPermissionString, P.class);
    }

    public final void e() {
        Activity P = F1.P();
        if (P == null) {
            return;
        }
        e eVar = e.a;
        String string = P.getString(g2.c);
        kotlin.jvm.internal.l.d(string, "activity.getString(R.str…ermission_name_for_title)");
        String string2 = P.getString(g2.d);
        kotlin.jvm.internal.l.d(string2, "activity.getString(R.str…mission_settings_message)");
        eVar.c(P, string, string2, new a(P));
    }
}
