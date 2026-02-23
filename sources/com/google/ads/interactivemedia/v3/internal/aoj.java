package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aoj extends apj {
    private static final ayt i = new ayt();
    private final Context h;

    public aoj(anw anwVar, agl aglVar, int i2, Context context, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "ATj3hbklxV/XiswqkLJ9VlaAJFBsAV/1VJ4eSTnw1AP/96KhgekAXYnIpmljK7wO", "rfBYaobM06JIPnbukgoyOwsb7bCc9rvkUNfR4KOQWHU=", aglVar, i2, 29, null, null, null);
        this.h = context;
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        this.g.W("E");
        AtomicReference b = i.b(this.h.getPackageName());
        if (b.get() == null) {
            synchronized (b) {
                try {
                    if (b.get() == null) {
                        b.set((String) this.d.invoke((Object) null, new Object[]{this.h}));
                    }
                } finally {
                }
            }
        }
        String str = (String) b.get();
        synchronized (this.g) {
            this.g.W(com.google.ads.interactivemedia.v3.impl.data.aq.a(str.getBytes(), true));
        }
    }
}
