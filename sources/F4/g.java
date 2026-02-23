package f4;

import android.opengl.GLES20;
import android.util.Log;
import d4.u;
import d4.v;
import f4.e;
import java.nio.FloatBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g {
    public static final float[] j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};
    public static final float[] l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};
    public int a;
    public a b;
    public a c;
    public u d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public static class a {
        public final int a;
        public final FloatBuffer b;
        public final FloatBuffer c;
        public final int d;

        public a(e.b bVar) {
            this.a = bVar.a();
            this.b = v.e(bVar.c);
            this.c = v.e(bVar.d);
            int i = bVar.b;
            this.d = i != 1 ? i != 2 ? 4 : 6 : 5;
        }

        public static /* synthetic */ FloatBuffer a(a aVar) {
            return aVar.b;
        }

        public static /* synthetic */ FloatBuffer b(a aVar) {
            return aVar.c;
        }

        public static /* synthetic */ int c(a aVar) {
            return aVar.d;
        }

        public static /* synthetic */ int d(a aVar) {
            return aVar.a;
        }
    }

    public static boolean c(e eVar) {
        e.a aVar = eVar.a;
        e.a aVar2 = eVar.b;
        return aVar.b() == 1 && aVar.a(0).a == 0 && aVar2.b() == 1 && aVar2.a(0).a == 0;
    }

    public void a(int i, float[] fArr, boolean z) {
        a aVar = z ? this.c : this.b;
        if (aVar == null) {
            return;
        }
        int i2 = this.a;
        GLES20.glUniformMatrix3fv(this.f, 1, false, i2 == 1 ? z ? l : k : i2 == 2 ? z ? n : m : j, 0);
        GLES20.glUniformMatrix4fv(this.e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(this.i, 0);
        try {
            v.b();
        } catch (v.a e) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e);
        }
        GLES20.glVertexAttribPointer(this.g, 3, 5126, false, 12, a.a(aVar));
        try {
            v.b();
        } catch (v.a e2) {
            Log.e("ProjectionRenderer", "Failed to load position data", e2);
        }
        GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 8, a.b(aVar));
        try {
            v.b();
        } catch (v.a e3) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e3);
        }
        GLES20.glDrawArrays(a.c(aVar), 0, a.d(aVar));
        try {
            v.b();
        } catch (v.a e4) {
            Log.e("ProjectionRenderer", "Failed to render", e4);
        }
    }

    public void b() {
        try {
            u uVar = new u("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.d = uVar;
            this.e = uVar.j("uMvpMatrix");
            this.f = this.d.j("uTexMatrix");
            this.g = this.d.e("aPosition");
            this.h = this.d.e("aTexCoords");
            this.i = this.d.j("uTexture");
        } catch (v.a e) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e);
        }
    }

    public void d(e eVar) {
        if (c(eVar)) {
            this.a = eVar.c;
            a aVar = new a(eVar.a.a(0));
            this.b = aVar;
            if (!eVar.d) {
                aVar = new a(eVar.b.a(0));
            }
            this.c = aVar;
        }
    }
}
