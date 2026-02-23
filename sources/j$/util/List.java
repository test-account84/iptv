package j$.util;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface List extends Collection {

    public final /* synthetic */ class -CC {
        public static void $default$replaceAll(java.util.List list, UnaryOperator unaryOperator) {
            Objects.requireNonNull(unaryOperator);
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                listIterator.set(unaryOperator.apply(listIterator.next()));
            }
        }

        public static void $default$sort(java.util.List list, java.util.Comparator comparator) {
            Object[] array = list.toArray();
            Arrays.sort(array, comparator);
            ListIterator listIterator = list.listIterator();
            for (Object obj : array) {
                listIterator.next();
                listIterator.set(obj);
            }
        }

        public static Spliterator a(java.util.List list) {
            return list instanceof RandomAccess ? new a(list) : Spliterators.spliterator(list, 16);
        }
    }

    public final /* synthetic */ class -EL {
        public static /* synthetic */ void sort(java.util.List list, java.util.Comparator comparator) {
            if (list instanceof List) {
                ((List) list).sort(comparator);
            } else {
                -CC.$default$sort(list, comparator);
            }
        }
    }

    void replaceAll(UnaryOperator unaryOperator);

    void sort(java.util.Comparator comparator);
}
