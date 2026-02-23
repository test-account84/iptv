package v4;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class j implements Handler.Callback {
    public final /* synthetic */ q a;

    public /* synthetic */ j(q qVar) {
        this.a = qVar;
    }

    public final boolean handleMessage(Message message) {
        q qVar = this.a;
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (qVar) {
            try {
                t tVar = (t) qVar.f.get(i);
                if (tVar == null) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("Received response for unknown request: ");
                    sb2.append(i);
                    Log.w("MessengerIpcClient", sb2.toString());
                    return true;
                }
                qVar.f.remove(i);
                qVar.f();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    tVar.c(new u(4, "Not supported by GmsCore", null));
                    return true;
                }
                tVar.a(data);
                return true;
            } finally {
            }
        }
    }
}
