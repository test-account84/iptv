package b0;

import b0.d;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.m;
import l8.s;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a extends d {
    public final Map a;
    public final AtomicBoolean b;

    public static final class a extends m implements l {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Map.Entry entry) {
            kotlin.jvm.internal.l.e(entry, "entry");
            return "  " + ((d.a) entry.getKey()).a() + " = " + entry.getValue();
        }
    }

    public a(Map map, boolean z) {
        kotlin.jvm.internal.l.e(map, "preferencesMap");
        this.a = map;
        this.b = new AtomicBoolean(z);
    }

    public Map a() {
        Map unmodifiableMap = Collections.unmodifiableMap(this.a);
        kotlin.jvm.internal.l.d(unmodifiableMap, "unmodifiableMap(preferencesMap)");
        return unmodifiableMap;
    }

    public Object b(d.a aVar) {
        kotlin.jvm.internal.l.e(aVar, "key");
        return this.a.get(aVar);
    }

    public final void e() {
        if (!(!this.b.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return kotlin.jvm.internal.l.a(this.a, ((a) obj).a);
        }
        return false;
    }

    public final void f() {
        this.b.set(true);
    }

    public final void g(d.b... bVarArr) {
        kotlin.jvm.internal.l.e(bVarArr, "pairs");
        e();
        if (bVarArr.length <= 0) {
            return;
        }
        d.b bVar = bVarArr[0];
        throw null;
    }

    public final Object h(d.a aVar) {
        kotlin.jvm.internal.l.e(aVar, "key");
        e();
        return this.a.remove(aVar);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final void i(d.a aVar, Object obj) {
        kotlin.jvm.internal.l.e(aVar, "key");
        j(aVar, obj);
    }

    public final void j(d.a aVar, Object obj) {
        Map map;
        kotlin.jvm.internal.l.e(aVar, "key");
        e();
        if (obj == null) {
            h(aVar);
            return;
        }
        if (obj instanceof Set) {
            map = this.a;
            obj = Collections.unmodifiableSet(s.O((Iterable) obj));
            kotlin.jvm.internal.l.d(obj, "unmodifiableSet(value.toSet())");
        } else {
            map = this.a;
        }
        map.put(aVar, obj);
    }

    public String toString() {
        return s.A(this.a.entrySet(), ",\n", "{\n", "\n}", 0, (CharSequence) null, a.a, 24, (Object) null);
    }

    public /* synthetic */ a(Map map, boolean z, int i, kotlin.jvm.internal.g gVar) {
        this((i & 1) != 0 ? new LinkedHashMap() : map, (i & 2) != 0 ? true : z);
    }
}
