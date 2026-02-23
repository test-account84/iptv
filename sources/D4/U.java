package d4;

import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u {
    public final int a;
    public final a[] b;
    public final b[] c;
    public final Map d;
    public final Map e;

    public static final class a {
        public final String a;
        public final int b;
        public final int c;

        public a(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public static a a(int i, int i2) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35722, iArr, 0);
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            GLES20.glGetActiveAttrib(i, i2, i3, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, u.a(bArr));
            return new a(str, i2, u.b(i, str));
        }
    }

    public static final class b {
        public final String a;
        public final int b;
        public final int c;
        public final float[] d = new float[16];

        public b(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        public static b a(int i, int i2) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            GLES20.glGetActiveUniform(i, i2, i3, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, u.a(bArr));
            return new b(str, u.c(i, str), iArr2[0]);
        }
    }

    public u(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        this.a = glCreateProgram;
        v.b();
        d(glCreateProgram, 35633, str);
        d(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        v.c(iArr[0] == 1, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glUseProgram(glCreateProgram);
        this.d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.b = new a[iArr2[0]];
        for (int i = 0; i < iArr2[0]; i++) {
            a a2 = a.a(this.a, i);
            this.b[i] = a2;
            this.d.put(a2.a, a2);
        }
        this.e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.a, 35718, iArr3, 0);
        this.c = new b[iArr3[0]];
        for (int i2 = 0; i2 < iArr3[0]; i2++) {
            b a3 = b.a(this.a, i2);
            this.c[i2] = a3;
            this.e.put(a3.a, a3);
        }
        v.b();
    }

    public static /* synthetic */ int a(byte[] bArr) {
        return h(bArr);
    }

    public static /* synthetic */ int b(int i, String str) {
        return f(i, str);
    }

    public static /* synthetic */ int c(int i, String str) {
        return i(i, str);
    }

    public static void d(int i, int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        v.c(iArr[0] == 1, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        v.b();
    }

    public static int f(int i, String str) {
        return GLES20.glGetAttribLocation(i, str);
    }

    public static int h(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 0) {
                return i;
            }
        }
        return bArr.length;
    }

    public static int i(int i, String str) {
        return GLES20.glGetUniformLocation(i, str);
    }

    public int e(String str) {
        int g = g(str);
        GLES20.glEnableVertexAttribArray(g);
        v.b();
        return g;
    }

    public final int g(String str) {
        return f(this.a, str);
    }

    public int j(String str) {
        return i(this.a, str);
    }
}
