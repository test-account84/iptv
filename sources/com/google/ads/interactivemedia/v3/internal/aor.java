package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aor extends apj {
    private final Map h;
    private final View i;
    private final Context j;

    public aor(anw anwVar, agl aglVar, int i, Map map, View view, Context context, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "FdWssDbNTznwvaSwEiy9othUceULqhXS0NiSaXeIdQIZaN4heVunXmsWFB1bgBsj", "TzSf4nrBofZD4sG4/0KqSG9VhwNKl95AgxoEIclkVIM=", aglVar, i, 85, null, null, null);
        this.h = map;
        this.i = view;
        this.j = context;
    }

    private final long c(int i) {
        Map map = this.h;
        Integer valueOf = Integer.valueOf(i);
        if (map.containsKey(valueOf)) {
            return ((Long) this.h.get(valueOf)).longValue();
        }
        return Long.MIN_VALUE;
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = {c(1), c(2)};
        Context context = this.j;
        if (context == null) {
            context = this.a.b();
        }
        long[] jArr2 = (long[]) this.d.invoke((Object) null, new Object[]{jArr, context, this.i});
        long j = jArr2[0];
        this.h.put(1, Long.valueOf(jArr2[1]));
        long j2 = jArr2[2];
        this.h.put(2, Long.valueOf(jArr2[3]));
        synchronized (this.g) {
            this.g.ae(j);
            this.g.ad(j2);
        }
    }
}
