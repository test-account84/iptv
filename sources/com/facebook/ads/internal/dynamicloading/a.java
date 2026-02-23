package com.facebook.ads.internal.dynamicloading;

import dalvik.system.InMemoryDexClassLoader;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ InMemoryDexClassLoader a(ByteBuffer byteBuffer, ClassLoader classLoader) {
        return new InMemoryDexClassLoader(byteBuffer, classLoader);
    }
}
