package org.apache.http.impl.client;

import java.net.URI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class RedirectLocations extends AbstractList {
    private final Set unique = new HashSet();
    private final List all = new ArrayList();

    public void add(int i, Object obj) {
        URI uri = (URI) obj;
        this.all.add(i, uri);
        this.unique.add(uri);
    }

    public boolean contains(Object obj) {
        return this.unique.contains(obj);
    }

    public List getAll() {
        return new ArrayList(this.all);
    }

    public Object set(int i, Object obj) {
        URI uri = (URI) obj;
        URI uri2 = (URI) this.all.set(i, uri);
        this.unique.remove(uri2);
        this.unique.add(uri);
        if (this.all.size() != this.unique.size()) {
            this.unique.addAll(this.all);
        }
        return uri2;
    }

    public int size() {
        return this.all.size();
    }

    public void add(URI uri) {
        this.unique.add(uri);
        this.all.add(uri);
    }

    public boolean contains(URI uri) {
        return this.unique.contains(uri);
    }

    public URI get(int i) {
        return (URI) this.all.get(i);
    }

    public URI remove(int i) {
        URI uri = (URI) this.all.remove(i);
        this.unique.remove(uri);
        if (this.all.size() != this.unique.size()) {
            this.unique.addAll(this.all);
        }
        return uri;
    }

    public boolean remove(URI uri) {
        boolean remove = this.unique.remove(uri);
        if (remove) {
            Iterator it = this.all.iterator();
            while (it.hasNext()) {
                if (((URI) it.next()).equals(uri)) {
                    it.remove();
                }
            }
        }
        return remove;
    }
}
