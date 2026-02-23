package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.y;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c extends AbstractList implements y.b {
    public boolean a = true;

    public boolean add(Object obj) {
        d();
        return super.add(obj);
    }

    public boolean addAll(int i, Collection collection) {
        d();
        return super.addAll(i, collection);
    }

    public void clear() {
        d();
        super.clear();
    }

    public void d() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public final void k() {
        this.a = false;
    }

    public boolean remove(Object obj) {
        d();
        return super.remove(obj);
    }

    public boolean removeAll(Collection collection) {
        d();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        d();
        return super.retainAll(collection);
    }

    public boolean t() {
        return this.a;
    }

    public boolean addAll(Collection collection) {
        d();
        return super.addAll(collection);
    }
}
