package I5;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class y implements j6.b {
    public volatile Set b = null;
    public volatile Set a = Collections.newSetFromMap(new ConcurrentHashMap());

    public y(Collection collection) {
        this.a.addAll(collection);
    }

    public static y b(Collection collection) {
        return new y((Set) collection);
    }

    public synchronized void a(j6.b bVar) {
        Set set;
        Object obj;
        try {
            if (this.b == null) {
                set = this.a;
                obj = bVar;
            } else {
                set = this.b;
                obj = bVar.get();
            }
            set.add(obj);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.b);
    }

    public final synchronized void d() {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                this.b.add(((j6.b) it.next()).get());
            }
            this.a = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
