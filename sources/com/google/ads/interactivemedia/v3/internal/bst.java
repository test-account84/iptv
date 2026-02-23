package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class bst extends AbstractMap {
    private final int a;
    private boolean d;
    private volatile bss e;
    private List b = Collections.emptyList();
    private Map c = Collections.emptyMap();
    private Map f = Collections.emptyMap();

    public /* synthetic */ bst(int i) {
        this.a = i;
    }

    public static bst c(int i) {
        return new bsl(i);
    }

    public static /* bridge */ /* synthetic */ List f(bst bstVar) {
        return bstVar.b;
    }

    public static /* bridge */ /* synthetic */ Map h(bst bstVar) {
        return bstVar.c;
    }

    public static /* bridge */ /* synthetic */ void i(bst bstVar) {
        bstVar.o();
    }

    public static /* bridge */ /* synthetic */ void k(bst bstVar, int i) {
        bstVar.m(i);
    }

    private final int l(Comparable comparable) {
        int size = this.b.size();
        int i = size - 1;
        int i2 = 0;
        if (i >= 0) {
            int compareTo = comparable.compareTo(((bsp) this.b.get(i)).a());
            if (compareTo > 0) {
                return -(size + 1);
            }
            if (compareTo == 0) {
                return i;
            }
        }
        while (i2 <= i) {
            int i3 = (i2 + i) / 2;
            int compareTo2 = comparable.compareTo(((bsp) this.b.get(i3)).a());
            if (compareTo2 < 0) {
                i = i3 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    private final Object m(int i) {
        o();
        Object value = ((bsp) this.b.remove(i)).getValue();
        if (!this.c.isEmpty()) {
            Iterator it = n().entrySet().iterator();
            List list = this.b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new bsp(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap n() {
        o();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            this.f = treeMap.descendingMap();
        }
        return this.c;
    }

    private final void o() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
        this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
        this.d = true;
    }

    public final int b() {
        return this.b.size();
    }

    public final void clear() {
        o();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return l(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public final Iterable d() {
        return this.c.isEmpty() ? bso.a() : this.c.entrySet();
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        o();
        int l = l(comparable);
        if (l >= 0) {
            return ((bsp) this.b.get(l)).setValue(obj);
        }
        o();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.a);
        }
        int i = -(l + 1);
        if (i >= this.a) {
            return n().put(comparable, obj);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            bsp bspVar = (bsp) this.b.remove(i2 - 1);
            n().put(bspVar.a(), bspVar.getValue());
        }
        this.b.add(i, new bsp(this, comparable, obj));
        return null;
    }

    public final Set entrySet() {
        if (this.e == null) {
            this.e = new bss(this);
        }
        return this.e;
    }

    public final boolean equals(Object obj) {
        Map entrySet;
        Map entrySet2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bst)) {
            return super.equals(obj);
        }
        bst bstVar = (bst) obj;
        int size = size();
        if (size != bstVar.size()) {
            return false;
        }
        int b = b();
        if (b == bstVar.b()) {
            for (int i = 0; i < b; i++) {
                if (!g(i).equals(bstVar.g(i))) {
                    return false;
                }
            }
            if (b == size) {
                return true;
            }
            entrySet = this.c;
            entrySet2 = bstVar.c;
        } else {
            entrySet = entrySet();
            entrySet2 = bstVar.entrySet();
        }
        return entrySet.equals(entrySet2);
    }

    public final Map.Entry g(int i) {
        return (Map.Entry) this.b.get(i);
    }

    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int l = l(comparable);
        return l >= 0 ? ((bsp) this.b.get(l)).getValue() : this.c.get(comparable);
    }

    public final int hashCode() {
        int b = b();
        int i = 0;
        for (int i2 = 0; i2 < b; i2++) {
            i += ((bsp) this.b.get(i2)).hashCode();
        }
        return this.c.size() > 0 ? i + this.c.hashCode() : i;
    }

    public final boolean j() {
        return this.d;
    }

    public final Object remove(Object obj) {
        o();
        Comparable comparable = (Comparable) obj;
        int l = l(comparable);
        if (l >= 0) {
            return m(l);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    public final int size() {
        return this.b.size() + this.c.size();
    }
}
