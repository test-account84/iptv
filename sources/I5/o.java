package I5;

import android.util.Log;
import com.google.ads.interactivemedia.v3.internal.z1;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class o implements e, b6.a {
    public static final j6.b i = new k();
    public final Map a;
    public final Map b;
    public final Map c;
    public final List d;
    public Set e;
    public final v f;
    public final AtomicReference g;
    public final j h;

    public o(Executor executor, Iterable iterable, Collection collection, j jVar) {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.e = new HashSet();
        this.g = new AtomicReference();
        v vVar = new v(executor);
        this.f = vVar;
        this.h = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.s(vVar, v.class, g6.d.class, g6.c.class));
        arrayList.add(c.s(this, b6.a.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.d = q(iterable);
        n(arrayList);
    }

    public static /* synthetic */ Object j(o oVar, c cVar) {
        return oVar.r(cVar);
    }

    public static /* synthetic */ void k(D d, j6.b bVar) {
        s(d, bVar);
    }

    public static /* synthetic */ void l(y yVar, j6.b bVar) {
        t(yVar, bVar);
    }

    public static b m(Executor executor) {
        return new b(executor);
    }

    public static List q(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static /* synthetic */ void s(D d, j6.b bVar) {
        d.j(bVar);
    }

    public static /* synthetic */ void t(y yVar, j6.b bVar) {
        yVar.a(bVar);
    }

    public /* synthetic */ Object a(Class cls) {
        return d.b(this, cls);
    }

    public /* synthetic */ Object b(F f) {
        return d.a(this, f);
    }

    public /* synthetic */ Set c(Class cls) {
        return d.f(this, cls);
    }

    public /* synthetic */ Set d(F f) {
        return d.e(this, f);
    }

    public synchronized j6.b e(F f) {
        E.c(f, "Null interface requested.");
        return (j6.b) this.b.get(f);
    }

    public synchronized j6.b f(F f) {
        y yVar = (y) this.c.get(f);
        if (yVar != null) {
            return yVar;
        }
        return i;
    }

    public /* synthetic */ j6.b g(Class cls) {
        return d.d(this, cls);
    }

    public j6.a h(F f) {
        j6.b e = e(f);
        return e == null ? D.e() : e instanceof D ? (D) e : D.i(e);
    }

    public /* synthetic */ j6.a i(Class cls) {
        return d.c(this, cls);
    }

    public final void n(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((j6.b) it.next()).get();
                    if (componentRegistrar != null) {
                        list.addAll(this.h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (w e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Object[] array = ((c) it2.next()).j().toArray();
                int length = array.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Object obj = array[i2];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.e.add(obj.toString());
                        }
                        i2++;
                    }
                }
            }
            if (this.a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                c cVar = (c) it3.next();
                this.a.put(cVar, new x(new l(this, cVar)));
            }
            arrayList.addAll(w(list));
            arrayList.addAll(x());
            v();
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            ((Runnable) it4.next()).run();
        }
        u();
    }

    public final void o(Map map, boolean z) {
        for (Map.Entry entry : map.entrySet()) {
            c cVar = (c) entry.getKey();
            j6.b bVar = (j6.b) entry.getValue();
            if (cVar.n() || (cVar.o() && z)) {
                bVar.get();
            }
        }
        this.f.d();
    }

    public void p(boolean z) {
        HashMap hashMap;
        if (z1.a(this.g, null, Boolean.valueOf(z))) {
            synchronized (this) {
                hashMap = new HashMap(this.a);
            }
            o(hashMap, z);
        }
    }

    public final /* synthetic */ Object r(c cVar) {
        return cVar.h().a(new G(cVar, this));
    }

    public final void u() {
        Boolean bool = (Boolean) this.g.get();
        if (bool != null) {
            o(this.a, bool.booleanValue());
        }
    }

    public final void v() {
        Map map;
        F c;
        Object e;
        for (c cVar : this.a.keySet()) {
            for (r rVar : cVar.g()) {
                if (rVar.g() && !this.c.containsKey(rVar.c())) {
                    map = this.c;
                    c = rVar.c();
                    e = y.b(Collections.emptySet());
                } else if (this.b.containsKey(rVar.c())) {
                    continue;
                } else {
                    if (rVar.f()) {
                        throw new z(String.format("Unsatisfied dependency for component %s: %s", new Object[]{cVar, rVar.c()}));
                    }
                    if (!rVar.g()) {
                        map = this.b;
                        c = rVar.c();
                        e = D.e();
                    }
                }
                map.put(c, e);
            }
        }
    }

    public final List w(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.p()) {
                j6.b bVar = (j6.b) this.a.get(cVar);
                for (F f : cVar.j()) {
                    if (this.b.containsKey(f)) {
                        arrayList.add(new m((D) ((j6.b) this.b.get(f)), bVar));
                    } else {
                        this.b.put(f, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final List x() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.a.entrySet()) {
            c cVar = (c) entry.getKey();
            if (!cVar.p()) {
                j6.b bVar = (j6.b) entry.getValue();
                for (F f : cVar.j()) {
                    if (!hashMap.containsKey(f)) {
                        hashMap.put(f, new HashSet());
                    }
                    ((Set) hashMap.get(f)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (this.c.containsKey(entry2.getKey())) {
                y yVar = (y) this.c.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new n(yVar, (j6.b) it.next()));
                }
            } else {
                this.c.put((F) entry2.getKey(), y.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    public /* synthetic */ o(Executor executor, Iterable iterable, Collection collection, j jVar, a aVar) {
        this(executor, iterable, collection, jVar);
    }

    public static final class b {
        public final Executor a;
        public final List b = new ArrayList();
        public final List c = new ArrayList();
        public j d = j.a;

        public b(Executor executor) {
            this.a = executor;
        }

        public static /* synthetic */ ComponentRegistrar a(ComponentRegistrar componentRegistrar) {
            return f(componentRegistrar);
        }

        public b b(c cVar) {
            this.c.add(cVar);
            return this;
        }

        public b c(ComponentRegistrar componentRegistrar) {
            this.b.add(new p(componentRegistrar));
            return this;
        }

        public b d(Collection collection) {
            this.b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.a, this.b, this.c, this.d, null);
        }

        public b g(j jVar) {
            this.d = jVar;
            return this;
        }

        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }
    }
}
