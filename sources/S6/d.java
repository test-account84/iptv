package s6;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class d {
    public static volatile d b;
    public final Set a = new HashSet();

    public static d a() {
        d dVar = b;
        if (dVar == null) {
            synchronized (d.class) {
                try {
                    dVar = b;
                    if (dVar == null) {
                        dVar = new d();
                        b = dVar;
                    }
                } finally {
                }
            }
        }
        return dVar;
    }

    public Set b() {
        Set unmodifiableSet;
        synchronized (this.a) {
            unmodifiableSet = Collections.unmodifiableSet(this.a);
        }
        return unmodifiableSet;
    }
}
