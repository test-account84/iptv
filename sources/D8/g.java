package D8;

import java.util.Iterator;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class g {

    public static final class a implements d {
        public final /* synthetic */ p a;

        public a(p pVar) {
            this.a = pVar;
        }

        public Iterator iterator() {
            return g.a(this.a);
        }
    }

    public static Iterator a(p block) {
        kotlin.jvm.internal.l.e(block, "block");
        e eVar = new e();
        eVar.e(p8.b.b(block, eVar, eVar));
        return eVar;
    }

    public static d b(p block) {
        kotlin.jvm.internal.l.e(block, "block");
        return new a(block);
    }
}
