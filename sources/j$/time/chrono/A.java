package j$.time.chrono;

import j$.time.LocalDateTime;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.ServiceLoader;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public abstract class a implements n {
    private static final ConcurrentHashMap a = new ConcurrentHashMap();
    private static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final /* synthetic */ int c = 0;

    static {
        new Locale("ja", "JP", "JP");
    }

    protected a() {
    }

    static n i(String str) {
        Objects.a(str, "id");
        while (true) {
            ConcurrentHashMap concurrentHashMap = a;
            n nVar = (n) concurrentHashMap.get(str);
            if (nVar == null) {
                nVar = (n) b.get(str);
            }
            if (nVar != null) {
                return nVar;
            }
            if (concurrentHashMap.get("ISO") != null) {
                Iterator it = ServiceLoader.load(n.class).iterator();
                while (it.hasNext()) {
                    n nVar2 = (n) it.next();
                    if (str.equals(nVar2.getId()) || str.equals(nVar2.p())) {
                        return nVar2;
                    }
                }
                throw new j$.time.c("Unknown chronology: ".concat(str));
            }
            q qVar = q.o;
            k(qVar, qVar.getId());
            x xVar = x.d;
            xVar.getClass();
            k(xVar, "Japanese");
            C c2 = C.d;
            c2.getClass();
            k(c2, "Minguo");
            I i = I.d;
            i.getClass();
            k(i, "ThaiBuddhist");
            Iterator it2 = ServiceLoader.load(a.class, (ClassLoader) null).iterator();
            while (it2.hasNext()) {
                a aVar = (a) it2.next();
                if (!aVar.getId().equals("ISO")) {
                    k(aVar, aVar.getId());
                }
            }
            u uVar = u.d;
            uVar.getClass();
            k(uVar, "ISO");
        }
    }

    static n k(n nVar, String str) {
        String p;
        n nVar2 = (n) a.putIfAbsent(str, nVar);
        if (nVar2 == null && (p = nVar.p()) != null) {
            b.putIfAbsent(p, nVar);
        }
        return nVar2;
    }

    public final int compareTo(Object obj) {
        return getId().compareTo(((n) obj).getId());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && getId().compareTo(((a) obj).getId()) == 0;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    public e m(LocalDateTime localDateTime) {
        try {
            return j(localDateTime).s(j$.time.k.E(localDateTime));
        } catch (j$.time.c e) {
            throw new j$.time.c("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e);
        }
    }

    public final String toString() {
        return getId();
    }
}
