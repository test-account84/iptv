package Z6;

import Y6.v;
import Y6.w;
import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h {
    public static final String n = "h";
    public Camera a;
    public Camera.CameraInfo b;
    public Z6.a c;
    public B6.b d;
    public boolean e;
    public String f;
    public m h;
    public v i;
    public v j;
    public Context l;
    public i g = new i();
    public int k = -1;
    public final a m = new a();

    public final class a implements Camera.PreviewCallback {
        public p a;
        public v b;

        public a() {
        }

        public void a(p pVar) {
            this.a = pVar;
        }

        public void b(v vVar) {
            this.b = vVar;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            RuntimeException e;
            v vVar = this.b;
            p pVar = this.a;
            if (vVar == null || pVar == null) {
                Log.d(h.b(), "Got preview callback, but no handler or resolution available");
                if (pVar == null) {
                    return;
                } else {
                    e = new Exception("No resolution available");
                }
            } else {
                try {
                    if (bArr == null) {
                        throw new NullPointerException("No preview data received");
                    }
                    w wVar = new w(bArr, vVar.a, vVar.c, camera.getParameters().getPreviewFormat(), h.this.f());
                    if (h.a(h.this).facing == 1) {
                        wVar.e(true);
                    }
                    pVar.b(wVar);
                    return;
                } catch (RuntimeException e2) {
                    e = e2;
                    Log.e(h.b(), "Camera preview failed", e);
                }
            }
            pVar.a(e);
        }
    }

    public h(Context context) {
        this.l = context;
    }

    public static /* synthetic */ Camera.CameraInfo a(h hVar) {
        return hVar.b;
    }

    public static /* synthetic */ String b() {
        return n;
    }

    public static List i(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new v(previewSize.width, previewSize.height);
                arrayList.add(new v(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size size : supportedPreviewSizes) {
            arrayList.add(new v(size.width, size.height));
        }
        return arrayList;
    }

    public final int c() {
        int c = this.h.c();
        int i = 0;
        if (c != 0) {
            if (c == 1) {
                i = 90;
            } else if (c == 2) {
                i = 180;
            } else if (c == 3) {
                i = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.b;
        int i2 = cameraInfo.facing;
        int i3 = cameraInfo.orientation;
        int i4 = (i2 == 1 ? 360 - ((i3 + i) % 360) : (i3 - i) + 360) % 360;
        Log.i(n, "Camera Display Orientation: " + i4);
        return i4;
    }

    public void d() {
        Camera camera = this.a;
        if (camera != null) {
            camera.release();
            this.a = null;
        }
    }

    public void e() {
        if (this.a == null) {
            throw new RuntimeException("Camera not open");
        }
        r();
    }

    public int f() {
        return this.k;
    }

    public final Camera.Parameters g() {
        Camera.Parameters parameters = this.a.getParameters();
        String str = this.f;
        if (str == null) {
            this.f = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        return parameters;
    }

    public v h() {
        if (this.j == null) {
            return null;
        }
        return j() ? this.j.b() : this.j;
    }

    public boolean j() {
        int i = this.k;
        if (i != -1) {
            return i % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean k() {
        String flashMode;
        Camera.Parameters parameters = this.a.getParameters();
        if (parameters == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public void l() {
        Camera b = C6.a.b(this.g.b());
        this.a = b;
        if (b == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int a2 = C6.a.a(this.g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.b = cameraInfo;
        Camera.getCameraInfo(a2, cameraInfo);
    }

    public void m(p pVar) {
        Camera camera = this.a;
        if (camera == null || !this.e) {
            return;
        }
        this.m.a(pVar);
        camera.setOneShotPreviewCallback(this.m);
    }

    public final void n(int i) {
        this.a.setDisplayOrientation(i);
    }

    public void o(i iVar) {
        this.g = iVar;
    }

    public final void p(boolean z) {
        Camera.Parameters g = g();
        if (g == null) {
            Log.w(n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = n;
        Log.i(str, "Initial camera parameters: " + g.flatten());
        if (z) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        c.g(g, this.g.a(), z);
        if (!z) {
            c.k(g, false);
            if (this.g.h()) {
                c.i(g);
            }
            if (this.g.e()) {
                c.c(g);
            }
            if (this.g.g()) {
                c.l(g);
                c.h(g);
                c.j(g);
            }
        }
        List i = i(g);
        if (i.size() == 0) {
            this.i = null;
        } else {
            v a2 = this.h.a(i, j());
            this.i = a2;
            g.setPreviewSize(a2.a, a2.c);
        }
        if (Build.DEVICE.equals("glass-1")) {
            c.e(g);
        }
        Log.i(str, "Final camera parameters: " + g.flatten());
        this.a.setParameters(g);
    }

    public void q(m mVar) {
        this.h = mVar;
    }

    public final void r() {
        try {
            int c = c();
            this.k = c;
            n(c);
        } catch (Exception unused) {
            Log.w(n, "Failed to set rotation.");
        }
        try {
            p(false);
        } catch (Exception unused2) {
            try {
                p(true);
            } catch (Exception unused3) {
                Log.w(n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.j = this.i;
        } else {
            this.j = new v(previewSize.width, previewSize.height);
        }
        this.m.b(this.j);
    }

    public void s(j jVar) {
        jVar.a(this.a);
    }

    public void t(boolean z) {
        if (this.a != null) {
            try {
                if (z != k()) {
                    Z6.a aVar = this.c;
                    if (aVar != null) {
                        aVar.j();
                    }
                    Camera.Parameters parameters = this.a.getParameters();
                    c.k(parameters, z);
                    if (this.g.f()) {
                        c.d(parameters, z);
                    }
                    this.a.setParameters(parameters);
                    Z6.a aVar2 = this.c;
                    if (aVar2 != null) {
                        aVar2.i();
                    }
                }
            } catch (RuntimeException e) {
                Log.e(n, "Failed to set torch", e);
            }
        }
    }

    public void u() {
        Camera camera = this.a;
        if (camera == null || this.e) {
            return;
        }
        camera.startPreview();
        this.e = true;
        this.c = new Z6.a(this.a, this.g);
        B6.b bVar = new B6.b(this.l, this, this.g);
        this.d = bVar;
        bVar.d();
    }

    public void v() {
        Z6.a aVar = this.c;
        if (aVar != null) {
            aVar.j();
            this.c = null;
        }
        B6.b bVar = this.d;
        if (bVar != null) {
            bVar.e();
            this.d = null;
        }
        Camera camera = this.a;
        if (camera == null || !this.e) {
            return;
        }
        camera.stopPreview();
        this.m.a(null);
        this.e = false;
    }
}
