package androidx.navigation;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d {
    public final q a;
    public final boolean b;
    public final boolean c;
    public final Object d;

    public static final class a {
        public q a;
        public Object c;
        public boolean b = false;
        public boolean d = false;

        public d a() {
            if (this.a == null) {
                this.a = q.e(this.c);
            }
            return new d(this.a, this.b, this.c, this.d);
        }

        public a b(Object obj) {
            this.c = obj;
            this.d = true;
            return this;
        }

        public a c(boolean z) {
            this.b = z;
            return this;
        }

        public a d(q qVar) {
            this.a = qVar;
            return this;
        }
    }

    public d(q qVar, boolean z, Object obj, boolean z2) {
        if (!qVar.f() && z) {
            throw new IllegalArgumentException(qVar.c() + " does not allow nullable values");
        }
        if (!z && z2 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + qVar.c() + " has null value but is not nullable.");
        }
        this.a = qVar;
        this.b = z;
        this.d = obj;
        this.c = z2;
    }

    public q a() {
        return this.a;
    }

    public boolean b() {
        return this.c;
    }

    public void c(String str, Bundle bundle) {
        if (this.c) {
            this.a.i(bundle, str, this.d);
        }
    }

    public boolean d(String str, Bundle bundle) {
        if (!this.b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.a.b(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.b != dVar.b || this.c != dVar.c || !this.a.equals(dVar.a)) {
            return false;
        }
        Object obj2 = this.d;
        Object obj3 = dVar.d;
        return obj2 != null ? obj2.equals(obj3) : obj3 == null;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31;
        Object obj = this.d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }
}
