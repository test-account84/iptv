package l8;

import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a implements Collection, x8.a {

    public static final class a extends kotlin.jvm.internal.m implements w8.l {
        public a() {
            super(1);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Object obj) {
            return obj == a.this ? "(this Collection)" : String.valueOf(obj);
        }
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.l.a(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(@NotNull Collection elements) {
        kotlin.jvm.internal.l.e(elements, "elements");
        Collection collection = (Iterable) elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract int getSize();

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public Object[] toArray() {
        return kotlin.jvm.internal.f.a(this);
    }

    @NotNull
    public String toString() {
        return s.A(this, ", ", "[", "]", 0, null, new a(), 24, null);
    }

    @NotNull
    public Object[] toArray(@NotNull Object[] array) {
        kotlin.jvm.internal.l.e(array, "array");
        Object[] b = kotlin.jvm.internal.f.b(this, array);
        kotlin.jvm.internal.l.c(b, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.CollectionsKt__CollectionsJVMKt.copyToArrayImpl>");
        return b;
    }
}
