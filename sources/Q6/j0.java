package q6;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;
import q6.l0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class j0 implements OnCompleteListener {
    public /* synthetic */ ScheduledFuture a;

    public /* synthetic */ j0(ScheduledFuture scheduledFuture) {
        this.a = scheduledFuture;
    }

    public final void onComplete(Task task) {
        l0.a.e(this.a, task);
    }
}
