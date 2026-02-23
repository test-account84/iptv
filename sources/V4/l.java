package v4;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ q a;

    public /* synthetic */ l(q qVar) {
        this.a = qVar;
    }

    public final void run() {
        t tVar;
        q qVar = this.a;
        while (true) {
            synchronized (qVar) {
                try {
                    if (qVar.a != 2) {
                        return;
                    }
                    if (qVar.e.isEmpty()) {
                        qVar.f();
                        return;
                    } else {
                        tVar = (t) qVar.e.poll();
                        qVar.f.put(tVar.a, tVar);
                        w.e(qVar.g).schedule(new o(qVar, tVar), 30L, TimeUnit.SECONDS);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String valueOf = String.valueOf(tVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 8);
                sb.append("Sending ");
                sb.append(valueOf);
                Log.d("MessengerIpcClient", sb.toString());
            }
            Context a = w.a(qVar.g);
            Messenger messenger = qVar.c;
            Message obtain = Message.obtain();
            obtain.what = tVar.c;
            obtain.arg1 = tVar.a;
            obtain.replyTo = messenger;
            Bundle bundle = new Bundle();
            bundle.putBoolean("oneWay", tVar.b());
            bundle.putString("pkg", a.getPackageName());
            bundle.putBundle("data", tVar.d);
            obtain.setData(bundle);
            try {
                qVar.d.a(obtain);
            } catch (RemoteException e) {
                qVar.a(2, e.getMessage());
            }
        }
    }
}
