package D8;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class i extends h {

    public static final class a implements d {
        public final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        public Iterator iterator() {
            return this.a;
        }
    }

    public static d c(Iterator it) {
        kotlin.jvm.internal.l.e(it, "<this>");
        return d(new a(it));
    }

    public static final d d(d dVar) {
        kotlin.jvm.internal.l.e(dVar, "<this>");
        return dVar instanceof D8.a ? dVar : new D8.a(dVar);
    }
}
