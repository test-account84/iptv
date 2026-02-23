package k8;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class i implements Serializable {
    public final Object a;
    public final Object c;

    public i(Object obj, Object obj2) {
        this.a = obj;
        this.c = obj2;
    }

    public final Object a() {
        return this.a;
    }

    public final Object b() {
        return this.c;
    }

    public final Object c() {
        return this.a;
    }

    public final Object d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.l.a(this.a, iVar.a) && kotlin.jvm.internal.l.a(this.c, iVar.c);
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.c;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.a + ", " + this.c + ')';
    }
}
