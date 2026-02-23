package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class l {
    public final Set a = Collections.newSetFromMap(new WeakHashMap());

    public static k a(Object obj, Looper looper, String str) {
        com.google.android.gms.common.internal.r.n(obj, "Listener must not be null");
        com.google.android.gms.common.internal.r.n(looper, "Looper must not be null");
        com.google.android.gms.common.internal.r.n(str, "Listener type must not be null");
        return new k(looper, obj, str);
    }

    public static k.a b(Object obj, String str) {
        com.google.android.gms.common.internal.r.n(obj, "Listener must not be null");
        com.google.android.gms.common.internal.r.n(str, "Listener type must not be null");
        com.google.android.gms.common.internal.r.h(str, "Listener type must not be empty");
        return new k.a(obj, str);
    }

    public final void c() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
        this.a.clear();
    }
}
