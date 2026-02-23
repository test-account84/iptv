package R0;

import Q0.n;
import Q0.s;
import Q0.v;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class g extends s {
    public static final String j = Q0.k.f("WorkContinuationImpl");
    public final j a;
    public final String b;
    public final Q0.d c;
    public final List d;
    public final List e;
    public final List f;
    public final List g;
    public boolean h;
    public n i;

    public g(j jVar, String str, Q0.d dVar, List list) {
        this(jVar, str, dVar, list, null);
    }

    public static boolean i(g gVar, Set set) {
        set.addAll(gVar.c());
        Set l = l(gVar);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (l.contains((String) it.next())) {
                return true;
            }
        }
        List e = gVar.e();
        if (e != null && !e.isEmpty()) {
            Iterator it2 = e.iterator();
            while (it2.hasNext()) {
                if (i((g) it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(gVar.c());
        return false;
    }

    public static Set l(g gVar) {
        HashSet hashSet = new HashSet();
        List e = gVar.e();
        if (e != null && !e.isEmpty()) {
            Iterator it = e.iterator();
            while (it.hasNext()) {
                hashSet.addAll(((g) it.next()).c());
            }
        }
        return hashSet;
    }

    public n a() {
        if (this.h) {
            Q0.k.c().h(j, String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", this.e)}), new Throwable[0]);
        } else {
            a1.b bVar = new a1.b(this);
            this.a.r().b(bVar);
            this.i = bVar.d();
        }
        return this.i;
    }

    public Q0.d b() {
        return this.c;
    }

    public List c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public List e() {
        return this.g;
    }

    public List f() {
        return this.d;
    }

    public j g() {
        return this.a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.h;
    }

    public void k() {
        this.h = true;
    }

    public g(j jVar, String str, Q0.d dVar, List list, List list2) {
        this.a = jVar;
        this.b = str;
        this.c = dVar;
        this.d = list;
        this.g = list2;
        this.e = new ArrayList(list.size());
        this.f = new ArrayList();
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                this.f.addAll(((g) it.next()).f);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String a = ((v) list.get(i)).a();
            this.e.add(a);
            this.f.add(a);
        }
    }

    public g(j jVar, List list) {
        this(jVar, null, Q0.d.KEEP, list, null);
    }
}
