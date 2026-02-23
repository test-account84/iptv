package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class xt extends Surface {
    private static int b;
    private static boolean c;
    public final boolean a;
    private final xs d;
    private boolean e;

    public /* synthetic */ xt(xs xsVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.d = xsVar;
        this.a = z;
    }

    public static xt a(Context context, boolean z) {
        boolean z2 = true;
        if (z && !b(context)) {
            z2 = false;
        }
        af.w(z2);
        return new xs().a(z ? b : 0);
    }

    public static synchronized boolean b(Context context) {
        int i;
        String eglQueryString;
        int i2;
        String eglQueryString2;
        synchronized (xt.class) {
            try {
                if (!c) {
                    int i3 = cq.a;
                    if (i3 >= 24 && ((i3 >= 26 || !("samsung".equals(cq.c) || "XT1650".equals(cq.d))) && ((i3 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content")))) {
                        i2 = 2;
                        if (i3 >= 17 && (eglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString2.contains("EGL_KHR_surfaceless_context")) {
                            i2 = 1;
                        }
                    } else {
                        i2 = 0;
                    }
                    b = i2;
                    c = true;
                }
                i = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i != 0;
    }

    public final void release() {
        super.release();
        synchronized (this.d) {
            try {
                if (!this.e) {
                    this.d.b();
                    this.e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
