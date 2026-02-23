package l8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class s extends r {

    public static final class a implements D8.d {
        public final /* synthetic */ Iterable a;

        public a(Iterable iterable) {
            this.a = iterable;
        }

        public Iterator iterator() {
            return this.a.iterator();
        }
    }

    public static /* synthetic */ String A(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, w8.l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            lVar = null;
        }
        return z(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, lVar);
    }

    public static Object B(List list) {
        kotlin.jvm.internal.l.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(k.g(list));
    }

    public static Comparable C(Iterable iterable) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List D(Collection collection, Iterable elements) {
        kotlin.jvm.internal.l.e(collection, "<this>");
        kotlin.jvm.internal.l.e(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            p.q(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List E(Collection collection, Object obj) {
        kotlin.jvm.internal.l.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object F(Iterable iterable) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        if (iterable instanceof List) {
            return G((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final Object G(List list) {
        kotlin.jvm.internal.l.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static List H(Iterable iterable, int i) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return k.f();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return L(iterable);
            }
            if (i == 1) {
                return j.b(u(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return k.k(arrayList);
    }

    public static byte[] I(Collection collection) {
        kotlin.jvm.internal.l.e(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = ((Number) it.next()).byteValue();
            i++;
        }
        return bArr;
    }

    public static final Collection J(Iterable iterable, Collection destination) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        kotlin.jvm.internal.l.e(destination, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static int[] K(Collection collection) {
        kotlin.jvm.internal.l.e(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List L(Iterable iterable) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return k.k(M(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return k.f();
        }
        if (size != 1) {
            return N(collection);
        }
        return j.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final List M(Iterable iterable) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        return iterable instanceof Collection ? N((Collection) iterable) : J(iterable, new ArrayList());
    }

    public static List N(Collection collection) {
        kotlin.jvm.internal.l.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set O(Iterable iterable) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return E.c(J(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return E.b();
        }
        if (size != 1) {
            return J(iterable, new LinkedHashSet(A.a(collection.size())));
        }
        return D.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static List P(Iterable iterable, int i, int i2, boolean z) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        F.a(i, i2);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator b = F.b(iterable.iterator(), i, i2, z, false);
            while (b.hasNext()) {
                arrayList.add((List) b.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i2) + (size % i2 == 0 ? 0 : 1));
        int i3 = 0;
        while (i3 >= 0 && i3 < size) {
            int e = B8.h.e(i, size - i3);
            if (e < i && !z) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(e);
            for (int i4 = 0; i4 < e; i4++) {
                arrayList3.add(list.get(i4 + i3));
            }
            arrayList2.add(arrayList3);
            i3 += i2;
        }
        return arrayList2;
    }

    public static List Q(Iterable iterable, Iterable other) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        kotlin.jvm.internal.l.e(other, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = other.iterator();
        ArrayList arrayList = new ArrayList(Math.min(l.o(iterable, 10), l.o(other, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(k8.m.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static D8.d s(Iterable iterable) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        return new a(iterable);
    }

    public static List t(List list, int i) {
        kotlin.jvm.internal.l.e(list, "<this>");
        if (i >= 0) {
            return H((Iterable) list, B8.h.c(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final Object u(Iterable iterable) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        if (iterable instanceof List) {
            return v((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object v(List list) {
        kotlin.jvm.internal.l.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object w(List list) {
        kotlin.jvm.internal.l.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final Appendable x(Iterable iterable, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, w8.l lVar) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        kotlin.jvm.internal.l.e(buffer, "buffer");
        kotlin.jvm.internal.l.e(separator, "separator");
        kotlin.jvm.internal.l.e(prefix, "prefix");
        kotlin.jvm.internal.l.e(postfix, "postfix");
        kotlin.jvm.internal.l.e(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                buffer.append(separator);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            E8.f.a(buffer, obj, lVar);
        }
        if (i >= 0 && i2 > i) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ Appendable y(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, w8.l lVar, int i2, Object obj) {
        return x(iterable, appendable, (i2 & 2) != 0 ? ", " : charSequence, (i2 & 4) != 0 ? "" : charSequence2, (i2 & 8) == 0 ? charSequence3 : "", (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : lVar);
    }

    public static final String z(Iterable iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, w8.l lVar) {
        kotlin.jvm.internal.l.e(iterable, "<this>");
        kotlin.jvm.internal.l.e(separator, "separator");
        kotlin.jvm.internal.l.e(prefix, "prefix");
        kotlin.jvm.internal.l.e(postfix, "postfix");
        kotlin.jvm.internal.l.e(truncated, "truncated");
        String sb = x(iterable, new StringBuilder(), separator, prefix, postfix, i, truncated, lVar).toString();
        kotlin.jvm.internal.l.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }
}
