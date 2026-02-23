package d4;

import d4.A;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet a;
    public final /* synthetic */ int c;
    public final /* synthetic */ A.a d;

    public /* synthetic */ z(CopyOnWriteArraySet copyOnWriteArraySet, int i, A.a aVar) {
        this.a = copyOnWriteArraySet;
        this.c = i;
        this.d = aVar;
    }

    public final void run() {
        A.a(this.a, this.c, this.d);
    }
}
