package z3;

import android.os.Handler;
import android.os.Message;
import z3.n;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class o implements Handler.Callback {
    public final /* synthetic */ n.g a;

    public /* synthetic */ o(n.g gVar) {
        this.a = gVar;
    }

    public final boolean handleMessage(Message message) {
        return n.g.a(this.a, message);
    }
}
