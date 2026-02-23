package D5;

import C5.a;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class d {
    public final Set a;
    public final a.b b;
    public final L4.a c;
    public final c d;

    public d(L4.a aVar, a.b bVar) {
        this.b = bVar;
        this.c = aVar;
        c cVar = new c(this);
        this.d = cVar;
        aVar.b(cVar);
        this.a = new HashSet();
    }

    public static /* bridge */ /* synthetic */ a.b a(d dVar) {
        return dVar.b;
    }
}
