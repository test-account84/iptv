package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class bln {
    public static final bln b;

    static {
        bln blnVar = null;
        if (bkz.a()) {
            try {
                blnVar = new bll(AccessibleObject.class.getDeclaredMethod("canAccess", new Class[]{Object.class}));
            } catch (NoSuchMethodException unused) {
            }
        }
        if (blnVar == null) {
            blnVar = new blm();
        }
        b = blnVar;
    }

    public abstract boolean a(AccessibleObject accessibleObject, Object obj);
}
