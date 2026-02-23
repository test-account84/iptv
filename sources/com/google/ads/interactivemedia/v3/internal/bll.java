package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bll extends bln {
    final /* synthetic */ Method a;

    public bll(Method method) {
        this.a = method;
    }

    public final boolean a(AccessibleObject accessibleObject, Object obj) {
        try {
            return ((Boolean) this.a.invoke(accessibleObject, new Object[]{obj})).booleanValue();
        } catch (Exception e) {
            throw new RuntimeException("Failed invoking canAccess", e);
        }
    }
}
