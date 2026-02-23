package o8;

import k8.j;
import k8.q;
import w8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class f {
    public static final void a(l lVar, d completion) {
        kotlin.jvm.internal.l.e(lVar, "<this>");
        kotlin.jvm.internal.l.e(completion, "completion");
        d c = p8.b.c(p8.b.a(lVar, completion));
        j.a aVar = j.c;
        c.resumeWith(j.b(q.a));
    }

    public static final void b(p pVar, Object obj, d completion) {
        kotlin.jvm.internal.l.e(pVar, "<this>");
        kotlin.jvm.internal.l.e(completion, "completion");
        d c = p8.b.c(p8.b.b(pVar, obj, completion));
        j.a aVar = j.c;
        c.resumeWith(j.b(q.a));
    }
}
