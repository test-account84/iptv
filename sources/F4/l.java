package f4;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import d4.k0;
import d4.v;
import f4.d;
import f4.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends GLSurfaceView {
    public static final /* synthetic */ int n = 0;
    public final CopyOnWriteArrayList a;
    public final SensorManager c;
    public final Sensor d;
    public final d e;
    public final Handler f;
    public final m g;
    public final i h;
    public SurfaceTexture i;
    public Surface j;
    public boolean k;
    public boolean l;
    public boolean m;

    public final class a implements GLSurfaceView.Renderer, m.a, d.a {
        public final i a;
        public final float[] e;
        public final float[] f;
        public final float[] g;
        public float h;
        public float i;
        public final float[] c = new float[16];
        public final float[] d = new float[16];
        public final float[] j = new float[16];
        public final float[] k = new float[16];

        public a(i iVar) {
            float[] fArr = new float[16];
            this.e = fArr;
            float[] fArr2 = new float[16];
            this.f = fArr2;
            float[] fArr3 = new float[16];
            this.g = fArr3;
            this.a = iVar;
            v.j(fArr);
            v.j(fArr2);
            v.j(fArr3);
            this.i = 3.1415927f;
        }

        public synchronized void a(float[] fArr, float f) {
            float[] fArr2 = this.e;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.i = -f;
            d();
        }

        public synchronized void b(PointF pointF) {
            this.h = pointF.y;
            d();
            Matrix.setRotateM(this.g, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public final float c(float f) {
            if (f > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f)) * 2.0d);
            }
            return 90.0f;
        }

        public final void d() {
            Matrix.setRotateM(this.f, 0, -this.h, (float) Math.cos(this.i), (float) Math.sin(this.i), 0.0f);
        }

        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.k, 0, this.e, 0, this.g, 0);
                Matrix.multiplyMM(this.j, 0, this.f, 0, this.k, 0);
            }
            Matrix.multiplyMM(this.d, 0, this.c, 0, this.j, 0);
            this.a.e(this.d, false);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return l.this.performClick();
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            Matrix.perspectiveM(this.c, 0, c(f), f, 0.1f, 100.0f);
        }

        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            l.c(l.this, this.a.f());
        }
    }

    public interface b {
        void A(Surface surface);

        void z(Surface surface);
    }

    public l(Context context) {
        this(context, null);
    }

    public static /* synthetic */ void a(l lVar) {
        lVar.e();
    }

    public static /* synthetic */ void b(l lVar, SurfaceTexture surfaceTexture) {
        lVar.f(surfaceTexture);
    }

    public static /* synthetic */ void c(l lVar, SurfaceTexture surfaceTexture) {
        lVar.g(surfaceTexture);
    }

    public static void h(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    public void d(b bVar) {
        this.a.add(bVar);
    }

    public final /* synthetic */ void e() {
        Surface surface = this.j;
        if (surface != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((b) it.next()).z(surface);
            }
        }
        h(this.i, surface);
        this.i = null;
        this.j = null;
    }

    public final /* synthetic */ void f(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.i;
        Surface surface = this.j;
        Surface surface2 = new Surface(surfaceTexture);
        this.i = surfaceTexture;
        this.j = surface2;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).A(surface2);
        }
        h(surfaceTexture2, surface);
    }

    public final void g(SurfaceTexture surfaceTexture) {
        this.f.post(new j(this, surfaceTexture));
    }

    public f4.a getCameraMotionListener() {
        return this.h;
    }

    public e4.m getVideoFrameMetadataListener() {
        return this.h;
    }

    public Surface getVideoSurface() {
        return this.j;
    }

    public void i(b bVar) {
        this.a.remove(bVar);
    }

    public final void j() {
        boolean z = this.k && this.l;
        Sensor sensor = this.d;
        if (sensor == null || z == this.m) {
            return;
        }
        if (z) {
            this.c.registerListener(this.e, sensor, 0);
        } else {
            this.c.unregisterListener(this.e);
        }
        this.m = z;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f.post(new k(this));
    }

    public void onPause() {
        this.l = false;
        j();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.l = true;
        j();
    }

    public void setDefaultStereoMode(int i) {
        this.h.h(i);
    }

    public void setUseSensorRotation(boolean z) {
        this.k = z;
        j();
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new CopyOnWriteArrayList();
        this.f = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) d4.a.e(context.getSystemService("sensor"));
        this.c = sensorManager;
        Sensor defaultSensor = k0.a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.d = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        i iVar = new i();
        this.h = iVar;
        a aVar = new a(iVar);
        m mVar = new m(context, aVar, 25.0f);
        this.g = mVar;
        this.e = new d(((WindowManager) d4.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), mVar, aVar);
        this.k = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(mVar);
    }
}
