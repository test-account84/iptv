package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.O;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class a implements O {
    protected int memoizedHashCode = 0;

    public static abstract class a implements O.a {
        public static void c(Iterable iterable, List list) {
            y.a(iterable);
            if (!(iterable instanceof D)) {
                if (iterable instanceof Y) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    h(iterable, list);
                    return;
                }
            }
            List m = ((D) iterable).m();
            D d = (D) list;
            int size = list.size();
            for (Object obj : m) {
                if (obj == null) {
                    String str = "Element at index " + (d.size() - size) + " is null.";
                    for (int size2 = d.size() - 1; size2 >= size; size2--) {
                        d.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof g) {
                    d.x((g) obj);
                } else {
                    d.add((String) obj);
                }
            }
        }

        public static void h(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
        }

        public static k0 k(O o) {
            return new k0(o);
        }

        public abstract a i(a aVar);

        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public a a(O o) {
            if (f().getClass().isInstance(o)) {
                return i((a) o);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    public static void c(Iterable iterable, List list) {
        a.c(iterable, list);
    }

    public abstract int h();

    public int i(e0 e0Var) {
        int h = h();
        if (h != -1) {
            return h;
        }
        int e = e0Var.e(this);
        k(e);
        return e;
    }

    public k0 j() {
        return new k0(this);
    }

    public abstract void k(int i);

    public void l(OutputStream outputStream) {
        j Z = j.Z(outputStream, j.C(d()));
        g(Z);
        Z.W();
    }
}
