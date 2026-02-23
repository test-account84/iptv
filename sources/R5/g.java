package r5;

import j$.util.Objects;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g {
    public final String a;

    public class a extends g {
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, String str) {
            super(gVar, null);
            this.b = str;
        }

        public CharSequence h(Object obj) {
            return obj == null ? this.b : g.this.h(obj);
        }

        public g i(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public g(String str) {
        this.a = (String) m.k(str);
    }

    public static g f(char c) {
        return new g(String.valueOf(c));
    }

    public static g g(String str) {
        return new g(str);
    }

    public Appendable a(Appendable appendable, Iterator it) {
        m.k(appendable);
        if (it.hasNext()) {
            while (true) {
                appendable.append(h(it.next()));
                if (!it.hasNext()) {
                    break;
                }
                appendable.append(this.a);
            }
        }
        return appendable;
    }

    public final StringBuilder b(StringBuilder sb, Iterable iterable) {
        return c(sb, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb, Iterator it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String d(Iterable iterable) {
        return e(iterable.iterator());
    }

    public final String e(Iterator it) {
        return c(new StringBuilder(), it).toString();
    }

    public CharSequence h(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public g i(String str) {
        m.k(str);
        return new a(this, str);
    }

    public g(g gVar) {
        this.a = gVar.a;
    }

    public /* synthetic */ g(g gVar, a aVar) {
        this(gVar);
    }
}
