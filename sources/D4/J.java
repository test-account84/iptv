package d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j implements Iterable {
    public final Object a = new Object();
    public final Map c = new HashMap();
    public Set d = Collections.emptySet();
    public List e = Collections.emptyList();

    public void a(Object obj) {
        synchronized (this.a) {
            try {
                ArrayList arrayList = new ArrayList(this.e);
                arrayList.add(obj);
                this.e = Collections.unmodifiableList(arrayList);
                Integer num = (Integer) this.c.get(obj);
                if (num == null) {
                    HashSet hashSet = new HashSet(this.d);
                    hashSet.add(obj);
                    this.d = Collections.unmodifiableSet(hashSet);
                }
                this.c.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int b(Object obj) {
        int intValue;
        synchronized (this.a) {
            try {
                intValue = this.c.containsKey(obj) ? ((Integer) this.c.get(obj)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return intValue;
    }

    public void c(Object obj) {
        synchronized (this.a) {
            try {
                Integer num = (Integer) this.c.get(obj);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.e);
                arrayList.remove(obj);
                this.e = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.c.remove(obj);
                    HashSet hashSet = new HashSet(this.d);
                    hashSet.remove(obj);
                    this.d = Collections.unmodifiableSet(hashSet);
                } else {
                    this.c.put(obj, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Iterator iterator() {
        Iterator it;
        synchronized (this.a) {
            it = this.e.iterator();
        }
        return it;
    }

    public Set v() {
        Set set;
        synchronized (this.a) {
            set = this.d;
        }
        return set;
    }
}
