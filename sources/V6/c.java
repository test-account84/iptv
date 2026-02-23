package v6;

import F8.a;
import android.util.Log;
import k8.k;
import k8.q;
import org.json.JSONObject;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements h {
    public static final a g = new a(null);
    public final o8.g a;
    public final k6.h b;
    public final t6.b c;
    public final v6.a d;
    public final g e;
    public final kotlinx.coroutines.sync.b f;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b extends q8.d {
        public Object a;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public b(o8.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return c.this.d(this);
        }
    }

    public static final class c extends l implements p {
        public Object a;
        public Object c;
        public int d;
        public /* synthetic */ Object e;

        public c(o8.d dVar) {
            super(2, dVar);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(JSONObject jSONObject, o8.d dVar) {
            return create(jSONObject, dVar).invokeSuspend(q.a);
        }

        public final o8.d create(Object obj, o8.d dVar) {
            c cVar = c.this.new c(dVar);
            cVar.e = obj;
            return cVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0181 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0127  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00df  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 408
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: v6.c.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class d extends l implements p {
        public int a;
        public /* synthetic */ Object c;

        public d(o8.d dVar) {
            super(2, dVar);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, o8.d dVar) {
            return create(str, dVar).invokeSuspend(q.a);
        }

        public final o8.d create(Object obj, o8.d dVar) {
            d dVar2 = new d(dVar);
            dVar2.c = obj;
            return dVar2;
        }

        public final Object invokeSuspend(Object obj) {
            p8.c.d();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b(obj);
            Log.e("SessionConfigFetcher", "Error failing to fetch the remote configs: " + ((String) this.c));
            return q.a;
        }
    }

    public c(o8.g gVar, k6.h hVar, t6.b bVar, v6.a aVar, Y.f fVar) {
        kotlin.jvm.internal.l.e(gVar, "backgroundDispatcher");
        kotlin.jvm.internal.l.e(hVar, "firebaseInstallationsApi");
        kotlin.jvm.internal.l.e(bVar, "appInfo");
        kotlin.jvm.internal.l.e(aVar, "configsFetcher");
        kotlin.jvm.internal.l.e(fVar, "dataStore");
        this.a = gVar;
        this.b = hVar;
        this.c = bVar;
        this.d = aVar;
        this.e = new g(fVar);
        this.f = kotlinx.coroutines.sync.d.b(false, 1, (Object) null);
    }

    public static final /* synthetic */ g e(c cVar) {
        return cVar.e;
    }

    public Boolean a() {
        return this.e.g();
    }

    public F8.a b() {
        Integer e = this.e.e();
        if (e == null) {
            return null;
        }
        a.a aVar = F8.a.c;
        return F8.a.c(F8.c.o(e.intValue(), F8.d.SECONDS));
    }

    public Double c() {
        return this.e.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ae, B:29:0x00b2, B:32:0x00bf, B:37:0x0088, B:39:0x0090, B:42:0x0096), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[Catch: all -> 0x0051, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x004d, B:27:0x00ae, B:29:0x00b2, B:32:0x00bf, B:37:0x0088, B:39:0x0090, B:42:0x0096), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x001b  */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(o8.d r17) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.c.d(o8.d):java.lang.Object");
    }

    public final String f(String str) {
        return new E8.e("/").b(str, "");
    }
}
