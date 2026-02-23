package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class ReflectionAccessor {
    private static final ReflectionAccessor instance;

    static {
        instance = JavaVersion.getMajorJavaVersion() < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();
    }

    public static ReflectionAccessor getInstance() {
        return instance;
    }

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}
