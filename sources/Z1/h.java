package z1;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h extends z1.f {
    public final com.nytimes.android.external.cache.d b = com.nytimes.android.external.cache.e.q().a();

    public class a implements x1.c {
        public final /* synthetic */ String a;
        public final /* synthetic */ y1.a b;

        public a(String str, y1.a aVar) {
            this.a = str;
            this.b = aVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public x1.d apply(z1.f fVar) {
            return x1.d.d(fVar.c(this.a, this.b));
        }
    }

    public class b implements x1.c {
        public final /* synthetic */ f a;

        public b(f fVar) {
            this.a = fVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i apply(i iVar) {
            i c = iVar.c();
            c.h(this.a.a);
            return c;
        }
    }

    public class c implements x1.c {
        public final /* synthetic */ i a;
        public final /* synthetic */ y1.a b;

        public c(i iVar, y1.a aVar) {
            this.a = iVar;
            this.b = aVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set apply(z1.f fVar) {
            return fVar.f(this.a, this.b);
        }
    }

    public class d implements x1.b {
        public d() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void apply(z1.f fVar) {
            fVar.b();
        }
    }

    public class e implements x1.c {
        public final /* synthetic */ z1.b a;

        public e(z1.b bVar) {
            this.a = bVar;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(z1.f fVar) {
            return Boolean.valueOf(fVar.h(this.a));
        }
    }

    public final class f {
        public i a;
        public final LinkedList b;

        public f(i iVar) {
            LinkedList linkedList = new LinkedList();
            this.b = linkedList;
            this.a = iVar.c();
            linkedList.add(iVar.c());
        }

        public Set a(i iVar) {
            this.b.addLast(iVar.c());
            return this.a.h(iVar);
        }
    }

    public void b() {
        this.b.c();
        g().b(new d());
    }

    public i c(String str, y1.a aVar) {
        x1.g.c(str, "key == null");
        x1.g.c(aVar, "cacheHeaders == null");
        try {
            x1.d c2 = g().c(new a(str, aVar));
            f fVar = (f) this.b.b(str);
            return fVar != null ? (i) c2.g(new b(fVar)).i(fVar.a.c()) : (i) c2.k();
        } catch (Exception unused) {
            return null;
        }
    }

    public Set f(i iVar, y1.a aVar) {
        x1.g.c(iVar, "record == null");
        x1.g.c(aVar, "cacheHeaders == null");
        return (Set) g().g(new c(iVar, aVar)).i(Collections.emptySet());
    }

    public boolean h(z1.b bVar) {
        x1.g.c(bVar, "cacheKey == null");
        boolean booleanValue = ((Boolean) g().g(new e(bVar)).i(Boolean.FALSE)).booleanValue();
        if (this.b.b(bVar.b()) == null) {
            return booleanValue;
        }
        this.b.a(bVar.b());
        return true;
    }

    public Set i(i iVar) {
        x1.g.c(iVar, "record == null");
        f fVar = (f) this.b.b(iVar.g());
        if (fVar != null) {
            return fVar.a(iVar);
        }
        this.b.put(iVar.g(), new f(iVar));
        return Collections.singleton(iVar.g());
    }

    public Set j(Collection collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(i((i) it.next()));
        }
        return linkedHashSet;
    }
}
