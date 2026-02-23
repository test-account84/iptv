package s4;

import android.os.Looper;
import com.google.android.gms.internal.cast.zzdy;
import java.util.TimerTask;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends TimerTask {
    public final /* synthetic */ p4.i a;
    public final /* synthetic */ a c;

    public l(a aVar, p4.i iVar) {
        this.c = aVar;
        this.a = iVar;
    }

    public final void run() {
        new zzdy(Looper.getMainLooper()).post(new k(this));
    }
}
