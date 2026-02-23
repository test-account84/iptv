package M4;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;
    public final t f;

    public q(l2 l2Var, String str, String str2, String str3, long j, long j2, t tVar) {
        com.google.android.gms.common.internal.r.g(str2);
        com.google.android.gms.common.internal.r.g(str3);
        com.google.android.gms.common.internal.r.m(tVar);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            l2Var.d().w().c("Event created with reverse previous/current timestamps. appId, name", z1.z(str2), z1.z(str3));
        }
        this.f = tVar;
    }

    public final q a(l2 l2Var, long j) {
        return new q(l2Var, this.c, this.a, this.b, this.d, j, this.f);
    }

    public final String toString() {
        return "Event{appId='" + this.a + "', name='" + this.b + "', params=" + this.f.toString() + "}";
    }

    public q(l2 l2Var, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        t tVar;
        com.google.android.gms.common.internal.r.g(str2);
        com.google.android.gms.common.internal.r.g(str3);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            l2Var.d().w().b("Event created with reverse previous/current timestamps. appId", z1.z(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            tVar = new t(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    l2Var.d().r().a("Param name can't be null");
                } else {
                    Object o = l2Var.N().o(str4, bundle2.get(str4));
                    if (o == null) {
                        l2Var.d().w().b("Param value can't be null", l2Var.D().e(str4));
                    } else {
                        l2Var.N().D(bundle2, str4, o);
                    }
                }
                it.remove();
            }
            tVar = new t(bundle2);
        }
        this.f = tVar;
    }
}
