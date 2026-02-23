package kotlinx.coroutines.internal;

import G8.I0;
import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class q {
    public static final q a;
    public static final I0 b;

    static {
        q qVar = new q();
        a = qVar;
        z.e("kotlinx.coroutines.fast.service.loader", true);
        b = qVar.a();
    }

    public final I0 a() {
        Object next;
        I0 e;
        try {
            Iterable l = D8.k.l(D8.i.c(ServiceLoader.load(p.class, p.class.getClassLoader()).iterator()));
            Iterator it = l.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int c = ((p) next).c();
                    do {
                        Object next2 = it.next();
                        int c2 = ((p) next2).c();
                        if (c < c2) {
                            next = next2;
                            c = c2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            p pVar = (p) next;
            if (pVar != null && (e = r.e(pVar, l)) != null) {
                return e;
            }
            return r.b(null, null, 3, null);
        } catch (Throwable th) {
            return r.b(th, null, 2, null);
        }
    }
}
