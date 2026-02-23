package b0;

import k8.k;
import k8.q;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class b implements Y.f {
    public final Y.f a;

    public static final class a extends l implements p {
        public int a;
        public /* synthetic */ Object c;
        public final /* synthetic */ p d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p pVar, o8.d dVar) {
            super(2, dVar);
            this.d = pVar;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(d dVar, o8.d dVar2) {
            return create(dVar, dVar2).invokeSuspend(q.a);
        }

        public final o8.d create(Object obj, o8.d dVar) {
            a aVar = new a(this.d, dVar);
            aVar.c = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object d = p8.c.d();
            int i = this.a;
            if (i == 0) {
                k.b(obj);
                d dVar = (d) this.c;
                p pVar = this.d;
                this.a = 1;
                obj = pVar.invoke(dVar, this);
                if (obj == d) {
                    return d;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                k.b(obj);
            }
            d dVar2 = (d) obj;
            ((b0.a) dVar2).f();
            return dVar2;
        }
    }

    public b(Y.f fVar) {
        kotlin.jvm.internal.l.e(fVar, "delegate");
        this.a = fVar;
    }

    public Object a(p pVar, o8.d dVar) {
        return this.a.a(new a(pVar, null), dVar);
    }

    public kotlinx.coroutines.flow.b getData() {
        return this.a.getData();
    }
}
