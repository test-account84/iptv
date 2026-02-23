package q6;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class e implements OnCompleteListener {
    public /* synthetic */ h a;
    public /* synthetic */ Intent b;

    public /* synthetic */ e(h hVar, Intent intent) {
        this.a = hVar;
        this.b = intent;
    }

    public final void onComplete(Task task) {
        this.a.f(this.b, task);
    }
}
