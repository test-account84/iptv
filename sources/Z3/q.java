package z3;

import android.os.Handler;
import android.os.Message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class q implements Handler.Callback {
    public final /* synthetic */ s a;

    public /* synthetic */ q(s sVar) {
        this.a = sVar;
    }

    public final boolean handleMessage(Message message) {
        return s.a(this.a, message);
    }
}
