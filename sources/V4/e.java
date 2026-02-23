package v4;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class e extends zzf {
    public final /* synthetic */ c a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, Looper looper) {
        super(looper);
        this.a = cVar;
    }

    public final void handleMessage(Message message) {
        c.d(this.a, message);
    }
}
