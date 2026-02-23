package Y6;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l {
    public static final String k = "l";
    public Z6.g a;
    public HandlerThread b;
    public Handler c;
    public i d;
    public Handler e;
    public Rect f;
    public boolean g = false;
    public final Object h = new Object();
    public final Handler.Callback i = new a();
    public final Z6.p j = new b();

    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == B6.k.e) {
                l.a(l.this, (w) message.obj);
                return true;
            }
            if (i != B6.k.i) {
                return true;
            }
            l.b(l.this);
            return true;
        }
    }

    public class b implements Z6.p {
        public b() {
        }

        public void a(Exception exc) {
            synchronized (l.c(l.this)) {
                try {
                    if (l.d(l.this)) {
                        l.e(l.this).obtainMessage(B6.k.i).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b(w wVar) {
            synchronized (l.c(l.this)) {
                try {
                    if (l.d(l.this)) {
                        l.e(l.this).obtainMessage(B6.k.e, wVar).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public l(Z6.g gVar, i iVar, Handler handler) {
        x.a();
        this.a = gVar;
        this.d = iVar;
        this.e = handler;
    }

    public static /* synthetic */ void a(l lVar, w wVar) {
        lVar.g(wVar);
    }

    public static /* synthetic */ void b(l lVar) {
        lVar.h();
    }

    public static /* synthetic */ Object c(l lVar) {
        return lVar.h;
    }

    public static /* synthetic */ boolean d(l lVar) {
        return lVar.g;
    }

    public static /* synthetic */ Handler e(l lVar) {
        return lVar.c;
    }

    public x6.i f(w wVar) {
        if (this.f == null) {
            return null;
        }
        return wVar.a();
    }

    public final void g(w wVar) {
        Message obtain;
        long currentTimeMillis = System.currentTimeMillis();
        wVar.d(this.f);
        x6.i f = f(wVar);
        x6.o c = f != null ? this.d.c(f) : null;
        if (c != null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d(k, "Found barcode in " + (currentTimeMillis2 - currentTimeMillis) + " ms");
            if (this.e != null) {
                obtain = Message.obtain(this.e, B6.k.g, new Y6.b(c, wVar));
                obtain.setData(new Bundle());
                obtain.sendToTarget();
            }
        } else {
            Handler handler = this.e;
            if (handler != null) {
                obtain = Message.obtain(handler, B6.k.f);
                obtain.sendToTarget();
            }
        }
        if (this.e != null) {
            Message.obtain(this.e, B6.k.h, Y6.b.e(this.d.d(), wVar)).sendToTarget();
        }
        h();
    }

    public final void h() {
        this.a.v(this.j);
    }

    public void i(Rect rect) {
        this.f = rect;
    }

    public void j(i iVar) {
        this.d = iVar;
    }

    public void k() {
        x.a();
        HandlerThread handlerThread = new HandlerThread(k);
        this.b = handlerThread;
        handlerThread.start();
        this.c = new Handler(this.b.getLooper(), this.i);
        this.g = true;
        h();
    }

    public void l() {
        x.a();
        synchronized (this.h) {
            this.g = false;
            this.c.removeCallbacksAndMessages((Object) null);
            this.b.quit();
        }
    }
}
