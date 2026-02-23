package U1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class m {
    public boolean a;
    public final Handler b = new Handler(Looper.getMainLooper(), new b(null));

    public static class b implements Handler.Callback {
        public b() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((l) message.obj).b();
            return true;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public void a(l lVar) {
        q2.h.a();
        if (this.a) {
            this.b.obtainMessage(1, lVar).sendToTarget();
            return;
        }
        this.a = true;
        lVar.b();
        this.a = false;
    }
}
