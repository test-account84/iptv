package q1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b extends Handler {
    public final p1.b a;

    public b(p1.b bVar) {
        super(Looper.getMainLooper());
        this.a = bVar;
    }

    public void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
            return;
        }
        p1.b bVar = this.a;
        if (bVar != null) {
            r1.a aVar = (r1.a) message.obj;
            bVar.a(aVar.a, aVar.c);
        }
    }
}
