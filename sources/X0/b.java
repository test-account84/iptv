package x0;

import androidx.navigation.l;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b {
    public final Set a;

    public static final class b {
        public final Set a;

        public b(l lVar) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            hashSet.add(Integer.valueOf(x0.c.a(lVar).i()));
        }

        public b a() {
            return new b(this.a, null, null, null);
        }
    }

    public interface c {
    }

    public b(Set set, W.c cVar, c cVar2) {
        this.a = set;
    }

    public c a() {
        return null;
    }

    public W.c b() {
        return null;
    }

    public Set c() {
        return this.a;
    }

    public /* synthetic */ b(Set set, W.c cVar, c cVar2, a aVar) {
        this(set, cVar, cVar2);
    }
}
