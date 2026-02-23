package v4;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.cloudmessaging.zzf;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class q implements ServiceConnection {
    public r d;
    public final /* synthetic */ w g;
    public int a = 0;
    public final Messenger c = new Messenger(new zzf(Looper.getMainLooper(), new j(this)));
    public final Queue e = new ArrayDeque();
    public final SparseArray f = new SparseArray();

    public /* synthetic */ q(w wVar, p pVar) {
        this.g = wVar;
    }

    public final synchronized void a(int i, String str) {
        b(i, str, null);
    }

    public final synchronized void b(int i, String str, Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(str);
                Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
            }
            int i2 = this.a;
            if (i2 == 0) {
                throw new IllegalStateException();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.a = 4;
            B4.b.b().c(w.a(this.g), this);
            u uVar = new u(i, str, th);
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ((t) it.next()).c(uVar);
            }
            this.e.clear();
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                ((t) this.f.valueAt(i3)).c(uVar);
            }
            this.f.clear();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void c() {
        w.e(this.g).execute(new l(this));
    }

    public final synchronized void d() {
        if (this.a == 1) {
            a(1, "Timed out while binding");
        }
    }

    public final synchronized void e(int i) {
        t tVar = (t) this.f.get(i);
        if (tVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.f.remove(i);
            tVar.c(new u(3, "Timed out waiting for response", null));
            f();
        }
    }

    public final synchronized void f() {
        try {
            if (this.a == 2 && this.e.isEmpty() && this.f.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.a = 3;
                B4.b.b().c(w.a(this.g), this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean g(t tVar) {
        int i = this.a;
        if (i != 0) {
            if (i == 1) {
                this.e.add(tVar);
                return true;
            }
            if (i != 2) {
                return false;
            }
            this.e.add(tVar);
            c();
            return true;
        }
        this.e.add(tVar);
        com.google.android.gms.common.internal.r.p(this.a == 0);
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (B4.b.b().a(w.a(this.g), intent, this, 1)) {
                w.e(this.g).schedule(new m(this), 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
        } catch (SecurityException e) {
            b(0, "Unable to bind to service", e);
        }
        return true;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        w.e(this.g).execute(new n(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        w.e(this.g).execute(new k(this));
    }
}
