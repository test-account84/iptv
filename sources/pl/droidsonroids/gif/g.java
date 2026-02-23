package pl.droidsonroids.gif;

import android.content.Context;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class g {
    public static Context a;

    public static Context a() {
        if (a == null) {
            try {
                a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", (Class[]) null).invoke((Object) null, (Object[]) null);
            } catch (Exception e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return a;
    }

    public static void b() {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            O8.c.a(a(), "pl_droidsonroids_gif");
        }
    }
}
