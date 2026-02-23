package W1;

import W1.a;
import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class d implements a.a {
    public final int a;
    public final a b;

    public interface a {
        File a();
    }

    public d(a aVar, int i) {
        this.a = i;
        this.b = aVar;
    }

    public W1.a build() {
        File a2 = this.b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.d(a2, this.a);
        }
        return null;
    }
}
