package I5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class q {

    public static class b {
        public final I5.c a;
        public final Set b = new HashSet();
        public final Set c = new HashSet();

        public b(I5.c cVar) {
            this.a = cVar;
        }

        public void a(b bVar) {
            this.b.add(bVar);
        }

        public void b(b bVar) {
            this.c.add(bVar);
        }

        public I5.c c() {
            return this.a;
        }

        public Set d() {
            return this.b;
        }

        public boolean e() {
            return this.b.isEmpty();
        }

        public boolean f() {
            return this.c.isEmpty();
        }

        public void g(b bVar) {
            this.c.remove(bVar);
        }
    }

    public static class c {
        public final F a;
        public final boolean b;

        public c(F f, boolean z) {
            this.a = f;
            this.b = z;
        }

        public static /* synthetic */ boolean a(c cVar) {
            return cVar.b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.a.equals(this.a) && cVar.b == this.b;
        }

        public int hashCode() {
            return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.b).hashCode();
        }

        public /* synthetic */ c(F f, boolean z, a aVar) {
            this(f, z);
        }
    }

    public static void a(List list) {
        Set<b> c2 = c(list);
        Set b2 = b(c2);
        int i = 0;
        while (!b2.isEmpty()) {
            b bVar = (b) b2.iterator().next();
            b2.remove(bVar);
            i++;
            for (b bVar2 : bVar.d()) {
                bVar2.g(bVar);
                if (bVar2.f()) {
                    b2.add(bVar2);
                }
            }
        }
        if (i == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar3 : c2) {
            if (!bVar3.f() && !bVar3.e()) {
                arrayList.add(bVar3.c());
            }
        }
        throw new s(arrayList);
    }

    public static Set b(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    public static Set c(List list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            I5.c cVar = (I5.c) it.next();
            b bVar = new b(cVar);
            for (F f : cVar.j()) {
                c cVar2 = new c(f, !cVar.p(), null);
                if (!hashMap.containsKey(cVar2)) {
                    hashMap.put(cVar2, new HashSet());
                }
                Set set2 = (Set) hashMap.get(cVar2);
                if (!set2.isEmpty() && !c.a(cVar2)) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[]{f}));
                }
                set2.add(bVar);
            }
        }
        Iterator it2 = hashMap.values().iterator();
        while (it2.hasNext()) {
            for (b bVar2 : (Set) it2.next()) {
                for (r rVar : bVar2.c().g()) {
                    if (rVar.e() && (set = (Set) hashMap.get(new c(rVar.c(), rVar.g(), null))) != null) {
                        for (b bVar3 : set) {
                            bVar2.a(bVar3);
                            bVar3.b(bVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it3 = hashMap.values().iterator();
        while (it3.hasNext()) {
            hashSet.addAll((Set) it3.next());
        }
        return hashSet;
    }
}
