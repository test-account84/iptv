package org.apache.commons.logging.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class WeakHashtable extends Hashtable {
    private static final int MAX_CHANGES_BEFORE_PURGE = 100;
    private static final int PARTIAL_PURGE_COUNT = 10;
    private static final long serialVersionUID = -1546036869799732453L;
    private final ReferenceQueue queue = new ReferenceQueue();
    private int changeCount = 0;

    class 1 implements Enumeration {
        private final /* synthetic */ Enumeration val$enumer;

        public 1(Enumeration enumeration) {
            this.val$enumer = enumeration;
        }

        public boolean hasMoreElements() {
            return this.val$enumer.hasMoreElements();
        }

        public Object nextElement() {
            return Referenced.access$100((Referenced) this.val$enumer.nextElement());
        }
    }

    public static final class Entry implements Map.Entry {
        private final Object key;
        private final Object value;

        private Entry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!getKey().equals(entry.getKey())) {
                return false;
            }
            if (getValue() == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!getValue().equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public Object getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("Entry.setValue is not supported.");
        }

        public /* synthetic */ Entry(Object obj, Object obj2, 1 r3) {
            this(obj, obj2);
        }
    }

    public static final class Referenced {
        private final int hashCode;
        private final WeakReference reference;

        private Referenced(Object obj) {
            this.reference = new WeakReference(obj);
            this.hashCode = obj.hashCode();
        }

        public static /* synthetic */ Object access$100(Referenced referenced) {
            return referenced.getValue();
        }

        private Object getValue() {
            return this.reference.get();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Referenced)) {
                return false;
            }
            Referenced referenced = (Referenced) obj;
            Object value = getValue();
            Object value2 = referenced.getValue();
            return value == null ? value2 == null && hashCode() == referenced.hashCode() : value.equals(value2);
        }

        public int hashCode() {
            return this.hashCode;
        }

        private Referenced(Object obj, ReferenceQueue referenceQueue) {
            this.reference = new WeakKey(obj, referenceQueue, this, null);
            this.hashCode = obj.hashCode();
        }

        public /* synthetic */ Referenced(Object obj, ReferenceQueue referenceQueue, 1 r3) {
            this(obj, referenceQueue);
        }

        public /* synthetic */ Referenced(Object obj, 1 r2) {
            this(obj);
        }
    }

    public static final class WeakKey extends WeakReference {
        private final Referenced referenced;

        private WeakKey(Object obj, ReferenceQueue referenceQueue, Referenced referenced) {
            super(obj, referenceQueue);
            this.referenced = referenced;
        }

        public static /* synthetic */ Referenced access$400(WeakKey weakKey) {
            return weakKey.getReferenced();
        }

        private Referenced getReferenced() {
            return this.referenced;
        }

        public /* synthetic */ WeakKey(Object obj, ReferenceQueue referenceQueue, Referenced referenced, 1 r4) {
            this(obj, referenceQueue, referenced);
        }
    }

    private void purge() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.queue) {
            while (true) {
                try {
                    WeakKey poll = this.queue.poll();
                    if (poll == null) {
                        break;
                    } else {
                        arrayList.add(WeakKey.access$400(poll));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            super.remove(arrayList.get(i));
        }
    }

    private void purgeOne() {
        synchronized (this.queue) {
            try {
                WeakKey poll = this.queue.poll();
                if (poll != null) {
                    super.remove(WeakKey.access$400(poll));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean containsKey(Object obj) {
        return super.containsKey(new Referenced(obj, (1) null));
    }

    public Enumeration elements() {
        purge();
        return super.elements();
    }

    public Set entrySet() {
        purge();
        Set<Map.Entry> entrySet = super.entrySet();
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : entrySet) {
            Object access$100 = Referenced.access$100((Referenced) entry.getKey());
            Object value = entry.getValue();
            if (access$100 != null) {
                hashSet.add(new Entry(access$100, value, null));
            }
        }
        return hashSet;
    }

    public Object get(Object obj) {
        return super.get(new Referenced(obj, (1) null));
    }

    public boolean isEmpty() {
        purge();
        return super.isEmpty();
    }

    public Set keySet() {
        purge();
        Set keySet = super.keySet();
        HashSet hashSet = new HashSet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            Object access$100 = Referenced.access$100((Referenced) it.next());
            if (access$100 != null) {
                hashSet.add(access$100);
            }
        }
        return hashSet;
    }

    public Enumeration keys() {
        purge();
        return new 1(super.keys());
    }

    public synchronized Object put(Object obj, Object obj2) {
        try {
            if (obj == null) {
                throw new NullPointerException("Null keys are not allowed");
            }
            if (obj2 == null) {
                throw new NullPointerException("Null values are not allowed");
            }
            int i = this.changeCount;
            int i2 = i + 1;
            this.changeCount = i2;
            if (i > 100) {
                purge();
                this.changeCount = 0;
            } else if (i2 % 10 == 0) {
                purgeOne();
            }
        } catch (Throwable th) {
            throw th;
        }
        return super.put(new Referenced(obj, this.queue, null), obj2);
    }

    public void putAll(Map map) {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void rehash() {
        purge();
        super.rehash();
    }

    public synchronized Object remove(Object obj) {
        try {
            int i = this.changeCount;
            int i2 = i + 1;
            this.changeCount = i2;
            if (i > 100) {
                purge();
                this.changeCount = 0;
            } else if (i2 % 10 == 0) {
                purgeOne();
            }
        } catch (Throwable th) {
            throw th;
        }
        return super.remove(new Referenced(obj, (1) null));
    }

    public int size() {
        purge();
        return super.size();
    }

    public String toString() {
        purge();
        return super.toString();
    }

    public Collection values() {
        purge();
        return super.values();
    }
}
