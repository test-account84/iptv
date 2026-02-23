package com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    public void makeAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
