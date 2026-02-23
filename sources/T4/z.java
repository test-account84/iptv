package t4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class z extends J {
    public final List d;

    public z(String str, String str2, String str3) {
        super(str, "MediaControlChannel", null);
        this.d = Collections.synchronizedList(new ArrayList());
    }

    public final List f() {
        return this.d;
    }

    public final void g() {
        synchronized (this.d) {
            try {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((x) it.next()).c(2002);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(x xVar) {
        this.d.add(xVar);
    }
}
