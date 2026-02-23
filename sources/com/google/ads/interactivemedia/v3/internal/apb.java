package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class apb extends apj {
    private final StackTraceElement[] h;

    public apb(anw anwVar, agl aglVar, int i, StackTraceElement[] stackTraceElementArr, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(anwVar, "5Y5rtCIQhjVwnkrBvzpTMg0rZuVvyD2oudHeojlpiyRPt3QF1dIwn8qKzMnR3WrD", "L+eAMQBxQYtni61+5W3ps9X1nzCZQ5WzyUUXMjOuRZ4=", aglVar, i, 45, null, null, null);
        this.h = stackTraceElementArr;
    }

    public final void a() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.h;
        if (stackTraceElementArr != null) {
            anq anqVar = new anq((String) this.d.invoke((Object) null, new Object[]{stackTraceElementArr}));
            synchronized (this.g) {
                try {
                    this.g.ap(anqVar.a.longValue());
                    if (anqVar.b.booleanValue()) {
                        this.g.aM(anqVar.c.booleanValue() ? agh.a : agh.b);
                    } else {
                        this.g.aM(agh.c);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
