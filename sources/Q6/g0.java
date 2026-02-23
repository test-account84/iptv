package q6;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import q6.l0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class g0 implements OnCompleteListener {
    public /* synthetic */ l0.a a;

    public /* synthetic */ g0(l0.a aVar) {
        this.a = aVar;
    }

    public final void onComplete(Task task) {
        i0.a(this.a, task);
    }
}
