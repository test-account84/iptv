package v1;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class i {
    public final f a;
    public final Object b;
    public final List c;
    public Set d;
    public final boolean e;

    public static final class a {
        public final f a;
        public Object b;
        public List c;
        public Set d;
        public boolean e;

        public a(f fVar) {
            this.a = (f) x1.g.c(fVar, "operation == null");
        }

        public static /* synthetic */ f a(a aVar) {
            return aVar.a;
        }

        public static /* synthetic */ Object b(a aVar) {
            return aVar.b;
        }

        public static /* synthetic */ List c(a aVar) {
            return aVar.c;
        }

        public static /* synthetic */ Set d(a aVar) {
            return aVar.d;
        }

        public static /* synthetic */ boolean e(a aVar) {
            return aVar.e;
        }

        public i f() {
            return new i(this);
        }

        public a g(Object obj) {
            this.b = obj;
            return this;
        }

        public a h(Set set) {
            this.d = set;
            return this;
        }

        public a i(List list) {
            this.c = list;
            return this;
        }

        public a j(boolean z) {
            this.e = z;
            return this;
        }
    }

    public i(a aVar) {
        this.a = (f) x1.g.c(a.a(aVar), "operation == null");
        this.b = a.b(aVar);
        this.c = a.c(aVar) != null ? Collections.unmodifiableList(a.c(aVar)) : Collections.emptyList();
        this.d = a.d(aVar) != null ? Collections.unmodifiableSet(a.d(aVar)) : Collections.emptySet();
        this.e = a.e(aVar);
    }

    public static a a(f fVar) {
        return new a(fVar);
    }

    public Object b() {
        return this.b;
    }

    public Set c() {
        return this.d;
    }

    public List d() {
        return this.c;
    }

    public boolean e() {
        return !this.c.isEmpty();
    }

    public a f() {
        return new a(this.a).g(this.b).i(this.c).h(this.d).j(this.e);
    }
}
