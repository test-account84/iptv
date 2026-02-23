package com.google.ads.interactivemedia.v3.internal;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class br implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    private static final int[] a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};
    private final Handler b;
    private final int[] c = new int[1];
    private EGLDisplay d;
    private EGLContext e;
    private EGLSurface f;
    private SurfaceTexture g;

    public br(Handler handler) {
        this.b = handler;
    }

    public final SurfaceTexture a() {
        SurfaceTexture surfaceTexture = this.g;
        af.s(surfaceTexture);
        return surfaceTexture;
    }

    public final void b(int i) throws bs {
        EGLSurface eglCreatePbufferSurface;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        bt.a(eglGetDisplay != null, "eglGetDisplay failed");
        int[] iArr = new int[2];
        bt.a(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
        this.d = eglGetDisplay;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, a, 0, eGLConfigArr, 0, 1, iArr2, 0);
        bt.a(eglChooseConfig && iArr2[0] > 0 && eGLConfigArr[0] != null, cq.H("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]));
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eglCreateContext = EGL14.eglCreateContext(this.d, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        bt.a(eglCreateContext != null, "eglCreateContext failed");
        this.e = eglCreateContext;
        EGLDisplay eGLDisplay = this.d;
        if (i == 1) {
            eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            bt.a(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
        }
        bt.a(EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext), "eglMakeCurrent failed");
        this.f = eglCreatePbufferSurface;
        GLES20.glGenTextures(1, this.c, 0);
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z) {
                sb.append('\n');
            }
            sb.append("glError: ");
            sb.append(GLU.gluErrorString(glGetError));
            z = true;
        }
        if (z) {
            throw new bs(sb.toString());
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.c[0]);
        this.g = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public final void c() {
        this.b.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.g;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.c, 0);
            }
            EGLDisplay eGLDisplay = this.d;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.d;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.d, this.f);
            }
            EGLContext eGLContext = this.e;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.d, eGLContext);
            }
            if (cq.a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.d;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.d);
            }
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
        } catch (Throwable th) {
            EGLDisplay eGLDisplay4 = this.d;
            if (eGLDisplay4 != null && !eGLDisplay4.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay5 = this.d;
                EGLSurface eGLSurface3 = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay5, eGLSurface3, eGLSurface3, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface4 = this.f;
            if (eGLSurface4 != null && !eGLSurface4.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.d, this.f);
            }
            EGLContext eGLContext2 = this.e;
            if (eGLContext2 != null) {
                EGL14.eglDestroyContext(this.d, eGLContext2);
            }
            if (cq.a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay6 = this.d;
            if (eGLDisplay6 != null && !eGLDisplay6.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.d);
            }
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            throw th;
        }
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.b.post(this);
    }

    public final void run() {
        SurfaceTexture surfaceTexture = this.g;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
