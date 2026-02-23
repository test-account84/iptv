package androidx.lifecycle;

import G8.x0;
import androidx.lifecycle.j;
import java.util.concurrent.CancellationException;
import k8.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements n {
    public final /* synthetic */ j.b a;
    public final /* synthetic */ kotlin.jvm.internal.B c;
    public final /* synthetic */ G8.L d;
    public final /* synthetic */ j.b e;
    public final /* synthetic */ G8.n f;
    public final /* synthetic */ kotlinx.coroutines.sync.b g;
    public final /* synthetic */ w8.p h;

    public static final class a extends q8.l implements w8.p {
        public Object a;
        public Object c;
        public int d;
        public final /* synthetic */ kotlinx.coroutines.sync.b e;
        public final /* synthetic */ w8.p f;

        public static final class a extends q8.l implements w8.p {
            public int a;
            public /* synthetic */ Object c;
            public final /* synthetic */ w8.p d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(w8.p pVar, o8.d dVar) {
                super(2, dVar);
                this.d = pVar;
            }

            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(G8.L l, o8.d dVar) {
                return create(l, dVar).invokeSuspend(k8.q.a);
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
                    k8.k.b(obj);
                    G8.L l = (G8.L) this.c;
                    w8.p pVar = this.d;
                    this.a = 1;
                    if (pVar.invoke(l, this) == d) {
                        return d;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k8.k.b(obj);
                }
                return k8.q.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kotlinx.coroutines.sync.b bVar, w8.p pVar, o8.d dVar) {
            super(2, dVar);
            this.e = bVar;
            this.f = pVar;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(G8.L l, o8.d dVar) {
            return create(l, dVar).invokeSuspend(k8.q.a);
        }

        public final o8.d create(Object obj, o8.d dVar) {
            return new a(this.e, this.f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.sync.b bVar;
            w8.p pVar;
            kotlinx.coroutines.sync.b bVar2;
            Throwable th;
            Object d = p8.c.d();
            int i = this.d;
            try {
                if (i == 0) {
                    k8.k.b(obj);
                    bVar = this.e;
                    pVar = this.f;
                    this.a = bVar;
                    this.c = pVar;
                    this.d = 1;
                    if (bVar.a((Object) null, this) == d) {
                        return d;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        bVar2 = (kotlinx.coroutines.sync.b) this.a;
                        try {
                            k8.k.b(obj);
                            k8.q qVar = k8.q.a;
                            bVar2.c((Object) null);
                            return k8.q.a;
                        } catch (Throwable th2) {
                            th = th2;
                            bVar2.c((Object) null);
                            throw th;
                        }
                    }
                    pVar = (w8.p) this.c;
                    kotlinx.coroutines.sync.b bVar3 = (kotlinx.coroutines.sync.b) this.a;
                    k8.k.b(obj);
                    bVar = bVar3;
                }
                a aVar = new a(pVar, null);
                this.a = bVar;
                this.c = null;
                this.d = 2;
                if (G8.M.c(aVar, this) == d) {
                    return d;
                }
                bVar2 = bVar;
                k8.q qVar2 = k8.q.a;
                bVar2.c((Object) null);
                return k8.q.a;
            } catch (Throwable th3) {
                bVar2 = bVar;
                th = th3;
                bVar2.c((Object) null);
                throw th;
            }
        }
    }

    public final void b(p pVar, j.b bVar) {
        kotlin.jvm.internal.l.e(pVar, "<anonymous parameter 0>");
        kotlin.jvm.internal.l.e(bVar, "event");
        if (bVar == this.a) {
            this.c.a = G8.i.d(this.d, (o8.g) null, (G8.N) null, new a(this.g, this.h, null), 3, (Object) null);
            return;
        }
        if (bVar == this.e) {
            x0 x0Var = (x0) this.c.a;
            if (x0Var != null) {
                x0.a.a(x0Var, (CancellationException) null, 1, (Object) null);
            }
            this.c.a = null;
        }
        if (bVar == j.b.ON_DESTROY) {
            G8.n nVar = this.f;
            j.a aVar = k8.j.c;
            nVar.resumeWith(k8.j.b(k8.q.a));
        }
    }
}
