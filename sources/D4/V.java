package d4;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class v {
    public static final int[] a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    public static final int[] b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};
    public static final int[] c = {12445, 13120, 12344, 12344};
    public static final int[] d = {12344};

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static void a(int i, int i2) {
        GLES20.glBindTexture(i, i2);
        b();
        GLES20.glTexParameteri(i, 10240, 9729);
        b();
        GLES20.glTexParameteri(i, 10241, 9729);
        b();
        GLES20.glTexParameteri(i, 10242, 33071);
        b();
        GLES20.glTexParameteri(i, 10243, 33071);
        b();
    }

    public static void b() {
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
            throw new a(sb.toString());
        }
    }

    public static void c(boolean z, String str) {
        if (!z) {
            throw new a(str);
        }
    }

    public static FloatBuffer d(int i) {
        return ByteBuffer.allocateDirect(i * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer e(float[] fArr) {
        return d(fArr.length).put(fArr).flip();
    }

    public static int f() {
        int g = g();
        a(36197, g);
        return g;
    }

    public static int g() {
        c(!k0.c(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b();
        return iArr[0];
    }

    public static boolean h(Context context) {
        String eglQueryString;
        int i = k0.a;
        if (i < 24) {
            return false;
        }
        if (i >= 26 || !("samsung".equals(k0.c) || "XT1650".equals(k0.d))) {
            return (i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean i() {
        String eglQueryString;
        return k0.a >= 17 && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_KHR_surfaceless_context");
    }

    public static void j(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
