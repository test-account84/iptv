package d4;

import android.os.Handler;
import android.os.Message;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class y implements Handler.Callback {
    public final /* synthetic */ A a;

    public /* synthetic */ y(A a) {
        this.a = a;
    }

    public final boolean handleMessage(Message message) {
        return A.b(this.a, message);
    }
}
