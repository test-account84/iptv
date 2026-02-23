package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d.D;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class f extends Handler {
    public final WeakReference a;

    public f(a aVar) {
        super(Looper.getMainLooper());
        this.a = new WeakReference(aVar);
    }

    public void handleMessage(Message message) {
        a aVar = (a) this.a.get();
        if (aVar == null) {
            return;
        }
        if (message.what == -1) {
            aVar.invalidateSelf();
            return;
        }
        Iterator it = aVar.i.iterator();
        if (it.hasNext()) {
            D.a(it.next());
            throw null;
        }
    }
}
