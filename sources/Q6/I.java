package q6;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class i implements Continuation {
    public /* synthetic */ Context a;
    public /* synthetic */ Intent b;

    public /* synthetic */ i(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    public final Object then(Task task) {
        return n.f(this.a, this.b, task);
    }
}
