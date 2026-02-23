package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class Dictionary extends AbstractSet {
    protected final Table map = new Table();

    public static class Table extends HashMap {
    }

    public Entry get(String str) {
        return (Entry) this.map.get(str);
    }

    public Iterator iterator() {
        return this.map.values().iterator();
    }

    public Entry remove(String str) {
        return (Entry) this.map.remove(str);
    }

    public int size() {
        return this.map.size();
    }

    public boolean add(Entry entry) {
        return this.map.put(entry.getName(), entry) != null;
    }
}
