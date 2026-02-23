package q1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends Handler {
    public final p1.f a;

    public g(p1.f fVar) {
        super(Looper.getMainLooper());
        this.a = fVar;
    }

    public void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
            return;
        }
        p1.f fVar = this.a;
        if (fVar != null) {
            r1.a aVar = (r1.a) message.obj;
            fVar.a(aVar.a, aVar.c);
        }
    }
}
