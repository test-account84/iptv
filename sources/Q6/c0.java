package q6;

import android.content.Context;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class c0 implements Callable {
    public /* synthetic */ Context a;
    public /* synthetic */ ScheduledExecutorService b;
    public /* synthetic */ FirebaseMessaging c;
    public /* synthetic */ I d;
    public /* synthetic */ D e;

    public /* synthetic */ c0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, I i, D d) {
        this.a = context;
        this.b = scheduledExecutorService;
        this.c = firebaseMessaging;
        this.d = i;
        this.e = d;
    }

    public final Object call() {
        return d0.i(this.a, this.b, this.c, this.d, this.e);
    }
}
