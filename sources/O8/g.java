package o8;

import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import o8.e;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public interface g {

    public static final class a {

        public static final class a extends m implements p {
            public static final a a = new a();

            public a() {
                super(2);
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g invoke(g acc, b element) {
                o8.c cVar;
                l.e(acc, "acc");
                l.e(element, "element");
                g w = acc.w(element.getKey());
                h hVar = h.a;
                if (w == hVar) {
                    return element;
                }
                e.b bVar = e.d0;
                e eVar = (e) w.a(bVar);
                if (eVar == null) {
                    cVar = new o8.c(w, element);
                } else {
                    g w2 = w.w(bVar);
                    if (w2 == hVar) {
                        return new o8.c(element, eVar);
                    }
                    cVar = new o8.c(new o8.c(w2, element), eVar);
                }
                return cVar;
            }
        }

        public static g a(g gVar, g context) {
            l.e(context, "context");
            return context == h.a ? gVar : (g) context.l(gVar, a.a);
        }
    }

    public interface b extends g {

        public static final class a {
            public static Object a(b bVar, Object obj, p operation) {
                l.e(operation, "operation");
                return operation.invoke(obj, bVar);
            }

            public static b b(b bVar, c key) {
                l.e(key, "key");
                if (!l.a(bVar.getKey(), key)) {
                    return null;
                }
                l.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static g c(b bVar, c key) {
                l.e(key, "key");
                return l.a(bVar.getKey(), key) ? h.a : bVar;
            }

            public static g d(b bVar, g context) {
                l.e(context, "context");
                return a.a(bVar, context);
            }
        }

        b a(c cVar);

        c getKey();
    }

    public interface c {
    }

    g V(g gVar);

    b a(c cVar);

    Object l(Object obj, p pVar);

    g w(c cVar);
}
