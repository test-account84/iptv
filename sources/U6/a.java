package u6;

import android.util.Log;
import j$.util.DesugarCollections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.sync.b;
import q8.d;
import u6.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a {
    public static final a a = new a();
    public static final Map b = DesugarCollections.synchronizedMap(new LinkedHashMap());

    public static final class a {
        public final kotlinx.coroutines.sync.b a;
        public u6.b b;

        public a(kotlinx.coroutines.sync.b bVar, u6.b bVar2) {
            l.e(bVar, "mutex");
            this.a = bVar;
            this.b = bVar2;
        }

        public final kotlinx.coroutines.sync.b a() {
            return this.a;
        }

        public final u6.b b() {
            return this.b;
        }

        public final void c(u6.b bVar) {
            this.b = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return l.a(this.a, aVar.a) && l.a(this.b, aVar.b);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            u6.b bVar = this.b;
            return hashCode + (bVar == null ? 0 : bVar.hashCode());
        }

        public String toString() {
            return "Dependency(mutex=" + this.a + ", subscriber=" + this.b + ')';
        }

        public /* synthetic */ a(kotlinx.coroutines.sync.b bVar, u6.b bVar2, int i, g gVar) {
            this(bVar, (i & 2) != 0 ? null : bVar2);
        }
    }

    public static final class b extends d {
        public Object a;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public int j;

        public b(o8.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return a.this.c(this);
        }
    }

    public final void a(b.a aVar) {
        l.e(aVar, "subscriberName");
        Map map = b;
        if (!map.containsKey(aVar)) {
            l.d(map, "dependencies");
            map.put(aVar, new a(kotlinx.coroutines.sync.d.a(true), null, 2, null));
            return;
        }
        Log.d("SessionsDependencies", "Dependency " + aVar + " already added.");
    }

    public final a b(b.a aVar) {
        Map map = b;
        l.d(map, "dependencies");
        Object obj = map.get(aVar);
        if (obj != null) {
            l.d(obj, "dependencies.getOrElse(s…load time.\"\n      )\n    }");
            return (a) obj;
        }
        throw new IllegalStateException("Cannot get dependency " + aVar + ". Dependencies should be added at class load time.");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00a1 -> B:10:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(o8.d r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof u6.a.b
            if (r0 == 0) goto L13
            r0 = r11
            u6.a$b r0 = (u6.a.b) r0
            int r1 = r0.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.j = r1
            goto L18
        L13:
            u6.a$b r0 = new u6.a$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.h
            java.lang.Object r1 = p8.c.d()
            int r2 = r0.j
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r2 = r0.g
            java.lang.Object r5 = r0.f
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r0.e
            kotlinx.coroutines.sync.b r6 = (kotlinx.coroutines.sync.b) r6
            java.lang.Object r7 = r0.d
            u6.b$a r7 = (u6.b.a) r7
            java.lang.Object r8 = r0.c
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.a
            java.util.Map r9 = (java.util.Map) r9
            k8.k.b(r11)
            goto La2
        L40:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L48:
            k8.k.b(r11)
            java.util.Map r11 = u6.a.b
            java.lang.String r2 = "dependencies"
            kotlin.jvm.internal.l.d(r11, r2)
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            int r5 = r11.size()
            int r5 = l8.A.a(r5)
            r2.<init>(r5)
            java.util.Set r11 = r11.entrySet()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            r8 = r11
            r5 = r2
        L6b:
            boolean r11 = r8.hasNext()
            if (r11 == 0) goto Lb5
            java.lang.Object r11 = r8.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r2 = r11.getKey()
            java.lang.Object r6 = r11.getKey()
            r7 = r6
            u6.b$a r7 = (u6.b.a) r7
            java.lang.Object r11 = r11.getValue()
            u6.a$a r11 = (u6.a.a) r11
            kotlinx.coroutines.sync.b r6 = r11.a()
            r0.a = r5
            r0.c = r8
            r0.d = r7
            r0.e = r6
            r0.f = r5
            r0.g = r2
            r0.j = r3
            java.lang.Object r11 = r6.a(r4, r0)
            if (r11 != r1) goto La1
            return r1
        La1:
            r9 = r5
        La2:
            u6.a r11 = u6.a.a     // Catch: java.lang.Throwable -> Lb0
            u6.b r11 = r11.d(r7)     // Catch: java.lang.Throwable -> Lb0
            r6.c(r4)
            r5.put(r2, r11)
            r5 = r9
            goto L6b
        Lb0:
            r11 = move-exception
            r6.c(r4)
            throw r11
        Lb5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.c(o8.d):java.lang.Object");
    }

    public final u6.b d(b.a aVar) {
        l.e(aVar, "subscriberName");
        u6.b b2 = b(aVar).b();
        if (b2 != null) {
            return b2;
        }
        throw new IllegalStateException("Subscriber " + aVar + " has not been registered.");
    }

    public final void e(u6.b bVar) {
        l.e(bVar, "subscriber");
        b.a c = bVar.c();
        a b2 = b(c);
        if (b2.b() == null) {
            b2.c(bVar);
            b.a.a(b2.a(), (Object) null, 1, (Object) null);
            return;
        }
        Log.d("SessionsDependencies", "Subscriber " + c + " already registered.");
    }
}
