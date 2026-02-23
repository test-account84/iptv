package z4;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class b implements q {
    public final /* synthetic */ v a;

    public /* synthetic */ b(v vVar) {
        this.a = vVar;
    }

    public final void accept(Object obj, Object obj2) {
        a.g gVar = d.d;
        ((a) ((e) obj).getService()).A(this.a);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
