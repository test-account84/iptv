package com.google.android.gms.internal.cast;

import java.lang.reflect.AccessibleObject;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzux implements PrivilegedExceptionAction {
    public final /* bridge */ /* synthetic */ Object run() throws Exception {
        for (AccessibleObject accessibleObject : Unsafe.class.getDeclaredFields()) {
            accessibleObject.setAccessible(true);
            Object obj = accessibleObject.get((Object) null);
            if (Unsafe.class.isInstance(obj)) {
                return (Unsafe) Unsafe.class.cast(obj);
            }
        }
        return null;
    }
}
