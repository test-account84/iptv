package org.simpleframework.xml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class WeakCache implements Cache {
    private SegmentList list;

    public class Segment extends WeakHashMap {
        private Segment() {
        }

        public synchronized void cache(Object obj, Object obj2) {
            put(obj, obj2);
        }

        public synchronized boolean contains(Object obj) {
            return containsKey(obj);
        }

        public synchronized Object fetch(Object obj) {
            return get(obj);
        }

        public synchronized Object take(Object obj) {
            return remove(obj);
        }

        public /* synthetic */ Segment(WeakCache weakCache, 1 r2) {
            this();
        }
    }

    public class SegmentList implements Iterable {
        private List list = new ArrayList();
        private int size;

        public SegmentList(int i) {
            this.size = i;
            create(i);
        }

        private void create(int i) {
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    return;
                }
                this.list.add(new Segment(WeakCache.this, null));
                i = i2;
            }
        }

        private int segment(Object obj) {
            return Math.abs(obj.hashCode() % this.size);
        }

        public Segment get(Object obj) {
            int segment = segment(obj);
            if (segment < this.size) {
                return (Segment) this.list.get(segment);
            }
            return null;
        }

        public Iterator iterator() {
            return this.list.iterator();
        }
    }

    public WeakCache() {
        this(10);
    }

    private Segment map(Object obj) {
        return this.list.get(obj);
    }

    public void cache(Object obj, Object obj2) {
        map(obj).cache(obj, obj2);
    }

    public boolean contains(Object obj) {
        return map(obj).contains(obj);
    }

    public Object fetch(Object obj) {
        return map(obj).fetch(obj);
    }

    public boolean isEmpty() {
        Iterator it = this.list.iterator();
        while (it.hasNext()) {
            if (!((Segment) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Object take(Object obj) {
        return map(obj).take(obj);
    }

    public WeakCache(int i) {
        this.list = new SegmentList(i);
    }
}
