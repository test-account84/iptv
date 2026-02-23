package o4;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class i0 implements OnCompleteListener {
    public final /* synthetic */ k0 a;

    public /* synthetic */ i0(k0 k0Var) {
        this.a = k0Var;
    }

    public final void onComplete(Task task) {
        e.B(this.a.a, "joinApplication", task);
    }
}
