package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class e implements C8.c, d {
    public static final a c = new a(null);
    public static final Map d;
    public static final HashMap e;
    public static final HashMap f;
    public static final HashMap g;
    public static final Map h;
    public final Class a;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
        
            if (r2 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String a(java.lang.Class r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.l.e(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Lb1
            Le:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L68
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r2 = r8.getEnclosingMethod()
                r3 = 2
                r4 = 36
                java.lang.String r5 = "name"
                if (r2 == 0) goto L42
                kotlin.jvm.internal.l.d(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = r2.getName()
                r6.append(r2)
                r6.append(r4)
                java.lang.String r2 = r6.toString()
                java.lang.String r2 = E8.o.A0(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L40
                goto L42
            L40:
                r1 = r2
                goto Lb1
            L42:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                kotlin.jvm.internal.l.d(r0, r5)
                if (r8 == 0) goto L63
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = r8.getName()
                r2.append(r8)
                r2.append(r4)
                java.lang.String r8 = r2.toString()
                java.lang.String r1 = E8.o.A0(r0, r8, r1, r3, r1)
                goto Lb1
            L63:
                java.lang.String r1 = E8.o.z0(r0, r4, r1, r3, r1)
                goto Lb1
            L68:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto L9c
                java.lang.Class r8 = r8.getComponentType()
                boolean r0 = r8.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L99
                java.util.Map r0 = kotlin.jvm.internal.e.c()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto L99
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r2)
                java.lang.String r1 = r0.toString()
            L99:
                if (r1 != 0) goto Lb1
                goto L40
            L9c:
                java.util.Map r0 = kotlin.jvm.internal.e.c()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto Lb1
                java.lang.String r1 = r8.getSimpleName()
            Lb1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.e.a.a(java.lang.Class):java.lang.String");
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        int i = 0;
        Iterable h2 = l8.k.h(w8.a.class, w8.l.class, w8.p.class, w8.q.class, w8.r.class, w8.s.class, w8.t.class, w8.u.class, w8.v.class, w8.w.class, w8.b.class, w8.c.class, w8.d.class, w8.e.class, w8.f.class, w8.g.class, w8.h.class, w8.i.class, w8.j.class, w8.k.class, w8.m.class, w8.n.class, w8.o.class);
        ArrayList arrayList = new ArrayList(l8.l.o(h2, 10));
        for (Object obj : h2) {
            int i2 = i + 1;
            if (i < 0) {
                l8.k.n();
            }
            arrayList.add(k8.m.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        d = l8.B.j(arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        e = hashMap;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Iterable<String> values = hashMap.values();
        l.d(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            l.d(kotlinName, "kotlinName");
            sb.append(E8.o.C0(kotlinName, '.', null, 2, null));
            sb.append("CompanionObject");
            k8.i a2 = k8.m.a(sb.toString(), kotlinName + ".Companion");
            hashMap3.put(a2.c(), a2.d());
        }
        for (Map.Entry entry : d.entrySet()) {
            hashMap3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        g = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(l8.A.a(hashMap3.size()));
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), E8.o.C0((String) entry2.getValue(), '.', null, 2, null));
        }
        h = linkedHashMap;
    }

    public e(Class jClass) {
        l.e(jClass, "jClass");
        this.a = jClass;
    }

    public static final /* synthetic */ Map c() {
        return h;
    }

    public Class a() {
        return this.a;
    }

    public String b() {
        return c.a(a());
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && l.a(v8.a.b(this), v8.a.b((C8.c) obj));
    }

    public int hashCode() {
        return v8.a.b(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
