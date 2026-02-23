package O6;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c {
    public final List a;
    public final int b;
    public final boolean c;

    public c(List list, int i, boolean z) {
        this.a = new ArrayList(list);
        this.b = i;
        this.c = z;
    }

    public List a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean c(List list) {
        return this.a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a.equals(cVar.a) && this.c == cVar.c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }
}
