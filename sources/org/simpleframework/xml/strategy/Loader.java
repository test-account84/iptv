package org.simpleframework.xml.strategy;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
class Loader {
    private static ClassLoader getCallerClassLoader() throws Exception {
        return Loader.class.getClassLoader();
    }

    private static ClassLoader getClassLoader() throws Exception {
        return Thread.currentThread().getContextClassLoader();
    }

    public Class load(String str) throws Exception {
        ClassLoader classLoader = getClassLoader();
        if (classLoader == null) {
            classLoader = getCallerClassLoader();
        }
        return classLoader.loadClass(str);
    }
}
