package e4;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import d4.v;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k extends GLSurfaceView implements l {
    public static final /* synthetic */ int c = 0;
    public final a a;

    public static final class a implements GLSurfaceView.Renderer {
        public static final float[] l = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        public static final float[] m = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        public static final float[] n = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        public static final String[] o = {"y_tex", "u_tex", "v_tex"};
        public static final FloatBuffer p = d4.v.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        public final GLSurfaceView a;
        public final int[] c = new int[3];
        public final int[] d = new int[3];
        public final int[] e = new int[3];
        public final int[] f = new int[3];
        public final AtomicReference g = new AtomicReference();
        public final FloatBuffer[] h = new FloatBuffer[3];
        public d4.u i;
        public int j;
        public VideoDecoderOutputBuffer k;

        public a(GLSurfaceView gLSurfaceView) {
            this.a = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.e;
                this.f[i] = -1;
                iArr[i] = -1;
            }
        }

        public void a(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) this.g.getAndSet(videoDecoderOutputBuffer);
            if (videoDecoderOutputBuffer2 != null) {
                videoDecoderOutputBuffer2.release();
            }
            this.a.requestRender();
        }

        public final void b() {
            try {
                GLES20.glGenTextures(3, this.c, 0);
                for (int i = 0; i < 3; i++) {
                    GLES20.glUniform1i(this.i.j(o[i]), i);
                    GLES20.glActiveTexture(33984 + i);
                    d4.v.a(3553, this.c[i]);
                }
                d4.v.b();
            } catch (v.a e) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures", e);
            }
        }

        public void onDrawFrame(GL10 gl10) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.g.getAndSet((Object) null);
            if (videoDecoderOutputBuffer == null && this.k == null) {
                return;
            }
            if (videoDecoderOutputBuffer != null) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.k;
                if (videoDecoderOutputBuffer2 != null) {
                    videoDecoderOutputBuffer2.release();
                }
                this.k = videoDecoderOutputBuffer;
            }
            VideoDecoderOutputBuffer videoDecoderOutputBuffer3 = (VideoDecoderOutputBuffer) d4.a.e(this.k);
            float[] fArr = m;
            int i = videoDecoderOutputBuffer3.colorspace;
            if (i == 1) {
                fArr = l;
            } else if (i == 3) {
                fArr = n;
            }
            GLES20.glUniformMatrix3fv(this.j, 1, false, fArr, 0);
            int[] iArr = (int[]) d4.a.e(videoDecoderOutputBuffer3.yuvStrides);
            Buffer[] bufferArr = (ByteBuffer[]) d4.a.e(videoDecoderOutputBuffer3.yuvPlanes);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = videoDecoderOutputBuffer3.height;
                if (i2 != 0) {
                    i3 = (i3 + 1) / 2;
                }
                int i4 = i3;
                GLES20.glActiveTexture(33984 + i2);
                GLES20.glBindTexture(3553, this.c[i2]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i2], i4, 0, 6409, 5121, bufferArr[i2]);
            }
            int i5 = videoDecoderOutputBuffer3.width;
            int i6 = (i5 + 1) / 2;
            int[] iArr2 = {i5, i6, i6};
            for (int i7 = 0; i7 < 3; i7++) {
                if (this.e[i7] != iArr2[i7] || this.f[i7] != iArr[i7]) {
                    d4.a.g(iArr[i7] != 0);
                    float f = iArr2[i7] / iArr[i7];
                    this.h[i7] = d4.v.e(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f, 0.0f, f, 1.0f});
                    GLES20.glVertexAttribPointer(this.d[i7], 2, 5126, false, 0, this.h[i7]);
                    this.e[i7] = iArr2[i7];
                    this.f[i7] = iArr[i7];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            try {
                d4.v.b();
            } catch (v.a e) {
                Log.e("VideoDecoderGLSV", "Failed to draw a frame", e);
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                d4.u uVar = new d4.u("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.i = uVar;
                GLES20.glVertexAttribPointer(uVar.e("in_pos"), 2, 5126, false, 0, p);
                this.d[0] = this.i.e("in_tc_y");
                this.d[1] = this.i.e("in_tc_u");
                this.d[2] = this.i.e("in_tc_v");
                this.j = this.i.j("mColorConversion");
                d4.v.b();
                b();
                d4.v.b();
            } catch (v.a e) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e);
            }
        }
    }

    public k(Context context) {
        this(context, null);
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.a.a(videoDecoderOutputBuffer);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.a = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    @Deprecated
    public l getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
