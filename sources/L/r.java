package L;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class r implements k {
    public final LocaleList a;

    public r(Object obj) {
        this.a = q.a(obj);
    }

    public String a() {
        return d.k.a(this.a);
    }

    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return d.g.a(this.a, ((k) obj).b());
    }

    public Locale get(int i) {
        return o.a(this.a, i);
    }

    public int hashCode() {
        return p.a(this.a);
    }

    public boolean isEmpty() {
        return m.a(this.a);
    }

    public int size() {
        return l.a(this.a);
    }

    public String toString() {
        return n.a(this.a);
    }
}
