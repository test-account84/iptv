package U5;

import O5.r;
import com.google.android.gms.tasks.TaskCompletionSource;
import z2.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class c implements h {
    public final /* synthetic */ e a;
    public final /* synthetic */ TaskCompletionSource b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ r d;

    public /* synthetic */ c(e eVar, TaskCompletionSource taskCompletionSource, boolean z, r rVar) {
        this.a = eVar;
        this.b = taskCompletionSource;
        this.c = z;
        this.d = rVar;
    }

    public final void a(Exception exc) {
        e.a(this.a, this.b, this.c, this.d, exc);
    }
}
