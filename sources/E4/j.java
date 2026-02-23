package e4;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import d4.v;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j extends Surface {
    public static int e;
    public static boolean f;
    public final boolean a;
    public final b c;
    public boolean d;

    public static class b extends HandlerThread implements Handler.Callback {
        public d4.n a;
        public Handler c;
        public Error d;
        public RuntimeException e;
        public j f;

        public b() {
            super("ExoPlayer:PlaceholderSurface");
        }

        public j a(int i) {
            boolean z;
            start();
            this.c = new Handler(getLooper(), this);
            this.a = new d4.n(this.c);
            synchronized (this) {
                z = false;
                this.c.obtainMessage(1, i, 0).sendToTarget();
                while (this.f == null && this.e == null && this.d == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.e;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.d;
            if (error == null) {
                return (j) d4.a.e(this.f);
            }
            throw error;
        }

        public final void b(int i) {
            d4.a.e(this.a);
            this.a.h(i);
            this.f = new j(this, this.a.g(), i != 0, null);
        }

        public void c() {
            d4.a.e(this.c);
            this.c.sendEmptyMessage(2);
        }

        public final void d() {
            d4.a.e(this.a);
            this.a.i();
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            try {
                if (i != 1) {
                    if (i != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (v.a e) {
                    d4.B.e("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                    this.e = new IllegalStateException(e);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e2) {
                    d4.B.e("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                    this.d = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e3) {
                    d4.B.e("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.e = e3;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    public j(b bVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.c = bVar;
        this.a = z;
    }

    public static int a(Context context) {
        if (d4.v.h(context)) {
            return d4.v.i() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean c(Context context) {
        boolean z;
        synchronized (j.class) {
            try {
                if (!f) {
                    e = a(context);
                    f = true;
                }
                z = e != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static j d(Context context, boolean z) {
        d4.a.g(!z || c(context));
        return new b().a(z ? e : 0);
    }

    public void release() {
        super.release();
        synchronized (this.c) {
            try {
                if (!this.d) {
                    this.c.c();
                    this.d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ j(b bVar, SurfaceTexture surfaceTexture, boolean z, a aVar) {
        this(bVar, surfaceTexture, z);
    }
}
