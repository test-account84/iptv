package com.onesignal;

import com.onesignal.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class x0 {
    public final HashMap a;

    public x0() {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put(u.d.class.getName(), new u.d());
        hashMap.put(u.b.class.getName(), new u.b());
    }

    public final u.c a() {
        return (u.c) this.a.get(u.b.class.getName());
    }

    public u.c b() {
        u.c a = a();
        Iterator it = a.j().iterator();
        while (it.hasNext()) {
            if (((P7.a) it.next()).d().isAttributed()) {
                return a;
            }
        }
        return d();
    }

    public u.c c(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((P7.a) it.next()).d().isAttributed()) {
                return a();
            }
        }
        return d();
    }

    public final u.c d() {
        return (u.c) this.a.get(u.d.class.getName());
    }
}
