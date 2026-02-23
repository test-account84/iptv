package e4;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.google.ads.interactivemedia.v3.internal.T1;
import d4.k0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class o {
    public final f a = new f();
    public final b b;
    public final e c;
    public boolean d;
    public Surface e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;

    public static final class a {
        public static void a(Surface surface, float f) {
            try {
                T1.a(surface, f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                d4.B.e("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    public interface b {

        public interface a {
            void a(Display display);
        }

        void a(a aVar);

        void b();
    }

    public static final class e implements Choreographer.FrameCallback, Handler.Callback {
        public static final e g = new e();
        public volatile long a = -9223372036854775807L;
        public final Handler c;
        public final HandlerThread d;
        public Choreographer e;
        public int f;

        public e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.d = handlerThread;
            handlerThread.start();
            Handler w = k0.w(handlerThread.getLooper(), this);
            this.c = w;
            w.sendEmptyMessage(0);
        }

        public static e d() {
            return g;
        }

        public void a() {
            this.c.sendEmptyMessage(1);
        }

        public final void b() {
            Choreographer choreographer = this.e;
            if (choreographer != null) {
                int i = this.f + 1;
                this.f = i;
                if (i == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        public final void c() {
            try {
                this.e = Choreographer.getInstance();
            } catch (RuntimeException e) {
                d4.B.k("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e);
            }
        }

        public void doFrame(long j) {
            this.a = j;
            ((Choreographer) d4.a.e(this.e)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.c.sendEmptyMessage(2);
        }

        public final void f() {
            Choreographer choreographer = this.e;
            if (choreographer != null) {
                int i = this.f - 1;
                this.f = i;
                if (i == 0) {
                    choreographer.removeFrameCallback(this);
                    this.a = -9223372036854775807L;
                }
            }
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c();
                return true;
            }
            if (i == 1) {
                b();
                return true;
            }
            if (i != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public o(Context context) {
        b f = f(context);
        this.b = f;
        this.c = f != null ? e.d() : null;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.f = -1.0f;
        this.i = 1.0f;
        this.j = 0;
    }

    public static /* synthetic */ void a(o oVar, Display display) {
        oVar.p(display);
    }

    public static boolean c(long j, long j2) {
        return Math.abs(j - j2) <= 20000000;
    }

    public static long e(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    public static b f(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        b d2 = k0.a >= 17 ? d.d(applicationContext) : null;
        return d2 == null ? c.c(applicationContext) : d2;
    }

    public long b(long j) {
        long j2;
        if (this.p == -1 || !this.a.e()) {
            j2 = j;
        } else {
            long a2 = this.q + ((long) ((this.a.a() * (this.m - this.p)) / this.i));
            if (c(j, a2)) {
                j2 = a2;
            } else {
                n();
                j2 = j;
            }
        }
        this.n = this.m;
        this.o = j2;
        e eVar = this.c;
        if (eVar == null || this.k == -9223372036854775807L) {
            return j2;
        }
        long j3 = eVar.a;
        return j3 == -9223372036854775807L ? j2 : e(j2, j3, this.k) - this.l;
    }

    public final void d() {
        Surface surface;
        if (k0.a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE || this.h == 0.0f) {
            return;
        }
        this.h = 0.0f;
        a.a(surface, 0.0f);
    }

    public void g(float f) {
        this.f = f;
        this.a.g();
        q();
    }

    public void h(long j) {
        long j2 = this.n;
        if (j2 != -1) {
            this.p = j2;
            this.q = this.o;
        }
        this.m++;
        this.a.f(j * 1000);
        q();
    }

    public void i(float f) {
        this.i = f;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.d = true;
        n();
        if (this.b != null) {
            ((e) d4.a.e(this.c)).a();
            this.b.a(new n(this));
        }
        r(false);
    }

    public void l() {
        this.d = false;
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
            ((e) d4.a.e(this.c)).e();
        }
        d();
    }

    public void m(Surface surface) {
        if (surface instanceof j) {
            surface = null;
        }
        if (this.e == surface) {
            return;
        }
        d();
        this.e = surface;
        r(true);
    }

    public final void n() {
        this.m = 0L;
        this.p = -1L;
        this.n = -1L;
    }

    public void o(int i) {
        if (this.j == i) {
            return;
        }
        this.j = i;
        r(true);
    }

    public final void p(Display display) {
        long j;
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            this.k = refreshRate;
            j = (refreshRate * 80) / 100;
        } else {
            d4.B.j("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            j = -9223372036854775807L;
            this.k = -9223372036854775807L;
        }
        this.l = j;
    }

    public final void q() {
        if (k0.a < 30 || this.e == null) {
            return;
        }
        float b2 = this.a.e() ? this.a.b() : this.f;
        float f = this.g;
        if (b2 == f) {
            return;
        }
        if (b2 != -1.0f && f != -1.0f) {
            if (Math.abs(b2 - this.g) < ((!this.a.e() || this.a.d() < 5000000000L) ? 1.0f : 0.02f)) {
                return;
            }
        } else if (b2 == -1.0f && this.a.c() < 30) {
            return;
        }
        this.g = b2;
        r(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r(boolean r4) {
        /*
            r3 = this;
            int r0 = d4.k0.a
            r1 = 30
            if (r0 < r1) goto L31
            android.view.Surface r0 = r3.e
            if (r0 == 0) goto L31
            int r1 = r3.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L11
            goto L31
        L11:
            boolean r1 = r3.d
            if (r1 == 0) goto L22
            float r1 = r3.g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L22
            float r2 = r3.i
            float r1 = r1 * r2
            goto L23
        L22:
            r1 = 0
        L23:
            if (r4 != 0) goto L2c
            float r4 = r3.h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L2c
            return
        L2c:
            r3.h = r1
            e4.o.a.a(r0, r1)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.o.r(boolean):void");
    }

    public static final class c implements b {
        public final WindowManager a;

        public c(WindowManager windowManager) {
            this.a = windowManager;
        }

        public static b c(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        public void a(b.a aVar) {
            aVar.a(this.a.getDefaultDisplay());
        }

        public void b() {
        }
    }

    public static final class d implements b, DisplayManager.DisplayListener {
        public final DisplayManager a;
        public b.a b;

        public d(DisplayManager displayManager) {
            this.a = displayManager;
        }

        public static b d(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        public void a(b.a aVar) {
            this.b = aVar;
            this.a.registerDisplayListener(this, k0.x());
            aVar.a(c());
        }

        public void b() {
            this.a.unregisterDisplayListener(this);
            this.b = null;
        }

        public final Display c() {
            return this.a.getDisplay(0);
        }

        public void onDisplayChanged(int i) {
            b.a aVar = this.b;
            if (aVar == null || i != 0) {
                return;
            }
            aVar.a(c());
        }

        public void onDisplayAdded(int i) {
        }

        public void onDisplayRemoved(int i) {
        }
    }
}
