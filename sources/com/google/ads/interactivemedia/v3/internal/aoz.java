package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aoz extends apj {
    private List h;
    private final Context i;

    public aoz(anw anwVar, agl aglVar, int i, Context context, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "S/SJ7YtODXxfB+6o9UyIgHiId71g3ksNaRMWqG3MsynbaW5fZJkURKKNBmxPvqKI", "TBTy2z6/sYWhl/djL8GAQh763EadMhWk9n5M3AmRbIg=", aglVar, i, 31, null, null, null);
        this.h = null;
        this.i = context;
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        this.g.aG(-1L);
        this.g.aC(-1L);
        Context context = this.i;
        if (context == null) {
            context = this.a.b();
        }
        if (this.h == null) {
            this.h = (List) this.d.invoke((Object) null, new Object[]{context});
        }
        List list = this.h;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.g) {
            this.g.aG(((Long) this.h.get(0)).longValue());
            this.g.aC(((Long) this.h.get(1)).longValue());
        }
    }
}
