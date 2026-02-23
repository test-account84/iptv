package l8;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class p extends o {
    public static boolean q(Collection collection, Iterable elements) {
        kotlin.jvm.internal.l.e(collection, "<this>");
        kotlin.jvm.internal.l.e(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean r(Collection collection, Object[] elements) {
        kotlin.jvm.internal.l.e(collection, "<this>");
        kotlin.jvm.internal.l.e(elements, "elements");
        return collection.addAll(g.b(elements));
    }
}
