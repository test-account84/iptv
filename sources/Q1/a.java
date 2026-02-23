package q1;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class a {
    public static a c;
    public final Set a = Collections.newSetFromMap(new ConcurrentHashMap());
    public AtomicInteger b = new AtomicInteger();

    public static a c() {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        c = new a();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public k1.a a(k1.a aVar) {
        try {
            this.a.add(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            aVar.L(d());
            aVar.J(aVar.y() == k1.e.IMMEDIATE ? l1.b.b().a().b().submit(new d(aVar)) : l1.b.b().a().c().submit(new d(aVar)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }

    public void b(k1.a aVar) {
        try {
            this.a.remove(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int d() {
        return this.b.incrementAndGet();
    }
}
