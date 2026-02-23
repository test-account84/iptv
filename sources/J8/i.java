package J8;

import G8.B0;
import k8.q;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import o8.g;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class i extends q8.d implements kotlinx.coroutines.flow.c, q8.e {
    public final kotlinx.coroutines.flow.c a;
    public final o8.g c;
    public final int d;
    public o8.g e;
    public o8.d f;

    public static final class a extends m implements p {
        public static final a a = new a();

        public a() {
            super(2);
        }

        public final Integer a(int i, g.b bVar) {
            return Integer.valueOf(i + 1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (g.b) obj2);
        }
    }

    public i(kotlinx.coroutines.flow.c cVar, o8.g gVar) {
        super(g.a, o8.h.a);
        this.a = cVar;
        this.c = gVar;
        this.d = ((Number) gVar.l(0, a.a)).intValue();
    }

    public Object a(Object obj, o8.d dVar) {
        try {
            Object d = d(dVar, obj);
            if (d == p8.c.d()) {
                q8.h.c(dVar);
            }
            return d == p8.c.d() ? d : q.a;
        } catch (Throwable th) {
            this.e = new e(th, dVar.getContext());
            throw th;
        }
    }

    public final void c(o8.g gVar, o8.g gVar2, Object obj) {
        if (gVar2 instanceof e) {
            h((e) gVar2, obj);
        }
        k.a(this, gVar);
    }

    public final Object d(o8.d dVar, Object obj) {
        o8.g context = dVar.getContext();
        B0.i(context);
        o8.g gVar = this.e;
        if (gVar != context) {
            c(context, gVar, obj);
            this.e = context;
        }
        this.f = dVar;
        Object e = j.a().e(this.a, obj, this);
        if (!l.a(e, p8.c.d())) {
            this.f = null;
        }
        return e;
    }

    public q8.e getCallerFrame() {
        o8.d dVar = this.f;
        if (dVar instanceof q8.e) {
            return (q8.e) dVar;
        }
        return null;
    }

    public o8.g getContext() {
        o8.g gVar = this.e;
        return gVar == null ? o8.h.a : gVar;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h(e eVar, Object obj) {
        throw new IllegalStateException(E8.g.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + eVar.a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    public Object invokeSuspend(Object obj) {
        Throwable d = k8.j.d(obj);
        if (d != null) {
            this.e = new e(d, getContext());
        }
        o8.d dVar = this.f;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return p8.c.d();
    }

    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
