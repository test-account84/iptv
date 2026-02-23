package D8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class k extends j {

    public static final class a implements Iterable, x8.a {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        public Iterator iterator() {
            return this.a.iterator();
        }
    }

    public static Iterable e(d dVar) {
        kotlin.jvm.internal.l.e(dVar, "<this>");
        return new a(dVar);
    }

    public static d f(d dVar, int i) {
        kotlin.jvm.internal.l.e(dVar, "<this>");
        if (i >= 0) {
            return i == 0 ? dVar : dVar instanceof c ? ((c) dVar).a(i) : new b(dVar, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final Appendable g(d dVar, Appendable buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, w8.l lVar) {
        kotlin.jvm.internal.l.e(dVar, "<this>");
        kotlin.jvm.internal.l.e(buffer, "buffer");
        kotlin.jvm.internal.l.e(separator, "separator");
        kotlin.jvm.internal.l.e(prefix, "prefix");
        kotlin.jvm.internal.l.e(postfix, "postfix");
        kotlin.jvm.internal.l.e(truncated, "truncated");
        buffer.append(prefix);
        int i2 = 0;
        for (Object obj : dVar) {
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

    public static final String h(d dVar, CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, w8.l lVar) {
        kotlin.jvm.internal.l.e(dVar, "<this>");
        kotlin.jvm.internal.l.e(separator, "separator");
        kotlin.jvm.internal.l.e(prefix, "prefix");
        kotlin.jvm.internal.l.e(postfix, "postfix");
        kotlin.jvm.internal.l.e(truncated, "truncated");
        String sb = g(dVar, new StringBuilder(), separator, prefix, postfix, i, truncated, lVar).toString();
        kotlin.jvm.internal.l.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String i(d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, w8.l lVar, int i2, Object obj) {
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
        return h(dVar, charSequence, charSequence5, charSequence6, i3, charSequence7, lVar);
    }

    public static d j(d dVar, w8.l transform) {
        kotlin.jvm.internal.l.e(dVar, "<this>");
        kotlin.jvm.internal.l.e(transform, "transform");
        return new l(dVar, transform);
    }

    public static final Collection k(d dVar, Collection destination) {
        kotlin.jvm.internal.l.e(dVar, "<this>");
        kotlin.jvm.internal.l.e(destination, "destination");
        Iterator it = dVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static List l(d dVar) {
        kotlin.jvm.internal.l.e(dVar, "<this>");
        return l8.k.k(m(dVar));
    }

    public static final List m(d dVar) {
        kotlin.jvm.internal.l.e(dVar, "<this>");
        return k(dVar, new ArrayList());
    }
}
