package J1;

import J1.e;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class i {
    public final e a;

    public class a implements d {
        public a() {
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map a(i iVar) {
            return iVar.u();
        }
    }

    public class b implements c {
        public final /* synthetic */ i a;

        public b(i iVar) {
            this.a = iVar;
        }

        public Object a(i iVar) {
            return i.a(this.a) ? i.b(i.this, iVar) : i.c(this.a) ? i.d(i.this, iVar) : iVar.p(true);
        }
    }

    public interface c {
        Object a(i iVar);
    }

    public interface d {
        Object a(i iVar);
    }

    public i(e eVar) {
        this.a = eVar;
    }

    public static /* synthetic */ boolean a(i iVar) {
        return iVar.h();
    }

    public static /* synthetic */ List b(i iVar, i iVar2) {
        return iVar.r(iVar2);
    }

    public static /* synthetic */ boolean c(i iVar) {
        return iVar.k();
    }

    public static /* synthetic */ Map d(i iVar, i iVar2) {
        return iVar.s(iVar2);
    }

    public final void e(boolean z) {
        if (!z && this.a.k() == e.a.NULL) {
            throw new NullPointerException("corrupted response reader, expected non null value");
        }
    }

    public boolean f() {
        return this.a.g();
    }

    public final boolean g() {
        return this.a.k() == e.a.BOOLEAN;
    }

    public final boolean h() {
        return this.a.k() == e.a.BEGIN_ARRAY;
    }

    public final boolean i() {
        return this.a.k() == e.a.NULL;
    }

    public final boolean j() {
        return this.a.k() == e.a.NUMBER;
    }

    public final boolean k() {
        return this.a.k() == e.a.BEGIN_OBJECT;
    }

    public Boolean l(boolean z) {
        e(z);
        if (this.a.k() != e.a.NULL) {
            return Boolean.valueOf(this.a.h());
        }
        this.a.l();
        return null;
    }

    public List m(boolean z, c cVar) {
        e(z);
        if (this.a.k() == e.a.NULL) {
            this.a.l();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        this.a.a();
        while (this.a.g()) {
            arrayList.add(cVar.a(this));
        }
        this.a.d();
        return arrayList;
    }

    public String n() {
        return this.a.i();
    }

    public Object o(boolean z, d dVar) {
        e(z);
        if (this.a.k() == e.a.NULL) {
            this.a.l();
            return null;
        }
        this.a.c();
        Object a2 = dVar.a(this);
        this.a.e();
        return a2;
    }

    public Object p(boolean z) {
        e(z);
        if (!i()) {
            return g() ? l(false) : j() ? new BigDecimal(q(false)) : q(false);
        }
        t();
        return null;
    }

    public String q(boolean z) {
        e(z);
        if (this.a.k() != e.a.NULL) {
            return this.a.j();
        }
        this.a.l();
        return null;
    }

    public final List r(i iVar) {
        return iVar.m(false, new b(iVar));
    }

    public final Map s(i iVar) {
        return (Map) iVar.o(false, new a());
    }

    public void t() {
        this.a.l();
    }

    public Map u() {
        Object s;
        if (k()) {
            return s(this);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (f()) {
            String n = n();
            if (i()) {
                t();
                s = null;
            } else {
                s = k() ? s(this) : h() ? r(this) : p(true);
            }
            linkedHashMap.put(n, s);
        }
        return linkedHashMap;
    }
}
