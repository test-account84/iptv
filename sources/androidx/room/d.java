package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.a;
import androidx.room.b;
import androidx.room.c;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d {
    public final Context a;
    public final String b;
    public int c;
    public final androidx.room.c d;
    public final c.c e;
    public androidx.room.b f;
    public final Executor g;
    public final androidx.room.a h = new a();
    public final AtomicBoolean i = new AtomicBoolean(false);
    public final ServiceConnection j;
    public final Runnable k;
    public final Runnable l;
    public final Runnable m;

    public class a extends a.a {

        public class a implements Runnable {
            public final /* synthetic */ String[] a;

            public a(String[] strArr) {
                this.a = strArr;
            }

            public void run() {
                d.this.d.e(this.a);
            }
        }

        public a() {
        }

        public void o(String[] strArr) {
            d.this.g.execute(new a(strArr));
        }
    }

    public class b implements ServiceConnection {
        public b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f = b.a.A(iBinder);
            d dVar = d.this;
            dVar.g.execute(dVar.k);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            d dVar = d.this;
            dVar.g.execute(dVar.l);
            d.this.f = null;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                d dVar = d.this;
                androidx.room.b bVar = dVar.f;
                if (bVar != null) {
                    dVar.c = bVar.n0(dVar.h, dVar.b);
                    d dVar2 = d.this;
                    dVar2.d.a(dVar2.e);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            d dVar = d.this;
            dVar.d.g(dVar.e);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            d dVar = d.this;
            dVar.d.g(dVar.e);
            try {
                d dVar2 = d.this;
                androidx.room.b bVar = dVar2.f;
                if (bVar != null) {
                    bVar.W0(dVar2.h, dVar2.c);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
            }
            d dVar3 = d.this;
            dVar3.a.unbindService(dVar3.j);
        }
    }

    public class f extends c.c {
        public f(String[] strArr) {
            super(strArr);
        }

        public boolean a() {
            return true;
        }

        public void b(Set set) {
            if (d.this.i.get()) {
                return;
            }
            try {
                d dVar = d.this;
                androidx.room.b bVar = dVar.f;
                if (bVar != null) {
                    bVar.V(dVar.c, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot broadcast invalidation", e);
            }
        }
    }

    public d(Context context, String str, androidx.room.c cVar, Executor executor) {
        b bVar = new b();
        this.j = bVar;
        this.k = new c();
        this.l = new d();
        this.m = new e();
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = str;
        this.d = cVar;
        this.g = executor;
        this.e = new f((String[]) cVar.a.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), bVar, 1);
    }
}
