package j$.util.concurrent;

import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class i extends b implements Set, j$.util.Set {
    private static final long serialVersionUID = 7249069246763182397L;

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    public final boolean equals(Object obj) {
        Set set;
        return (obj instanceof Set) && ((set = (Set) obj) == this || (containsAll(set) && set.containsAll(this)));
    }

    public final void forEach(Consumer consumer) {
        consumer.getClass();
        l[] lVarArr = this.a.a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l a = pVar.a();
            if (a == null) {
                return;
            } else {
                consumer.accept(a.b);
            }
        }
    }

    public final int hashCode() {
        a it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((h) it).next().hashCode();
        }
        return i;
    }

    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.a;
        l[] lVarArr = concurrentHashMap.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, length, concurrentHashMap, 0);
    }

    public final /* synthetic */ Stream parallelStream() {
        return Collection.-CC.$default$parallelStream(this);
    }

    public final /* synthetic */ java.util.stream.Stream parallelStream() {
        return Stream.Wrapper.convert(Collection.-CC.$default$parallelStream(this));
    }

    public final boolean remove(Object obj) {
        return this.a.remove(obj) != null;
    }

    public final /* synthetic */ boolean removeIf(Predicate predicate) {
        return Collection.-CC.$default$removeIf(this, predicate);
    }

    public final Spliterator spliterator() {
        ConcurrentHashMap concurrentHashMap = this.a;
        long j = concurrentHashMap.j();
        l[] lVarArr = concurrentHashMap.a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new j(lVarArr, length, 0, length, j < 0 ? 0L : j, 0);
    }

    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    public final /* synthetic */ Stream stream() {
        return Collection.-CC.$default$stream(this);
    }

    public final /* synthetic */ java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(Collection.-CC.$default$stream(this));
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return Collection.-CC.$default$toArray(this, intFunction);
    }
}
