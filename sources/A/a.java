package a;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a {
    public final Set a = new CopyOnWriteArraySet();
    public volatile Context b;

    public void a(b bVar) {
        if (this.b != null) {
            bVar.a(this.b);
        }
        this.a.add(bVar);
    }

    public void b() {
        this.b = null;
    }

    public void c(Context context) {
        this.b = context;
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(context);
        }
    }

    public Context d() {
        return this.b;
    }

    public void e(b bVar) {
        this.a.remove(bVar);
    }
}
