package z1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class f {
    public x1.d a = x1.d.a();

    public final f a(f fVar) {
        x1.g.c(fVar, "cache == null");
        f fVar2 = this;
        while (fVar2.a.f()) {
            fVar2 = (f) fVar2.a.e();
        }
        fVar2.a = x1.d.h(fVar);
        return this;
    }

    public abstract void b();

    public abstract i c(String str, y1.a aVar);

    public Collection d(Collection collection, y1.a aVar) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            i c = c((String) it.next(), aVar);
            if (c != null) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }

    public Set e(Collection collection, y1.a aVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(f((i) it.next(), aVar));
        }
        return linkedHashSet;
    }

    public abstract Set f(i iVar, y1.a aVar);

    public final x1.d g() {
        return this.a;
    }

    public abstract boolean h(b bVar);
}
