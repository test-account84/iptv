package b0;

import k8.k;
import k8.q;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g {

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
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b0.a aVar = (b0.a) this.c;
                k.b(obj);
                return aVar;
            }
            k.b(obj);
            b0.a c = ((d) this.c).c();
            p pVar = this.d;
            this.c = c;
            this.a = 1;
            return pVar.invoke(c, this) == d ? d : c;
        }
    }

    public static final Object a(Y.f fVar, p pVar, o8.d dVar) {
        return fVar.a(new a(pVar, null), dVar);
    }
}
