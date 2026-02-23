package v4;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class y implements Continuation {
    public final /* synthetic */ c a;
    public final /* synthetic */ Bundle b;

    public /* synthetic */ y(c cVar, Bundle bundle) {
        this.a = cVar;
        this.b = bundle;
    }

    public final Object then(Task task) {
        return this.a.c(this.b, task);
    }
}
