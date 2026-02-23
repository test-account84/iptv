package com.onesignal;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;
import p.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class K1 {

    public static class a extends p.e {
        public String a;
        public boolean c;

        public a(String str, boolean z) {
            this.a = str;
            this.c = z;
        }

        public void onCustomTabsServiceConnected(ComponentName componentName, p.c cVar) {
            cVar.g(0L);
            p.f e = cVar.e((p.b) null);
            if (e == null) {
                return;
            }
            Uri parse = Uri.parse(this.a);
            e.f(parse, (Bundle) null, (List) null);
            if (this.c) {
                p.d a = new d.a(e).a();
                a.a.setData(parse);
                a.a.addFlags(268435456);
                F1.b.startActivity(a.a, a.b);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static boolean a() {
        return true;
    }

    public static boolean b(String str, boolean z) {
        if (!a()) {
            return false;
        }
        return p.c.a(F1.b, "com.android.chrome", new a(str, z));
    }
}
