package v4;

import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ q a;
    public final /* synthetic */ IBinder c;

    public /* synthetic */ n(q qVar, IBinder iBinder) {
        this.a = qVar;
        this.c = iBinder;
    }

    public final void run() {
        q qVar = this.a;
        IBinder iBinder = this.c;
        synchronized (qVar) {
            if (iBinder == null) {
                qVar.a(0, "Null service connection");
                return;
            }
            try {
                qVar.d = new r(iBinder);
                qVar.a = 2;
                qVar.c();
            } catch (RemoteException e) {
                qVar.a(0, e.getMessage());
            }
        }
    }
}
