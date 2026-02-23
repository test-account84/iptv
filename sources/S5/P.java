package s5;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class p extends Q implements Serializable {
    public final Comparator a;

    public p(Comparator comparator) {
        this.a = (Comparator) r5.m.k(comparator);
    }

    public int compare(Object obj, Object obj2) {
        return this.a.compare(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            return this.a.equals(((p) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
