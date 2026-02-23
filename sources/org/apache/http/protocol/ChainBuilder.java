package org.apache.http.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
final class ChainBuilder {
    private final LinkedList list = new LinkedList();
    private final Map uniqueClasses = new HashMap();

    private void ensureUnique(Object obj) {
        Object remove = this.uniqueClasses.remove(obj.getClass());
        if (remove != null) {
            this.list.remove(remove);
        }
        this.uniqueClasses.put(obj.getClass(), obj);
    }

    public ChainBuilder addAllFirst(Collection collection) {
        if (collection == null) {
            return this;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addFirst(it.next());
        }
        return this;
    }

    public ChainBuilder addAllLast(Collection collection) {
        if (collection == null) {
            return this;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addLast(it.next());
        }
        return this;
    }

    public ChainBuilder addFirst(Object obj) {
        if (obj == null) {
            return this;
        }
        ensureUnique(obj);
        this.list.addFirst(obj);
        return this;
    }

    public ChainBuilder addLast(Object obj) {
        if (obj == null) {
            return this;
        }
        ensureUnique(obj);
        this.list.addLast(obj);
        return this;
    }

    public LinkedList build() {
        return new LinkedList(this.list);
    }

    public ChainBuilder addAllFirst(Object... objArr) {
        if (objArr == null) {
            return this;
        }
        for (Object obj : objArr) {
            addFirst(obj);
        }
        return this;
    }

    public ChainBuilder addAllLast(Object... objArr) {
        if (objArr == null) {
            return this;
        }
        for (Object obj : objArr) {
            addLast(obj);
        }
        return this;
    }
}
