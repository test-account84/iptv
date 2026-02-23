package M7;

import com.onesignal.F1;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class a {
    public final F1.v a;
    public final String b;

    public a(F1.v level, String entry) {
        l.e(level, "level");
        l.e(entry, "entry");
        this.a = level;
        this.b = entry;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && l.a(this.b, aVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "OneSignalLogEvent(level=" + this.a + ", entry=" + this.b + ')';
    }
}
